package ar.uba.fi.tdd.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
	
	private File file;
	private String buffer;
	FileWriter fw;
	BufferedWriter bw;

	Output(String message) {
		buffer = message;
	}
	
	private void init(String filePath) throws IOException{
		file = new File(filePath);
		fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
	}
	
	private boolean existsFile() throws IOException {
		return file.exists();
	}
	
	private void createFile() throws IOException{
		file.createNewFile();
	}
	
	/**
	 * Write the content of the output on a file
	 * @param filePath the path of the file that is going to be written
	 * @throws IOException If the file exists, and exception is raised.
	 */
	
	public void writeOnFile(String filePath) throws IOException {
		init(filePath);
		if (!existsFile()){ 
			createFile();
			bw.write(buffer);
			bw.close();
		}
	}
	
	/**
	 * Write the content of the output on the standard output
	 */
	
	public void writeOnScreen() {
		System.out.println(buffer);
	}
	
	/**
	 * 
	 * @return a String with the content of the output
	 */
	
	public String writeOnString() {
		return buffer;
	}
}
