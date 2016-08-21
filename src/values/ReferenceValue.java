package values;

import universe.StoredSymbol;

public class ReferenceValue extends AbstractValue {
	protected transient StoredSymbol reference;

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.REFERENCE;
	}
	
	public ReferenceValue(StoredSymbol reference) {
		this.reference = reference;
	}

	public StoredSymbol getReference() {
		return reference;
	}

	public void setReference(StoredSymbol reference) {
		this.reference = reference;
	}

	@Override
	public boolean canAssign(IReturnValue newRValue) {
		return (newRValue instanceof ReferenceValue);
	}
	
	@Override
	public boolean assign(IReturnValue newRValue) {
		if(newRValue instanceof ReferenceValue) {
			reference = ((ReferenceValue)newRValue).getReference();
			return true;
		}
		return false;
	}
	

	@Override
	public IReturnValue cloneValue() {
		return new ReferenceValue(getReference());
	}
}
