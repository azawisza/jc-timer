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
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.counter.worker.TestQuestDataCollector;
import pl.vdl.azbest.timer.gui.GUIFacade;
import org.eclipse.swt.widgets.Button;

public class Cmp_TestQuestTable extends Composite {

	private final String COL0_NAME = "Date";

	private final String COL1_NAME = "Source";

	private final String COL2_NAME = "Exam";

	private final String COL3_NAME = "Topic";

	private final String COL4_NAME = "Link";

	private final String COL5_NAME = "Pass";

	private final String COL6_NAME = "Time";

	private Table table = null;

	private Group group = null;

	public Cmp_TestQuestTable(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridData gridData4 = new GridData();
		gridData4.horizontalSpan = 9;
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
		table = new Table(this, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLayoutData(gridData);
		table.setLinesVisible(true);

		for (String name : Conf.getInstance().getDataTableColumns()) {
			addColumn(name);
		}

		createGroup();

		this.setLayout(gridLayout1);
		this.setSize(new Point(517, 394));

		label2 = new Label(this, SWT.NONE);
		label2
				.setText("Test progress data");
		label2.setLayoutData(gridData4);
		init();
	}

	private void addColumn(String colname) {
		TableColumn tableColumn7 = new TableColumn(table, SWT.NONE);
		tableColumn7.setWidth(10 * colname.length());
		tableColumn7.setText(colname);
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.END;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData5 = new GridData();
		gridData5.verticalSpan = 2;
		gridData5.verticalAlignment = GridData.FILL;
		gridData5.grabExcessHorizontalSpace = false;
		gridData5.grabExcessVerticalSpace = true;
		gridData5.horizontalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = false;
		gridData1.horizontalSpan = 9;
		gridData1.verticalAlignment = GridData.FILL;
		group = new Group(this, SWT.NONE);
		group.setLayoutData(gridData1);
		group.setLayout(gridLayout);
		// button5 = new Button(group, SWT.NONE);

		button = new Button(group, SWT.NONE);
		button.setText("Save as HTML");
		button.setLayoutData(gridData2);
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {

			}
		});
		// button5.setLayoutData(gridData5);

		// button5.setText("Save");

		/*
		 * button5 .addSelectionListener(new
		 * org.eclipse.swt.events.SelectionAdapter() { public void
		 * widgetSelected( org.eclipse.swt.events.SelectionEvent e) {
		 *
		 * TableItem it = table.getItem(selectedIndex); FileDialog fd = new
		 * FileDialog(Cmp_TestQuestTable.this .getShell(), SWT.SAVE);
		 * fd.setFilterExtensions(new String[] { ".txt" }); fd.open();
		 *
		 * String path = fd.getFilterPath() +
		 * System.getProperty("path.separator") + fd.getFileName();
		 *
		 * Command c = new Cmd_uiSaveToFile( getTableDataAsHTMLTable(), path);
		 * Invoker.getInstance().addCommand(c); Invoker.getInstance().execute(); }
		 * });
		 */
	}

	private void init() {
		GUIFacade.getInstance().setCmpTestQuestTable(this);
		// adding titles

		// getTestQuestData
		for (Map<String, String> dataRow : TestQuestDataCollector.getInstance()
				.getTestQuestData()) {
			addTableRow(dataRow);

		}
		Conf.getInstance().setDataTableShellOpen(true);

	}

	private Label label2 = null;

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

	private boolean rowsSet = false;

	private Button button = null;

	public void addTableRow(Map<String, String> data) {
		Color color =null;
		if (!data.get("Pass").equals("false")) {
			//green 168 205 138
			color =  new Color(Display.getCurrent(), 168, 205, 138);
		} else {
			//red 255 128 0
			color =  new Color(Display.getCurrent(), 255, 128, 0);
		}

		int i = 0;
		TableItem item = new TableItem(table, SWT.NULL);
		for (Entry<String, String> cel : data.entrySet()) {

			item.setText(i, cel.getValue());
			i++;
			item.setBackground(color);
		}

	}
} // @jve:decl-index=0:visual-constraint="32,36"
