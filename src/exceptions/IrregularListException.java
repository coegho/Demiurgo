package exceptions;

public class IrregularListException extends Exception {
	@Override
	public String getMessage() {
		return "Irregular list";
	}
}
