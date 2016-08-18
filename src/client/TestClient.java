package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import serverinterface.ResultObject;
import serverinterface.ServerInterface;

public class TestClient {

	public static void main(String[] args) {
		try {String registryURL ="rmi://127.0.0.1:5555/plataformarol";  
		
			ServerInterface h = (ServerInterface)Naming.lookup(registryURL);
		
		System.out.println("Lookup completed " );
		
		List<ResultObject> l = h.checkRoom("mundo1", "/escenario1");
		for(ResultObject o : l) {
			System.out.println(o);
		}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
