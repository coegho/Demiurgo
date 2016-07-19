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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, D=17, 
		IF=18, ELSE=19, FOR=20, SYMBOL=21, USERNAME=22, INT_NUMBER=23, FLOAT_NUMBER=24, 
		BOOLEAN=25, TEXT_STRING=26, WS=27, COMMENT=28, COMMENT2=29, MUL=30, DIV=31, 
		ADD=32, SUB=33, EQ=34, NEQ=35, GREQ=36, LESEQ=37, GREAT=38, LESS=39, AND=40, 
		OR=41, ASSIGN=42, MOVE=43, INHERIT=44, ROOM=45, USEROBJ=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "D", "IF", 
		"ELSE", "FOR", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", 
		"TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", 
		"EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM", "USEROBJ"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'^'", "'['", "']'", "'new'", 
		"'#'", "'int'", "'float'", "'string'", "'[]'", "'\n'", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "'*'", "'/'", 
		"'+'", "'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&'", "'|'", 
		"'='", "'>>'", "':'", "'@'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "D", "IF", "ELSE", "FOR", "SYMBOL", "USERNAME", 
		"INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", "TEXT_STRING", "WS", "COMMENT", 
		"COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", "GREQ", "LESEQ", 
		"GREAT", "LESS", "AND", "OR", "ASSIGN", "MOVE", "INHERIT", "ROOM", "USEROBJ"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0118\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\5\26\u009f\n\26\3\26\7\26\u00a2"+
		"\n\26\f\26\16\26\u00a5\13\26\3\27\3\27\6\27\u00a9\n\27\r\27\16\27\u00aa"+
		"\3\30\6\30\u00ae\n\30\r\30\16\30\u00af\3\31\6\31\u00b3\n\31\r\31\16\31"+
		"\u00b4\3\31\3\31\6\31\u00b9\n\31\r\31\16\31\u00ba\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u00c6\n\32\3\33\3\33\7\33\u00ca\n\33\f"+
		"\33\16\33\u00cd\13\33\3\33\3\33\3\34\6\34\u00d2\n\34\r\34\16\34\u00d3"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00dc\n\35\f\35\16\35\u00df\13\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00ea\n\36\f\36\16"+
		"\36\u00ed\13\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3"+
		"$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-"+
		"\3.\3.\3/\3/\3/\4\u00cb\u00dd\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60\3\2\23\4\2FFff\4\2KKkk\4\2HHhh\4\2GGgg\4\2NNnn\4\2UUuu\4\2QQqq\4"+
		"\2TTtt\5\2C\\aac|\7\2CEG\\aaceg|\6\2\62;C\\aac|\3\2\62;\4\2VVvv\4\2WW"+
		"ww\4\2CCcc\5\2\13\13\17\17\"\"\3\2\f\f\u0122\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2"+
		"\2\13g\3\2\2\2\ri\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23o\3\2\2\2\25q\3\2"+
		"\2\2\27u\3\2\2\2\31w\3\2\2\2\33{\3\2\2\2\35\u0081\3\2\2\2\37\u0088\3\2"+
		"\2\2!\u008b\3\2\2\2#\u008d\3\2\2\2%\u008f\3\2\2\2\'\u0092\3\2\2\2)\u0097"+
		"\3\2\2\2+\u009e\3\2\2\2-\u00a6\3\2\2\2/\u00ad\3\2\2\2\61\u00b2\3\2\2\2"+
		"\63\u00c5\3\2\2\2\65\u00c7\3\2\2\2\67\u00d1\3\2\2\29\u00d7\3\2\2\2;\u00e5"+
		"\3\2\2\2=\u00f0\3\2\2\2?\u00f2\3\2\2\2A\u00f4\3\2\2\2C\u00f6\3\2\2\2E"+
		"\u00f8\3\2\2\2G\u00fb\3\2\2\2I\u00fe\3\2\2\2K\u0101\3\2\2\2M\u0104\3\2"+
		"\2\2O\u0106\3\2\2\2Q\u0108\3\2\2\2S\u010a\3\2\2\2U\u010c\3\2\2\2W\u010e"+
		"\3\2\2\2Y\u0111\3\2\2\2[\u0113\3\2\2\2]\u0115\3\2\2\2_`\7}\2\2`\4\3\2"+
		"\2\2ab\7\177\2\2b\6\3\2\2\2cd\7*\2\2d\b\3\2\2\2ef\7+\2\2f\n\3\2\2\2gh"+
		"\7.\2\2h\f\3\2\2\2ij\7\60\2\2j\16\3\2\2\2kl\7`\2\2l\20\3\2\2\2mn\7]\2"+
		"\2n\22\3\2\2\2op\7_\2\2p\24\3\2\2\2qr\7p\2\2rs\7g\2\2st\7y\2\2t\26\3\2"+
		"\2\2uv\7%\2\2v\30\3\2\2\2wx\7k\2\2xy\7p\2\2yz\7v\2\2z\32\3\2\2\2{|\7h"+
		"\2\2|}\7n\2\2}~\7q\2\2~\177\7c\2\2\177\u0080\7v\2\2\u0080\34\3\2\2\2\u0081"+
		"\u0082\7u\2\2\u0082\u0083\7v\2\2\u0083\u0084\7t\2\2\u0084\u0085\7k\2\2"+
		"\u0085\u0086\7p\2\2\u0086\u0087\7i\2\2\u0087\36\3\2\2\2\u0088\u0089\7"+
		"]\2\2\u0089\u008a\7_\2\2\u008a \3\2\2\2\u008b\u008c\7\f\2\2\u008c\"\3"+
		"\2\2\2\u008d\u008e\t\2\2\2\u008e$\3\2\2\2\u008f\u0090\t\3\2\2\u0090\u0091"+
		"\t\4\2\2\u0091&\3\2\2\2\u0092\u0093\t\5\2\2\u0093\u0094\t\6\2\2\u0094"+
		"\u0095\t\7\2\2\u0095\u0096\t\5\2\2\u0096(\3\2\2\2\u0097\u0098\t\4\2\2"+
		"\u0098\u0099\t\b\2\2\u0099\u009a\t\t\2\2\u009a*\3\2\2\2\u009b\u009c\t"+
		"\2\2\2\u009c\u009f\t\n\2\2\u009d\u009f\t\13\2\2\u009e\u009b\3\2\2\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00a3\3\2\2\2\u00a0\u00a2\t\f\2\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		",\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8\7&\2\2\u00a7\u00a9\t\f\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab.\3\2\2\2\u00ac\u00ae\t\r\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\60\3\2\2\2\u00b1"+
		"\u00b3\t\r\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\7\60\2\2\u00b7"+
		"\u00b9\t\r\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\62\3\2\2\2\u00bc\u00bd\t\16\2\2\u00bd\u00be"+
		"\t\t\2\2\u00be\u00bf\t\17\2\2\u00bf\u00c6\t\5\2\2\u00c0\u00c1\t\4\2\2"+
		"\u00c1\u00c2\t\20\2\2\u00c2\u00c3\t\6\2\2\u00c3\u00c4\t\7\2\2\u00c4\u00c6"+
		"\t\5\2\2\u00c5\u00bc\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c6\64\3\2\2\2\u00c7"+
		"\u00cb\7$\2\2\u00c8\u00ca\13\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00ce\u00cf\7$\2\2\u00cf\66\3\2\2\2\u00d0\u00d2\t\21\2"+
		"\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b\34\2\2\u00d68\3\2\2\2\u00d7"+
		"\u00d8\7\61\2\2\u00d8\u00d9\7,\2\2\u00d9\u00dd\3\2\2\2\u00da\u00dc\13"+
		"\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00de\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7,"+
		"\2\2\u00e1\u00e2\7\61\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b\35\2\2\u00e4"+
		":\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\7\61\2\2\u00e7\u00eb\3\2\2"+
		"\2\u00e8\u00ea\n\22\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ee\u00ef\b\36\2\2\u00ef<\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1>\3\2"+
		"\2\2\u00f2\u00f3\7\61\2\2\u00f3@\3\2\2\2\u00f4\u00f5\7-\2\2\u00f5B\3\2"+
		"\2\2\u00f6\u00f7\7/\2\2\u00f7D\3\2\2\2\u00f8\u00f9\7?\2\2\u00f9\u00fa"+
		"\7?\2\2\u00faF\3\2\2\2\u00fb\u00fc\7#\2\2\u00fc\u00fd\7?\2\2\u00fdH\3"+
		"\2\2\2\u00fe\u00ff\7@\2\2\u00ff\u0100\7?\2\2\u0100J\3\2\2\2\u0101\u0102"+
		"\7>\2\2\u0102\u0103\7?\2\2\u0103L\3\2\2\2\u0104\u0105\7@\2\2\u0105N\3"+
		"\2\2\2\u0106\u0107\7>\2\2\u0107P\3\2\2\2\u0108\u0109\7(\2\2\u0109R\3\2"+
		"\2\2\u010a\u010b\7~\2\2\u010bT\3\2\2\2\u010c\u010d\7?\2\2\u010dV\3\2\2"+
		"\2\u010e\u010f\7@\2\2\u010f\u0110\7@\2\2\u0110X\3\2\2\2\u0111\u0112\7"+
		"<\2\2\u0112Z\3\2\2\2\u0113\u0114\7B\2\2\u0114\\\3\2\2\2\u0115\u0116\7"+
		"/\2\2\u0116\u0117\7@\2\2\u0117^\3\2\2\2\16\2\u009e\u00a3\u00aa\u00af\u00b4"+
		"\u00ba\u00c5\u00cb\u00d3\u00dd\u00eb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}