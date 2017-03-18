package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.universe.World;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.usc.rai.coego.martin.demiurgo.exceptions.MissingInventoryException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
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
		if (location != null)
			loc_id = location.getId();
		else
			loc_id = -1;
	}

	public DemiurgoLocation getLocation() throws MissingInventoryException {
		return location;
	}

	@Override
	public void assign(ValueInterface newRValue) throws ValueCastException {
		try {
		if (canAssign(newRValue)) {
			if (((LocationValue) newRValue).getLocation() != null) {
				location = ((LocationValue) newRValue).getLocation();
				loc_id = location.getId();
			}
		}
		else
			throw new ValueCastException(-1, -1, -1, newRValue.getTypeName(), getTypeName());
		} catch(MissingInventoryException e) {
			throw new ValueCastException(-1, -1, -1, "null", getTypeName());
		}
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
	public String getValueAsString() {
		try {
			return Long.toString(getLocation().getId());
		} catch (MissingInventoryException e) {
			return "null";
		}
	}

	public List<ValueInterface> getContents() {
		try {
			return new ArrayList<>(
					getLocation().getObjects().stream().map(o -> new ObjectValue(o)).collect(Collectors.toList()));
		} catch (MissingInventoryException e) {
			return new ArrayList<>();
		}
	}
}