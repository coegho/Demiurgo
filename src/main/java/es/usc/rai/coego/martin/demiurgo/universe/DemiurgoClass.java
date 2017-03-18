package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;

import es.usc.rai.coego.martin.demiurgo.exceptions.CannotDestroyClassException;
import es.usc.rai.coego.martin.demiurgo.exceptions.TagAlreadySetException;
import es.usc.rai.coego.martin.demiurgo.json.JsonClass;
import es.usc.rai.coego.martin.demiurgo.json.JsonMethod;
import es.usc.rai.coego.martin.demiurgo.json.JsonVariable;
import es.usc.rai.coego.martin.demiurgo.values.ClassTyped;
import es.usc.rai.coego.martin.demiurgo.values.InventoryValue;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

/**
 * Represents a class in the world defined by the user. These classes will be
 * used to create new objects.
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class DemiurgoClass implements Comparable<DemiurgoClass> {
	protected String className;
	protected DemiurgoClass parentClass;
	protected Map<String, DefaultField> fields;
	protected Map<String, ValueInterface> staticFields;
	protected Map<String, ClassMethod> methods;
	protected ClassMethod constructor;
	protected World world;
	protected String code;
	
	//special fields for views
	protected String v_image, v_name, v_description;
	protected Set<String> publicFields;
	protected Set<String> statusFields;
	protected Set<String> visibleFields;
	
	protected Set<String> visibleMethods;

	public DemiurgoClass(String className, String code, World world) {
		this.className = className;
		this.fields = new HashMap<>();
		this.staticFields = new HashMap<>();
		this.methods = new HashMap<>();
		this.world = world;
		this.code = code;
		this.publicFields = new HashSet<>();
		this.statusFields = new HashSet<>();
		this.visibleFields = new HashSet<>();
		this.visibleMethods = new HashSet<>();
	}

	public DemiurgoClass(String classname, String code) {
		this.className = classname;
		this.fields = new HashMap<>();
		this.staticFields = new HashMap<>();
		this.methods = new HashMap<>();
		this.code = code;
		this.publicFields = new HashSet<>();
		this.statusFields = new HashSet<>();
		this.visibleFields = new HashSet<>();
		this.visibleMethods = new HashSet<>();
	}

	public String getClassName() {
		return className;
	}

	public World getWorld() {
		return world;
	}

	public Map<String, DefaultField> getRealFields() {
		return fields;
	}

	public Map<String, DefaultField> getFields() {
		Map<String, DefaultField> map = new HashMap<>();
		map.putAll(parentClass.getFields());
		map.putAll(fields);
		return map;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void addField(String fieldName, ValueInterface defaultValue, ParseTree initialAssign) {
		fields.put(fieldName, new DefaultField(defaultValue, initialAssign));
	}
	
	public void addStaticField(String varName, ValueInterface value) throws StaticInventoryException {
		if(value instanceof InventoryValue) {
			throw new StaticInventoryException(0, 0, 0, varName);
		}
		else {

			this.staticFields.put(varName, value);
		}
	}
	
	public Map<String, ValueInterface> getStaticFields() {
		Map<String, ValueInterface> statics = getParentClass().getStaticFields();
		statics.putAll(staticFields);
		return statics;
	}
	
	public ValueInterface getStaticField(String name) {
		return getStaticFields().get(name);
	}
	
	public DefaultField getDefaultField(String fieldName) {
		if (fields.containsKey(fieldName))
			return fields.get(fieldName);
		else
			return parentClass.getDefaultField(fieldName);
	}

	public ValueInterface getField(String fieldName) {
		if (fields.containsKey(fieldName))
			return fields.get(fieldName).getField();
		else
			return parentClass.getField(fieldName);
	}

	public void addMethod(String methodName, ClassMethod method) {
		methods.put(methodName, method);
	}

	public ClassMethod getMethod(String methodName) {
		if (methods.containsKey(methodName))
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

	public DemiurgoClass getParentClass() {
		return parentClass;
	}

	public void setParentClass(DemiurgoClass parentClass) {
		this.parentClass = parentClass;
	}

	public boolean inheritFrom(DemiurgoClass tryParent) {
		if (tryParent == world.getRootClass()) {
			return true;
		}
		DemiurgoClass p = this;
		while (p != world.getRootClass()) {
			if (p == tryParent) {
				return true;
			}
			p = p.getParentClass();
		}
		return false;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void rebuild(World world) {
		this.world = world;
	}

	public JsonClass toJson() {
		JsonClass jc = new JsonClass();
		jc.setCode(getCode());
		jc.setClassName(getClassName());
		jc.setParent(getParentClass().toJson());
		List<JsonVariable> f = new ArrayList<>();
		for (Entry<String, DefaultField> e : getParentClass().getFields().entrySet()) {
			f.add(new JsonVariable(e.getKey(), e.getValue().getField().getValueAsString(),
					e.getValue().getField().getTypeName()));
		}
		for (Entry<String, DefaultField> e : fields.entrySet()) {
			f.removeIf(v -> v.getName().equalsIgnoreCase(e.getKey()));
			f.add(new JsonVariable(e.getKey(), e.getValue().getField().getValueAsString(),
					e.getValue().getField().getTypeName()));
		}
		f.sort(Comparator.comparing(JsonVariable::getName));
		jc.setFields(f);

		List<JsonMethod> m = new ArrayList<>();
		for (Entry<String, ClassMethod> e : getMethods().entrySet()) {
			m.add(e.getValue().toJson(e.getKey()));
		}

		m.sort(Comparator.comparing(JsonMethod::getName));
		jc.setMethods(m);
		return jc;
	}

	/**
	 * Modify the current class' fields and methods to the new class' ones.
	 * 
	 * @param newClass
	 */
	public void modifyTo(DemiurgoClass newClass) {
		parentClass = newClass.parentClass;
		fields = newClass.fields;
		staticFields = newClass.staticFields;
		methods = newClass.methods;
		constructor = newClass.constructor;
		code = newClass.code;
		
		v_name = newClass.v_name;
		v_description = newClass.v_description;
		v_image = newClass.v_image;
		publicFields = newClass.publicFields;
		statusFields = newClass.statusFields;
		visibleFields = newClass.visibleFields;

		visibleMethods = newClass.visibleMethods;

		// update references
		for (Entry<String, DefaultField> e : fields.entrySet()) {
			if (e.getValue().getField() instanceof ObjectValue) {
				ObjectValue ov = (ObjectValue) e.getValue().getField();
				if (ov.getClassType().getClassName().equalsIgnoreCase(this.getClassName())) {
					ov.setClassType(this);
				}
			}
		}
		for (Entry<String, ClassMethod> e : methods.entrySet()) {
			for (ValueInterface a : e.getValue().args.values()) {
				if (a instanceof ObjectValue
						&& ((ObjectValue) a).getClassType().getClassName().equalsIgnoreCase(this.getClassName())) {
					((ObjectValue) a).setClassType(this);
				}
			}
		}

		if (constructor != null)
			for (ValueInterface a : constructor.getArgsValues()) {
				if (a instanceof ObjectValue
						&& ((ObjectValue) a).getClassType().getClassName().equalsIgnoreCase(this.getClassName())) {
					((ObjectValue) a).setClassType(this);
				}
			}
	}

	public Map<String, ClassMethod> getMethods() {
		Map<String, ClassMethod> methods = new HashMap<String, ClassMethod>();
		if (!(this instanceof RootObjectClass)) {
			methods.putAll(this.getParentClass().getMethods());
		}
		methods.putAll(this.methods);
		return methods;
	}

	@Override
	public int compareTo(DemiurgoClass another) {
		return getClassName().compareTo(another.getClassName());
	}

	@Override
	public boolean equals(Object another) {
		return (another instanceof DemiurgoClass
				&& ((DemiurgoClass) another).getClassName().equalsIgnoreCase(getClassName()));
	}

	public void destroyClass() throws CannotDestroyClassException {
		// checking for references
		for (DemiurgoClass cl : getWorld().getClasses()) {
			if (cl.hasReferencesToClass(this)) {
				throw new CannotDestroyClassException(getClassName());
			}
		}

		for (DemiurgoRoom r : getWorld().getAllRooms()) {
			r.clearClassReferences(this);
		}

		List<DemiurgoObject> l = getWorld().getAllObjects().stream()
				.filter(o -> o.getClassName().equalsIgnoreCase(getClassName())).collect(Collectors.toList());
		for (DemiurgoObject o : l) {
			o.destroyObject(false);
		}
		getWorld().markToDestroy(this);
	}

	public boolean hasReferencesToClass(DemiurgoClass cl) {
		if (getParentClass().equals(cl)) {
			return true;
		}

		// checking fields
		for (Entry<String, DefaultField> e : getFields().entrySet()) {
			if (e.getValue().getField() instanceof ClassTyped
					&& ((ClassTyped) e.getValue().getField()).getClassType() != null
					&& ((ClassTyped) e.getValue().getField()).getClassType().equals(cl)) {
				return true;
			}
		}

		return false;
	}

	
	
	public String getNameField() {
		if(v_name != null)
			return v_name;
		else
			return getParentClass().getNameField();
	}
	
	public String getDescriptionField() {
		if(v_description != null)
			return v_description;
		else
			return getParentClass().getDescriptionField();
	}
	
	public String getImageField() {
		if(v_image != null)
			return v_image;
		else
			return getParentClass().getImageField();
	}

	public static ClassTags getValidTag(String tag) {
		return ClassTags.valueOf(tag.toUpperCase());
	}
	
	public Set<String> getPublicFields() {
		Set<String> p = new HashSet<>(); 
		p.addAll(getParentClass().getPublicFields());
		p.addAll(publicFields);
		return p;
	}
	
	public Set<String> getStatusFields() {
		Set<String> p = new HashSet<>(); 
		p.addAll(getParentClass().getStatusFields());
		p.addAll(statusFields);
		return p;
	}
	
	public Set<String> getVisibleFields() {
		Set<String> p = new HashSet<>(); 
		p.addAll(getParentClass().getVisibleFields());
		p.addAll(visibleFields);
		return p;
	}
	
	public Set<String> getVisibleMethods() {
		Set<String> p = new HashSet<>(); 
		p.addAll(getParentClass().getVisibleMethods());
		p.addAll(visibleMethods);
		return p;
	}

	public void tagField(ClassTags tag, String varName) throws TagAlreadySetException {
		switch(tag) {
		case DESCRIPTION:
			if(v_description != null)
				throw new TagAlreadySetException(0, 0, 0, tag.toString());
			v_description = varName;
			break;
		case IMAGE:
			if(v_image != null)
				throw new TagAlreadySetException(0, 0, 0, tag.toString());
			v_image = varName;
			break;
		case NAME:
			if(v_name != null)
				throw new TagAlreadySetException(0, 0, 0, tag.toString());
			v_name = varName;
			break;
		case PUBLIC:
			publicFields.add(varName);
			break;
		case STATUS:
			statusFields.add(varName);
			break;
		case VISIBLE:
			visibleFields.add(varName);
			break;
		}
	}
	
	public void tagMethod(ClassTags tag, String mName) throws TagAlreadySetException {
		//TODO: image, name and description from method
		//TODO: good exception
		switch(tag) {
		case DESCRIPTION:
			throw new TagAlreadySetException(0, 0, 0, tag.toString());
		case IMAGE:
			throw new TagAlreadySetException(0, 0, 0, tag.toString());
		case NAME:
			throw new TagAlreadySetException(0, 0, 0, tag.toString());
		case PUBLIC:
			throw new TagAlreadySetException(0, 0, 0, tag.toString());
		case STATUS:
			throw new TagAlreadySetException(0, 0, 0, tag.toString());
		case VISIBLE:
			visibleMethods.add(mName);
			break;
		}
	}
}