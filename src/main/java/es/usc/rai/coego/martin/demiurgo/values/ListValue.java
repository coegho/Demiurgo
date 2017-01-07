package es.usc.rai.coego.martin.demiurgo.values;

import java.util.ArrayList;
import java.util.List;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.SizeMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.World;

public class ListValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<ValueInterface> value;
	protected ReturnValueTypes innerType;
	protected transient DemiurgoClass classType;
	protected String className;
	protected int listDepth;

	public ListValue(List<ValueInterface> value, int depth, ReturnValueTypes innerType) {
		this.value = value;
		this.listDepth = depth;
		this.innerType = innerType;
	}

	public ListValue() {
		this.value = new ArrayList<>();
	}

	public ListValue(List<ValueInterface> value) {
		this.value = value;
		if(value.size() > 0) {
			this.innerType = value.get(0).getInnerType();
			this.listDepth = value.get(0).getDepth()+1;
		}
	}

	public static ListValue defaultValue(ReturnValueTypes innerType, int depth) {
		ListValue lv = new ListValue();
		lv.setDepth(depth);
		lv.setInnerType(innerType);
		return lv;
	}

	public static ListValue defaultValue(DemiurgoClass cl, int depth) {
		ListValue lv = new ListValue();
		lv.setDepth(depth);
		lv.setInnerType(ReturnValueTypes.OBJECT);
		lv.classType = cl;
		lv.className = cl.getClassName();
		return lv;
	}

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.LIST;
	}

	@Override
	public ReturnValueTypes getInnerType() {
		return innerType;
	}

	public void setInnerType(ReturnValueTypes innerType) {
		this.innerType = innerType;
	}

	@Override
	public int getDepth() {
		return listDepth;
	}

	public void setDepth(int depth) {
		this.listDepth = depth;
	}

	public List<ValueInterface> getValue() {
		return value;
	}

	public void setValue(List<ValueInterface> value) {
		this.value = value;
	}

	@Override
	public ValueInterface add(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.add(r); });
	}

	@Override
	public ValueInterface sub(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.sub(r); });
	}

	@Override
	public ValueInterface mul(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.mul(r); });
	}

	@Override
	public ValueInterface div(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.div(r); });
	}

	@Override
	public ValueInterface negative() throws IllegalOperationException {
		return doListOperation(this, 0, (v) -> { return v.negative(); });
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.eq(r); });
	}

	@Override
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.neq(r); });
	}

	@Override
	public ValueInterface greq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.greq(r); });
	}

	@Override
	public ValueInterface leseq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.leseq(r); });
	}

	@Override
	public ValueInterface great(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.great(r); });
	}

	@Override
	public ValueInterface less(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.less(r); });
	}

	@Override
	public ValueInterface and(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.and(r); });
	}

	@Override
	public ValueInterface or(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.or(r); });
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		return doListOperation(this, 0, (l) -> { return l.dice(); });
	}

	/**
	 * Performs a multiple dice roll.
	 * <p>
	 * Examples:
	 * <p>
	 * {2,3}d6 -> {{d6, d6}, {d6, d6, d6}}
	 * <p>
	 * {2,3}d{6,10} -> {{d6, d6}, {d10, d10, d10}}
	 * <p>
	 * {{1,2},{3,4}}d10 -> {{{d10},{d10,d10}},{{d10,d10d10},{d10,d10,d10,d10}}}
	 * <p>
	 * {2,3}d{{6,12},{10,20}} -> {{{d6,d6},{d12,d12}},
	 * {{d10,d10,d10},{d20,d20,d20}}}
	 */
	@Override
	public ValueInterface multDice(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l,r) -> { return l.multDice(r); });
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
		String content = "";
		for (ValueInterface x : getValue()) {
			content += " " + x.castToString() + " ";
		}
		return "[" + content + "]";
	}

	@Override
	public boolean canAssign(ValueInterface newRValue) {
		if (newRValue instanceof ListValue) {
			ListValue lv = (ListValue) newRValue;
			if (getInnerType() == ReturnValueTypes.OBJECT && !lv.classType.inheritFrom(classType))
				return false;
			return getDepth() == lv.getDepth() && (lv.getInnerType() == null || getInnerType() == lv.getInnerType());
		}
		return false;
	}

	@Override
	public boolean assign(ValueInterface newRValue) {
		if (!canAssign(newRValue)) {
			return false;
		}
		value = ((ListValue) newRValue).getValue();
		return true;
	}

	@Override
	public ValueInterface getFromIndex(int index) throws IllegalOperationException {
		return getValue().get(index);
	}

	public boolean set(int index, ValueInterface newRValue) {
		return getValue().get(index).assign(newRValue);
	}

	@Override
	public ValueInterface not() {
		return new IntegerValue(isTrue() ? 0 : 1);
	}

	@Override
	public boolean isTrue() {
		return getValue().size() != 0;
	}

	@Override
	public ValueInterface cloneValue() {
		List<ValueInterface> list = new ArrayList<>();
		for (ValueInterface x : getValue()) {
			list.add(x.cloneValue());
		}
		return new ListValue(list, listDepth, innerType);
	}

	@Override
	public String toString() {
		String content = "";
		for (ValueInterface x : getValue()) {
			content += " " + x.toString() + " ";
		}
		return "LIST/[" + content + "]";
	}

	@Override
	public ValueInterface rebuild(World world) {
		this.classType = world.getClassFromName(className);
		for (ValueInterface v : value) {
			v.rebuild(world);
		}
		return this;
	}

	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[1] = getInnerType().name();
		r[2] = "{";
		for (ValueInterface v : value) {
			r[2] += v.getValueCodes();
		}
		r[2] += "}";
		return r;
	}

	@Override
	public String getTypeName() {
		StringBuilder sb = new StringBuilder((getInnerType() != null) ? getInnerType().name() : getType().name());
		for (int i = 0; i < getDepth(); i++) {
			sb.append("[]");
		}
		return sb.toString();
	}

	@Override
	public String getValueAsString() {
		List<String> strs = new ArrayList<>();
		for (ValueInterface l : getValue()) {
			strs.add(l.getValueAsString());
		}
		return "{" + String.join(", ", strs) + "}";
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
}
