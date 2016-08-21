package database;

import java.util.List;

import serializable.SerializableUser;
import serializable.SerializableWorldObject;
import serializable.SerializableWorldRoom;

public interface DatabaseInterface {

	public boolean createConnection(String database, String username, String pass);
	
	public void stopConnection();
	
	public void writeUser(SerializableUser user);
	
	public void writeWorldObject(SerializableWorldObject obj);
	
	public void writeWorldRoom(SerializableWorldRoom room);
	
	public List<SerializableUser> readAllUsers();
	
	public List<SerializableWorldObject> readAllObjects();
	
	public List<SerializableWorldRoom> readAllRooms();

	public long[] readCurrentIDs();

	public void setCurrentIDs(long objId, long RoomId);
}
