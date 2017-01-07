package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Class_defContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.EchoContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.InventoryTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Var_declContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ClassDefinitionOnCodeException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.values.NullValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class CodeVisitor extends ExecVisitor {

	private StringBuilder prenarration;

	public CodeVisitor(DemiurgoRoom room) {
		sm = new CodeParsingScopeManager(room);
	}

	/**
	 * Returns an error because a code visitor cannot process a class input.
	 */
	@Override
	public ValueInterface visitClass_def(Class_defContext ctx) {
		throw new RuntimeException(new ClassDefinitionOnCodeException(ctx.start.getLine(),
				ctx.start.getCharPositionInLine(), ctx.start.getStartIndex()));
	}

	/**
	 * Emits output. Useful for debugging and helping the DX to describe the
	 * situation.
	 */
	@Override
	public ValueInterface visitEcho(EchoContext ctx) {
		ValueInterface v = visit(ctx.operation());

		try {
			appendPrenarration(v.castToString());
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	/**
	 * Declares a new variable into the current room.
	 * <p>
	 * If a class is currently being defined, adds a new field to it.
	 * <p>
	 * var_decl : data_type SYMBOL (ASSIGN operation)? ;
	 */
	@Override
	public ValueInterface visitVar_decl(Var_declContext ctx) {
		ValueInterface type = visit(ctx.data_type());

		String varName = ctx.SYMBOL().getText().toLowerCase();
		if (ctx.operation() != null) {
			ValueInterface v = visit(ctx.operation());
			type.assign(v);

		}
		getSM().setVariable(varName, type);

		return new NullValue();
	}

	/**
	 * Throws an error because a class cannot have inventories.
	 */
	@Override
	public ValueInterface visitInventoryType(InventoryTypeContext ctx) {
		throw new RuntimeException(new ClassDefinitionOnCodeException(ctx.start.getLine(),
				ctx.start.getCharPositionInLine(), ctx.start.getStartIndex()));
	}
	
	public String getPrenarration() {
		if(prenarration != null)
			return prenarration.toString();
		else
			return null;
	}
	
	public void appendPrenarration(String str) {
		if(prenarration == null) {
			prenarration = new StringBuilder();
		}
		prenarration.append(str + "\n");
	}
}
