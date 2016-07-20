package values;

import exceptions.ValueCastException;

public class StringValue implements IReturnValue {
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
	public IReturnValue add(IReturnValue other) {
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
		return null;
	}

	@Override
	public IReturnValue sub(IReturnValue other) {
		// throw new Exception //TODO
		return null;
	}

	@Override
	public IReturnValue mul(IReturnValue other) {
		// throw new Exception //TODO
		return null;
	}

	@Override
	public IReturnValue div(IReturnValue other) {
		// throw new Exception //TODO
		return null;
	}

	@Override
	public IReturnValue negative() {
		// throw new Exception //TODO
		return null;
	}

	@Override
	public IReturnValue eq(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue) {
			// throw new Exception //TODO
		}
		if (other instanceof StringValue) {
			return new IntegerValue((getValue() == ((StringValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.eq(this);
		}
		return null;
	}

	@Override
	public IReturnValue neq(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue) {
			// throw new Exception //TODO
		}
		if (other instanceof StringValue) {
			return new IntegerValue((getValue() != ((StringValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.neq(this);
		}
		return null;
	}

	@Override
	public IReturnValue greq(IReturnValue other) {
		// throw new Exception //TODO
		return null;
	}

	@Override
	public IReturnValue leseq(IReturnValue other) {
		// throw new Exception //TODO
		return null;
	}

	@Override
	public IReturnValue great(IReturnValue other) {
		// throw new Exception //TODO
		return null;
	}

	@Override
	public IReturnValue less(IReturnValue other) {
		// throw new Exception //TODO
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
		// TODO: exception
		return null;
	}

	@Override
	public IReturnValue multDice(IReturnValue another) {
		// TODO: exception
		return null;
	}

	@Override
	public IReturnValue exponent(IReturnValue other) {
		// TODO: throw exception
		return null;
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
	public boolean assign(IReturnValue newRValue) {
		try {
			value = newRValue.castToString();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
	}

	@Override
	public IReturnValue getFromIndex(IReturnValue another) {
		// TODO exception
		return null;
	}

	@Override
	public IReturnValue not() {
		return new IntegerValue(isTrue() ? 0 : 1);
	}

	@Override
	public boolean isTrue() {
		return getValue() != "";
	}

	@Override
	public IReturnValue cloneValue() {
		return new StringValue(this.getValue());
	}

	@Override
	public String toString() {
		return "{STRING=\"" + getValue() + "\"}";
	}
	
	@Override
	public int getDepth() {
		return 0;
	}
}
