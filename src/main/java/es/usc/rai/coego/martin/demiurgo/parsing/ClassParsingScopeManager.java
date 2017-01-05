package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.scopes.ClassScope;
import es.usc.rai.coego.martin.demiurgo.scopes.WorldScope;

public class ClassParsingScopeManager extends ScopeManager {

	protected ClassScope classScope;
	
	/**
	 * Constructor. The GM is coding a game's class.
	 * 
	 * @param world
	 *            The world in which the parsing is being done.
	 * @param cl
	 *            The class which is being defined.
	 */
	public ClassParsingScopeManager(DemiurgoClass cl) {
		super(new WorldScope(cl.getWorld()));
		classScope = new ClassScope(cl);
		pushScope(classScope);
	}
	
	@Override
	public DemiurgoClass getClassFromName(String className) {
		if(classScope.getCurrentClass().getClassName().equalsIgnoreCase(className)) {
			return classScope.getCurrentClass();
		}
		return globals.getClassFromName(className);
	}

}
