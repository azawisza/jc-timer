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

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.lf5.StartLogFactor5;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.alarm.AlarmClock;
import pl.vdl.azbest.timer.counter.worker.Clock;
import pl.vdl.azbest.timer.counter.worker.ClockConcreteSubject;
import pl.vdl.azbest.timer.counter.worker.TimeStatistics;
import pl.vdl.azbest.timer.gui.GUIFacade;
import pl.vdl.azbest.timer.gui.SWTTimer;


public class Start {
	private static Logger logger = Logger.getLogger(Start.class);

	public static void main(String[] args) {



		initEngine();
		initGUI();

	}

	private static void initGUI() {
		logger.debug("Loading SWT GUI Facade");
		GUIFacade.getInstance();
		logger.debug("Opening main program window");
		SWTTimer t = new SWTTimer();
		t.openSWTWidgetStandAlone2();
		Conf.getInstance().setAllowBlank(true);

	}

	private static void initEngine() {
		logger.debug("Loading Invoker");
		Invoker.getInstance();
		logger.debug("Loading AlarmClock");
		AlarmClock.getInstance();
		logger.debug("Loading Clock");
		Clock.getInstance();
		logger.debug("Loading Clock subject");
		ClockConcreteSubject.getInstance();
		logger.debug("Loading Time statistics");
		TimeStatistics.getInstance();

		ClockConcreteSubject.getInstance().addClockListener(Conf.getInstance());
	}

}
