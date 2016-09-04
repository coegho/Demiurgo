package es.usc.rai.coego.martin.demiurgo.values;

import com.fasterxml.jackson.databind.node.ObjectNode;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import gal.republica.coego.demiurgo.lib.ReturnValueTypes;

public class FloatValue extends AbstractValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float value;

	public FloatValue(float value) {
		this.value = value;
	}
	
	public static FloatValue defaultValue() {
		return new FloatValue(0);
	}
	
	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.FLOAT;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public ValueInterface add(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new FloatValue(getValue() + ((IntegerValue) other).getValue());
		}
		if (other instanceof FloatValue) {
			return new FloatValue((float) getValue() + ((FloatValue) other).getValue());
		}
		if (other instanceof StringValue) {
			return new StringValue(Float.toString(getValue()) + ((StringValue) other).getValue());
		}
		if (other instanceof ListValue) {
			return other.add(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface sub(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof ListValue) {
			return negative().add(other);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface mul(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new FloatValue(getValue() * ((IntegerValue) other).getValue());
		}
		if (other instanceof FloatValue) {
			return new FloatValue((float) getValue() * ((FloatValue) other).getValue());
		}
		if (other instanceof ListValue) {
			return other.mul(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface div(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new FloatValue(getValue() / ((IntegerValue) other).getValue());
		}
		if (other instanceof FloatValue) {
			return new FloatValue((float) getValue() / ((FloatValue) other).getValue());
		}
		if (other instanceof ListValue) {
			ListValue av = (ListValue) other.cloneValue();
			for (int i = 0; i < av.getValue().size(); i++) {
				av.getValue().set(i, div(av.getValue().get(i)));
			}
			return av;
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface negative() throws IllegalOperationException {
		return new FloatValue(-getValue());
	}

	@Override
	public ValueInterface eq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() == ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue((getValue() == ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.eq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface neq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() != ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() != ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.neq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface greq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() >= ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue((getValue() >= ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.less(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface leseq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() <= ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue((getValue() <= ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.great(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface great(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() > ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue((getValue() > ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.leseq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface less(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() < ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue((getValue() < ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.greq(this);
		}
		throw new IllegalOperationException();
	}

	
	@Override
	public int castToInteger() throws ValueCastException {
		return (int)value;
	}

	@Override
	public float castToFloat() throws ValueCastException {
		return value;
	}

	@Override
	public String castToString() throws ValueCastException {
		return Float.toString(value);
	}
	
	@Override
	public boolean canAssign(ValueInterface newRValue) {
		if(!writable) return false;
		try {
			newRValue.castToFloat();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
	}
	
	@Override
	public boolean assign(ValueInterface newRValue) {
		if(!writable) return false;
		try {
			value = newRValue.castToFloat();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
	}


	@Override
	public ValueInterface not() {
		return new IntegerValue(isTrue() ? 0 : 1);
	}

	@Override
	public boolean isTrue() {
		return getValue() != 0;
	}

	@Override
	public ValueInterface cloneValue() {
		return new FloatValue(this.getValue());
	}
	
	@Override
	public String toString() {
		return "FLOAT/" + getValue() + "}";
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[2] = Float.toString(value);
		return r;
	}

	@Override
	public ObjectNode toJSON() {
		ObjectNode json = super.toJSON();
		json.put("value", getValue());
		return json;
	}
}
