package plataformarol;

import values.IReturnValue;

public class StoredSymbol {
	protected IReturnValue value;
	protected boolean writable = true;
	protected String type;//TODO: enum
	
	public StoredSymbol(IReturnValue value) {
		this.value = value;
	}
	
	public StoredSymbol(IReturnValue value, boolean isWritable) {
		this.value = value;
		this.writable = isWritable;
	}
	
	public IReturnValue getValue() {
		return value;
	}
	
	public void setValue(IReturnValue value) {
		this.value = value;
	}
	
	public boolean isWritable() {
		return writable;
	}
}