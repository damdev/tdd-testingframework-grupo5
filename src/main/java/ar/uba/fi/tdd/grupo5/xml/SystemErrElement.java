package ar.uba.fi.tdd.grupo5.xml;

public class SystemErrElement extends Element {

	private String content;

	public SystemErrElement(String content) {
		super("system-err");
		this.content = content;
	}

	@Override
	protected void oneLineTag() {
		stream = tabLevel + "<" + name + ">" + content + "</" + name + ">\n";
	}
}
