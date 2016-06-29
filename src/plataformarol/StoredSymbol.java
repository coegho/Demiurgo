package plataformarol;

public class StoredSymbol {
	protected IReturnValue value;
	
	public StoredSymbol(IReturnValue value) {
		this.value = value;
	}
	public IReturnValue getValue() {
		return value;
	}
	public void setValue(IReturnValue value) {
		this.value = value;
	}
}