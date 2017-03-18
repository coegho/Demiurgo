package es.usc.rai.coego.martin.demiurgo.values;

import java.util.ArrayList;
import java.util.List;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.MissingInventoryException;
import es.usc.rai.coego.martin.demiurgo.exceptions.SizeMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.World;

public abstract class AbstractValue implements ValueInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean writable = true;

	@Override
	public ValueInterface add(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "+");
	}

	@Override
	public ValueInterface sub(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "-");
	}

	@Override
	public ValueInterface mul(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "*");
	}

	@Override
	public ValueInterface div(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "/");
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "==");
	}

	@Override
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "!=");
	}

	@Override
	public ValueInterface greq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), ">=");
	}

	@Override
	public ValueInterface leseq(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "<=");
	}

	@Override
	public ValueInterface great(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), ">");
	}

	@Override
	public ValueInterface less(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "<");
	}

	@Override
	public ValueInterface and(ValueInterface another) throws IllegalOperationException {
		if (another instanceof ListValue) {
			return another.and(this);
		} else
			try {
				return new IntegerValue(isTrue() && another.isTrue());
			} catch (ValueCastException e) {
				throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "&");
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
				throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "|");
			}
	}

	@Override
	public ValueInterface negative() throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), getTypeName(), "-x");
	}

	@Override
	public ValueInterface not() throws IllegalOperationException {
		try {
			return new IntegerValue(!isTrue());
		} catch (ValueCastException e) {
			throw new IllegalOperationException(-1, -1, -1, getTypeName(), getTypeName(), "!");
		}
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), getTypeName(), "Dx");
	}

	@Override
	public ValueInterface multDice(ValueInterface another) throws IllegalOperationException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "xDy");
	}

	@Override
	public int castToInteger() throws ValueCastException {
		throw new ValueCastException(-1, -1, -1, getTypeName(), "INT");
	}

	@Override
	public float castToFloat() throws ValueCastException {
		throw new ValueCastException(-1, -1, -1, getTypeName(), "FLOAT");
	}

	@Override
	public String castToString() throws ValueCastException {
		throw new ValueCastException(-1, -1, -1, getTypeName(), "STRING");
	}
	
	@Override
	public List<ValueInterface> castToList() throws ValueCastException {
		throw new ValueCastException(-1, -1, -1, getTypeName(), "STRING");
	}

	@Override
	public ValueInterface getFromIndex(int index) throws IllegalOperationException, MissingInventoryException {
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), "INT", "[]");
	}

	@Override
	public int getDepth() {
		return 0;
	}

	@Override
	public boolean isTrue() throws ValueCastException {
		throw new ValueCastException(-1, -1, -1, getTypeName(), "INT");
	}

	@Override
	public void setWritable(boolean writable) {
		this.writable = writable;
	}

	@Override
	public ValueInterface rebuild(World world) {
		return this;
	}

	@Override
	public String getTypeName() {
		return getType().name();
	}
	
	@Override
	public ReturnValueTypes getInnerType() {
		return getType();
	}
	
	@Override
	public void assign(ValueInterface newRValue) throws ValueCastException {
		throw new ValueCastException(-1, -1, -1, newRValue.getTypeName(), getTypeName());
	}
	
	public static ValueInterface doListOperation(ValueInterface left, ValueInterface right, int depth,
			BinaryFunction operation) throws IllegalOperationException {
		List<ValueInterface> output = new ArrayList<>();
		if (left.getDepth() < right.getDepth()) {
			List<ValueInterface> rightList = ((ListValue) right.cloneValue()).getValue();
			for(ValueInterface v : rightList) {
				output.add(doListOperation(left, v, depth, operation));
			}
		}
		else if (left.getDepth() > right.getDepth()) {
			List<ValueInterface> leftList = ((ListValue) left.cloneValue()).getValue();
			for(ValueInterface v : leftList) {
				output.add(doListOperation(v, right, depth, operation));
			}
		}
		
		// same depth
		
		else if(left.getDepth() > depth) {
			// two lists
			List<ValueInterface> leftList = ((ListValue) left.cloneValue()).getValue();
			List<ValueInterface> rightList = ((ListValue) right.cloneValue()).getValue();
			if(leftList.size() == rightList.size()) {
				//same size
				for(int i=0; i<leftList.size();i++) {
					output.add(doListOperation(leftList.get(i), rightList.get(i), depth, operation));
				}
			}
			else {
				throw new SizeMismatchException(-1, -1, -1, left.getTypeName(), right.getTypeName());
			}
		} else {
			//two objects
			return operation.apply(left, right);
		}

		return new ListValue(output);
	}
	
	public static ValueInterface doListOperation(ValueInterface value, int depth,
			UnaryFunction operation) throws IllegalOperationException {
		if(value.getDepth() > depth) {
			List<ValueInterface> output = new ArrayList<>();
			for (ValueInterface x : ((ListValue)value).getValue()) {
				output.add(doListOperation(x, depth, operation));
			}
			return new ListValue(output);
		}
		else {
			return operation.apply(value);
		}
	}
	
	@Override
	public void clearObjectReferences(DemiurgoObject obj) {
		// nothing to do
	}
}
