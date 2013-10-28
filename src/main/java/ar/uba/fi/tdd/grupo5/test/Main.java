package ar.uba.fi.tdd.grupo5.test;

import ar.uba.fi.tdd.grupo5.framework.TestSuite;

public class Main 
{
    public static void main( String[] args )
    {
       TestSuite addSuite = new TestSuite("Addition test suite");
       TestSuite productSuite = new TestSuite("Product test suite");
       TestSuite divSuite = new TestSuite("Divition test suite");
       
       addSuite.add(new AddTest());
       addSuite.add(new ZeroAddTest());
       addSuite.add(new AddFailedTest());
       
       productSuite.add(new ProductTest());
       productSuite.add(new ZeroProductTest());
       
       divSuite.add(new ZeroDivitionTest());
       
       String r1 = addSuite.run();
       System.out.println(r1);
       r1 = productSuite.run();
       System.out.println(r1);
       r1 = divSuite.run();
       System.out.println(r1);

    }
}
