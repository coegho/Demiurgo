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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		D=18, IF=19, ELSE=20, FOR=21, SYMBOL=22, INT_NUMBER=23, FLOAT_NUMBER=24, 
		BOOLEAN=25, TEXT_STRING=26, WS=27, COMMENT=28, COMMENT2=29, MUL=30, DIV=31, 
		ADD=32, SUB=33, EQ=34, NEQ=35, GREQ=36, LESEQ=37, GREAT=38, LESS=39, AND=40, 
		OR=41, ASSIGN=42, MOVE=43, INHERIT=44, ROOM=45;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"D", "IF", "ELSE", "FOR", "SYMBOL", "INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", 
		"TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", 
		"EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'^'", "'['", "']'", "'new'", 
		"'#'", "'->'", "'$'", "'int'", "'float'", "'string'", "'\n'", null, null, 
		null, null, null, null, null, null, null, null, null, null, "'*'", "'/'", 
		"'+'", "'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&'", "'|'", 
		"'='", "'>>'", "':'", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "D", "IF", "ELSE", "FOR", "SYMBOL", 
		"INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", "TEXT_STRING", "WS", "COMMENT", 
		"COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", "GREQ", "LESEQ", 
		"GREAT", "LESS", "AND", "OR", "ASSIGN", "MOVE", "INHERIT", "ROOM"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2/\u010f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u009f\n\27\3\27\7\27\u00a2"+
		"\n\27\f\27\16\27\u00a5\13\27\3\30\6\30\u00a8\n\30\r\30\16\30\u00a9\3\31"+
		"\6\31\u00ad\n\31\r\31\16\31\u00ae\3\31\3\31\6\31\u00b3\n\31\r\31\16\31"+
		"\u00b4\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00c0\n\32\3"+
		"\33\3\33\7\33\u00c4\n\33\f\33\16\33\u00c7\13\33\3\33\3\33\3\34\6\34\u00cc"+
		"\n\34\r\34\16\34\u00cd\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00d6\n\35\f"+
		"\35\16\35\u00d9\13\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36"+
		"\u00e4\n\36\f\36\16\36\u00e7\13\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+"+
		"\3+\3,\3,\3,\3-\3-\3.\3.\4\u00c5\u00d7\2/\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/\3\2\23\4\2FFff\4\2KKkk\4\2HHhh\4\2GGgg\4\2NNnn\4\2UUuu\4\2QQ"+
		"qq\4\2TTtt\5\2C\\aac|\7\2CEG\\aaceg|\6\2\62;C\\aac|\3\2\62;\4\2VVvv\4"+
		"\2WWww\4\2CCcc\5\2\13\13\17\17\"\"\3\2\f\f\u0118\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13e\3"+
		"\2\2\2\rg\3\2\2\2\17i\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27s"+
		"\3\2\2\2\31u\3\2\2\2\33x\3\2\2\2\35z\3\2\2\2\37~\3\2\2\2!\u0084\3\2\2"+
		"\2#\u008b\3\2\2\2%\u008d\3\2\2\2\'\u008f\3\2\2\2)\u0092\3\2\2\2+\u0097"+
		"\3\2\2\2-\u009e\3\2\2\2/\u00a7\3\2\2\2\61\u00ac\3\2\2\2\63\u00bf\3\2\2"+
		"\2\65\u00c1\3\2\2\2\67\u00cb\3\2\2\29\u00d1\3\2\2\2;\u00df\3\2\2\2=\u00ea"+
		"\3\2\2\2?\u00ec\3\2\2\2A\u00ee\3\2\2\2C\u00f0\3\2\2\2E\u00f2\3\2\2\2G"+
		"\u00f5\3\2\2\2I\u00f8\3\2\2\2K\u00fb\3\2\2\2M\u00fe\3\2\2\2O\u0100\3\2"+
		"\2\2Q\u0102\3\2\2\2S\u0104\3\2\2\2U\u0106\3\2\2\2W\u0108\3\2\2\2Y\u010b"+
		"\3\2\2\2[\u010d\3\2\2\2]^\7}\2\2^\4\3\2\2\2_`\7\177\2\2`\6\3\2\2\2ab\7"+
		"*\2\2b\b\3\2\2\2cd\7+\2\2d\n\3\2\2\2ef\7.\2\2f\f\3\2\2\2gh\7\60\2\2h\16"+
		"\3\2\2\2ij\7`\2\2j\20\3\2\2\2kl\7]\2\2l\22\3\2\2\2mn\7_\2\2n\24\3\2\2"+
		"\2op\7p\2\2pq\7g\2\2qr\7y\2\2r\26\3\2\2\2st\7%\2\2t\30\3\2\2\2uv\7/\2"+
		"\2vw\7@\2\2w\32\3\2\2\2xy\7&\2\2y\34\3\2\2\2z{\7k\2\2{|\7p\2\2|}\7v\2"+
		"\2}\36\3\2\2\2~\177\7h\2\2\177\u0080\7n\2\2\u0080\u0081\7q\2\2\u0081\u0082"+
		"\7c\2\2\u0082\u0083\7v\2\2\u0083 \3\2\2\2\u0084\u0085\7u\2\2\u0085\u0086"+
		"\7v\2\2\u0086\u0087\7t\2\2\u0087\u0088\7k\2\2\u0088\u0089\7p\2\2\u0089"+
		"\u008a\7i\2\2\u008a\"\3\2\2\2\u008b\u008c\7\f\2\2\u008c$\3\2\2\2\u008d"+
		"\u008e\t\2\2\2\u008e&\3\2\2\2\u008f\u0090\t\3\2\2\u0090\u0091\t\4\2\2"+
		"\u0091(\3\2\2\2\u0092\u0093\t\5\2\2\u0093\u0094\t\6\2\2\u0094\u0095\t"+
		"\7\2\2\u0095\u0096\t\5\2\2\u0096*\3\2\2\2\u0097\u0098\t\4\2\2\u0098\u0099"+
		"\t\b\2\2\u0099\u009a\t\t\2\2\u009a,\3\2\2\2\u009b\u009c\t\2\2\2\u009c"+
		"\u009f\t\n\2\2\u009d\u009f\t\13\2\2\u009e\u009b\3\2\2\2\u009e\u009d\3"+
		"\2\2\2\u009f\u00a3\3\2\2\2\u00a0\u00a2\t\f\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4.\3\2\2\2"+
		"\u00a5\u00a3\3\2\2\2\u00a6\u00a8\t\r\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\60\3\2\2\2\u00ab"+
		"\u00ad\t\r\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\7\60\2\2\u00b1"+
		"\u00b3\t\r\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\62\3\2\2\2\u00b6\u00b7\t\16\2\2\u00b7\u00b8"+
		"\t\t\2\2\u00b8\u00b9\t\17\2\2\u00b9\u00c0\t\5\2\2\u00ba\u00bb\t\4\2\2"+
		"\u00bb\u00bc\t\20\2\2\u00bc\u00bd\t\6\2\2\u00bd\u00be\t\7\2\2\u00be\u00c0"+
		"\t\5\2\2\u00bf\u00b6\3\2\2\2\u00bf\u00ba\3\2\2\2\u00c0\64\3\2\2\2\u00c1"+
		"\u00c5\7$\2\2\u00c2\u00c4\13\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2"+
		"\2\2\u00c5\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00c9\7$\2\2\u00c9\66\3\2\2\2\u00ca\u00cc\t\21\2"+
		"\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\b\34\2\2\u00d08\3\2\2\2\u00d1"+
		"\u00d2\7\61\2\2\u00d2\u00d3\7,\2\2\u00d3\u00d7\3\2\2\2\u00d4\u00d6\13"+
		"\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7,"+
		"\2\2\u00db\u00dc\7\61\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b\35\2\2\u00de"+
		":\3\2\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e1\7\61\2\2\u00e1\u00e5\3\2\2"+
		"\2\u00e2\u00e4\n\22\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e8\u00e9\b\36\2\2\u00e9<\3\2\2\2\u00ea\u00eb\7,\2\2\u00eb>\3\2"+
		"\2\2\u00ec\u00ed\7\61\2\2\u00ed@\3\2\2\2\u00ee\u00ef\7-\2\2\u00efB\3\2"+
		"\2\2\u00f0\u00f1\7/\2\2\u00f1D\3\2\2\2\u00f2\u00f3\7?\2\2\u00f3\u00f4"+
		"\7?\2\2\u00f4F\3\2\2\2\u00f5\u00f6\7#\2\2\u00f6\u00f7\7?\2\2\u00f7H\3"+
		"\2\2\2\u00f8\u00f9\7@\2\2\u00f9\u00fa\7?\2\2\u00faJ\3\2\2\2\u00fb\u00fc"+
		"\7>\2\2\u00fc\u00fd\7?\2\2\u00fdL\3\2\2\2\u00fe\u00ff\7@\2\2\u00ffN\3"+
		"\2\2\2\u0100\u0101\7>\2\2\u0101P\3\2\2\2\u0102\u0103\7(\2\2\u0103R\3\2"+
		"\2\2\u0104\u0105\7~\2\2\u0105T\3\2\2\2\u0106\u0107\7?\2\2\u0107V\3\2\2"+
		"\2\u0108\u0109\7@\2\2\u0109\u010a\7@\2\2\u010aX\3\2\2\2\u010b\u010c\7"+
		"<\2\2\u010cZ\3\2\2\2\u010d\u010e\7B\2\2\u010e\\\3\2\2\2\r\2\u009e\u00a3"+
		"\u00a9\u00ae\u00b4\u00bf\u00c5\u00cd\u00d7\u00e5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}