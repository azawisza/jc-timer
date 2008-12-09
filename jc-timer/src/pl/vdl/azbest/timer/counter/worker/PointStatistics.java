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
package pl.vdl.azbest.timer.counter.worker;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class PointStatistics {
	// TimeStatistics
	private int points = 0;
	private int pid = 0;
	private HashMap<Integer, Integer> pHsitory = new HashMap<Integer, Integer>();
	private static PointStatistics instance = null;
	private Logger logger = Logger.getLogger(getClass().getName());
	private PointStatistics() {
	}

	public static PointStatistics getInstance() {
		if (instance == null) {
			instance = new PointStatistics();
			return instance;
		} else {
			return instance;
		}
	}

	public void advancePoints(int i) {
		pid++;
		pHsitory.put(pid, i);
		if (i == 1970) {
			resetPoints();
			return;
		}
		points += i;
	}

	public String getFactor() {
		double p = points;
		logger.info(p + " - " + pHsitory.size() + " -"
				+ (p / pHsitory.size()));
		return "" + p / pHsitory.size();
	}

	public int getPoints() {
		return points;
	}

	public void resetPoints() {
		points = 0;
		pHsitory.clear();
	}

}
