package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public class ZeroProductTest extends TestCase {
	
	public ZeroProductTest(String name) {
		super(name);
	}
	
	public ZeroProductTest() {
		super();
	}
	
	public void testCode() throws AssertException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.product(5, 0) == 0);
	}
}
