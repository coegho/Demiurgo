package es.usc.rai.coego.martin.demiurgo.webservice.auth;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.universe.User;

public class DemiurgoSecurityContext implements SecurityContext {

	User user;
	String authenticationScheme;
	Principal userPrincipal;
	
	public DemiurgoSecurityContext(String username, String world, String authenticationScheme) {
		super();
		this.user = Demiurgo.getWorld(world).getUser(username);
		this.authenticationScheme = authenticationScheme;
		this.userPrincipal = new DemiurgoPrincipal(username, world);
	}

	@Override
	public String getAuthenticationScheme() {
		return authenticationScheme;
	}

	@Override
	public Principal getUserPrincipal() {
		return userPrincipal;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public boolean isUserInRole(String checkrole) {
		return checkrole.equals(user.getRole().toString());
	}

}
