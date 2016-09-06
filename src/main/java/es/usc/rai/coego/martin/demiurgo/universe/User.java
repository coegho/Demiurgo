package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class User {
	protected String username;
	protected boolean admin;
	protected transient WorldObject obj;

	// Serializable fields
	protected long obj_id;

	public User(String username, boolean admin) {
		this.username = username;
		this.admin = admin;
	}

	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 */
	public User(String username, boolean admin, long obj_id) {
		this.username = username;
		this.admin = admin;
		this.obj_id = obj_id;
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
		if (obj.getUser() != this) {
			obj.setUser(this);
		}
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public long getObjId() {
		return ((obj != null) ? obj.getId() : -1);
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(getUsername());
		out.writeLong(getObjId());
		out.writeBoolean(isAdmin());
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		username = (String) in.readObject();
		obj_id = in.readLong();
		admin = in.readBoolean();
	}

	public void rebuild(World world) {
		if (obj_id != -1) {
			obj = world.getObject(obj_id);
		}
	}
	
	public ObjectNode toJSON() {
		ObjectNode userdata = new ObjectMapper().createObjectNode();
        userdata.put("username", getUsername());
        if(getObjId() != -1)
        	userdata.put("obj_id", getObjId());
        userdata.put("admin", isAdmin()?"admin":"player");
		
		return userdata;
	}
}
