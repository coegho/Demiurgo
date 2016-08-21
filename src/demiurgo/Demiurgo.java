package demiurgo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import coe.COELexer;
import coe.COEParser;
import database.DatabaseInterface;
import database.MariaDBDatabase;
import serializable.ServerInterfaceImpl;
import universe.User;
import universe.UserDefinedClass;
import universe.World;
import universe.WorldObject;
import universe.WorldRoom;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class Demiurgo {
	protected static Map<String, World> worlds;

	public static void main(String[] args) {
		worlds = new HashMap<>();

		File platRoot = new File("worlds");
		if (!platRoot.exists()) {
			System.err.println("ERROR: Cannot find 'worlds' folder");
			System.exit(1);
		}
		if (!platRoot.isDirectory()) {
			System.err.println("ERROR: 'worlds' is not a folder");
			System.exit(2);
		}

		// looking for worlds
		for (File w : platRoot.listFiles()) {
			if (w.isDirectory()) {
				// It must be a world
				try {
					worlds.put(w.getName().toLowerCase(), rebuildWorld(w));
				} catch (IOException e) {
					System.err.println(e.getMessage());
					System.exit(4);
				}
			} else {
				System.err.println("WARNING: " + w.getName() + " is not a folder");
			}
		}

		/*
		 * for(String w : worlds.keySet()) { loadFromDatabase(worlds.get(w)); }
		 */
		loadFromDatabase(worlds.get("mundo1")); // TODO: Example

		int portNum = 5555;
		String registryURL = "plataformarol", hostName = "localhost";
		try {
			startRegistry(portNum);
			ServerInterfaceImpl objetoServidor = new ServerInterfaceImpl();
			registryURL = "rmi://" + hostName + ":" + portNum + "/" + registryURL;
			Naming.rebind(registryURL, objetoServidor);
			System.out.println("RMI READY");
		} catch (RemoteException re) {
			System.out.println("RemoteException in PlataformaRol.main: " + re);
			System.out.println(re.getCause() + ":::" + re.getLocalizedMessage());
		} catch (IOException re) {
			System.out.println("IOException in PlataformaRol.main: " + re);
			System.out.println(re.getCause() + ":::" + re.getLocalizedMessage());
		}

		// TODO: Check
		for (String wn : worlds.keySet()) {
			// Checking world state
			World w = worlds.get(wn);
			System.out.println("##########CHECKING WORLD STATE: " + w.getName() + "########");
			System.out.println("--DEFINED CLASSES--");
			for (String c : w.getAllClasses()) {
				System.out.println(c);
			}
			System.out.println("--USERS--");
			for (String c : w.getAllUserNames()) {
				System.out.println(c);
			}
			System.out.println("--CHECKING ROOMS--");
			for (WorldRoom r : w.getAllRooms()) {
				System.out.println("ROOM " + r.getLongPath());
				System.out.print("| OBJECTS = {");
				for (WorldObject o : r.getObjects()) {
					System.out.print(" #" + o.getId() + ":" + o.getUserClass().getClassName());
				}
				System.out.println(" }");
				System.out.print("| VARIABLES = {");
				for (String s : r.getAllVarNames())
					System.out.print(" " + s + "=" + r.getVariable(s).toString());
				System.out.println(" }");
			}
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Saving changes...");
				saveAllInDatabase();
				System.out.println("Changes saved correctly");
			}
		});

		// TODO: little eclipse hack

		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static synchronized void loadFromDatabase(World world) {
		DatabaseInterface db = new MariaDBDatabase();
		db.createConnection("plataformarol", "mysql", "mysql"); // TODO: config

		// Reading rooms
		List<WorldRoom> rooms = db.readAllRooms();
		for (WorldRoom r : rooms) {
			world.newRoom(r);
		}

		// Reading objects
		List<WorldObject> objs = db.readAllObjects();
		for (WorldObject o : objs) {
			world.addObject(o);
		}

		// Rebuilding room variables
		for (WorldRoom r : rooms) {
			r.rebuild(world);
		}

		// Rebuilding object variables
		for (WorldObject obj : objs) {
			obj.rebuild(world);
		}

		// Reading users
		List<User> users = db.readAllUsers();
		for (User u : users) {
			if (u.getObjId() != -1)
				u.setObj(world.getObject(u.getObjId()));
			world.addUser(u);
		}

		long[] ids = db.readCurrentIDs();

		world.setCurrentObjId(ids[0]);
		world.setCurrentRoomId(ids[1]);

		db.stopConnection();
	}

	private static synchronized void saveWorldInDatabase(World world) {
		DatabaseInterface db = new MariaDBDatabase();
		db.createConnection("plataformarol", "mysql", "mysql"); // TODO: config

		// Writing rooms
		for (WorldRoom room : world.getAllRooms()) {
			db.writeWorldRoom(room);
		}

		// Writing objects
		for (WorldObject o : world.getAllObjects()) {
			db.writeWorldObject(o);
		}

		// Writing users
		for (User u : world.getAllUsers()) {
			db.writeUser(u);
		}

		db.setCurrentIDs(world.getCurrentObjId(), world.getCurrentRoomId());

		db.stopConnection();
	}

	private static World rebuildWorld(File w) throws IOException {
		World world = new World(w.getName().toLowerCase());
		File classes = new File(w, "classes");
		File[] list = classes.listFiles(new RolFileFilter());
		// Declaring classes
		for (File c : list) {
			if (c.exists() && c.isFile()) {
				String filename = c.getName().toLowerCase();
				String className = filename.substring(0, filename.length() - RolFileFilter.extension.length());
				world.addClass(new UserDefinedClass(className, world));
			} else {
				System.err.print(c.getName());
			}
		}
		// Defining classes
		for (File c : list) {
			if (c.exists() && c.isFile()) {
				String filename = c.getName().toLowerCase();
				String className = filename.substring(0, filename.length() - RolFileFilter.extension.length());
				ErrorHandler errors = new ErrorHandler();
				ParseTree tree = parseStream(new FileInputStream(c), errors);
				ClassVisitor eval = new ClassVisitor(world.getClassFromName(className), errors);
				eval.visit(tree);

				if (errors.hasErrors()) {
					for (String e : errors.getErrors()) {
						System.err.println(e);
					}
					System.exit(3);
				}
			}
		}
		return world;
	}

	public static ParseTree parseStream(InputStream is, ErrorHandler errors) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(is);
		COELexer lexer = new COELexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		COEParser parser = new COEParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new ErrorListener(errors));
		ParseTree tree = parser.s(); // parse; start at s
		return tree;
	}

	private static void startRegistry(int RMIPortNum) throws RemoteException {
		try {
			Registry registry = LocateRegistry.getRegistry(RMIPortNum);
			registry.list();

		} catch (RemoteException e) {
			// No valid registry at that port.
			/* Registry registry = */LocateRegistry.createRegistry(RMIPortNum);
		}
	}

	public static World getWorld(String name) {
		return worlds.get(name);
	}

	public static Map<String, World> getWorlds() {
		return worlds;
	}

	private static void saveAllInDatabase() {
		/*
		 * for(String s : worlds.keySet()) { saveWorldInDatabase(worlds.get(s));
		 * }
		 */
		saveWorldInDatabase(worlds.get("mundo1")); // TODO: Example
	}
}

class RolFileFilter implements FilenameFilter {

	static String extension = ".rol";

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}

}