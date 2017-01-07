package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.stream.Collectors;

import es.usc.rai.coego.martin.demiurgo.json.JsonInventory;

public class Inventory extends DemiurgoLocation {
	protected transient DemiurgoObject container;
	protected long container_id;
	protected String varName;

	public Inventory(DemiurgoObject obj, String varName, long id) {
		super(obj.getUserClass().getWorld(), id);
		container = obj;
		this.varName = varName;
	}
	
	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * @param id
	 * @param obj_id
	 */
	public Inventory(long id, String varName, long obj_id) {
		super(id);
		this.container_id = obj_id;
		this.varName = varName;
	}

	public DemiurgoObject getContainer() {
		return container;
	}

	public void setContainer(DemiurgoObject container) {
		this.container = container;
	}
	
	public String getVarName() {
		return varName;
	}
	
	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public void rebuild(World world) {
		super.rebuild(world);
		this.container = world.getObject(container_id);
	}

	public JsonInventory toJson(String name) {
		JsonInventory json = new JsonInventory();
		json.setName(name);
		json.setObjects(getObjects().stream().map(o -> o.toJson()).collect(Collectors.toList()));
		return json;
	}

	@Override
	public DemiurgoRoom getRealLocation() {
		return getContainer().getRealLocation();
	}

	@Override
	public boolean isInsideOf(DemiurgoObject another) {
		return getContainer().getId() == another.getId() || getContainer().isInsideOf(another);
	}

	@Override
	public void destroyLocation() {
		for(DemiurgoObject o : getObjects()) {
			o.destroyObject(true);
		}

		getWorld().markInventoryToDestroy(this);
	}
}
