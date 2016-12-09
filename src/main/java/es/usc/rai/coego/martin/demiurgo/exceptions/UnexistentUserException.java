package es.usc.rai.coego.martin.demiurgo.exceptions;

public class UnexistentUserException extends DemiurgoException {

	private String username; 
	public UnexistentUserException(int line, int column, int startIndex, String username) {
		super("User doesn't exist: "+ username, line, column, startIndex);
		this.username = username;
	}
}
