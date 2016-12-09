package es.usc.rai.coego.martin.demiurgo.exceptions;

public class RoomNotFoundException extends DemiurgoException {
	private String path;
	public RoomNotFoundException(int line, int column, int i, String path) {
		super("Cannot found room '" + path + "'", line, column, i);
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
