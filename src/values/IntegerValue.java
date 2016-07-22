package values;

import java.util.Random;

import exceptions.ValueCastException;

public class IntegerValue implements IReturnValue {
	protected int value;

	public IntegerValue(int value) {
		this.value = value;
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
	public IReturnValue add(IReturnValue other) {
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
		return null;
	}

	@Override
	public IReturnValue sub(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof ListValue) {
			return add(other.negative());
		}
		if (other instanceof StringValue) {
			// throw new Exception //TODO
		}
		return null;
	}

	@Override
	public IReturnValue mul(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue(getValue() * ((IntegerValue) other).getValue());
		}
		if (other instanceof FloatValue) {
			return new FloatValue((float) getValue() * ((FloatValue) other).getValue());
		}
		if (other instanceof StringValue) {
			// throw new Exception //TODO
		}
		if (other instanceof ListValue) {
			return other.mul(this);
		}
		return null;
	}

	@Override
	public IReturnValue div(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue(getValue() / ((IntegerValue) other).getValue());
		}
		if (other instanceof FloatValue) {
			return new FloatValue((float) getValue() / ((FloatValue) other).getValue());
		}
		if (other instanceof StringValue) {
			// throw new Exception //TODO
		}
		if (other instanceof ListValue) {
			ListValue av = (ListValue) other.cloneValue();
			for (int i = 0; i < av.getValue().size(); i++) {
				av.getValue().set(i, div(av.getValue().get(i)));
			}
			return av;
		}
		return null;
	}

	@Override
	public IReturnValue negative() {
		return new IntegerValue(-getValue());
	}

	@Override
	public IReturnValue eq(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() == ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() == ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof StringValue) {
			// TODO: throw exception
		}
		if (other instanceof ListValue) {
			return other.eq(this);
		}
		return null;
	}

	@Override
	public IReturnValue neq(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() != ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() != ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof StringValue) {
			// TODO: throw exception
		}
		if (other instanceof ListValue) {
			return other.neq(this);
		}
		return null;
	}

	@Override
	public IReturnValue greq(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() >= ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() >= ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof StringValue) {
			// TODO: throw exception
		}
		if (other instanceof ListValue) {
			return other.less(this);
		}
		return null;
	}

	@Override
	public IReturnValue leseq(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() <= ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() <= ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof StringValue) {
			// TODO: throw exception
		}
		if (other instanceof ListValue) {
			return other.great(this);
		}
		return null;
	}

	@Override
	public IReturnValue great(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() > ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() > ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof StringValue) {
			// TODO: throw exception
		}
		if (other instanceof ListValue) {
			return other.leseq(this);
		}
		return null;
	}

	@Override
	public IReturnValue less(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() < ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue(((float) getValue() < ((FloatValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof StringValue) {
			// TODO: throw exception
		}
		if (other instanceof ListValue) {
			return other.greq(this);
		}
		return null;
	}

	@Override
	public IReturnValue and(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			return new IntegerValue((isTrue() && other.isTrue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.and(this);
		}
		return null;
	}

	@Override
	public IReturnValue or(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			return new IntegerValue((isTrue() || other.isTrue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.or(this);
		}
		return null;
	}

	@Override
	public IReturnValue dice() {
		return new IntegerValue((new Random().nextInt(getValue())) + 1); // TODO:
																			// Optimize
																			// random
	}

	@Override
	public IReturnValue multDice(IReturnValue other) {
		ListValue lv = new ListValue();
		Random r = new Random(); // TODO: Optimize random

		if (other instanceof FloatValue || other instanceof StringValue) {
			// TODO: exception
		}

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

		return null;
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
	public IReturnValue getFromIndex(IReturnValue another) {
		// TODO Exception
		return null;
	}

	@Override
	public IReturnValue not() {
		return new IntegerValue(isTrue() ? 0 : 1);
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

	@Override
	public int getDepth() {
		return 0;
	}
}
