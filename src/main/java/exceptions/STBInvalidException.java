package exceptions;

public class STBInvalidException extends RuntimeException {

	    private static final long serialVersionUID = 1L;
	    
	    
	    public STBInvalidException(String message) {
	        super(message);
	    }

	    public STBInvalidException(String message, Throwable cause) {
	        super(message, cause);
	    }
	

}
