package es.usc.rai.coego.martin.demiurgo.webservice.auth;

import java.security.Principal;

public class DemiurgoPrincipal implements Principal {

	protected String name;
	protected String world;
	
	public DemiurgoPrincipal(String name, String world) {
		this.name = name;
		this.world = world;
	}
	@Override
	public String getName() {
		return name;
	}
	
	public String getWorld() {
		return world;
	}

}
