package plataformarol;

import java.io.IOException;

//import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import linguaxe.*;

public class PlataformaRol {

	public static void main(String[] args) {
		// create a CharStream that reads from standard input
		ANTLRInputStream input;
		try {
			input = new ANTLRInputStream(System.in);
			// create a lexer that feeds off of input CharStream
			LinguaxeLexer lexer = new LinguaxeLexer(input);
			// create a buffer of tokens pulled from the lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// create a parser that feeds off the tokens buffer
			LinguaxeParser parser = new LinguaxeParser(tokens);
			ParseTree tree = parser.s(); // begin parsing at init rule
			System.out.println(tree.toStringTree(parser)); // print LISP-style
															// tree

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
