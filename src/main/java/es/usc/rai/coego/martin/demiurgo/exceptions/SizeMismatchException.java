package es.usc.rai.coego.martin.demiurgo.exceptions;

public class SizeMismatchException extends IllegalOperationException {
	public SizeMismatchException(int line, int column, int i, String leftType, String rightType, String operation) {
		super(line, column, i, leftType, rightType, operation);
	}
	
	@Override
	public String getMessage() {
		return "Size does not match on operation '" + getLeftType() + "' '" + getOperation() + "' '" + getRightType() + "'";

	}
}
