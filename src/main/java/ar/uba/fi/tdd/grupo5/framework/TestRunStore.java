package ar.uba.fi.tdd.grupo5.framework;

import java.util.Collection;

public interface TestRunStore {
	
	/**
	 * Write the content to some kind of storage
	 * 
	 */
	
	void save();
	
	/**
	 * Read the content previously saved
	 * 
	 */
	
	boolean load();
	
	/**
	 * Set path to storage file
	 *
	 * @param path
	 * 			the path of the file that is going to be written
	 */
	
	void setPath(String path);
	
	/**
	 * Obtain all the TestResult objects previously loaded
	 *
	 * @return Collection with all the TestResult objects
	 * 
	 * @see TestResult, Collection
	 */
	
	Collection<TestResult> getAllTestResults();

	/**
	 * Stores all the TestResult objects in results
	 * 
	 * @param results
	 *            the results being stored
	 */
	
	public void addAllTestResults(Collection<TestResult> results);
			
}
