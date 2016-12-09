package es.usc.rai.coego.martin.demiurgo.exceptions;

public class NotAListException extends DemiurgoException {
	private String type;
	public NotAListException(int line, int column, int i, String type) {
		super("Trying to access by index to an '" + type + "'", line, column, i);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
