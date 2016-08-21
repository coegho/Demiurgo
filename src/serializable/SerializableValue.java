package serializable;

import java.io.Serializable;

public interface SerializableValue extends Serializable {
	public String[] getValueCodes();
	public ReturnValueTypes getType();
}
