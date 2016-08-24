package gal.republica.coego.demiurgo.exceptions;

public class UndeclaredVariableException extends Exception {
	@Override
	public String getMessage() {
		return "Variable undeclared";
	}
}
