package es.usc.rai.coego.martin.demiurgo.exceptions;

public class CannotLoopException extends DemiurgoException {
	private String offenderType;

	public CannotLoopException(int line, int column, int i, String offenderType) {
		super("For loop cannot walk with a '" + offenderType + "' argument", line, column, i);
		this.offenderType = offenderType;
	}
	
	public String getOffenderType() {
		return offenderType;
	}
}
