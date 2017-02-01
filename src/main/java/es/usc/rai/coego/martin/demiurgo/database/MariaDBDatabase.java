package es.usc.rai.coego.martin.demiurgo.database;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import es.usc.rai.coego.martin.demiurgo.universe.Action;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserRole;
import es.usc.rai.coego.martin.demiurgo.universe.Witness;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.Inventory;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoLocation;

public class MariaDBDatabase implements DatabaseInterface {

	// TODO: table prefix
	private Connection con;

	@Override
	public boolean createConnection(String url, String username, String pass) {
		if (existsDriver()) {
			try {
				con = DriverManager.getConnection(url, username, pass);
				return true;
			} catch (SQLException e) {
				throw new RuntimeException(e); //TODO
			}
		}
		return false;
	}

	public boolean existsDriver() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			return true;
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public void stopConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void beginTransaction() {
		if(existsActiveConnection())
			try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public void commitTransaction() {
		if(existsActiveConnection())
			try {
				con.commit();
				con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public void rollbackTransaction() {
		if(existsActiveConnection())
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public boolean existsActiveConnection() {
		return con != null;
	}

	@Override
	public boolean login(String name, String password) {
		try {
			PreparedStatement stm = con.prepareStatement("SELECT username FROM users WHERE username LIKE ? AND passwd=?");
			stm.setString(1, name);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return false; // TODO throw exception
		}
	}
	
	@Override
	public User register(String name, String password, String mail) {
		try {
			PreparedStatement stm = con.prepareStatement("INSERT users (username, passwd, mail) VALUES (?, ?, ?)"/*, Statement.RETURN_GENERATED_KEYS*/);
			stm.setString(1, name);
			stm.setString(2, password);
			stm.setString(3, mail);
			stm.executeUpdate();
			
			//ResultSet rs = stm.getGeneratedKeys();
			return new User(name, UserRole.USER);
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}
	
	@Override
	public boolean changePassword(String name, String oldPassword, String newPassword) {
		try {
			PreparedStatement stm = con.prepareStatement("UPDATE users SET passwd = ? WHERE (username = ? AND passwd = ?)");
			stm.setString(1, newPassword);
			stm.setString(2, name);
			stm.setString(3, oldPassword);
			int count = stm.executeUpdate();
			
			return count > 0;
			
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return false; // TODO throw exception
		}
	}

	@Override
	public void writeUser(User user) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT users (username, role, obj_id, decision) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE obj_id=VALUES(obj_id), role=VALUES(role), decision=VALUES(decision)");
			stm.setString(1, user.getUsername());
			stm.setString(2, user.getRole().toString());
			if (user.getObj() != null)
				stm.setLong(3, user.getObjId());
			else
				stm.setNull(3, java.sql.Types.BIGINT);
			stm.setString(4, user.getDecision());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void writeDemiurgoObject(DemiurgoObject obj) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT objects (obj_id, classname, room, obj_value) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE classname=VALUES(classname), room=VALUES(room), obj_value=VALUES(obj_value)");
			stm.setLong(1, obj.getId());
			stm.setString(2, obj.getClassName());
			stm.setLong(3, obj.getLocId());
			stm.setObject(4, obj.getFields());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteDemiurgoObject(DemiurgoObject obj) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"DELETE FROM objects WHERE obj_id = ?");
			stm.setLong(1, obj.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void writeDemiurgoClass(DemiurgoClass cl) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT classes (classname, code) VALUES (?, ?) ON DUPLICATE KEY UPDATE code=VALUES(code)");
			stm.setString(1, cl.getClassName());
			stm.setString(2, cl.getCode());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	public void writeLocationId(DemiurgoLocation location) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT locations (id) VALUES (?) ON DUPLICATE KEY UPDATE id=VALUES(id)");
			stm.setLong(1, location.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void writeWorldRoom(DemiurgoRoom room) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT rooms (id, long_path, room_value, prenarration) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE long_path=VALUES(long_path), room_value=VALUES(room_value), prenarration=VALUES(prenarration)");
			stm.setLong(1, room.getId());
			stm.setString(2, room.getLongPath());
			stm.setObject(3, room.getVariables());
			stm.setString(4, room.getPrenarration());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void writeInventory(Inventory inv) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT inventories (id, varname, obj_id) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE obj_id=VALUES(obj_id), varname=VALUES(varname)");
			stm.setLong(1, inv.getId());
			stm.setLong(3, inv.getContainer().getId());
			stm.setString(2, inv.getVarName());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void deleteLocation(DemiurgoLocation loc) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"DELETE FROM locations WHERE id = ?");
			stm.setLong(1, loc.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void deleteInventory(Inventory inv) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"DELETE FROM inventories WHERE id = ?");
			stm.setLong(1, inv.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void writeAction(Action action) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT actions (id, room, narration, publish_date, published) VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE room=VALUES(room), narration=VALUES(narration), publish_date=VALUES(publish_date), published=VALUES(published)");
			stm.setLong(1, action.getId());
			stm.setLong(2, action.getRoom().getId());
			stm.setString(3, action.getNarration());
			stm.setTimestamp(4, new java.sql.Timestamp(action.getDate().getTime()));
			stm.setBoolean(5, action.isPublished());
			stm.executeUpdate();

			PreparedStatement std = con.prepareStatement("DELETE FROM witness_action WHERE action = ?");
			std.setLong(1, action.getId());
			std.executeUpdate();
			for (Witness w : action.getWitnesses()) {
				writeWitness(action, w);
			}
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	private void writeWitness(Action action, Witness w) {
		try {
			PreparedStatement stm = con.prepareStatement("INSERT witness_action (action, username, decision) VALUES (?, ?, ?)");
			stm.setLong(1, action.getId());
			stm.setString(2, w.getUser().getUsername());
			stm.setString(3, w.getDecision());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public List<User> readAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		try {
			PreparedStatement stm = con
					.prepareStatement("SELECT username,IFNULL(obj_id,-1) AS obj_id, role, decision FROM users");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getString("username"), UserRole.valueOf(rs.getString("role")),
						rs.getLong("obj_id"), rs.getString("decision")));
			}

			return users;
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemiurgoObject> readAllObjects() {
		ArrayList<DemiurgoObject> objs = new ArrayList<>();
		try {
			PreparedStatement stm = con.prepareStatement("SELECT obj_id, classname, room, obj_value FROM objects");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("obj_id");
				String classname = rs.getString("classname");
				long loc_id = rs.getLong("room");
				byte[] buf = rs.getBytes("obj_value");
				ObjectInputStream objectIn = null;
				if (buf != null)
					objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

				Map<String, ValueInterface> variables = (Map<String, ValueInterface>) objectIn.readObject();
				DemiurgoObject obj = new DemiurgoObject(id, classname, loc_id, variables);
				objs.add(obj);
			}

			return objs;
		} catch (SQLException | IOException | ClassNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}
	
	@Override
	public List<DemiurgoClass> readAllClasses() {
		ArrayList<DemiurgoClass> classes = new ArrayList<>();
		try {
			PreparedStatement stm = con.prepareStatement("SELECT classname, code FROM classes");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String classname = rs.getString("classname");
				String code = rs.getString("code");
				DemiurgoClass dclass = new DemiurgoClass(classname, code);
				classes.add(dclass);
			}

			return classes;
		} catch (SQLException  e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemiurgoRoom> readAllRooms() {
		ArrayList<DemiurgoRoom> rooms = new ArrayList<>();
		try {
			PreparedStatement stm = con.prepareStatement("SELECT id,long_path,room_value, prenarration FROM rooms");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String path = rs.getString("long_path");
				byte[] buf = rs.getBytes("room_value");
				ObjectInputStream objectIn = null;
				if (buf != null)
					objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
				String prenarration = rs.getString("prenarration");
				
				Map<String, ValueInterface> variables = (Map<String, ValueInterface>) objectIn.readObject();
				rooms.add(new DemiurgoRoom(id, path, variables, prenarration));
			}

			return rooms;
		} catch (SQLException | IOException | ClassNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}
	
	@Override
	public List<Inventory> readAllInventories() {
		ArrayList<Inventory> invs = new ArrayList<>();
		try {
			PreparedStatement stm = con.prepareStatement("SELECT id,varname, obj_id FROM inventories");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				long obj_id = rs.getLong("obj_id");
				String varName = rs.getString("varname");
				
				invs.add(new Inventory(id, varName, obj_id));
			}

			return invs;
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public List<Action> readActionsFromRoom(DemiurgoRoom room) {
		List<Action> actions = new ArrayList<>();
		try {
			PreparedStatement stm = con
					.prepareStatement("SELECT id, narration, publish_date, published FROM actions WHERE room = ? ORDER BY publish_date");
			PreparedStatement wtns = con.prepareStatement("SELECT username, decision FROM witness_action WHERE action = ?");
			stm.setLong(1, room.getId());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				// Extracting action data
				long id = rs.getLong("id");
				String narration = rs.getString("narration");
				Date date = rs.getDate("publish_date");
				boolean published = rs.getBoolean("published");

				// Looking for witnesses
				wtns.setLong(1, id);
				ResultSet rsw = wtns.executeQuery();
				List<Witness> witnesses = new ArrayList<>();
				while (rsw.next()) {
					User u = room.getWorld().getUser(rsw.getString("username"));
					witnesses.add(new Witness(u, rsw.getString("decision")));
				}
				actions.add(new Action(id, room, narration, witnesses, date, published));
			}
			return actions;

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public long[] readCurrentIDs() {
		long[] ids = new long[3];
		try {
			PreparedStatement stm = con.prepareStatement("SELECT obj,room,action FROM current_ids");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				ids[0] = rs.getLong("obj");
				ids[1] = rs.getLong("room");
				ids[2] = rs.getLong("action");
			}

			return ids;
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public void setCurrentIDs(long objId, long roomId, long actionId) {
		try {
			PreparedStatement stm = con.prepareStatement("UPDATE current_ids SET obj=?,room=?, action=?");
			stm.setLong(1, objId);
			stm.setLong(2, roomId);
			stm.setLong(3, actionId);
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteClass(DemiurgoClass cl) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"DELETE FROM classes WHERE classname = ?");
			stm.setString(1, cl.getClassName());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteRoom(DemiurgoRoom room) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"DELETE FROM rooms WHERE id = ?");
			stm.setLong(1, room.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
}
