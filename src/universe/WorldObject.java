package universe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import serializable.SerializableWorldObject;
import values.IReturnValue;
import values.ObjectValue;

public class WorldObject {
	protected long id;
	protected UserDefinedClass ownClass;
	protected WorldLocation location;
	protected Map<String, IReturnValue> fields;
	protected User user;

	public WorldObject(UserDefinedClass ownClass, WorldLocation location) {
		this.id = -1;
		this.ownClass = ownClass;
		this.location = location;
		this.fields = new HashMap<>();
		for(String varName : ownClass.getFields().keySet()) {
			IReturnValue field = ownClass.getField(varName);
			fields.put(varName, field.cloneValue());
		}
		ObjectValue v = new ObjectValue(this);
		v.setWritable(false);
		fields.put("this", v);
		location.addObject(this);
		location.getWorld().addObject(this);
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
	
	public SerializableWorldObject getSerializableWorldObject() {
		return new SerializableWorldObject(id, ownClass.getClassName(), ((location!=null)?location.getId():null), fields, ((user!=null)?user.getUsername():null));
	}

	
}
