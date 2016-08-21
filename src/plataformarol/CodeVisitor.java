package plataformarol;

import exceptions.ClassDefinitionOnCodeException;
import linguaxe.LinguaxeParser.Class_defContext;
import universe.WorldRoom;
import values.IReturnValue;

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
