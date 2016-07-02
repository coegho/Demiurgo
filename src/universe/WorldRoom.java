package universe;

import java.util.HashMap;
import java.util.Map;

import plataformarol.StoredSymbol;
import values.IReturnValue;

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
	
	public void setVariable(String name, IReturnValue value) {
		if(variables.containsKey(name)) {
			variables.get(name).setValue(value);
		}
		else {
			this.variables.put(name, new StoredSymbol(value));
		}
	}
}
