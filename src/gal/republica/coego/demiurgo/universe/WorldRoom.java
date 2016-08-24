package gal.republica.coego.demiurgo.universe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import gal.republica.coego.demiurgo.lib.Decision;
import gal.republica.coego.demiurgo.lib.ValueData;
import gal.republica.coego.demiurgo.lib.WorldObjectData;
import gal.republica.coego.demiurgo.lib.WorldRoomData;
import gal.republica.coego.demiurgo.values.IReturnValue;

public class WorldRoom extends WorldLocation {
	protected String longPath;
	protected Map<String, IReturnValue> variables;
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
	public WorldRoom(long id, String long_path, Map<String, IReturnValue> variables) {
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

	public IReturnValue getVariable(String name) {
		return variables.get(name);
	}

	public void setVariable(String name, IReturnValue value) {
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

	public List<Decision> getDecisions() {
		List<Decision> l = new ArrayList<>();
		for (User u : decisions.keySet()) {
			l.add(new Decision(u.getUsername(), longPath, decisions.get(u)));
		}
		return l;
	}

	public Map<String, IReturnValue> getVariables() {
		return variables;
	}

	@Override
	public void rebuild(World world) {
		super.rebuild(world);
		for (IReturnValue v : variables.values()) {
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
		variables = ((Map<String, IReturnValue>) in.readObject());
		decisions = (Map<User, String>) in.readObject();
		objects = (List<WorldObject>) in.readObject();
	}

	public WorldRoomData roomData() {
		Map<String, ValueData> v = new HashMap<>();
		for (Entry<String, IReturnValue> e : getVariables().entrySet()) {
			v.put(e.getKey(), e.getValue().valueData());
		}
		List<WorldObjectData> ol = new ArrayList<>();
		for(WorldObject o: getObjects()) {
			ol.add(o.worldObjectData());
		}
		return new WorldRoomData(getId(), getLongPath(), v, getNarratedAction(), getDecisions(), ol);
	}
}
