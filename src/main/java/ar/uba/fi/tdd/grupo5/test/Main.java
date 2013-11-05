package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Report;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class Main {
	public static void main(String[] args) throws TestException {
		TestSuite calculatorSuite = new TestSuite("Calculator suite");
		TestSuite addSuite = new TestSuite("Addition test suite");
		TestSuite productSuite = new TestSuite("Product test suite");
		TestSuite divSuite = new TestSuite("Divition test suite");

		addSuite.add(new AddTest());
		addSuite.add(new ZeroAddTest());
		addSuite.add(new AddFailedTest());

		productSuite.add(new ProductTest());
		productSuite.add(new ZeroProductTest());

		divSuite.add(new ZeroDivitionTest());

		calculatorSuite.add(addSuite);
		calculatorSuite.add(productSuite);
		calculatorSuite.add(divSuite);

		Report result = calculatorSuite.run();
		result.writeOnScreen();
	}
}
