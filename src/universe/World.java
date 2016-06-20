package universe;

import java.util.HashMap;
import java.util.Map;

public class World {
	protected Map<String, UserDefinedClass> classes;
	protected Map<Integer, WorldObject> objects;
	protected Map<String, WorldRoom> rooms;
	
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
	}
}
