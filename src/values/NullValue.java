package values;

public class NullValue extends AbstractValue {

	@Override
	public boolean canAssign(IReturnValue newRValue) {
		return false;
	}

	@Override
	public boolean assign(IReturnValue newRValue) {
		return false;
	}

	@Override
	public IReturnValue cloneValue() {
		return new NullValue();
	}

	@Override
	public ReturnValueTypes getType() {
		return null;
	}

}
