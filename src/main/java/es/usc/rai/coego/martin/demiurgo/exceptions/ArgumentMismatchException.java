package es.usc.rai.coego.martin.demiurgo.exceptions;

public class ArgumentMismatchException extends DemiurgoException {

	public ArgumentMismatchException(int line, int column, int i) {
		super("Arguments doesn't match", line, column, i);
	}
}