package ar.uba.fi.tdd.grupo5;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Test {
	
	private List<Test> tests = new ArrayList<>();
	
	public TestSuite(){
		
	}
	
	public void add(Test test){
		tests.add(test);
	}
	
	@Override
	void run() {
		for (Test test : tests){
			test.run();
		}
	}

	@Override
	TestResult getResult() {
		return new TestResult();
	}
}
