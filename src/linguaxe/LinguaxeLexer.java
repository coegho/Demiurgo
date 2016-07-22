// Generated from Linguaxe.g4 by ANTLR 4.5
package linguaxe;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LinguaxeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, D=13, IF=14, ELSE=15, FOR=16, ECHO=17, INT_TYPE=18, 
		FLOAT_TYPE=19, STRING_TYPE=20, SYMBOL=21, USERNAME=22, INT_NUMBER=23, 
		FLOAT_NUMBER=24, BOOLEAN=25, TEXT_STRING=26, WS=27, COMMENT=28, COMMENT2=29, 
		MUL=30, DIV=31, ADD=32, SUB=33, EQ=34, NEQ=35, GREQ=36, LESEQ=37, GREAT=38, 
		LESS=39, AND=40, OR=41, ASSIGN=42, MOVE=43, INHERIT=44, ROOM=45, USEROBJ=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", 
		"FLOAT_TYPE", "STRING_TYPE", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", 
		"BOOLEAN", "TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", 
		"SUB", "EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM", "USEROBJ"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'['", "']'", "'new'", 
		"'#'", "'[]'", "'\n'", null, null, null, null, "'!'", null, null, null, 
		null, null, null, null, null, null, null, null, null, "'*'", "'/'", "'+'", 
		"'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&'", "'|'", "'='", 
		"'>>'", "':'", "'@'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", "FLOAT_TYPE", "STRING_TYPE", 
		"SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", "TEXT_STRING", 
		"WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", 
		"GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", "MOVE", "INHERIT", 
		"ROOM", "USEROBJ"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LinguaxeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Linguaxe.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0115\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\5\26\u009c\n\26\3\26\7\26\u009f\n\26\f\26\16\26\u00a2"+
		"\13\26\3\27\3\27\6\27\u00a6\n\27\r\27\16\27\u00a7\3\30\6\30\u00ab\n\30"+
		"\r\30\16\30\u00ac\3\31\6\31\u00b0\n\31\r\31\16\31\u00b1\3\31\3\31\6\31"+
		"\u00b6\n\31\r\31\16\31\u00b7\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\5\32\u00c3\n\32\3\33\3\33\7\33\u00c7\n\33\f\33\16\33\u00ca\13\33\3"+
		"\33\3\33\3\34\6\34\u00cf\n\34\r\34\16\34\u00d0\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\7\35\u00d9\n\35\f\35\16\35\u00dc\13\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\7\36\u00e7\n\36\f\36\16\36\u00ea\13\36\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\4\u00c8\u00da"+
		"\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\24\4\2FFff\4\2KKkk\4\2"+
		"HHhh\4\2GGgg\4\2NNnn\4\2UUuu\4\2QQqq\4\2TTtt\4\2PPpp\4\2VVvv\4\2CCcc\5"+
		"\2C\\aac|\7\2CEG\\aaceg|\6\2\62;C\\aac|\3\2\62;\4\2WWww\5\2\13\13\17\17"+
		"\"\"\3\2\f\f\u011f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\3_\3\2\2\2\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2\17"+
		"k\3\2\2\2\21m\3\2\2\2\23o\3\2\2\2\25s\3\2\2\2\27u\3\2\2\2\31x\3\2\2\2"+
		"\33z\3\2\2\2\35|\3\2\2\2\37\177\3\2\2\2!\u0084\3\2\2\2#\u0088\3\2\2\2"+
		"%\u008a\3\2\2\2\'\u008e\3\2\2\2)\u0094\3\2\2\2+\u009b\3\2\2\2-\u00a3\3"+
		"\2\2\2/\u00aa\3\2\2\2\61\u00af\3\2\2\2\63\u00c2\3\2\2\2\65\u00c4\3\2\2"+
		"\2\67\u00ce\3\2\2\29\u00d4\3\2\2\2;\u00e2\3\2\2\2=\u00ed\3\2\2\2?\u00ef"+
		"\3\2\2\2A\u00f1\3\2\2\2C\u00f3\3\2\2\2E\u00f5\3\2\2\2G\u00f8\3\2\2\2I"+
		"\u00fb\3\2\2\2K\u00fe\3\2\2\2M\u0101\3\2\2\2O\u0103\3\2\2\2Q\u0105\3\2"+
		"\2\2S\u0107\3\2\2\2U\u0109\3\2\2\2W\u010b\3\2\2\2Y\u010e\3\2\2\2[\u0110"+
		"\3\2\2\2]\u0112\3\2\2\2_`\7}\2\2`\4\3\2\2\2ab\7\177\2\2b\6\3\2\2\2cd\7"+
		"*\2\2d\b\3\2\2\2ef\7+\2\2f\n\3\2\2\2gh\7.\2\2h\f\3\2\2\2ij\7\60\2\2j\16"+
		"\3\2\2\2kl\7]\2\2l\20\3\2\2\2mn\7_\2\2n\22\3\2\2\2op\7p\2\2pq\7g\2\2q"+
		"r\7y\2\2r\24\3\2\2\2st\7%\2\2t\26\3\2\2\2uv\7]\2\2vw\7_\2\2w\30\3\2\2"+
		"\2xy\7\f\2\2y\32\3\2\2\2z{\t\2\2\2{\34\3\2\2\2|}\t\3\2\2}~\t\4\2\2~\36"+
		"\3\2\2\2\177\u0080\t\5\2\2\u0080\u0081\t\6\2\2\u0081\u0082\t\7\2\2\u0082"+
		"\u0083\t\5\2\2\u0083 \3\2\2\2\u0084\u0085\t\4\2\2\u0085\u0086\t\b\2\2"+
		"\u0086\u0087\t\t\2\2\u0087\"\3\2\2\2\u0088\u0089\7#\2\2\u0089$\3\2\2\2"+
		"\u008a\u008b\t\3\2\2\u008b\u008c\t\n\2\2\u008c\u008d\t\13\2\2\u008d&\3"+
		"\2\2\2\u008e\u008f\t\4\2\2\u008f\u0090\t\6\2\2\u0090\u0091\t\b\2\2\u0091"+
		"\u0092\t\f\2\2\u0092\u0093\t\13\2\2\u0093(\3\2\2\2\u0094\u0095\t\7\2\2"+
		"\u0095\u0096\t\13\2\2\u0096\u0097\t\t\2\2\u0097*\3\2\2\2\u0098\u0099\t"+
		"\2\2\2\u0099\u009c\t\r\2\2\u009a\u009c\t\16\2\2\u009b\u0098\3\2\2\2\u009b"+
		"\u009a\3\2\2\2\u009c\u00a0\3\2\2\2\u009d\u009f\t\17\2\2\u009e\u009d\3"+
		"\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		",\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\7&\2\2\u00a4\u00a6\t\17\2\2"+
		"\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8.\3\2\2\2\u00a9\u00ab\t\20\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\60\3\2\2"+
		"\2\u00ae\u00b0\t\20\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\7\60"+
		"\2\2\u00b4\u00b6\t\20\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\62\3\2\2\2\u00b9\u00ba\t\13\2"+
		"\2\u00ba\u00bb\t\t\2\2\u00bb\u00bc\t\21\2\2\u00bc\u00c3\t\5\2\2\u00bd"+
		"\u00be\t\4\2\2\u00be\u00bf\t\f\2\2\u00bf\u00c0\t\6\2\2\u00c0\u00c1\t\7"+
		"\2\2\u00c1\u00c3\t\5\2\2\u00c2\u00b9\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c3"+
		"\64\3\2\2\2\u00c4\u00c8\7$\2\2\u00c5\u00c7\13\2\2\2\u00c6\u00c5\3\2\2"+
		"\2\u00c7\u00ca\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7$\2\2\u00cc\66\3\2\2\2\u00cd"+
		"\u00cf\t\22\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3"+
		"\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\34\2\2\u00d3"+
		"8\3\2\2\2\u00d4\u00d5\7\61\2\2\u00d5\u00d6\7,\2\2\u00d6\u00da\3\2\2\2"+
		"\u00d7\u00d9\13\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00de\7,\2\2\u00de\u00df\7\61\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b\35"+
		"\2\2\u00e1:\3\2\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e8"+
		"\3\2\2\2\u00e5\u00e7\n\23\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2"+
		"\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00eb\u00ec\b\36\2\2\u00ec<\3\2\2\2\u00ed\u00ee\7,\2\2\u00ee"+
		">\3\2\2\2\u00ef\u00f0\7\61\2\2\u00f0@\3\2\2\2\u00f1\u00f2\7-\2\2\u00f2"+
		"B\3\2\2\2\u00f3\u00f4\7/\2\2\u00f4D\3\2\2\2\u00f5\u00f6\7?\2\2\u00f6\u00f7"+
		"\7?\2\2\u00f7F\3\2\2\2\u00f8\u00f9\7#\2\2\u00f9\u00fa\7?\2\2\u00faH\3"+
		"\2\2\2\u00fb\u00fc\7@\2\2\u00fc\u00fd\7?\2\2\u00fdJ\3\2\2\2\u00fe\u00ff"+
		"\7>\2\2\u00ff\u0100\7?\2\2\u0100L\3\2\2\2\u0101\u0102\7@\2\2\u0102N\3"+
		"\2\2\2\u0103\u0104\7>\2\2\u0104P\3\2\2\2\u0105\u0106\7(\2\2\u0106R\3\2"+
		"\2\2\u0107\u0108\7~\2\2\u0108T\3\2\2\2\u0109\u010a\7?\2\2\u010aV\3\2\2"+
		"\2\u010b\u010c\7@\2\2\u010c\u010d\7@\2\2\u010dX\3\2\2\2\u010e\u010f\7"+
		"<\2\2\u010fZ\3\2\2\2\u0110\u0111\7B\2\2\u0111\\\3\2\2\2\u0112\u0113\7"+
		"/\2\2\u0113\u0114\7@\2\2\u0114^\3\2\2\2\16\2\u009b\u00a0\u00a7\u00ac\u00b1"+
		"\u00b7\u00c2\u00c8\u00d0\u00da\u00e8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}