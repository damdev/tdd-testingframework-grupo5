package ar.uba.fi.tdd.grupo5.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report {

	private String buffer;

	public Report(String message) {
		if (message == null) {
			buffer = "";
		} else {
			buffer = message;
		}
	}

	/**
	 * Write the content of the output on a file
	 * 
	 * @param filePath
	 *            the path of the file that is going to be written
	 * @throws NullPointerException, IOException 
	 */
	public void writeOnFile(String filePath) throws NullPointerException, IOException {
		if (isEmptyBuffer()) {
			return;
		}
		
		File file = new File(filePath);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(buffer);
		bw.close();
	}

	/**
	 * Write the content of the output on the standard output
	 */
	public void writeOnScreen() {
		System.out.println(buffer);
	}

	/**
	 * Return a String with the content of the output
	 */
	public String writeOnString() {
		return buffer;
	}

	private boolean isEmptyBuffer() {
		return buffer.isEmpty();
	}
}
