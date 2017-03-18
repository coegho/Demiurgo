package es.usc.rai.coego.martin.demiurgo.values;

import java.util.ArrayList;
import java.util.List;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;

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
	public ValueInterface add(ValueInterface another) throws IllegalOperationException {
		if (another instanceof IntegerValue) {
			return new StringValue(getValue() + Integer.toString(((IntegerValue) another).getValue()));
		}
		if (another instanceof FloatValue) {
			return new StringValue(getValue() + Float.toString(((FloatValue) another).getValue()));
		}
		if (another instanceof StringValue) {
			return new StringValue(getValue() + ((StringValue) another).getValue());
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.add(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "+");
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		if (another instanceof StringValue) {
			return new IntegerValue(getValue().equalsIgnoreCase(((StringValue) another).getValue()));
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.eq(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "==");
	}

	@Override
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException {
		if (another instanceof StringValue) {
			return new IntegerValue(!getValue().equalsIgnoreCase(((StringValue) another).getValue()));
		}
		if (another instanceof ListValue) {
			return doListOperation(this, another, 0, (l,r) -> { return l.neq(r); });
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "!=");
	}
	
	@Override
	public int castToInteger() throws ValueCastException {
		try {
			return Integer.parseInt(value);
		} catch(NumberFormatException ex) {
			throw new ValueCastException(-1, -1, -1, getTypeName(), "INT");
		}
	}

	@Override
	public float castToFloat() throws ValueCastException {
		try {
			return Float.parseFloat(value);
		} catch(NumberFormatException ex) {
			throw new ValueCastException(-1, -1, -1, getTypeName(), "FLOAT");
		}
	}

	@Override
	public String castToString() throws ValueCastException {
		return value;
	}
	
	@Override
	public List<ValueInterface> castToList() throws ValueCastException {
		List<ValueInterface> output = new ArrayList<>();
		for(char c : value.toCharArray()) {
			output.add(new StringValue(String.valueOf(c)));
		}
		return output;
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
	public void assign(ValueInterface newRValue) throws ValueCastException {
		try {
			value = newRValue.castToString();
		} catch(ValueCastException ex) {
			throw ex;
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
	public String getValueAsString() {
		return '"'+getValue()+'"';
	}
	
	
}
