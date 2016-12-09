package es.usc.rai.coego.martin.demiurgo.exceptions;

public class CodeClassInClassFileException extends DemiurgoException {
	public CodeClassInClassFileException(int line, int column, int i) {
		super("Found regular code where it should be a class definition", line, column, i);
	}
}
