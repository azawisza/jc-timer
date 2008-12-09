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
package pl.vdl.azbest.timer.counter.worker;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import pl.vdl.azbest.timer.Conf;

public class ClockConcreteSubject implements ClockSubject {
	private static ClockConcreteSubject instance = null;
	private ClockData data = null;
	private ArrayList<ClockListener> clockListeners = new ArrayList<ClockListener>();
	private Logger logger = Logger.getLogger(getClass().getName());
	private ClockConcreteSubject() {
	}

	public static ClockConcreteSubject getInstance() {
		if (instance == null) {
			instance = new ClockConcreteSubject();
			return instance;
		} else {
			return instance;
		}
	}

	public void getState() {
		ClockData cData = new ClockData(Clock.getInstance().getHrs(), Clock
				.getInstance().getMin(), Clock.getInstance().getSec());
		data = cData;
		notifyClockListener();
	}

	public void addClockListener(ClockListener clockListener) {
	 if (clockListener instanceof Conf) {

		 Conf new_name = (Conf) clockListener;
		 logger.info("its ADDesd");

		}
		clockListeners.add(clockListener);

	}

	public void notifyClockListener() {
		logger.info(clockListeners.size());
		for (ClockListener x : clockListeners) {
			x.update(data);
		}

	}

	public void removeClockListener(ClockListener clockListener) {
		clockListeners.remove(clockListener);

	}

}
