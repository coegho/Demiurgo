package es.usc.rai.coego.martin.demiurgo.exceptions;

public class TagAlreadySetException extends DemiurgoException {
	public TagAlreadySetException(int line, int column, int i, String tag) {
		super("This tag is already set: " + tag, line, column, i);
	}
}
