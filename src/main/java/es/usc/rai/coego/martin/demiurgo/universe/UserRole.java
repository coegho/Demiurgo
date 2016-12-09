package es.usc.rai.coego.martin.demiurgo.universe;

public enum UserRole {
	GM(1, "gm"), USER(0, "user");
	protected int id;
	protected String name;
	
	UserRole(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
