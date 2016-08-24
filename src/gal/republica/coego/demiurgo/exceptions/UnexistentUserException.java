package gal.republica.coego.demiurgo.exceptions;

public class UnexistentUserException extends Exception {

	private String username; 
	public UnexistentUserException(String username) {
		this.username = username;
	}

}
