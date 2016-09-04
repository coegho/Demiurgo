package es.usc.rai.coego.martin.demiurgo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import es.usc.rai.coego.martin.demiurgo.database.DatabaseInterface;
import es.usc.rai.coego.martin.demiurgo.database.MariaDBDatabase;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.CodeVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import gal.republica.coego.demiurgo.lib.Decision;
import gal.republica.coego.demiurgo.lib.RoomPathData;
import gal.republica.coego.demiurgo.lib.ServerInterface;
import gal.republica.coego.demiurgo.lib.UserData;
import gal.republica.coego.demiurgo.lib.WorldRoomData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class ServerInterfaceImpl extends UnicastRemoteObject implements ServerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerInterfaceImpl() throws RemoteException {
		super();
	}

	@Override
	public String login(String world, String name, String password) throws RemoteException {
		DatabaseInterface db = new MariaDBDatabase();
		db.createConnection("plataformarol", "mysql", "mysql"); // TODO: config
		if (db.login(name, password)) {
			User user = Demiurgo.getWorld(world).getUser(name.toLowerCase());
			if(user == null) {
				return null;
			}
			Key key = Demiurgo.getKey();
			try {
			String token = Jwts.builder().setSubject(user.getUsername())
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.claim("role", user.isAdmin() ? "admin" : "player")
					.claim("world", world.toLowerCase())
					.signWith(SignatureAlgorithm.HS512, key)
					.compact();
			return token;
			}catch(Exception e){System.err.println(e.getLocalizedMessage());}
		}
		return null;
	}
	
	@Override
	public UserData me(String token) throws RemoteException {
		/*try {
			Jws<Claims> cl = Jwts.parser().setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			return Demiurgo.getWorld(world).getUser(cl.getBody().getSubject()).toJSON();
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return null;
		}*/return null;
	}

	@Override
	public WorldRoomData checkRoom(String token, String path) throws RemoteException {
		/*try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			WorldRoom room = Demiurgo.getWorld(world).getRoom(path);
			return room.toJSON();
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return null;
		}*/return null;
	}

	@Override
	public boolean executeCode(String token, String path, String code) throws RemoteException {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			ErrorHandler errors = new ErrorHandler();
			InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
			ParseTree tree;

			tree = Demiurgo.parseStream(is, errors);

			WorldRoom room = Demiurgo.getWorld(world).getRoom(path);
			if (room == null) {
				return false;
			}
			CodeVisitor eval = new CodeVisitor(room, errors);
			eval.visit(tree);

			if (errors.hasErrors()) {
				for (String e : errors.getErrors()) {
					System.err.println(e); // TODO: Output this and check errors
				}
			}
			return true;
		} catch (SignatureException | MissingClaimException | IncorrectClaimException | IOException e) {
			System.err.println(e.getLocalizedMessage());
			return false;
		}
	}

	@Override
	public boolean newClass(String token, String name, String code) throws RemoteException {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			ErrorHandler errors = new ErrorHandler();
			InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
			ParseTree tree;

			tree = Demiurgo.parseStream(is, errors);

			UserDefinedClass newClass = new UserDefinedClass(name, w);
			w.addClass(newClass);
			ClassVisitor eval = new ClassVisitor(newClass, errors);
			eval.visit(tree);

			if (errors.hasErrors()) {
				for (String e : errors.getErrors()) {
					System.err.println(e); // TODO: Output this and check errors
				}
				w.removeClass(newClass.getClassName());
			}
			return true;
		} catch (SignatureException | MissingClaimException | IncorrectClaimException | IOException e) {
			System.err.println(e.getLocalizedMessage());
			return false;
		}
	}

	@Override
	public boolean createRoom(String token, String path) throws RemoteException {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			WorldRoom room = Demiurgo.getWorld(world).newRoom(path);
			return room != null;
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return false;
		}
	}

	@Override
	public void submitDecision(String token, String text) throws RemoteException {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "player").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			String user = (String) cl.getBody().getSubject();
			World w = Demiurgo.getWorld(world);
			w.addDecision(w.getUser(user), text);
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public List<String> getPendingRooms(String token) throws RemoteException {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			if (w == null)
				return null;
			List<String> l = new ArrayList<>();
			for (WorldRoom r : w.getPendingRooms()) {
				l.add(r.getLongPath());
			}
			return l;
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public List<Decision> getNoRoomDecisions(String token) throws RemoteException {
		/*try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			if (w == null)
				return null;
			return w.getDecisions();
			
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return null;
		}*/return null;
	}

	@Override
	public RoomPathData getAllRoomPaths(String token) throws RemoteException {
		/*try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			if (w == null)
				return null;
			return w.getRoomPaths();
			
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			*/return null;
		//}
	}
}
