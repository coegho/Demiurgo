package es.usc.rai.coego.martin.demiurgo.exceptions;

public class NotAnObjectException extends DemiurgoException {

	private String type;
	public NotAnObjectException(int line, int column, int i, String type) {
		super("Trying to access to '" + type + "' like an object", line, column, i);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}
