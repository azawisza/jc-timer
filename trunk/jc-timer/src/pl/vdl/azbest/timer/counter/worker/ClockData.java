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

import org.apache.log4j.Logger;

public class ClockData {
	private String minutes = "";
	private String seconds = "";
	private String hours = "";
	private Logger logger = Logger.getLogger(getClass().getName());
	public ClockData(int h, int m, int s) {
		String seconds = "" + s;
		String minutes = "" + m;
		String hours = "" + h;
		if (s < 10)
			seconds = "0" + s;
		if (m < 10)
			minutes = "0" + m;
		if (h < 10)
			hours = "0" + h;
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);

	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public String getSeconds() {
		return seconds;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		return hours + ":" + minutes + ":" + seconds;
	}

	public static String formatClock(int s) {
		int hrs = s / 3600;
		int min = s / 60;
		min = min % 60;
		int sec = (s % 60);

		String seconds = "" + sec;
		String minutes = "" + min;
		String hours = "" + hrs;
		if (sec < 10)
			seconds = "0" + sec;
		if (min < 10)
			minutes = "0" + min;
		if (hrs < 10)
			hours = "0" + hrs;
		return hours + ":" + minutes + ":" + seconds;
	}



}
