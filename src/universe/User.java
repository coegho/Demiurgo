package universe;

import java.io.IOException;

import serializable.SerializableUser;

public class User implements SerializableUser {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String username;
	protected transient WorldObject obj;
	
	//Serializable fields
	protected long obj_id;
	
	public User(String username) {
		this.username = username;
	}
	
	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 */
	public User(String username, long obj_id) {
		this.username = username;
		this.obj_id = obj_id;
	}
	
	@Override
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
		if(obj.getUser() != this) {
			obj.setUser(this);
		}
	}

	@Override
	public long getObjId() {
		return ((obj != null)?obj.getId():-1);
	}
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(getUsername());
		out.writeLong(getObjId());
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		username = (String) in.readObject();
		obj_id = in.readLong();
	}
	
	
	public void rebuild(World world) {
		if(obj_id != -1) {
			obj = world.getObject(obj_id);
		}
	}
}
