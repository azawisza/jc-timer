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
package pl.vdl.azbest.timer.blogger;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Button;

public class Cmp_PostEditor extends Composite {

	private Group group = null;
	private Text text = null;
	private Label label = null;
	private CoolBar coolBar = null;
	private Text textArea = null;
	private Button button2 = null;

	public Cmp_PostEditor(Composite parent, int style) {
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
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.END;
		gridData3.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.horizontalSpan = 2;
		gridData2.verticalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.grabExcessVerticalSpace = true;
		gridData2.horizontalAlignment = GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		group = new Group(this, SWT.NONE);
		group.setText("Wordpress post");
		group.setLayout(gridLayout);
		group.setLayoutData(gridData);
		label = new Label(group, SWT.NONE);
		label.setText("Post title");
		text = new Text(group, SWT.BORDER);
		text.setLayoutData(gridData1);
		@SuppressWarnings("unused")
		Label filler3 = new Label(group, SWT.NONE);
		@SuppressWarnings("unused")
		Label filler4 = new Label(group, SWT.NONE);
		@SuppressWarnings("unused")
		Label filler5 = new Label(group, SWT.NONE);
		createCoolBar();
		textArea = new Text(group, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		textArea.setLayoutData(gridData2);
		@SuppressWarnings("unused")
		Label filler2 = new Label(group, SWT.NONE);
		@SuppressWarnings("unused")
		Label filler = new Label(group, SWT.NONE);
		button2 = new Button(group, SWT.NONE);
		button2.setText("Send");
		button2.setLayoutData(gridData3);
	}

	/**
	 * This method initializes coolBar
	 *
	 */
	private void createCoolBar() {
		setCoolBar(new CoolBar(group, SWT.NONE));
	}

	public void setCoolBar(CoolBar coolBar) {
		this.coolBar = coolBar;
	}

	public CoolBar getCoolBar() {
		return coolBar;
	}

}
