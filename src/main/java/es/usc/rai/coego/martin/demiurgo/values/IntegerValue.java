package es.usc.rai.coego.martin.demiurgo.values;

import java.util.Random;

import com.fasterxml.jackson.databind.node.ObjectNode;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;

public class IntegerValue extends AbstractValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int value;
	protected transient static Random r = new Random();

	public IntegerValue(int value) {
		this.value = value;
	}

	public IntegerValue(boolean value) {
		this.value = value?1:0;
	}

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.INT;
	}

	public static IntegerValue defaultValue() {
		return new IntegerValue(0);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public ValueInterface add(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue(getValue() + ((IntegerValue) other).getValue());
		}
		if (other instanceof FloatValue) {
			return new FloatValue((float) getValue() + ((FloatValue) other).getValue());
		}
		if (other instanceof StringValue) {
			return new StringValue(Integer.toString(getValue()) + ((StringValue) other).getValue());
		}
		if (other instanceof ListValue) {
			return other.add(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface sub(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof ListValue) {
			return add(other.negative());
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface mul(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue(getValue() * ((IntegerValue) other).getValue());
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
			return new IntegerValue(getValue() / ((IntegerValue) other).getValue());
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
		return new IntegerValue(-getValue());
	}

	@Override
	public ValueInterface eq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() == ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() == ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue(((float) getValue() >= ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue(((float) getValue() <= ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue(((float) getValue() > ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue(((float) getValue() < ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.greq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		return new IntegerValue((r.nextInt(getValue())) + 1);
	}

	@Override
	public ValueInterface multDice(ValueInterface other) throws IllegalOperationException {
		ListValue lv = new ListValue();

		if (other instanceof IntegerValue) {
			for (int i = 0; i < getValue(); i++) {
				lv.getValue().add(new IntegerValue((r.nextInt(((IntegerValue) other).getValue())) + 1));
			}
			return lv;
		}
		if (other instanceof ListValue) {
			for (ValueInterface x : ((ListValue) other).getValue()) {
				lv.getValue().add(multDice(x));
			}
			return lv;
		}

		throw new IllegalOperationException();
	}


	@Override
	public int castToInteger() throws ValueCastException {
		return value;
	}

	@Override
	public float castToFloat() throws ValueCastException {
		return (float) value;
	}

	@Override
	public String castToString() throws ValueCastException {
		return Integer.toString(value);
	}
	
	@Override
	public boolean canAssign(ValueInterface newRValue) {
		if(!writable) return false;
		try {
			newRValue.castToInteger();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
	}

	@Override
	public boolean assign(ValueInterface newRValue) {
		if(!writable) return false;
		try {
			value = newRValue.castToInteger();
			return true;
		} catch (ValueCastException ex) {
			return false;
		}
	}

	@Override
	public boolean isTrue() {
		return getValue() != 0;
	}

	@Override
	public ValueInterface cloneValue() {
		return new IntegerValue(this.getValue());
	}

	@Override
	public String toString() {
		return "INT/" + getValue();
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[2] = Integer.toString(value);
		return r;
	}
	
	@Override
	public ObjectNode toJSON() {
		ObjectNode json = super.toJSON();
		json.put("value", getValue());
		return json;
	}
}
