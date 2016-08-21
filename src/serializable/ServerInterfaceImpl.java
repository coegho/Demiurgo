package serializable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import plataformarol.CodeVisitor;
import plataformarol.ErrorHandler;
import plataformarol.PlataformaRol;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createRoom(String world, String path) throws RemoteException {
		WorldRoom room = PlataformaRol.getWorld(world).newRoom(path);
		return room != null;
	}

}
