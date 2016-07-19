package values;

import universe.WorldObject;

public class ObjectValue implements IReturnValue {
	protected WorldObject obj;

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.OBJECT;
	}
	
	public WorldObject getObj() {
		return obj;
	}

	public void setObj(WorldObject obj) {
		this.obj = obj;
	}

	public ObjectValue(WorldObject obj) {
		this.obj = obj;
	}
	
	@Override
	public IReturnValue add(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue sub(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue mul(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue div(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue eq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue neq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue greq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue leseq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue great(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue less(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue and(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue or(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue negative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue not() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue dice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue multDice(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue exponent(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue getFromIndex(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue cloneValue() {
		return new ObjectValue(obj);
	}

	@Override
	public boolean isTrue() {
		return obj != null;
	}

	@Override
	public String toString() {
		return "{OBJ=" + obj.getId() + "}";
	}
	
	@Override
	public int getDepth() {
		return 0;
	}
}
