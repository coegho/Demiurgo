package es.usc.rai.coego.martin.demiurgo.exceptions;

public class UndefinedClassException extends DemiurgoException {
	String className;

	public UndefinedClassException(int line, int column, int i, String className) {
		super("Undefined class '" + className + "'", line, column, i);
		this.className = className;
	}
}
