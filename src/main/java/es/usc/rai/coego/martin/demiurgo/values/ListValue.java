package es.usc.rai.coego.martin.demiurgo.values;

import java.util.ArrayList;
import java.util.List;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.World;

public class ListValue extends AbstractValue implements ClassTyped {
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
		if (value.size() > 0) {
			setInnerType(value.get(0).getInnerType());
			setDepth(value.get(0).getDepth() + 1);
			if(value.get(0).getInnerType() == ReturnValueTypes.OBJECT) {
				classType = ((ObjectValue)value.get(0)).getObj().getDemiurgoClass();
				
			}
		} else {
			this.listDepth = 1;
		}
	}

	/**
	 * Completely empty list, useful for types only.
	 * 
	 * @return
	 */
	public static ListValue defaultValue() {
		ListValue lv = new ListValue();
		return lv;
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
		return doListOperation(this, another, 0, (l, r) -> {
			return l.add(r);
		});
	}

	@Override
	public ValueInterface sub(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.sub(r);
		});
	}

	@Override
	public ValueInterface mul(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.mul(r);
		});
	}

	@Override
	public ValueInterface div(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.div(r);
		});
	}

	@Override
	public ValueInterface negative() throws IllegalOperationException {
		return doListOperation(this, 0, (v) -> {
			return v.negative();
		});
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.eq(r);
		});
	}

	@Override
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.neq(r);
		});
	}

	@Override
	public ValueInterface greq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.greq(r);
		});
	}

	@Override
	public ValueInterface leseq(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.leseq(r);
		});
	}

	@Override
	public ValueInterface great(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.great(r);
		});
	}

	@Override
	public ValueInterface less(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.less(r);
		});
	}

	@Override
	public ValueInterface and(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.and(r);
		});
	}

	@Override
	public ValueInterface or(ValueInterface another) throws IllegalOperationException {
		return doListOperation(this, another, 0, (l, r) -> {
			return l.or(r);
		});
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		return doListOperation(this, 0, (l) -> {
			return l.dice();
		});
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
		return doListOperation(this, another, 0, (l, r) -> {
			return l.multDice(r);
		});
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
		List<String> strs = new ArrayList<>();
		for (ValueInterface l : getValue()) {
			strs.add(l.getValueAsString());
		}
		return "{" + String.join(", ", strs) + "}";
	}

	@Override
	public List<ValueInterface> castToList() throws ValueCastException {
		return ((ListValue) this.cloneValue()).getValue();
	}

	@Override
	public boolean canAssign(ValueInterface newRValue) {
		try {
			ListValue lv = new ListValue(newRValue.castToList());
			if ((lv.getInnerType() == ReturnValueTypes.OBJECT) && (classType != null && !lv.classType.inheritFrom(classType)))
				return false;
			return (getDepth() == 0 || getDepth() == lv.getDepth())
					&& (getInnerType() == null || lv.getValue().size() == 0 || getInnerType() == lv.getInnerType());
		} catch (ValueCastException e) {
			return false;
		}
	}

	@Override
	public void assign(ValueInterface newRValue) throws ValueCastException {
		try {
			if (canAssign(newRValue)) {
				ListValue lv = new ListValue(newRValue.castToList());
				this.setValue(lv.getValue());
				this.setDepth(lv.getDepth());
				this.setInnerType(lv.getInnerType());
				this.setClassType(lv.getClassType());
			}
			else
				throw new ValueCastException(-1, -1, -1, newRValue.getTypeName(), getTypeName());
		} catch (ValueCastException e) {
			throw e;
		}
	}

	@Override
	public void setClassType(DemiurgoClass cl) {
		this.classType = cl;
		if(classType != null)
		this.className = cl.getClassName();
	}

	@Override
	public DemiurgoClass getClassType() {
		return classType;
	}

	@Override
	public ValueInterface getFromIndex(int index) throws IllegalOperationException {
		return getValue().get(index);
	}

	/*public boolean set(int index, ValueInterface newRValue) {
		return getValue().get(index).assign(newRValue);
	}*/

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
		ListValue lv = new ListValue(list);
		lv.setClassType(getClassType());
		lv.setInnerType(getInnerType());
		return lv;
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
	
	@Override
	public void clearObjectReferences(DemiurgoObject obj) {
		for(ValueInterface i : value) {
			i.clearObjectReferences(obj);
		}
	}
}