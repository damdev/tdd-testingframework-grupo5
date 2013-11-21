package ar.uba.fi.tdd.grupo5;

import java.util.ArrayList;
import java.util.Collection;

import ar.uba.fi.tdd.grupo5.framework.NotSucceedTestsRunMode;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestResult;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

import org.junit.Test;

import static junit.framework.Assert.*;

public class NotSucceedRunModeTest {
	private class MySimpleTest extends TestCase {
		public MySimpleTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
		}
	}
	
	@Test
	public void shouldRunErrorTestTest() {
		TestCase test = new MySimpleTest("simple test");
		Collection<TestResult> results = new ArrayList<TestResult>();
		TestResult result = new TestResult("simple test", false, true, 10);
		results.add(result);
		NotSucceedTestsRunMode runMode = new NotSucceedTestsRunMode(results);
		assertTrue(runMode.shouldRunTest(test));
	}
	
	@Test
	public void shouldRunFailedTestTest() {
		TestCase test = new MySimpleTest("simple test");
		Collection<TestResult> results = new ArrayList<TestResult>();
		TestResult result = new TestResult("simple test", true, false, 10);
		results.add(result);
		NotSucceedTestsRunMode runMode = new NotSucceedTestsRunMode(results);
		assertTrue(runMode.shouldRunTest(test));
	}
	
	@Test
	public void shouldNotRunSucceedTestTest() {
		TestCase test = new MySimpleTest("simple test");
		Collection<TestResult> results = new ArrayList<TestResult>();
		TestResult result = new TestResult("simple test", false, false, 10);
		results.add(result);
		NotSucceedTestsRunMode runMode = new NotSucceedTestsRunMode(results);
		assertFalse(runMode.shouldRunTest(test));
	}
	
}
