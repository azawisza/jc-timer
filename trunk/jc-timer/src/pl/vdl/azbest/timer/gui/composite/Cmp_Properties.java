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

import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class Cmp_Properties extends Composite {
	private Logger logger = Logger.getLogger(getClass().getName());
	private CoolBar coolBar = null;
	private Composite composite = null;

	public Cmp_Properties(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createCoolBar();
		createComposite();
		setSize(new Point(38, 29));
		setLayout(new GridLayout());
	}

	/**
	 * This method initializes coolBar
	 *
	 */
	private void createCoolBar() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = false;
		gridData.verticalAlignment = GridData.CENTER;
		coolBar = new CoolBar(this, SWT.NONE);
		coolBar.setLayoutData(gridData);

		// create and add the button for performing an open operation
		final CoolItem openCoolItem = new CoolItem(coolBar, SWT.NONE);

		final ToolBar fileToolBar = new ToolBar(coolBar, SWT.HORIZONTAL);
		final ToolItem openToolItem = new ToolItem(fileToolBar, SWT.PUSH);

		openToolItem.setText(">>");
		openToolItem.setToolTipText(">>");
		openToolItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				logger.info("Open");
				composite.setVisible(true);
				composite.setEnabled(true);
				composite.setSize(100, 100);
			}
		});

		fileToolBar.pack();
		Point size = fileToolBar.getSize();
		openCoolItem.setControl(fileToolBar);
		openCoolItem.setSize(openCoolItem.computeSize(size.x, size.y));

		// final CoolItem editbarCoolItem = new CoolItem(coolBar, SWT.PUSH);
		// final ToolBar editToolBar = new ToolBar(coolBar,SWT.HORIZONTAL);
	}

	/**
	 * This method initializes composite
	 *
	 */
	private void createComposite() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setVisible(false);
		composite.setEnabled(false);
		composite.setBackground(new Color(Display.getCurrent(), 168, 152, 93));
		composite.setLayoutData(gridData1);
	}

} // @jve:decl-index=0:visual-constraint="0,0"
