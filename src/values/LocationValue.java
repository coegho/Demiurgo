package values;

import exceptions.ValueCastException;
import universe.World;
import universe.WorldLocation;

public class LocationValue extends AbstractValue {
	WorldLocation location;

	public LocationValue(WorldLocation location) {
		this.location = location;
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
	public boolean canAssign(IReturnValue newRValue) {
		return (newRValue instanceof LocationValue);
	}
	
	@Override
	public boolean assign(IReturnValue newRValue) {
		if(newRValue instanceof LocationValue) {
			location = ((LocationValue)newRValue).getLocation();
			return true;
		}
		return false;
	}

	@Override
	public IReturnValue cloneValue() {
		return new LocationValue(getLocation());
	}
}
