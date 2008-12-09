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

import java.util.Timer;
import java.util.TimerTask;

public class Clock {
	private final int TIMECONST = 1000;

	private int min = 0;

	private int sec = 0;

	private int hrs = 0;

	private volatile boolean stop = false;

	private Timer timer = null;

	private static Clock instance = null;

	private Clock() {
	}

	public static Clock getInstance() {
		if (instance == null) {
			instance = new Clock();
			return instance;
		} else {
			return instance;
		}
	}

	private void claculate() {
		timer = new Timer();
		class MyTimerTask extends TimerTask {
			@Override
			public void run() {

				// timer.cancel();
				timer.schedule(new MyTimerTask(), TIMECONST);
				advance(TIMECONST / 1000);
				// if(stop)timer.cancel();

			}
		}
		timer.schedule(new MyTimerTask(), TIMECONST);

	}

	private void advance(int i) {
		sec += i;
		if (sec >= 60) {
			min += 1;
			sec = 0;
			if (min >= 60) {
				hrs += 1;
				min = 0;

			}

		}
		printTime();
		ClockConcreteSubject.getInstance().getState();
	}

	private void printTime() {
		// logger.info("TIME: " + hrs + " : " + min + " : " + sec);

	}

	public void start() {
		this.stop = false;

		claculate();
	}

	public void stop() {
		if (timer != null) {
			timer.cancel();
			timer = null;
			stop = true;
		}
	}

	// Test
	public static void main(String[] args) {
		Clock c = new Clock();
		c.start();
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void clear() {
		this.hrs = 0;
		this.sec = 0;
		this.min = 0;
		ClockConcreteSubject.getInstance().getState();
	}

	public ClockData getClockData() {
		return new ClockData(hrs, min, sec);
	}

}
