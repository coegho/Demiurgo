package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import es.usc.rai.coego.martin.demiurgo.coe.COELexer;
import es.usc.rai.coego.martin.demiurgo.parsing.ExecVisitor;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ClassMethod extends DemiurgoMethod {
	protected ParseTree node;

	public ClassMethod(List<String> argNames, Map<String, ValueInterface> args, String retVarName, ParseTree node) {
		super(argNames, args, retVarName);
		if (node != null)
			this.node = node;
		else // creates a dummy node
			this.node = new TerminalNodeImpl(new CommonToken(COELexer.WS));
	}

	public ParseTree getNode() {
		return node;
	}

	public void setNode(ParseTree node) {
		this.node = node;
	}

	
	public void execute(ExecVisitor vis) {
		vis.visit(getNode());
	}

}
