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

public class Cmp_tmpAlarmSet extends Composite {

	private Group group = null;

	public Cmp_tmpAlarmSet(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createGroup();
		setSize(new Point(300, 200));
		setLayout(new GridLayout());
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		group = new Group(this, SWT.NONE);
		group.setLayout(new GridLayout());
	}

}
