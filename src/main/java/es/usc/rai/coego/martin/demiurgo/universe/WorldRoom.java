package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class WorldRoom extends WorldLocation {
	protected String longPath;
	protected Map<String, ValueInterface> variables;
	protected List<Action> actions;

	public WorldRoom(String longName, World world, long id) {
		super(world, id);
		variables = new HashMap<>();
		this.actions = null;
		this.longPath = longName;
	}

	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * @param narration 
	 */
	public WorldRoom(long id, String long_path, Map<String, ValueInterface> variables/*, String narration*/) {
		super(id);
		this.longPath = long_path;
		this.variables = variables;
		this.actions = null;
	}

	public String getLongPath() {
		return longPath;
	}

	public void setLongPath(String longPath) {
		this.longPath = longPath;
	}

	public String getShortName() {
		return longPath.substring(longPath.lastIndexOf('/'));
	}

	public ValueInterface getVariable(String name) {
		return variables.get(name);
	}

	public void setVariable(String name, ValueInterface value) {
		this.variables.put(name, value);
	}

	
	public List<User> getDecidingUsers() {
		List<User> users = new ArrayList<>();
		for(WorldObject o : objects) {
			if(o.getUser() != null && o.getUser().getDecision() != null) {
				users.add(o.getUser());
			}
		}
		return users;
	}

	public Map<String, ValueInterface> getVariables() {
		return variables;
	}

	@Override
	public void rebuild(World world) {
		super.rebuild(world);
		for (ValueInterface v : variables.values()) {
			v.rebuild(world);
		}
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeLong(getId());
		out.writeObject(getLongPath());
		out.writeObject(getVariables());
		out.writeObject(getObjects());
	}

	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		id = in.readLong();
		longPath = (String) in.readObject();
		variables = ((Map<String, ValueInterface>) in.readObject());
		objects = (List<WorldObject>) in.readObject();
	}
/*
	public String toJSON() {
		ObjectMapper om = new ObjectMapper();
		ObjectNode roomdata = om.createObjectNode();
		roomdata.put("id", getId());
		roomdata.put("longPath", getLongPath());
		roomdata.put("narratedAction", getNarratedAction());
		
		ObjectNode variables = om.createObjectNode();
		for (Entry<String, ValueInterface> e : getVariables().entrySet()) {
			variables.set(e.getKey(), e.getValue().toJSON());
		}
		roomdata.set("variables", variables);
		
		ArrayNode objects = om.createArrayNode();
		for(WorldObject o: getObjects()) {
			objects.add(o.toJSON());
		}
		roomdata.set("objects", objects);
		
		roomdata.set("decisions", getDecisions());
		return roomdata.toString();
	}*/

	/**
	 * Returns all users whose character is inside this room.
	 * @return List of users occupying this room.
	 */
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		for(WorldObject o : getObjects()) {
			if(o.getUser() != null) {
				users.add(o.getUser());
			}
		}
		return users;
	}
	
	public List<Action> getActions() {
		if(!areActionsInCache()) {
			setActions(Demiurgo.loadActionsFromRoom(this));
		}
		return actions;
	}
	
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	public boolean areActionsInCache() {
		return actions != null;
	}
}
