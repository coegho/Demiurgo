package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import es.usc.rai.coego.martin.demiurgo.coe.COELexer;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ClassMethod {
	protected ParseTree node;
	protected List<String> argNames; //arguments ordered by num
	protected Map<String, ValueInterface> args;
	protected String retVarName;
	
	public ClassMethod(ParseTree node) {
		if(node != null)
			this.node = node;
		else //creates a dummy node
			this.node = new TerminalNodeImpl(new CommonToken(COELexer.WS));
		this.argNames = new ArrayList<>();
		this.args = new HashMap<>();
	}

	public ParseTree getNode() {
		return node;
	}

	public void setNode(ParseTree node) {
		this.node = node;
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
	
}
