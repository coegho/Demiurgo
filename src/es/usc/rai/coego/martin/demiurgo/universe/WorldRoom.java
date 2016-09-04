package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

import java.util.Set;

import gal.republica.coego.demiurgo.lib.Decision;
import gal.republica.coego.demiurgo.lib.ValueData;
import gal.republica.coego.demiurgo.lib.WorldObjectData;
import gal.republica.coego.demiurgo.lib.WorldRoomData;

public class WorldRoom extends WorldLocation {
	protected String longPath;
	protected Map<String, ValueInterface> variables;
	protected String narratedAction;
	protected Map<User, String> decisions;

	public WorldRoom(String longName, World world, long id) {
		super(world, id);
		variables = new HashMap<>();
		this.longPath = longName;
		decisions = new HashMap<>();
	}

	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 */
	public WorldRoom(long id, String long_path, Map<String, ValueInterface> variables) {
		super(id);
		this.longPath = long_path;
		this.variables = variables;
		decisions = new HashMap<>();
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

	public Set<String> getAllVarNames() {
		return variables.keySet();
	}

	public String getNarratedAction() {
		return narratedAction;
	}

	public void setNarratedAction(String narratedAction) {
		this.narratedAction = narratedAction;
	}

	public void addDecision(User user, String text) {
		decisions.put(user, text);
	}

	public Map<User, String> getDecisionsMap() {
		return decisions;
	}

	protected ArrayNode getDecisions() {
		ObjectMapper om = new ObjectMapper();
		ArrayNode l = om.createArrayNode();
		for (Entry<User, String> u : decisions.entrySet()) {
			ObjectNode decision = om.createObjectNode();
			decision.put("username", u.getKey().getUsername());
			decision.put("room_path", getLongPath());
			decision.put("text", u.getValue());
			l.add(decision);
		}
		return l;
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
		out.writeObject(getNarratedAction());
		out.writeObject(getVariables());
		out.writeObject(getDecisionsMap());
		out.writeObject(getObjects());
	}

	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		id = in.readLong();
		longPath = (String) in.readObject();
		narratedAction = (String) in.readObject();
		variables = ((Map<String, ValueInterface>) in.readObject());
		decisions = (Map<User, String>) in.readObject();
		objects = (List<WorldObject>) in.readObject();
	}

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
	}
}
