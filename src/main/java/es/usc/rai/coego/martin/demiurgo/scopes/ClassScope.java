package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ClassScope extends Scope {

	protected DemiurgoClass currentClass;
	
	public ClassScope(DemiurgoClass currentClass) {
		this.currentClass = currentClass;
	}
	
	@Override
	public ValueInterface getVariable(String name) {
		return currentClass.getField(name);
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		currentClass.addField(name, value, null);
	}

	public DemiurgoClass getCurrentClass() {
		return currentClass;
	}

	@Override
	public DemiurgoMethod getMethod(String methodName) {
		if(currentClass.getWorld().getMethods().containsKey(methodName)) {
			return currentClass.getWorld().getMethod(methodName);
		}
		return currentClass.getMethod(methodName);
	}
}
