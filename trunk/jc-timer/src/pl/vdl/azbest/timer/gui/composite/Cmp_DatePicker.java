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
import java.util.Date;

import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.GridData;

public class Cmp_DatePicker extends Composite {
	private Logger logger = Logger.getLogger(getClass().getName());
	private Group group = null;

	private Label label = null;

	private Label label1 = null;

	private Combo comboMonth = null;

	private Label label2 = null;

	private Spinner spinnerDay = null;

	private Spinner spinnerYear = null;

	public Cmp_DatePicker(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createGroup();
		setSize(new Point(269, 57));
		setLayout(new GridLayout());
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData11 = new GridData();
		gridData11.horizontalAlignment = GridData.CENTER;
		gridData11.grabExcessHorizontalSpace = false;
		gridData11.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.widthHint = 15;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.CENTER;
		gridData.grabExcessHorizontalSpace = false;
		gridData.widthHint = 30;
		gridData.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 6;
		group = new Group(this, SWT.NONE);
		group.setText("Date Chooser");
		group.setLayoutData(gridData11);
		group.setLayout(gridLayout);
		label = new Label(group, SWT.NONE);
		label.setText("Year");
		spinnerYear = new Spinner(group, SWT.READ_ONLY | SWT.BORDER);
		spinnerYear.setMaximum(4760);
		spinnerYear.setMinimum(-4760);
		spinnerYear.setLayoutData(gridData);
		label1 = new Label(group, SWT.NONE);
		label1.setText("Month");
		createComboMonth();
		label2 = new Label(group, SWT.NONE);
		label2.setText("Day");
		spinnerDay = new Spinner(group, SWT.BORDER);

		spinnerDay.setDigits(0);
		spinnerDay.setMaximum(31);
		spinnerDay.setMinimum(1);
		spinnerDay.setLayoutData(gridData1);
		init();
	}

	/**
	 * This method initializes comboMonth
	 *
	 */
	private void createComboMonth() {
		GridData gridData2 = new GridData();
		gridData2.widthHint = 40;
		comboMonth = new Combo(group, SWT.READ_ONLY);
		comboMonth.setLayoutData(gridData2);
		comboMonth
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Calendar c = Calendar.getInstance();
						logger.info("combo selection "
								+ comboMonth.getSelectionIndex());
						c.set(Calendar.MONTH, comboMonth.getSelectionIndex());
						logger.info("Month " + c.get(Calendar.MONTH));
						spinnerDay.setMaximum(c
								.getActualMaximum(Calendar.DAY_OF_MONTH));
						logger.info("MAX: "
								+ c.getActualMaximum(Calendar.DAY_OF_MONTH));
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});

		for (int i = 0; i < 12; i++) {
			comboMonth.add(gxtMTH[i], i);
		}
	}

	private void init() {
		setYear(cal.get(Calendar.YEAR));
		setMonth(cal.get(Calendar.MONTH));
		setDay(cal.get(Calendar.DAY_OF_MONTH));
	}

	private void setDay(int d) {
		spinnerDay.setSelection(d);
	}

	private void setYear(int y) {
		spinnerYear.setSelection(y);
	}

	private void setMonth(int m) {
		comboMonth.select(m);

	}

	private final String gxtMTH[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
			"JUL", "AUG", "SEP", "OCT", "NOV", "DEC" }; // @jve:decl-index=0:

	private Calendar cal = null;
	{
		Date d = new Date();
		cal = Calendar.getInstance();
		cal.setTime(d);
	}

	public int[] getDate() {
		return new int[] { spinnerYear.getSelection(),
				comboMonth.getSelectionIndex(), spinnerDay.getSelection() };
	}

} // @jve:decl-index=0:visual-constraint="10,10"
