package serializable;

import java.io.Serializable;

public class SerializableDecision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String username;
	protected String room_path;
	protected String text;

	public SerializableDecision(String username, String room_path, String text) {
		super();
		this.username = username;
		this.room_path = room_path;
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoom_path() {
		return room_path;
	}

	public void setRoom_path(String room_path) {
		this.room_path = room_path;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
