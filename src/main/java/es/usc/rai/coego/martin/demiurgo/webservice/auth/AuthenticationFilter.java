package es.usc.rai.coego.martin.demiurgo.webservice.auth;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// Check if the HTTP Authorization header is present and formatted
		// correctly
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new NotAuthorizedException("Authorization header must be provided");
		}

		// Extract the token from the HTTP Authorization header
		String token = authorizationHeader.substring("Bearer".length()).trim();

		try {

			// Validate the token
			validateToken(token);

			Jws<Claims> cl = Jwts.parser().setSigningKey(Demiurgo.getKey()).parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			String username = (String) cl.getBody().getSubject();

			requestContext.setSecurityContext(new DemiurgoSecurityContext(username, world,
					requestContext.getSecurityContext().getAuthenticationScheme()));
			
		} catch (Exception e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

	private void validateToken(String token) throws Exception {
		Jwts.parser().setSigningKey(Demiurgo.getKey()).parseClaimsJws(token);
	}
}