package test;

import ar.uba.fi.tdd.grupo5.Assert;
import ar.uba.fi.tdd.grupo5.AssertionFailedException;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.TestCase;

public class TestSubstraction extends TestCase {
	public void testCode() throws AssertionFailedException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.substract(10, 2) == 8);
	}
}