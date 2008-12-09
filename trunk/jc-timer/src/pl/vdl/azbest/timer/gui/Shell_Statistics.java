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
package pl.vdl.azbest.timer.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.gui.composite.Cmp_Satisitcs;

public class Shell_Statistics extends SWTElement {

	// private Shell sShell = null; //
	// @jve:decl-index=0:visual-constraint="79,67"
	private static Shell_Statistics instance = null; // @jve:decl-index=0:

	private Composite composite5 = null;

	private Shell_Statistics() {
	}

	public static Shell_Statistics getInstance() {
		if (instance == null) {
			instance = new Shell_Statistics();
			return instance;
		} else {
			return instance;
		}
	}

	/**
	 * This method initializes sShell
	 */
	@Override
	protected void createSShell() {
		sShell = new Shell(SWT.BORDER | SWT.SHELL_TRIM | SWT.ON_TOP);
		sShell.setText("Shell");
		sShell.setSize(new Point(247, 166));
		sShell.setLayout(new GridLayout());
		sShell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {
			@Override
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				Conf.getInstance().setShell_statvindowOpned(false);
				GUIFacade.getInstance().setShell_Statistics(null);
			}
		});
		init();
	}

	private void init() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite5 = new Cmp_Satisitcs(sShell, SWT.NONE);
		composite5.setLayout(new GridLayout());
		composite5.setLayoutData(gridData1);
		// Cmp_DiggIt

		// ad to gui facade

		GUIFacade.getInstance().setShell_Statistics(this);
		lockSWTWidgetSize();
		setSWTWidgetPositionCenetr(0, 0);

	}

	public void updateShellStatistics(String qNumber, String totalTime,
			String timePerQuest, String points, String factor) {
		Cmp_Satisitcs cmps = (Cmp_Satisitcs) composite5;
		cmps.updateValues(qNumber, totalTime, timePerQuest, points, factor);

	}

	public void minimalize() {
		sShell.setMinimized(true);
	}

	public void restore() {
		sShell.setMinimized(false);
	}

	public void setCounter(int i) {
		((Cmp_Satisitcs) composite5).setCounter(i);
	}

}
