package universe;

import values.IReturnValue;

public class StoredSymbol {
	protected IReturnValue value;
	protected boolean writable = true;
	
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
		if(writable)
			this.value = value;
		//Only writes if it is writable
		//TODO: may produce a warning?
	}
	
	public boolean isWritable() {
		return writable;
	}
	
	public void setWritable(boolean writable) {
		this.writable = writable;
	}
	
	public boolean assign(IReturnValue newValue) {
		return value.assign(newValue);
	}
}