package test;

import ar.uba.fi.tdd.grupo5.TestSuite;

public class Main 
{
    public static void main( String[] args )
    {
       TestSuite addSuite = new TestSuite("Addition test suite");
       TestSuite productSuite = new TestSuite("Product test suite");
       
       addSuite.add(new TestAdd());
       addSuite.add(new TestZeroAdd());
       addSuite.add(new TestAddFailed());
       
       productSuite.add(new TestProduct());
       productSuite.add(new TestZeroProduct());
       
       addSuite.run();
       productSuite.run();

    }
}
