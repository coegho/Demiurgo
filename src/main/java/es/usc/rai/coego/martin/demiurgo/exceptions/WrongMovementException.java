package es.usc.rai.coego.martin.demiurgo.exceptions;

public class WrongMovementException extends DemiurgoException {
	private String mobile;
	private String destination;

	public WrongMovementException(int line, int column, int startIndex, String mobile, String destination) {
		super("Cannot move '" + mobile + "' into '" + destination + "'", line, column, startIndex);
		this.mobile = mobile;
		this.destination = destination;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public String getDestination() {
		return destination;
	}
}
