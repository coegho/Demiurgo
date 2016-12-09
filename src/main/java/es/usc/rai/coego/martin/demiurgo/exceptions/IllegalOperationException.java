package es.usc.rai.coego.martin.demiurgo.exceptions;

public class IllegalOperationException extends DemiurgoException {
	private String leftType;
	private String rightType;
	private String operation;

	public IllegalOperationException(int line, int column, int i, String leftType, String rightType, String operation) {
		super("Illegal operation: '" + leftType + "' '" + operation + "' '" + rightType + "'", line, column, i);
		this.leftType = leftType;
		this.rightType = rightType;
		this.operation = operation;
	}
	
	public String getLeftType() {
		return leftType;
	}
	
	public String getRightType() {
		return rightType;
	}
	
	public String getOperation() {
		return operation;
	}
}
