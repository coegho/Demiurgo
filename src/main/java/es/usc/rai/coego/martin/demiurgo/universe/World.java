package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.usc.rai.coego.martin.demiurgo.exceptions.ObjectInsideItselfException;

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
	protected List<DemiurgoObject> destroyedObjects;
	protected Map<Long, DemiurgoLocation> locations;
	protected Map<String, User> users;
	protected Map<Long, Action> actions;
	protected RoomPath rooms;
	protected List<Inventory> inventories;
	protected DemiurgoClass rootClass;
	protected long currentObjId;
	protected long currentLocationId;
	protected long currentActionId;
	protected List<DemiurgoRoom> pendingRooms;
	protected Logger worldLogger;
	protected List<Inventory> destroyedInventories;
	private List<DemiurgoLocation> destroyedLocations;
	private List<DemiurgoClass> destroyedClasses;
	private List<DemiurgoRoom> destroyedRooms;

	public World(String name) throws SecurityException, IOException {
		this.name = name;
		currentObjId = 0;
		currentLocationId = 0;
		currentActionId = 0;
		classes = new HashMap<>();
		objects = new HashMap<>();
		destroyedObjects = new ArrayList<>();
		destroyedInventories = new ArrayList<>();
		destroyedLocations = new ArrayList<>();
		destroyedClasses = new ArrayList<>();
		destroyedRooms = new ArrayList<>();
		locations = new HashMap<>();
		inventories = new ArrayList<>();
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
	 * @throws ObjectInsideItselfException 
	 */
	public void moveTo(DemiurgoLocation origin, DemiurgoLocation destination, DemiurgoObject obj) throws ObjectInsideItselfException {
		if(destination.isInsideOf(obj)) {
			throw new ObjectInsideItselfException(obj);
		}
		origin.removeObject(obj);
		obj.setLocation(destination);
		destination.addObject(obj);
		if(obj.getUser() != null && obj.getUser().getDecision() != null) {
			this.addPendingRoom(destination.getRealLocation());
			if(origin.getRealLocation().getDecidingUsers().size() == 0) {
				this.getPendingRooms().remove(origin.getRealLocation());
			}
		}
	}

	/**
	 * Finds a RoomPath by its absolute path.
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
	public DemiurgoRoom newRoom(String roomRelativeName, String currentRoom) {
		return newRoom(currentRoom + roomRelativeName);
	}

	/**
	 * Insert a new room on the specified path.
	 * 
	 * @param room
	 *            The relative path to the room.
	 * @return
	 */
	public DemiurgoRoom newRoom(DemiurgoRoom room) {
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
	public DemiurgoRoom newRoom(String roomLongName) {
		RoomPath rg = searchRoomGroup(roomLongName, true);
		if (rg.getOwnRoom() == null) {
			DemiurgoRoom room = new DemiurgoRoom(roomLongName, this, currentLocationId);
			currentLocationId++;
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
	public DemiurgoRoom getRoom(String roomRelativeName, String currentRoom) {
		return getRoom(currentRoom + roomRelativeName);
	}

	/**
	 * Returns a room from a absolute path.
	 * 
	 * @param roomLongName
	 *            The complete path to the room.
	 * @return
	 */
	public DemiurgoRoom getRoom(String roomLongName) {
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
	public List<DemiurgoRoom> getAllRooms() {
		List<DemiurgoRoom> l = rooms.getAllRooms();
		Collections.sort(l);
		return l;
	}

	/**
	 * Debug method. It returns all classes in the world. TODO
	 * 
	 * @return
	 */
	public List<DemiurgoClass> getClasses() {
		ArrayList<DemiurgoClass> l = new ArrayList<>(classes.values());
		Collections.sort(l);
		return l;
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

	public DemiurgoLocation getLocation(long loc_id) {
		return locations.get(loc_id);
	}

	public void setCurrentObjId(long objId) {
		this.currentObjId = objId;
	}

	public void setCurrentLocationId(long roomId) {
		this.currentLocationId = roomId;
	}

	public void setCurrentActionId(long currentActionId) {
		this.currentActionId = currentActionId;
	}
	

	public long getCurrentObjId() {
		return currentObjId;
	}

	public long getCurrentLocationId() {
		return currentLocationId;
	}

	public long getCurrentActionId() {
		return currentActionId;
	}


	public List<DemiurgoRoom> getPendingRooms() {
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

	public Inventory createInventory(DemiurgoObject obj, String varName) {
		Inventory inv = new Inventory(obj, varName, currentLocationId);
		currentLocationId++;
		inventories.add(inv);
		addInventory(inv);
		return inv;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public List<DemiurgoLocation> getLocations() {
		return new ArrayList<>(locations.values());
	}

	public void addInventory(Inventory inv) {
		inventories.add(inv);
		locations.put(inv.getId(), inv);
	}

	public void addPendingRoom(DemiurgoRoom location) {
		if(!pendingRooms.contains(location)) {
			pendingRooms.add(location);
		}
	}

	public void markToDestroy(DemiurgoObject obj) {
		destroyedObjects.add(obj);
		objects.remove(obj.getId());
	}

	public List<DemiurgoObject> getDestroyedObjects() {
		return destroyedObjects;
	}

	public void markInventoryToDestroy(Inventory inv) {
		destroyedInventories.add(inv);
		destroyedLocations.add(inv);
		locations.remove(inv.getId());
	}
	
	public void markRoomToDestroy(DemiurgoRoom room) {
		destroyedRooms.add(room);
		destroyedLocations.add(room);
		locations.remove(room.getId());
		searchRoomGroup(room.getLongPath(), false).setOwnRoom(null);;
		
	}

	public List<Inventory> getDestroyedInventories() {
		return destroyedInventories;
	}

	public List<DemiurgoLocation> getDestroyedLocations() {
		return destroyedLocations;
	}
	
	public List<DemiurgoClass> getDestroyedClasses() {
		return destroyedClasses;
	}
	
	public void markToDestroy(DemiurgoClass cl) {
		destroyedClasses.add(cl);
		classes.remove(cl.getClassName());
	}

	public List<DemiurgoRoom> getDestroyedRooms() {
		return destroyedRooms;
	}
}
