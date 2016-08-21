package serializable;

import java.rmi.Remote;
import java.util.List;

/**
 * This class serves to create a RMI object that acts as a proxy for user
 * interfaces, web interface for example.
 * 
 * @author Martín Coego Pérez
 * @since 1.0
 */
public interface ServerInterface extends Remote {

	/**
	 * Checks the room's contents.
	 * 
	 * @param world
	 *            World's name.
	 * @param path
	 *            Room's path.
	 * @throws java.rmi.RemoteException
	 */
	public List<SerializableWorldObject> checkRoom(String world, String path) throws java.rmi.RemoteException;

	/**
	 * Executes code related to an action.
	 * 
	 * @param world
	 *            World's name.
	 * @param path
	 *            Current room's path.
	 * @param code
	 *            Code to execute.
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public boolean executeCode(String world, String path, String code) throws java.rmi.RemoteException;

	/**
	 * Creates a new class into the world.
	 * 
	 * @param world
	 *            World's name.
	 * @param name
	 *            New class' name.
	 * @param code
	 *            New class' code.
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public boolean newClass(String world, String name, String code) throws java.rmi.RemoteException;

	/**
	 * 
	 * @param world
	 *            World's name.
	 * @param path
	 *            New room's path.
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public boolean createRoom(String world, String path) throws java.rmi.RemoteException;
}
