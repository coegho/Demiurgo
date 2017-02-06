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
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.json.JsonInventory;
import es.usc.rai.coego.martin.demiurgo.json.JsonMethod;
import es.usc.rai.coego.martin.demiurgo.json.JsonObject;
import es.usc.rai.coego.martin.demiurgo.json.JsonVariable;
import es.usc.rai.coego.martin.demiurgo.json.StatusInventory;
import es.usc.rai.coego.martin.demiurgo.json.StatusObject;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass.DefaultField;
import es.usc.rai.coego.martin.demiurgo.values.InventoryValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class DemiurgoObject {
	protected long id;
	protected transient DemiurgoClass ownClass;
	protected transient DemiurgoLocation location;
	protected Map<String, ValueInterface> fields;
	protected transient User user;

	// Serializable fields
	protected String className;
	protected long loc_id;
	protected String username;

	public DemiurgoObject(DemiurgoClass ownClass, DemiurgoLocation location, Map<String, ValueInterface> fields) {
		this.id = -1;
		this.ownClass = ownClass;
		this.location = location;
		this.fields = fields;
		location.addObject(this);
		location.getWorld().addObject(this);
	}
	
	public DemiurgoObject(DemiurgoClass ownClass, DemiurgoLocation location) {
		this.id = -1;
		this.ownClass = ownClass;
		this.location = location;
		this.fields =  new HashMap<String, ValueInterface>();
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

	public DemiurgoClass getDemiurgoClass() {
		return ownClass;
	}

	public void setUserClass(DemiurgoClass ownClass) {
		this.ownClass = ownClass;
	}

	public DemiurgoLocation getLocation() {
		return location;
	}

	public void setLocation(DemiurgoLocation location) {
		this.location = location;
	}

	public void moveTo(DemiurgoLocation location) throws ObjectInsideItselfException {
		this.location.getWorld().moveTo(this.location, location, this);
	}
	
	public ValueInterface getField(String fieldName) {
		if(fieldName.equalsIgnoreCase("this")) {
			return new ObjectValue(this);
		}
		return fields.get(fieldName.toLowerCase());
	}

	public void setField(String fieldName, ValueInterface value) {
		fields.put(fieldName.toLowerCase(), value);
	}
	
	public void setFields(Map<String, ValueInterface> fields) {
		this.fields = fields;
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
	
	public StatusObject toStatusJson() {
		String name = null;
		String description = null;
		String imgurl = null;
		List<String> visibleFields = new ArrayList<>();
		List<JsonVariable> fields = new ArrayList<>();
		List<StatusInventory> inventories = new ArrayList<>();
		
		//Getting special fields
		for(Entry<String, ValueInterface> e : this.fields.entrySet()) {
			if(e.getKey().equalsIgnoreCase("v_name")) {
				name = e.getValue().getValueAsString();
			}
			else if(e.getKey().equalsIgnoreCase("v_description")) {
				description = e.getValue().getValueAsString();
			}
			else if(e.getKey().equalsIgnoreCase("v_imgurl")) {
				imgurl = e.getValue().getValueAsString();
			}
			else if(e.getKey().equalsIgnoreCase("v_fields") && e.getValue() instanceof ListValue) {
				for(ValueInterface v : ((ListValue)e.getValue()).getValue())
					visibleFields.add(v.getValueAsString().toLowerCase());
			}
		}
		
		if(name == null) {
			name = ownClass.getClassName();
		}
		
		//Getting only visible fields
		for(Entry<String, ValueInterface> e : this.fields.entrySet()) {
			if(visibleFields.contains(e.getKey().toLowerCase())) {
				
				if(e.getValue() instanceof InventoryValue) {
					Inventory inv = (Inventory)((InventoryValue)e.getValue()).getLocation();
					inventories.add(inv.toStatusJson(e.getKey()));
				}
				else {
					fields.add(new JsonVariable(e.getKey(), e.getValue().getValueAsString(), e.getValue().getTypeName()));
				}
			}
		}
		return new StatusObject(name, description, imgurl, fields, inventories);
	}

	public void updateClass() {//TODO: assign default values
		List<String> losing = new ArrayList<String>(fields.keySet());
		for (Entry<String, DefaultField> e : ownClass.getFields().entrySet()) {
			if (fields.containsKey(e.getKey())) { // Already has this variable
				losing.remove(e.getKey());
				if(!(e.getValue().getField() instanceof InventoryValue)) { //Cannot assign inventories
					if (e.getValue().getField().canAssign(fields.get(e.getKey()))) { // Compatible
																			// type
						ValueInterface n = e.getValue().getField().cloneValue(); // new
																		// variable
						try {
							n.assign(fields.get(e.getKey()));
						} catch (ValueCastException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						fields.put(e.getKey(), n);
					} else { // incompatible type, any previous value will be lost
						ownClass.getWorld().getLogger().info("Object #" + id + " update field " + e.getKey()
								+ ", lose previous value: " + fields.get(e.getKey()).getValueAsString());
						fields.put(e.getKey(), e.getValue().getField().cloneValue());
					}
				}
			} else { // put directly
				if(e.getValue().getField() instanceof InventoryValue) {
					InventoryValue v = new InventoryValue(getDemiurgoClass().getWorld().createInventory(this, e.getKey()));
					fields.put(e.getKey(), v);
				}
				else
					fields.put(e.getKey(), e.getValue().getField().cloneValue());
			}
		}
		
		//Removing fields not defined on the new code
		for(String f : losing) {
			ownClass.getWorld().getLogger().info("Object #" + id + " lose field " + f
			+ ", value: " + fields.get(f).getValueAsString());
			if(fields.get(f) instanceof InventoryValue) { //previous inventories must be destroyed
				Inventory inv = (Inventory)((InventoryValue)fields.get(f)).getLocation();
				inv.destroyLocation();
			}
			fields.remove(f);
			
		}
	}
	
	public DemiurgoRoom getRealLocation() {
		return getLocation().getRealLocation();
	}
	
	public boolean isInsideOf(DemiurgoObject another) {
		return getLocation().isInsideOf(another);
	}
	
	/**
	 * Marks this object to be destroyed. All references to this object will
	 * be set to null, and this object will be stored in the
	 * list of destroyed objects to tell the database to delete its tuple. 
	 */
	public void destroyObject(boolean destroyInventories) {
		//evacuate or destroy all objects from inventories
		for(Entry<String, ValueInterface> f : fields.entrySet()) {
			if(f.getValue() instanceof InventoryValue) {
				Inventory inv = (Inventory) ((InventoryValue)f.getValue()).getLocation();
				if(!destroyInventories) { //Destroy all contents
					for(DemiurgoObject o : inv.getObjects()) {
						try {
							o.moveTo(getRealLocation());
						} catch (ObjectInsideItselfException e) {}
					}
				}
				//destroy inventory
				inv.destroyLocation();
			}
		}
	
		//search and clear references
		//user
		if(getUser() != null) {
			getLocation().getWorld().setUserObject(getUser(), null);
		}
		//room variables
		for(DemiurgoRoom r : getLocation().getWorld().getAllRooms()) {
			r.clearObjectReferences(this);
		}
		//object variables
		for(DemiurgoObject o : getLocation().getWorld().getAllObjects()) {
			o.clearObjectReferences(this);
		}
		//room
		getLocation().removeObject(this);
		
		getLocation().getWorld().markToDestroy(this);
		
	}
	
	public void clearObjectReferences(DemiurgoObject obj) {
		for(Entry<String, ValueInterface> e : fields.entrySet()) {
			if((e.getValue() instanceof ObjectValue) && ((ObjectValue)e.getValue()).getObj() == obj) {
				((ObjectValue)e.getValue()).setObj(null);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof DemiurgoObject) && ((DemiurgoObject)obj).getId() == getId();
	}
}
