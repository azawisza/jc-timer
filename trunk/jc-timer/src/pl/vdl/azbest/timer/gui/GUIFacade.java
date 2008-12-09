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

import java.util.ArrayList;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.alarm.AlarmClock;
import pl.vdl.azbest.timer.alarm.AlarmData;
import pl.vdl.azbest.timer.alarm.AlarmListener;
import pl.vdl.azbest.timer.counter.worker.ClockConcreteSubject;
import pl.vdl.azbest.timer.counter.worker.ClockData;
import pl.vdl.azbest.timer.counter.worker.ClockListener;
import pl.vdl.azbest.timer.counter.worker.PointStatistics;
import pl.vdl.azbest.timer.counter.worker.TimeStatistics;
import pl.vdl.azbest.timer.gui.composite.Cmp_Buttons;
import pl.vdl.azbest.timer.gui.composite.Cmp_Clock;
import pl.vdl.azbest.timer.gui.composite.Cmp_TestQuestForm;
import pl.vdl.azbest.timer.gui.composite.Cmp_TestQuestTable;
import pl.vdl.azbest.timer.gui.composite.Cmp_progressBar;

public class GUIFacade extends SWTElement implements ClockListener,
		AlarmListener {
	private Cmp_Buttons cmp_Buttons;

	private Cmp_Clock cmp_Clock;

	private Cmp_TestQuestForm cmp_TestQuestForm = null;

	private Shell_RestartButton shell_RestartButton = null;

	private ArrayList<Cmp_progressBar> cmp_progressBar = new ArrayList<Cmp_progressBar>();

	private Shell_Statistics shell_Statistics = null;

	private SWTTimer swTimer = null;

	private Shell_BlogSettings shell_BlogSettings = null;
	private ArrayList<Shell_PsotingBlogPostProgress> blogProgesLabels = new ArrayList<Shell_PsotingBlogPostProgress>();

	private static GUIFacade instance = null;

	private ArrayList<Shel_splashQuestion> shel_splashQuestion = new ArrayList<Shel_splashQuestion>();

	public void addPostingBlogProgressShell(Shell_PsotingBlogPostProgress shell) {
		this.blogProgesLabels.add(shell);
	}

	private void removePostingBlogProgressShell(Shell_PsotingBlogPostProgress shell) {
		this.blogProgesLabels.remove(shell);

	}


	@Override
	protected void createSShell() {
		sShell = swTimer.sShell;
	}

	public void showDialog(String txt) {
		sShell = swTimer.sShell;
		showInformationDialog(txt);
	}

	private GUIFacade() {

		ClockConcreteSubject.getInstance().addClockListener(this);
		AlarmClock.getInstance().addAlarmListener(this);

	}

	public static GUIFacade getInstance() {
		if (instance == null) {
			instance = new GUIFacade();
			return instance;
		} else {
			return instance;
		}
	}

	public void update(final ClockData data) {
		Conf.getInstance().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (cmp_Clock != null) {
					cmp_Clock.setTime(data.getHours(), data.getMinutes(), data
							.getSeconds());
					swTimer.settitleClock(data.getHours() + ":"
							+ data.getMinutes() + ":" + data.getSeconds());
				}

				// if (cmp_progressBar != null) {
				adavanceProgressBars();

				if (data.getSeconds().equals("00")
						&& data.getMinutes().equals("00")
						&& data.getHours().equals("00")) {
					clearProgrsBars();

				}
				// }

				if (shell_Statistics != null) {
					shell_Statistics.updateShellStatistics(TimeStatistics
							.getInstance().getStatQuestions(), TimeStatistics
							.getInstance().getStatElapsedTime(), TimeStatistics
							.getInstance().getTimePerQuest(), ""
							+ PointStatistics.getInstance().getPoints(), ""
							+ PointStatistics.getInstance().getFactor());

				}

			}

		});// sencexec
	}

	public Cmp_Buttons getCmp_Buttons() {
		return cmp_Buttons;
	}

	public void setCmp_Buttons(Cmp_Buttons cmp_Buttons) {
		this.cmp_Buttons = cmp_Buttons;
	}

	public Cmp_Clock getCmp_Clock() {
		return cmp_Clock;
	}

	public void setCmp_Clock(Cmp_Clock cmp_Clock) {
		this.cmp_Clock = cmp_Clock;
	}

	public ArrayList<Cmp_progressBar> getCmp_progressBar() {
		return cmp_progressBar;
	}

	public void setCmp_progressBar(Cmp_progressBar cmp_progressBar) {
		this.cmp_progressBar.add(cmp_progressBar);
	}

	public void setCmp_TestQuestForm(Cmp_TestQuestForm cmp_TestQuestForm) {
		this.cmp_TestQuestForm = cmp_TestQuestForm;
	}

	public void setCmpTestQuestTable(Cmp_TestQuestTable cmpTestQuestTable) {
	}

	public String[] getTestQuestDatafromGUI() {
		return cmp_TestQuestForm.getFormData();
	}

	public SWTTimer getSwTimer() {
		return swTimer;
	}

	public void setSwTimer(SWTTimer swTimer) {
		this.swTimer = swTimer;
	}

	public Shell_Statistics getShell_Statistics() {
		return shell_Statistics;
	}

	public void setShell_Statistics(Shell_Statistics shell_Statistics) {
		this.shell_Statistics = shell_Statistics;
	}

	public void minimalizeAll() {
		if (shell_Statistics != null)
			shell_Statistics.minimalize();
		if (shell_RestartButton != null)
			Shell_RestartButton.getInstance().minimalize();

	}

	public void maxmizeAll() {
		if (shell_Statistics != null)
			shell_Statistics.restore();
		if (shell_RestartButton != null)
			shell_RestartButton.restore();
	}

	public Shell_RestartButton getShell_RestartButton() {
		return shell_RestartButton;
	}

	public void setShell_RestartButton(Shell_RestartButton shell_RestartButton) {
		this.shell_RestartButton = shell_RestartButton;
	}

	public void addShel_splashQuestion(Shel_splashQuestion splash) {
		this.shel_splashQuestion.add(splash);
	}

	public void removeShel_splashQuestion(Shel_splashQuestion splash) {
		this.shel_splashQuestion.remove(splash);
	}

	public void update(final AlarmData data) {
		Conf.getInstance().getDisplay().asyncExec(new Runnable() {
			public void run() {
				showAlarmSplash(data);
			}
		});
	}

	private void showAlarmSplash(AlarmData data) {
		System.out.print("alarm : " + data.getAlarmText() + " : "
				+ data.getAlarmTime().getTime().toString());
		Shel_splashQuestion splash = new Shel_splashQuestion();
		splash.showSplash(data.getAlarmText() + " - "
				+ data.getAlarmTime().getTime().toString(), 10 * 1000);
	}

	private void adavanceProgressBars() {
		for (Cmp_progressBar bar : cmp_progressBar) {
			bar.advance();
		}
	}

	private void clearProgrsBars() {
		for (Cmp_progressBar bar : cmp_progressBar) {
			bar.clear();
		}
	}

	public Shell_BlogSettings getShell_BlogSettings() {
		return shell_BlogSettings;
	}

	public void setShell_BlogSettings(Shell_BlogSettings shell_BlogSettings) {
		this.shell_BlogSettings = shell_BlogSettings;
	}

}
