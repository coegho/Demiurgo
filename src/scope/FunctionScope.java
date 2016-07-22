package scope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import universe.ClassMethod;
import universe.StoredSymbol;
import values.IReturnValue;

/**
 * 
 * This scope is used when a function is called.
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class FunctionScope extends Scope {
	protected ClassMethod method;
	protected ObjectScope parent;
	protected Map<String, StoredSymbol> variables;
	protected String retVarName;
	
	public FunctionScope(ClassMethod method,
			List<IReturnValue> args, String retVarName, ObjectScope parent) {
		this.method = method;
		this.parent = parent;
		this.retVarName = retVarName;
		this.variables = new HashMap<>();
		for(int i = 0; i<args.size(); i++) {
			String argName = method.getArgumentName(i);
			this.variables.put(argName,
					new StoredSymbol(args.get(i)));
		}
		if(method.hasReturnArgument()) {
			String retArgName = method.getReturnArgumentName();
			IReturnValue retArg = method.getArgumentType(retArgName);
			this.variables.put(retArgName, new StoredSymbol(retArg));
		}
	}
	
	@Override
	public StoredSymbol getVariable(String name) {
		if(variables.containsKey(name))
			return variables.get(name);
		else
			return parent.getVariable(name);
	}

	@Override
	public void setVariable(String name, StoredSymbol value) {
		variables.put(name, value);
		
	}

	public ObjectScope getParent() {
		return parent;
	}

	public StoredSymbol getReturnVariable() {
		return variables.get(retVarName);
	}
}
