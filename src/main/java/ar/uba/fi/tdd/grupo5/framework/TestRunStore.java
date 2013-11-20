package ar.uba.fi.tdd.grupo5.framework;

import java.util.Collection;

public interface TestRunStore {
	void save();
	
	boolean load();
	
	void setPath(String path);
	
	Collection<TestResult> getAllTestResults();

	public void addAllTestResults(Collection<TestResult> results);
			
}
