package es.usc.rai.coego.martin.demiurgo.values;

import gal.republica.coego.demiurgo.lib.ReturnValueTypes;

public class ReferenceValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient IReturnValue reference;

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.REFERENCE;
	}
	
	public ReferenceValue(IReturnValue reference) {
		this.reference = reference;
	}

	public IReturnValue getReference() {
		return reference;
	}

	public void setReference(IReturnValue reference) {
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
