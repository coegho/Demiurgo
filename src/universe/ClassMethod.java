package universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import values.IReturnValue;

public class ClassMethod {
	protected ParseTree node;
	protected List<String> argNames; //arguments ordered by num
	protected Map<String, StoredSymbol> args;
	protected String retVarName;
	
	public ClassMethod(ParseTree node) {
		this.node = node;
		this.argNames = new ArrayList<>();
		this.args = new HashMap<>();
	}

	public ParseTree getNode() {
		return node;
	}

	public void setNode(ParseTree node) {
		this.node = node;
	}

	public String getReturnVariable() {
		return retVarName;
	}

	public void setReturnVariable(String varName, StoredSymbol varValue) {
		retVarName = varName;
		args.put(varName, varValue);
	}
	
	
	public String getArgumentName(int index) {
		return argNames.get(index);
	}
	
	public StoredSymbol getArgumentType(String argName) {
		return args.get(argName);
	}
	
	public void addArgument(String argName, StoredSymbol type) {
		argNames.add(argName);
		args.put(argName, type);
	}

	public boolean checkArgs(List<IReturnValue> argValues) {
		if(argNames.size() != argValues.size()) {
			return false;
		}
		for(int i=0; i < argNames.size(); i++) {
			if(!args.get(argNames.get(i)).getValue().canAssign(argValues.get(i))) {
				return false;
			}
		}
		return true;
	}
	
}
