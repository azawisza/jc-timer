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
package pl.vdl.azbest.timer.alarm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;


public class AlarmClock implements AlarmSubject {
	private Logger logger = Logger.getLogger(getClass().getName());
	private HashMap<Long, AlarmScheduler> alarms = new HashMap<Long, AlarmScheduler>();

	private ArrayList<AlarmListener> alarmListeners = new ArrayList<AlarmListener>();

	private volatile AlarmData data = null;

	private static AlarmClock instance = null;

	private AlarmClock() {
	}

	public static AlarmClock getInstance() {
		if (instance == null) {
			instance = new AlarmClock();
			return instance;
		} else {
			return instance;
		}
	}

	public void addAlarmListener(AlarmListener alarmListener) {
		alarmListeners.add(alarmListener);
	}

	public void removeAlarmListener(AlarmListener alarmListener) {
		alarmListeners.remove(alarmListener);
	}

	public synchronized void notifyAlarmListener() {
		for (AlarmListener al : alarmListeners) {
			if (data != null)
				al.update(data);
		}
	}

	private class AlarmScheduler extends Thread {
		private AlarmData data;

		public AlarmData getData() {
			return data;
		}

		public void setData(AlarmData data) {
			this.data = data;
		}

		public AlarmScheduler(AlarmData data) {
			this.data = data;

		}

		public boolean peform = true;

		@Override
		public void run() {
			Thread.currentThread().setName("AlarmClockThread");
			Calendar time = data.getAlarmTime();
			Calendar currentTime = Calendar.getInstance();
			currentTime.setTime(new Date());
			long aTime = time.getTimeInMillis();
			long dt = aTime - currentTime.getTimeInMillis();
			logger.info("Alarm sheduler started ..." + dt + " "
					+ data.toString());
			if (dt <= 0) {
				updateState(data);

				return;
			} else {
				// we gonna wait
				while (true) {
					try {
						Thread.sleep(1 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (peform) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						long cTime = cal.getTimeInMillis();
						if (aTime - cTime <= 0) {
							updateState(data);
							logger.info("Alarm sheduler ended");
							return;
						}
					}else {
						return;
					}

				}

			}// waiter
		}
	}

	public void scheduleAlarm(AlarmData data) {
		alarms.put(data.getAlarmTime().getTimeInMillis(), new AlarmScheduler(
				data));
		alarms.get(data.getAlarmTime().getTimeInMillis()).start();
	}

	public void unscheduleAlarm(AlarmData data) {
		logger.debug("scheduled alarm number: " + alarms.size());
		logger.info("Removing alarm");
		alarms.get(data.getAlarmTime().getTimeInMillis()).peform=false;
		alarms.remove(data.getAlarmTime().getTimeInMillis());
		logger.debug("scheduled alarm number: " + alarms.size());

	}

	private synchronized void updateState(AlarmData data) {
		this.data = data;
		notifyAlarmListener();
		this.data = null;
		alarms.remove(data.getAlarmTime().getTimeInMillis());
	}

	public List<AlarmData> getScheduledAlarms() {
		List<AlarmData> alist = new ArrayList<AlarmData>();
		for (long key : alarms.keySet()) {

			AlarmScheduler as = alarms.get(key);
			AlarmData adata = as.getData();
			alist.add(adata);
		}
		return alist;
	}

}
