package values;

import java.util.ArrayList;
import java.util.List;

import exceptions.IllegalOperationException;
import exceptions.SizeMismatchException;
import exceptions.ValueCastException;
import gal.republica.coego.demiurgo.lib.ReturnValueTypes;
import universe.UserDefinedClass;
import universe.World;

public class ListValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<IReturnValue> value;
	protected ReturnValueTypes innerType;
	protected transient UserDefinedClass classType;
	protected String className;
	protected int listDepth;

	public ListValue(List<IReturnValue> value) {
		this.value = value;
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
	
	public static ListValue defaultValue(UserDefinedClass cl, int depth) {
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

	public List<IReturnValue> getValue() {
		return value;
	}

	public void setValue(List<IReturnValue> value) {
		this.value = value;
	}

	@Override
	public IReturnValue add(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.add(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).add(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue sub(IReturnValue other) throws IllegalOperationException {
		return add(other.negative());
	}

	@Override
	public IReturnValue mul(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.mul(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).mul(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue div(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.div(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).div(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue negative() throws IllegalOperationException {
		ListValue lv = new ListValue();
		for (IReturnValue x : getValue()) {
			lv.getValue().add(x.negative());
		}
		return lv;
	}

	@Override
	public IReturnValue eq(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.eq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).eq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue neq(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.neq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).neq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue greq(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.greq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).greq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue leseq(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.leseq(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).leseq(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue great(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.great(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).great(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue less(IReturnValue other) throws IllegalOperationException {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.less(other));
			}
			return av;
		}
		if (other instanceof ListValue) {

			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).less(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		throw new IllegalOperationException();
	}

	@Override
	public IReturnValue and(IReturnValue other) throws IllegalOperationException {
		if (other instanceof ListValue) {
			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).and(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		else {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.and(other));
			}
			return av;
		}
	}

	@Override
	public IReturnValue or(IReturnValue other) throws IllegalOperationException {
		if (other instanceof ListValue) {
			if (getValue().size() == ((ListValue) other).getValue().size()) {
				ListValue av = new ListValue();
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = av.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).or(b.get(i)));
				}
				return av;
			} else {
				throw new SizeMismatchException();
			}
		}
		else {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.or(other));
			}
			return av;
		}
	}

	@Override
	public IReturnValue dice() throws IllegalOperationException {
		ListValue lv = new ListValue();

		for (IReturnValue x : getValue()) {
			lv.getValue().add(x.dice());
		}
		return lv;
	}

	@Override
	public IReturnValue multDice(IReturnValue other) throws IllegalOperationException {
		ListValue lv = new ListValue();

		if (other instanceof FloatValue || other instanceof StringValue) {
			throw new IllegalOperationException();
		}

		if (other instanceof IntegerValue) {
			for (IReturnValue x : getValue()) {
				lv.getValue().add(x.multDice(other));
			}
			return lv;
		}
		if (other instanceof ListValue) {
			if (getValue().size() == ((ListValue) other).getValue().size()) {
				List<IReturnValue> a, b, out;
				a = this.getValue();
				b = ((ListValue) other).getValue();
				out = lv.getValue();

				for (int i = 0; i < a.size(); i++) {
					out.add(a.get(i).multDice(b.get(i)));
				}
				return lv;
			} else {
				throw new SizeMismatchException();
			}
		}
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
	public boolean canAssign(IReturnValue newRValue) {
		if(newRValue instanceof ListValue) {
			ListValue lv = (ListValue)newRValue;
			if(getInnerType() == ReturnValueTypes.OBJECT && !lv.classType.inheritFrom(classType))
				return false;
			return getDepth() == lv.getDepth() && getInnerType() == lv.getInnerType();
		}
		return false;
	}
	
	@Override
	public boolean assign(IReturnValue newRValue) {
		if(newRValue instanceof ListValue) {
			value = ((ListValue)newRValue).getValue();
			return true;
		}
		return false;
	}

	@Override
	public IReturnValue getFromIndex(int index) throws IllegalOperationException {
		return getValue().get(index);
	}
	
	public boolean set(int index, IReturnValue newRValue) {
		return getValue().get(index).assign(newRValue);
	}

	@Override
	public IReturnValue not() {
		return new IntegerValue(isTrue() ? 0 : 1);
	}

	@Override
	public boolean isTrue() {
		return getValue().size() != 0;
	}

	@Override
	public IReturnValue cloneValue() {
		List<IReturnValue> list = new ArrayList<>();
		for (IReturnValue x : getValue()) {
			list.add(x.cloneValue());
		}
		return new ListValue(list);
	}

	@Override
	public String toString() {
		String content = "";
		for (IReturnValue x : getValue()) {
			content += " " + x.toString() + " ";
		}
		return "LIST/[" + content + "]";
	}
	
	@Override
	public IReturnValue rebuild(World world) {
		this.classType = world.getClassFromName(className);
		for(IReturnValue v : value) {
			v.rebuild(world);
		}
		return this;
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[1] = getInnerType().name();
		r[2] = "{";
		for(IReturnValue v : value) {
			r[2] += v.getValueCodes();
		}
		r[2] += "}";
		return r;
	}
}
