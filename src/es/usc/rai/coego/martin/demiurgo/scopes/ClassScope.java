package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.ClassMethod;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.values.IReturnValue;

public class ClassScope extends Scope {

	protected UserDefinedClass currentClass;
	protected ClassMethod definingMethod;
	
	public ClassScope(UserDefinedClass currentClass) {
		this.currentClass = currentClass;
	}
	
	@Override
	public IReturnValue getVariable(String name) {
		return currentClass.getField(name);
	}

	@Override
	public void setVariable(String name, IReturnValue value) {
		currentClass.addField(name, value);
	}

	public UserDefinedClass getCurrentClass() {
		return currentClass;
	}
	
	public ClassMethod getDefiningMethod() {
		return definingMethod;
	}
	
	public void setDefiningMethod(ClassMethod definingMethod) {
		this.definingMethod = definingMethod;
	}
}
