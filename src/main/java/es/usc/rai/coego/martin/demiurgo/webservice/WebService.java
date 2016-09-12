package es.usc.rai.coego.martin.demiurgo.webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.antlr.v4.runtime.tree.ParseTree;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.database.DatabaseInterface;
import es.usc.rai.coego.martin.demiurgo.database.MariaDBDatabase;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.CodeVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Path("/webservice")
public class WebService {

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@FormParam("name") String name, @FormParam("password") String password,
			@FormParam("world") String world) {
		DatabaseInterface db = new MariaDBDatabase();
		db.createConnection("plataformarol", "mysql", "mysql"); // TODO:
		if (db.login(name, password)) {
			User user = Demiurgo.getWorld(world).getUser(name.toLowerCase());
			if (user == null) {
				return null;
			}
			Key key = Demiurgo.getKey();

			String token = Jwts.builder().setSubject(user.getUsername())
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.claim("role", user.isAdmin() ? "admin" : "player").claim("world", world.toLowerCase())
					.signWith(SignatureAlgorithm.HS512, key).compact();
			System.out.println("Logged " + name + " in world " + world);
			return token;
		}
		return "ERROR: BAD CREDENTIALS";
	}

	@GET
	@Path("/me")
	@Produces(MediaType.APPLICATION_JSON)
	public String me(@QueryParam("token") String token) {
		try {
			Jws<Claims> cl = Jwts.parser().setSigningKey(Demiurgo.getKey()).parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");

			User u = Demiurgo.getWorld(world).getUser(cl.getBody().getSubject());

			if (u != null) {
				return u.toJSON().toString();
			} else
				return null;
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return null;
		}
	}

	@GET
	@Path("/checkroom/{path}")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkRoom(@QueryParam("token") String token, @PathParam("path") String path) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			WorldRoom room = Demiurgo.getWorld(world).getRoom(path);

			if (room != null) {
				return room.toJSON().toString();
			} else {
				System.err.println("Cannot find room '" + path + "'");
				return "ERROR";
			}
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@POST
	@Path("/executecode")
	@Produces(MediaType.APPLICATION_JSON)
	public String executeCode(@FormParam("token") String token, @FormParam("path") String path,
			@FormParam("code") String code) {
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
				System.err.println("Cannot find room '" + path + "'");
				return "ERROR";
			}
			CodeVisitor eval = new CodeVisitor(room, errors);
			eval.visit(tree);

			if (errors.hasErrors()) {
				for (String e : errors.getErrors()) {
					System.err.println(e); // TODO: Output this and check errors
				}
			}
			return "OK";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException | IOException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@POST
	@Path("/newclass")
	@Produces(MediaType.APPLICATION_JSON)
	public String newClass(@FormParam("token") String token, @FormParam("name") String name,
			@FormParam("code") String code) {
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
			return "OK";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException | IOException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@POST
	@Path("/createroom")
	@Produces(MediaType.APPLICATION_JSON)
	public String createRoom(@FormParam("token") String token, @FormParam("path") String path) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			WorldRoom room = Demiurgo.getWorld(world).newRoom(path);
			return (room != null) ? "OK" : "ERROR";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@POST
	@Path("/submitdecision")
	@Produces(MediaType.APPLICATION_JSON)
	public String submitDecision(@FormParam("token") String token, @FormParam("text") String text) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "player").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			String user = (String) cl.getBody().getSubject();
			World w = Demiurgo.getWorld(world);
			w.addDecision(w.getUser(user), text);
			return "OK";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@GET
	@Path("/pendingrooms")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPendingRooms(@QueryParam("token") String token) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			if (w == null)
				return "ERROR";
			return w.getPendingRoomsJSON().toString();
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@GET
	@Path("/noroomdecisions")
	@Produces(MediaType.APPLICATION_JSON)
	public String getNoRoomDecisions(@QueryParam("token") String token) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			if (w == null)
				return "ERROR";
			return w.getDecisions().toString();

		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@GET
	@Path("/roompaths")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllRoomPaths(@QueryParam("token") String token) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			if (w == null)
				return "ERROR";
			return w.getRoomPaths().toString();

		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}
}