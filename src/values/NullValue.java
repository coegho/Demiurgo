package values;

import serializable.ReturnValueTypes;

public class NullValue extends AbstractValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean canAssign(IReturnValue newRValue) {
		return false;
	}

	@Override
	public boolean assign(IReturnValue newRValue) {
		return false;
	}

	@Override
	public IReturnValue cloneValue() {
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
	public String[] getValueCodes() {
		String[] r = new String[3];
		r[0] = "NULL";
		return r;
	}
}
