package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Class_defContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ClassDefinitionOnCodeException;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class CodeVisitor extends ExecVisitor {

	public CodeVisitor(WorldRoom room, ErrorHandler errors) {
		super(errors);
		sm = new ScopeManager(room);
		this.errors = errors;
	}

	/**
	 * Returns an error because a code visitor cannot process a class input.
	 */
	@Override
	public ValueInterface visitClass_def(Class_defContext ctx) {
		errors.notifyError(new ClassDefinitionOnCodeException());
		return null;
	}
	
}
