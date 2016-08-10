package plataformarol;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import linguaxe.LinguaxeLexer;
import linguaxe.LinguaxeParser;
import universe.World;
import universe.WorldObject;
import universe.WorldRoom;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class PlataformaRol {

	public static void main(String[] args) {
		try {
			//TODO: example data
			ErrorHandler errors = new ErrorHandler();
			List<String> users = new ArrayList<>();
			users.add("user1");
			World currentWorld = new World();
			WorldRoom currentRoom = currentWorld.newRoom("/proba/estancia_de_probas");
			currentWorld.newRoom("/proba/estancia2");

			if (args.length > 0) {
				for (String arg : args) {
					InputStream is = new FileInputStream(arg);
					ANTLRInputStream input = new ANTLRInputStream(is);
					LinguaxeLexer lexer = new LinguaxeLexer(input);
					CommonTokenStream tokens = new CommonTokenStream(lexer);
					LinguaxeParser parser = new LinguaxeParser(tokens);
					parser.removeErrorListeners();
					parser.addErrorListener(new ErrorListener(errors));
					ParseTree tree = parser.s(); // parse; start at s
					ExecVisitor eval = new ExecVisitor(currentWorld, currentRoom, errors);
					eval.visit(tree);
				}
			} else {
				//no input files
			}

			//Checking errors
			for(String e : errors.getErrors()) {
				System.out.println(e);
			}
			
			//Checking world state
			System.out.println("##########CHECKING WORLD STATE########");
			System.out.println("--SEARCHING USERS--");
			for(String u : users) {
				WorldObject o = currentWorld.getObjectFromUser(u);
				if(o != null) {
					WorldRoom r = (WorldRoom)o.getLocation();
					System.out.println("| $" + u + " -> #" + o.getId() + " (" + r.getLongName() + ")");
				}
				else {
					System.out.println("| $" + u + " -> null");
				}
			}
			System.out.println("--CHECKING ROOMS--");
			for(WorldRoom r : currentWorld.getAllRooms()) {
				System.out.println("ROOM " + r.getLongName());
				System.out.print("| OBJECTS = {");
				for(WorldObject o : r.getObjects()) {
					System.out.print(" #"+ o.getId() + ":"+o.getUserClass().getClassName());
				}
				System.out.println(" }");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
