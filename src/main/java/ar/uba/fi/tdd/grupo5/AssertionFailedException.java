package ar.uba.fi.tdd.grupo5;


public class AssertionFailedException extends Exception {
  
	public AssertionFailedException(String msg)
    {
        super(msg);
    }
	
	public AssertionFailedException()
    {
        super("Message was not provided");
    }

	public String getMessage()
    {
        return super.getMessage();
    }
	
}
