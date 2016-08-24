package gal.republica.coego.demiurgo.exceptions;

public class ClassFilenameMismatchException extends Exception {
	protected String filename;
	protected String classname;

	public ClassFilenameMismatchException(String filename, String classname) {
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
