/*
 This file is part of JCTimer

    JCTimer is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JCTimer is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JCTimer.  If not, see <http://www.gnu.org/licenses/>.
	author: azbest.pro (azbest.pro@gmail.com)
*/
package pl.vdl.azbest.timer.cmd;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.Logger;

import pl.vdl.azbest.timer.cmd.Command;

public class Invoker implements Command {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(getClass().getName());

	private Queue<Command> commands = new LinkedList<Command>();

	private static Invoker instance;

	private Invoker() {
		init();
	}

	private void init() {
		class Executor extends Thread {
			private Logger logger = Logger.getLogger(getClass().getName());

			@Override
			public void run() {
				Thread.currentThread().setName("CommandInvokerThread");
				while (true) {
					synchronized (commands) {

						while (commands.isEmpty()) {
							try {
								logger.info("waiting for job ...");
								commands.wait();

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}// while comands emty
						logger.info("Executing command ...");
						commands.poll().execute();
						logger.info("Command executed.");
					}// synchronized
				}// endless loop
			}// run
		}// Executor

		// this.command.execute();
		Executor exe = new Executor();
		exe.start();
	}// init()

	public static Invoker getInstance() {
		if (instance == null) {
			instance = new Invoker();
			return instance;
		} else {
			return instance;
		}
	}

	public void addCommand(Command comm) {
		this.commands.add(comm);
		synchronized (commands) {
			this.commands.notify();
		}
	}

	public void execute() {
	}

}
