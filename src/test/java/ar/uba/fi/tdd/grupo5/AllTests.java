package ar.uba.fi.tdd.grupo5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AssertTest.class, AssertionFailedExceptionTest.class,
		TestCaseTest.class, TestResultTest.class, TestSuiteTest.class,
		TimerTest.class })
public class AllTests {

}
