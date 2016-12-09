package es.usc.rai.coego.martin.demiurgo.parsing;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Recognizer;

import es.usc.rai.coego.martin.demiurgo.exceptions.ParserException;

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
		//TODO: Logger
		System.err.println("rule stack: "+stack);
		System.err.println("line "+line+":"+charPositionInLine+" at "+
		offendingSymbol+": "+msg);
		errors.notifyError(new ParserException(
				"line " + line + ":" + charPositionInLine + ": " + msg, line, charPositionInLine, 0));
	}
}
