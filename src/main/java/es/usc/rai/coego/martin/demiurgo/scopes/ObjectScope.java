package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ObjectScope extends Scope {
	protected WorldObject obj;
	
	public ObjectScope(WorldObject obj) {
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

	public WorldObject getObject() {
		return obj;
	}
}
