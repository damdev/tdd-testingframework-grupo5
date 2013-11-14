package ar.uba.fi.tdd.grupo5.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class XmlManager {

	private String buffer;
	private String filePath;
	private TestSuitesElement rootElement;

	public XmlManager(String filePath) {
		initBuffer();
		this.filePath = filePath;
		rootElement = new TestSuitesElement();
	}

	public void writeXML() throws IOException {
		generateXMLBuffer();
		File file = new File(filePath + getDate() + ".xml");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(buffer);
		bw.close();
	}

	public void setTestSuiteChild(TestSuiteElement testSuiteElement) {
		rootElement.addTestSuiteElement(testSuiteElement);
	}

	private void initBuffer() {
		buffer = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	}

	private void generateXMLBuffer() {
		buffer += rootElement.getXMLFormatElement();
	}

	private String getDate() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("-dd-MM-YYYY-HH:mm:ss");
		return (sdf.format(cal.getTime()));
	}
}