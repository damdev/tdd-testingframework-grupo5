package ar.uba.fi.tdd.grupo5.framework.exception;

/**
 * Created with IntelliJ IDEA.
 * User: sebastian
 * Date: 18/11/13
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public class PerformanceException  extends Exception {
    private static final long serialVersionUID = -1140973198796785876L;
    private static final String defaultMessage = "Exception cause by a not-fullfilled Performance requirement";

    public PerformanceException(String message) {
        super(message);
     }

    public PerformanceException() {
        super(defaultMessage);
    }
}
