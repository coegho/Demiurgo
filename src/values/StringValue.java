package values;

import exceptions.IllegalOperationException;
import exceptions.ValueCastException;

public class StringValue extends AbstractValue {
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
	public IReturnValue add(IReturnValue other) throws IllegalOperationException {
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
	public IReturnValue eq(IReturnValue other) throws IllegalOperationException {
		if (other instanceof StringValue) {
			return new IntegerValue((getValue() == ((StringValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.eq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue neq(IReturnValue other) throws IllegalOperationException {
		if (other instanceof StringValue) {
			return new IntegerValue((getValue() != ((StringValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof ListValue) {
			return other.neq(this);
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue dice() throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue multDice(IReturnValue another) throws IllegalOperationException {
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
	public boolean canAssign(IReturnValue newRValue) {
		try {
			newRValue.castToString();
			return true;
		} catch(ValueCastException ex) {
			return false;
		}
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
	public boolean isTrue() {
		return getValue() != "";
	}

	@Override
	public IReturnValue cloneValue() {
		return new StringValue(this.getValue());
	}

	@Override
	public String toString() {
		return "STRING/\"" + getValue() + "\"";
	}
}
