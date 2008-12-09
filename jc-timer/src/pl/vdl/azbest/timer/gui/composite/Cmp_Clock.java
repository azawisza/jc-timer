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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.graphics.Font;

import pl.vdl.azbest.timer.gui.GUIFacade;

public class Cmp_Clock extends Composite {

	private Group group = null;
	private Label label = null;
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;
	private Label label4 = null;

	public Cmp_Clock(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createGroup();
		setSize(new Point(143, 60));
		setLayout(new GridLayout());
		GUIFacade.getInstance().setCmp_Clock(this);

	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData5 = new GridData();
		gridData5.grabExcessVerticalSpace = true;
		GridData gridData4 = new GridData();
		gridData4.grabExcessVerticalSpace = true;
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.CENTER;
		gridData3.grabExcessHorizontalSpace = true;
		gridData3.grabExcessVerticalSpace = true;
		gridData3.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.CENTER;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.grabExcessVerticalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.CENTER;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.CENTER;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		group = new Group(this, SWT.NONE);
		group.setLayout(gridLayout);
		group.setLayoutData(gridData);
		label4 = new Label(group, SWT.NONE);
		label4.setText("hrs");
		label4.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				14, SWT.NORMAL));
		label4.setLayoutData(gridData3);
		label3 = new Label(group, SWT.NONE);
		label3.setText(":");
		label3.setLayoutData(gridData4);
		label3.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				14, SWT.NORMAL));
		label = new Label(group, SWT.NONE);
		label.setText("min");
		label.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				14, SWT.NORMAL));
		label.setLayoutData(gridData2);
		label1 = new Label(group, SWT.NONE);
		label1.setText(":");
		label1.setLayoutData(gridData5);
		label1.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				14, SWT.NORMAL));
		label2 = new Label(group, SWT.NONE);
		label2.setText("sec");
		label2.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				14, SWT.NORMAL));
		label2.setLayoutData(gridData1);
	}

	public void setTime(String hours, String minutes, String seconds) {
		this.label4.setText(hours);
		this.label.setText(minutes);
		this.label2.setText(seconds);
	}

} // @jve:decl-index=0:visual-constraint="9,4"
