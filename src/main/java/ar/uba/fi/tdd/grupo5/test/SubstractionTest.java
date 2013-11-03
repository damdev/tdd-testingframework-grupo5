package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.Assert;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

public class SubstractionTest extends TestCase {
	
	public SubstractionTest(String name) {
		super(name);
	}
	
	public SubstractionTest() {
		super();
	}
	
	public void testCode() throws AssertException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.substract(10, 2) == 8);
	}
}