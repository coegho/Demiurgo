package serializable;

import java.io.Serializable;

public class SerializableUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String username;
	protected long obj_id;

	public SerializableUser(String username) {
		this.username = username;
		this.obj_id = -1;
	}
	
	public SerializableUser(String username, long obj_id) {
		this.username = username;
		this.obj_id = obj_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getObj_id() {
		return obj_id;
	}

	public void setObj_id(long obj_id) {
		this.obj_id = obj_id;
	}

}
