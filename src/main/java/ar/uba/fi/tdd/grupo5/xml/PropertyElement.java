package ar.uba.fi.tdd.grupo5.xml;

public class PropertyElement extends Element {

	public PropertyElement(String nameAttibuteValue, String valueAttibuteValue) {
		super("property");
		addAttribute("name", nameAttibuteValue);
		addAttribute("value", valueAttibuteValue);
	}

}
