package serializable;

import java.io.Serializable;

public interface SerializableWorldObject extends Serializable {

	public long getId();

	public String getClassName();

	public long getLoc_id();

	public String getUsername();

	public SerializableValue getField(String name);
}
