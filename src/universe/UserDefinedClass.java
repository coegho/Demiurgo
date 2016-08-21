package universe;

import java.util.HashMap;
import java.util.Map;

import values.IReturnValue;

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
	protected Map<String, IReturnValue> fields;
	protected Map<String, ClassMethod> methods;
	protected ClassMethod constructor;
	protected World world;

	public UserDefinedClass(String className, World world) {
		this.className = className;
		this.fields = new HashMap<>();
		this.methods = new HashMap<>();
		this.world = world;
	}

	public String getClassName() {
		return className;
	}

	public World getWorld() {
		return world;
	}
	
	public Map<String, IReturnValue> getRealFields() {
		return fields;
	}
	
	public Map<String, IReturnValue> getFields() {
		Map<String, IReturnValue> map = new HashMap<>();
		map.putAll(parentClass.getFields());
		map.putAll(fields);
		return map;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void addField(String fieldName, IReturnValue defaultValue) {
		fields.put(fieldName, defaultValue);
	}

	public IReturnValue getField(String fieldName) {
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
	
	public void setConstructor(ClassMethod constructor) {
		this.constructor = constructor;
	}
	
	public ClassMethod getConstructor() {
		return constructor;
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
		UserDefinedClass p = this;
		while(p != world.getRootClass()) {
			if(p == tryParent) {
				return true;
			}
			p = p.getParentClass();
		}
		return false;
	}
}
