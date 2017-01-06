package es.usc.rai.coego.martin.demiurgo.database;

import java.util.List;

import es.usc.rai.coego.martin.demiurgo.universe.Action;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.Inventory;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoLocation;

public interface DatabaseInterface {
	
	public boolean existsActiveConnection();

	public boolean createConnection(String url, String username, String pass);
	
	public void beginTransaction();
	
	public void commitTransaction();
	
	public void rollbackTransaction();
	
	public void stopConnection();
	
	public boolean login(String name, String password);
	
	public User register(String name, String password);
	
	public boolean changePassword(String name, String oldPassword, String newPassword);
	
	public void writeUser(User user);
	
	public void writeDemiurgoObject(DemiurgoObject obj);
	
	public void deleteDemiurgoObject(DemiurgoObject obj);
	
	public void writeDemiurgoClass(DemiurgoClass cl);
	
	public void writeLocationId(DemiurgoLocation location);
	
	public void writeWorldRoom(DemiurgoRoom room);

	void writeInventory(Inventory inv);

	public void deleteInventory(Inventory i);
	
	public void writeAction(Action action);
	
	public List<User> readAllUsers();
	
	public List<DemiurgoObject> readAllObjects();
	
	public List<DemiurgoClass> readAllClasses();
	
	public List<DemiurgoRoom> readAllRooms();
	
	List<Inventory> readAllInventories();
	
	public List<Action> readActionsFromRoom(DemiurgoRoom room);

	public long[] readCurrentIDs();

	public void setCurrentIDs(long objId, long RoomId, long actionId);

	public void deleteLocation(DemiurgoLocation loc);

	public void deleteClass(DemiurgoClass cl);

	public void deleteRoom(DemiurgoRoom r);

}
