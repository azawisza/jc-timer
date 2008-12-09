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

import pl.vdl.azbest.timer.counter.worker.Clock;

public class CIdle implements CounterState {
	private Logger logger = Logger.getLogger(getClass().getName());

	private Counter counter = null;

	public CIdle(Counter c) {
		counter = c;
	}

	public CounterState start() {
		logger.info("Start Counting... Idle > Counting");
		Clock.getInstance().start();
		counter.state = counter.cCounting;
		return counter.state;
	}

	public CounterState stop() {
		final String message = "Transition not supported";
		logger.warn(message);
		//throw new IllegalCounterStateException(message);
		return counter.state;
	}

	public CounterState resume() {
		final String message = "Transition not supported";
		logger.warn(message);
		//throw new IllegalCounterStateException(message);
		return counter.state;
	}

	public CounterState reset() {
		final String message = "Transition not supported";
		logger.warn(message);
		//throw new IllegalCounterStateException(message);
		return counter.state;
	}
}
