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

public class Counter implements CounterState {
	private Logger logger = Logger.getLogger(getClass().getName());

	CounterState cCounting = null;
	CounterState cIdle = null;
	CounterState cPaused = null;
	private static Counter instance = null;
	CounterState state = null;
	public void setState(CounterState state) {
		this.state = state;
	}

	public static Counter getInstance() {
		if (instance == null) {
			instance = new Counter();
			return instance;
		} else {
			return instance;
		}
	}

	public Counter() {
		cCounting = new CCounting(this);
		cIdle = new CIdle(this);
		cPaused = new CPaused(this);
		state = cIdle;
		logger.info("Counter initialized, in IDLE");
	}

	public CounterState start() {
		state.start();
		return state;
	}

	public CounterState stop() {
		state.stop();
		return state;
	}

	public CounterState resume() {
		state.resume();
		return state;
	}

	public CounterState reset() {
		state.reset();
		return state;

	}

}
