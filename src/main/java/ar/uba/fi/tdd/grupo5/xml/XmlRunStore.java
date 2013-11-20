package ar.uba.fi.tdd.grupo5.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.uba.fi.tdd.grupo5.framework.TestResult;
import ar.uba.fi.tdd.grupo5.framework.TestRunStore;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;

public class XmlRunStore implements TestRunStore {

	private TestResultsXml rootElement;
	private String buffer;
	private String filePath;
	
	public XmlRunStore() {
		initBuffer();
		rootElement = new TestResultsXml();
	}


	@Override
	public void setPath(String path) {
		filePath = path + ".xml";
	}

	
	@Override
	public void save() {
		generateXMLBuffer();
		File file = new File(filePath);
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(buffer);
			bw.close();
		} catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	
	private void initBuffer() {
		buffer = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	}
	
	@Override
	public boolean load() {
		XStream xstream = new XStream();
		try {
			rootElement = (TestResultsXml)xstream.fromXML(new File(filePath));
		} catch(XStreamException exception) {
			return false;
		}
		return true;
	}
	
	private void generateXMLBuffer() {
		XStream xstream = new XStream();
		buffer += xstream.toXML(rootElement);
	}
	

	public void addAllTestResults(Collection<TestResult> results) {
		for(TestResult result : results) {
			TestResultXml testResultXml = new TestResultXml(result);
			rootElement.addTestResultXml(testResultXml);
		}
	}
	
	public void addTestResult(TestResult testResult) {
		rootElement.addTestResultXml(new TestResultXml(testResult));
	}
	
	public Collection<TestResult> getAllTestResults() {
		Collection<TestResult> results = new ArrayList<TestResult>();
		for(TestResultXml resultXml : rootElement.getTestResults()) {
			results.add(TestResult.buildFromXml(resultXml));
		}
		return results;
	}
	
}
