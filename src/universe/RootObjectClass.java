package universe;

import values.IReturnValue;

/**
 * RootObjectClass represents the special "OBJECT" class, which is the parent of all other
 * classes.
 * @author Martín Coego Pérez
 *
 */
public class RootObjectClass extends UserDefinedClass {
	public RootObjectClass() {
		super("object", null);
	}

	@Override
	public void setClassName(String className) { }

	@Override
	public void addField(String fieldName, IReturnValue defaultValue) { }

	@Override
	public void addMethod(String methodName, ClassMethod method) { }
	
	@Override
	public void setParentClass(UserDefinedClass parentClass) { }

	@Override
	public UserDefinedClass getParentClass() {
		return this;
	}

	@Override
	public IReturnValue getField(String fieldName) {
		return fields.get(fieldName); //Doesn't look in parent class
	}

	@Override
	public ClassMethod getMethod(String methodName) {
		return methods.get(methodName);
	}	
}
