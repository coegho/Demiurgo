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
	public ValueInterface add(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.add(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).add(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "+");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "+");
	}

	@Override
	public ValueInterface sub(ValueInterface other) throws IllegalOperationException {
		return add(other.negative());
	}

	@Override
	public ValueInterface mul(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.mul(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).mul(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "*");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "*");
	}

	@Override
	public ValueInterface div(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.div(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).div(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "/");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "/");
	}

	@Override
	public ValueInterface negative() throws IllegalOperationException {
		ListValue lv = new ListValue();
		for (ValueInterface x : getValue()) {
			lv.getValue().add(x.negative());
		}
		return lv;
	}

	@Override
	public ValueInterface eq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.eq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).eq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "==");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "==");
	}

	@Override
	public ValueInterface neq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.neq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).neq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "!=");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "!=");
	}

	@Override
	public ValueInterface greq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.greq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).greq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), ">=");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), ">=");
	}

	@Override
	public ValueInterface leseq(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.leseq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).leseq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "<=");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "<=");
	}

	@Override
	public ValueInterface great(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.great(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).great(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), ">");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), ">");
	}

	@Override
	public ValueInterface less(ValueInterface other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.less(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).less(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "<");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "<");
	}

	@Override
	public ValueInterface and(ValueInterface other) throws IllegalOperationException {
		if (other instanceof ListValue) {
			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).and(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "&");
			}
		}
		else {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.and(other));
			}
			return av;
		}
	}

	@Override
	public ValueInterface or(ValueInterface other) throws IllegalOperationException {
		if (other instanceof ListValue) {
			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).or(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "|");
			}
		}
		else {
			ListValue av = new ListValue();
			for (ValueInterface x : getValue()) {
				av.getValue().add(x.or(other));
			}
			return av;
		}
	}

	@Override
	public ValueInterface dice() throws IllegalOperationException {
		ListValue lv = new ListValue();

		for (ValueInterface x : getValue()) {
			lv.getValue().add(x.dice());
		}
		return lv;
	}

	@Override
	public ValueInterface multDice(ValueInterface other) throws IllegalOperationException {
		ListValue lv = new ListValue();

		if (other instanceof FloatValue || other instanceof StringValue) {
			throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "xDy");
		}

		if (other instanceof IntegerValue) {
			for (ValueInterface x : getValue()) {
				lv.getValue().add(x.multDice(other));
			}
			return lv;
		}
		if (other instanceof ListValue) {
			if (getValue().size() == ((ListValue) other).getValue().size()) {
				List<ValueInterface> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = lv.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).multDice(b.get(i)));
				}
				return lv;
			} else {
				throw new SizeMismatchException(-1, -1, -1, getTypeName(), other.getTypeName(), "xDy");
			}
		}
		throw new IllegalOperationException(-1, -1, -1, getTypeName(), other.getTypeName(), "xDy");
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
		if(newRValue instanceof ListValue) {
			ListValue lv = (ListValue)newRValue;
			if(getInnerType() == ReturnValueTypes.OBJECT && !lv.classType.inheritFrom(classType))
				return false;
			return getDepth() == lv.getDepth() && (lv.getInnerType() == null || getInnerType() == lv.getInnerType());
		}
		return false;
	}
	
	@Override
	public boolean assign(ValueInterface newRValue) {
		if(!canAssign(newRValue)) {
			return false;
		}
		value = ((ListValue)newRValue).getValue();
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
		for(ValueInterface v : value) {
			v.rebuild(world);
		}
		return this;
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[1] = getInnerType().name();
		r[2] = "{";
		for(ValueInterface v : value) {
			r[2] += v.getValueCodes();
		}
		r[2] += "}";
		return r;
	}
	
	@Override
	public String getTypeName() {
		StringBuilder sb = new StringBuilder((getInnerType()!=null)?getInnerType().name():getType().name());
		for(int i=0;i<getDepth();i++) { sb.append("[]");}
		return sb.toString();
	}
	
	@Override
	public String getValueAsString() {
		List<String> strs = new ArrayList<>();
		for(ValueInterface l : getValue()) {
			strs.add(l.getValueAsString());
		}
		return "{" + String.join(", ", strs) + "}";
	}
}
