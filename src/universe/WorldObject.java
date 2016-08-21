package universe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import serializable.SerializableValue;
import serializable.SerializableWorldObject;
import values.ObjectValue;

public class WorldObject {
	protected long id;
	protected UserDefinedClass ownClass;
	protected WorldLocation location;
	protected Map<String, StoredSymbol> fields;
	protected User user;

	public WorldObject(UserDefinedClass ownClass, WorldLocation location) {
		this.ownClass = ownClass;
		this.location = location;
		this.fields = new HashMap<>();
		for(String varName : ownClass.getFields().keySet()) {
			StoredSymbol field = ownClass.getField(varName);
			fields.put(varName, new StoredSymbol(field.getValue().cloneValue()));
		}
		fields.put("this", new StoredSymbol(new ObjectValue(this), false));
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

	public void moveTo(WorldLocation location) {
		this.location.removeObject(this);
		this.location = location;
		location.addObject(this);
	}
	
	public StoredSymbol getField(String fieldName) {
		return fields.get(fieldName);
	}

	public void setField(String fieldName, StoredSymbol value) {
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
		Map<String, SerializableValue> variables = new HashMap<>();
		for(String s : fields.keySet()) {
			variables.put(s, fields.get(s).getValue());
		}
		return new SerializableWorldObject(id, ownClass.getClassName(), ((location!=null)?location.getId():null), variables, ((user!=null)?user.getUsername():null));
	}
}
