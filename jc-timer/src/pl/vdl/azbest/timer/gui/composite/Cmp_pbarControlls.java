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
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolItem;

import pl.vdl.azbest.timer.cmd.Cmd_uiDiggIT;
import pl.vdl.azbest.timer.cmd.Cmd_uiPause;
import pl.vdl.azbest.timer.cmd.Cmd_uiRestart;
import pl.vdl.azbest.timer.cmd.Cmd_uiStart;
import pl.vdl.azbest.timer.cmd.Cmd_uiStop;
import pl.vdl.azbest.timer.cmd.Command;
import pl.vdl.azbest.timer.cmd.Invoker;

public class Cmp_pbarControlls extends Composite {

	private ToolBar toolBar = null;

	public Cmp_pbarControlls(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createToolBar();
		setSize(new Point(173, 31));
		setLayout(new GridLayout());
	}

	/**
	 * This method initializes toolBar
	 *
	 */
	private void createToolBar() {
		toolBar = new ToolBar(this, SWT.FLAT);
		ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
		toolItem.setText("Start");
		ToolItem toolItem3 = new ToolItem(toolBar, SWT.PUSH);
		toolItem3.setText("Pause");
		toolItem.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				Command c = new Cmd_uiStart();
				Invoker.getInstance().addCommand(c);
				Invoker.getInstance().execute();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});

		ToolItem toolItem1 = new ToolItem(toolBar, SWT.PUSH);
		toolItem1.setText("Stop");
		toolItem1.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				Command c = new Cmd_uiStop();
				Invoker.getInstance().addCommand(c);
				Invoker.getInstance().execute();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		ToolItem toolItem2 = new ToolItem(toolBar, SWT.PUSH);
		toolItem2.setText("Restart");
		toolItem2.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				Command c = new Cmd_uiRestart();
				Command c2 = new Cmd_uiDiggIT(true);
				Invoker.getInstance().addCommand(c2);
				//Invoker.getInstance().addCommand(c);
				/*Invoker.getInstance().execute();


				Invoker.getInstance().addCommand(c);
				Invoker.getInstance().execute();*/

			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
		toolItem3.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				Command c = new Cmd_uiPause();
				Invoker.getInstance().addCommand(c);
				Invoker.getInstance().execute();
			}
			public void widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent e) {
			}
		});
	}

}  //  @jve:decl-index=0:visual-constraint="10,20"
