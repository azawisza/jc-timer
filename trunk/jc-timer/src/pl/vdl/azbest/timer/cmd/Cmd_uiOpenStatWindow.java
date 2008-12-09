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

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.gui.Shell_Statistics;

public class Cmd_uiOpenStatWindow implements Command {

	public void execute() {

		Conf.getInstance().getDisplay().syncExec(new Runnable() {
			public void run() {
				Shell_Statistics.getInstance().openSWTWidgetSingleton(
						Conf.getInstance().isShell_statvindowOpned());
				Conf.getInstance().setShell_statvindowOpned(true);
			}
		});

	}

}
