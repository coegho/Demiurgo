package es.usc.rai.coego.martin.demiurgo.universe;

public class Inventory extends WorldLocation {
	protected WorldObject container;

	public Inventory(World world, long id) {
		super(world, id);
	}
	
	public WorldObject getContainer() {
		return container;
	}

	public void setContainer(WorldObject container) {
		this.container = container;
	}
	
	
}
