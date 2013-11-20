package ar.uba.fi.tdd.grupo5.framework;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sebastian
 * Date: 18/11/13
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public abstract class TestRunMode {

    private List<TestResult> lastResults;


    public abstract void setTestsToBeRunned(TestSuite testSuite);

    public abstract boolean shouldRunTest(Test test);

    public boolean testExists(Test test) {
        for(TestResult currentResult : lastResults) {
            if(currentResult.getTestName().equals(test.getName())) {
                return true;
            }
        }
        return false;
    }

    protected TestResult getTestResultByName(String testName) {
        for(TestResult currentResult : lastResults) {
            if(currentResult.getTestName().equals(testName))
                return currentResult;
        }
        return null;
    }

    protected List<TestResult> getLastResults() {
        return lastResults;
    }

    protected void setLastResults(List<TestResult> results) {
        lastResults = results;
    }
}
