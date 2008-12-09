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
package pl.vdl.azbest.timer.test;

import junit.framework.Test;
import junit.framework.TestSuite;

//First create class that extends test suite
public class TimerTestSuite extends TestSuite {
	// inside of it write suite() meth that returns Test object
	public static Test suite() {
		// Write TestSuite and add test case classess, you can optionally
		// override global teradown and setup.
		TestSuite testSuite = new TestSuite() {
			// big set up for whole suite
			protected void setUp() {
				System.err.println("Setting up");
			}

			// big tear down for whole suite
			protected void tearDown() {
				System.err.println("tearing down");
			}
		};
		testSuite.addTestSuite(TestClock.class);//Adding test cases.
		testSuite.addTestSuite(TestCounter.class);
		return testSuite;
	}

}
