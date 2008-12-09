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

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.alarm.AlarmClock;
import pl.vdl.azbest.timer.counter.worker.ClockConcreteSubject;
import pl.vdl.azbest.timer.counter.worker.ClockData;
import pl.vdl.azbest.timer.counter.worker.ClockListener;
import pl.vdl.azbest.timer.counter.worker.PointStatistics;
import pl.vdl.azbest.timer.counter.worker.TestQuestDataCollector;
import pl.vdl.azbest.timer.counter.worker.TimeStatistics;

public class Cmd_enAddTestQuestRow implements Command {
	private boolean pass;

	public Cmd_enAddTestQuestRow(boolean pass) {
		this.pass = pass;
	}

	public void execute() {
		/*
		 * This map represents inhalt of table row. Number of rows is same as
		 * number of elements in this map
		 */
		Map<String, String> tableRow = new HashMap<String, String>();

		tableRow.put("Number", TimeStatistics.getInstance().getStatQuestions());
		tableRow.put("Subject", Conf.getInstance().getTestSubject());

		tableRow.put("Elapsed", Conf.getInstance().getTimerTime());
		tableRow.put("Pass", "" + pass);

		NumberFormat nf = NumberFormat.getNumberInstance();

		RoundingMode rm = RoundingMode.HALF_UP;
		//nf.setRoundingMode(rm);
		nf.setMaximumFractionDigits(3);
		nf.setMinimumFractionDigits(3);

		tableRow.put("Factor", nf.format(Double.parseDouble(PointStatistics
				.getInstance().getFactor())));
		tableRow.put("Total time", TimeStatistics.getInstance()
				.getStatElapsedTime());
		tableRow.put("Mean time", TimeStatistics.getInstance()
				.getTimePerQuest());
		tableRow.put("Exam", Conf.getInstance().getTestExam());

		tableRow.put("Source", Conf.getInstance().getTestSource());

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		tableRow.put("Date", "" + cal.get(Calendar.HOUR_OF_DAY) + ":"
				+ cal.get(Calendar.MINUTE));

		/*
		 * class TimeGetter implements ClockListener{ public String time = null;
		 * public void update(ClockData cd) { time =
		 * ""+cd.getHours()+":"+cd.getMinutes()+":"+cd.getSeconds(); } }
		 * ClockListener tg = new TimeGetter();
		 * ClockConcreteSubject.getInstance().addClockListener(tg);
		 *
		 * while(((TimeGetter)tg).time== null){ //till its null }
		 */

		Conf.getInstance().setDataTableColumns(tableRow.keySet());

		TestQuestDataCollector.getInstance().addRow(tableRow);
	}
}
