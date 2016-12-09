package es.usc.rai.coego.martin.demiurgo.exceptions;

public class ConstructorCalledAsMethodException extends DemiurgoException {
	private String className;
	public ConstructorCalledAsMethodException(int line, int column, int i, String className) {
		super("Constructor of class '" + className + "' called as a normal method", line, column, i);
		this.className = className;
	}
	
	public String getClassName() {
		return className;
	}
}
