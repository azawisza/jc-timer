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

import pl.vdl.azbest.timer.gui.composite.Cmp_pbarControlls;
import pl.vdl.azbest.timer.gui.composite.Cmp_progressBar;

public class Shl_ProgressBar extends SWTElement {

	// private Shell sShell = null; //
	// @jve:decl-index=0:visual-constraint="10,10"
	private Composite composite3 = null;  //  @jve:decl-index=0:visual-constraint="10,52"
	private Composite composite4 = null;

	/**
	 * This method initializes sShell
	 */
	@Override
	protected void createSShell() {
		sShell = new Shell(SWT.ON_TOP | SWT.SHELL_TRIM);
		sShell.setText("02:30");
		sShell.setSize(new Point(300, 100));
		sShell.setLayout(new GridLayout());
		init();
	}

	private void init() {
		createComposite4();
		createComposite3();

	}

	private void createComposite3() {

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite3 = new Cmp_progressBar(sShell, SWT.NONE);
		composite3.setLayout(new GridLayout());
		composite3.setSize(new Point(210, 77));
		composite3.setLayoutData(gridData1);
	}
	private void createComposite4() {

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite3 = new Cmp_pbarControlls(sShell, SWT.NONE);
		composite3.setLayout(new GridLayout());
		composite3.setSize(new Point(323, 90));
		composite3.setLayoutData(gridData1);
	}

}
