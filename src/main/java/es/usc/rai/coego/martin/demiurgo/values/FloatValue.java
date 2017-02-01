package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;

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
	public ValueInterface add(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new FloatValue(getValue() + ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new FloatValue((float) getValue() + ((FloatValue) another).getValue());
		}
		if (another instanceof StringValue) {
			return new StringValue(Float.toString(getValue()) + ((StringValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.add(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "+");
	}

	@Override
	public ValueInterface sub(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new FloatValue(getValue() - ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new FloatValue((float) getValue() - ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.sub(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "-");
	}

	@Override
	public ValueInterface mul(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new FloatValue(getValue() * ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new FloatValue((float) getValue() * ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.mul(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "*");
	}

	@Override
	public ValueInterface div(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new FloatValue(getValue() / ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new FloatValue((float) getValue() / ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.div(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "/");
	}

	@Override
	public ValueInterface negative() throws IllegalOperationException {
		return new FloatValue(-getValue());
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() == ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new IntegerValue(getValue() == ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.eq(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "==");
	}

	@Override
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() != ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new IntegerValue((float) getValue() != ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.neq(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "!=");
	}

	@Override
	public ValueInterface greq(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() >= ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new IntegerValue(getValue() >= ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.greq(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), ">=");
	}

	@Override
	public ValueInterface leseq(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() <= ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new IntegerValue(getValue() <= ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.leseq(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "<=");
	}

	@Override
	public ValueInterface great(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() > ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new IntegerValue(getValue() > ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.great(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), ">");
	}

	@Override
	public ValueInterface less(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() < ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new IntegerValue(getValue() < ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.less(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "<");
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
	public void assign(ValueInterface newRValue) throws ValueCastException {
		if(canAssign(newRValue))
			try {
				value = newRValue.castToFloat();
			} catch(ValueCastException ex) {
				throw ex;
			}
		else
			throw new ValueCastException(-1, -1, -1, newRValue.getTypeName(), getTypeName());
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
	public String getValueAsString() {
		return Float.toString(getValue());
	}
	
}
