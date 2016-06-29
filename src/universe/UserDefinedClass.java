package universe;

import java.util.HashMap;
import java.util.Map;

import plataformarol.IReturnValue;

public class UserDefinedClass {
	protected String className;
	protected Map<String, IReturnValue> fields;
	
	public String getClassName() {
		return className;
	}
	
	public Map<String, IReturnValue> getDefaultVariables() {
		return fields;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public UserDefinedClass(String className) {
		this.className = className;
		this.fields = new HashMap<>();
	}
	
	public UserDefinedClass(String className, Map <String, IReturnValue> defaultVariables) {
		this.className = className;
		this.fields = defaultVariables;
	}
	
	public void addField(String fieldName, IReturnValue defaultValue) {
		fields.put(fieldName, defaultValue);
	}
	
	public IReturnValue getField(String fieldName) {
		return fields.get(fieldName);
	}
}
