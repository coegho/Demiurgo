package scope;

import universe.StoredSymbol;
import universe.WorldObject;

public class ObjectScope extends Scope {
	protected WorldObject obj;
	
	public ObjectScope(WorldObject obj) {
		this.obj = obj;
	}

	@Override
	public StoredSymbol getVariable(String name) {
		return obj.getField(name);
	}

	@Override
	public void setVariable(String name, StoredSymbol value) {
		obj.setField(name, value);
		
	}

	public WorldObject getObject() {
		return obj;
	}
}
