package scope;

import universe.ClassMethod;
import universe.StoredSymbol;
import universe.UserDefinedClass;

public class ClassScope extends Scope {

	protected UserDefinedClass currentClass;
	protected ClassMethod definingMethod;
	
	public ClassScope(UserDefinedClass currentClass) {
		this.currentClass = currentClass;
	}
	
	@Override
	public StoredSymbol getVariable(String name) {
		return currentClass.getField(name);//TODO
	}

	@Override
	public void setVariable(String name, StoredSymbol value) {
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
