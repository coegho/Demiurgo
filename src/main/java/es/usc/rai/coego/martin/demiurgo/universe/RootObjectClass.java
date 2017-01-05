package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	public Map<String, ValueInterface> getFields() {
		return fields; //Doesn't look in parent class
	}
	
	@Override
	public ValueInterface getField(String fieldName) {
		return fields.get(fieldName); //Doesn't look in parent class
	}

	@Override
	public ClassMethod getMethod(String methodName) {
		return methods.get(methodName); //Doesn't look in parent class
	}
	
	@Override
	public JsonClass toJson() {
		JsonClass jc = new JsonClass();
		jc.setCode(getCode());
		jc.setClassName(getClassName());
		List<JsonVariable> f = new ArrayList<>();
		for(Entry<String, ValueInterface> e : fields.entrySet()) {
			f.add(new JsonVariable(e.getKey(), e.getValue().getValueAsString(), e.getValue().getTypeName()));
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
}
