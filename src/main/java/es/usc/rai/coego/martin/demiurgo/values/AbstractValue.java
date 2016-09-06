package es.usc.rai.coego.martin.demiurgo.values;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.World;

public abstract class AbstractValue implements ValueInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean writable = true;

	@Override
	public ValueInterface add(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface sub(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface mul(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface div(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface greq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface leseq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface great(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface less(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface and(ValueInterface another) throws IllegalOperationException {
		if (another instanceof ListValue) {
			return another.and(this);
		} else
			try {
				return new IntegerValue(isTrue() && another.isTrue());
			} catch (ValueCastException e) {
				throw new IllegalOperationException();
			}
	}

	@Override
	public ValueInterface or(ValueInterface another) throws IllegalOperationException {
		if (another instanceof ListValue) {
			return another.or(this);
		} else
			try {
				return new IntegerValue(isTrue() || another.isTrue());
			} catch (ValueCastException e) {
				throw new IllegalOperationException();
			}
	}

	@Override
	public ValueInterface negative() throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface not() throws IllegalOperationException {
		try {
			return new IntegerValue(!isTrue());
		} catch (ValueCastException e) {
			throw new IllegalOperationException();
		}
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public ValueInterface multDice(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public int castToInteger() throws ValueCastException {
		throw new ValueCastException();
	}

	@Override
	public float castToFloat() throws ValueCastException {
		throw new ValueCastException();
	}

	@Override
	public String castToString() throws ValueCastException {
		throw new ValueCastException();
	}

	@Override
	public ValueInterface getFromIndex(int index) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public int getDepth() {
		return 0;
	}

	@Override
	public boolean isTrue() throws ValueCastException {
		throw new ValueCastException();
	}

	@Override
	public void setWritable(boolean writable) {
		this.writable = writable;
	}

	@Override
	public ValueInterface rebuild(World world) {
		return this;
	}
	
	@Deprecated
	public String[] getValueCodes() {
		String[] r = new String[3];
		r[0] = getType().name();
		return r;
	}
	
	@Override
	public ObjectNode toJSON() {
		ObjectMapper om = new ObjectMapper();
		ObjectNode json = om.createObjectNode();
		json.put("type", getType().name());
		return json;
	}
}
