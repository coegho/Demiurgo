package gal.republica.coego.demiurgo.values;

import gal.republica.coego.demiurgo.exceptions.IllegalOperationException;
import gal.republica.coego.demiurgo.exceptions.ValueCastException;
import gal.republica.coego.demiurgo.lib.ValueData;
import gal.republica.coego.demiurgo.universe.World;

public abstract class AbstractValue implements IReturnValue {
	protected boolean writable = true;

	@Override
	public IReturnValue add(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue sub(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue mul(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue div(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue eq(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue neq(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue greq(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue leseq(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue great(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue less(IReturnValue another) throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue and(IReturnValue another) throws IllegalOperationException {
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
	public IReturnValue or(IReturnValue another) throws IllegalOperationException {
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
	public IReturnValue negative() throws IllegalOperationException {
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue not() throws IllegalOperationException {
		try {
			return new IntegerValue(!isTrue());
		} catch (ValueCastException e) {
			throw new IllegalOperationException();
		}
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
	public IReturnValue getFromIndex(int index) throws IllegalOperationException {
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
	public IReturnValue rebuild(World world) {
		return this;
	}
	
	public String[] getValueCodes() {
		String[] r = new String[3];
		r[0] = getType().name();
		return r;
	}
	
	@Override
	public ValueData valueData() {
		return new ValueData(getValueCodes(), getType());
	}
}