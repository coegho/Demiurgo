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
		ValueInterface field = obj.getField(name);
		if(field == null) {
			field = obj.getDemiurgoClass().getStaticField(name);
		}
		return field;
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		obj.setField(name, value);
		
	}

	@Override
	public DemiurgoObject getThisObject() {
		return obj;
	}

	@Override
	public DemiurgoMethod getMethod(String methodName) {
		if(obj.getLocation().getWorld().getMethods().containsKey(methodName)) {
			return obj.getLocation().getWorld().getMethod(methodName);
		}
		return obj.getDemiurgoClass().getMethod(methodName);
	}
}
