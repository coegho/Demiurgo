package scope;

import plataformarol.StoredSymbol;
import universe.WorldRoom;
import values.IReturnValue;

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
	public void setVariable(String name, IReturnValue value) {
		room.setVariable(name, value);
	}

	public WorldScope getParent() {
		return parent;
	}

	public WorldRoom getRoom() {
		return room;
	}
}
