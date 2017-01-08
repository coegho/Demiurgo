package es.usc.rai.coego.martin.demiurgo.values;

public class NullValue extends AbstractValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean canAssign(ValueInterface newRValue) {
		return false;
	}

	@Override
	public boolean assign(ValueInterface newRValue) {
		return false;
	}

	@Override
	public ValueInterface cloneValue() {
		return new NullValue();
	}

	@Override
	public ReturnValueTypes getType() {
		return null;
	}

	@Override
	public String toString() {
		return "NULL";
	}
	
	@Override
	public String getValueAsString() {
		return "NULL";
	}
}
