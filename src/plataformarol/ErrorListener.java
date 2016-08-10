package plataformarol;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

public class ErrorListener extends BaseErrorListener {
	List<String> errors;

	public ErrorListener(List<String> errors) {
		super();
		this.errors = errors;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		//System.err.println("rule stack: " + stack);
		//System.err.println("line " + line + ":" + charPositionInLine + " at " + offendingSymbol + ": " + msg);
		errors.add("line " + line + ":" + charPositionInLine + ": " + msg);
	}
}
