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
package pl.vdl.azbest.timer;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Display;

import pl.vdl.azbest.timer.counter.worker.ClockData;
import pl.vdl.azbest.timer.counter.worker.ClockListener;

/**General configuration */
public class Conf implements ClockListener{
	private Logger logger = Logger.getLogger(getClass().getName());
	private static Conf instance;

	private boolean isNewAlarmShellOpen = false;

	private boolean isTestSettingsShellOpen = false;

	private boolean isDataTableShellOpen;

	private boolean isDataCollectorOn = false;

	private boolean shell_statvindowOpned = false;
	private boolean Cmd_OpenBlogSettingsWindowIsOpened = false;


	private boolean RButtonOpened = false;

	private boolean allowBlank = false;

	private String blogUserName="mrtomato";
	private String blogPassword="mrt0mat0";
	private String blogAddress="http://mrtomato.wordpress.com/xmlrpc.php";

	private String blogNumber="1";



	private Set<String> dataTableColumns = new HashSet<String>();

	private String testSource = "NA";
	private String testSubject = "NA";
	private String testExam = "NA";

	public String getTestExam() {
		return testExam;
	}

	public void setTestExam(String testExam) {
		this.testExam = testExam;
	}

	public String getTestSource() {
		return testSource;
	}

	public void setTestSource(String testSource) {
		this.testSource = testSource;
	}

	public String getTestSubject() {
		return testSubject;
	}

	public void setTestSubject(String testSubject) {
		this.testSubject = testSubject;
	}

	public boolean isAllowBlank() {
		return allowBlank;
	}

	public boolean isShell_statvindowOpned() {
		return shell_statvindowOpned;
	}

	public void setShell_statvindowOpned(boolean shell_statvindowOpned) {
		this.shell_statvindowOpned = shell_statvindowOpned;
	}

	public void setAllowBlank(boolean allowBlank) {
		this.allowBlank = allowBlank;
	}

	public boolean isRButtonOpened() {
		return RButtonOpened;
	}

	public void setRButtonOpened(boolean buttonOpened) {
		RButtonOpened = buttonOpened;
	}

	private Conf() {
		logger.debug("Conf Created.");
	}

	public boolean isDataTableShellOpen() {
		return isDataTableShellOpen;
	}

	public void setDataTableShellOpen(boolean isDataTableShellOpen) {
		this.isDataTableShellOpen = isDataTableShellOpen;
	}

	public static Conf getInstance() {

		if (instance == null) {
			Logger.getRootLogger().warn("Conf class call. - instance is null");
			instance = new Conf();
			return instance;
		} else {
			Logger.getRootLogger().debug("Conf class call.");
			return instance;
		}
	}

	private Display display = null;

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public boolean isDataCollectorOn() {
		return isDataCollectorOn;
	}

	public void setDataCollectorOn(boolean isDataCollectorOn) {
		this.isDataCollectorOn = isDataCollectorOn;
	}

	public boolean isNewAlarmShellOpen() {
		return isNewAlarmShellOpen;
	}

	public void setNewAlarmShellOpen(boolean isNewAlarmShellOpen) {
		logger.debug("alarm shel opened");
		this.isNewAlarmShellOpen = isNewAlarmShellOpen;

	}

	public boolean isTestSettingsShellOpen() {
		return isTestSettingsShellOpen;
	}

	public void setTestSettingsShellOpen(boolean isTestSettingsShellOpen) {
		this.isTestSettingsShellOpen = isTestSettingsShellOpen;
	}

	private String timerTime = "00:00:00";
	public void update(ClockData cd) {
		timerTime = ""+cd.getHours()+":"+cd.getMinutes()+":"+cd.getSeconds();

	}

	public  String getTimerTime() {
		return timerTime;
	}

	public Set<String> getDataTableColumns() {
		return dataTableColumns;
	}

	public void setDataTableColumns(Set<String> dataTableColumns) {
		this.dataTableColumns = dataTableColumns;
	}

	public String getBlogUserName() {
		return blogUserName;
	}

	public void setBlogUserName(String blogUserName) {
		this.blogUserName = blogUserName;
	}

	public String getBlogPassword() {
		return blogPassword;
	}

	public void setBlogPassword(String blogPassword) {
		this.blogPassword = blogPassword;
	}

	public String getBlogAddress() {
		return blogAddress;
	}

	public void setBlogAddress(String blogAddress) {
		this.blogAddress = blogAddress;
	}

	public String getBlogNumber() {
		return blogNumber;
	}

	public void setBlogNumber(String blogNumber) {
		this.blogNumber = blogNumber;
	}

	public boolean isCmd_OpenBlogSettingsWindowIsOpened() {
		return Cmd_OpenBlogSettingsWindowIsOpened;
	}

	public void setCmd_OpenBlogSettingsWindowIsOpened(
			boolean cmd_OpenBlogSettingsWindowIsOpened) {
		Cmd_OpenBlogSettingsWindowIsOpened = cmd_OpenBlogSettingsWindowIsOpened;
	}
	public String getCurrentDate(){
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(0);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
				new Locale("pl", "PL"));
		DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
				new Locale("pl", "PL"));

		String time = df.format(c.getTime());
		String date = tf.format(c.getTime());

		logger.info(time + date + c.get(Calendar.SECOND));
		String name = time + "_" + date + "-" + c.get(Calendar.SECOND);
		name = name.replace('.', '-');
		name = name.replace(':', '-');
		return name;
	}



}