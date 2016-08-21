package universe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import serializable.SerializableWorldRoom;
import values.IReturnValue;

public class WorldRoom extends WorldLocation {
	protected String longName;
	protected Map<String, IReturnValue> variables;
	
	public WorldRoom(String longName, World world, long id) {
		super(world, id);
		variables = new HashMap<>();
		this.longName = longName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}
	
	public String getShortName() {
		return longName.substring(longName.lastIndexOf('.'));
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
	
	public SerializableWorldRoom getSerializableWorldRoom() {
		return new SerializableWorldRoom(id, longName, variables);
	}
}
