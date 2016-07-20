package scope;

import universe.StoredSymbol;
import universe.WorldRoom;

public class RoomScope extends Scope {
	protected WorldScope parent;
	protected WorldRoom room;

	public RoomScope(WorldRoom room, WorldScope parent) {
		this.parent = parent;
		this.room = room;
	}

	@Override
	public StoredSymbol getVariable(String name) {
		return room.getVariable(name);
	}

	@Override
	public void setVariable(String name, StoredSymbol value) {
		room.setVariable(name, value);
	}

	public WorldScope getParent() {
		return parent;
	}

	public WorldRoom getRoom() {
		return room;
	}
}
