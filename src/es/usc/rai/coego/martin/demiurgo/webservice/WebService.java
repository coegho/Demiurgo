package es.usc.rai.coego.martin.demiurgo.webservice;

import java.security.Key;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.database.DatabaseInterface;
import es.usc.rai.coego.martin.demiurgo.database.MariaDBDatabase;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/webservice")
public class WebService {

	@Path("/login")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@QueryParam("name") String name, @QueryParam("password") String password,
			@QueryParam("world") String world) {
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

	
	@Path("/me")@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String me(@QueryParam("request") String request) {

		String response = null;

		response = "Response from Jersey Restful Webservice : " + request;

		return response;
	}

	
	@Path("/checkroom")@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String checkRoom(@QueryParam("request") String request) {

		String response = null;

		response = "Response from Jersey Restful Webservice : " + request;

		return response;
	}

	
	@Path("/executecode")@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String executeCode(@QueryParam("request") String request) {
		String response = null;

		response = "Response from Jersey Restful Webservice : " + request;

		return response;
	}
}