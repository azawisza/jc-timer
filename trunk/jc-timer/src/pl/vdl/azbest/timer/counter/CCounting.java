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
package pl.vdl.azbest.timer.counter;

import org.apache.log4j.Logger;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.cmd.Cmd_enSaveTestQuestData;
import pl.vdl.azbest.timer.cmd.Command;
import pl.vdl.azbest.timer.counter.worker.Clock;

public class CCounting implements CounterState {
	private Logger logger = Logger.getLogger(getClass().getName());
	private Counter counter = null;

	public CCounting(Counter c) {
		counter = c;
	}

	public CounterState start() {
		final String message = "Transition not supported";
		logger.warn(message);
		//throw new IllegalCounterStateException(message);
		return counter.state;
	}

	public CounterState stop() {
		logger.info("Pauses counting... Counting > Paused");
		if (Conf.getInstance().isDataCollectorOn()) {
			Command c = new Cmd_enSaveTestQuestData();
			c.execute();
		}
		Clock.getInstance().stop();
		counter.state = counter.cPaused;
		return counter.state;
	}

	public CounterState resume() {
		Clock.getInstance().start();
		final String message = "Transition not supported";
		logger.warn(message);
		//throw new IllegalCounterStateException(message);
		return counter.state;
	}

	public CounterState reset() {
		if (Conf.getInstance().isDataCollectorOn()) {
			Command c = new Cmd_enSaveTestQuestData();
			c.execute();
			return counter.state;
		}
		Clock.getInstance().stop();
		Clock.getInstance().clear();
		logger.info("Stops counting... Counting > Idle");
		counter.state = counter.cIdle;
		return counter.state;
	}

}
