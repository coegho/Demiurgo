package values;

import gal.republica.coego.demiurgo.lib.ReturnValueTypes;
import universe.UserDefinedClass;
import universe.World;
import universe.WorldObject;

public class ObjectValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient UserDefinedClass itsClass;
	protected transient WorldObject obj;
	protected String className;
	protected long obj_id;
	
	public ObjectValue(WorldObject obj) {
		this.obj = obj;
		this.itsClass = obj.getUserClass();
		obj_id = obj.getId();
		className = itsClass.getClassName();
	}
	
	/**
	 * Creates an empty ObjectValue with a class defined.
	 * @param itsClass Object's class.
	 */
	public ObjectValue(UserDefinedClass itsClass) {
		this.itsClass = itsClass;
		className = itsClass.getClassName();
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
		obj_id = obj.getId();
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
				obj_id = obj.getId();
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
		return "OBJ/" + className + "/"+ obj_id;
	}
	
	@Override
	public IReturnValue rebuild(World world) {
		this.itsClass = world.getClassFromName(className);
		this.obj = world.getObject(obj_id);
		return this;
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[1] = className;
		r[2] = Long.toString(obj_id);
		return r;
	}
}
