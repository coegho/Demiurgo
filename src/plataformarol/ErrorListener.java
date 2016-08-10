package plataformarol;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Recognizer;

import exceptions.SyntaxErrorException;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

public class ErrorListener extends BaseErrorListener {
	protected ErrorHandler errors;

	public ErrorListener(ErrorHandler errors) {
		super();
		this.errors = errors;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		errors.notifyError(new SyntaxErrorException(
				"line " + line + ":" + charPositionInLine + ": " + msg, e));
	}
}
