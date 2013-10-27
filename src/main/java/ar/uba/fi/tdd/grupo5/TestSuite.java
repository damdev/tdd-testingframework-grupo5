package ar.uba.fi.tdd.grupo5;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
	
	private List<TestCase> tests = new ArrayList<>();
	private List<TestResult> results = new ArrayList<>();
	
	public TestSuite(){
		
	}
	
	public void add(TestCase test){
		tests.add(test);
	}
	
	public String run() {
		for (TestCase test : tests){
			results.add(test.run());
		}
		return generateResult();
	}
	
	private String generateResult() {
		/**
		 * TODO Implementar, hay que recorrer la lista de results y formatear
		 * 		en un string el resultado.
		 */
		return "";
	}
}
