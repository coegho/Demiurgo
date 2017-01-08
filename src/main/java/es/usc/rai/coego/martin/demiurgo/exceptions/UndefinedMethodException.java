package es.usc.rai.coego.martin.demiurgo.exceptions;

public class UndefinedMethodException extends DemiurgoException {
	private String methodName;
	public UndefinedMethodException(int line, int column, int i, String methodName) {
		super("Method '" + methodName + "' undefined", line, column, i);
		this.methodName = methodName;
	}
	
	public String getMethodName() {
		return methodName;
	}
}
