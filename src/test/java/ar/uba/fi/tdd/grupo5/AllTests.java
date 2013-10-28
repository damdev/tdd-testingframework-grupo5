package ar.uba.fi.tdd.grupo5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAssert.class, TestAssertionFailedException.class,
		TestTestCase.class, TestTestResult.class, TestTestSuite.class,
		TestTimer.class })
public class AllTests {

}
