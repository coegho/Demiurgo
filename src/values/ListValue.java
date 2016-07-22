package values;

import java.util.ArrayList;
import java.util.List;

import exceptions.ValueCastException;

public class ListValue implements IReturnValue {
	protected List<IReturnValue> value;
	protected ReturnValueTypes innerType;
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
	public IReturnValue add(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue sub(IReturnValue other) {
		return add(other.negative());

	}

	@Override
	public IReturnValue mul(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue div(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue negative() {
		ListValue lv = new ListValue();
		for (IReturnValue x : getValue()) {
			lv.getValue().add(x.negative());
		}
		return lv;
	}

	@Override
	public IReturnValue eq(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue neq(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue greq(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue leseq(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue great(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue less(IReturnValue other) {
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue and(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.and(other));
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
					out.add(a.get(i).and(b.get(i)));
				}
				return av;
			} else {
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue or(IReturnValue other) {
		if (other instanceof IntegerValue || other instanceof FloatValue || other instanceof StringValue) {
			ListValue av = new ListValue();
			for (IReturnValue x : getValue()) {
				av.getValue().add(x.or(other));
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
					out.add(a.get(i).or(b.get(i)));
				}
				return av;
			} else {
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}
		return null;
	}

	@Override
	public IReturnValue dice() {
		ListValue lv = new ListValue();

		for (IReturnValue x : getValue()) {
			lv.getValue().add(x.dice());
		}
		return lv;
	}

	@Override
	public IReturnValue multDice(IReturnValue other) {
		ListValue lv = new ListValue();

		if (other instanceof FloatValue || other instanceof StringValue) {
			// TODO: exception
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
				// throw new Exception("Number of elements doesn't match");
				// //TODO
			}
		}

		return null;
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
	public IReturnValue getFromIndex(IReturnValue another) {
		if (another instanceof IntegerValue) {
			return getValue().get(((IntegerValue) another).getValue());
		} else {
			// TODO: exception
		}
		return null;
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
		return "{LIST=[" + content + "]}";
	}
}
