package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.values.IReturnValue;

public class ObjectScope extends Scope {
	protected WorldObject obj;
	
	public ObjectScope(WorldObject obj) {
		this.obj = obj;
	}

	@Override
	public IReturnValue getVariable(String name) {
		return obj.getField(name);
	}

	@Override
	public void setVariable(String name, IReturnValue value) {
		obj.setField(name, value);
		
	}

	public WorldObject getObject() {
		return obj;
	}
}
