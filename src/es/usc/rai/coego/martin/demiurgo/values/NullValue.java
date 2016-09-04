package es.usc.rai.coego.martin.demiurgo.values;

import com.fasterxml.jackson.databind.node.ObjectNode;

import gal.republica.coego.demiurgo.lib.ReturnValueTypes;

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
	public String[] getValueCodes() {
		String[] r = new String[3];
		r[0] = "NULL";
		return r;
	}
	
	@Override
	public ObjectNode toJSON() {
		ObjectNode json = super.toJSON();
		json.put("value", "NULL");
		return json;
	}
}
