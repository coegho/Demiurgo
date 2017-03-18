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
		FALSE=24, NOT=25, INSTANCEOFSYMBOL=26, NULLOBJ=27, THROWKEY=28, STATICKEY=29, 
		SYMBOL=30, USERNAME=31, INT_NUMBER=32, FLOAT_NUMBER=33, TEXT_STRING=34, 
		WS=35, COMMENT=36, COMMENT2=37, MUL=38, DIV=39, ADD=40, SUB=41, EQ=42, 
		NEQ=43, GREQ=44, LESEQ=45, GREAT=46, LESS=47, AND=48, OR=49, ASSIGN=50, 
		MOVE=51, INHERIT=52, ROOM=53, USEROBJ=54, INVENTORY=55, CONCAT=56;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "D", "IF", "ELSE", "FOR", 
		"ECHO", "INT_TYPE", "FLOAT_TYPE", "STRING_TYPE", "TRUE", "FALSE", "NOT", 
		"INSTANCEOFSYMBOL", "NULLOBJ", "THROWKEY", "STATICKEY", "SYMBOL", "USERNAME", 
		"INT_NUMBER", "FLOAT_NUMBER", "TEXT_STRING", "WS", "COMMENT", "COMMENT2", 
		"MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", 
		"AND", "OR", "ASSIGN", "MOVE", "INHERIT", "ROOM", "USEROBJ", "INVENTORY", 
		"CONCAT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'$'", "'#'", "'['", "']'", 
		"'new'", "'..'", "'[]'", "'\n'", null, null, null, null, "'!'", null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", 
		"'>='", "'<='", "'>'", "'<'", "'&'", "'|'", "'='", "'>>'", "':'", "'@'", 
		"'->'", "'%'", "'++'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", "FLOAT_TYPE", 
		"STRING_TYPE", "TRUE", "FALSE", "NOT", "INSTANCEOFSYMBOL", "NULLOBJ", 
		"THROWKEY", "STATICKEY", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", 
		"TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", 
		"EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM", "USEROBJ", "INVENTORY", "CONCAT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2:\u0154\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\5\37\u00e1\n\37\3\37\7\37\u00e4\n\37\f\37\16\37\u00e7\13\37\3 \3"+
		" \6 \u00eb\n \r \16 \u00ec\3!\6!\u00f0\n!\r!\16!\u00f1\3\"\6\"\u00f5\n"+
		"\"\r\"\16\"\u00f6\3\"\3\"\6\"\u00fb\n\"\r\"\16\"\u00fc\3#\3#\7#\u0101"+
		"\n#\f#\16#\u0104\13#\3#\3#\3$\6$\u0109\n$\r$\16$\u010a\3$\3$\3%\3%\3%"+
		"\3%\7%\u0113\n%\f%\16%\u0116\13%\3%\3%\3%\3%\3%\3&\3&\3&\3&\7&\u0121\n"+
		"&\f&\16&\u0124\13&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3"+
		"-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3"+
		"\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\39\39\39\4\u0102\u0114"+
		"\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:\3\2\27\4\2FFff\4\2KKkk\4\2HHhh\4\2GGgg\4\2NNnn\4\2UUuu\4\2QQqq"+
		"\4\2TTtt\4\2PPpp\4\2VVvv\4\2CCcc\4\2WWww\4\2EEee\4\2JJjj\4\2YYyy\5\2C"+
		"\\aac|\7\2CEG\\aaceg|\6\2\62;C\\aac|\3\2\62;\5\2\13\13\17\17\"\"\3\2\f"+
		"\f\u015d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\3s\3\2\2\2\5u\3\2\2\2\7w\3\2\2\2\ty"+
		"\3\2\2\2\13{\3\2\2\2\r}\3\2\2\2\17\177\3\2\2\2\21\u0081\3\2\2\2\23\u0083"+
		"\3\2\2\2\25\u0085\3\2\2\2\27\u0087\3\2\2\2\31\u008b\3\2\2\2\33\u008e\3"+
		"\2\2\2\35\u0091\3\2\2\2\37\u0093\3\2\2\2!\u0095\3\2\2\2#\u0098\3\2\2\2"+
		"%\u009d\3\2\2\2\'\u00a1\3\2\2\2)\u00a3\3\2\2\2+\u00a7\3\2\2\2-\u00ad\3"+
		"\2\2\2/\u00b1\3\2\2\2\61\u00b6\3\2\2\2\63\u00bc\3\2\2\2\65\u00c0\3\2\2"+
		"\2\67\u00cb\3\2\2\29\u00d0\3\2\2\2;\u00d6\3\2\2\2=\u00e0\3\2\2\2?\u00e8"+
		"\3\2\2\2A\u00ef\3\2\2\2C\u00f4\3\2\2\2E\u00fe\3\2\2\2G\u0108\3\2\2\2I"+
		"\u010e\3\2\2\2K\u011c\3\2\2\2M\u0127\3\2\2\2O\u0129\3\2\2\2Q\u012b\3\2"+
		"\2\2S\u012d\3\2\2\2U\u012f\3\2\2\2W\u0132\3\2\2\2Y\u0135\3\2\2\2[\u0138"+
		"\3\2\2\2]\u013b\3\2\2\2_\u013d\3\2\2\2a\u013f\3\2\2\2c\u0141\3\2\2\2e"+
		"\u0143\3\2\2\2g\u0145\3\2\2\2i\u0148\3\2\2\2k\u014a\3\2\2\2m\u014c\3\2"+
		"\2\2o\u014f\3\2\2\2q\u0151\3\2\2\2st\7}\2\2t\4\3\2\2\2uv\7\177\2\2v\6"+
		"\3\2\2\2wx\7*\2\2x\b\3\2\2\2yz\7+\2\2z\n\3\2\2\2{|\7.\2\2|\f\3\2\2\2}"+
		"~\7\60\2\2~\16\3\2\2\2\177\u0080\7&\2\2\u0080\20\3\2\2\2\u0081\u0082\7"+
		"%\2\2\u0082\22\3\2\2\2\u0083\u0084\7]\2\2\u0084\24\3\2\2\2\u0085\u0086"+
		"\7_\2\2\u0086\26\3\2\2\2\u0087\u0088\7p\2\2\u0088\u0089\7g\2\2\u0089\u008a"+
		"\7y\2\2\u008a\30\3\2\2\2\u008b\u008c\7\60\2\2\u008c\u008d\7\60\2\2\u008d"+
		"\32\3\2\2\2\u008e\u008f\7]\2\2\u008f\u0090\7_\2\2\u0090\34\3\2\2\2\u0091"+
		"\u0092\7\f\2\2\u0092\36\3\2\2\2\u0093\u0094\t\2\2\2\u0094 \3\2\2\2\u0095"+
		"\u0096\t\3\2\2\u0096\u0097\t\4\2\2\u0097\"\3\2\2\2\u0098\u0099\t\5\2\2"+
		"\u0099\u009a\t\6\2\2\u009a\u009b\t\7\2\2\u009b\u009c\t\5\2\2\u009c$\3"+
		"\2\2\2\u009d\u009e\t\4\2\2\u009e\u009f\t\b\2\2\u009f\u00a0\t\t\2\2\u00a0"+
		"&\3\2\2\2\u00a1\u00a2\7#\2\2\u00a2(\3\2\2\2\u00a3\u00a4\t\3\2\2\u00a4"+
		"\u00a5\t\n\2\2\u00a5\u00a6\t\13\2\2\u00a6*\3\2\2\2\u00a7\u00a8\t\4\2\2"+
		"\u00a8\u00a9\t\6\2\2\u00a9\u00aa\t\b\2\2\u00aa\u00ab\t\f\2\2\u00ab\u00ac"+
		"\t\13\2\2\u00ac,\3\2\2\2\u00ad\u00ae\t\7\2\2\u00ae\u00af\t\13\2\2\u00af"+
		"\u00b0\t\t\2\2\u00b0.\3\2\2\2\u00b1\u00b2\t\13\2\2\u00b2\u00b3\t\t\2\2"+
		"\u00b3\u00b4\t\r\2\2\u00b4\u00b5\t\5\2\2\u00b5\60\3\2\2\2\u00b6\u00b7"+
		"\t\4\2\2\u00b7\u00b8\t\f\2\2\u00b8\u00b9\t\6\2\2\u00b9\u00ba\t\7\2\2\u00ba"+
		"\u00bb\t\5\2\2\u00bb\62\3\2\2\2\u00bc\u00bd\t\n\2\2\u00bd\u00be\t\b\2"+
		"\2\u00be\u00bf\t\13\2\2\u00bf\64\3\2\2\2\u00c0\u00c1\t\3\2\2\u00c1\u00c2"+
		"\t\n\2\2\u00c2\u00c3\t\7\2\2\u00c3\u00c4\t\13\2\2\u00c4\u00c5\t\f\2\2"+
		"\u00c5\u00c6\t\n\2\2\u00c6\u00c7\t\16\2\2\u00c7\u00c8\t\5\2\2\u00c8\u00c9"+
		"\t\b\2\2\u00c9\u00ca\t\4\2\2\u00ca\66\3\2\2\2\u00cb\u00cc\t\n\2\2\u00cc"+
		"\u00cd\t\r\2\2\u00cd\u00ce\t\6\2\2\u00ce\u00cf\t\6\2\2\u00cf8\3\2\2\2"+
		"\u00d0\u00d1\t\13\2\2\u00d1\u00d2\t\17\2\2\u00d2\u00d3\t\t\2\2\u00d3\u00d4"+
		"\t\b\2\2\u00d4\u00d5\t\20\2\2\u00d5:\3\2\2\2\u00d6\u00d7\t\7\2\2\u00d7"+
		"\u00d8\t\13\2\2\u00d8\u00d9\t\f\2\2\u00d9\u00da\t\13\2\2\u00da\u00db\t"+
		"\3\2\2\u00db\u00dc\t\16\2\2\u00dc<\3\2\2\2\u00dd\u00de\t\2\2\2\u00de\u00e1"+
		"\t\21\2\2\u00df\u00e1\t\22\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00df\3\2\2\2"+
		"\u00e1\u00e5\3\2\2\2\u00e2\u00e4\t\23\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6>\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00ea\7&\2\2\u00e9\u00eb\t\23\2\2\u00ea\u00e9\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"@\3\2\2\2\u00ee\u00f0\t\24\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2"+
		"\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2B\3\2\2\2\u00f3\u00f5\t"+
		"\24\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\7\60\2\2\u00f9\u00fb\t"+
		"\24\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fdD\3\2\2\2\u00fe\u0102\7$\2\2\u00ff\u0101\13\2\2\2"+
		"\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0103\3\2\2\2\u0102\u0100"+
		"\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7$\2\2\u0106"+
		"F\3\2\2\2\u0107\u0109\t\25\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2"+
		"\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d"+
		"\b$\2\2\u010dH\3\2\2\2\u010e\u010f\7\61\2\2\u010f\u0110\7,\2\2\u0110\u0114"+
		"\3\2\2\2\u0111\u0113\13\2\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2"+
		"\u0114\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0117\u0118\7,\2\2\u0118\u0119\7\61\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\b%\2\2\u011bJ\3\2\2\2\u011c\u011d\7\61\2\2\u011d\u011e\7\61\2\2"+
		"\u011e\u0122\3\2\2\2\u011f\u0121\n\26\2\2\u0120\u011f\3\2\2\2\u0121\u0124"+
		"\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0125\u0126\b&\2\2\u0126L\3\2\2\2\u0127\u0128\7,\2\2\u0128"+
		"N\3\2\2\2\u0129\u012a\7\61\2\2\u012aP\3\2\2\2\u012b\u012c\7-\2\2\u012c"+
		"R\3\2\2\2\u012d\u012e\7/\2\2\u012eT\3\2\2\2\u012f\u0130\7?\2\2\u0130\u0131"+
		"\7?\2\2\u0131V\3\2\2\2\u0132\u0133\7#\2\2\u0133\u0134\7?\2\2\u0134X\3"+
		"\2\2\2\u0135\u0136\7@\2\2\u0136\u0137\7?\2\2\u0137Z\3\2\2\2\u0138\u0139"+
		"\7>\2\2\u0139\u013a\7?\2\2\u013a\\\3\2\2\2\u013b\u013c\7@\2\2\u013c^\3"+
		"\2\2\2\u013d\u013e\7>\2\2\u013e`\3\2\2\2\u013f\u0140\7(\2\2\u0140b\3\2"+
		"\2\2\u0141\u0142\7~\2\2\u0142d\3\2\2\2\u0143\u0144\7?\2\2\u0144f\3\2\2"+
		"\2\u0145\u0146\7@\2\2\u0146\u0147\7@\2\2\u0147h\3\2\2\2\u0148\u0149\7"+
		"<\2\2\u0149j\3\2\2\2\u014a\u014b\7B\2\2\u014bl\3\2\2\2\u014c\u014d\7/"+
		"\2\2\u014d\u014e\7@\2\2\u014en\3\2\2\2\u014f\u0150\7\'\2\2\u0150p\3\2"+
		"\2\2\u0151\u0152\7-\2\2\u0152\u0153\7-\2\2\u0153r\3\2\2\2\r\2\u00e0\u00e5"+
		"\u00ec\u00f1\u00f6\u00fc\u0102\u010a\u0114\u0122\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}