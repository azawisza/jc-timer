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

import java.util.Calendar;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class Cmp_TimePicker extends Composite {

	private Group group = null;

	private Label label = null;

	private Spinner spinner = null;

	private Label label1 = null;

	private Spinner spinner1 = null;

	private Label label2 = null;

	private Spinner spinner2 = null;

	public Cmp_TimePicker(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createGroup();
		setSize(new Point(279, 65));
		setLayout(new GridLayout());
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.CENTER;
		gridData.grabExcessHorizontalSpace = false;
		gridData.grabExcessVerticalSpace = false;
		gridData.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
		gridLayout.marginHeight = 5;
		gridLayout.makeColumnsEqualWidth = false;
		gridLayout.marginWidth = 5;
		group = new Group(this, SWT.NONE);
		group.setText("Time Chooser");
		group.setLayoutData(gridData);
		group.setLayout(gridLayout);
		label = new Label(group, SWT.NONE);
		label.setText("Hour");
		spinner = new Spinner(group, SWT.BORDER);
		spinner.setMaximum(24);
		spinner.setFont(new Font(Display.getDefault(), "Tahoma", 14, SWT.NORMAL));
		label1 = new Label(group, SWT.NONE);
		label1.setText("Minute");
		spinner1 = new Spinner(group, SWT.BORDER);
		spinner1.setMaximum(60);
		spinner1.setFont(new Font(Display.getDefault(), "Tahoma", 14, SWT.NORMAL));
		label2 = new Label(group, SWT.NONE);
		label2.setText("Second");
		spinner2 = new Spinner(group, SWT.BORDER);
		spinner2.setMaximum(60);
		spinner2.setFont(new Font(Display.getDefault(), "Tahoma", 14, SWT.NORMAL));
		spinner2.setMinimum(0);
		init();
	}

	private void init() {
		Calendar c = Calendar.getInstance();
		int h = c.get(Calendar.HOUR_OF_DAY);
		int m = c.get(Calendar.MINUTE);
		spinner.setSelection(h);
		spinner1.setSelection(m);

	}

	public int[] getTime() {
		int[] time = { this.spinner.getSelection(),
				this.spinner1.getSelection(), this.spinner2.getSelection() };
		return time;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
