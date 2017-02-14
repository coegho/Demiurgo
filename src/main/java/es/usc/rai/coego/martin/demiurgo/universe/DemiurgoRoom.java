package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import es.usc.rai.coego.martin.demiurgo.json.JsonObject;
import es.usc.rai.coego.martin.demiurgo.json.JsonPendingRoom;
import es.usc.rai.coego.martin.demiurgo.json.JsonRoom;
import es.usc.rai.coego.martin.demiurgo.json.JsonUser;
import es.usc.rai.coego.martin.demiurgo.json.JsonVariable;
import es.usc.rai.coego.martin.demiurgo.values.ClassTyped;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class DemiurgoRoom extends DemiurgoLocation implements Comparable<DemiurgoRoom> {
	protected String longPath;
	protected Map<String, ValueInterface> variables;
	protected List<Action> actions;
	protected String prenarration;

	public DemiurgoRoom(String longName, World world, long id) {
		super(world, id);
		variables = new HashMap<>();
		this.actions = new ArrayList<Action>();
		this.longPath = longName;
		this.prenarration = null;
	}

	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * 
	 * @param narration
	 */
	public DemiurgoRoom(long id, String long_path, Map<String, ValueInterface> variables, String prenarration) {
		super(id);
		this.longPath = long_path;
		this.variables = variables;
		this.actions = null;
		this.prenarration = prenarration;
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
		return getUsers().stream().filter(u -> u.getDecision() != null).collect(Collectors.toList());
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
		objects = (List<DemiurgoObject>) in.readObject();
	}

	public JsonRoom toJson() {
		JsonRoom r = new JsonRoom();
		r.setId(getId());
		r.setLongPath(getLongPath());

		// Variables to JSON
		List<JsonVariable> variables = new ArrayList<>();
		for (Entry<String, ValueInterface> v : getVariables().entrySet()) {
			variables.add(new JsonVariable(v.getKey(), v.getValue().getValueAsString(), v.getValue().getTypeName()));
		}

		variables.sort(Comparator.comparing(JsonVariable::getName));
		r.setVariables(variables);

		// Objects to JSON
		List<JsonObject> objects = new ArrayList<>();
		for (DemiurgoObject o : getObjects()) {
			objects.add(o.toJson());
		}
		r.setObjects(objects);

		List<JsonUser> users = new ArrayList<>();
		users.sort(Comparator.comparing(JsonUser::getName));
		for (User u : getUsers()) {
			users.add(u.toJson());
		}
		r.setUsers(users);

		r.setPrenarration(getPrenarration());
		return r;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getPrenarration() {
		return prenarration;
	}

	public void setPrenarration(String prenarration) {
		this.prenarration = prenarration;
	}

	public void appendPrenarration(String prenarration) {
		if (this.prenarration == null)
			this.prenarration = "";
		if (prenarration != null)
			this.prenarration += prenarration + "\n";
	}

	public boolean areActionsInCache() {
		return actions != null;
	}

	public void clearDecisionsAndPrenarration() {
		prenarration = null;
		for (User u : getUsers()) {
			u.setDecision(null);
		}
		world.getPendingRooms().remove(this);
	}

	@Override
	public DemiurgoRoom getRealLocation() {
		return this;
	}

	@Override
	public boolean isInsideOf(DemiurgoObject another) {
		return false;
	}

	public JsonPendingRoom toJsonPendingRoom() {
		return new JsonPendingRoom(getLongPath(), getObjects().size(), getUsers().size(),
				getDecidingUsers().stream().map(u -> u.getUsername()).collect(Collectors.toList()));
	}

	@Override
	public int compareTo(DemiurgoRoom another) {
		return getLongPath().compareTo(another.getLongPath());
	}

	public void removeVariable(String varName) {
		variables.remove(varName);
	}

	public void clearObjectReferences(DemiurgoObject obj) {
		for (Entry<String, ValueInterface> e : variables.entrySet()) {
			e.getValue().clearObjectReferences(obj);
		}
	}

	@Override
	public void destroyLocation() {
		List<DemiurgoObject> list = new ArrayList<>(getObjects());
		for (DemiurgoObject o : list) {
			o.destroyObject(true);
		}

		getWorld().markRoomToDestroy(this);
	}

	public void clearClassReferences(DemiurgoClass cl) {
		for (ValueInterface v : getVariables().values()) {
			if (v instanceof ClassTyped && ((ClassTyped) v).getClassType() != null
					&& ((ClassTyped) v).getClassType().equals(cl)) {
				((ClassTyped)v).setClassType(getWorld().getRootClass());
			}
		}
	}
}
