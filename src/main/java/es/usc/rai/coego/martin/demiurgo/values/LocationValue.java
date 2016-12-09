package es.usc.rai.coego.martin.demiurgo.values;

import com.fasterxml.jackson.databind.node.ObjectNode;

import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldLocation;

public class LocationValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient WorldLocation location;
	protected long loc_id;

	public LocationValue(WorldLocation location) {
		this.location = location;
		loc_id = location.getId();
	}
	
	public static LocationValue defaultValue(World world) {
		return new LocationValue(world.getRoom("."));
	}

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.LOCATION;
	}

	public WorldLocation getLocation() {
		return location;
	}

	@Override
	public boolean canAssign(ValueInterface newRValue) {
		return (newRValue instanceof LocationValue);
	}
	
	@Override
	public boolean assign(ValueInterface newRValue) {
		if(newRValue instanceof LocationValue) {
			location = ((LocationValue)newRValue).getLocation();
			loc_id = location.getId();
			return true;
		}
		return false;
	}

	@Override
	public ValueInterface cloneValue() {
		return new LocationValue(getLocation());
	}
	
	@Override
	public String toString() {
		return "LOC/" + location.getId();
	}
	
	@Override
	public ValueInterface rebuild(World world) {
		this.location = world.getLocation(loc_id);
		return this;
	}
	
	@Override
	public String[] getValueCodes() {
		String[] r = super.getValueCodes();
		r[2] = Long.toString(loc_id);
		return r;
	}
	
	@Override
	public String getValueAsString() {
		return Long.toString(getLocation().getId());
	}
}
