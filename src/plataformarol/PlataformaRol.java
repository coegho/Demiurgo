package plataformarol;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import linguaxe.LinguaxeLexer;
import linguaxe.LinguaxeParser;
import universe.World;
import universe.WorldRoom;

public class PlataformaRol {

	public static void main(String[] args) {
		try {
			//TODO: example data
			World currentWorld = new World();
			WorldRoom currentRoom = new WorldRoom("estancia_de_probas");

			if (args.length > 0) {
				for (String arg : args) {
					InputStream is = new FileInputStream(arg);
					ANTLRInputStream input = new ANTLRInputStream(is);
					LinguaxeLexer lexer = new LinguaxeLexer(input);
					CommonTokenStream tokens = new CommonTokenStream(lexer);
					LinguaxeParser parser = new LinguaxeParser(tokens);
					ParseTree tree = parser.s(); // parse; start at s
					EvalVisitor eval = new EvalVisitor(currentWorld, currentRoom);
					eval.visit(tree);
				}
			} else {
				InputStream is = System.in;
				ANTLRInputStream input = new ANTLRInputStream(is);
				LinguaxeLexer lexer = new LinguaxeLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				LinguaxeParser parser = new LinguaxeParser(tokens);
				ParseTree tree = parser.s(); // parse; start at s
				EvalVisitor eval = new EvalVisitor(currentWorld, currentRoom);
				eval.visit(tree);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
