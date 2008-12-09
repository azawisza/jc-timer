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

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Event;

/** Defines basic SWT windows behavior */
public abstract class SWTElement {

	private Logger logger = Logger.getLogger(getClass().getName());
	protected Shell sShell = null;
	protected Display display = null;

	protected int WIN_WIDTH;
	protected int WIN_HEIGHT;
	protected String WIN_TITLE;

	private boolean isMouseUp = true;
	private boolean reallyCloseBox = false;
	private Listener SWTExitListener = null;

	private String doubtToExitReason = "";
	protected String REALLY_EXIT_MESSAGE = "Really exit ?";
	private String SWTExceptionSHOUT = "from SWTElement:"
			+ getClass().getName() + "  sShell is null!";

	protected abstract void createSShell();

	public void openSWTWidget() {
		display = org.eclipse.swt.widgets.Display.getDefault();
		this.createSShell();
		this.setSWTWidgetPositionCenetr(0, 0);
		if (this.sShell != null)
			this.sShell.open();
		else {
			throw (new SWTException(SWTExceptionSHOUT));
		}
	}

	public void openSWTWidgetSingleton(boolean isOpened) {
		display = org.eclipse.swt.widgets.Display.getDefault();
		if (!isOpened) {
			openSWTWidget();
		} else {
			// do nothing :)
		}
	}

	public void openSWTWidgetCustomDisplay(Display customDisplay) {
		this.display = customDisplay;
		this.createSShell();
		this.setSWTWidgetPositionCenetr(0, 0);
		if (this.sShell != null)
			this.sShell.open();
		else {
			throw (new SWTException(SWTExceptionSHOUT));
		}
	}

	public void openSWTWidgetStandAloneWithReallyClose() {
		this.reallyCloseBox = true;
		openSWTWidgetStandAlone();

	}

	public void openSWTWidgetWithReallyClose() {
		reallyCloseBox = true;
		enableReallyExitDialog();
	}

	public void openSWTWidgetStandAlone2() {
		this.display = new Display();
		Display.setAppName(this.WIN_TITLE);
		this.createSShell();
		if (reallyCloseBox)
			enableReallyExitDialog();
		this.setSWTWidgetPositionCenetr(10, -60);
		this.sShell.open();
		while (!sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	public void openSWTWidgetStandAlone() {
		// this.display =new Display();
		Display.setAppName(this.WIN_TITLE);
		this.createSShell();
		if (reallyCloseBox)
			enableReallyExitDialog();
		this.setSWTWidgetPositionCenetr(10, -60);
		this.sShell.open();
		while (!sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

	private void createSWTReallyExitListener() {
		SWTExitListener = new Listener() {
			public void handleEvent(Event event) {
				showReallyExitDialog(event);
			}
		};
	}

	public void setSWTWidgetPositionCenetr(int dx, int dy) {
		if (display != null && sShell != null) {
			Monitor primaryMONITOR = display.getPrimaryMonitor();
			Rectangle bounds = primaryMONITOR.getBounds();
			Rectangle boundsRectangle = sShell.getBounds();
			int x = bounds.x
					+ Math.max(0, (bounds.width - boundsRectangle.width) / 2);
			int y = bounds.y
					+ Math.max(0, (bounds.height - boundsRectangle.height) / 2);
			sShell.setBounds(x + dx, y + dy, boundsRectangle.width,
					boundsRectangle.height);
		} else {
			throw (new SWTException(SWTExceptionSHOUT));
		}
	}

	public void showInformationDialog(String reason) {
		int style = SWT.OK;
		style |= SWT.APPLICATION_MODAL;
		MessageBox box = new MessageBox(sShell, style);
		box.setText(sShell.getText());
		box.setMessage(reason);
		box.open();
	}

	public boolean showInformationDialogYN(String reason) {
		int style = SWT.ICON_QUESTION | SWT.YES | SWT.NO;

		MessageBox box = new MessageBox(sShell, style);
		box.setText(sShell.getText());
		box.setMessage(reason);
		if (SWT.NO == box.open()) {
			return false;
		}
		return true;

	}

	protected void lockSWTWidgetSize() {
		final Point endPoint = new Point(0, 0);
		sShell.addControlListener(new org.eclipse.swt.events.ControlAdapter() {
			@Override
			public void controlResized(org.eclipse.swt.events.ControlEvent e) {
				Point p = sShell.getSize();
				logger.info("Changing widget size ... - locking");
				endPoint.x = p.x;
				endPoint.y = p.y;
				if (endPoint.x < WIN_WIDTH || endPoint.y < WIN_HEIGHT) {
					if (isMouseUp)
						sShell.setSize(new Point(WIN_WIDTH, WIN_HEIGHT));
				}
			}
		});
	}

	public Display getSWTWidgetDisplay() {
		return this.display;
	}

	public void enableReallyExitDialog() {
		createSWTReallyExitListener();
		sShell.addListener(SWT.Close, SWTExitListener);
	}

	private void showReallyExitDialog(Event event) {
		if (doubtToExitReason.equals(""))
			return;
		int style = SWT.YES | SWT.NO;
		style |= SWT.APPLICATION_MODAL;
		MessageBox mbox = new MessageBox(sShell, style);
		mbox.setText(sShell.getText());
		mbox.setMessage(doubtToExitReason + " " + REALLY_EXIT_MESSAGE);
		switch (mbox.open()) {
		case SWT.YES:
			break;
		case SWT.NO:
			event.doit = false;
			break;
		}

	}

	public void setDoubtToExitReason(String reason) {
		this.doubtToExitReason = reason;
	}

	public void disableReallyExitDialog() {
		sShell.removeListener(SWT.Close, SWTExitListener);
		SWTExitListener = null;
	}

	protected void disposeWidget() {
		if (!this.sShell.isDisposed())
			this.sShell.dispose();
		else {
			throw (new SWTException("shell has been  disposed already"));
		}

	}

	public void closeWidget() {
		if (this.sShell != null)
			this.sShell.close();
		else {
			throw (new SWTException(SWTExceptionSHOUT));
		}
	}

}
