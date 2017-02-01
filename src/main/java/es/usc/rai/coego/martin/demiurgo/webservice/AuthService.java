package es.usc.rai.coego.martin.demiurgo.webservice;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.database.DatabaseInterface;
import es.usc.rai.coego.martin.demiurgo.database.MariaDBDatabase;
import es.usc.rai.coego.martin.demiurgo.database.WorldDBData;
import es.usc.rai.coego.martin.demiurgo.json.LoginRequest;
import es.usc.rai.coego.martin.demiurgo.json.RegisterUserRequest;
import es.usc.rai.coego.martin.demiurgo.json.RegisterUserResponse;
import es.usc.rai.coego.martin.demiurgo.json.ResponseStatus;
import es.usc.rai.coego.martin.demiurgo.json.WorldListResponse;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/")
public class AuthService {
	@Path("/worlds")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorldList() {
		WorldListResponse res = new WorldListResponse();
		List<String> worlds = Demiurgo.getWorlds().values().stream().map(w -> w.getName()).collect(Collectors.toList());
		res.setWorlds(worlds);
		return Response.ok(res).build();
	}

	@Path("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(LoginRequest req) {
		// hashing
		String hashedPass = hashPassword(req.getPassword());
		World w = Demiurgo.getWorld(req.getWorld().toLowerCase());
		if(w == null) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Cannot find world "+ req.getWorld()).build();
		}
		DatabaseInterface db = new MariaDBDatabase();
		WorldDBData dbData = Demiurgo.getWorldsConfig().getWorlds().get(w.getName());
		db.createConnection(dbData.getUrl(), dbData.getUser(), dbData.getPasswd());

		if (db.login(req.getName(), hashedPass)) {
			db.stopConnection();
			User user = w.getUser(req.getName().toLowerCase());
			if (user != null) {
				String token = issueToken(user.getUsername(), req.getWorld().toLowerCase(), Demiurgo.getKey());
				System.out.println("Logged " + req.getName() + " in world " + req.getWorld() + " with role "
						+ user.getRole().toString());

				return Response.ok(token).build();
			}
			w.getLogger().severe("Found user '" + req.getName() +  "' in database but cannot find it on world");
		}
		db.stopConnection();
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}

	@Path("/register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(RegisterUserRequest req) {
		RegisterUserResponse res = new RegisterUserResponse();

		String world = req.getWorld();
		String username = req.getUsername();
		String password = req.getPassword();

		World w = Demiurgo.getWorld(world);
		if (w == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find world " + world).build();
		}

		if (!checkCredentialsConditions(username, password)) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Name and password does not satisfy the conditions").build();
		}
		
		if(w.getUser(username) != null) {
			res.setStatus(new ResponseStatus(false, "Name already in use"));
			return Response.ok(res).build();
		}
		
		DatabaseInterface db = new MariaDBDatabase();
		WorldDBData dbData = Demiurgo.getWorldsConfig().getWorlds().get(w.getName());
		db.createConnection(dbData.getUrl(), dbData.getUser(), dbData.getPasswd());
		
		String hashedPass = hashPassword(password);
		
		User u = db.register(username, hashedPass, req.getMail());
		w.addUser(u);
		
		//TODO: authorization by mail and gm
		res.setActive(true);
		res.setStatus(new ResponseStatus());
		return Response.ok(res).build();
	}

	private String issueToken(String username, String world, Key key) {
		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.claim("world", world).signWith(SignatureAlgorithm.HS512, key).compact();
		return token;
	}

	private boolean checkCredentialsConditions(String username, String password) {
		Pattern pat = Pattern.compile("^[A-Z0-9_]+$", Pattern.CASE_INSENSITIVE);
		return username.length() >= 2 &&
				password.length() >= 2 &&
				pat.matcher(username).matches();
				
	}
	
	public static String hashPassword(String password) {
		String hashedPass = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			hashedPass = DatatypeConverter.printHexBinary(digest);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			Demiurgo.getLogger().severe(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return hashedPass;
	}
}
