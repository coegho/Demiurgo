package es.usc.rai.coego.martin.demiurgo.universe;

public class Inventory extends WorldLocation {
	protected DemiurgoObject container;

	public Inventory(World world, long id) {
		super(world, id);
	}
	
	public DemiurgoObject getContainer() {
		return container;
	}

	public void setContainer(DemiurgoObject container) {
		this.container = container;
	}
	
	
}
