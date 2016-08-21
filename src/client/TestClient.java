package client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import serializable.SerializableWorldObject;
import serializable.ServerInterface;

public class TestClient {

	public static void main(String[] args) {
		try {
			String registryURL = "rmi://127.0.0.1:5555/plataformarol";

			ServerInterface h = (ServerInterface) Naming.lookup(registryURL);

			System.out.println("Lookup completed ");

			//h.createRoom("mundo1", "/escenario1");

			List<SerializableWorldObject> l;
			l = h.checkRoom("mundo1", "/escenario1");
			for (SerializableWorldObject o : l) {
				System.out.println(o);
			}

			System.out.println("Reading input.rol...");
			String code = new String(Files.readAllBytes(Paths.get("input.rol")), StandardCharsets.UTF_8);

			h.executeCode("mundo1", "/escenario1", code);

			l = h.checkRoom("mundo1", "/escenario1");
			for (SerializableWorldObject o : l) {
				System.out.println(o);
			}

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
