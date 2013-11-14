package ar.uba.fi.tdd.grupo5.xml;

public class SystemOutElement extends Element {

	private String content;

	public SystemOutElement(String content) {
		super("system-out");
		this.content = content;
	}

	@Override
	protected void oneLineTag() {
		stream = tabLevel + "<" + name + ">" + content + "</" + name + ">\n";
	}
}