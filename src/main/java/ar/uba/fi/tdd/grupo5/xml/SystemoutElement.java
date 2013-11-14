package ar.uba.fi.tdd.grupo5.xml;

public class SystemoutElement extends Element {

	private String content;	
	
	public SystemoutElement(String content) {
		super("system-out");
		this.content = content;
	}

	protected void oneLineTag(){
		stream = tabLevel + "<" + name + ">" + content + "</" + name + ">\n";
	}
	
}