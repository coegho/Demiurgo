package gal.republica.coego.demiurgo.parsing;

import gal.republica.coego.demiurgo.coe.COEParser.Class_defContext;
import gal.republica.coego.demiurgo.exceptions.ClassDefinitionOnCodeException;
import gal.republica.coego.demiurgo.universe.WorldRoom;
import gal.republica.coego.demiurgo.values.IReturnValue;

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
	public IReturnValue visitClass_def(Class_defContext ctx) {
		errors.notifyError(new ClassDefinitionOnCodeException());
		return null;
	}
	
}
