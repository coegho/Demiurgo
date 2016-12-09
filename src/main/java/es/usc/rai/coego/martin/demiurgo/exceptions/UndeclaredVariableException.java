package es.usc.rai.coego.martin.demiurgo.exceptions;

public class UndeclaredVariableException extends DemiurgoException {
	private String variable;
	public UndeclaredVariableException(int line, int column, int i, String variable) {
		super("Variable '" + variable + "' undeclared", line, column, i);
		this.variable = variable;
	}
}
