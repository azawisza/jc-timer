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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.SWT;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.cmd.Cmd_CaptureClipboardToFile;
import pl.vdl.azbest.timer.cmd.Cmd_blogClipboardContent;
import pl.vdl.azbest.timer.cmd.Cmd_blogOpenSettingsWindow;
import pl.vdl.azbest.timer.cmd.Cmd_openNewAlarmShell;
import pl.vdl.azbest.timer.cmd.Cmd_uiClearTestCollector;
import pl.vdl.azbest.timer.cmd.Cmd_uiOpenDataTableShell;
import pl.vdl.azbest.timer.cmd.Cmd_uiOpenStatWindow;
import pl.vdl.azbest.timer.cmd.Cmd_uiOpenTestSettingsWindow;
import pl.vdl.azbest.timer.cmd.Cmd_uiPause;
import pl.vdl.azbest.timer.cmd.Cmd_uiRestart;
import pl.vdl.azbest.timer.cmd.Cmd_uiSaveToFile;
import pl.vdl.azbest.timer.cmd.Cmd_uiStart;
import pl.vdl.azbest.timer.cmd.Cmd_uiStop;
import pl.vdl.azbest.timer.cmd.Command;
import pl.vdl.azbest.timer.cmd.Invoker;
import pl.vdl.azbest.timer.cmd.Stop;
import pl.vdl.azbest.timer.counter.worker.TestQuestDataCollector;
import pl.vdl.azbest.timer.counter.worker.TimeStatistics;
import pl.vdl.azbest.timer.gui.composite.Cmp_Buttons;
import pl.vdl.azbest.timer.gui.composite.Cmp_Clock;
import pl.vdl.azbest.timer.gui.composite.Cmp_progressBar;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class SWTTimer extends SWTElement {

	// private Shell sShell = null; //
	// @jve:decl-index=0:visual-constraint="282,183"
	Composite composite1 = null;
	private Logger logger = Logger.getLogger(getClass().getName());
	Composite composite2 = null;

	Composite composite4 = null;

	Composite composite5 = null;

	Composite composite3 = null;

	private Menu menuBar = null;

	private Menu submenu = null;

	/**
	 * This method initializes sShell
	 */
	@Override
	protected void createSShell() {
		sShell = new Shell(SWT.BORDER | SWT.SHELL_TRIM | SWT.ON_TOP);
		sShell.setText("JCTimer");
		WIN_HEIGHT = 250;
		WIN_WIDTH = 300;
		sShell.setSize(new Point(300, 250));
		sShell.setLayout(new GridLayout());
		menuBar = new Menu(sShell, SWT.BAR);

		MenuItem submenuItem = new MenuItem(menuBar, SWT.CASCADE);
		submenuItem.setText("File");
		submenu = new Menu(submenuItem);
		MenuItem check = new MenuItem(submenu, SWT.CHECK);
		check.setText("RESET button");
		MenuItem push1 = new MenuItem(submenu, SWT.PUSH);
		push1.setText("Save ...");
		MenuItem push4 = new MenuItem(submenu, SWT.PUSH);
		push4.setText("Data browser");
		@SuppressWarnings("unused")
		MenuItem separator1 = new MenuItem(submenu, SWT.SEPARATOR);
		MenuItem push = new MenuItem(submenu, SWT.PUSH);
		push.setText("Statistics");
		MenuItem push5 = new MenuItem(submenu, SWT.PUSH);
		push5.setText("02:30 progress bar");

		//Cmd_uiClearTestCollector
		MenuItem push6 = new MenuItem(submenu, SWT.PUSH);
		push6.setText("Add alarm");
		push6
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_openNewAlarmShell();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();

					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		push5
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Shl_ProgressBar bar = new Shl_ProgressBar();
						bar.openSWTWidget();

					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		push
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {

						Command c = new Cmd_uiOpenStatWindow();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();

					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		push4
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiOpenDataTableShell();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();

					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		submenuItem.setMenu(submenu);
		check
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Shell_RestartButton.getInstance()
								.openSWTWidgetSingleton(
										Conf.getInstance().isRButtonOpened());
						Conf.getInstance().setRButtonOpened(true);

					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		push1
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {

						FileDialog fd = new FileDialog(sShell, SWT.SAVE);
						fd.setFilterExtensions(new String[] { ".txt" });
						fd.open();

						String path = fd.getFilterPath()
								+ System.getProperty("file.separator")
								+ fd.getFileName();

						logger.info(path
								+ "\n"
								+ TestQuestDataCollector.getInstance()
										.getTableDataAsHTMLTable());

						Command c = new Cmd_uiSaveToFile(TestQuestDataCollector
								.getInstance().getTableDataAsHTMLTable(), path);
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		sShell.setMenuBar(menuBar);
		sShell.addShellListener(new org.eclipse.swt.events.ShellAdapter() {
			@Override
			public void shellClosed(org.eclipse.swt.events.ShellEvent e) {
				Stop.perform();
			}
		});

		MenuItem push7 = new MenuItem(submenu, SWT.PUSH);
		push7.setText("Test settings");
		push7
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiOpenTestSettingsWindow();
						Invoker.getInstance().addCommand(c);

					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});


//		Cmd_uiClearTestCollector
		MenuItem push8 = new MenuItem(submenu, SWT.PUSH);
		push8.setText("Clear data.");
		push8
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiClearTestCollector();
						Invoker.getInstance().addCommand(c);


					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		MenuItem push9 = new MenuItem(submenu, SWT.PUSH);
		push9.setText("Open Blog settings");
		push9
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_blogOpenSettingsWindow();
						Invoker.getInstance().addCommand(c);


					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});

		init();
	}

	private void init() {
		createComposite2();
		createComposite1();
		createComposite3();
		// createComposite4();
		// createComposite5();

		lockSWTWidgetSize();
		setSWTWidgetPositionCenetr(0, 0);

		Conf.getInstance().setDisplay(sShell.getDisplay());
		GUIFacade.getInstance().setSwTimer(this);
		tryIt();

	}

	private void createComposite2() {

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite2 = new Cmp_Clock(sShell, SWT.NONE);
		composite2.setLayout(new GridLayout());
		composite2.setLayoutData(gridData1);
	}

	private void createComposite1() {

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite1 = new Cmp_Buttons(sShell, SWT.NONE);
		composite1.setLayout(new GridLayout());
		composite1.setLayoutData(gridData1);
	}

	private void createComposite3() {

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalAlignment = GridData.FILL;
		composite3 = new Cmp_progressBar(sShell, SWT.NONE);
		composite3.setLayout(new GridLayout());
		composite3.setLayoutData(gridData1);
	}

	private void tryIt() {
		Tray appTray = display.getSystemTray();

		Image trayImg = new Image(display, "tary_icon.gif");
		TrayItem item = new TrayItem(appTray, SWT.NONE);
		item.setImage(trayImg);
		final Menu menu = new Menu(sShell, SWT.POP_UP);
		MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Open window");
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						sShell.setMinimized(false);
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});

		menuItem = new MenuItem(menu, SWT.SEPARATOR);

		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Start");
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiStart();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});

		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Stop");
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiStop();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Pause");
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiPause();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Restart");
		@SuppressWarnings("unused")
		MenuItem separator = new MenuItem(menu, SWT.SEPARATOR);
		MenuItem push2 = new MenuItem(menu, SWT.PUSH);
		push2.setText("Show stat");
		push2
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiOpenStatWindow();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();

					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		MenuItem push3 = new MenuItem(menu, SWT.PUSH);
		push3.setText("Reset stat");
		push3
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						TimeStatistics.getInstance().reset();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command c = new Cmd_uiRestart();
						Invoker.getInstance().addCommand(c);
						Invoker.getInstance().execute();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});

		item.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				menu.setVisible(true);
			}
		});
		item.addListener(SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				menu.setVisible(true);
			}
		});
		menuItem = new MenuItem(menu, SWT.SEPARATOR);
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Restore All");
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						sShell.setMinimized(false);
						GUIFacade.getInstance().maxmizeAll();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Minimalize All");
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						sShell.setMinimized(true);
						GUIFacade.getInstance().minimalizeAll();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Capture image");
		menuItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						Command cmd = new Cmd_CaptureClipboardToFile();
						Invoker.getInstance().addCommand(cmd);
						Invoker.getInstance().execute();
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("Blog clippboard content");
		menuItem
		.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
			public void widgetSelected(
					org.eclipse.swt.events.SelectionEvent e) {
				Command cmd = new Cmd_blogClipboardContent();
				Invoker.getInstance().addCommand(cmd);
				Invoker.getInstance().execute();
			}

			public void widgetDefaultSelected(
					org.eclipse.swt.events.SelectionEvent e) {
			}
		});

	}

	public void settitleClock(String titleClock) {
		sShell.setText(titleClock);
	}

}
