package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoLocation;

public abstract class LocationValue extends AbstractValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient DemiurgoLocation location;
	protected long loc_id;

	public LocationValue(DemiurgoLocation location) {
		this.location = location;
		if(location != null)
			loc_id = location.getId();
		else
			loc_id = -1;
	}


	public DemiurgoLocation getLocation() {
		return location;
	}

	
	@Override
	public boolean assign(ValueInterface newRValue) {
		if(canAssign(newRValue)) {
			if(((LocationValue)newRValue).getLocation() != null) {
				location = ((LocationValue)newRValue).getLocation();
				loc_id = location.getId();
			}
			return true;
		}
		return false;
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
