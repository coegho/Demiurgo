package es.usc.rai.coego.martin.demiurgo.scopes;

import java.util.HashMap;
import java.util.Map;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class LoopScope extends Scope {

	protected Scope parent;
	protected Map<String, ValueInterface> variables;
	
	public LoopScope(Scope parent) {
		this.parent = parent;
		variables = new HashMap<>();
	}
	
	@Override
	public ValueInterface getVariable(String name) {
		if(variables.containsKey(name)) {
			return variables.get(name);
		}
		else {
			return parent.getVariable(name);
		}
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		variables.put(name, value);
	}

	@Override
	public DemiurgoMethod getMethod(String methodName) {
		return parent.getMethod(methodName);
	}

}
