package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.List;

public abstract class WorldLocation {

	protected long id;
	protected transient World world;
	protected List<DemiurgoObject> objects;

	public WorldLocation(World world, long id) {
		this.id = id;
		this.world = world;
		objects = new ArrayList<>();
	}
	
	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * @param id
	 */
	public WorldLocation(long id) {
		this.id = id;
		objects = new ArrayList<>();
	}

	public void addObject(DemiurgoObject obj) {
		objects.add(obj);
	}

	public void removeObject(DemiurgoObject obj) {
		objects.remove(obj);
	}

	public World getWorld() {
		return world;
	}

	public List<DemiurgoObject> getObjects() {
		return objects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void rebuild(World world) {
		this.world = world;
	}

	public abstract DemiurgoRoom getRealLocation();

	public abstract boolean isInsideOf(DemiurgoObject another);
}
