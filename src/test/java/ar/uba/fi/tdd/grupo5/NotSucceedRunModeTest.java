package ar.uba.fi.tdd.grupo5;

import ar.uba.fi.tdd.grupo5.framework.TestCase;
import ar.uba.fi.tdd.grupo5.framework.exception.AssertException;

import org.junit.Test;
import static junit.framework.Assert.*;

public class NotSucceedRunModeTest {
	private class MySimpleTest extends TestCase {
		public MySimpleTest(String name) {
			this.name = name;
		}

		@Override
		public void testCode() throws AssertException {
		}
	}
	
	@Test
	public void test() {
		
	}
}
