package values;

import java.util.Random;

import exceptions.IllegalOperationException;
import exceptions.ValueCastException;

public class IntegerValue extends AbstractValue {
	protected int value;

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
	public IReturnValue add(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue sub(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof ListValue) {
			return add(other.negative());
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue mul(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue div(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue negative() throws IllegalOperationException {
		return new IntegerValue(-getValue());
	}

	@Override
	public IReturnValue eq(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue neq(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue greq(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue leseq(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue great(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue less(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue dice() throws IllegalOperationException {
		return new IntegerValue((new Random().nextInt(getValue())) + 1); // TODO:
																			// Optimize
																			// random
	}

	@Override
	public IReturnValue multDice(IReturnValue other) throws IllegalOperationException {
		ListValue lv = new ListValue();
		Random r = new Random(); // TODO: Optimize random

		if (other instanceof IntegerValue) {
			for (int i = 0; i < getValue(); i++) {
				lv.getValue().add(new IntegerValue((r.nextInt(((IntegerValue) other).getValue())) + 1));
			}
			return lv;
		}
		if (other instanceof ListValue) {
			for (IReturnValue x : ((ListValue) other).getValue()) {
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
	public boolean canAssign(IReturnValue newRValue) {
		try {
			newRValue.castToInteger();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
	}

	@Override
	public boolean assign(IReturnValue newRValue) {
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
	public IReturnValue cloneValue() {
		return new IntegerValue(this.getValue());
	}

	@Override
	public String toString() {
		return "{INT=" + getValue() + "}";
	}
}
