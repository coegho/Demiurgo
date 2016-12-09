package es.usc.rai.coego.martin.demiurgo.exceptions;

public class ClassDefinitionOnCodeException extends DemiurgoException {
	public ClassDefinitionOnCodeException(int line, int column, int i) {
		super("Found a class definition on regular code", line, column, i);
	}
}
