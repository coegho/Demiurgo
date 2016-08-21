package serializable;

import java.io.Serializable;
import java.util.Map;

import values.IReturnValue;

public class SerializableWorldRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected long id;
	protected String long_path;
	protected Map<String, SerializableValue> fields;
	
	public SerializableWorldRoom(long id, String long_path, Map<String, SerializableValue> fields) {
		this.id = id;
		this.long_path = long_path;
		this.fields = fields;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLong_path() {
		return long_path;
	}
	
	public void setLong_path(String long_path) {
		this.long_path = long_path;
	}
	
	public Map<String, SerializableValue> getFields() {
		return fields;
	}
	
	public void setFields(Map<String, SerializableValue> fields) {
		this.fields = fields;
	}
}
