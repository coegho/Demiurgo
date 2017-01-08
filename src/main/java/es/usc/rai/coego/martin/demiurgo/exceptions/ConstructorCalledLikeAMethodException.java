package es.usc.rai.coego.martin.demiurgo.exceptions;

public class ConstructorCalledLikeAMethodException extends DemiurgoException {
	private String className;
	public ConstructorCalledLikeAMethodException(int line, int column, int i, String className) {
		super("Constructor of class '" + className + "' called like an ordinary method", line, column, i);
		this.className = className;
	}
	
	public String getClassName() {
		return className;
	}
}
