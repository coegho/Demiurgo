package es.usc.rai.coego.martin.demiurgo.exceptions;

public class BadConstructorException extends DemiurgoException {
	public BadConstructorException(int line, int column, int i) {
		super("Bad constructor syntax", line, column, i);
	}
}
