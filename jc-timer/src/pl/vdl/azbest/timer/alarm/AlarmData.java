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
package pl.vdl.azbest.timer.alarm;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class AlarmData {
	private Logger logger = Logger.getLogger(getClass().getName());
	private String alarmText = "";
	private Calendar alarmTime = null;

	public String getAlarmText() {
		return alarmText;
	}

	public void setAlarmText(String alarmText) {
		this.alarmText = alarmText;
	}

	public Calendar getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Calendar alarmTime) {
		this.alarmTime = alarmTime;
	}

	@Override
	public String toString() {
		return "Text " + alarmText + " " + alarmTime.toString();
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2008);
		cal.set(Calendar.MONTH, Calendar.JULY);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		cal.set(Calendar.HOUR, 11);
		cal.set(Calendar.MINUTE, 8);
		cal.set(Calendar.SECOND, 60);
		Date d = new Date();

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d);


	}

}
