package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
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
		this.itsClass = obj.getDemiurgoClass();
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
	
	public ObjectValue(DemiurgoObject obj, DemiurgoClass itsClass) {
		this.obj = obj;
		this.itsClass = itsClass;
	}

	@Override
	public ValueInterface eq(ValueInterface another) throws IllegalOperationException {
		if(another instanceof ObjectValue) {
			ObjectValue o = ((ObjectValue)another);
			if(getObj() == null) {
				return new IntegerValue(o.getObj() == null); //two nulls: true
			}
			else if(o.getObj() == null)
				return new IntegerValue(0); //only one null: false
			return new IntegerValue(getObj().equals(o.getObj()));
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
	
	public DemiurgoClass getItsClass() {
		return itsClass;
	}
	
	public void setItsClass(DemiurgoClass itsClass) {
		this.itsClass = itsClass;
	}
	
	@Override
	public boolean canAssign(ValueInterface newRValue) {
		if (newRValue instanceof ObjectValue) {
			ObjectValue o = (ObjectValue)newRValue;
			if(o.getObj() == null) {
				return true; //always can assign null
			}
			//check polymorphism
			return (o.getObj().getDemiurgoClass().inheritFrom(itsClass));
		}
		return false;
	}

	@Override
	public void assign(ValueInterface newRValue) throws ValueCastException {
		if(canAssign(newRValue)) {
			ObjectValue o = (ObjectValue)newRValue;
			obj = o.getObj();
			obj_id = (o.getObj()!=null)?obj.getId():-1;
		}
		else
			throw new ValueCastException(-1, -1, -1, newRValue.getTypeName(), getTypeName());
	}

	@Override
	public ValueInterface cloneValue() {
		return new ObjectValue(obj, itsClass);
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
	public String getTypeName() {
		return super.getTypeName() + "/" + itsClass.getClassName();
	}
	
	@Override
	public String getValueAsString() {
		return ((getObj()!=null)?("#"+Long.toString(getObj().getId())):"null");
	}
}
