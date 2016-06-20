package universe;

import java.util.HashMap;
import java.util.Map;

import plataformarol.IReturnValue;

public class UserDefinedClass {
	protected String className;
	protected Map<String, IReturnValue> defaultVariables;
	
	public String getClassName() {
		return className;
	}
	
	public Map<String, IReturnValue> getDefaultVariables() {
		return defaultVariables;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public UserDefinedClass(String className) {
		this.className = className;
		this.defaultVariables = new HashMap<>();
	}
	
	public UserDefinedClass(String className, Map <String, IReturnValue> defaultVariables) {
		this.className = className;
		this.defaultVariables = defaultVariables;
	}
}
