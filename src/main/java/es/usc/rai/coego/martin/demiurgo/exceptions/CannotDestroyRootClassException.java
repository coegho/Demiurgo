package es.usc.rai.coego.martin.demiurgo.exceptions;

public class CannotDestroyRootClassException extends CannotDestroyClassException {

	public CannotDestroyRootClassException() {
		super("object");
	}

	@Override
	public String getMessage() {
		return "Cannot destroy class OBJECT: this class is the root of all classes";
	}
}
