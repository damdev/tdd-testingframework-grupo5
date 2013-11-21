package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;
import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public class TimeRestrictionTest {
	private class MySimpleTest extends TestCase {
		public MySimpleTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
		}
	}
	

	private class MySuite extends TestSuite {
		public MySuite() {
			super("MySuite");
		}
	}

	
	@Test
	public void runTestBelowTimeRestrictionSucceeds() {
		MySimpleTest testCase = new MySimpleTest("test");
		testCase.setTimeLimit(10000);
		MySuite suite = new MySuite();
		try {
			suite.add(testCase);
			suite.run();
			Assert.assertEquals(0, suite.countErrorTestCases());
			Assert.assertEquals(0, suite.countFailTestCases());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void runTestPastTimeRestrictionFails() {
		MySimpleTest testCase = new MySimpleTest("test");
		testCase.setTimeLimit(10);
		MySuite suite = new MySuite();
		try {
			suite.add(testCase);
			suite.run();
			assertEquals(1, suite.countFailTestCases());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
