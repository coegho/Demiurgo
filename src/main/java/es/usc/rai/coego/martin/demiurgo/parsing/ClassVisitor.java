package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Class_defContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.CodeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.InventoryTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.New_objContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Var_declContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ClassFilenameMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.CodeClassInClassFileException;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.values.InventoryValue;
import es.usc.rai.coego.martin.demiurgo.values.NullValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ClassVisitor extends ExecVisitor {

	private DemiurgoClass cl;

	public ClassVisitor(DemiurgoClass cl) {
		this.cl = cl;
		sm = new ClassParsingScopeManager(cl);
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

			if (ctx.SYMBOL().size() == 2) { // inherit from another class
				String parentName = ctx.SYMBOL(1).getText().toLowerCase();
				if(parentName.equalsIgnoreCase(className)) {
					//A class cannot inherit from itself
					throw new RuntimeException(/*TODO: custom exception*/);
				}
				cl.setParentClass(getSM().getClassFromName(parentName));
			}
			else {
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
	 * Adds a new field into the current class.
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
	 * Returns a default INVENTORY value (it counts as a type).
	 */
	@Override
	public ValueInterface visitInventoryType(InventoryTypeContext ctx) {
		return InventoryValue.defaultValue(getSM().getCurrentWorld());
	}

	/**
	 * Returns an error because a class visitor cannot process a code input.
	 */
	@Override
	public ValueInterface visitCode(CodeContext ctx) {
		throw new RuntimeException(new CodeClassInClassFileException(ctx.start.getLine(),
				ctx.start.getCharPositionInLine(), ctx.start.getStartIndex()));
	}
	
	/**
	 * Returns an error because a class visitor cannot create new objects.
	 * <p>
	 * new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;
	 */
	@Override
	public ValueInterface visitNew_obj(New_objContext ctx) {
		//TODO: different exception
		throw new RuntimeException(new CodeClassInClassFileException(ctx.SYMBOL().getSymbol().getLine(),
				ctx.SYMBOL().getSymbol().getCharPositionInLine(),
				ctx.start.getStartIndex()));
	}

}
