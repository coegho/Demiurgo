package universe;

public class User {
	protected String username;
	protected WorldObject obj;
	
	public User(String username) {
		this.username = username;
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
		if(obj.getUser() != this) {
			obj.setUser(this);
		}
	}
}
