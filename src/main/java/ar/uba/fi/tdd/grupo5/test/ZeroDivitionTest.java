package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.framework.AssertionFailedException;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;

public class ZeroDivitionTest extends TestCase {

	public ZeroDivitionTest(String name) {
		super(name);
	}
	
	public ZeroDivitionTest() {
		super();
	}
	
	@Override
	public void testCode() throws AssertionFailedException {
		Calculator c = new Calculator();
		Assert.assertTrue( c.divide(1, 0) == 1);
	}

}
