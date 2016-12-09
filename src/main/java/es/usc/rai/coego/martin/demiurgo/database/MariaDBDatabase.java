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
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserRole;
import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class MariaDBDatabase implements DatabaseInterface {

	// TODO: table prefix
	private Connection con;

	@Override
	public boolean createConnection(String database, String username, String pass) {
		if (existsDriver()) {
			try {
				// TODO: config
				con = DriverManager.getConnection("jdbc:mariadb://localhost/" + database, username, pass);
				return true;
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());// TODO: send a good
															// error
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
	public boolean existsActiveConnection() {
		return con != null;
	}

	@Override
	public boolean login(String name, String password) {
		try {
			PreparedStatement stm = con.prepareStatement("SELECT username FROM users WHERE username=? AND passwd=?");
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
	public void writeWorldObject(WorldObject obj) {
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
	public void writeWorldRoom(WorldRoom room) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT rooms (id, long_path, room_value) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE long_path=VALUES(long_path), room_value=VALUES(room_value)");
			stm.setLong(1, room.getId());
			stm.setString(2, room.getLongPath());
			stm.setObject(3, room.getVariables());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void writeAction(Action action) {
		try {
			PreparedStatement stm = con.prepareStatement(
					"INSERT actions (id, room, code, narration, publish_date, status) VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE room=VALUES(room), code=VALUES(code), narration=VALUES(narration), publish_date=VALUES(publish_date), status=VALUES(status)");
			stm.setLong(1, action.getId());
			stm.setLong(2, action.getRoom().getId());
			stm.setString(3, action.getCode());
			stm.setString(4, action.getNarration());
			stm.setTimestamp(5, new java.sql.Timestamp(action.getDate().getTime()));
			stm.setString(6, action.getStatus().name());
			stm.executeUpdate();

			PreparedStatement std = con.prepareStatement("DELETE FROM witness_action WHERE action = ?");
			std.setLong(1, action.getId());
			std.executeUpdate();
			for (User w : action.getWitnesses()) {
				writeWitness(action, w);
			}
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	private void writeWitness(Action action, User witness) {
		try {
			PreparedStatement stm = con.prepareStatement("INSERT witness_action (action, username) VALUES (?, ?)");
			stm.setLong(1, action.getId());
			stm.setString(2, witness.getUsername());
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
	public List<WorldObject> readAllObjects() {
		ArrayList<WorldObject> objs = new ArrayList<>();
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
				WorldObject obj = new WorldObject(id, classname, loc_id, variables);
				objs.add(obj);
			}

			return objs;
		} catch (SQLException | IOException | ClassNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorldRoom> readAllRooms() {
		ArrayList<WorldRoom> rooms = new ArrayList<>();
		try {
			PreparedStatement stm = con.prepareStatement("SELECT id,long_path,room_value FROM rooms");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String path = rs.getString("long_path");
				byte[] buf = rs.getBytes("room_value");
				ObjectInputStream objectIn = null;
				if (buf != null)
					objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

				Map<String, ValueInterface> variables = (Map<String, ValueInterface>) objectIn.readObject();
				rooms.add(new WorldRoom(id, path, variables));
			}

			return rooms;
		} catch (SQLException | IOException | ClassNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public List<Action> readActionsFromRoom(WorldRoom room) {
		ArrayList<Action> actions = new ArrayList<>();
		try {
			PreparedStatement stm = con
					.prepareStatement("SELECT id, code, narration, publish_date, status FROM actions WHERE room = ?");
			PreparedStatement wtns = con.prepareStatement("SELECT username FROM witness_action WHERE action = ?");
			stm.setLong(1, room.getId());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				// Extracting action data
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String narration = rs.getString("narration");
				Date date = rs.getDate("publish_date");
				Action.Status status = Action.Status.valueOf(rs.getString("status"));

				// Looking for witnesses
				wtns.setLong(1, id);
				ResultSet rsw = wtns.executeQuery();
				List<User> witnesses = new ArrayList<>();
				while (rsw.next()) {
					witnesses.add(room.getWorld().getUser(rsw.getString("username")));
				}
				actions.add(new Action(id, room, code, narration, witnesses, date, status));
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
}
