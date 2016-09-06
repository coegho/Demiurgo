package es.usc.rai.coego.martin.demiurgo.values;

public class ReferenceValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient ValueInterface reference;

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.REFERENCE;
	}
	
	public ReferenceValue(ValueInterface reference) {
		this.reference = reference;
	}

	public ValueInterface getReference() {
		return reference;
	}

	public void setReference(ValueInterface reference) {
		this.reference = reference;
	}

	@Override
	public boolean canAssign(ValueInterface newRValue) {
		return (newRValue instanceof ReferenceValue);
	}
	
	@Override
	public boolean assign(ValueInterface newRValue) {
		if(newRValue instanceof ReferenceValue) {
			reference = ((ReferenceValue)newRValue).getReference();
			return true;
		}
		return false;
	}
	

	@Override
	public ValueInterface cloneValue() {
		return new ReferenceValue(getReference());
	}
}
