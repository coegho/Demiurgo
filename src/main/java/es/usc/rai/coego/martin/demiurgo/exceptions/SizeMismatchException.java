package es.usc.rai.coego.martin.demiurgo.exceptions;

public class SizeMismatchException extends IllegalOperationException {
	public SizeMismatchException(int line, int column, int i, String leftType, String rightType) {
		super(line, column, i, leftType, rightType, null);
	}
	
	@Override
	public String getMessage() {
		return "Size does not match on operation between lists'" + getLeftType() + "' and '" + getRightType() + "'";

	}
}
