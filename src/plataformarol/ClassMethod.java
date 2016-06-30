package plataformarol;

import org.antlr.v4.runtime.tree.ParseTree;

public class ClassMethod {
	protected ParseTree node;
	protected String ReturnVariable;
	
	public ClassMethod(ParseTree node) {
		this.node = node;
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
	
	
}
