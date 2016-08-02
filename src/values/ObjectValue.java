package values;

import exceptions.IllegalOperationException;
import exceptions.ValueCastException;
import universe.UserDefinedClass;
import universe.WorldObject;

public class ObjectValue extends AbstractValue {
	protected UserDefinedClass itsClass;
	protected WorldObject obj;
	
	public ObjectValue(WorldObject obj) {
		this.obj = obj;
		this.itsClass = obj.getUserClass();
	}
	
	/**
	 * Creates an empty ObjectValue with a class defined.
	 * @param itsClass Object's class.
	 */
	public ObjectValue(UserDefinedClass itsClass) {
		this.itsClass = itsClass;
	}

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.OBJECT;
	}
	
	public static ObjectValue defaultValue(UserDefinedClass itsClass) {
		return new ObjectValue(itsClass);
	}
	
	public WorldObject getObj() {
		return obj;
	}

	public void setObj(WorldObject obj) {
		this.obj = obj;
	}
	
	@Override
	public boolean canAssign(IReturnValue newRValue) {
		if (newRValue instanceof ObjectValue) {
			ObjectValue o = (ObjectValue)newRValue;
			//check polymorphism
			return (o.getObj().getUserClass().inheritFrom(itsClass));
		}
		return false;
	}

	@Override
	public boolean assign(IReturnValue newRValue) {
		if(newRValue instanceof ObjectValue) {
			ObjectValue o = (ObjectValue)newRValue;
			//check polymorphism
			if(o.getObj().getUserClass().inheritFrom(itsClass)) {
				obj = o.getObj();
				return true;
			}
		}
		return false;
	}

	@Override
	public IReturnValue cloneValue() {
		return new ObjectValue(obj);
	}

	@Override
	public String toString() {
		return "{OBJ=" + obj.getId() + "}";
	}
}
