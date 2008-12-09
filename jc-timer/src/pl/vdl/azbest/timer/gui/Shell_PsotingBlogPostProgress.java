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

import pl.vdl.azbest.timer.cmd.Cmd_blogPostSave.BlogWorker;
import pl.vdl.azbest.timer.gui.composite.Cmp_BlogReporting;
import pl.vdl.azbest.timer.gui.composite.Cmp_BlogSettings;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

public class Shell_PsotingBlogPostProgress extends SWTElement {
	private BlogWorker worker;
	public Shell_PsotingBlogPostProgress(BlogWorker worker){
		this.worker=worker;
	}
//private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="181,71"

	/**
	 * This method initializes sShell
	 */
	protected void createSShell() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalIndent = 5;
		gridData.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.verticalSpacing = 5;
		gridLayout.marginWidth = 5;
		sShell = new Shell();
		sShell.setText("wait...");
		sShell.setLayout(gridLayout);
		addComposite() ;
		sShell.setSize(new Point(298, 171));
		sShell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				worker.removeUI();

			}
		});
		button1 = new Button(sShell, SWT.UP | SWT.FLAT);
		button1.setText("Hide");
		button1.setLayoutData(gridData);
		button1.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				Shell_PsotingBlogPostProgress.this.closeWidget();
			}
		});
		lockSWTWidgetSize();

	}
	private Composite  composite5;
	private Button button1 = null;
	private void addComposite() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.verticalAlignment = GridData.FILL;
		composite5 = new Cmp_BlogReporting(sShell, SWT.NONE);
		composite5.setLayout(new GridLayout());
		composite5.setLayoutData(gridData1);
		((Cmp_BlogReporting)composite5).loadData(title);
	}
	public void setBlogPostinProgressLabel(String status) {
		if(composite5!= null){
			((Cmp_BlogReporting)composite5).setStatus(status);
		}
	}
	private String title ="";  //  @jve:decl-index=0:
	public void setTitle(String title) {
		this.title=title;
	}

}
