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
package pl.vdl.azbest.timer.gui.composite;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridData;

import pl.vdl.azbest.timer.cmd.Cmd_uiPause;
import pl.vdl.azbest.timer.cmd.Cmd_uiRestart;
import pl.vdl.azbest.timer.cmd.Cmd_uiStart;
import pl.vdl.azbest.timer.cmd.Cmd_uiStop;
import pl.vdl.azbest.timer.cmd.Command;
import pl.vdl.azbest.timer.cmd.Invoker;
import pl.vdl.azbest.timer.gui.GUIFacade;

public class Cmp_Buttons extends Composite {

	private Group group = null;
	private Button button = null;
	private Button button1 = null;
	private Button button2 = null;
	private Button button3 = null;

	public Cmp_Buttons(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		this.setLayout(gridLayout);
		createGroup();
		setSize(new Point(241, 59));
		GUIFacade.getInstance().setCmp_Buttons(this);
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.grabExcessVerticalSpace = true;
		gridData4.verticalAlignment = GridData.FILL;
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.grabExcessVerticalSpace = true;
		gridData3.verticalAlignment = GridData.FILL;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.grabExcessVerticalSpace = true;
		gridData2.verticalAlignment = GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 4;
		group = new Group(this, SWT.NONE);
		group.setLayout(gridLayout1);
		group.setLayoutData(gridData);
		button = new Button(group, SWT.NONE);
		button.setText("START");
		button.setLayoutData(gridData4);
		button
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					@Override
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiStart();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}
				});
		button1 = new Button(group, SWT.NONE);
		button1.setText("STOP");
		button1.setLayoutData(gridData3);
		button1
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					@Override
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiStop();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}
				});
		button2 = new Button(group, SWT.NONE);
		button2.setText("PAUSE");
		button2.setLayoutData(gridData2);
		button2
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					@Override
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiPause();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}
				});
		button3 = new Button(group, SWT.NONE);
		button3.setText("RESTART");
		button3.setLayoutData(gridData1);
		button3
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					@Override
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiRestart();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}
				});
	}

} // @jve:decl-index=0:visual-constraint="0,0"
