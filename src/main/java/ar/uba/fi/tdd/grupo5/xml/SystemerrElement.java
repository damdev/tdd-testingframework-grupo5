package ar.uba.fi.tdd.grupo5.xml;

public class SystemerrElement extends Element {

	private String content;	
	
	public SystemerrElement(String content) {
		super("system-err");
		this.content = content;
	}

	protected void oneLineTag(){
		stream = tabLevel + "<" + name + ">" + content + "</" + name + ">\n";
	}
	
}
