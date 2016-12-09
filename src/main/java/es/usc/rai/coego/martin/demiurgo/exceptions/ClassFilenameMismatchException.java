package es.usc.rai.coego.martin.demiurgo.exceptions;

public class ClassFilenameMismatchException extends DemiurgoException {
	protected String filename;
	protected String classname;

	public ClassFilenameMismatchException(int line, int column, int i, String filename, String classname) {
		super("Class filename mismatch: class '" + classname + "' does not match with filename '" + filename + "'",
				line, column, i);
		this.filename = filename;
		this.classname = classname;
	}

	public String getFilename() {
		return filename;
	}

	public String getClassname() {
		return classname;
	}

	@Override
	public String getMessage() {
		return "Class filename mismatch: class '" + getClassname() + "' does not match with filename '" + getFilename()
				+ "'";
	}
}
