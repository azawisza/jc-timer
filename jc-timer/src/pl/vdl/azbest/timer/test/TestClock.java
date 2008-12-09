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

import pl.vdl.azbest.timer.counter.worker.Clock;
import pl.vdl.azbest.timer.counter.worker.ClockData;
import sun.net.www.content.text.plain;
import junit.framework.TestCase;

/** simple test class for {@link pl.vdl.azbest.timer.counter.worker.Clock} class */
public class TestClock extends TestCase {
	public void testCreateClock() {
		// testing singleton
		assertNotNull("Clock obtained should not be null", Clock.getInstance());
		assertTrue("Clock obtained should be instance of Clock", Clock
				.getInstance() instanceof Clock);
		assertSame("It is singleton - we ought to have only one Clock", Clock
				.getInstance(), Clock.getInstance());
	}
	public void testClearClock() throws CloneNotSupportedException {
		// testing clear()
		Clock.getInstance().clear();
		assertEquals("Min=0", 0, Clock.getInstance().getMin());
		assertEquals("Hrs=0", 0, Clock.getInstance().getHrs());
		assertEquals("Sec=0", 0, Clock.getInstance().getSec());
		assertTrue(
				"We shoud always have plusable minutes and seconds and hours",
				(Clock.getInstance().getHrs() * Clock.getInstance().getMin() * Clock
						.getInstance().getSec()) >= 0);
		//
		assertTrue(Clock.getInstance().getClockData() instanceof ClockData);
		clone();

	}
	public void testStopClock() {
		// test stopping start
		Clock.getInstance().start();
		assertFalse(Clock.getInstance().isStop());
		// test stop
		Clock.getInstance().stop();
		assertTrue(Clock.getInstance().isStop());
		// testing progress - howto ? using sleep()?
	}
}
