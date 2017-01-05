package es.usc.rai.coego.martin.demiurgo.scopes;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class WorldScope extends Scope {
	//TODO: Has world its own variables?
	protected World world;
	
	public WorldScope(World world) {
		this.world = world;
	}
	
	@Override
	public ValueInterface getVariable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVariable(String name, ValueInterface value) {
		// TODO Auto-generated method stub
		
	}
	
	public World getWorld() {
		return world;
	}

	public DemiurgoClass getClassFromName(String className) {
		return world.getClassFromName(className);
	}

	public DemiurgoClass getRootClass() {
		return world.getRootClass();
	}

	public void addClass(DemiurgoClass newClass) {
		world.addClass(newClass);
		
	}

	public DemiurgoObject getObject(long id) {
		return world.getObject(id);
	}

	public DemiurgoRoom getRoom(String roomLongName) {
		return world.getRoom(roomLongName);
	}

	public DemiurgoRoom getRoom(String roomRelativeName, String currentRoom) {
		return world.getRoom(roomRelativeName, currentRoom);
	}

	public void setUserObject(User user, DemiurgoObject obj) {
		world.setUserObject(user, obj);
	}
}
