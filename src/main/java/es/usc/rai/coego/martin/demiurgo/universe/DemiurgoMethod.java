package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.usc.rai.coego.martin.demiurgo.json.JsonMethod;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public abstract class DemiurgoMethod {
	protected List<String> argNames; //arguments ordered by num
	protected Map<String, ValueInterface> args;
	protected String retVarName;
	
	public DemiurgoMethod() {
		this.argNames = new ArrayList<>();
		this.args = new HashMap<>();
	}
	
	public DemiurgoMethod(List<String> argNames, Map<String, ValueInterface> args, String retVarName) {
		this.argNames = argNames;
		this.args = args;
		this.retVarName = retVarName;
	}
	
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

	public boolean checkArgs(List<ValueInterface> argValues) {
		if(argNames.size() != argValues.size()) {
			return false;
		}
		for(int i=0; i < argNames.size(); i++) {
			if(!args.get(argNames.get(i)).canAssign(argValues.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String r = "METHOD args={";
		for(String n : argNames) {
			r += " "+n;
		}
		r += " }";
		return r;
	}

	public JsonMethod toJson(String name) {
		List<String> args = new ArrayList<>(this.argNames);
		args.remove(retVarName);
		return new JsonMethod(name, args, retVarName);
	}
	
	public List<ValueInterface> getArgsValues() {
		List<ValueInterface> output = new ArrayList<>();
		for(String n : argNames) {
			output.add(args.get(n));
		}
		return output;
	}
}
