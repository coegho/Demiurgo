package es.usc.rai.coego.martin.demiurgo.values;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public ValueInterface add(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() + ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new FloatValue((float) getValue() + ((FloatValue) another).getValue());
		}
		if (another instanceof StringValue) {
			return new StringValue(Integer.toString(getValue()) + ((StringValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.add(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "+");
	}

	@Override
	public ValueInterface sub(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() - ((IntegerValue) another).getValue());
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
			return new IntegerValue(getValue() * ((IntegerValue) another).getValue());
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
			return new IntegerValue(getValue() / ((IntegerValue) another).getValue());
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
		return new IntegerValue(-getValue());
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new IntegerValue(getValue() == ((IntegerValue) another).getValue());
		}
		if (another instanceof FloatValue) {
			return new IntegerValue((float) getValue() == ((FloatValue) another).getValue());
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
			return new IntegerValue((float) getValue() >= ((FloatValue) another).getValue());
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
			return new IntegerValue((float) getValue() <= ((FloatValue) another).getValue());
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
			return new IntegerValue((float) getValue() > ((FloatValue) another).getValue());
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
			return new IntegerValue((float) getValue() < ((FloatValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.less(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "<");
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		return new IntegerValue((r.nextInt(getValue())) + 1);
	}

	/**
	 * Performs a multiple dice roll.
	 * <p>
	 * Examples:
	 * <p>
	 * 4d6 -> {d6, d6, d6, d6}
	 * <p>
	 * 3d{6,10} -> {{d6, d6, d6}, {d10, d10, d10}}
	 * <p>
	 * 3d{{6,12},{10,20}} -> {{{d6,d6,d6}, {d12,d12,d12}}, {{d10,d10,d10}, {d20,d20,d20}}}
	 */
	@Override
	public ValueInterface multDice(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			List<ValueInterface> output = new ArrayList<>();
			for (int i = 0; i < getValue(); i++) {
				output.add(another.dice());
			}
			return new ListValue(output);
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.multDice(r); });
		}

		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "xDy");
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
	public void assign(ValueInterface newRValue) throws ValueCastException {
		if(canAssign(newRValue))
			try {
				value = newRValue.castToInteger();;
			} catch (ValueCastException ex) {
				throw ex;
			}
		else
			throw new ValueCastException(-1, -1, -1, newRValue.getTypeName(), getTypeName());
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
	public String getValueAsString() {
		return Integer.toString(getValue());
	}
}
