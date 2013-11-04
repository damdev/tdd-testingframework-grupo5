package ar.uba.fi.tdd.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
	private File file;
	private String path;
	private String buffer;
	FileWriter fw;
	BufferedWriter bw;
	
	Output(String filePath, String message) throws IOException{
		file = new File(filePath);
		path = filePath;
		fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		buffer = message;
	}
	
	Output(String message) throws IOException{
		buffer = message;
	}
	
	public boolean existsFile() throws IOException {
		if (file == null){
			throw new IOException("There is no file assigned.");
		}
		
		return file.exists();
	}
	
	public void createFile() throws IOException{
		if (file == null){
			throw new IOException("There is no file assigned.");
		}
		
		else if (!existsFile()) {
		file.createNewFile();
		}
	}

	public void writeOnFile() throws IOException {
		if (bw == null){
			throw new IOException("There is no file assigned.");
		}
		else {
			bw.write(buffer);
		}
	}
	
	public void writeOnScreen() {
		System.out.println(buffer);
	}
	
	public String getString() {
		return buffer;
	}
	
	public void finalize(){
		if (bw != null){
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
