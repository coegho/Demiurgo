package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.ClassMethod;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ClassScope extends Scope {

	protected DemiurgoClass currentClass;
	protected ClassMethod definingMethod;
	
	public ClassScope(DemiurgoClass currentClass) {
		this.currentClass = currentClass;
	}
	
	@Override
	public ValueInterface getVariable(String name) {
		return currentClass.getField(name);
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		currentClass.addField(name, value);
	}

	public DemiurgoClass getCurrentClass() {
		return currentClass;
	}
	
	public ClassMethod getDefiningMethod() {
		return definingMethod;
	}
	
	public void setDefiningMethod(ClassMethod definingMethod) {
		this.definingMethod = definingMethod;
	}
}
