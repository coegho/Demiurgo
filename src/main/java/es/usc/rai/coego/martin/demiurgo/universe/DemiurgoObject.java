package es.usc.rai.coego.martin.demiurgo.universe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import es.usc.rai.coego.martin.demiurgo.exceptions.ObjectInsideItselfException;
import es.usc.rai.coego.martin.demiurgo.json.JsonInventory;
import es.usc.rai.coego.martin.demiurgo.json.JsonMethod;
import es.usc.rai.coego.martin.demiurgo.json.JsonObject;
import es.usc.rai.coego.martin.demiurgo.json.JsonVariable;
import es.usc.rai.coego.martin.demiurgo.values.InventoryValue;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class DemiurgoObject {
	protected long id;
	protected transient DemiurgoClass ownClass;
	protected transient WorldLocation location;
	protected Map<String, ValueInterface> fields;
	protected transient User user;

	// Serializable fields
	protected String className;
	protected long loc_id;
	protected String username;

	public DemiurgoObject(DemiurgoClass ownClass, WorldLocation location) {
		this.id = -1;
		this.ownClass = ownClass;
		this.location = location;
		this.fields = new HashMap<>();
		for (Entry<String, ValueInterface> var : ownClass.getFields().entrySet()) {
			if(var.getValue() instanceof InventoryValue) {
				Inventory inv = ownClass.getWorld().createInventory(this, var.getKey());
				fields.put(var.getKey(), new InventoryValue(inv));
			}
			else {
				fields.put(var.getKey(), var.getValue().cloneValue());
			}
		}
		ObjectValue v = new ObjectValue(this);
		v.setWritable(false);
		fields.put("this", v);
		location.addObject(this);
		location.getWorld().addObject(this);
	}

	/**
	 * This constructor requires a posterior call to the method 'rebuild'.
	 * 
	 * @param id
	 *            Object's ID.
	 * @param classname
	 *            Name of the object's class.
	 * @param loc_id
	 *            ID of the object's location.
	 * @param fields
	 *            Object's fields.
	 */
	public DemiurgoObject(long id, String classname, long loc_id, Map<String, ValueInterface> fields) {
		this.id = id;
		this.className = classname;
		this.loc_id = loc_id;
		this.fields = fields;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DemiurgoClass getUserClass() {
		return ownClass;
	}

	public void setUserClass(DemiurgoClass ownClass) {
		this.ownClass = ownClass;
	}

	public WorldLocation getLocation() {
		return location;
	}

	public void setLocation(WorldLocation location) {
		this.location = location;
	}

	public void moveTo(WorldLocation location) throws ObjectInsideItselfException {
		this.location.getWorld().moveTo(this.location, location, this);
	}

	public ValueInterface getField(String fieldName) {
		return fields.get(fieldName);
	}

	public void setField(String fieldName, ValueInterface value) {
		fields.put(fieldName, value);
	}

	public Set<String> getAllFieldNames() {
		return fields.keySet();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getClassName() {
		return ownClass.getClassName();
	}

	public long getLocId() {
		return location.getId();
	}

	public String getUsername() {
		if (user != null) {
			return user.getUsername();
		}
		return null;
	}

	public Map<String, ValueInterface> getFields() {
		Map<String, ValueInterface> retFields = new HashMap<>();
		for (Entry<String, ValueInterface> e : fields.entrySet()) {
			if (!e.getKey().equals("this")) {
				retFields.put(e.getKey(), e.getValue());
			}
		}
		return retFields;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeLong(getId());
		out.writeObject(getClassName());
		out.writeLong(getLocId());
		out.writeObject(getUsername());
		out.writeObject(getFields());
	}

	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		id = in.readLong();
		className = (String) in.readObject();
		loc_id = in.readLong();
		username = (String) in.readObject();
		fields = ((Map<String, ValueInterface>) in.readObject());
	}

	public void rebuild(World world) {
		ownClass = world.getClassFromName(className);
		location = world.getLocation(loc_id);
		location.addObject(this);
		user = world.getUser(username);
		for (ValueInterface v : fields.values()) {
			v.rebuild(world);
		}
	}

	public JsonObject toJson() {
		List<JsonVariable> fields = new ArrayList<>();
		List<JsonInventory> inventories = new ArrayList<>();
		for (Entry<String, ValueInterface> v : getFields().entrySet()) {
			fields.add(new JsonVariable(v.getKey(), v.getValue().getValueAsString(), v.getValue().getTypeName()));
			if(v.getValue() instanceof InventoryValue) {
				Inventory inv = (Inventory)((InventoryValue)v.getValue()).getLocation();
				inventories.add(inv.toJson(v.getKey()));
			}
		}
		fields.sort(Comparator.comparing(JsonVariable::getName));
		
		List<JsonMethod> methods = new ArrayList<>();
		
		for(Entry<String, ClassMethod> m : ownClass.getMethods().entrySet()) {
			methods.add(m.getValue().toJson(m.getKey()));
		}
		methods.sort(Comparator.comparing(JsonMethod::getName));
		
		return new JsonObject(getId(), getClassName(), getLocId(), fields, methods, inventories);
	}

	public void updateClass() {
		List<String> losing = new ArrayList<String>(fields.keySet());
		for (Entry<String, ValueInterface> e : ownClass.getFields().entrySet()) {
			if (fields.containsKey(e.getKey())) { // Already has this variable
				losing.remove(e.getKey());
				if (e.getValue().canAssign(fields.get(e.getKey()))) { // Compatible
																		// type
					ValueInterface n = e.getValue().cloneValue(); // new
																	// variable
					n.assign(fields.get(e.getKey()));
					fields.put(e.getKey(), n);
				} else { // incompatible type, any previous value will be lost
					ownClass.getWorld().getLogger().info("Object #" + id + " update field " + e.getKey()
							+ ", lose previous value: " + fields.get(e.getKey()).getValueAsString());
					fields.put(e.getKey(), e.getValue().cloneValue());
				}
			} else { // put directly
				if(e.getValue() instanceof InventoryValue) {
					InventoryValue v = new InventoryValue(getUserClass().getWorld().createInventory(this, e.getKey()));
					fields.put(e.getKey(), v);
				}
				else
					fields.put(e.getKey(), e.getValue().cloneValue());
			}
		}
		
		//Removing fields not defined on the new code
		for(String f : losing) {
			ownClass.getWorld().getLogger().info("Object #" + id + " lose field " + f
			+ ", value: " + fields.get(f).getValueAsString());
			fields.remove(f);
		}
	}
	
	public DemiurgoRoom getRealLocation() {
		return getLocation().getRealLocation();
	}
	
	public boolean isInsideOf(DemiurgoObject another) {
		return getLocation().isInsideOf(another);
	}
}
