package es.usc.rai.coego.martin.demiurgo.exceptions;

public class IrregularListException extends DemiurgoException {
	
	public IrregularListException(int line, int column, int i) {
		super("Irregular list", line, column, i);
	}
}
