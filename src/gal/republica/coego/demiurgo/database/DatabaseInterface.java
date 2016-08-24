package gal.republica.coego.demiurgo.database;

import java.util.List;

import gal.republica.coego.demiurgo.universe.User;
import gal.republica.coego.demiurgo.universe.WorldObject;
import gal.republica.coego.demiurgo.universe.WorldRoom;

public interface DatabaseInterface {
	
	public boolean existsActiveConnection();

	public boolean createConnection(String database, String username, String pass);
	
	public void stopConnection();
	
	public boolean login(String name, String password);
	
	public void writeUser(User user);
	
	public void writeWorldObject(WorldObject obj);
	
	public void writeWorldRoom(WorldRoom room);
	
	public List<User> readAllUsers();
	
	public List<WorldObject> readAllObjects();
	
	public List<WorldRoom> readAllRooms();

	public long[] readCurrentIDs();

	public void setCurrentIDs(long objId, long RoomId);
}