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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;

import pl.vdl.azbest.timer.Conf;
import org.eclipse.swt.widgets.Spinner;

public class Cmp_BlogSettings extends Composite {

	private Group group = null;
	private Label label = null;
	private Text textUsername = null;
	private Label label1 = null;
	private Text textPassword = null;
	private Label label2 = null;
	private Text textAddress = null;
	private Label label3 = null;
	private Combo combo = null;
	private Label label4 = null;
	private Spinner spinnerID = null;
	public Cmp_BlogSettings(Composite parent, int style) {
		super(parent, style);
		initialize();
		loadFormData();
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
		GridData gridData11 = new GridData();
		gridData11.horizontalAlignment = GridData.FILL;
		gridData11.grabExcessHorizontalSpace = true;
		gridData11.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.horizontalAlignment = GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.verticalAlignment = GridData.CENTER;
		gridData1.horizontalAlignment = GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		group = new Group(this, SWT.NONE);
		group.setText("Blog Settings");
		group.setLayout(gridLayout);
		group.setLayoutData(gridData);
		label = new Label(group, SWT.NONE);
		label.setText("Username");
		textUsername = new Text(group, SWT.BORDER);
		textUsername.setLayoutData(gridData1);
		label1 = new Label(group, SWT.NONE);
		label1.setText("Password");
		textPassword = new Text(group, SWT.BORDER | SWT.PASSWORD);
		textPassword.setLayoutData(gridData2);
		label2 = new Label(group, SWT.NONE);
		label2.setText("Address");
		textAddress = new Text(group, SWT.BORDER);
		textAddress.setLayoutData(gridData11);
		label3 = new Label(group, SWT.NONE);
		label3.setText("RPC ype");
		createCombo();
		label4 = new Label(group, SWT.NONE);
		label4.setText("ID");
		spinnerID = new Spinner(group, SWT.NONE);
		spinnerID.setSelection(1);

	}

	/**
	 * This method initializes combo
	 *
	 */
	private void createCombo() {
		combo = new Combo(group, SWT.NONE);
		combo.setText("meta Weblog API");
		combo.setEnabled(false);
	}
	public String[] getFormData() {
		return new String[]{textUsername.getText(),textPassword.getText(),textAddress.getText()};

	}
	public void saveFormData() {
		Conf.getInstance().setBlogAddress(textAddress.getText());
		Conf.getInstance().setBlogNumber(spinnerID.getText());
		Conf.getInstance().setBlogPassword(textPassword.getText());
		Conf.getInstance().setBlogUserName(textUsername.getText());
	}
	private void loadFormData() {
		textAddress.setText(Conf.getInstance().getBlogAddress());
		textPassword.setText(Conf.getInstance().getBlogPassword());
		textUsername.setText(Conf.getInstance().getBlogUserName());
		//spinnerID.setSelection(Integer.parseInt(Conf.getInstance().getBlogNumber()));

	}

}
