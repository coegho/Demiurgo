package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Class_defContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.EchoContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ClassDefinitionOnCodeException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class CodeVisitor extends ExecVisitor {

	private String prenarration;
	
	public CodeVisitor(WorldRoom room) {
		sm = new ScopeManager(room);
		this.prenarration = "";
	}

	/**
	 * Returns an error because a code visitor cannot process a class input.
	 */
	@Override
	public ValueInterface visitClass_def(Class_defContext ctx) {
		throw new RuntimeException(new ClassDefinitionOnCodeException(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.start.getStartIndex()));
	}
	
	/**
	 * Emits output. Useful for debugging and helping the DX to describe the
	 * situation.
	 */
	@Override
	public ValueInterface visitEcho(EchoContext ctx) {
		ValueInterface v = visit(ctx.operation());

		// TODO: temporal code for debugging
		try {
			prenarration += v.castToString();
			System.out.println(v.castToString());
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	public String getPrenarration() {
		return prenarration;
	}
}
