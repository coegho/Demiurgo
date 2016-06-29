package universe;

import java.util.HashMap;
import java.util.Map;

import plataformarol.StoredSymbol;

public class WorldObject {
	protected UserDefinedClass ownClass;
	protected WorldContainer location;
	protected Map<String, StoredSymbol> fields;

	public UserDefinedClass getUserClass() {
		return ownClass;
	}

	public void setUserClass(UserDefinedClass ownClass) {
		this.ownClass = ownClass;
	}

	public WorldContainer getLocation() {
		return location;
	}

	public void setLocation(WorldContainer location) {
		this.location = location;
	}
	
	public StoredSymbol getField(String fieldName) {
		return fields.get(fieldName);
	}

	public WorldObject(UserDefinedClass ownClass, WorldContainer location) {
		this.ownClass = ownClass;
		this.location = location;
		this.fields = new HashMap<>();
		for(String varName : ownClass.getDefaultVariables().keySet()) {
			fields.put(varName, new StoredSymbol(ownClass.getDefaultVariables().get(varName).cloneValue()));
		}
	}
}
