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

import pl.vdl.azbest.timer.gui.composite.Cmp_TestQuestForm;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;

public class Shl_TestSettings extends SWTElement{

	//private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="13,-9"

	/**
	 * This method initializes sShell
	 */
	protected void createSShell() {
		GridLayout gridLayout = new GridLayout();
		sShell = new Shell();
		sShell.setText("Test settings");
		sShell.setLayout(gridLayout);

		sShell.setSize(new Point(383, 214));
		sShell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				Conf.getInstance().setTestSettingsShellOpen(false);
			}
		});
		init();
		createGroup();
	}
	private void init(){
		Conf.getInstance().setTestSettingsShellOpen(true);
		createComposite1();
		lockSWTWidgetSize();
		setSWTWidgetPositionCenetr(0, 0);

	}
	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		gridData.verticalAlignment = GridData.CENTER;
		group = new Group(sShell, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setLayoutData(gridData);
		button = new Button(group, SWT.NONE);
		button.setText("Save settings");
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				saveSettings();
			}
		});
	}



	private Composite composite1= null;
	private Cmp_TestQuestForm cmp_TestQuestForm = null;
	private Group group = null;
	private Button button = null;
	private void createComposite1() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite1 = new Cmp_TestQuestForm(sShell, SWT.NONE);
		cmp_TestQuestForm = (Cmp_TestQuestForm)composite1;
		composite1.setLayout(new GridLayout());
		composite1.setLayoutData(gridData1);

	}
	private void saveSettings() {
		String s[] = cmp_TestQuestForm.getFormData();
		Conf.getInstance().setTestExam(s[0]);
		Conf.getInstance().setTestSource(s[1]);
		Conf.getInstance().setTestSubject(s[2]);
	}

}
