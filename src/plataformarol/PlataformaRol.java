package plataformarol;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

//import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import linguaxe.*;

public class PlataformaRol {

	public static void main(String[] args) {
		try {
			String inputFile = null;
			if ( args.length>0 ) inputFile = args[0];
			InputStream is = System.in;
			if ( inputFile!=null ) is = new FileInputStream(inputFile);
			ANTLRInputStream input = new ANTLRInputStream(is);
			LinguaxeLexer lexer = new LinguaxeLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			LinguaxeParser parser = new LinguaxeParser(tokens);
			ParseTree tree = parser.s(); // parse; start at s
			EvalVisitor eval = new EvalVisitor();
			eval.visit(tree);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
