package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.universe.RootObjectClass;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;

public class DestroyFunction extends BuiltinFunction {

	public DestroyFunction(RootObjectClass cl) {
		super();
		addArgument("obj", ObjectValue.defaultValue(cl));
	}
	
	@Override
	public void execute(Scope scope) {
		ObjectValue obj = (ObjectValue) scope.getVariable("obj");
		obj.getObj().destroyObject(true);
	}

}
