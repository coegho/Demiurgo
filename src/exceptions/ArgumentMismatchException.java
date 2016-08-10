package exceptions;

public class ArgumentMismatchException extends Exception {

	@Override
	public String getMessage() {
		return "Arguments doesn't match";
	}
	
}
