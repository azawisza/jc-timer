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

import pl.vdl.azbest.timer.counter.CCounting;
import pl.vdl.azbest.timer.counter.CIdle;
import pl.vdl.azbest.timer.counter.Counter;
import pl.vdl.azbest.timer.counter.CounterState;
import pl.vdl.azbest.timer.counter.IllegalCounterStateException;
import junit.awtui.TestRunner;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestCounter extends TestCase{
	public void testCreateCounter() {
		assertNotNull(Counter.getInstance());
		assertTrue(Counter.getInstance() instanceof Counter);
		assertSame(Counter.getInstance(),Counter.getInstance());

	}
	public void testCounterIdle() {
		assertTrue(Counter.getInstance().stop() instanceof CIdle );
		assertTrue(Counter.getInstance().reset() instanceof CIdle );
		assertTrue(Counter.getInstance().resume() instanceof CIdle );
		assertTrue(Counter.getInstance().start() instanceof CCounting );
		//moving to counting
	}
	public void testCounterCounting() {
		//assertTrue(Counter.getInstance().stop() instanceof CIdle );
		//assertTrue(Counter.getInstance().reset() instanceof CIdle );
		//assertTrue(Counter.getInstance().resume() instanceof CIdle );
		//assertTrue(Counter.getInstance().start() instanceof CCounting );

	}
	public static void main(String[] args) {
		//junit.awtui.TestRunner.run(new TestSuite(TestCounter.class));
		junit.awtui.TestRunner.run(TestCounter.class);
	}


}
