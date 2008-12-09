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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

import pl.vdl.azbest.timer.cmd.Cmd_uiDiggIT;
import pl.vdl.azbest.timer.cmd.Cmd_uiRestart;
import pl.vdl.azbest.timer.cmd.Command;
import pl.vdl.azbest.timer.cmd.Invoker;
import pl.vdl.azbest.timer.counter.worker.PointStatistics;

public class Cmp_DiggIt extends Composite {

	private Group group = null;

	private Button button = null;

	private Button button1 = null;

	public Cmp_DiggIt(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		this.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif", 12,
				SWT.NORMAL));
		createGroup();
		setSize(new Point(163, 325));
		setLayout(new GridLayout());
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
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		group = new Group(this, SWT.NONE);
		group.setText("Restrat/Points/Mask");
		group.setLayoutData(gridData1);
		group.setLayout(gridLayout);
		button = new Button(group, SWT.NONE);
		button.setText("-");
		button.setLayoutData(gridData3);
		button.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				18, SWT.BOLD));
		button
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					@Override
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {

						Command c = new Cmd_uiDiggIT(false);
						Invoker.getInstance().addCommand(c);

					}
				});
		button1 = new Button(group, SWT.NONE);
		button1.setText("+");
		button1.setLayoutData(gridData4);
		button1.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				18, SWT.BOLD));
		button1
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					@Override
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {

						Command c = new Cmd_uiDiggIT(true);
						Invoker.getInstance().addCommand(c);

					}
				});
	}

	public void resetCounter() {

	}

} // @jve:decl-index=0:visual-constraint="84,80"
