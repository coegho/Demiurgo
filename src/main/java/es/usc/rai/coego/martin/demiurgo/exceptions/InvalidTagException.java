package es.usc.rai.coego.martin.demiurgo.exceptions;

public class InvalidTagException extends DemiurgoException {

	public InvalidTagException(int line, int column, int startIndex, String tag) {
		super("Invalid tag: " + tag, line, column, startIndex);
	}

}
