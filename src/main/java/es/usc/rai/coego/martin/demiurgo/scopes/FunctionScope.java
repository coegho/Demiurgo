package es.usc.rai.coego.martin.demiurgo.scopes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

/**
 * 
 * This scope is used when a function is called.
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class FunctionScope extends Scope {
	protected DemiurgoMethod method;
	protected Scope parent;
	protected Map<String, ValueInterface> variables;
	
	public FunctionScope(DemiurgoMethod method,
			List<ValueInterface> args, Scope parent) {
		this.method = method;
		this.parent = parent;
		this.variables = new HashMap<>();
		for(int i = 0; i<args.size(); i++) {
			String argName = method.getArgumentName(i);
			this.variables.put(argName, args.get(i));
		}
		if(method.hasReturnArgument()) {
			String retArgName = method.getReturnArgumentName();
			ValueInterface retArg = method.getArgumentType(retArgName);
			this.variables.put(retArgName, retArg);
		}
	}
	
	@Override
	public ValueInterface getVariable(String name) {
		if(variables.containsKey(name))
			return variables.get(name);
		else
			return parent.getVariable(name);
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		variables.put(name, value);
		
	}

	public Scope getParent() {
		return parent;
	}

	public ValueInterface getReturnVariable() {
		return variables.get(method.getReturnArgumentName());
	}

	@Override
	public DemiurgoMethod getMethod(String methodName) {
		return parent.getMethod(methodName);
	}
}
