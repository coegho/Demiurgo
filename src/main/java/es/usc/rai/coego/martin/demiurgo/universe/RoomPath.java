package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RoomPath {
	protected String path;
	protected RoomPath parent;
	protected Map<String, RoomPath> children;
	protected WorldRoom ownRoom;
	
	public RoomPath(String path, RoomPath parent) {
		this.path = path;
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
		String ret = "ROOMPATH \""+ path + "\"={";
		for(String rg : children.keySet()) {
			ret += children.get(rg).toString();
		}
		ret += "}";
		return ret;
	}
	
	public ObjectNode roomPathData() {
		ObjectMapper om = new ObjectMapper();
		
		ObjectNode o = om.createObjectNode();
		o.put("path", path);
		o.put("hasroom", ownRoom != null);
		ObjectNode oc = om.createObjectNode();
		for(Entry<String, RoomPath> r : children.entrySet()) {
			if(r.getKey() != "." && r.getKey() != "..") {
			oc.set(r.getKey(), r.getValue().roomPathData());
			}
		}
		o.set("children", oc);
		return o;
	}
}
