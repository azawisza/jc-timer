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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;

public class Cmp_Satisitcs extends Composite {

	private Group group = null;
	private Label label6 = null;
	private Label label7 = null;
	private Label label8 = null;
	private Label label9 = null;
	private Label label10 = null;
	private Label label11 = null;
	private Label label = null;
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;

	public Cmp_Satisitcs(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		this.setLayout(gridLayout);
		createGroup();
		this.setSize(new Point(105, 121));
	}

	// 0 -
	public void updateValues(String qNumber, String totalTime,
			String timePerQuest, String points, String factor) {
		this.label9.setText(qNumber);
		this.label10.setText(totalTime);
		this.label11.setText(timePerQuest);
		this.label1.setText(points);
		this.label3.setText(factor);

	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData6 = new GridData();
		gridData6.horizontalAlignment = GridData.FILL;
		gridData6.grabExcessHorizontalSpace = true;
		gridData6.verticalAlignment = GridData.CENTER;
		GridData gridData5 = new GridData();
		gridData5.horizontalAlignment = GridData.FILL;
		gridData5.grabExcessHorizontalSpace = true;
		gridData5.verticalAlignment = GridData.CENTER;
		GridData gridData20 = new GridData();
		gridData20.horizontalAlignment = GridData.FILL;
		gridData20.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 2;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = false;
		gridData.verticalAlignment = GridData.CENTER;
		group = new Group(this, SWT.NONE);
		group.setText("Time statistics");
		group.setLayoutData(gridData);
		group.setLayout(gridLayout1);
		label6 = new Label(group, SWT.NONE);
		label6.setText("Qnum");
		label6.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				8, SWT.BOLD));
		label9 = new Label(group, SWT.NONE);
		label9.setText("1");
		label9.setLayoutData(gridData20);
		label7 = new Label(group, SWT.NONE);
		label7.setText("TT");
		label7.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				8, SWT.BOLD));
		label10 = new Label(group, SWT.NONE);
		label10.setText("00:00:00");
		label8 = new Label(group, SWT.NONE);
		label8.setText("TPQ");
		label8.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				8, SWT.BOLD));
		label11 = new Label(group, SWT.NONE);
		label11.setText("00:00:00");
		label = new Label(group, SWT.NONE);
		label.setText("Pts");
		label.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif", 8,
				SWT.BOLD));
		label1 = new Label(group, SWT.NONE);
		label1.setText("0");
		label1.setLayoutData(gridData5);
		label2 = new Label(group, SWT.NONE);
		label2.setText("Factor");
		label2.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				8, SWT.BOLD));
		label3 = new Label(group, SWT.NONE);
		label3.setText("Label");
		label3.setLayoutData(gridData6);
	}

	public void setCounter(int i) {
		label1.setText("" + i);
	}

} // @jve:decl-index=0:visual-constraint="34,34"
