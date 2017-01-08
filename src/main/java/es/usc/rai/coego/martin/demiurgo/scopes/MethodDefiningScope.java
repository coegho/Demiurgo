package es.usc.rai.coego.martin.demiurgo.scopes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class MethodDefiningScope extends Scope {
	private ClassScope parent;
	private List<String> argNames;
	private Map<String, ValueInterface> args;
	private String retVarName;
	
	public MethodDefiningScope(ClassScope parent) {
		this.parent = parent;
		argNames = new ArrayList<>();
		args = new HashMap<>();
	}
	
	@Override
	public ValueInterface getVariable(String name) {
		return parent.getVariable(name);
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		parent.setVariable(name, value);
	}

	@Override
	public DemiurgoMethod getMethod(String methodName) {
		return parent.getMethod(methodName);
	}

	//Method defining
	public String getReturnArgumentName() {
		return retVarName;
	}

	public void setReturnArgument(String varName, ValueInterface varValue) {
		if(hasReturnArgument()) {
			args.remove(retVarName);
		}
		retVarName = varName;
		args.put(varName, varValue);
	}
	
	public boolean hasReturnArgument() {
		return retVarName != null;
	}
	
	public String getArgumentName(int index) {
		return argNames.get(index);
	}
	
	public ValueInterface getArgumentType(String argName) {
		return args.get(argName).cloneValue();
	}
	
	public void addArgument(String argName, ValueInterface type) {
		argNames.add(argName);
		args.put(argName, type);
	}
	
	public List<String> getArgNames() {
		return argNames;
	}
	
	public Map<String, ValueInterface> getArgs() {
		return args;
	}
	
	public String getRetVarName() {
		return retVarName;
	}
}
