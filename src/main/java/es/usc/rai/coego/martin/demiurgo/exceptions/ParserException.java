package es.usc.rai.coego.martin.demiurgo.exceptions;

public class ParserException extends DemiurgoException {
	public ParserException(String message, int line, int column, int i) {
		super(message, line, column, i);
	}
}
