package universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

public class ClassMethod {
	protected ParseTree node;
	protected List<String> argNames; //arguments ordered by num
	protected Map<String, StoredSymbol> args;
	protected String ReturnVariable;
	
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
		return ReturnVariable;
	}

	public void setReturnVariable(String returnVariable) {
		ReturnVariable = returnVariable;
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
	
}
