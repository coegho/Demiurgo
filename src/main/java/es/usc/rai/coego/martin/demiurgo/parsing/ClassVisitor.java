package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ArgsContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Class_defContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.CodeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.InventoryTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MethodContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.New_objContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Var_declContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.BadConstructorException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ClassFilenameMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.CodeClassInClassFileException;
import es.usc.rai.coego.martin.demiurgo.scopes.MethodDefiningScope;
import es.usc.rai.coego.martin.demiurgo.universe.ClassMethod;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.values.InventoryValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ClassVisitor extends ExecVisitor {

	private DemiurgoClass cl;

	public ClassVisitor(DemiurgoClass cl) {
		this.cl = cl;
		sm = new ClassParsingScopeManager(cl);
	}
	
	protected DemiurgoClass getCurrentClass() {
		return cl;
	}
	
	public ClassParsingScopeManager getSM() {
		return (ClassParsingScopeManager) sm;
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

			return null;
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
		
		getCurrentClass().addField(varName, type, ctx.operation());

		return null;
	}
	
	/**
	 * Defines a new method in the current class.
	 * <p>
	 * method : ( data_type SYMBOL ASSIGN )? metname=SYMBOL '(' args? ')' nl?
	 * '{' code? '}' ;
	 */
	@Override
	public ValueInterface visitMethod(MethodContext ctx) {
		try {
			// TODO: non-class methods?
			MethodDefiningScope ms = new MethodDefiningScope(getSM().getClassScope());
			getSM().pushScope(ms);
			DemiurgoClass curClass = getSM().getClassScope().getCurrentClass();
			String methodName = ctx.metname.getText().toLowerCase();

			//input arguments
			if (ctx.args() != null) {
				visit(ctx.args());
			}
			
			//ouput argument
			if (ctx.ASSIGN() != null) {
				String returnName = ctx.SYMBOL(0).getText().toLowerCase();
				ValueInterface t = visit(ctx.data_type());

				ms.setReturnArgument(returnName, t);

			}
			
			ClassMethod cm = new ClassMethod(ms.getArgNames(), ms.getArgs(), ms.getRetVarName(), ctx.code());
			
			if (methodName.equals(curClass.getClassName())) { // CONSTRUCTOR
				if (ctx.ASSIGN() != null) {
					throw new BadConstructorException(ctx.ASSIGN().getSymbol().getLine(),
							ctx.ASSIGN().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex());
				}
				curClass.setConstructor(cm); // TODO: at this moment only one
												// constructor is allowed
			} else {
				curClass.addMethod(methodName, cm);
			}
			
			
		} catch (BadConstructorException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	/**
	 * Defines the arguments of the method or function.
	 * <p>
	 * args : data_type SYMBOL ( ',' data_type SYMBOL )* ;
	 */
	@Override
	public ValueInterface visitArgs(ArgsContext ctx) {
		for (int i = 0; i < ctx.SYMBOL().size(); i++) {
			String argName = ctx.SYMBOL(i).getText().toLowerCase();
			ValueInterface typeV = visit(ctx.data_type(i));

			((MethodDefiningScope) getSM().getScope()).addArgument(argName, typeV);
		}
		return null;
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
