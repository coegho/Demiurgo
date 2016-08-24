package gal.republica.coego.demiurgo.universe;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import gal.republica.coego.demiurgo.lib.ValueData;
import gal.republica.coego.demiurgo.lib.WorldObjectData;
import gal.republica.coego.demiurgo.values.IReturnValue;
import gal.republica.coego.demiurgo.values.ObjectValue;

public class WorldObject {
	protected long id;
	protected transient UserDefinedClass ownClass;
	protected transient WorldLocation location;
	protected Map<String, IReturnValue> fields;
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
			IReturnValue field = ownClass.getField(varName);
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
	public WorldObject(long id, String classname, long loc_id, Map<String, IReturnValue> fields) {
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

	public IReturnValue getField(String fieldName) {
		return fields.get(fieldName);
	}

	public void setField(String fieldName, IReturnValue value) {
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

	public Map<String, IReturnValue> getFields() {
		return fields;
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
		fields = ((Map<String, IReturnValue>) in.readObject());
	}

	public void rebuild(World world) {
		ownClass = world.getClassFromName(className);
		location = world.getLocation(loc_id);
		location.addObject(this);
		user = world.getUser(username);
		for (IReturnValue v : fields.values()) {
			v.rebuild(world);
		}
	}
	
	public WorldObjectData worldObjectData() {
		Map<String, ValueData> f = new HashMap<>();
		for(Entry<String, IReturnValue> e : getFields().entrySet()) {
			f.put(e.getKey(), e.getValue().valueData());
		}
		return new WorldObjectData(getId(), getClassName(), getLocId(), f);
	}
}
