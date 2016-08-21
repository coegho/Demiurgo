package database;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import serializable.SerializableUser;
import serializable.SerializableWorldObject;
import serializable.SerializableWorldRoom;
import values.IReturnValue;

public class MariaDBDatabase implements DatabaseInterface {

	//TODO: table prefix
	private Connection con;

	@Override
	public boolean createConnection(String database, String username, String pass) {
		if (existsDriver()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/" + database, username, pass);
				return true;
			} catch (SQLException e) {
				System.err.println(e.getLocalizedMessage());
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
	public void writeUser(SerializableUser user) {
		try {
			PreparedStatement stm = con.prepareStatement("INSERT users (username, obj_id) VALUES (?, ?) ON DUPLICATE KEY UPDATE obj_id=VALUES(obj_id)");
			stm.setString(1, user.getUsername());
			if (user.getObj_id() != -1)
				stm.setLong(2, user.getObj_id());
			else
				stm.setNull(2, java.sql.Types.BIGINT);
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void writeWorldObject(SerializableWorldObject obj) {
		try {
			PreparedStatement stm = con.prepareStatement("INSERT objects (obj_id, classname, room, obj_value) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE classname=VALUES(classname), room=VALUES(room), obj_value=VALUES(obj_value)");
			stm.setLong(1, obj.getId());
			stm.setString(2, obj.getClassName());
			stm.setLong(3, obj.getLoc_id());
			stm.setObject(4, obj.getFields());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void writeWorldRoom(SerializableWorldRoom room) {
		try {
			PreparedStatement stm = con.prepareStatement("INSERT rooms (id, long_path, room_value) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE long_path=VALUES(long_path), room_value=VALUES(room_value)");
			stm.setLong(1, room.getId());
			stm.setString(2, room.getLong_path());
			stm.setObject(3, room.getFields());
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public List<SerializableUser> readAllUsers() {
		ArrayList<SerializableUser> users = new ArrayList<>();
		try {
			PreparedStatement stm = con.prepareStatement("SELECT username,IFNULL(obj_id,-1) AS obj_id FROM users");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				users.add(new SerializableUser(rs.getString("username"), rs.getLong("obj_id")));
			}

			return users;
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public List<SerializableWorldObject> readAllObjects() {
		ArrayList<SerializableWorldObject> objs = new ArrayList<>();
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
				
				Map<String, IReturnValue> variables = (Map<String, IReturnValue>)objectIn.readObject();
				objs.add(new SerializableWorldObject(id, classname, loc_id, variables));
			}

			return objs;
		} catch (SQLException | IOException | ClassNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public List<SerializableWorldRoom> readAllRooms() {
		ArrayList<SerializableWorldRoom> rooms = new ArrayList<>();
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

				Map<String, IReturnValue> variables = (Map<String, IReturnValue>)objectIn.readObject();
				rooms.add(new SerializableWorldRoom(id, path, variables));
			}

			return rooms;
		} catch (SQLException | IOException | ClassNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public long[] readCurrentIDs() {
		long[] ids = new long[2];
		try {
			PreparedStatement stm = con.prepareStatement("SELECT obj,room FROM current_ids");
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				ids[0] = rs.getLong("obj");
				ids[1] = rs.getLong("room");
			}

			return ids;
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			return null; // TODO throw exception
		}
	}

	@Override
	public void setCurrentIDs(long objId, long roomId) {
		try {
			PreparedStatement stm = con.prepareStatement("UPDATE current_ids SET obj=?,room=?");
			stm.setLong(1, objId);
			stm.setLong(2, roomId);
			stm.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
}
