package universe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents a world into the system.
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class World {
	protected String name;
	protected Map<String, UserDefinedClass> classes;
	protected Map<Long, WorldObject> objects;
	protected Map<String, WorldObject> userObjects; //TODO: only a string to identify user?
	protected RoomGroup rooms;
	protected UserDefinedClass rootClass;
	protected long currentId;
	
	
	public World(String name) {
		this.name = name;
		currentId = 0;
		classes = new HashMap<>();
		objects = new HashMap<>();
		userObjects = new HashMap<>();
		rooms = new RoomGroup("", null);
		rootClass = new RootObjectClass(this);
		classes.put("object", rootClass);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UserDefinedClass getClassFromName(String className) {
		return classes.get(className);
	}
	
	public void addClass(String className, UserDefinedClass newClass) {
		classes.put(className, newClass);
	}
	
	
	public UserDefinedClass getRootClass() {
		return rootClass;
	}
	
	public void setRootClass(UserDefinedClass rootClass) {
		this.rootClass = rootClass;
	}
	
	public void addObject(WorldObject obj) {
		obj.setId(currentId);
		currentId++;
		objects.put(obj.getId(), obj);
	}
	
	public void removeObject(WorldObject obj) {
		objects.remove(obj.id);
	}
	
	public WorldObject getObject(long id) {
		return objects.get(id);
	}
	
	/**
	 * Creates a new room from a relative path.
	 * @param roomRelativeName The relative path to the room.
	 * @param currentRoom The absolute path of the current room (ending by '/').
	 * @return
	 */
	public WorldRoom newRoom(String roomRelativeName, String currentRoom) {
		RoomGroup rg = rooms;
		String loc = currentRoom  + roomRelativeName;
		for(String s : loc.split("/")) {
			if(rg.getChildren().containsKey(s)) {
				rg = rg.getChildren().get(s);
			}
			else {
				RoomGroup ng = new RoomGroup(s, rg);
				rg.getChildren().put(s, ng);
				rg = ng;
			}
		}
		WorldRoom room = new WorldRoom(loc, this);
		rg.setOwnRoom(room);
		
		return room;
	}
	
	/**
	 * Creates a new room from a absolute path.
	 * @param roomLongName The complete path to the room.
	 * @return
	 */
	public WorldRoom newRoom(String roomLongName) {
		return newRoom(roomLongName, "");
	}
	
	/**
	 * Returns a room from a relative path.
	 * @param roomRelativeName The relative path to the room.
	 * @param currentRoom The absolute path of the current room (ending by '/').
	 * @return
	 */
	public WorldRoom getRoom(String roomRelativeName, String currentRoom) {
		RoomGroup rg = rooms;
		String loc = currentRoom  + roomRelativeName;
		for(String s : loc.split("/")) {
			if(rg.getChildren().containsKey(s)) {
				rg = rg.getChildren().get(s);
			}
			else {
				return null;
			}
		}
		
		return rg.getOwnRoom();
	}
	
	/**
	 * Returns a room from a absolute path.
	 * @param roomLongName The complete path to the room.
	 * @return
	 */
	public WorldRoom getRoom(String roomLongName) {
		return getRoom(roomLongName, "");
	}
	
	/**
	 * Debug method. It returns all rooms in the world. TODO
	 * @return
	 */
	public List<WorldRoom> getAllRooms() {
		return rooms.getAllRooms();
	}
	
	/**
	 * Debug method. It returns all classes in the world. TODO
	 * @return
	 */
	public Set<String> getAllClasses() {
		return classes.keySet();
	}
	
	/**
	 * Get the object associated to the given user.
	 * @param user Name of the user
	 * @return The user's object
	 */
	public WorldObject getObjectFromUser(String user) {
		return userObjects.get(user);
	}
	
	public void setUserObject(String user, WorldObject obj) {
		userObjects.put(user, obj);
		obj.setUser(user);
	}
}
