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
		T__9=10, T__10=11, T__11=12, T__12=13, D=14, IF=15, ELSE=16, FOR=17, ECHO=18, 
		INT_TYPE=19, FLOAT_TYPE=20, STRING_TYPE=21, SYMBOL=22, USERNAME=23, INT_NUMBER=24, 
		FLOAT_NUMBER=25, BOOLEAN=26, TEXT_STRING=27, WS=28, COMMENT=29, COMMENT2=30, 
		MUL=31, DIV=32, ADD=33, SUB=34, EQ=35, NEQ=36, GREQ=37, LESEQ=38, GREAT=39, 
		LESS=40, AND=41, OR=42, ASSIGN=43, MOVE=44, INHERIT=45, ROOM=46, USEROBJ=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", 
		"FLOAT_TYPE", "STRING_TYPE", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", 
		"BOOLEAN", "TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", 
		"SUB", "EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM", "USEROBJ"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'^'", "'['", "']'", "'new'", 
		"'#'", "'[]'", "'\n'", null, null, null, null, "'!'", null, null, null, 
		null, null, null, null, null, null, null, null, null, "'*'", "'/'", "'+'", 
		"'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&'", "'|'", "'='", 
		"'>>'", "':'", "'@'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", "FLOAT_TYPE", 
		"STRING_TYPE", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", 
		"TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", 
		"EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM", "USEROBJ"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u0119\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u00a0\n\27\3\27\7\27"+
		"\u00a3\n\27\f\27\16\27\u00a6\13\27\3\30\3\30\6\30\u00aa\n\30\r\30\16\30"+
		"\u00ab\3\31\6\31\u00af\n\31\r\31\16\31\u00b0\3\32\6\32\u00b4\n\32\r\32"+
		"\16\32\u00b5\3\32\3\32\6\32\u00ba\n\32\r\32\16\32\u00bb\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00c7\n\33\3\34\3\34\7\34\u00cb\n"+
		"\34\f\34\16\34\u00ce\13\34\3\34\3\34\3\35\6\35\u00d3\n\35\r\35\16\35\u00d4"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00dd\n\36\f\36\16\36\u00e0\13\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00eb\n\37\f\37\16"+
		"\37\u00ee\13\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%"+
		"\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/"+
		"\3/\3\60\3\60\3\60\4\u00cc\u00de\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61\3\2\24\4\2FFff\4\2KKkk\4\2HHhh\4\2GGgg\4\2NNnn\4\2UUuu\4\2Q"+
		"Qqq\4\2TTtt\4\2PPpp\4\2VVvv\4\2CCcc\5\2C\\aac|\7\2CEG\\aaceg|\6\2\62;"+
		"C\\aac|\3\2\62;\4\2WWww\5\2\13\13\17\17\"\"\3\2\f\f\u0123\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2"+
		"\2\2\7e\3\2\2\2\tg\3\2\2\2\13i\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2\21o\3\2"+
		"\2\2\23q\3\2\2\2\25s\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2\33|\3\2\2\2\35~\3"+
		"\2\2\2\37\u0080\3\2\2\2!\u0083\3\2\2\2#\u0088\3\2\2\2%\u008c\3\2\2\2\'"+
		"\u008e\3\2\2\2)\u0092\3\2\2\2+\u0098\3\2\2\2-\u009f\3\2\2\2/\u00a7\3\2"+
		"\2\2\61\u00ae\3\2\2\2\63\u00b3\3\2\2\2\65\u00c6\3\2\2\2\67\u00c8\3\2\2"+
		"\29\u00d2\3\2\2\2;\u00d8\3\2\2\2=\u00e6\3\2\2\2?\u00f1\3\2\2\2A\u00f3"+
		"\3\2\2\2C\u00f5\3\2\2\2E\u00f7\3\2\2\2G\u00f9\3\2\2\2I\u00fc\3\2\2\2K"+
		"\u00ff\3\2\2\2M\u0102\3\2\2\2O\u0105\3\2\2\2Q\u0107\3\2\2\2S\u0109\3\2"+
		"\2\2U\u010b\3\2\2\2W\u010d\3\2\2\2Y\u010f\3\2\2\2[\u0112\3\2\2\2]\u0114"+
		"\3\2\2\2_\u0116\3\2\2\2ab\7}\2\2b\4\3\2\2\2cd\7\177\2\2d\6\3\2\2\2ef\7"+
		"*\2\2f\b\3\2\2\2gh\7+\2\2h\n\3\2\2\2ij\7.\2\2j\f\3\2\2\2kl\7\60\2\2l\16"+
		"\3\2\2\2mn\7`\2\2n\20\3\2\2\2op\7]\2\2p\22\3\2\2\2qr\7_\2\2r\24\3\2\2"+
		"\2st\7p\2\2tu\7g\2\2uv\7y\2\2v\26\3\2\2\2wx\7%\2\2x\30\3\2\2\2yz\7]\2"+
		"\2z{\7_\2\2{\32\3\2\2\2|}\7\f\2\2}\34\3\2\2\2~\177\t\2\2\2\177\36\3\2"+
		"\2\2\u0080\u0081\t\3\2\2\u0081\u0082\t\4\2\2\u0082 \3\2\2\2\u0083\u0084"+
		"\t\5\2\2\u0084\u0085\t\6\2\2\u0085\u0086\t\7\2\2\u0086\u0087\t\5\2\2\u0087"+
		"\"\3\2\2\2\u0088\u0089\t\4\2\2\u0089\u008a\t\b\2\2\u008a\u008b\t\t\2\2"+
		"\u008b$\3\2\2\2\u008c\u008d\7#\2\2\u008d&\3\2\2\2\u008e\u008f\t\3\2\2"+
		"\u008f\u0090\t\n\2\2\u0090\u0091\t\13\2\2\u0091(\3\2\2\2\u0092\u0093\t"+
		"\4\2\2\u0093\u0094\t\6\2\2\u0094\u0095\t\b\2\2\u0095\u0096\t\f\2\2\u0096"+
		"\u0097\t\13\2\2\u0097*\3\2\2\2\u0098\u0099\t\7\2\2\u0099\u009a\t\13\2"+
		"\2\u009a\u009b\t\t\2\2\u009b,\3\2\2\2\u009c\u009d\t\2\2\2\u009d\u00a0"+
		"\t\r\2\2\u009e\u00a0\t\16\2\2\u009f\u009c\3\2\2\2\u009f\u009e\3\2\2\2"+
		"\u00a0\u00a4\3\2\2\2\u00a1\u00a3\t\17\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6"+
		"\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5.\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00a9\7&\2\2\u00a8\u00aa\t\17\2\2\u00a9\u00a8\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\60\3\2\2\2\u00ad\u00af\t\20\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2"+
		"\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\62\3\2\2\2\u00b2\u00b4"+
		"\t\20\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\7\60\2\2\u00b8\u00ba"+
		"\t\20\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\64\3\2\2\2\u00bd\u00be\t\13\2\2\u00be\u00bf"+
		"\t\t\2\2\u00bf\u00c0\t\21\2\2\u00c0\u00c7\t\5\2\2\u00c1\u00c2\t\4\2\2"+
		"\u00c2\u00c3\t\f\2\2\u00c3\u00c4\t\6\2\2\u00c4\u00c5\t\7\2\2\u00c5\u00c7"+
		"\t\5\2\2\u00c6\u00bd\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c7\66\3\2\2\2\u00c8"+
		"\u00cc\7$\2\2\u00c9\u00cb\13\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d0\7$\2\2\u00d08\3\2\2\2\u00d1\u00d3\t\22\2\2"+
		"\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\35\2\2\u00d7:\3\2\2\2\u00d8"+
		"\u00d9\7\61\2\2\u00d9\u00da\7,\2\2\u00da\u00de\3\2\2\2\u00db\u00dd\13"+
		"\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00df\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7,"+
		"\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\b\36\2\2\u00e5"+
		"<\3\2\2\2\u00e6\u00e7\7\61\2\2\u00e7\u00e8\7\61\2\2\u00e8\u00ec\3\2\2"+
		"\2\u00e9\u00eb\n\23\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ef\u00f0\b\37\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7,\2\2\u00f2@\3\2"+
		"\2\2\u00f3\u00f4\7\61\2\2\u00f4B\3\2\2\2\u00f5\u00f6\7-\2\2\u00f6D\3\2"+
		"\2\2\u00f7\u00f8\7/\2\2\u00f8F\3\2\2\2\u00f9\u00fa\7?\2\2\u00fa\u00fb"+
		"\7?\2\2\u00fbH\3\2\2\2\u00fc\u00fd\7#\2\2\u00fd\u00fe\7?\2\2\u00feJ\3"+
		"\2\2\2\u00ff\u0100\7@\2\2\u0100\u0101\7?\2\2\u0101L\3\2\2\2\u0102\u0103"+
		"\7>\2\2\u0103\u0104\7?\2\2\u0104N\3\2\2\2\u0105\u0106\7@\2\2\u0106P\3"+
		"\2\2\2\u0107\u0108\7>\2\2\u0108R\3\2\2\2\u0109\u010a\7(\2\2\u010aT\3\2"+
		"\2\2\u010b\u010c\7~\2\2\u010cV\3\2\2\2\u010d\u010e\7?\2\2\u010eX\3\2\2"+
		"\2\u010f\u0110\7@\2\2\u0110\u0111\7@\2\2\u0111Z\3\2\2\2\u0112\u0113\7"+
		"<\2\2\u0113\\\3\2\2\2\u0114\u0115\7B\2\2\u0115^\3\2\2\2\u0116\u0117\7"+
		"/\2\2\u0117\u0118\7@\2\2\u0118`\3\2\2\2\16\2\u009f\u00a4\u00ab\u00b0\u00b5"+
		"\u00bb\u00c6\u00cc\u00d4\u00de\u00ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}