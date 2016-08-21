package serializable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import plataformarol.ClassVisitor;
import plataformarol.CodeVisitor;
import plataformarol.ErrorHandler;
import plataformarol.PlataformaRol;
import universe.UserDefinedClass;
import universe.World;
import universe.WorldObject;
import universe.WorldRoom;

public class ServerInterfaceImpl extends UnicastRemoteObject implements ServerInterface {

	public ServerInterfaceImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<SerializableWorldObject> checkRoom(String world, String path) throws RemoteException {
		WorldRoom room = PlataformaRol.getWorld(world).getRoom(path);
		if (room == null) {
			return null;
		}
		ArrayList<SerializableWorldObject> ret = new ArrayList<>();
		for (WorldObject o : room.getObjects()) {
			ret.add(o.getSerializableWorldObject());
		}
		return ret;

	}

	@Override
	public boolean executeCode(String world, String path, String code) throws RemoteException {
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		ParseTree tree;
		try {
			tree = PlataformaRol.parseStream(is, errors);
		} catch (IOException e1) {
			return false;
		}
		WorldRoom room = PlataformaRol.getWorld(world).getRoom(path);
		if (room == null) {
			return false;
		}
		CodeVisitor eval = new CodeVisitor(room, errors);
		eval.visit(tree);

		if (errors.hasErrors()) {
			for (String e : errors.getErrors()) {
				System.err.println(e); // TODO: Output this and check errors
			}
		}
		return true;
	}

	@Override
	public boolean newClass(String world, String name, String code) throws RemoteException {
		World w = PlataformaRol.getWorld(world);
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		ParseTree tree;
		try {
			tree = PlataformaRol.parseStream(is, errors);
		} catch (IOException e1) {
			return false;
		}

		UserDefinedClass newClass = new UserDefinedClass(name, w);
		w.addClass(newClass);
		ClassVisitor eval = new ClassVisitor(newClass, errors);
		eval.visit(tree);

		if (errors.hasErrors()) {
			for (String e : errors.getErrors()) {
				System.err.println(e); // TODO: Output this and check errors
			}
			w.removeClass(newClass.getClassName());
		}
		return true;
	}

	@Override
	public boolean createRoom(String world, String path) throws RemoteException {
		WorldRoom room = PlataformaRol.getWorld(world).newRoom(path);
		return room != null;
	}

	@Override
	public void submitDecision(String world, String user, String text) throws RemoteException {
		// TODO: identify user
		World w = PlataformaRol.getWorld(world);
		w.addDecision(w.getUser(user), text);
	}

	@Override
	public List<String> getPendingRooms(String world) throws RemoteException {
		World w = PlataformaRol.getWorld(world);
		if (w == null)
			return null;
		List<String> l = new ArrayList<>();
		for(WorldRoom r : w.getPendingRooms()) {
			l.add(r.getLongPath());
		}
		return l;
	}

	@Override
	public List<SerializableDecision> getDecisions(String world, String room) throws RemoteException {
		World w = PlataformaRol.getWorld(world);
		if (w == null)
			return null;
		if (room == null) {
			return w.getSerializableDecisions();
		} else {
			WorldRoom r = w.getRoom(room);
			if (r == null)
				return null;
			return r.getSerializableDecisions();
		}
	}
}
