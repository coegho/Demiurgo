package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Class_defContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.CodeContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ClassFilenameMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.CodeClassInClassFileException;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.values.IReturnValue;
import es.usc.rai.coego.martin.demiurgo.values.NullValue;

public class ClassVisitor extends ExecVisitor {

	private UserDefinedClass cl;

	public ClassVisitor(UserDefinedClass cl, ErrorHandler errors) {
		super(errors);
		this.cl = cl;
		sm = new ScopeManager(cl);
		this.errors = errors;
	}

	/**
	 * Defines a new class.
	 * <p>
	 * class_def : SYMBOL ( '(' SYMBOL ')' )? ('/n')* '{' ('/n')* fields?
	 * methods? '}' ;
	 */
	@Override
	public IReturnValue visitClass_def(Class_defContext ctx) {
		String className = ctx.SYMBOL(0).getText().toLowerCase();
		if (!className.equals(cl.getClassName())) {
			errors.notifyError(new ClassFilenameMismatchException(cl.getClassName(), className));
			return null;
		}

		if (ctx.SYMBOL(1) != null) { // inherit from another class
			String parentName = ctx.SYMBOL(1).getText().toLowerCase();
			cl.setParentClass(getSM().getClassFromName(parentName));
		} else {// inherit from "Object" class
			cl.setParentClass(getSM().getCurrentWorld().getRootClass());
		}

		if (ctx.fields() != null) {
			visit(ctx.fields());
			if (errors.hasErrors())
				return null;
		}
		if (ctx.methods() != null) {
			visit(ctx.methods());
			if (errors.hasErrors())
				return null;
		}

		return new NullValue();
	}

	/**
	 * Returns an error because a class visitor cannot process a code input.
	 */
	@Override
	public IReturnValue visitCode(CodeContext ctx) {
		errors.notifyError(new CodeClassInClassFileException());
		return null;
	}

}
