package es.usc.rai.coego.martin.demiurgo.values;


import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.universe.Inventory;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldLocation;

public class InventoryValue extends LocationValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryValue(WorldLocation location) {
		super(location);
	}
	@Override
	public boolean canAssign(ValueInterface newRValue) {
		return (newRValue instanceof InventoryValue);
	}

	@Override
	public ValueInterface cloneValue() {
		return new InventoryValue(location);
	}
	
	@Override
	public ValueInterface getFromIndex(int index) throws IllegalOperationException {
		return new ObjectValue(getLocation().getObjects().get(index));
	}

	@Override
	public ReturnValueTypes getType() {
		return ReturnValueTypes.INVENTORY;
	}
	public static ValueInterface defaultValue(World world) {
		return new InventoryValue(null);
	}
	
	@Override
	public String getValueAsString() {
		return "%";
	}
	public void setLocation(Inventory location) {
		this.location = location;
	}
}
