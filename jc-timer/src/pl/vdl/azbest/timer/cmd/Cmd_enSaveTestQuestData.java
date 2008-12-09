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

import java.text.DateFormat;
import java.util.Date;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.counter.worker.Clock;
import pl.vdl.azbest.timer.counter.worker.ClockData;
import pl.vdl.azbest.timer.counter.worker.TestQuestDataCollector;
import pl.vdl.azbest.timer.gui.GUIFacade;

public class Cmd_enSaveTestQuestData implements Command {

	public void execute() {
		/*String[] form = GUIFacade.getInstance().getTestQuestDatafromGUI();
		if (form == null)
			return;

		ClockData clock = Clock.getInstance().getClockData();

		int i = form.length;
		String output[] = new String[i + 2];

		// adding first column
		// [0]
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

		output[0] = df.format(d);

		// all stuff from form GUI
		// [1][2][3][4][5][6]
		for (int j = 1; j <= i; j++) {
			if (i >= j) {
				output[j] = form[j - 1];
				logger.info(form[j - 1]);
			}

		}

		// and time
		// [6]
		output[i + 1] = clock.toString();

		// adding
		//TODO investigate this
		//TestQuestDataCollector.getInstance().addRow(output);

		*/



	}

}
