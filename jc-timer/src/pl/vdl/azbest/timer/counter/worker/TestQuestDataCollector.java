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

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class TestQuestDataCollector {
	private static TestQuestDataCollector instance = null;
	private Logger logger = Logger.getLogger(getClass().getName());
	private ArrayList<Map<String, String>> testQuestData = new ArrayList<Map<String, String>>();

	private TestQuestDataCollector() {
	}

	public static TestQuestDataCollector getInstance() {
		if (instance == null) {
			instance = new TestQuestDataCollector();
			return instance;
		} else {
			return instance;
		}
	}

	public void addRow(Map<String, String> data) {

		testQuestData.add(data);
	}

	public ArrayList<Map<String, String>> getTestQuestData() {
		return testQuestData;
	}

	public void setTestQuestData(ArrayList<Map<String, String>> testQuestData) {
		this.testQuestData = testQuestData;
	}

	public String getTableDataAsHTMLTable() {
		String output = "<table>";
		boolean title = false;

		if (testQuestData.size() > 0) {
			for (Map<String, String> map : testQuestData) {
				// setting table title
				if (!title) {
					output += "<tr>";
					for (Entry<String, String> en : map.entrySet()) {
						output += "<td><b>" + en.getKey() + "</b></td>";
					}
					output += "</tr>";
					title = true;
				}// title
				// setting table inhalt
				String rowStart = "";
				String rowBody = "";
				String rowEnd = "</tr>";

				// output += "<tr>";
				for (Entry<String, String> en : map.entrySet()) {
					rowBody += "<td>" + en.getValue() + "</td>";
					// colored background
					if (en.getKey().equals("Pass")) {
						if (en.getValue().equals("false")) {
							rowStart = "<tr BGCOLOR=\"#FF9B37\">";
						} else {
							rowStart = "<tr BGCOLOR=\"#A8CD8A\">";

						}
					}
				}
				output += rowStart + rowBody + rowEnd;
			}
		} else {
			logger.warn("No data to return, sending empty HTML table");
		}
		output += "</table>";

		return output;
	}

	public void clearColector() {
		this.testQuestData.clear();
	}

}
