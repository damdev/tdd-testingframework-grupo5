package ar.uba.fi.tdd.grupo5;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Test {
	
	private List<Test> myTests = new ArrayList<Test>();
	
	public TestSuite(){
		
	}
	
	public void add(Test test){
		myTests.add(test);
	}
	@Override
	void run() {
		for (Test testCase : myTests){
			testCase.run();
		}

	}

	@Override
	TestResult getResult() {
		return new TestResult(this);
	}

}
