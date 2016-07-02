package plataformarol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import universe.ClassMethod;
import universe.UserDefinedClass;
import universe.World;
import universe.WorldRoom;
import values.IReturnValue;

/**
 * This class manages all the symbols found on the input. It store all the variables
 * and their values, and a reference of the current room.
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class SymbolTable {
	protected Map<String, StoredSymbol> variables;
	protected GlobalScope globals;
	protected List<Scope> scopes;
	protected Scope currentScope;
	protected World currentWorld;
	protected WorldRoom currentRoom;
	protected UserDefinedClass definingClass;
	protected ClassMethod definingMethod;
	
	public SymbolTable(World world, WorldRoom room) {
		this.variables = new HashMap<>();
		currentWorld = world;
		currentRoom = room;
		scopes = new ArrayList<>();
		globals = new GlobalScope(currentWorld);
		currentScope = new RoomScope(this.currentRoom, globals);
		scopes.add(globals);
		scopes.add(currentScope);
	}
	
	public StoredSymbol getVariable(String name) {
		return currentScope.getVariable(name);
	}
	
	public void setVariable(String name, IReturnValue value) {
		currentScope.setVariable(name, value);
	}
	
	public WorldRoom getCurrentRoom() {
		return currentRoom;
	}
	
	public World getCurrentWorld() {
		return currentWorld;
	}
	
	public UserDefinedClass getDefiningClass() {
		return definingClass;
	}

	public void setDefiningClass(UserDefinedClass definingClass) {
		this.definingClass = definingClass;
	}
	
	public ClassMethod getDefiningMethod() {
		return definingMethod;
	}
	
	public void setDefiningMethod(ClassMethod definingMethod) {
		this.definingMethod = definingMethod;
	}
	
	public void pushScope(Scope scope) {
		scopes.add(scope);
		currentScope = scope;
	}
	
	public void popScope() {
		scopes.remove(scopes.size()-1);
		currentScope = scopes.get(scopes.size()-1);
	}
	
	public Scope getScope() {
		return currentScope;
	}
}


