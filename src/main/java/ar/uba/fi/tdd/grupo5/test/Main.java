package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Runner;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.TestSuite;
import ar.uba.fi.tdd.grupo5.framework.exception.TestException;

public class Main {
	public static void main(String[] args) throws TestException {
		TestCase addTest1 = new AddTest();
		addTest1.addTags("FIRST");
		TestCase addTest2 = new ZeroAddTest();
		addTest2.addTags("FIRST");
		TestCase addTest3 = new AddFailedTest();
		addTest3.addTags("SECOND");
		TestSuite addSuite = new TestSuite("Addition test suite");
		addSuite.add(addTest1);
		addSuite.add(addTest2);
		addSuite.add(addTest3);
		
		TestCase productTest1 = new ProductTest();
		productTest1.addTags("FIRST");
		TestCase productTest2 = new ZeroProductTest();
		productTest2.addTags("FIRST");
		TestSuite productSuite = new TestSuite("Product test suite");
		productSuite.add(productTest1);
		productSuite.add(productTest2);
		
		TestCase divitionTest = new ZeroDivitionTest();
		divitionTest.addTags("SECOND");
		TestSuite divSuite = new TestSuite("Divition test suite");
		divSuite.add(divitionTest);
		
		TestSuite calculatorSuite = new TestSuite("Calculator suite");
		calculatorSuite.add(addSuite);
		calculatorSuite.add(productSuite);
		calculatorSuite.add(divSuite);

		Runner runner = new Runner(calculatorSuite, "./XMLReport");
		runner.runAll();
		runner.runWithAnyTags("FIRST");
		runner.runWithAllTags("SECOND");
		
		runner.writeXML();
	}
}
