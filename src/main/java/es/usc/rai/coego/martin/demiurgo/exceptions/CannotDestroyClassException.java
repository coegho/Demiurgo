package es.usc.rai.coego.martin.demiurgo.exceptions;

public class CannotDestroyClassException extends Exception {

	private String classname;
	
	public CannotDestroyClassException(String classname) {
		this.classname = classname;
	}
	
	@Override
	public String getMessage() {
		return "Cannot destroy class " + classname;
	}

}
