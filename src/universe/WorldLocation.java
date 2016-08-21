package universe;

import java.util.ArrayList;
import java.util.List;

public class WorldLocation {

	protected long id;
	protected transient World world;
	protected transient List<WorldObject> objects;

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

	public void addObject(WorldObject obj) {
		objects.add(obj);
	}

	public void removeObject(WorldObject obj) {
		objects.remove(obj);
	}

	public World getWorld() {
		return world;
	}

	public List<WorldObject> getObjects() {
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
}
