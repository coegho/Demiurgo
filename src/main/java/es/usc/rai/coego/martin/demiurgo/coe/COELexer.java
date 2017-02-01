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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, D=15, IF=16, ELSE=17, 
		FOR=18, ECHO=19, INT_TYPE=20, FLOAT_TYPE=21, STRING_TYPE=22, TRUE=23, 
		FALSE=24, NOT=25, INSTANCEOFSYMBOL=26, NULLOBJ=27, SYMBOL=28, USERNAME=29, 
		INT_NUMBER=30, FLOAT_NUMBER=31, TEXT_STRING=32, WS=33, COMMENT=34, COMMENT2=35, 
		MUL=36, DIV=37, ADD=38, SUB=39, EQ=40, NEQ=41, GREQ=42, LESEQ=43, GREAT=44, 
		LESS=45, AND=46, OR=47, ASSIGN=48, MOVE=49, INHERIT=50, ROOM=51, USEROBJ=52, 
		INVENTORY=53, CONCAT=54;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "D", "IF", "ELSE", "FOR", 
		"ECHO", "INT_TYPE", "FLOAT_TYPE", "STRING_TYPE", "TRUE", "FALSE", "NOT", 
		"INSTANCEOFSYMBOL", "NULLOBJ", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", 
		"TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", 
		"EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM", "USEROBJ", "INVENTORY", "CONCAT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'$'", "'#'", "'['", "']'", 
		"'new'", "'..'", "'[]'", "'\n'", null, null, null, null, "'!'", null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>='", 
		"'<='", "'>'", "'<'", "'&'", "'|'", "'='", "'>>'", "':'", "'@'", "'->'", 
		"'%'", "'++'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", "FLOAT_TYPE", 
		"STRING_TYPE", "TRUE", "FALSE", "NOT", "INSTANCEOFSYMBOL", "NULLOBJ", 
		"SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", "TEXT_STRING", "WS", 
		"COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", "GREQ", 
		"LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", "MOVE", "INHERIT", "ROOM", 
		"USEROBJ", "INVENTORY", "CONCAT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\28\u0143\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\5\35\u00d0\n\35\3\35\7\35\u00d3\n\35\f\35\16\35\u00d6\13\35\3\36\3\36"+
		"\6\36\u00da\n\36\r\36\16\36\u00db\3\37\6\37\u00df\n\37\r\37\16\37\u00e0"+
		"\3 \6 \u00e4\n \r \16 \u00e5\3 \3 \6 \u00ea\n \r \16 \u00eb\3!\3!\7!\u00f0"+
		"\n!\f!\16!\u00f3\13!\3!\3!\3\"\6\"\u00f8\n\"\r\"\16\"\u00f9\3\"\3\"\3"+
		"#\3#\3#\3#\7#\u0102\n#\f#\16#\u0105\13#\3#\3#\3#\3#\3#\3$\3$\3$\3$\7$"+
		"\u0110\n$\f$\16$\u0113\13$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3"+
		"*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67\4"+
		"\u00f1\u0103\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8\3\2\25\4\2FFff\4\2KKkk\4\2HHhh\4\2GGgg\4\2NNnn\4\2UUuu"+
		"\4\2QQqq\4\2TTtt\4\2PPpp\4\2VVvv\4\2CCcc\4\2WWww\4\2EEee\5\2C\\aac|\7"+
		"\2CEG\\aaceg|\6\2\62;C\\aac|\3\2\62;\5\2\13\13\17\17\"\"\3\2\f\f\u014c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\3o\3\2\2\2\5q\3\2\2\2\7s\3\2\2\2\tu\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2"+
		"\17{\3\2\2\2\21}\3\2\2\2\23\177\3\2\2\2\25\u0081\3\2\2\2\27\u0083\3\2"+
		"\2\2\31\u0087\3\2\2\2\33\u008a\3\2\2\2\35\u008d\3\2\2\2\37\u008f\3\2\2"+
		"\2!\u0091\3\2\2\2#\u0094\3\2\2\2%\u0099\3\2\2\2\'\u009d\3\2\2\2)\u009f"+
		"\3\2\2\2+\u00a3\3\2\2\2-\u00a9\3\2\2\2/\u00ad\3\2\2\2\61\u00b2\3\2\2\2"+
		"\63\u00b8\3\2\2\2\65\u00bc\3\2\2\2\67\u00c7\3\2\2\29\u00cf\3\2\2\2;\u00d7"+
		"\3\2\2\2=\u00de\3\2\2\2?\u00e3\3\2\2\2A\u00ed\3\2\2\2C\u00f7\3\2\2\2E"+
		"\u00fd\3\2\2\2G\u010b\3\2\2\2I\u0116\3\2\2\2K\u0118\3\2\2\2M\u011a\3\2"+
		"\2\2O\u011c\3\2\2\2Q\u011e\3\2\2\2S\u0121\3\2\2\2U\u0124\3\2\2\2W\u0127"+
		"\3\2\2\2Y\u012a\3\2\2\2[\u012c\3\2\2\2]\u012e\3\2\2\2_\u0130\3\2\2\2a"+
		"\u0132\3\2\2\2c\u0134\3\2\2\2e\u0137\3\2\2\2g\u0139\3\2\2\2i\u013b\3\2"+
		"\2\2k\u013e\3\2\2\2m\u0140\3\2\2\2op\7}\2\2p\4\3\2\2\2qr\7\177\2\2r\6"+
		"\3\2\2\2st\7*\2\2t\b\3\2\2\2uv\7+\2\2v\n\3\2\2\2wx\7.\2\2x\f\3\2\2\2y"+
		"z\7\60\2\2z\16\3\2\2\2{|\7&\2\2|\20\3\2\2\2}~\7%\2\2~\22\3\2\2\2\177\u0080"+
		"\7]\2\2\u0080\24\3\2\2\2\u0081\u0082\7_\2\2\u0082\26\3\2\2\2\u0083\u0084"+
		"\7p\2\2\u0084\u0085\7g\2\2\u0085\u0086\7y\2\2\u0086\30\3\2\2\2\u0087\u0088"+
		"\7\60\2\2\u0088\u0089\7\60\2\2\u0089\32\3\2\2\2\u008a\u008b\7]\2\2\u008b"+
		"\u008c\7_\2\2\u008c\34\3\2\2\2\u008d\u008e\7\f\2\2\u008e\36\3\2\2\2\u008f"+
		"\u0090\t\2\2\2\u0090 \3\2\2\2\u0091\u0092\t\3\2\2\u0092\u0093\t\4\2\2"+
		"\u0093\"\3\2\2\2\u0094\u0095\t\5\2\2\u0095\u0096\t\6\2\2\u0096\u0097\t"+
		"\7\2\2\u0097\u0098\t\5\2\2\u0098$\3\2\2\2\u0099\u009a\t\4\2\2\u009a\u009b"+
		"\t\b\2\2\u009b\u009c\t\t\2\2\u009c&\3\2\2\2\u009d\u009e\7#\2\2\u009e("+
		"\3\2\2\2\u009f\u00a0\t\3\2\2\u00a0\u00a1\t\n\2\2\u00a1\u00a2\t\13\2\2"+
		"\u00a2*\3\2\2\2\u00a3\u00a4\t\4\2\2\u00a4\u00a5\t\6\2\2\u00a5\u00a6\t"+
		"\b\2\2\u00a6\u00a7\t\f\2\2\u00a7\u00a8\t\13\2\2\u00a8,\3\2\2\2\u00a9\u00aa"+
		"\t\7\2\2\u00aa\u00ab\t\13\2\2\u00ab\u00ac\t\t\2\2\u00ac.\3\2\2\2\u00ad"+
		"\u00ae\t\13\2\2\u00ae\u00af\t\t\2\2\u00af\u00b0\t\r\2\2\u00b0\u00b1\t"+
		"\5\2\2\u00b1\60\3\2\2\2\u00b2\u00b3\t\4\2\2\u00b3\u00b4\t\f\2\2\u00b4"+
		"\u00b5\t\6\2\2\u00b5\u00b6\t\7\2\2\u00b6\u00b7\t\5\2\2\u00b7\62\3\2\2"+
		"\2\u00b8\u00b9\t\n\2\2\u00b9\u00ba\t\b\2\2\u00ba\u00bb\t\13\2\2\u00bb"+
		"\64\3\2\2\2\u00bc\u00bd\t\3\2\2\u00bd\u00be\t\n\2\2\u00be\u00bf\t\7\2"+
		"\2\u00bf\u00c0\t\13\2\2\u00c0\u00c1\t\f\2\2\u00c1\u00c2\t\n\2\2\u00c2"+
		"\u00c3\t\16\2\2\u00c3\u00c4\t\5\2\2\u00c4\u00c5\t\b\2\2\u00c5\u00c6\t"+
		"\4\2\2\u00c6\66\3\2\2\2\u00c7\u00c8\t\n\2\2\u00c8\u00c9\t\r\2\2\u00c9"+
		"\u00ca\t\6\2\2\u00ca\u00cb\t\6\2\2\u00cb8\3\2\2\2\u00cc\u00cd\t\2\2\2"+
		"\u00cd\u00d0\t\17\2\2\u00ce\u00d0\t\20\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00ce"+
		"\3\2\2\2\u00d0\u00d4\3\2\2\2\u00d1\u00d3\t\21\2\2\u00d2\u00d1\3\2\2\2"+
		"\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5:\3"+
		"\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d9\7&\2\2\u00d8\u00da\t\21\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc<\3\2\2\2\u00dd\u00df\t\22\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1>\3\2\2\2\u00e2"+
		"\u00e4\t\22\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3"+
		"\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\7\60\2\2\u00e8"+
		"\u00ea\t\22\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3"+
		"\2\2\2\u00eb\u00ec\3\2\2\2\u00ec@\3\2\2\2\u00ed\u00f1\7$\2\2\u00ee\u00f0"+
		"\13\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00f2\3\2\2\2"+
		"\u00f1\u00ef\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5"+
		"\7$\2\2\u00f5B\3\2\2\2\u00f6\u00f8\t\23\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fc\b\"\2\2\u00fcD\3\2\2\2\u00fd\u00fe\7\61\2\2\u00fe\u00ff"+
		"\7,\2\2\u00ff\u0103\3\2\2\2\u0100\u0102\13\2\2\2\u0101\u0100\3\2\2\2\u0102"+
		"\u0105\3\2\2\2\u0103\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0106\3\2"+
		"\2\2\u0105\u0103\3\2\2\2\u0106\u0107\7,\2\2\u0107\u0108\7\61\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010a\b#\2\2\u010aF\3\2\2\2\u010b\u010c\7\61\2\2"+
		"\u010c\u010d\7\61\2\2\u010d\u0111\3\2\2\2\u010e\u0110\n\24\2\2\u010f\u010e"+
		"\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\b$\2\2\u0115H\3\2\2\2\u0116"+
		"\u0117\7,\2\2\u0117J\3\2\2\2\u0118\u0119\7\61\2\2\u0119L\3\2\2\2\u011a"+
		"\u011b\7-\2\2\u011bN\3\2\2\2\u011c\u011d\7/\2\2\u011dP\3\2\2\2\u011e\u011f"+
		"\7?\2\2\u011f\u0120\7?\2\2\u0120R\3\2\2\2\u0121\u0122\7#\2\2\u0122\u0123"+
		"\7?\2\2\u0123T\3\2\2\2\u0124\u0125\7@\2\2\u0125\u0126\7?\2\2\u0126V\3"+
		"\2\2\2\u0127\u0128\7>\2\2\u0128\u0129\7?\2\2\u0129X\3\2\2\2\u012a\u012b"+
		"\7@\2\2\u012bZ\3\2\2\2\u012c\u012d\7>\2\2\u012d\\\3\2\2\2\u012e\u012f"+
		"\7(\2\2\u012f^\3\2\2\2\u0130\u0131\7~\2\2\u0131`\3\2\2\2\u0132\u0133\7"+
		"?\2\2\u0133b\3\2\2\2\u0134\u0135\7@\2\2\u0135\u0136\7@\2\2\u0136d\3\2"+
		"\2\2\u0137\u0138\7<\2\2\u0138f\3\2\2\2\u0139\u013a\7B\2\2\u013ah\3\2\2"+
		"\2\u013b\u013c\7/\2\2\u013c\u013d\7@\2\2\u013dj\3\2\2\2\u013e\u013f\7"+
		"\'\2\2\u013fl\3\2\2\2\u0140\u0141\7-\2\2\u0141\u0142\7-\2\2\u0142n\3\2"+
		"\2\2\r\2\u00cf\u00d4\u00db\u00e0\u00e5\u00eb\u00f1\u00f9\u0103\u0111\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}