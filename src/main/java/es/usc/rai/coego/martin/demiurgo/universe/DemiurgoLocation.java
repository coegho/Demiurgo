package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import es.usc.rai.coego.martin.demiurgo.values.InventoryValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public abstract class DemiurgoLocation {

	protected long id;
	protected transient World world;
	protected List<DemiurgoObject> objects;

	public DemiurgoLocation(World world, long id) {
		this.id = id;
		this.world = world;
		objects = new ArrayList<>();
	}
	
	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * @param id
	 */
	public DemiurgoLocation(long id) {
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

	/**
	 * Returns all users whose character is inside this room.
	 * 
	 * @return List of users occupying this room.
	 */
	public List<User> getUsers() {
		Set<User> users = new HashSet<>();
		for (DemiurgoObject o : getObjects()) {
			if (o.getUser() != null) {
				users.add(o.getUser());
			}
			//Looking for users in inventories
			for(Entry<String, ValueInterface> e : o.getFields().entrySet()) {
				if(e.getValue() instanceof InventoryValue) {
					users.addAll(((InventoryValue)e.getValue()).getLocation().getUsers());
				}
			}
		}
		return new ArrayList<>(users);
	}
	
	public abstract void destroyLocation();
}
