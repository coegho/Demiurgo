package es.usc.rai.coego.martin.demiurgo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import es.usc.rai.coego.martin.demiurgo.coe.COELexer;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser;
import es.usc.rai.coego.martin.demiurgo.database.DatabaseInterface;
import es.usc.rai.coego.martin.demiurgo.database.MariaDBDatabase;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorListener;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import gal.republica.coego.demiurgo.lib.ServerInterface;
import io.jsonwebtoken.impl.crypto.MacProvider;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class Demiurgo {
	protected static Map<String, World> worlds;
	protected static Key k;
	// Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/demiurgo/";
    private static HttpServer server;

	public static void main(String[] args) {
		 
		worlds = new HashMap<>();
		k = MacProvider.generateKey();
		
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

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Saving changes...");
				/*try {
					LocateRegistry.getRegistry().unbind("Demiurgo");
				} catch (RemoteException | NotBoundException e) {
					System.err.println(e.getLocalizedMessage());
				}*/
				if(server != null) {
					server.shutdown();
				}
				saveAllInDatabase();
				System.out.println("Changes saved correctly");
			}
		});

		// int portNum = 5555; //TODO: use this port

		/*
		 * if (System.getSecurityManager() == null) System.setSecurityManager (
		 * new SecurityManager() );
		 */

		/*try {
			ServerInterfaceImpl remote = new ServerInterfaceImpl();
			// registryURL = "rmi://" + hostName + ":" + portNum + "/" +
			// registryURL;

			ServerInterface stub = (ServerInterface) UnicastRemoteObject.toStub(remote);

			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Demiurgo", stub);

			System.out.println("RMI READY");
		} catch (RemoteException e) {
			System.err.println(e.getLocalizedMessage());
			System.exit(-1);
		} catch (AlreadyBoundException e) {
			System.err.println(e.getLocalizedMessage());
			System.exit(-1);
		}*/
		
		/*
		 * for(String w : worlds.keySet()) { loadFromDatabase(worlds.get(w)); }
		 */
		loadFromDatabase(worlds.get("mundo1")); // TODO: Example
		
		server = startServer();
		
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
					System.out.print(" #" + o.getId() + ":" + o.getClassName());
				}
				System.out.println(" }");
				System.out.print("| VARIABLES = {");
				for (String s : r.getAllVarNames())
					System.out.print(" " + s + "=" + r.getVariable(s).toString());
				System.out.println(" }");
			}
		}

		// TODO: little eclipse hack

		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example.rest package
        final ResourceConfig rc = new ResourceConfig().packages("es.usc.rai.coego.martin.demiurgo.webservice");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

	public static Key getKey() {
		return k;
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
