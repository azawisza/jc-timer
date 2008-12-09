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

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.gui.composite.Cmp_DiggIt;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class Shell_RestartButton extends SWTElement {

	private static Shell_RestartButton instance = null; // @jve:decl-index=0:

	private Shell_RestartButton() {
		GUIFacade.getInstance().setShell_RestartButton(this);

	}

	public static Shell_RestartButton getInstance() {
		if (instance == null) {
			instance = new Shell_RestartButton();
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
		sShell = new Shell(SWT.ON_TOP | SWT.SHELL_TRIM);
		WIN_HEIGHT = 600;
		WIN_WIDTH = 200;

		sShell.setText("");
		sShell.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				47, SWT.NORMAL));
		createGroup();
		sShell.setSize(new Point(200, 600));
		sShell.setLayout(new GridLayout());
		sShell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {
			@Override
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				Conf.getInstance().setRButtonOpened(false);
				GUIFacade.getInstance().setShell_RestartButton(null);
			}
		});

		// lockSWTWidgetSize();
		createComposite2();
		setSWTWidgetPositionCenetr(0, 0);
		sShell.setSize(200, 400);

	}

	private Composite composite6 = null;

	private void createComposite2() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite6 = new Cmp_DiggIt(sShell, SWT.NONE);
		composite6.setLayout(new GridLayout());
		composite6.setLayoutData(gridData1);
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		/*
		 * GridData gridData1 = new GridData(); gridData1.horizontalAlignment =
		 * GridData.FILL; gridData1.grabExcessHorizontalSpace = true;
		 * gridData1.grabExcessVerticalSpace = true; gridData1.verticalAlignment
		 * = GridData.FILL; GridData gridData = new GridData();
		 * gridData.horizontalAlignment = GridData.FILL;
		 * gridData.grabExcessHorizontalSpace = true;
		 * gridData.grabExcessVerticalSpace = true; gridData.verticalAlignment =
		 * GridData.FILL; group = new Group(sShell, SWT.NONE);
		 * group.setLayout(new GridLayout()); group.setLayoutData(gridData1);
		 * button = new Button(group, SWT.NONE); button.setText("RESTART");
		 * button.setLayoutData(gridData); button.addSelectionListener(new
		 * org.eclipse.swt.events.SelectionAdapter() { public void
		 * widgetSelected(org.eclipse.swt.events.SelectionEvent e) { Command c =
		 * new Cmd_uiRestart(); Invoker.getInstance().addCommand(c);
		 * Invoker.getInstance().execute(); } }); button.setVisible(false);
		 * group.setVisible(false);
		 */
	}

	public void minimalize() {
		sShell.setMinimized(true);
	}

	public void restore() {
		sShell.setMinimized(false);
	}

	public void resetCounter() {
		((Cmp_DiggIt) composite6).resetCounter();
	}

}
