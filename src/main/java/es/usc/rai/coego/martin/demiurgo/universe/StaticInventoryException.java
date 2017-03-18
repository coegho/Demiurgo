package es.usc.rai.coego.martin.demiurgo.universe;

import es.usc.rai.coego.martin.demiurgo.exceptions.DemiurgoException;

public class StaticInventoryException extends DemiurgoException {

	public StaticInventoryException(int line, int column, int index, String varName) {
		super("Illegal field " + varName + "; an inventory cannot be static", line, column, index);
	}

}
