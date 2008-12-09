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

public class TimeStatistics implements ClockListener {
	private int elapsedTime = 0; // seconds elapsed

	private int questions = 0;
	private static TimeStatistics instance = null;

	private TimeStatistics() {

		ClockConcreteSubject.getInstance().addClockListener(this);

	}

	public static TimeStatistics getInstance() {
		if (instance == null) {
			instance = new TimeStatistics();
			return instance;
		} else {
			return instance;
		}
	}

	public void update(ClockData data) {
		if (Integer.parseInt(data.getMinutes()) == 0
				&& Integer.parseInt(data.getSeconds()) == 0
				&& Integer.parseInt(data.getHours()) == 0) {
			// we have 00:00:00 - timer reset, and question change !
			questions++;
		} else {
			// second elapsed
			elapsedTime++;
		}
	}

	public String getStatQuestions() {
		return questions + "";
	}

	public String getStatElapsedTime() {
		return ClockData.formatClock(elapsedTime);
	}

	public String getTimePerQuest() {
		if (questions > 0) {
			return ClockData.formatClock(elapsedTime / questions);
		} else {
			return "-";
		}

	}

	public void reset() {
		elapsedTime = 0;
		questions = 0;
	}

}
