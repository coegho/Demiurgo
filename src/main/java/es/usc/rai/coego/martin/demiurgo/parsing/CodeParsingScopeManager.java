package es.usc.rai.coego.martin.demiurgo.parsing;

import es.usc.rai.coego.martin.demiurgo.scopes.RoomScope;
import es.usc.rai.coego.martin.demiurgo.scopes.WorldScope;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;

public class CodeParsingScopeManager extends ScopeManager {
	protected RoomScope roomScope;
	
	/**
	 * Constructor. The GM is coding ordinary code of a normal action.
	 * 
	 * @param world
	 *            The world in which the parsing is being done.
	 * @param room
	 *            The room in which the action is happening.
	 */
	public CodeParsingScopeManager(DemiurgoRoom room) {
		super(new WorldScope(room.getWorld()));
		roomScope = new RoomScope(room, globals);
		pushScope(roomScope);
	}
	
	public DemiurgoRoom getCurrentRoom() {
		return roomScope.getRoom();
	}
}
