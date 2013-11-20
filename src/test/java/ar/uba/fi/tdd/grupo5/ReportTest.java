package ar.uba.fi.tdd.grupo5;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import ar.uba.fi.tdd.grupo5.framework.Report;

public class ReportTest {

	private static final String FILE = "OuputTest.txt";

	@Test
	public void successWriteToStringWithNullMessage() {
		Report report = new Report(null);
		assertEquals("", report.writeOnString());
	}

	@Test
	public void successWriteToString() {
		String msg = "Generic Message";
		Report report = new Report(msg);
		assertEquals("Generic Message", report.writeOnString());
	}

	@Test
	public void failWriteToFileOutputWithNullMessage() throws NullPointerException,IOException {
		Report report = new Report(null);
		report.writeOnFile(FILE);
	}

	@Test
	public void successWriteToFile() throws IOException {
		String msg = "Generic Message";
		Report report = new Report(msg);
		report.writeOnFile(FILE);
		String fileMessage = getStringInFile();
		deleteFile();
		assertTrue(fileMessage.equals("Generic Message"));
	}

	private String getStringInFile() {
		File file = new File(FILE);
		FileReader fr;
		StringBuffer data = new StringBuffer();
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				data.append(linea);
				data.append(System.getProperty("line.separator"));
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (data.toString().isEmpty()) {
			return null;
		}
		int c = data.lastIndexOf(System.getProperty("line.separator"));
		String sReturn = data.substring(0, c);
		return sReturn;
	}

	private void deleteFile() {
		File file = new File(FILE);
		file.delete();
	}
	
}
