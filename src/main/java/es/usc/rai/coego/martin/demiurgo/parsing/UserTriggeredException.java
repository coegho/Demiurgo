package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.exceptions.DemiurgoException;

public class UserTriggeredException extends DemiurgoException {

	public UserTriggeredException(int line, int column, int i, String msg) {
		super(msg, line, column, i);
	}

}
