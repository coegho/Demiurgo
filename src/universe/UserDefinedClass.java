package universe;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a class in the world defined by the user. These classes will be used to create
 * new objects.
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class UserDefinedClass {
	protected String className;
	protected UserDefinedClass parentClass;
	protected Map<String, StoredSymbol> fields;
	protected Map<String, ClassMethod> methods;
	protected World world;

	public UserDefinedClass(String className, UserDefinedClass parentClass, World world) {
		this.className = className;
		this.fields = new HashMap<>();
		this.methods = new HashMap<>();
		this.parentClass = parentClass;
		this.world = world;
	}

	public String getClassName() {
		return className;
	}

	public Map<String, StoredSymbol> getRealFields() {
		return fields;
	}
	
	public Map<String, StoredSymbol> getFields() {
		Map<String, StoredSymbol> map = new HashMap<>();
		map.putAll(parentClass.getFields());
		map.putAll(fields);
		return map;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void addField(String fieldName, StoredSymbol defaultValue) {
		fields.put(fieldName, defaultValue);
	}

	public StoredSymbol getField(String fieldName) {
		if(fields.containsKey(fieldName))
			return fields.get(fieldName);
		else
			return parentClass.getField(fieldName);
	}

	public void addMethod(String methodName, ClassMethod method) {
		methods.put(methodName, method);
	}

	public ClassMethod getMethod(String methodName) {
		if(methods.containsKey(methodName))
			return methods.get(methodName);
		else
			return parentClass.getMethod(methodName);
	}

	public UserDefinedClass getParentClass() {
		return parentClass;
	}

	public void setParentClass(UserDefinedClass parentClass) {
		this.parentClass = parentClass;
	}
	
	public boolean inheritFrom(UserDefinedClass tryParent) {
		if(tryParent == world.getRootClass()) {
			return true;
		}
		UserDefinedClass p = parentClass;
		while(p != world.getRootClass()) {
			if(p == tryParent) {
				return true;
			}
			p = p.getParentClass();
		}
		return false;
	}
}
