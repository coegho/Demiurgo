package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomPath {
	protected String path;
	protected RoomPath parent;
	protected Map<String, RoomPath> children;
	protected DemiurgoRoom ownRoom;
	
	public RoomPath(String path, RoomPath parent) {
		this.path = path;
		this.parent = parent;
		children = new HashMap<>();
		children.put(".", this);
		children.put("..", parent);
	}
	
	public void setOwnRoom(DemiurgoRoom ownRoom) {
		this.ownRoom = ownRoom;
	}
	
	public DemiurgoRoom getOwnRoom() {
		return ownRoom;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getShortName() {
		return path.substring(path.lastIndexOf('/'));
	}
	
	public Map<String, RoomPath> getChildren() {
		return children;
	}
	
	/**
	 * Debug method. It returns all rooms in the world.
	 * @return
	 */
	public List<DemiurgoRoom> getAllRooms() {
		List<DemiurgoRoom> l = new ArrayList<>();
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
		String ret = "ROOMPATH \""+ path + "\"={";
		for(String rg : children.keySet()) {
			ret += children.get(rg).toString();
		}
		ret += "}";
		return ret;
	}
	
	
}
