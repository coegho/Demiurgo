package es.usc.rai.coego.martin.demiurgo.exceptions;

public class ValueCastException extends DemiurgoException {
	private String type;
	private String castType;
	public ValueCastException(int line, int column, int startIndex, String type, String castType) {
		super("Cannot cast from '" + type + "' to '" + castType + "'", line, column, startIndex);
		this.type = type;
		this.castType = castType;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCastType() {
		return castType;
	}
}
