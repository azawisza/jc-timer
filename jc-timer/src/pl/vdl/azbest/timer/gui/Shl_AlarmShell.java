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

import java.util.Calendar;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.alarm.AlarmClock;
import pl.vdl.azbest.timer.alarm.AlarmData;
import pl.vdl.azbest.timer.cmd.Cmd_uiNewAlarm;
import pl.vdl.azbest.timer.cmd.Command;
import pl.vdl.azbest.timer.cmd.Invoker;
import pl.vdl.azbest.timer.gui.composite.Cmp_DatePicker;
import pl.vdl.azbest.timer.gui.composite.Cmp_NewAlarm;
import pl.vdl.azbest.timer.gui.composite.Cmp_Table;
import pl.vdl.azbest.timer.gui.composite.Cmp_TimePicker;

public class Shl_AlarmShell extends SWTElement {

	// private Shell sShell = null; // @jve:decl-index=0:visual-constraint="0,0"

	private static Shl_AlarmShell instance = null;

	public static Shl_AlarmShell getInstance() {
		if (instance == null) {
			instance = new Shl_AlarmShell();
			return instance;
		} else {
			return instance;
		}
	}

	/**
	 * This method initializes sShell
	 */
	@Override
	protected void createSShell() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.makeColumnsEqualWidth = false;
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setLayout(gridLayout);
		sShell.setSize(new Point(445, 464));
		sShell.addDisposeListener(new org.eclipse.swt.events.DisposeListener() {
			public void widgetDisposed(org.eclipse.swt.events.DisposeEvent e) {
				Conf.getInstance().setNewAlarmShellOpen(false);

			}
		});

		init();
	}

	private void init() {

		createComposite1();
		createComposite2();
		createComposite3();
		createComposite4();
		Conf.getInstance().setNewAlarmShellOpen(true);

	}

	private void createComposite1() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = false;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;

		cmp_DatePicker = new Cmp_DatePicker(sShell, SWT.NONE);
		composite1 = cmp_DatePicker;
		composite1.setLayout(new GridLayout());
		composite1.setLayoutData(gridData1);

	}

	private void createComposite2() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = false;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;

		cmp_TimePicker = new Cmp_TimePicker(sShell, SWT.NONE);
		composite2 = cmp_TimePicker;
		composite2.setLayout(new GridLayout());
		composite2.setLayoutData(gridData1);

	}

	private void createComposite3() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		// gridData1.verticalAlignment = GridData.FILL;

		cmp_NewAlarm = new Cmp_NewAlarm(sShell, SWT.NONE);
		composite3 = cmp_NewAlarm;
		composite3.setLayout(new GridLayout());
		composite3.setLayoutData(gridData1);

	}

	private void createComposite4() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;

		cmp_Table = new Cmp_Table(sShell, SWT.FILL);

		composite4 = cmp_Table;
		composite4.setLayout(new GridLayout());
		composite4.setLayoutData(gridData1);
		cmp_Table.setColumns("Alarm text", "Alarm time");
		List<AlarmData> list = AlarmClock.getInstance().getScheduledAlarms();
		for (AlarmData adata : list) {
			cmp_Table.addTableRow(adata);
		}

	}

	private Composite composite1 = null;

	private Composite composite2 = null;

	private Composite composite3 = null;

	private Composite composite4 = null;

	private Cmp_Table cmp_Table = null;

	private Cmp_NewAlarm cmp_NewAlarm = null;

	private Cmp_TimePicker cmp_TimePicker = null;

	private Cmp_DatePicker cmp_DatePicker = null;

	public void setNewAlarm() {


		int[] date = cmp_DatePicker.getDate();
		int[] time = cmp_TimePicker.getTime();
		String txt = cmp_NewAlarm.getAlarmTXT();

		Calendar alarm = Calendar.getInstance();
		alarm.set(date[0], date[1], date[2], time[0], time[1], time[2]);

		AlarmData aData = new AlarmData();
		aData.setAlarmText(txt);
		aData.setAlarmTime(alarm);


		Command command = new Cmd_uiNewAlarm(aData);
		Invoker.getInstance().addCommand(command);

		Invoker.getInstance().execute();
		cmp_Table.addTableRow(aData);
	}

}
