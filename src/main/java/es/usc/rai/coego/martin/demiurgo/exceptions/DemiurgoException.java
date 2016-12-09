package es.usc.rai.coego.martin.demiurgo.exceptions;

public abstract class DemiurgoException extends Exception {
	protected int line;
	protected int column;
	protected int startIndex;
	
	public DemiurgoException(String message, int line, int column, int startIndex) {
		super(message);
		this.line = line;
		this.column = column;
		this.startIndex = startIndex;
	}
	
	@Override
	public String getMessage() {
		return "line " + line + ":" + column + ": " + super.getMessage();
	}
	
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
}
