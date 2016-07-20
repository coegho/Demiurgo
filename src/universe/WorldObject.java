package universe;

import java.util.HashMap;
import java.util.Map;

public class WorldObject {
	protected long id;
	protected UserDefinedClass ownClass;
	protected WorldContainer location;
	protected Map<String, StoredSymbol> fields;

	public WorldObject(UserDefinedClass ownClass, WorldContainer location) {
		this.ownClass = ownClass;
		this.location = location;
		this.fields = new HashMap<>();
		for(String varName : ownClass.getFields().keySet()) {
			StoredSymbol field = ownClass.getField(varName);
			fields.put(varName, new StoredSymbol(field.getValue().cloneValue()));
		}
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

	public WorldContainer getLocation() {
		return location;
	}

	public void moveTo(WorldContainer location) {
		this.location.removeObject(this);
		this.location = location;
		location.addObject(this);
	}
	
	public StoredSymbol getField(String fieldName) {
		return fields.get(fieldName);
	}

	public void setField(String fieldName, StoredSymbol value) {
		//TODO: undeclared variables
		fields.put(fieldName, value);
	}
}
