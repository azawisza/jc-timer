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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.swing.LookAndFeel;

import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

import pl.vdl.azbest.timer.alarm.AlarmClock;
import pl.vdl.azbest.timer.alarm.AlarmData;

public class Cmp_Table extends Composite {

	private Table table = null;
	private Logger logger = Logger.getLogger(getClass().getName());

	public Cmp_Table(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridData gridData11 = new GridData();
		gridData11.horizontalSpan = 5;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 9;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 9;
		gridData.verticalAlignment = GridData.FILL;
		table = new Table(this, SWT.FULL_SELECTION | SWT.MULTI);
		table.setHeaderVisible(true);
		table.setLayoutData(gridData);
		table.setLinesVisible(true);

		table.addKeyListener(new org.eclipse.swt.events.KeyAdapter() {
			public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
				System.out.println("keyPressed()" + e); // TODO Auto-generated
				// Event stub
				// keyPressed()
				if (e.keyCode == 127) {
					System.out.println("DELETE was pressed.");
					TableItem ti[] = table.getSelection();
					if (ti.length > 0) {
						System.out
								.println("At least one element selected in table ");
						for (TableItem tableItem : ti) {
							if (tableItem.getData() instanceof AlarmData) {

								AlarmClock.getInstance().unscheduleAlarm(
										(AlarmData) tableItem.getData());
								tableItem.dispose();
								table.redraw();
							} else {
								System.err
										.println("ERROR - SWTTable contains data that are not AlarmData");
							}

						}
					}
				}

			}
		});
		/*
		 * if (!COL0_NAME.equals("")) { TableColumn tableColumn = new
		 * TableColumn(table, SWT.NONE); tableColumn.setWidth(60);
		 * tableColumn.setText(COL0_NAME); } if (!COL1_NAME.equals("")) {
		 * TableColumn tableColumn1 = new TableColumn(table, SWT.NONE);
		 * tableColumn1.setWidth(60); tableColumn1.setText(COL1_NAME); } if
		 * (!COL2_NAME.equals("")) {
		 *
		 * TableColumn tableColumn2 = new TableColumn(table, SWT.NONE);
		 * tableColumn2.setWidth(60); tableColumn2.setText(COL2_NAME); } if
		 * (!COL3_NAME.equals("")) {
		 *
		 * TableColumn tableColumn3 = new TableColumn(table, SWT.NONE);
		 * tableColumn3.setWidth(60); tableColumn3.setText(COL3_NAME); } if
		 * (!COL4_NAME.equals("")) {
		 *
		 * TableColumn tableColumn4 = new TableColumn(table, SWT.NONE);
		 * tableColumn4.setWidth(60); tableColumn4.setText(COL4_NAME); } if
		 * (!COL5_NAME.equals("")) { TableColumn tableColumn5 = new
		 * TableColumn(table, SWT.NONE); tableColumn5.setWidth(60);
		 * tableColumn5.setText(COL5_NAME); } if (!COL6_NAME.equals("")) {
		 *
		 * TableColumn tableColumn6 = new TableColumn(table, SWT.NONE);
		 * tableColumn6.setWidth(60); tableColumn6.setText(COL6_NAME); }
		 */

		this.setLayout(gridLayout1);
		this.setSize(new Point(517, 394));

		init();
	}

	private void init() {

		// testing
		// getTestQuestData

	}

	public void loadFile(String path) throws InvalidPropertiesFormatException,
			IOException {
		TableItem[] items = table.getItems();
		for (TableItem i : items) {
			i.dispose();
		}

		File f = new File(path);
		// //logger.info(path);
		Properties prop = new Properties();
		prop.loadFromXML(new FileInputStream(f));
		Set<?> kset = prop.keySet();
		Iterator<?> it = kset.iterator();
		// logger.info("kset size> "+kset.size());
		// logger.info("kset size> "+kset.size());
		while (it.hasNext()) {
			TableItem item = new TableItem(table, SWT.NULL);
			String key = (String) it.next();
			String property = prop.getProperty(key);
			item.setText(0, key);
			item.setText(1, property);

		}
		TableColumn[] col = table.getColumns();
		for (TableColumn tableColumn1 : col) {
			tableColumn1.pack();
		}

	}

	public void setColumns(String... cols) {
		if (cols != null) {
			for (String COL : cols) {
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(COL.length() * 10);
				tableColumn.setText(COL);

			}
		}
	}

	public void addTableRow(AlarmData adata) {
		String secS="";
		int sec = adata.getAlarmTime().get(Calendar.SECOND);
		if(sec<10){
			secS="0"+sec;
		}else
			secS=""+sec;
		TableItem item = new TableItem(table, SWT.NULL);
		item.setText(0,adata.getAlarmText());
		item.setText(1,adata.getAlarmTime().get(Calendar.HOUR_OF_DAY) + ":"
				+ adata.getAlarmTime().get(Calendar.MINUTE) + ":"
				+ secS );
		item.setData(adata);
	}
} // @jve:decl-index=0:visual-constraint="32,36"

