package ar.uba.fi.tdd.grupo5.xml;

public class SkippedElement extends Element {
		
	private String content;
	
	public SkippedElement(String name, String content) {
		super("skipped");
		this.content = content;
	}

	public String getXMLFormatElement(){
		openTag();
		stream += tabLevel + content + "\n";
		closeTag();
		return stream;
	}
	
}
