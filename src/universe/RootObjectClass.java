package universe;

import java.util.Map;

/**
 * RootObjectClass represents the special "OBJECT" class, which is the parent of all other
 * classes.
 * @author Martín Coego Pérez
 *
 */
public class RootObjectClass extends UserDefinedClass {
	public RootObjectClass(World world) {
		super("object", world);
	}

	@Override
	public UserDefinedClass getParentClass() {
		return this;
	}

	@Override
	public Map<String, StoredSymbol> getFields() {
		return fields; //Doesn't look in parent class
	}
	
	@Override
	public StoredSymbol getField(String fieldName) {
		return fields.get(fieldName); //Doesn't look in parent class
	}

	@Override
	public ClassMethod getMethod(String methodName) {
		return methods.get(methodName); //Doesn't look in parent class
	}	
}
