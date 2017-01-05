package es.usc.rai.coego.martin.demiurgo.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.usc.rai.coego.martin.demiurgo.scopes.RoomScope;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.scopes.WorldScope;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

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
	protected Map<String, ValueInterface> variables;
	protected WorldScope globals;
	protected List<Scope> scopes;
	protected Scope currentScope;
	protected RoomScope roomScope;

	/**
	 * Generic constructor.
	 * @param worldScope
	 * @param classScope 
	 */
	public ScopeManager(WorldScope globalScope) {
		this.variables = new HashMap<>();
		scopes = new ArrayList<>();
		globals = globalScope;
		pushScope(globalScope);
	}

	public ValueInterface getVariable(String name) {
		return currentScope.getVariable(name);
	}

	public void setVariable(String name, ValueInterface value) {
		currentScope.setVariable(name, value);
	}

	// Room
	//TODO: irrelevant in class scope
	public DemiurgoRoom getCurrentRoom() {
		return roomScope.getRoom();
	}

	// World
	public World getCurrentWorld() {
		;return globals.getWorld();
	}

	public DemiurgoClass getClassFromName(String className) {
		return globals.getClassFromName(className);
	}

	public DemiurgoClass getRootClass() {
		return globals.getRootClass();
	}


	public DemiurgoObject getObject(long id) {
		return globals.getObject(id);
	}

	public DemiurgoRoom getRoom(String roomLongName) {
		return globals.getRoom(roomLongName);
	}

	public DemiurgoRoom getRoom(String roomRelativeName, String currentRoom) {
		return globals.getRoom(roomRelativeName, currentRoom);
	}

	public void setUserObject(User user, DemiurgoObject obj) {
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
