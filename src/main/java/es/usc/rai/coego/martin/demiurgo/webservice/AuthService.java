package es.usc.rai.coego.martin.demiurgo.webservice;

import java.security.Key;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.database.DatabaseInterface;
import es.usc.rai.coego.martin.demiurgo.database.MariaDBDatabase;
import es.usc.rai.coego.martin.demiurgo.json.LoginRequest;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/login")
public class AuthService {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(LoginRequest req) {
		DatabaseInterface db = new MariaDBDatabase();
		db.createConnection("plataformarol", "mysql", "mysql"); // TODO:
		if (db.login(req.getName(), req.getPassword())) {
			User user = Demiurgo.getWorld(req.getWorld()).getUser(req.getName().toLowerCase());
			if (user != null) {

				String token = issueToken(user.getUsername(), req.getWorld().toLowerCase(),
						Demiurgo.getKey());
				System.out.println("Logged " + req.getName() + " in world " + req.getWorld() + " with role " + user.getRole().toString());

				return Response.ok(token).build();
			}
		}
		return Response.status(Response.Status.UNAUTHORIZED).build();
	}

	private String issueToken(String username, String world, Key key) {
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.claim("world", world)
				.signWith(SignatureAlgorithm.HS512, key).compact();
		return token;
	}
}
