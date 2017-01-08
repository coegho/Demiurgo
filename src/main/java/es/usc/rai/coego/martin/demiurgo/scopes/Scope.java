package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public abstract class Scope {
	public abstract ValueInterface getVariable(String name);
	
	/**
	 * Defines a new variable; if the variable already exists in scope, modifies its value. 
	 * @param name Variable's name.
	 * @param value Variable's value.
	 */
	public abstract void setVariable(String name, ValueInterface value);

	public abstract DemiurgoMethod getMethod(String methodName);
}
