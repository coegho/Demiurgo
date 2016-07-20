package scope;

import universe.StoredSymbol;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public abstract class Scope {
	public abstract StoredSymbol getVariable(String name);
	
	/**
	 * Defines a new variable; if the variable already exists in scope, modifies its value. 
	 * @param name Variable's name.
	 * @param value Variable's value.
	 */
	public abstract void setVariable(String name, StoredSymbol value);
}
