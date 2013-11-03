package ar.uba.fi.tdd.grupo5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AssertExceptionTest.class, AssertTest.class, TimerTest.class,
		TestResultTest.class, TestCaseTest.class, TestSuiteTest.class,
		TwoLevelTestSuiteTest.class })
public class AllTests {

}
