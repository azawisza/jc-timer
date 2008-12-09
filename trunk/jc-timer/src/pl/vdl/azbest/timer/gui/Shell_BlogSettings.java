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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.gui.composite.Cmp_BlogSettings;
import pl.vdl.azbest.timer.gui.composite.Cmp_Satisitcs;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

public class Shell_BlogSettings extends SWTElement{

	//private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="6,-221"

	/**
	 * This method initializes sShell
	 */
	protected void createSShell() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		sShell = new Shell();
		sShell.setText("Blog settings");
		sShell.setEnabled(true);
		sShell.setLayout(gridLayout);
		sShell.setSize(new Point(446, 243));
		sShell.addDisposeListener(new DisposeListener(){
			public void widgetDisposed(DisposeEvent eve) {
				Conf.getInstance().setCmd_OpenBlogSettingsWindowIsOpened(false);

			}
		});
		addComposite();
		createGroup();
		Conf.getInstance().setCmd_OpenBlogSettingsWindowIsOpened(true);



	}

	private Composite composite5 = null;
	private Group group = null;
	private Button button = null;
	private Button button1 = null;
	private Button button2 = null;

	private void addComposite() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.verticalAlignment = GridData.FILL;
		composite5 = new Cmp_BlogSettings(sShell, SWT.NONE);
		composite5.setLayout(new GridLayout());
		composite5.setLayoutData(gridData1);
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		gridData.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 3;
		group = new Group(sShell, SWT.NONE);
		group.setLayout(gridLayout1);
		group.setLayoutData(gridData);
		button = new Button(group, SWT.NONE);
		button.setText("Save");
		button2 = new Button(group, SWT.NONE);
		button2.setText("Apply");
		button2.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				((Cmp_BlogSettings)composite5).saveFormData();
			}
		});
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				((Cmp_BlogSettings)composite5).saveFormData();
				Shell_BlogSettings.this.closeWidget();

			}
		});
		button1 = new Button(group, SWT.NONE);
		button1.setText("Cancel");
		button1.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				System.out.println("widgetSelected()"); // TODO Auto-generated Event stub widgetSelected()
				Shell_BlogSettings.this.closeWidget();
			}
		});
	}

}
