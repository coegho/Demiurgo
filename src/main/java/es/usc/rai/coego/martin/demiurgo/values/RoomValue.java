package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.World;

public class RoomValue extends LocationValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomValue(DemiurgoRoom location) {
		super(location);
	}
	
	public static LocationValue defaultValue(World world) {
		return new RoomValue(world.getRoom("/"));
	}
	
	@Override
	public String castToString() throws ValueCastException {
		return ((DemiurgoRoom)location).getLongPath();
	}

	@Override
	public ValueInterface cloneValue() {
		return new RoomValue((DemiurgoRoom)location);
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
