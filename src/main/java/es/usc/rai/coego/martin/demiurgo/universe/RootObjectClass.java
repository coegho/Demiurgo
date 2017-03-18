package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import es.usc.rai.coego.martin.demiurgo.exceptions.CannotDestroyClassException;
import es.usc.rai.coego.martin.demiurgo.exceptions.CannotDestroyRootClassException;
import es.usc.rai.coego.martin.demiurgo.json.JsonClass;
import es.usc.rai.coego.martin.demiurgo.json.JsonMethod;
import es.usc.rai.coego.martin.demiurgo.json.JsonVariable;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

/**
 * RootObjectClass represents the special "OBJECT" class, which is the parent of all other
 * classes.
 * @author Martín Coego Pérez
 *
 */
public class RootObjectClass extends DemiurgoClass {
	public RootObjectClass(World world) {
		super("object", "", world); //TODO: this is not the correct code
	}

	@Override
	public DemiurgoClass getParentClass() {
		return this;
	}

	@Override
	public Map<String, DefaultField> getFields() {
		return fields; //Doesn't look in parent class
	}
	
	@Override
	public ValueInterface getField(String fieldName) {
		return fields.get(fieldName).getField(); //Doesn't look in parent class
	}
	
	@Override
	public DefaultField getDefaultField(String fieldName) {
		return fields.get(fieldName); //Doesn't look in parent class
	}

	@Override
	public ClassMethod getMethod(String methodName) {
		return methods.get(methodName); //Doesn't look in parent class
	}
	
	public Map<String, ValueInterface> getStaticFields() {
		return new HashMap<>(staticFields);
	}
	
	@Override
	public JsonClass toJson() {
		JsonClass jc = new JsonClass();
		jc.setCode(getCode());
		jc.setClassName(getClassName());
		List<JsonVariable> f = new ArrayList<>();
		for(Entry<String, DefaultField> e : fields.entrySet()) {
			f.add(new JsonVariable(e.getKey(), e.getValue().getField().getValueAsString(), e.getValue().getField().getTypeName()));
		}
		jc.setFields(f);
		
		List<JsonMethod> m = new ArrayList<>();
		for(Entry<String, ClassMethod> e : getMethods().entrySet()) {
			m.add(e.getValue().toJson(e.getKey()));
		}
		
		m.sort(Comparator.comparing(JsonMethod::getName));
		jc.setMethods(m);
		return jc;
	}
	
	@Override
	public String getNameField() {
		return "v_name";
	}
	
	@Override
	public String getDescriptionField() {
		return "v_description";
	}
	
	@Override
	public String getImageField() {
		return "v_imgurl";
	}
	
	@Override
	public Set<String> getStatusFields() {
		return statusFields;
	}
	
	@Override
	public Set<String> getPublicFields() {
		return publicFields;
	}
	
	@Override
	public Set<String> getVisibleFields() {
		return visibleFields;
	}
	
	@Override
	public Set<String> getVisibleMethods() {
		return visibleMethods;
	}
	
	@Override
	public void destroyClass() throws CannotDestroyClassException {
		//this class shouldn't be destroyed
		throw new CannotDestroyRootClassException();
	}
	
	@Override
	public boolean hasReferencesToClass(DemiurgoClass cl) {
		return false;
	}
}
