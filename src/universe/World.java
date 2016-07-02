package universe;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a world into the system.
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class World {
	protected Map<String, UserDefinedClass> classes;
	protected Map<Integer, WorldObject> objects;
	protected Map<String, WorldRoom> rooms;
	protected UserDefinedClass rootClass;
	
	public UserDefinedClass getClassFromName(String className) {
		return classes.get(className);
	}
	
	public void addClass(String className, UserDefinedClass newClass) {
		classes.put(className, newClass);
	}
	
	public World() {
		classes = new HashMap<>();
		objects = new HashMap<>();
		rooms = new HashMap<>();
		rootClass = new RootObjectClass();
		classes.put("object", rootClass);
	}
	
	public UserDefinedClass getRootClass() {
		return rootClass;
	}
	
	public void setRootClass(UserDefinedClass rootClass) {
		this.rootClass = rootClass;
	}
}
