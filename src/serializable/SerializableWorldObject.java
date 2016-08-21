package serializable;

import java.io.Serializable;
import java.util.Map;

import values.IReturnValue;

public class SerializableWorldObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected long id;
	protected String className;
	protected long loc_id;
	protected String user;
	protected Map<String, IReturnValue> fields;

	public SerializableWorldObject(long id, String className, long loc_id, Map<String, IReturnValue> fields, String user) {
		this.id = id;
		this.className = className;
		this.loc_id = loc_id;
		this.user = user;
		this.fields = fields;
	}
	
	public SerializableWorldObject(long id, String className, long loc_id, Map<String, IReturnValue> fields) {
		this.id = id;
		this.className = className;
		this.loc_id = loc_id;
		this.user = null;
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "<#"+id+" ("+className+") "+((user!=null)?(" ["+user+"]"):"")+">";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(long loc_id) {
		this.loc_id = loc_id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Map<String, IReturnValue> getFields() {
		return fields;
	}

	public void setFields(Map<String, IReturnValue> fields) {
		this.fields = fields;
	}
	
	
}
