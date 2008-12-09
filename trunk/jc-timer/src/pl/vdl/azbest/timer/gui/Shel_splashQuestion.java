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

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class Shel_splashQuestion extends SWTElement {

	// private Shell sShell = null; //
	// @jve:decl-index=0:visual-constraint="10,10"
	private Label label = null;

	/**
	 * This method initializes sShell
	 */
	@Override
	protected void createSShell() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.CENTER;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		sShell = new Shell(SWT.MODELESS | SWT.ON_TOP);
		sShell.setText("Shell");
		sShell.setSize(new Point(300, 94));
		sShell.setLayout(new GridLayout());
		label = new Label(sShell, SWT.NONE);

		label.setFont(new Font(Display.getDefault(), "Microsoft Sans Serif",
				14, SWT.NORMAL));
		label.setLayoutData(gridData);
		setSWTWidgetPositionCenetr(0, 0);
		label.setText(txt);
		final Timer t = new Timer();

		t.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					Thread.currentThread().setName("SplashScreenWaitThread");
					Thread.sleep(sec);

					sShell.getDisplay().syncExec(new Runnable() {
						public void run() {
							sShell.close();
						}
					});
					t.cancel();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, sec);

	}

	public void showSplash(String txt, int sec) {

		this.txt = txt;
		this.sec = sec;
		openSWTWidget();

	}

	private String txt = "";
	private int sec = 1000;

}
