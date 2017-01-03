package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a world into the system.
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class World {
	protected String name;
	protected Map<String, DemiurgoClass> classes;
	protected Map<Long, DemiurgoObject> objects;
	protected Map<Long, WorldLocation> locations;
	protected Map<String, User> users;
	protected Map<Long, Action> actions;
	protected RoomPath rooms;
	protected DemiurgoClass rootClass;
	protected long currentObjId;
	protected long currentRoomId;
	protected long currentActionId;
	protected List<WorldRoom> pendingRooms;
	protected Logger worldLogger;

	public World(String name) throws SecurityException, IOException {
		this.name = name;
		currentObjId = 0;
		currentRoomId = 0;
		currentActionId = 0;
		classes = new HashMap<>();
		objects = new HashMap<>();
		locations = new HashMap<>();
		users = new HashMap<>();
		actions = new HashMap<>();
		rooms = new RoomPath("/", null);
		rootClass = new RootObjectClass(this);
		pendingRooms = new ArrayList<>();
		classes.put("object", rootClass);
		
		worldLogger = Logger.getLogger(World.class.getName() + "." + name);
		worldLogger.setLevel(Level.INFO);
		worldLogger.setUseParentHandlers(false);
		Handler wh = new FileHandler(new File(name +".log").getAbsolutePath(), true);
		// wh.setFormatter(new XMLFormatter()); TODO: custom formatter
		worldLogger.addHandler(wh);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DemiurgoClass getClassFromName(String className) {
		return classes.get(className);
	}

	public void addClass(DemiurgoClass newClass) {
		classes.put(newClass.getClassName(), newClass);
	}

	public void removeClass(String className) {
		classes.remove(className);
	}

	public DemiurgoClass getRootClass() {
		return rootClass;
	}

	public void setRootClass(DemiurgoClass rootClass) {
		this.rootClass = rootClass;
	}

	public void addObject(DemiurgoObject obj) {
		if (obj.getId() == -1) {
			obj.setId(currentObjId);
			currentObjId++;
		}
		objects.put(obj.getId(), obj);
	}

	public void removeObject(DemiurgoObject obj) {
		objects.remove(obj.id);
	}

	public DemiurgoObject getObject(long id) {
		return objects.get(id);
	}

	/**
	 * Moves an object from one location to another.
	 * 
	 * @param origin
	 *            Original location.
	 * @param destination
	 *            Future location.
	 * @param obj
	 *            Moved object.
	 */
	public void moveTo(WorldLocation origin, WorldLocation destination, DemiurgoObject obj) {
		origin.removeObject(obj);
		obj.setLocation(destination);
		destination.addObject(obj);
	}

	/**
	 * Finds a RoomGroup by its absolute path.
	 * 
	 * @param loc
	 *            Absolute path to the room.
	 * @param constructive
	 *            If true, creates RoomGroup objects when they are not found.
	 * @return
	 */
	protected RoomPath searchRoomGroup(String loc, boolean constructive) {
		RoomPath rg = rooms;
		String partialPath = "";

		if (loc.isEmpty()) {
			return null;
		}
		if (loc.equals("/")) {
			return rg;
		}
		for (String s : loc.substring(1).split("/")) {
			partialPath += "/" + s;
			if (rg.getChildren().containsKey(s)) {
				rg = rg.getChildren().get(s);
			} else {
				if (constructive) {
					RoomPath ng = new RoomPath(partialPath.length() > 0 ? partialPath : partialPath + "/", rg);
					rg.getChildren().put(s, ng);
					rg = ng;
				} else
					return null;
			}
		}

		return rg;
	}

	/**
	 * Creates a new room from a relative path.
	 * 
	 * @param roomRelativeName
	 *            Relative path to the room.
	 * @param currentRoom
	 *            The absolute path of the current room (ending by '/').
	 * @return
	 */
	public WorldRoom newRoom(String roomRelativeName, String currentRoom) {
		return newRoom(currentRoom + roomRelativeName);
	}

	/**
	 * Insert a new room on the specified path.
	 * 
	 * @param room
	 *            The relative path to the room.
	 * @return
	 */
	public WorldRoom newRoom(WorldRoom room) {
		RoomPath rg = searchRoomGroup(room.getLongPath(), true);
		rg.setOwnRoom(room);
		locations.put(room.getId(), room);
		return rg.getOwnRoom();

	}

	/**
	 * Creates a new room from a absolute path.
	 * 
	 * @param roomLongName
	 *            The complete path to the room.
	 * @return
	 */
	public WorldRoom newRoom(String roomLongName) {
		RoomPath rg = searchRoomGroup(roomLongName, true);
		if (rg.getOwnRoom() == null) {
			WorldRoom room = new WorldRoom(roomLongName, this, currentRoomId);
			currentRoomId++;
			rg.setOwnRoom(room);
			locations.put(room.getId(), room);
		} else {
			System.err.println("Room already exists"); // TODO
		}
		return rg.getOwnRoom();
	}

	/**
	 * Returns a room from a relative path.
	 * 
	 * @param roomRelativeName
	 *            The relative path to the room.
	 * @param currentRoom
	 *            The absolute path of the current room (ending by '/').
	 * @return
	 */
	public WorldRoom getRoom(String roomRelativeName, String currentRoom) {
		return getRoom(currentRoom + roomRelativeName);
	}

	/**
	 * Returns a room from a absolute path.
	 * 
	 * @param roomLongName
	 *            The complete path to the room.
	 * @return
	 */
	public WorldRoom getRoom(String roomLongName) {
		RoomPath rg = searchRoomGroup(roomLongName, false);
		if (rg == null)
			return null;
		else
			return rg.getOwnRoom();
	}

	/**
	 * Returns all rooms in the world.
	 * 
	 * @return
	 */
	public List<WorldRoom> getAllRooms() {
		return rooms.getAllRooms();
	}

	/**
	 * Debug method. It returns all classes in the world. TODO
	 * 
	 * @return
	 */
	public Collection<DemiurgoClass> getClasses() {
		return classes.values();
	}

	public Set<String> getAllUserNames() {
		return users.keySet();
	}

	public Collection<DemiurgoObject> getAllObjects() {
		return objects.values();
	}

	/**
	 * Links an object with an user.
	 * 
	 * @param user
	 * @param obj
	 */
	public void setUserObject(User user, DemiurgoObject obj) {
		if (user != null) {
			user.setObj(obj);
		}
		if (obj != null) {
			obj.setUser(user);
		}
	}

	/**
	 * Adds a new user.
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		users.put(user.getUsername(), user);
	}

	/**
	 * Get an existing user.
	 * 
	 * @param user
	 * @return
	 */
	public User getUser(String user) {
		return users.get(user);
	}

	public WorldLocation getLocation(long loc_id) {
		return locations.get(loc_id);
	}

	public void setCurrentObjId(long objId) {
		this.currentObjId = objId;
	}

	public void setCurrentRoomId(long roomId) {
		this.currentRoomId = roomId;
	}

	public void setCurrentActionId(long currentActionId) {
		this.currentActionId = currentActionId;
	}

	public long getCurrentObjId() {
		return currentObjId;
	}

	public long getCurrentRoomId() {
		return currentRoomId;
	}

	public long getCurrentActionId() {
		return currentActionId;
	}

	public List<WorldRoom> getPendingRooms() {
		return pendingRooms;
	}

	public Collection<User> getAllUsers() {
		return users.values();
	}

	/*
	 * public ObjectNode getRoomPaths() { return rooms.roomPathData(); }
	 */

	public void addAction(Action action) {
		if (action.getId() == -1) {
			action.setId(currentActionId);
			currentActionId++;
		}
		action.getRoom().getActions().add(action);
		actions.put(action.getId(), action);
	}

	public Action getAction(long id) {
		return actions.get(id);
	}

	public Map<Long, Action> getActions() {
		return actions;
	}

	public void setActions(Map<Long, Action> actions) {
		this.actions = actions;
	}

	public Logger getLogger() {
		return worldLogger;
	}

	public void setLogger(Logger logger) {
		this.worldLogger = logger;
	}

	/**
	 * Modify the current class' fields and methods to the new class' ones.
	 * 
	 * @param newClass
	 */
	public void modifyClass(DemiurgoClass oldClass, DemiurgoClass newClass) {
		oldClass.modifyTo(newClass);
		objects.values().stream().filter(o -> o.ownClass.inheritFrom(oldClass)).forEach(o -> o.updateClass());
	}
}
