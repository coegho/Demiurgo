package plataformarol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scope.ClassScope;
import scope.RoomScope;
import scope.Scope;
import scope.WorldScope;
import universe.StoredSymbol;
import universe.User;
import universe.UserDefinedClass;
import universe.World;
import universe.WorldObject;
import universe.WorldRoom;

/**
 * This class manages all the symbols found on the input. It manage code scopes
 * that store all the variables and their values where appropiate. It stores too
 * a reference to the current room and world.
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class ScopeManager {
	protected Map<String, StoredSymbol> variables;
	protected WorldScope globals;
	protected List<Scope> scopes;
	protected Scope currentScope;
	protected RoomScope roomScope;

	/**
	 * Constructor. The GM is coding ordinary code of a normal action.
	 * 
	 * @param world
	 *            The world in which the parsing is being done.
	 * @param room
	 *            The room in which the action is happening.
	 */
	public ScopeManager(WorldRoom room) {
		this.variables = new HashMap<>();
		scopes = new ArrayList<>();
		globals = new WorldScope(room.getWorld());
		currentScope = roomScope = new RoomScope(room, globals);
		scopes.add(globals);
		scopes.add(currentScope);
	}

	/**
	 * Constructor. The GM is coding a game's class.
	 * 
	 * @param world
	 *            The world in which the parsing is being done.
	 * @param cl
	 *            The class which is being defined.
	 */
	public ScopeManager(UserDefinedClass cl) {
		this.variables = new HashMap<>();
		scopes = new ArrayList<>();
		globals = new WorldScope(cl.getWorld());
		currentScope = new ClassScope(cl);
		scopes.add(globals);
		scopes.add(currentScope);
	}

	public StoredSymbol getVariable(String name) {
		return currentScope.getVariable(name);
	}

	public void setVariable(String name, StoredSymbol value) {
		currentScope.setVariable(name, value);
	}

	// Room
	//TODO: irrelevant in class scope
	public WorldRoom getCurrentRoom() {
		return roomScope.getRoom();
	}

	// World
	public World getCurrentWorld() {
		return globals.getWorld();
	}

	public UserDefinedClass getClassFromName(String className) {
		return globals.getClassFromName(className);
	}

	public UserDefinedClass getRootClass() {
		return globals.getRootClass();
	}


	public WorldObject getObject(long id) {
		return globals.getObject(id);
	}

	public WorldRoom getRoom(String roomLongName) {
		return globals.getRoom(roomLongName);
	}

	public WorldRoom getRoom(String roomRelativeName, String currentRoom) {
		return globals.getRoom(roomRelativeName, currentRoom);
	}

	public void setUserObject(User user, WorldObject obj) {
		globals.setUserObject(user, obj);
	}

	// Scopes

	public void pushScope(Scope scope) {
		scopes.add(scope);
		currentScope = scope;
	}

	public void popScope() {
		scopes.remove(scopes.size() - 1);
		currentScope = scopes.get(scopes.size() - 1);
	}

	public Scope getScope() {
		return currentScope;
	}
}
