package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldLocation;

public class RoomValue extends LocationValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomValue(WorldLocation location) {
		super(location);
	}
	
	public static LocationValue defaultValue(World world) {
		return new RoomValue(world.getRoom("/"));
	}

	@Override
	public ValueInterface cloneValue() {
		return new RoomValue(location);
	}

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.ROOM;
	}
	
	@Override
	public boolean canAssign(ValueInterface newRValue) {
		return (newRValue instanceof RoomValue);
	}
}
