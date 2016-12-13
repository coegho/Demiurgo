package es.usc.rai.coego.martin.demiurgo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import es.usc.rai.coego.martin.demiurgo.coe.COELexer;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser;
import es.usc.rai.coego.martin.demiurgo.database.DatabaseInterface;
import es.usc.rai.coego.martin.demiurgo.database.MariaDBDatabase;
import es.usc.rai.coego.martin.demiurgo.exceptions.DemiurgoException;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorListener;
import es.usc.rai.coego.martin.demiurgo.universe.Action;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
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
	protected static Logger logger;

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI;
	public static final String protocol;
	public static final Optional<String> host;
	public static final String path;
	public static final Optional<String> port;

	static {
		protocol = "http://";
		host = Optional.ofNullable(System.getenv("DEMIURGO_HOSTNAME"));
		port = Optional.ofNullable(System.getenv("DEMIURGO_PORT"));
		path = "demiurgo";
		BASE_URI = protocol + host.orElse("localhost") + ":" + port.orElse("5324") + "/" + path + "/";
	}

	private static HttpServer server;

	public static void main(String[] args) {
		logger = Logger.getGlobal();
		logger.setLevel(Level.FINE);
		worlds = new HashMap<>();
		k = loadKey("demiurgo_key");

		File platRoot = new File("worlds");
		if (!platRoot.exists()) {
			logger.severe("ERROR: Cannot find 'worlds' folder");
			System.exit(1);
		}
		if (!platRoot.isDirectory()) {
			logger.severe("ERROR: 'worlds' is not a folder");
			System.exit(2);
		}

		// looking for worlds
		for (File w : platRoot.listFiles()) {
			if (w.isDirectory()) {
				// It must be a world
				try {
					worlds.put(w.getName().toLowerCase(), rebuildWorld(w));
				} catch (IOException e) {
					logger.severe(e.getMessage());
					System.exit(4);
				}
			} else {
				logger.warning(w.getName() + " is not a folder");
			}
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				logger.info("Saving changes...");
				if (server != null) {
					server.shutdown();
				}
				saveAllInDatabase();
				logger.info("Changes saved correctly");
			}
		});

		logger.info("Loading data from database...");
		for(World w : worlds.values()) {
			logger.info("loading " + w.getName() + "...");
			loadFromDatabase(w);
		}
		logger.info("Data loaded");

		server = startServer();
		server.getHttpHandler().setAllowEncodedSlash(true);

		// TODO: little eclipse hack

		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	//TODO: better method of handle keys
	private static Key loadKey(String keyFilePath) {
		ObjectOutputStream oos;
		ObjectInputStream ois;
		try {
			File f = new File(keyFilePath);
			if(!f.exists()) {
				Key key = MacProvider.generateKey();
				FileOutputStream fos = new FileOutputStream(f);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(key);
				return key;
			}
			else {
				FileInputStream fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				Key key = (Key) ois.readObject();
				return key;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static HttpServer startServer() {
		Logger l = Logger.getLogger("org.glassfish.grizzly.http.server.HttpHandler");
		l.setLevel(Level.FINE);
		l.setUseParentHandlers(false);
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.ALL);
		l.addHandler(ch);
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in com.example.rest package
		final ResourceConfig rc = new ResourceConfig().packages("es.usc.rai.coego.martin.demiurgo.webservice")
				.register(JacksonFeature.class).register(RolesAllowedDynamicFeature.class);
		;

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
				world.setUserObject(u, (world.getObject(u.getObjId())));
			world.addUser(u);
			if (u.getDecision() != null && u.getObj() != null && u.getObj().getLocation() instanceof WorldRoom) {
				world.getPendingRooms().add((WorldRoom) u.getObj().getLocation());
				// TODO: characters without room
			}
		}

		// Reading actions
		for (WorldRoom r : rooms) {
			List<Action> l = loadActionsFromRoom(r);
			r.setActions(l);
			for (Action a : l) {
				world.getActions().put(a.getId(), a);
			}
		}

		long[] ids = db.readCurrentIDs();

		world.setCurrentObjId(ids[0]);
		world.setCurrentRoomId(ids[1]);
		world.setCurrentActionId(ids[2]);

		db.stopConnection();
	}

	public static List<Action> loadActionsFromRoom(WorldRoom room) {
		DatabaseInterface db = new MariaDBDatabase();
		db.createConnection("plataformarol", "mysql", "mysql"); // TODO: config
		return db.readActionsFromRoom(room);
	}

	private static synchronized void saveWorldInDatabase(World world) {
		DatabaseInterface db = new MariaDBDatabase();
		db.createConnection("plataformarol", "mysql", "mysql"); // TODO: config

		// Writing rooms
		for (WorldRoom room : world.getAllRooms()) {
			db.writeWorldRoom(room);
			if (room.areActionsInCache()) {
				for (Action a : room.getActions()) {
					db.writeAction(a);
				}
			}
		}

		// Writing objects
		for (WorldObject o : world.getAllObjects()) {
			db.writeWorldObject(o);
		}

		// Writing users
		for (User u : world.getAllUsers()) {
			db.writeUser(u);
		}

		db.setCurrentIDs(world.getCurrentObjId(), world.getCurrentRoomId(), world.getCurrentActionId());

		db.stopConnection();
	}

	private static World rebuildWorld(File w) throws IOException {
		World world = new World(w.getName().toLowerCase());
		Logger wl = Logger.getLogger(World.class.getName() + "." + world.getName());
		wl.setLevel(Level.INFO);
		wl.setUseParentHandlers(false);
		Handler wh = new FileHandler(new File("world.log").getAbsolutePath(), true);
		// wh.setFormatter(new XMLFormatter()); TODO: custom formatter
		wl.addHandler(wh);
		world.setLogger(wl);
		File classes = new File(w, "classes");
		File[] list = classes.listFiles(new COEFileFilter());
		// Declaring classes
		for (File c : list) {
			if (c.exists() && c.isFile()) {
				String filename = c.getName().toLowerCase();
				String className = filename.substring(0, filename.length() - COEFileFilter.extension.length());
				world.addClass(new UserDefinedClass(className, world));
			} else {
				System.err.print(c.getName());
			}
		}
		// Defining classes
		for (File c : list) {
			if (c.exists() && c.isFile()) {
				String filename = c.getName().toLowerCase();
				String className = filename.substring(0, filename.length() - COEFileFilter.extension.length());
				ErrorHandler errors = new ErrorHandler();
				try {
					ParseTree tree = parseStream(new FileInputStream(c), errors);
					ClassVisitor eval = new ClassVisitor(world.getClassFromName(className));
					eval.visit(tree);

				} catch (RuntimeException e) {
					if (e.getCause() instanceof DemiurgoException) {
						DemiurgoException ex = (DemiurgoException) e.getCause();
						System.err.println("Error on file " + className);
						System.err.println(ex.getMessage());
						System.err.println("on line " + ex.getLine() + ", column " + ex.getColumn());
					}
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
		parser.setErrorHandler(new BailErrorStrategy());
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

	public static Logger getLogger() {
		return logger;
	}
}

class COEFileFilter implements FilenameFilter {

	static String extension = ".coe";

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}

}
