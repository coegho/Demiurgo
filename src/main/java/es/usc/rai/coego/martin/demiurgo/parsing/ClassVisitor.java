package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Class_defContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.CodeContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ClassFilenameMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.CodeClassInClassFileException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;
import es.usc.rai.coego.martin.demiurgo.values.NullValue;

public class ClassVisitor extends ExecVisitor {

	private DemiurgoClass cl;

	public ClassVisitor(DemiurgoClass cl) {
		this.cl = cl;
		sm = new ScopeManager(cl);
	}

	/**
	 * Defines a new class.
	 * <p>
	 * class_def : SYMBOL ( '(' SYMBOL ')' )? ('/n')* '{' ('/n')* fields?
	 * methods? '}' ;
	 */
	@Override
	public ValueInterface visitClass_def(Class_defContext ctx) {
		try {
			String className = ctx.SYMBOL(0).getText().toLowerCase();
			if (!className.equals(cl.getClassName())) {
				throw new ClassFilenameMismatchException(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
						ctx.start.getStartIndex(), cl.getClassName(), className);
			}

			if (ctx.SYMBOL(1) != null) { // inherit from another class
				String parentName = ctx.SYMBOL(1).getText().toLowerCase();
				if(parentName.equalsIgnoreCase(className)) {
					//A class cannot inherit from itself
					throw new RuntimeException(/*TODO: custom exception*/);
				}
				cl.setParentClass(getSM().getClassFromName(parentName));
			} else {// inherit from "Object" class
				cl.setParentClass(getSM().getCurrentWorld().getRootClass());
			}

			if (ctx.fields() != null) {
				visit(ctx.fields());

			}
			if (ctx.methods() != null) {
				visit(ctx.methods());

			}

			return new NullValue();
		} catch (ClassFilenameMismatchException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns an error because a class visitor cannot process a code input.
	 */
	@Override
	public ValueInterface visitCode(CodeContext ctx) {
		throw new RuntimeException(new CodeClassInClassFileException(ctx.start.getLine(),
				ctx.start.getCharPositionInLine(), ctx.start.getStartIndex()));
	}

}
