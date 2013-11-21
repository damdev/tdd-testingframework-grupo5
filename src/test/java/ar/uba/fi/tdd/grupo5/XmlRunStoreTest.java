package ar.uba.fi.tdd.grupo5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import ar.uba.fi.tdd.grupo5.framework.TestResult;
import ar.uba.fi.tdd.grupo5.framework.XmlRunStore;

import org.junit.Test;

import static junit.framework.Assert.*;

public class XmlRunStoreTest {
	
	@Test
	public void getSameTestName() {
		XmlRunStore runStore = new XmlRunStore();
		TestResult result = new TestResult("result", true, false, 10);
		ArrayList<TestResult> results = new ArrayList<TestResult>();
		results.add(result);
		runStore.addAllTestResults(results);
		Collection<TestResult> results2 = runStore.getAllTestResults();
		Iterator<TestResult> it = results2.iterator();
		TestResult resultLoaded = it.next();
		assertEquals(result.getTestName(), resultLoaded.getTestName());
	}
	
	
}
