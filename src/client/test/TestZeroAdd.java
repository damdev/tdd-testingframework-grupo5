package test;

import ar.uba.fi.tdd.grupo5.Assert;
import ar.uba.fi.tdd.grupo5.AssertionFailedException;
import ar.uba.fi.tdd.grupo5.Calculator;
import ar.uba.fi.tdd.grupo5.TestCase;

public class TestZeroAdd extends TestCase {
	public void testCode() throws AssertionFailedException{
		Calculator c = new Calculator();
		Assert.assertTrue( c.add(1, 0) == 1);
	}
}
