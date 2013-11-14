package ar.uba.fi.tdd.grupo5.xml;

public class Attribute {

	private String name;
	private String value;

	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getXMLFormatAttibute() {
		return name + "=\"" + value + "\" ";
	}

}
