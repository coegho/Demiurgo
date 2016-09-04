package es.usc.rai.coego.martin.demiurgo.values;

import com.fasterxml.jackson.databind.node.ObjectNode;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import gal.republica.coego.demiurgo.lib.ReturnValueTypes;

public class StringValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String value;

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.STRING;
	}

	public StringValue(String value) {
		this.value = value;
	}
	
	public static StringValue defaultValue() {
		return new StringValue("");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public ValueInterface add(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new StringValue(getValue() + Integer.toString(((IntegerValue) other).getValue()));
		}
		if (other instanceof FloatValue) {
			return new StringValue(getValue() + Float.toString(((FloatValue) other).getValue()));
		}
		if (other instanceof StringValue) {
			return new StringValue(getValue() + ((StringValue) other).getValue());
		}
		if (other instanceof ListValue) {
			ListValue av = (ListValue) other.cloneValue();
			for (int i = 0; i < av.getValue().size(); i++) {
				av.getValue().set(i, this.add(av.getValue().get(i)));
			}
			return av;
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface eq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof StringValue) {
			return new IntegerValue((getValue() == ((StringValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.eq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface neq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof StringValue) {
			return new IntegerValue((getValue() != ((StringValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.neq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface multDice(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}
	
	@Override
	public int castToInteger() throws ValueCastException {
		try {
			return Integer.parseInt(value);
		} catch(NumberFormatException ex) {
			throw new ValueCastException();
		}
	}

	@Override
	public float castToFloat() throws ValueCastException {
		try {
			return Float.parseFloat(value);
		} catch(NumberFormatException ex) {
			throw new ValueCastException();
		}
	}

	@Override
	public String castToString() throws ValueCastException {
		return value;
	}

	@Override
	public boolean canAssign(ValueInterface newRValue) {
		try {
			newRValue.castToString();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
	}
	
	@Override
	public boolean assign(ValueInterface newRValue) {
		try {
			value = newRValue.castToString();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
	}

	@Override
	public boolean isTrue() {
		return getValue() != "";
	}

	@Override
	public ValueInterface cloneValue() {
		return new StringValue(this.getValue());
	}

	@Override
	public String toString() {
		return "STRING/\"" + getValue() + "\"";
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[2] = value;
		return r;
	}
	
	@Override
	public ObjectNode toJSON() {
		ObjectNode json = super.toJSON();
		json.put("value", getValue());
		return json;
	}
}
