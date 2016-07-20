package universe;

import java.util.HashMap;
import java.util.Map;

public class WorldRoom extends WorldContainer {
	protected String longName;
	protected Map<String, StoredSymbol> variables;
	
	public WorldRoom(String longName, World world) {
		super(world);
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
	
	
	//TODO: variables lack type definition
	public StoredSymbol getVariable(String name) {
		return variables.get(name);
	}
	
	public void setVariable(String name, StoredSymbol value) {
		this.variables.put(name, value);
	}
}
