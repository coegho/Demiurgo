package serializable;

import java.io.Serializable;
import java.util.Map;

import values.IReturnValue;

public interface SerializableWorldObject extends Serializable {

	public long getId();

	public String getClassName();

	public long getLoc_id();

	public String getUsername();

	public Map<String, IReturnValue> getFields();
}
