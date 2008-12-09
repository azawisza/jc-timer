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
import pl.vdl.azbest.timer.gui.composite.Cmp_TestQuestTable;

public class Shell_DataTable extends SWTElement {
	private static Shell_DataTable instance = null; // @jve:decl-index=0:

	private Shell_DataTable() {

	}

	public static Shell_DataTable getInstance() {
		if (instance == null) {
			instance = new Shell_DataTable();
			return instance;
		} else {
			return instance;
		}
	}

	// private Shell sShell = null; // @jve:decl-index=0:visual-constraint="0,0"
	private Composite composite5 = null;

	/**
	 * This method initializes sShell
	 */
	@Override
	protected void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setSize(new Point(533, 336));
		sShell.setLayout(new GridLayout());
		sShell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {
			@Override
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				Conf.getInstance().setDataTableShellOpen(false);
			}
		});
		init();

	}

	private void init() {
		createComposite5();
	}

	private void createComposite5() {

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite5 = new Cmp_TestQuestTable(sShell, SWT.NONE);
		composite5.setLayout(new GridLayout());
		composite5.setLayoutData(gridData1);
	}

}
