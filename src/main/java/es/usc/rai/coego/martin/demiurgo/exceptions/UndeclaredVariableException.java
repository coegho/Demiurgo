package es.usc.rai.coego.martin.demiurgo.exceptions;

public class UndeclaredVariableException extends Exception {
	@Override
	public String getMessage() {
		return "Variable undeclared";
	}
}
