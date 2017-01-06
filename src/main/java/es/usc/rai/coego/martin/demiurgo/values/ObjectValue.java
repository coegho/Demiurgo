package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.World;

public class ObjectValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient DemiurgoClass itsClass;
	protected transient DemiurgoObject obj;
	protected String className;
	protected long obj_id;
	
	public ObjectValue(DemiurgoObject obj) {
		setObj(obj);
		this.itsClass = obj.getUserClass();
		obj_id = obj.getId();
		className = itsClass.getClassName();
	}
	
	/**
	 * Creates an empty ObjectValue with a class defined.
	 * @param itsClass Object's class.
	 */
	public ObjectValue(DemiurgoClass itsClass) {
		this.itsClass = itsClass;
		className = itsClass.getClassName();
	}
	
	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		if(another instanceof ObjectValue) {
			return new IntegerValue(getObj().getId() == ((ObjectValue)another).getObj().getId());
		}
		else {
			throw new IllegalOperationException(-1, -1, -1, getTypeName(), another.getTypeName(), "!=");
		}
	}

	@Override
	public ValueInterface neq(ValueInterface another) throws IllegalOperationException {
		return eq(another).not();
	}

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.OBJECT;
	}
	
	public static ObjectValue defaultValue(DemiurgoClass itsClass) {
		return new ObjectValue(itsClass);
	}
	
	public DemiurgoObject getObj() {
		return obj;
	}

	public void setObj(DemiurgoObject obj) {
		this.obj = obj;
		obj_id = (obj!=null)?(obj.getId()):-1;
	}
	
	@Override
	public boolean canAssign(ValueInterface newRValue) {
		if (newRValue instanceof ObjectValue) {
			ObjectValue o = (ObjectValue)newRValue;
			//check polymorphism
			return (o.getObj().getUserClass().inheritFrom(itsClass));
		}
		return false;
	}

	@Override
	public boolean assign(ValueInterface newRValue) {
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
	public ValueInterface cloneValue() {
		return new ObjectValue(obj);
	}

	@Override
	public String toString() {
		return "OBJ/" + className + "/"+ obj_id;
	}
	
	@Override
	public ValueInterface rebuild(World world) {
		this.itsClass = world.getClassFromName(className);
		setObj(world.getObject(obj_id));
		return this;
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[1] = className;
		r[2] = Long.toString(obj_id);
		return r;
	}
	
	@Override
	public String getTypeName() {
		return super.getTypeName() + "/" + itsClass.getClassName();
	}
	
	@Override
	public String getValueAsString() {
		return "#"+Long.toString((getObj()!=null)?(getObj().getId()):null);
	}
}
