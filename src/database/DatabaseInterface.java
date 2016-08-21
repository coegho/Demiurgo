package database;

import java.util.List;

import universe.User;
import universe.WorldObject;
import universe.WorldRoom;

public interface DatabaseInterface {

	public boolean createConnection(String database, String username, String pass);
	
	public void stopConnection();
	
	public void writeUser(User user);
	
	public void writeWorldObject(WorldObject obj);
	
	public void writeWorldRoom(WorldRoom room);
	
	public List<User> readAllUsers();
	
	public List<WorldObject> readAllObjects();
	
	public List<WorldRoom> readAllRooms();

	public long[] readCurrentIDs();

	public void setCurrentIDs(long objId, long RoomId);
}
