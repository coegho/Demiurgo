package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import es.usc.rai.coego.martin.demiurgo.json.JsonObject;
import es.usc.rai.coego.martin.demiurgo.json.JsonVariable;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class WorldObject {
	protected long id;
	protected transient UserDefinedClass ownClass;
	protected transient WorldLocation location;
	protected Map<String, ValueInterface> fields;
	protected transient User user;

	// Serializable fields
	protected String className;
	protected long loc_id;
	protected String username;

	public WorldObject(UserDefinedClass ownClass, WorldLocation location) {
		this.id = -1;
		this.ownClass = ownClass;
		this.location = location;
		this.fields = new HashMap<>();
		for (String varName : ownClass.getFields().keySet()) {
			ValueInterface field = ownClass.getField(varName);
			fields.put(varName, field.cloneValue());
		}
		ObjectValue v = new ObjectValue(this);
		v.setWritable(false);
		fields.put("this", v);
		location.addObject(this);
		location.getWorld().addObject(this);
	}

	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * 
	 * @param id
	 *            Object's ID.
	 * @param classname
	 *            Name of the object's class.
	 * @param loc_id
	 *            ID of the object's location.
	 * @param fields
	 *            Object's fields.
	 */
	public WorldObject(long id, String classname, long loc_id, Map<String, ValueInterface> fields) {
		this.id = id;
		this.className = classname;
		this.loc_id = loc_id;
		this.fields = fields;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDefinedClass getUserClass() {
		return ownClass;
	}

	public void setUserClass(UserDefinedClass ownClass) {
		this.ownClass = ownClass;
	}

	public WorldLocation getLocation() {
		return location;
	}

	public void setLocation(WorldLocation location) {
		this.location = location;
	}

	public void moveTo(WorldLocation location) {
		this.location.getWorld().moveTo(this.location, location, this);
	}

	public ValueInterface getField(String fieldName) {
		return fields.get(fieldName);
	}

	public void setField(String fieldName, ValueInterface value) {
		fields.put(fieldName, value);
	}

	public Set<String> getAllFieldNames() {
		return fields.keySet();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getClassName() {
		return ownClass.getClassName();
	}

	public long getLocId() {
		return location.getId();
	}

	public String getUsername() {
		if (user != null) {
			return user.getUsername();
		}
		return null;
	}

	public Map<String, ValueInterface> getFields() {
		Map<String, ValueInterface> retFields = new HashMap<>();
		for(Entry<String, ValueInterface> e: fields.entrySet()) {
			if(!e.getKey().equals("this")) {
				retFields.put(e.getKey(), e.getValue());
			}
		}
		return retFields;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeLong(getId());
		out.writeObject(getClassName());
		out.writeLong(getLocId());
		out.writeObject(getUsername());
		out.writeObject(getFields());
	}

	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		id = in.readLong();
		className = (String) in.readObject();
		loc_id = in.readLong();
		username = (String) in.readObject();
		fields = ((Map<String, ValueInterface>) in.readObject());
	}

	public void rebuild(World world) {
		ownClass = world.getClassFromName(className);
		location = world.getLocation(loc_id);
		location.addObject(this);
		user = world.getUser(username);
		for (ValueInterface v : fields.values()) {
			v.rebuild(world);
		}
	}

	public JsonObject toJson() {
		List<JsonVariable> fields = new ArrayList<>();
		for (Entry<String, ValueInterface> v : getFields().entrySet()) {
			fields.add(new JsonVariable(v.getKey(), v.getValue().getValueAsString(), v.getValue().getTypeName()));
		}
		return new JsonObject(getId(), getClassName(), getLocId(), fields);
	}
}
