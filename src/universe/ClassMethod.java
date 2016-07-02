package universe;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

public class ClassMethod {
	protected ParseTree node;
	protected List<String> args; //TODO: types
	protected String ReturnVariable; //TODO: types
	
	public ClassMethod(ParseTree node) {
		this.node = node;
		this.args = new ArrayList<>();
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
		return args.get(index);
	}
	
	public void addArgument(String argName) {
		//TODO typed variables
		args.add(argName);
	}
	
}
