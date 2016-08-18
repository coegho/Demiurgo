package universe;

import java.util.HashMap;
import java.util.Map;

import values.ObjectValue;

public class WorldObject {
	protected long id;
	protected UserDefinedClass ownClass;
	protected WorldLocation location;
	protected Map<String, StoredSymbol> fields;
	protected String user; //TODO: only a string?

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
	
	public Map<String, String> fieldsToString() {
		HashMap<String, String> ret = new HashMap<>();
		for(String k : fields.keySet()) {
			ret.put(k, fields.get(k).getValue().toString());
		}
		return ret;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
}
