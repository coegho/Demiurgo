package values;

import exceptions.ValueCastException;
import universe.World;
import universe.WorldLocation;

public class LocationValue implements IReturnValue {
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
	public IReturnValue add(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue sub(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue mul(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue div(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue eq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue neq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue greq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue leseq(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue great(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue less(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue and(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue or(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue negative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue not() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue dice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue multDice(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue exponent(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int castToInteger() throws ValueCastException {
		throw new ValueCastException();
	}

	@Override
	public float castToFloat() throws ValueCastException {
		throw new ValueCastException();
	}

	@Override
	public String castToString() throws ValueCastException {
		throw new ValueCastException();
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
	public IReturnValue getFromIndex(IReturnValue another) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReturnValue cloneValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTrue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDepth() {
		return 0;
	}
}
