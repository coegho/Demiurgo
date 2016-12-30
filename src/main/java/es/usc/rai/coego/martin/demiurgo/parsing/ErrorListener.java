package es.usc.rai.coego.martin.demiurgo.parsing;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import es.usc.rai.coego.martin.demiurgo.exceptions.ParserException;

public class ErrorListener extends BaseErrorListener {
	protected ErrorHandler errors;

	public ErrorListener(ErrorHandler errors) {
		super();
		this.errors = errors;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		errors.notifyError(new ParserException(
				"line " + line + ":" + charPositionInLine + ": " + msg, line, charPositionInLine, 0));
	}
}
