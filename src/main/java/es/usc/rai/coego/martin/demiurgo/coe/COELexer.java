// Generated from COE.g4 by ANTLR 4.5.3
package es.usc.rai.coego.martin.demiurgo.coe;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class COELexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, D=13, IF=14, ELSE=15, FOR=16, ECHO=17, INT_TYPE=18, 
		FLOAT_TYPE=19, STRING_TYPE=20, TRUE=21, FALSE=22, SYMBOL=23, USERNAME=24, 
		INT_NUMBER=25, FLOAT_NUMBER=26, TEXT_STRING=27, WS=28, COMMENT=29, COMMENT2=30, 
		MUL=31, DIV=32, ADD=33, SUB=34, EQ=35, NEQ=36, GREQ=37, LESEQ=38, GREAT=39, 
		LESS=40, AND=41, OR=42, ASSIGN=43, MOVE=44, INHERIT=45, ROOM=46, USEROBJ=47, 
		INVENTORY=48, CONCAT=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", 
		"FLOAT_TYPE", "STRING_TYPE", "TRUE", "FALSE", "SYMBOL", "USERNAME", "INT_NUMBER", 
		"FLOAT_NUMBER", "TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", 
		"ADD", "SUB", "EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", 
		"ASSIGN", "MOVE", "INHERIT", "ROOM", "USEROBJ", "INVENTORY", "CONCAT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'['", "']'", "'new'", 
		"'#'", "'[]'", "'\n'", null, null, null, null, "'!'", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "'*'", "'/'", 
		"'+'", "'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&'", "'|'", 
		"'='", "'>>'", "':'", "'@'", "'->'", "'%'", "'++'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", "FLOAT_TYPE", "STRING_TYPE", 
		"TRUE", "FALSE", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", "TEXT_STRING", 
		"WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", 
		"GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", "MOVE", "INHERIT", 
		"ROOM", "USEROBJ", "INVENTORY", "CONCAT"
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


	public COELexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "COE.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u0120\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\5\30\u00ad\n\30\3\30\7\30\u00b0\n"+
		"\30\f\30\16\30\u00b3\13\30\3\31\3\31\6\31\u00b7\n\31\r\31\16\31\u00b8"+
		"\3\32\6\32\u00bc\n\32\r\32\16\32\u00bd\3\33\6\33\u00c1\n\33\r\33\16\33"+
		"\u00c2\3\33\3\33\6\33\u00c7\n\33\r\33\16\33\u00c8\3\34\3\34\7\34\u00cd"+
		"\n\34\f\34\16\34\u00d0\13\34\3\34\3\34\3\35\6\35\u00d5\n\35\r\35\16\35"+
		"\u00d6\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00df\n\36\f\36\16\36\u00e2"+
		"\13\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00ed\n\37\f"+
		"\37\16\37\u00f0\13\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%"+
		"\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3."+
		"\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\4\u00ce\u00e0\2\63\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63\3\2\24\4\2FFff\4\2K"+
		"Kkk\4\2HHhh\4\2GGgg\4\2NNnn\4\2UUuu\4\2QQqq\4\2TTtt\4\2PPpp\4\2VVvv\4"+
		"\2CCcc\4\2WWww\5\2C\\aac|\7\2CEG\\aaceg|\6\2\62;C\\aac|\3\2\62;\5\2\13"+
		"\13\17\17\"\"\3\2\f\f\u0129\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5g\3\2\2\2\7i"+
		"\3\2\2\2\tk\3\2\2\2\13m\3\2\2\2\ro\3\2\2\2\17q\3\2\2\2\21s\3\2\2\2\23"+
		"u\3\2\2\2\25y\3\2\2\2\27{\3\2\2\2\31~\3\2\2\2\33\u0080\3\2\2\2\35\u0082"+
		"\3\2\2\2\37\u0085\3\2\2\2!\u008a\3\2\2\2#\u008e\3\2\2\2%\u0090\3\2\2\2"+
		"\'\u0094\3\2\2\2)\u009a\3\2\2\2+\u009e\3\2\2\2-\u00a3\3\2\2\2/\u00ac\3"+
		"\2\2\2\61\u00b4\3\2\2\2\63\u00bb\3\2\2\2\65\u00c0\3\2\2\2\67\u00ca\3\2"+
		"\2\29\u00d4\3\2\2\2;\u00da\3\2\2\2=\u00e8\3\2\2\2?\u00f3\3\2\2\2A\u00f5"+
		"\3\2\2\2C\u00f7\3\2\2\2E\u00f9\3\2\2\2G\u00fb\3\2\2\2I\u00fe\3\2\2\2K"+
		"\u0101\3\2\2\2M\u0104\3\2\2\2O\u0107\3\2\2\2Q\u0109\3\2\2\2S\u010b\3\2"+
		"\2\2U\u010d\3\2\2\2W\u010f\3\2\2\2Y\u0111\3\2\2\2[\u0114\3\2\2\2]\u0116"+
		"\3\2\2\2_\u0118\3\2\2\2a\u011b\3\2\2\2c\u011d\3\2\2\2ef\7}\2\2f\4\3\2"+
		"\2\2gh\7\177\2\2h\6\3\2\2\2ij\7*\2\2j\b\3\2\2\2kl\7+\2\2l\n\3\2\2\2mn"+
		"\7.\2\2n\f\3\2\2\2op\7\60\2\2p\16\3\2\2\2qr\7]\2\2r\20\3\2\2\2st\7_\2"+
		"\2t\22\3\2\2\2uv\7p\2\2vw\7g\2\2wx\7y\2\2x\24\3\2\2\2yz\7%\2\2z\26\3\2"+
		"\2\2{|\7]\2\2|}\7_\2\2}\30\3\2\2\2~\177\7\f\2\2\177\32\3\2\2\2\u0080\u0081"+
		"\t\2\2\2\u0081\34\3\2\2\2\u0082\u0083\t\3\2\2\u0083\u0084\t\4\2\2\u0084"+
		"\36\3\2\2\2\u0085\u0086\t\5\2\2\u0086\u0087\t\6\2\2\u0087\u0088\t\7\2"+
		"\2\u0088\u0089\t\5\2\2\u0089 \3\2\2\2\u008a\u008b\t\4\2\2\u008b\u008c"+
		"\t\b\2\2\u008c\u008d\t\t\2\2\u008d\"\3\2\2\2\u008e\u008f\7#\2\2\u008f"+
		"$\3\2\2\2\u0090\u0091\t\3\2\2\u0091\u0092\t\n\2\2\u0092\u0093\t\13\2\2"+
		"\u0093&\3\2\2\2\u0094\u0095\t\4\2\2\u0095\u0096\t\6\2\2\u0096\u0097\t"+
		"\b\2\2\u0097\u0098\t\f\2\2\u0098\u0099\t\13\2\2\u0099(\3\2\2\2\u009a\u009b"+
		"\t\7\2\2\u009b\u009c\t\13\2\2\u009c\u009d\t\t\2\2\u009d*\3\2\2\2\u009e"+
		"\u009f\t\13\2\2\u009f\u00a0\t\t\2\2\u00a0\u00a1\t\r\2\2\u00a1\u00a2\t"+
		"\5\2\2\u00a2,\3\2\2\2\u00a3\u00a4\t\4\2\2\u00a4\u00a5\t\f\2\2\u00a5\u00a6"+
		"\t\6\2\2\u00a6\u00a7\t\7\2\2\u00a7\u00a8\t\5\2\2\u00a8.\3\2\2\2\u00a9"+
		"\u00aa\t\2\2\2\u00aa\u00ad\t\16\2\2\u00ab\u00ad\t\17\2\2\u00ac\u00a9\3"+
		"\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b1\3\2\2\2\u00ae\u00b0\t\20\2\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\60\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b6\7&\2\2\u00b5\u00b7"+
		"\t\20\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\62\3\2\2\2\u00ba\u00bc\t\21\2\2\u00bb\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\64\3\2\2\2\u00bf\u00c1\t\21\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2"+
		"\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6"+
		"\7\60\2\2\u00c5\u00c7\t\21\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2"+
		"\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\66\3\2\2\2\u00ca\u00ce"+
		"\7$\2\2\u00cb\u00cd\13\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d1\u00d2\7$\2\2\u00d28\3\2\2\2\u00d3\u00d5\t\22\2\2\u00d4\u00d3"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\b\35\2\2\u00d9:\3\2\2\2\u00da\u00db\7\61\2"+
		"\2\u00db\u00dc\7,\2\2\u00dc\u00e0\3\2\2\2\u00dd\u00df\13\2\2\2\u00de\u00dd"+
		"\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1"+
		"\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e5\7\61"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b\36\2\2\u00e7<\3\2\2\2\u00e8\u00e9"+
		"\7\61\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00ed\n\23\2"+
		"\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\b\37\2\2"+
		"\u00f2>\3\2\2\2\u00f3\u00f4\7,\2\2\u00f4@\3\2\2\2\u00f5\u00f6\7\61\2\2"+
		"\u00f6B\3\2\2\2\u00f7\u00f8\7-\2\2\u00f8D\3\2\2\2\u00f9\u00fa\7/\2\2\u00fa"+
		"F\3\2\2\2\u00fb\u00fc\7?\2\2\u00fc\u00fd\7?\2\2\u00fdH\3\2\2\2\u00fe\u00ff"+
		"\7#\2\2\u00ff\u0100\7?\2\2\u0100J\3\2\2\2\u0101\u0102\7@\2\2\u0102\u0103"+
		"\7?\2\2\u0103L\3\2\2\2\u0104\u0105\7>\2\2\u0105\u0106\7?\2\2\u0106N\3"+
		"\2\2\2\u0107\u0108\7@\2\2\u0108P\3\2\2\2\u0109\u010a\7>\2\2\u010aR\3\2"+
		"\2\2\u010b\u010c\7(\2\2\u010cT\3\2\2\2\u010d\u010e\7~\2\2\u010eV\3\2\2"+
		"\2\u010f\u0110\7?\2\2\u0110X\3\2\2\2\u0111\u0112\7@\2\2\u0112\u0113\7"+
		"@\2\2\u0113Z\3\2\2\2\u0114\u0115\7<\2\2\u0115\\\3\2\2\2\u0116\u0117\7"+
		"B\2\2\u0117^\3\2\2\2\u0118\u0119\7/\2\2\u0119\u011a\7@\2\2\u011a`\3\2"+
		"\2\2\u011b\u011c\7\'\2\2\u011cb\3\2\2\2\u011d\u011e\7-\2\2\u011e\u011f"+
		"\7-\2\2\u011fd\3\2\2\2\r\2\u00ac\u00b1\u00b8\u00bd\u00c2\u00c8\u00ce\u00d6"+
		"\u00e0\u00ee\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}