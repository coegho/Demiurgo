package universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import serializable.SerializableDecision;
import serializable.SerializableWorldRoom;
import values.IReturnValue;

public class WorldRoom extends WorldLocation {

	protected String longPath;
	protected Map<String, IReturnValue> variables;
	protected String narratedAction;
	protected Map<User, String> decisions;

	public WorldRoom(String longName, World world, long id) {
		super(world, id);
		variables = new HashMap<>();
		this.longPath = longName;
	}

	public String getLongPath() {
		return longPath;
	}

	public void setLongPath(String longPath) {
		this.longPath = longPath;
	}

	public String getShortName() {
		return longPath.substring(longPath.lastIndexOf('.'));
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

	public SerializableWorldRoom getSerializableWorldRoom() {
		return new SerializableWorldRoom(id, longPath, variables);
	}

	public void addDecision(User user, String text) {
		decisions.put(user, text);
	}

	public List<SerializableDecision> getSerializableDecisions() {
		List<SerializableDecision> l = new ArrayList<>();
		for(User u : decisions.keySet()) {
			l.add(new SerializableDecision(u.getUsername(), longPath, decisions.get(u)));
		}
		return l;
	}
}
