package ar.uba.fi.tdd.grupo5.xml;

public class TestCaseElement extends Element {

	public TestCaseElement(String nameAttibuteValue) {
		super("testcase");
		addAttribute("name", nameAttibuteValue);
	}
}
