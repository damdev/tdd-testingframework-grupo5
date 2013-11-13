package ar.uba.fi.tdd.grupo5.xml;

public class TestSuiteElement extends Element {

	public TestSuiteElement(String nameAttibuteValue, String testsAttibuteValue) {
		super("testsuite");
		addAttribute("name", nameAttibuteValue);
		addAttribute("tests", testsAttibuteValue);
	}

}
