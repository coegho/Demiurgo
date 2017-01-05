package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class RoomScope extends Scope {
	protected WorldScope parent;
	protected DemiurgoRoom room;

	public RoomScope(DemiurgoRoom room, WorldScope parent) {
		this.parent = parent;
		this.room = room;
	}

	@Override
	public ValueInterface getVariable(String name) {
		return room.getVariable(name);
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		room.setVariable(name, value);
	}

	public WorldScope getParent() {
		return parent;
	}

	public DemiurgoRoom getRoom() {
		return room;
	}
}
