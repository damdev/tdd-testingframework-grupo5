package ar.uba.fi.tdd.grupo5.framework;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class TextFileRunStore implements TestRunStore {

	private static final String F_SEP = "<>";
	private static final String R_SEP = "\n";
	
	private List<TestResult> previousResults;
	StringBuffer buffer;
	private String filePath;
	
	public TextFileRunStore() {
		previousResults = new ArrayList<TestResult>();
		buffer = new StringBuffer();
	}
	
	@Override
	public void save() {
		for(TestResult result : previousResults) {
			writeResult(result);
		}
		writeBuffer();
	}
	
	
	private void writeResult(TestResult result) {
		buffer.append(result.getTestName());
		buffer.append(F_SEP);
		buffer.append(result.getTestTime());
		buffer.append(F_SEP);
		buffer.append(result.isError());
		buffer.append(F_SEP);
		buffer.append(result.isFail());
		buffer.append(F_SEP);
	}
	
	
	private TestResult readResult(Scanner reader) {
			reader.useDelimiter(F_SEP);
			String name = reader.next();
			long time = Long.valueOf(reader.next());
			boolean isError = Boolean.valueOf(reader.next());
			boolean isFail = Boolean.valueOf(reader.next());
			return new TestResult(name, isError, isFail, time);
	}
	
	
	private void writeBuffer() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(buffer.toString());
			writer.close();
		} catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}

	@Override
	public boolean load() {
		try {
			Scanner reader = new Scanner(new FileReader(filePath));	
			while(reader.hasNext()) {
				TestResult result = readResult(reader);
				previousResults.add(result);
			}
			reader.close();
			return true;
		} catch(IOException exception) {
			return false;
		}
	}

	@Override
	public void setPath(String path) {
		filePath = path + ".txt";
	}

	@Override
	public Collection<TestResult> getAllTestResults() {
		return previousResults;
	}

	@Override
	public void addAllTestResults(Collection<TestResult> results) {
		previousResults.addAll(results);
	}

}
