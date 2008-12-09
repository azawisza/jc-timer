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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import pl.vdl.azbest.timer.Conf;
import org.eclipse.swt.widgets.Link;

public class Cmp_BlogReporting extends Composite {

	private Group group = null;
	private Label label = null;
	private Label label2 = null;
	private Label labelUsername = null;
	private Label label4 = null;
	private Label labelStatus = null;
	private Label label1 = null;
	private Label label3 = null;
	private Link labelSite = null;

	public Cmp_BlogReporting(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createGroup();
		setSize(new Point(300, 98));
		setLayout(new GridLayout());
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.verticalAlignment = GridData.CENTER;
		GridData gridData21 = new GridData();
		gridData21.horizontalAlignment = GridData.FILL;
		gridData21.grabExcessHorizontalSpace = true;
		gridData21.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.verticalSpan = 4;
		gridData1.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		group = new Group(this, SWT.NONE);
		group.setText("Adding post ");
		group.setLayoutData(gridData1);
		group.setLayout(gridLayout);
		label1 = new Label(group, SWT.NONE);
		label3 = new Label(group, SWT.NONE);
		label3.setText("<empty>");
		label3.setLayoutData(gridData21);
		label = new Label(group, SWT.NONE);
		label.setText("Site:");
		label.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif", 8,
				SWT.BOLD));
		labelSite = new Link(group, SWT.NONE);
		labelSite.setText("<a>Link</a>");
		label2 = new Label(group, SWT.NONE);
		label2.setText("Username:");
		label2.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				8, SWT.BOLD));
		labelUsername = new Label(group, SWT.NONE);
		labelUsername.setText("Label");
		labelUsername.setLayoutData(gridData2);
		label4 = new Label(group, SWT.NONE);
		label4.setText("Status :");
		label4.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				8, SWT.BOLD));
		labelStatus = new Label(group, SWT.NONE);
		labelStatus.setText("Label");
		labelStatus.setLayoutData(gridData3);
		label1.setText("Title");
		label1.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif", 8, SWT.BOLD));
		loadData("");
	}

	public void loadData(String title) {
		labelSite.setText(Conf.getInstance().getBlogAddress());
		labelUsername.setText(Conf.getInstance().getBlogUserName());
		label3.setText(title);
	}

	public void setStatus(String status) {
		if(labelStatus!=null)labelStatus.setText(status);
	}

} // @jve:decl-index=0:visual-constraint="245,44"
