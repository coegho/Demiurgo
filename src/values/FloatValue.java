package values;

import exceptions.ValueCastException;

public class FloatValue implements IReturnValue {

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
	public IReturnValue add(IReturnValue other) {
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
		return null;
	}

	@Override
	public IReturnValue sub(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof ListValue) {
			return negative().add(other);
		}
		if (other instanceof StringValue) {
			// throw new Exception //TODO
		}
		return null;
	}

	@Override
	public IReturnValue mul(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new FloatValue(getValue() * ((IntegerValue) other).getValue());
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
			return new FloatValue(getValue() / ((IntegerValue) other).getValue());
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
		return new FloatValue(-getValue());
	}

	@Override
	public IReturnValue eq(IReturnValue other) {
		if (other instanceof IntegerValue) {
			return new IntegerValue((getValue() == ((IntegerValue) other).getValue()) ? 1 : 0);
		}
		if (other instanceof FloatValue) {
			return new IntegerValue((getValue() == ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue((getValue() >= ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue((getValue() <= ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue((getValue() > ((FloatValue) other).getValue()) ? 1 : 0);
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
			return new IntegerValue((getValue() < ((FloatValue) other).getValue()) ? 1 : 0);
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
		if (other instanceof IntegerValue) {
			return new FloatValue((float)Math.pow(getValue(), ((IntegerValue) other).getValue()));
		}
		if (other instanceof FloatValue) {
			return new FloatValue((float)Math.pow(getValue(), ((FloatValue) other).getValue()));
		}
		if(other instanceof StringValue) {
			//TODO: throw exception
		}
		if (other instanceof ListValue) {
			ListValue lv = new ListValue();
			for (IReturnValue x : ((ListValue)other).getValue()) {
				lv.getValue().add(exponent(x));
			}
			return lv;
		}
		return null;
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
	public boolean assign(IReturnValue newRValue) {
		try {
			value = newRValue.castToFloat();
			return true;
		} catch(ValueCastException ex) {
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
		return new FloatValue(this.getValue());
	}
	
	@Override
	public String toString() {
		return "{FLOAT=" + getValue() + "}";
	}
	
	@Override
	public int getDepth() {
		return 0;
	}
}
