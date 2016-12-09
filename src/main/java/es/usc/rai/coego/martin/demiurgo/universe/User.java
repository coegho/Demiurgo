package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;

public class User {
	protected String username;
	protected UserRole role;
	protected transient WorldObject obj;
	protected String decision;

	// Serializable fields
	protected long obj_id;

	public User(String username, UserRole role) {
		this.username = username;
		this.role = role;
	}

	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * @param string 
	 */
	public User(String username, UserRole role, long obj_id, String decision) {
		this.username = username;
		this.role = role;
		this.obj_id = obj_id;
		this.decision = decision;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public WorldObject getObj() {
		return obj;
	}

	public void setObj(WorldObject obj) {
		this.obj = obj;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public UserRole getRole() {
		return role;
	}

	public long getObjId() {
		return ((obj != null) ? obj.getId() : -1);
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(getUsername());
		out.writeLong(getObjId());
		out.writeObject(getRole());
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		username = (String) in.readObject();
		obj_id = in.readLong();
		role = (UserRole) in.readObject();
	}

	public void rebuild(World world) {
		if (obj_id != -1) {
			obj = world.getObject(obj_id);
		}
	}
	/*
	public ObjectNode toJSON() {
		ObjectNode userdata = new ObjectMapper().createObjectNode();
        userdata.put("username", getUsername());
        if(getObjId() != -1)
        	userdata.put("obj_id", getObjId());
        userdata.put("admin", isAdmin()?"admin":"player");
		
		return userdata;
	}*/
}
