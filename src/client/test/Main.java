package test;

import ar.uba.fi.tdd.grupo5.TestSuite;

public class Main 
{
    public static void main( String[] args )
    {
       TestSuite calculatorSuite = new TestSuite();
       TestSuite addSuite = new TestSuite();
       TestSuite productSuite = new TestSuite();
       
       addSuite.add(new TestAdd());
       addSuite.add(new TestZeroAdd());
       
       productSuite.add(new TestProduct());
       productSuite.add(new TestZeroProduct());
      
       
       calculatorSuite.add(addSuite);
       calculatorSuite.add(productSuite);
    }
}
