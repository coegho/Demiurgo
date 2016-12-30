package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;

import es.usc.rai.coego.martin.demiurgo.json.JsonUser;

public class User {
	protected String username;
	protected UserRole role;
	protected transient DemiurgoObject obj;
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

	public DemiurgoObject getObj() {
		return obj;
	}

	public void setObj(DemiurgoObject obj) {
		this.obj = obj;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public UserRole getRole() {
		return role;
	}

	public long getObjId() {
		return obj_id;
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
	
	public JsonUser toJson() {
		JsonUser ju = new JsonUser();
		ju.setName(getUsername());
		ju.setObj((getObj() != null)?(getObj().toJson()):null);
		ju.setRole(getRole().toString());
		ju.setDecision(getDecision());
		return ju;
	}
}
