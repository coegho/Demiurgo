package gal.republica.coego.demiurgo.universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomGroup {
	protected String name;
	protected RoomGroup parent;
	protected Map<String, RoomGroup> children;
	protected WorldRoom ownRoom;
	
	public RoomGroup(String name, RoomGroup parent) {
		this.name = name;
		this.parent = parent;
		children = new HashMap<>();
		children.put(".", this);
		children.put("..", parent);
	}
	
	public void setOwnRoom(WorldRoom ownRoom) {
		this.ownRoom = ownRoom;
	}
	
	public WorldRoom getOwnRoom() {
		return ownRoom;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLongName() {
		if(parent == null)
			return getName();
		else
			return parent.getLongName() + "/" + getName();
	}
	
	public Map<String, RoomGroup> getChildren() {
		return children;
	}
	
	/**
	 * Debug method. It returns all rooms in the world.
	 * @return
	 */
	public List<WorldRoom> getAllRooms() {
		List<WorldRoom> l = new ArrayList<>();
		if(getOwnRoom() != null)
			l.add(getOwnRoom());
		for(String c : children.keySet()) {
			if(c != "." && c != "..") {
				l.addAll(children.get(c).getAllRooms());
			}
		}
		return l;
	}
	
	@Override
	public String toString() {
		String ret = "ROOMGROUP \""+ name + "\"={";
		for(String rg : children.keySet()) {
			ret += children.get(rg).toString();
		}
		ret += "}";
		return ret;
	}
}
