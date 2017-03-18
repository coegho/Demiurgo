package es.usc.rai.coego.martin.demiurgo.universe;

import org.antlr.v4.runtime.tree.ParseTree;

import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class DefaultField {
	private ParseTree node;
	private ValueInterface value;

	public DefaultField(ValueInterface field, ParseTree initialAssign) {
		this.value = field;
		this.node = initialAssign;
	}

	public ParseTree getInitialAssign() {
		return node;
	}

	public void setInitialAssign(ParseTree initialAssign) {
		this.node = initialAssign;
	}

	public ValueInterface getField() {
		return value;
	}

	public void setField(ValueInterface field) {
		this.value = field;
	}
}