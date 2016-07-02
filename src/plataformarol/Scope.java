package plataformarol;

import values.IReturnValue;

public abstract class Scope {
	public abstract StoredSymbol getVariable(String name);
	public abstract void setVariable(String name, IReturnValue value);
}
