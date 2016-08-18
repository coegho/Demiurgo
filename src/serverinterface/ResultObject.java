package serverinterface;

import java.io.Serializable;
import java.util.Map;

public class ResultObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected long id;
	protected String className;
	protected String user;
	protected Map<String, String> fields;

	public ResultObject(long id, String className, Map<String, String> fields, String user) {
		this.id = id;
		this.className = className;
		this.user = user;
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "<#"+id+" ("+className+") "+((user!=null)?(" ["+user+"]"):"")+">";
	}
}
