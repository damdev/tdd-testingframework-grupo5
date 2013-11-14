package ar.uba.fi.tdd.grupo5.xml;

public class PropertiesElement extends Element {

	public PropertiesElement() {
		super("properties");
	}
	
	public void addPropertyElement(PropertyElement property){
		addChild(property);
	}
}
