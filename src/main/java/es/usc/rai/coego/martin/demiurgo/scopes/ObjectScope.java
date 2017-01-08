package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ObjectScope extends Scope {
	protected DemiurgoObject obj;
	
	public ObjectScope(DemiurgoObject obj) {
		this.obj = obj;
	}

	@Override
	public ValueInterface getVariable(String name) {
		return obj.getField(name);
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		obj.setField(name, value);
		
	}

	public DemiurgoObject getObject() {
		return obj;
	}

	@Override
	public DemiurgoMethod getMethod(String methodName) {
		if(obj.getLocation().getWorld().getMethods().containsKey(methodName)) {
			return obj.getLocation().getWorld().getMethod(methodName);
		}
		return obj.getUserClass().getMethod(methodName);
	}
}
