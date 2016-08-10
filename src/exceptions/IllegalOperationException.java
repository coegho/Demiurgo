package exceptions;

public class IllegalOperationException extends Exception {
	@Override
	public String getMessage() {
		return "Illegal operation";
	}
}
