package plataformarol;

import universe.WorldRoom;
import values.IReturnValue;

public class RoomScope extends Scope {
	protected GlobalScope parent;
	protected WorldRoom room;
	
	public RoomScope(WorldRoom room, GlobalScope parent) {
		this.parent = parent;
		this.room = room;
	}
	@Override
	public StoredSymbol getVariable(String name) {
		return room.getVariable(name);
	}

	@Override
	public void setVariable(String name, IReturnValue value) {
		room.setVariable(name, value);
	}
	
	public GlobalScope getParent() {
		return parent;
	}

}
