package plataformarol;

import java.util.HashMap;
import java.util.Map;

import universe.UserDefinedClass;
import universe.World;
import universe.WorldRoom;

/**
 * This class manages all the symbols found on the input. It store all the variables
 * and their values, and a reference of the current room.
 * @author Martín Coego Pérez
 *
 */
public class SymbolTable {
	protected Map<String, StoredSymbol> variables;
	protected World currentWorld;
	protected WorldRoom currentRoom;
	protected UserDefinedClass definingClass;
	
	public StoredSymbol getVariable(String name) {
		if(!variables.containsKey(name)) {
			variables.put(name, new StoredSymbol(null));
		}
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
	
	public WorldRoom getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(WorldRoom currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public World getCurrentWorld() {
		return currentWorld;
	}
	
	public void setCurrentWorld(World currentWorld) {
		this.currentWorld = currentWorld;
	}
	
	public UserDefinedClass getDefiningClass() {
		return definingClass;
	}

	public void setDefiningClass(UserDefinedClass definingClass) {
		this.definingClass = definingClass;
	}

	public SymbolTable() {
		this.variables = new HashMap<>();
	}
}


