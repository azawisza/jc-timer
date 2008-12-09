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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class Cmp_DTPicker extends Composite {

	public Cmp_DTPicker(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {

		setSize(new Point(274, 208));
		init();

	}

	private void init() {
		createComposite1();
		createComposite2();
	}

	private void createComposite1() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;

		composite1 = new Cmp_DatePicker(this.getShell(), SWT.NONE);
		composite1.setLayoutData(gridData1);
		composite1.setLayout(new GridLayout());

	}

	private void createComposite2() {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;

		composite2 = new Cmp_TimePicker(this.getShell(), SWT.NONE);
		composite2.setLayout(new GridLayout());
		composite2.setSize(new Point(236, 55));
		composite2.setLayoutData(gridData1);
	}

	private Composite composite1 = null;
	private Composite composite2 = null; // @jve:decl-index=0:visual-constraint=
	// "284,10"

} // @jve:decl-index=0:visual-constraint="0,0"
