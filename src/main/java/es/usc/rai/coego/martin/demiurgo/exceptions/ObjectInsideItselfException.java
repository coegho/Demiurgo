package es.usc.rai.coego.martin.demiurgo.exceptions;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;

public class ObjectInsideItselfException extends DemiurgoException {
	protected DemiurgoObject obj;
	public ObjectInsideItselfException(DemiurgoObject obj) {
		super("Cannot move object " + "'#" + obj.getId() + "' to an inventory of itself", 0, 0, 0);
		this.obj = obj;
	}
  //TODO: exception info
}
