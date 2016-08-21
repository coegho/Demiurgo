package serializable;

import java.io.Serializable;
import java.util.Map;

import values.IReturnValue;

public interface SerializableWorldRoom extends Serializable {

	public long getId();

	public String getLongPath();

	public Map<String, IReturnValue> getVariables();
}