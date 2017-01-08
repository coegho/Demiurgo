package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;

public abstract class BuiltinMethod extends DemiurgoMethod {

	public abstract void execute(Scope scope);
}
