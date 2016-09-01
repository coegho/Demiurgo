package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.values.IReturnValue;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public abstract class Scope {
	public abstract IReturnValue getVariable(String name);
	
	/**
	 * Defines a new variable; if the variable already exists in scope, modifies its value. 
	 * @param name Variable's name.
	 * @param value Variable's value.
	 */
	public abstract void setVariable(String name, IReturnValue value);
}
