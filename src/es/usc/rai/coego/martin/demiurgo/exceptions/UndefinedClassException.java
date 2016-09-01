package es.usc.rai.coego.martin.demiurgo.exceptions;

public class UndefinedClassException extends Exception {
	String className;

	public UndefinedClassException(String className) {
		this.className = className;
	}

	@Override
	public String getMessage() {
		return "Undefined class: " + className;
	}
}
