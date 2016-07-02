// Generated from Linguaxe.g4 by ANTLR 4.5
package linguaxe;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LinguaxeParser extends Parser {
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
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_fields = 2, RULE_var_decl = 3, RULE_methods = 4, 
		RULE_method = 5, RULE_args = 6, RULE_code = 7, RULE_line = 8, RULE_variable = 9, 
		RULE_function = 10, RULE_operation = 11, RULE_parens = 12, RULE_new_obj = 13, 
		RULE_sharp_identifier = 14, RULE_room = 15, RULE_room_path = 16, RULE_exp_if = 17, 
		RULE_exp_for = 18, RULE_exp_user = 19, RULE_username = 20, RULE_data_type = 21, 
		RULE_nl = 22;
	public static final String[] ruleNames = {
		"s", "class_def", "fields", "var_decl", "methods", "method", "args", "code", 
		"line", "variable", "function", "operation", "parens", "new_obj", "sharp_identifier", 
		"room", "room_path", "exp_if", "exp_for", "exp_user", "username", "data_type", 
		"nl"
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

	@Override
	public String getGrammarFileName() { return "Linguaxe.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LinguaxeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SContext extends ParserRuleContext {
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
	 
		public SContext() { }
		public void copyFrom(SContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SCodeContext extends SContext {
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public SCodeContext(SContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitSCode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDefContext extends SContext {
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public ClassDefContext(SContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			setState(48);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				class_def();
				}
				break;
			case 2:
				_localctx = new SCodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				code();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_defContext extends ParserRuleContext {
		public List<TerminalNode> SYMBOL() { return getTokens(LinguaxeParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(LinguaxeParser.SYMBOL, i);
		}
		public TerminalNode INHERIT() { return getToken(LinguaxeParser.INHERIT, 0); }
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public MethodsContext methods() {
			return getRuleContext(MethodsContext.class,0);
		}
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitClass_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(SYMBOL);
			setState(53);
			_la = _input.LA(1);
			if (_la==INHERIT) {
				{
				setState(51);
				match(INHERIT);
				setState(52);
				match(SYMBOL);
				}
			}

			setState(56);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(55);
				nl();
				}
			}

			setState(58);
			match(T__0);
			setState(60);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(59);
				nl();
				}
			}

			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(62);
				fields();
				}
				break;
			}
			setState(66);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << SYMBOL))) != 0)) {
				{
				setState(65);
				methods();
				}
			}

			setState(68);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldsContext extends ParserRuleContext {
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fields);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(70);
					var_decl();
					setState(71);
					nl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(75); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public TerminalNode ASSIGN() { return getToken(LinguaxeParser.ASSIGN, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			data_type();
			setState(78);
			match(SYMBOL);
			setState(81);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(79);
				match(ASSIGN);
				setState(80);
				operation(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodsContext extends ParserRuleContext {
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public MethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methods; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitMethods(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodsContext methods() throws RecognitionException {
		MethodsContext _localctx = new MethodsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methods);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				method();
				setState(85);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(84);
					nl();
					}
				}

				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << SYMBOL))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public Token metname;
		public List<TerminalNode> SYMBOL() { return getTokens(LinguaxeParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(LinguaxeParser.SYMBOL, i);
		}
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(LinguaxeParser.ASSIGN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(91);
				data_type();
				setState(92);
				match(SYMBOL);
				setState(93);
				match(ASSIGN);
				}
				break;
			}
			setState(97);
			((MethodContext)_localctx).metname = match(SYMBOL);
			setState(98);
			match(T__2);
			setState(100);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << SYMBOL))) != 0)) {
				{
				setState(99);
				args();
				}
			}

			setState(102);
			match(T__3);
			setState(104);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(103);
				nl();
				}
			}

			setState(106);
			match(T__0);
			setState(108);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(107);
				code();
				}
			}

			setState(110);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public List<TerminalNode> SYMBOL() { return getTokens(LinguaxeParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(LinguaxeParser.SYMBOL, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			data_type();
			setState(113);
			match(SYMBOL);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(114);
				match(T__4);
				setState(115);
				data_type();
				setState(116);
				match(SYMBOL);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_code);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(123);
				nl();
				}
			}

			setState(126);
			line();
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(127);
					nl();
					setState(128);
					line();
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(136);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(135);
				nl();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public Exp_ifContext exp_if() {
			return getRuleContext(Exp_ifContext.class,0);
		}
		public Exp_forContext exp_for() {
			return getRuleContext(Exp_forContext.class,0);
		}
		public Exp_userContext exp_user() {
			return getRuleContext(Exp_userContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_line);
		try {
			setState(142);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				exp_if();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				exp_for();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				exp_user();
				}
				break;
			case T__0:
			case T__2:
			case T__9:
			case T__10:
			case T__13:
			case T__14:
			case T__15:
			case D:
			case SYMBOL:
			case INT_NUMBER:
			case FLOAT_NUMBER:
			case BOOLEAN:
			case TEXT_STRING:
			case SUB:
			case ROOM:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				operation(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	 
		public VariableContext() { }
		public void copyFrom(VariableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RootVariableContext extends VariableContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public RootVariableContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitRootVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntermediateVariableContext extends VariableContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public IntermediateVariableContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitIntermediateVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		return variable(0);
	}

	private VariableContext variable(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableContext _localctx = new VariableContext(_ctx, _parentState);
		VariableContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_variable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RootVariableContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(145);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IntermediateVariableContext(new VariableContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_variable);
					setState(147);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(148);
					match(T__5);
					setState(149);
					match(SYMBOL);
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(155);
				variable(0);
				setState(156);
				match(T__5);
				}
				break;
			}
			setState(160);
			match(SYMBOL);
			setState(161);
			match(T__2);
			setState(170);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(162);
				operation(0);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(163);
					match(T__4);
					setState(164);
					operation(0);
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(172);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
	 
		public OperationContext() { }
		public void copyFrom(OperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensOpContext extends OperationContext {
		public ParensContext parens() {
			return getRuleContext(ParensContext.class,0);
		}
		public ParensOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitParensOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareContext extends OperationContext {
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode NEQ() { return getToken(LinguaxeParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(LinguaxeParser.EQ, 0); }
		public TerminalNode GREQ() { return getToken(LinguaxeParser.GREQ, 0); }
		public TerminalNode LESEQ() { return getToken(LinguaxeParser.LESEQ, 0); }
		public TerminalNode LESS() { return getToken(LinguaxeParser.LESS, 0); }
		public TerminalNode GREAT() { return getToken(LinguaxeParser.GREAT, 0); }
		public CompareContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MoveContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode MOVE() { return getToken(LinguaxeParser.MOVE, 0); }
		public MoveContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitMove(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends OperationContext {
		public TerminalNode BOOLEAN() { return getToken(LinguaxeParser.BOOLEAN, 0); }
		public BoolContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends OperationContext {
		public TerminalNode TEXT_STRING() { return getToken(LinguaxeParser.TEXT_STRING, 0); }
		public StringContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RoomOpContext extends OperationContext {
		public RoomContext room() {
			return getRuleContext(RoomContext.class,0);
		}
		public RoomOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitRoomOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends OperationContext {
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode MUL() { return getToken(LinguaxeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(LinguaxeParser.DIV, 0); }
		public MulDivContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends OperationContext {
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode ADD() { return getToken(LinguaxeParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(LinguaxeParser.SUB, 0); }
		public AddSubContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableOpContext extends OperationContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitVariableOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiceContext extends OperationContext {
		public TerminalNode D() { return getToken(LinguaxeParser.D, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public DiceContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitDice(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public IndexContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewObjContext extends OperationContext {
		public New_objContext new_obj() {
			return getRuleContext(New_objContext.class,0);
		}
		public NewObjContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitNewObj(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatContext extends OperationContext {
		public TerminalNode FLOAT_NUMBER() { return getToken(LinguaxeParser.FLOAT_NUMBER, 0); }
		public FloatContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ListContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexAssignContext extends OperationContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(LinguaxeParser.ASSIGN, 0); }
		public IndexAssignContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitIndexAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends OperationContext {
		public TerminalNode INT_NUMBER() { return getToken(LinguaxeParser.INT_NUMBER, 0); }
		public IntContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SharpContext extends OperationContext {
		public Sharp_identifierContext sharp_identifier() {
			return getRuleContext(Sharp_identifierContext.class,0);
		}
		public SharpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitSharp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDiceContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode D() { return getToken(LinguaxeParser.D, 0); }
		public MultDiceContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitMultDice(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegativeContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public NegativeContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionOpContext extends OperationContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitFunctionOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicContext extends OperationContext {
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode OR() { return getToken(LinguaxeParser.OR, 0); }
		public TerminalNode AND() { return getToken(LinguaxeParser.AND, 0); }
		public LogicContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclContext extends OperationContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public VarDeclContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends OperationContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(LinguaxeParser.ASSIGN, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AssignContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExponentContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ExponentContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitExponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		return operation(0);
	}

	private OperationContext operation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OperationContext _localctx = new OperationContext(_ctx, _parentState);
		OperationContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_operation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(175);
				match(SUB);
				setState(176);
				operation(23);
				}
				break;
			case 2:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(D);
				setState(178);
				operation(22);
				}
				break;
			case 3:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				variable(0);
				setState(180);
				match(ASSIGN);
				setState(181);
				operation(15);
				}
				break;
			case 4:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				function();
				}
				break;
			case 5:
				{
				_localctx = new IndexAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				variable(0);
				setState(185);
				match(T__7);
				setState(186);
				operation(0);
				setState(187);
				match(T__8);
				setState(188);
				match(ASSIGN);
				setState(189);
				operation(0);
				}
				break;
			case 6:
				{
				_localctx = new VariableOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				variable(0);
				}
				break;
			case 7:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				new_obj();
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(INT_NUMBER);
				}
				break;
			case 9:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(FLOAT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(BOOLEAN);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(TEXT_STRING);
				}
				break;
			case 12:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				sharp_identifier();
				}
				break;
			case 13:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				room();
				}
				break;
			case 14:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				parens();
				}
				break;
			case 15:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(T__0);
				setState(209);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
					{
					setState(201);
					operation(0);
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(202);
						match(T__4);
						setState(203);
						operation(0);
						}
						}
						setState(208);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(211);
				match(T__1);
				}
				break;
			case 16:
				{
				_localctx = new VarDeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				var_decl();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(241);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new MultDiceContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(215);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(216);
						match(D);
						setState(217);
						operation(22);
						}
						break;
					case 2:
						{
						_localctx = new ExponentContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(218);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(219);
						match(T__6);
						setState(220);
						operation(21);
						}
						break;
					case 3:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(221);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(222);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(223);
						operation(20);
						}
						break;
					case 4:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(224);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(225);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(226);
						operation(19);
						}
						break;
					case 5:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(227);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(228);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(229);
						operation(18);
						}
						break;
					case 6:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(230);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(231);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(232);
						operation(17);
						}
						break;
					case 7:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(233);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(234);
						match(MOVE);
						setState(235);
						operation(14);
						}
						break;
					case 8:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(236);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(237);
						match(T__7);
						setState(238);
						operation(0);
						setState(239);
						match(T__8);
						}
						break;
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParensContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ParensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parens; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParensContext parens() throws RecognitionException {
		ParensContext _localctx = new ParensContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__2);
			setState(247);
			operation(0);
			setState(248);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class New_objContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public New_objContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_obj; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitNew_obj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_objContext new_obj() throws RecognitionException {
		New_objContext _localctx = new New_objContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_new_obj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__9);
			setState(251);
			match(SYMBOL);
			setState(252);
			match(T__2);
			setState(261);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(253);
				operation(0);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(254);
					match(T__4);
					setState(255);
					operation(0);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(263);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sharp_identifierContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(LinguaxeParser.INT_NUMBER, 0); }
		public Sharp_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sharp_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitSharp_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sharp_identifierContext sharp_identifier() throws RecognitionException {
		Sharp_identifierContext _localctx = new Sharp_identifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sharp_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__10);
			setState(266);
			match(INT_NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoomContext extends ParserRuleContext {
		public TerminalNode ROOM() { return getToken(LinguaxeParser.ROOM, 0); }
		public Room_pathContext room_path() {
			return getRuleContext(Room_pathContext.class,0);
		}
		public RoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoomContext room() throws RecognitionException {
		RoomContext _localctx = new RoomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(ROOM);
			setState(269);
			room_path(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Room_pathContext extends ParserRuleContext {
		public Room_pathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_path; }
	 
		public Room_pathContext() { }
		public void copyFrom(Room_pathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RootRoomContext extends Room_pathContext {
		public RootRoomContext(Room_pathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitRootRoom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeafRoomContext extends Room_pathContext {
		public Room_pathContext room_path() {
			return getRuleContext(Room_pathContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public LeafRoomContext(Room_pathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitLeafRoom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelativeRoomContext extends Room_pathContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public RelativeRoomContext(Room_pathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitRelativeRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Room_pathContext room_path() throws RecognitionException {
		return room_path(0);
	}

	private Room_pathContext room_path(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Room_pathContext _localctx = new Room_pathContext(_ctx, _parentState);
		Room_pathContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_room_path, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new RelativeRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(272);
				match(SYMBOL);
				}
				break;
			case 2:
				{
				_localctx = new RootRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LeafRoomContext(new Room_pathContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_room_path);
					setState(276);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(277);
					match(DIV);
					setState(278);
					match(SYMBOL);
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp_ifContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LinguaxeParser.IF, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LinguaxeParser.ELSE, 0); }
		public Exp_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_if; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitExp_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_ifContext exp_if() throws RecognitionException {
		Exp_ifContext _localctx = new Exp_ifContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exp_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(IF);
			setState(285);
			match(T__2);
			setState(286);
			operation(0);
			setState(287);
			match(T__3);
			setState(289);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(288);
				nl();
				}
			}

			setState(291);
			match(T__0);
			setState(292);
			code();
			setState(293);
			match(T__1);
			setState(305);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(295);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(294);
					nl();
					}
				}

				setState(297);
				match(ELSE);
				setState(299);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(298);
					nl();
					}
				}

				setState(301);
				match(T__0);
				setState(302);
				code();
				setState(303);
				match(T__1);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LinguaxeParser.FOR, 0); }
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
		}
		public Exp_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_for; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitExp_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_forContext exp_for() throws RecognitionException {
		Exp_forContext _localctx = new Exp_forContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exp_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(FOR);
			setState(308);
			match(T__2);
			setState(309);
			match(SYMBOL);
			setState(310);
			match(INHERIT);
			setState(311);
			operation(0);
			setState(312);
			match(T__3);
			setState(314);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(313);
				nl();
				}
			}

			setState(316);
			match(T__0);
			setState(317);
			code();
			setState(318);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_userContext extends ParserRuleContext {
		public UsernameContext username() {
			return getRuleContext(UsernameContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Exp_userContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_user; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitExp_user(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_userContext exp_user() throws RecognitionException {
		Exp_userContext _localctx = new Exp_userContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exp_user);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			username();
			setState(321);
			match(T__11);
			setState(322);
			operation(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsernameContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public UsernameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_username; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitUsername(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsernameContext username() throws RecognitionException {
		UsernameContext _localctx = new UsernameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_username);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(T__12);
			setState(325);
			match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_typeContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitData_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_data_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << SYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NlContext extends ParserRuleContext {
		public NlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitNl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NlContext nl() throws RecognitionException {
		NlContext _localctx = new NlContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_nl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(329);
				match(T__16);
				}
				}
				setState(332); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return variable_sempred((VariableContext)_localctx, predIndex);
		case 11:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 16:
			return room_path_sempred((Room_pathContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variable_sempred(VariableContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean operation_sempred(OperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 21);
		case 2:
			return precpred(_ctx, 20);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 11);
		}
		return true;
	}
	private boolean room_path_sempred(Room_pathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u0151\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\5"+
		"\2\63\n\2\3\3\3\3\3\3\5\38\n\3\3\3\5\3;\n\3\3\3\3\3\5\3?\n\3\3\3\5\3B"+
		"\n\3\3\3\5\3E\n\3\3\3\3\3\3\4\3\4\3\4\6\4L\n\4\r\4\16\4M\3\5\3\5\3\5\3"+
		"\5\5\5T\n\5\3\6\3\6\5\6X\n\6\6\6Z\n\6\r\6\16\6[\3\7\3\7\3\7\3\7\5\7b\n"+
		"\7\3\7\3\7\3\7\5\7g\n\7\3\7\3\7\5\7k\n\7\3\7\3\7\5\7o\n\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\7\by\n\b\f\b\16\b|\13\b\3\t\5\t\177\n\t\3\t\3\t\3"+
		"\t\3\t\7\t\u0085\n\t\f\t\16\t\u0088\13\t\3\t\5\t\u008b\n\t\3\n\3\n\3\n"+
		"\3\n\5\n\u0091\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0099\n\13\f\13"+
		"\16\13\u009c\13\13\3\f\3\f\3\f\5\f\u00a1\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a8"+
		"\n\f\f\f\16\f\u00ab\13\f\5\f\u00ad\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00cf\n\r\f\r\16\r\u00d2\13\r\5\r\u00d4"+
		"\n\r\3\r\3\r\5\r\u00d8\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f4"+
		"\n\r\f\r\16\r\u00f7\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u0103\n\17\f\17\16\17\u0106\13\17\5\17\u0108\n\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u0115\n\22\3\22\3\22"+
		"\3\22\7\22\u011a\n\22\f\22\16\22\u011d\13\22\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0124\n\23\3\23\3\23\3\23\3\23\5\23\u012a\n\23\3\23\3\23\5\23\u012e"+
		"\n\23\3\23\3\23\3\23\3\23\5\23\u0134\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u013d\n\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\30\6\30\u014d\n\30\r\30\16\30\u014e\3\30\2\5\24\30\""+
		"\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\7\3\2 !\3\2\"#\3"+
		"\2$)\3\2*+\4\2\20\22\30\30\u0175\2\62\3\2\2\2\4\64\3\2\2\2\6K\3\2\2\2"+
		"\bO\3\2\2\2\nY\3\2\2\2\fa\3\2\2\2\16r\3\2\2\2\20~\3\2\2\2\22\u0090\3\2"+
		"\2\2\24\u0092\3\2\2\2\26\u00a0\3\2\2\2\30\u00d7\3\2\2\2\32\u00f8\3\2\2"+
		"\2\34\u00fc\3\2\2\2\36\u010b\3\2\2\2 \u010e\3\2\2\2\"\u0114\3\2\2\2$\u011e"+
		"\3\2\2\2&\u0135\3\2\2\2(\u0142\3\2\2\2*\u0146\3\2\2\2,\u0149\3\2\2\2."+
		"\u014c\3\2\2\2\60\63\5\4\3\2\61\63\5\20\t\2\62\60\3\2\2\2\62\61\3\2\2"+
		"\2\63\3\3\2\2\2\64\67\7\30\2\2\65\66\7.\2\2\668\7\30\2\2\67\65\3\2\2\2"+
		"\678\3\2\2\28:\3\2\2\29;\5.\30\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<>\7\3\2"+
		"\2=?\5.\30\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@B\5\6\4\2A@\3\2\2\2AB\3\2\2"+
		"\2BD\3\2\2\2CE\5\n\6\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7\4\2\2G\5\3\2"+
		"\2\2HI\5\b\5\2IJ\5.\30\2JL\3\2\2\2KH\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2"+
		"\2\2N\7\3\2\2\2OP\5,\27\2PS\7\30\2\2QR\7,\2\2RT\5\30\r\2SQ\3\2\2\2ST\3"+
		"\2\2\2T\t\3\2\2\2UW\5\f\7\2VX\5.\30\2WV\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YU"+
		"\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\13\3\2\2\2]^\5,\27\2^_\7\30"+
		"\2\2_`\7,\2\2`b\3\2\2\2a]\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\30\2\2df\7\5"+
		"\2\2eg\5\16\b\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hj\7\6\2\2ik\5.\30\2ji\3"+
		"\2\2\2jk\3\2\2\2kl\3\2\2\2ln\7\3\2\2mo\5\20\t\2nm\3\2\2\2no\3\2\2\2op"+
		"\3\2\2\2pq\7\4\2\2q\r\3\2\2\2rs\5,\27\2sz\7\30\2\2tu\7\7\2\2uv\5,\27\2"+
		"vw\7\30\2\2wy\3\2\2\2xt\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\17\3\2"+
		"\2\2|z\3\2\2\2}\177\5.\30\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0086\5\22\n\2\u0081\u0082\5.\30\2\u0082\u0083\5\22\n\2\u0083\u0085\3"+
		"\2\2\2\u0084\u0081\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\5."+
		"\30\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\21\3\2\2\2\u008c\u0091"+
		"\5$\23\2\u008d\u0091\5&\24\2\u008e\u0091\5(\25\2\u008f\u0091\5\30\r\2"+
		"\u0090\u008c\3\2\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\23\3\2\2\2\u0092\u0093\b\13\1\2\u0093\u0094\7\30\2\2\u0094"+
		"\u009a\3\2\2\2\u0095\u0096\f\3\2\2\u0096\u0097\7\b\2\2\u0097\u0099\7\30"+
		"\2\2\u0098\u0095\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\25\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\5\24\13"+
		"\2\u009e\u009f\7\b\2\2\u009f\u00a1\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\30\2\2\u00a3\u00ac\7\5\2\2"+
		"\u00a4\u00a9\5\30\r\2\u00a5\u00a6\7\7\2\2\u00a6\u00a8\5\30\r\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\6\2\2\u00af\27\3\2\2\2\u00b0\u00b1"+
		"\b\r\1\2\u00b1\u00b2\7#\2\2\u00b2\u00d8\5\30\r\31\u00b3\u00b4\7\24\2\2"+
		"\u00b4\u00d8\5\30\r\30\u00b5\u00b6\5\24\13\2\u00b6\u00b7\7,\2\2\u00b7"+
		"\u00b8\5\30\r\21\u00b8\u00d8\3\2\2\2\u00b9\u00d8\5\26\f\2\u00ba\u00bb"+
		"\5\24\13\2\u00bb\u00bc\7\n\2\2\u00bc\u00bd\5\30\r\2\u00bd\u00be\7\13\2"+
		"\2\u00be\u00bf\7,\2\2\u00bf\u00c0\5\30\r\2\u00c0\u00d8\3\2\2\2\u00c1\u00d8"+
		"\5\24\13\2\u00c2\u00d8\5\34\17\2\u00c3\u00d8\7\31\2\2\u00c4\u00d8\7\32"+
		"\2\2\u00c5\u00d8\7\33\2\2\u00c6\u00d8\7\34\2\2\u00c7\u00d8\5\36\20\2\u00c8"+
		"\u00d8\5 \21\2\u00c9\u00d8\5\32\16\2\u00ca\u00d3\7\3\2\2\u00cb\u00d0\5"+
		"\30\r\2\u00cc\u00cd\7\7\2\2\u00cd\u00cf\5\30\r\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d8\7\4\2\2\u00d6\u00d8\5\b\5\2\u00d7\u00b0\3\2"+
		"\2\2\u00d7\u00b3\3\2\2\2\u00d7\u00b5\3\2\2\2\u00d7\u00b9\3\2\2\2\u00d7"+
		"\u00ba\3\2\2\2\u00d7\u00c1\3\2\2\2\u00d7\u00c2\3\2\2\2\u00d7\u00c3\3\2"+
		"\2\2\u00d7\u00c4\3\2\2\2\u00d7\u00c5\3\2\2\2\u00d7\u00c6\3\2\2\2\u00d7"+
		"\u00c7\3\2\2\2\u00d7\u00c8\3\2\2\2\u00d7\u00c9\3\2\2\2\u00d7\u00ca\3\2"+
		"\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00f5\3\2\2\2\u00d9\u00da\f\27\2\2\u00da"+
		"\u00db\7\24\2\2\u00db\u00f4\5\30\r\30\u00dc\u00dd\f\26\2\2\u00dd\u00de"+
		"\7\t\2\2\u00de\u00f4\5\30\r\27\u00df\u00e0\f\25\2\2\u00e0\u00e1\t\2\2"+
		"\2\u00e1\u00f4\5\30\r\26\u00e2\u00e3\f\24\2\2\u00e3\u00e4\t\3\2\2\u00e4"+
		"\u00f4\5\30\r\25\u00e5\u00e6\f\23\2\2\u00e6\u00e7\t\4\2\2\u00e7\u00f4"+
		"\5\30\r\24\u00e8\u00e9\f\22\2\2\u00e9\u00ea\t\5\2\2\u00ea\u00f4\5\30\r"+
		"\23\u00eb\u00ec\f\17\2\2\u00ec\u00ed\7-\2\2\u00ed\u00f4\5\30\r\20\u00ee"+
		"\u00ef\f\r\2\2\u00ef\u00f0\7\n\2\2\u00f0\u00f1\5\30\r\2\u00f1\u00f2\7"+
		"\13\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00d9\3\2\2\2\u00f3\u00dc\3\2\2\2\u00f3"+
		"\u00df\3\2\2\2\u00f3\u00e2\3\2\2\2\u00f3\u00e5\3\2\2\2\u00f3\u00e8\3\2"+
		"\2\2\u00f3\u00eb\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\31\3\2\2\2\u00f7\u00f5\3\2\2"+
		"\2\u00f8\u00f9\7\5\2\2\u00f9\u00fa\5\30\r\2\u00fa\u00fb\7\6\2\2\u00fb"+
		"\33\3\2\2\2\u00fc\u00fd\7\f\2\2\u00fd\u00fe\7\30\2\2\u00fe\u0107\7\5\2"+
		"\2\u00ff\u0104\5\30\r\2\u0100\u0101\7\7\2\2\u0101\u0103\5\30\r\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u00ff\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\7\6\2\2\u010a\35\3\2\2"+
		"\2\u010b\u010c\7\r\2\2\u010c\u010d\7\31\2\2\u010d\37\3\2\2\2\u010e\u010f"+
		"\7/\2\2\u010f\u0110\5\"\22\2\u0110!\3\2\2\2\u0111\u0112\b\22\1\2\u0112"+
		"\u0115\7\30\2\2\u0113\u0115\3\2\2\2\u0114\u0111\3\2\2\2\u0114\u0113\3"+
		"\2\2\2\u0115\u011b\3\2\2\2\u0116\u0117\f\3\2\2\u0117\u0118\7!\2\2\u0118"+
		"\u011a\7\30\2\2\u0119\u0116\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3"+
		"\2\2\2\u011b\u011c\3\2\2\2\u011c#\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f"+
		"\7\25\2\2\u011f\u0120\7\5\2\2\u0120\u0121\5\30\r\2\u0121\u0123\7\6\2\2"+
		"\u0122\u0124\5.\30\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0126\7\3\2\2\u0126\u0127\5\20\t\2\u0127\u0133\7\4\2\2"+
		"\u0128\u012a\5.\30\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b\u012d\7\26\2\2\u012c\u012e\5.\30\2\u012d\u012c\3\2\2\2"+
		"\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7\3\2\2\u0130\u0131"+
		"\5\20\t\2\u0131\u0132\7\4\2\2\u0132\u0134\3\2\2\2\u0133\u0129\3\2\2\2"+
		"\u0133\u0134\3\2\2\2\u0134%\3\2\2\2\u0135\u0136\7\27\2\2\u0136\u0137\7"+
		"\5\2\2\u0137\u0138\7\30\2\2\u0138\u0139\7.\2\2\u0139\u013a\5\30\r\2\u013a"+
		"\u013c\7\6\2\2\u013b\u013d\5.\30\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u013f\7\3\2\2\u013f\u0140\5\20\t\2\u0140"+
		"\u0141\7\4\2\2\u0141\'\3\2\2\2\u0142\u0143\5*\26\2\u0143\u0144\7\16\2"+
		"\2\u0144\u0145\5\30\r\2\u0145)\3\2\2\2\u0146\u0147\7\17\2\2\u0147\u0148"+
		"\7\30\2\2\u0148+\3\2\2\2\u0149\u014a\t\6\2\2\u014a-\3\2\2\2\u014b\u014d"+
		"\7\23\2\2\u014c\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014c\3\2\2\2"+
		"\u014e\u014f\3\2\2\2\u014f/\3\2\2\2(\62\67:>ADMSW[afjnz~\u0086\u008a\u0090"+
		"\u009a\u00a0\u00a9\u00ac\u00d0\u00d3\u00d7\u00f3\u00f5\u0104\u0107\u0114"+
		"\u011b\u0123\u0129\u012d\u0133\u013c\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}