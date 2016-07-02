package universe;

import java.util.HashMap;
import java.util.Map;

import plataformarol.StoredSymbol;
import values.IReturnValue;

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
			fields.put(varName, new StoredSymbol(ownClass.getFields().get(varName).cloneValue()));
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

	public void setField(String fieldName, IReturnValue value) {
		//TODO: undeclared variables, and typed variables
		fields.put(fieldName, new StoredSymbol(value));
	}
}
