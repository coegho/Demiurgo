package plataformarol;

import universe.World;
import values.IReturnValue;

public class GlobalScope extends Scope {
	//TODO: Has world its own variables?
	protected World world;
	
	public GlobalScope(World world) {
		this.world = world;
	}
	
	@Override
	public StoredSymbol getVariable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVariable(String name, IReturnValue value) {
		// TODO Auto-generated method stub
		
	}
}
