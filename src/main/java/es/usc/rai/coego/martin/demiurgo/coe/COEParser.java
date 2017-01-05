// Generated from COE.g4 by ANTLR 4.5.3
package es.usc.rai.coego.martin.demiurgo.coe;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class COEParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, D=13, IF=14, ELSE=15, FOR=16, ECHO=17, INT_TYPE=18, 
		FLOAT_TYPE=19, STRING_TYPE=20, TRUE=21, FALSE=22, SYMBOL=23, USERNAME=24, 
		INT_NUMBER=25, FLOAT_NUMBER=26, BOOLEAN=27, TEXT_STRING=28, WS=29, COMMENT=30, 
		COMMENT2=31, MUL=32, DIV=33, ADD=34, SUB=35, EQ=36, NEQ=37, GREQ=38, LESEQ=39, 
		GREAT=40, LESS=41, AND=42, OR=43, ASSIGN=44, MOVE=45, INHERIT=46, ROOM=47, 
		USEROBJ=48, INVENTORY=49;
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_fields = 2, RULE_var_decl = 3, RULE_methods = 4, 
		RULE_method = 5, RULE_args = 6, RULE_code = 7, RULE_line = 8, RULE_variable = 9, 
		RULE_function_call = 10, RULE_operation = 11, RULE_parens = 12, RULE_new_obj = 13, 
		RULE_sharp_identifier = 14, RULE_room = 15, RULE_room_path = 16, RULE_exp_if = 17, 
		RULE_exp_else = 18, RULE_exp_for = 19, RULE_exp_user = 20, RULE_echo = 21, 
		RULE_data_type = 22, RULE_nl = 23;
	public static final String[] ruleNames = {
		"s", "class_def", "fields", "var_decl", "methods", "method", "args", "code", 
		"line", "variable", "function_call", "operation", "parens", "new_obj", 
		"sharp_identifier", "room", "room_path", "exp_if", "exp_else", "exp_for", 
		"exp_user", "echo", "data_type", "nl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'['", "']'", "'new'", 
		"'#'", "'[]'", "'\n'", null, null, null, null, "'!'", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "'*'", 
		"'/'", "'+'", "'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&'", 
		"'|'", "'='", "'>>'", "':'", "'@'", "'->'", "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "D", "IF", "ELSE", "FOR", "ECHO", "INT_TYPE", "FLOAT_TYPE", "STRING_TYPE", 
		"TRUE", "FALSE", "SYMBOL", "USERNAME", "INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", 
		"TEXT_STRING", "WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", 
		"EQ", "NEQ", "GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", 
		"MOVE", "INHERIT", "ROOM", "USEROBJ", "INVENTORY"
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
	public String getGrammarFileName() { return "COE.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public COEParser(TokenStream input) {
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
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public SCodeContext(SContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitSCode(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassDefContext extends SContext {
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public ClassDefContext(SContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyContext extends SContext {
		public EmptyContext(SContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		int _la;
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(48);
					nl();
					}
				}

				setState(51);
				class_def();
				setState(53);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(52);
					nl();
					}
				}

				}
				break;
			case 2:
				_localctx = new SCodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(55);
					nl();
					}
				}

				setState(58);
				code();
				setState(60);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(59);
					nl();
					}
				}

				}
				break;
			case 3:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
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
		public List<TerminalNode> SYMBOL() { return getTokens(COEParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(COEParser.SYMBOL, i);
		}
		public TerminalNode INHERIT() { return getToken(COEParser.INHERIT, 0); }
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitClass_def(this);
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
			setState(65);
			match(SYMBOL);
			setState(68);
			_la = _input.LA(1);
			if (_la==INHERIT) {
				{
				setState(66);
				match(INHERIT);
				setState(67);
				match(SYMBOL);
				}
			}

			setState(71);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(70);
				nl();
				}
			}

			setState(73);
			match(T__0);
			setState(75);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(74);
				nl();
				}
			}

			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(77);
				fields();
				}
				break;
			}
			setState(81);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(80);
				methods();
				}
			}

			setState(83);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitFields(this);
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
			setState(88); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(85);
					var_decl();
					setState(86);
					nl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(90); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public TerminalNode ASSIGN() { return getToken(COEParser.ASSIGN, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			data_type(0);
			setState(93);
			match(SYMBOL);
			setState(96);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(94);
				match(ASSIGN);
				setState(95);
				operation(0);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitMethods(this);
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
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				method();
				setState(100);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(99);
					nl();
					}
				}

				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0) );
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
		public List<TerminalNode> SYMBOL() { return getTokens(COEParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(COEParser.SYMBOL, i);
		}
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(COEParser.ASSIGN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitMethod(this);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(106);
				data_type(0);
				setState(107);
				match(SYMBOL);
				setState(108);
				match(ASSIGN);
				}
				break;
			}
			setState(112);
			((MethodContext)_localctx).metname = match(SYMBOL);
			setState(113);
			match(T__2);
			setState(115);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(114);
				args();
				}
			}

			setState(117);
			match(T__3);
			setState(119);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(118);
				nl();
				}
			}

			setState(121);
			match(T__0);
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(122);
				nl();
				}
				break;
			}
			setState(126);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(125);
				code();
				}
			}

			setState(129);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(128);
				nl();
				}
			}

			setState(131);
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
		public List<TerminalNode> SYMBOL() { return getTokens(COEParser.SYMBOL); }
		public TerminalNode SYMBOL(int i) {
			return getToken(COEParser.SYMBOL, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitArgs(this);
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
			setState(133);
			data_type(0);
			setState(134);
			match(SYMBOL);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(135);
				match(T__4);
				setState(136);
				data_type(0);
				setState(137);
				match(SYMBOL);
				}
				}
				setState(143);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_code);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			line();
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(145);
					nl();
					setState(146);
					line();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_line);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				exp_if();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				exp_for();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				exp_user();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				operation(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				var_decl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(158);
				echo();
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
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public RootVariableContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRootVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntermediateVariableContext extends VariableContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public IntermediateVariableContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitIntermediateVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RootObjectContext extends VariableContext {
		public Sharp_identifierContext sharp_identifier() {
			return getRuleContext(Sharp_identifierContext.class,0);
		}
		public RootObjectContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRootObject(this);
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
			setState(164);
			switch (_input.LA(1)) {
			case SYMBOL:
				{
				_localctx = new RootVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(162);
				match(SYMBOL);
				}
				break;
			case T__9:
				{
				_localctx = new RootObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				sharp_identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IntermediateVariableContext(new VariableContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_variable);
					setState(166);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(167);
					match(T__5);
					setState(168);
					match(SYMBOL);
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(174);
				variable(0);
				setState(175);
				match(T__5);
				}
				break;
			}
			setState(179);
			match(SYMBOL);
			setState(180);
			match(T__2);
			setState(189);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(181);
				operation(0);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(182);
					match(T__4);
					setState(183);
					operation(0);
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(191);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitParensOp(this);
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
		public TerminalNode NEQ() { return getToken(COEParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(COEParser.EQ, 0); }
		public TerminalNode GREQ() { return getToken(COEParser.GREQ, 0); }
		public TerminalNode LESEQ() { return getToken(COEParser.LESEQ, 0); }
		public TerminalNode LESS() { return getToken(COEParser.LESS, 0); }
		public TerminalNode GREAT() { return getToken(COEParser.GREAT, 0); }
		public CompareContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitCompare(this);
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
		public TerminalNode MOVE() { return getToken(COEParser.MOVE, 0); }
		public MoveContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitMove(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends OperationContext {
		public TerminalNode BOOLEAN() { return getToken(COEParser.BOOLEAN, 0); }
		public BoolContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends OperationContext {
		public TerminalNode TEXT_STRING() { return getToken(COEParser.TEXT_STRING, 0); }
		public StringContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitString(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRoomOp(this);
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
		public TerminalNode MUL() { return getToken(COEParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(COEParser.DIV, 0); }
		public MulDivContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitMulDiv(this);
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
		public TerminalNode ADD() { return getToken(COEParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(COEParser.SUB, 0); }
		public AddSubContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitAddSub(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitVariableOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DiceContext extends OperationContext {
		public TerminalNode D() { return getToken(COEParser.D, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public DiceContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitDice(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitIndex(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitNewObj(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatContext extends OperationContext {
		public TerminalNode FLOAT_NUMBER() { return getToken(COEParser.FLOAT_NUMBER, 0); }
		public FloatContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitFloat(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitList(this);
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
		public TerminalNode ASSIGN() { return getToken(COEParser.ASSIGN, 0); }
		public IndexAssignContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitIndexAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends OperationContext {
		public TerminalNode INT_NUMBER() { return getToken(COEParser.INT_NUMBER, 0); }
		public IntContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitInt(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitSharp(this);
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
		public TerminalNode D() { return getToken(COEParser.D, 0); }
		public MultDiceContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitMultDice(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionOpContext extends OperationContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public FunctionOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitFunctionOp(this);
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
		public TerminalNode OR() { return getToken(COEParser.OR, 0); }
		public TerminalNode AND() { return getToken(COEParser.AND, 0); }
		public LogicContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends OperationContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(COEParser.ASSIGN, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AssignContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitAssign(this);
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
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(194);
				function_call();
				}
				break;
			case 2:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(SUB);
				setState(196);
				operation(21);
				}
				break;
			case 3:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(D);
				setState(198);
				operation(20);
				}
				break;
			case 4:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				variable(0);
				setState(200);
				match(ASSIGN);
				setState(201);
				operation(14);
				}
				break;
			case 5:
				{
				_localctx = new IndexAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				variable(0);
				setState(204);
				match(T__6);
				setState(205);
				operation(0);
				setState(206);
				match(T__7);
				setState(207);
				match(ASSIGN);
				setState(208);
				operation(0);
				}
				break;
			case 6:
				{
				_localctx = new VariableOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				variable(0);
				}
				break;
			case 7:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				new_obj();
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(INT_NUMBER);
				}
				break;
			case 9:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(FLOAT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(BOOLEAN);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(TEXT_STRING);
				}
				break;
			case 12:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				sharp_identifier();
				}
				break;
			case 13:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				room();
				}
				break;
			case 14:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				parens();
				}
				break;
			case 15:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(T__0);
				setState(228);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
					{
					setState(220);
					operation(0);
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(221);
						match(T__4);
						setState(222);
						operation(0);
						}
						}
						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(230);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(256);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new MultDiceContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(233);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(234);
						match(D);
						setState(235);
						operation(20);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(236);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(237);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(238);
						operation(19);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(239);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(240);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(241);
						operation(18);
						}
						break;
					case 4:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(242);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(243);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(244);
						operation(17);
						}
						break;
					case 5:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(245);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(246);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(247);
						operation(16);
						}
						break;
					case 6:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(248);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(249);
						match(MOVE);
						setState(250);
						operation(13);
						}
						break;
					case 7:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(251);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(252);
						match(T__6);
						setState(253);
						operation(0);
						setState(254);
						match(T__7);
						}
						break;
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParensContext parens() throws RecognitionException {
		ParensContext _localctx = new ParensContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__2);
			setState(262);
			operation(0);
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

	public static class New_objContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitNew_obj(this);
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
			setState(265);
			match(T__8);
			setState(266);
			match(SYMBOL);
			setState(267);
			match(T__2);
			setState(276);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(268);
				operation(0);
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(269);
					match(T__4);
					setState(270);
					operation(0);
					}
					}
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(278);
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
		public TerminalNode INT_NUMBER() { return getToken(COEParser.INT_NUMBER, 0); }
		public Sharp_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sharp_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitSharp_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sharp_identifierContext sharp_identifier() throws RecognitionException {
		Sharp_identifierContext _localctx = new Sharp_identifierContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sharp_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__9);
			setState(281);
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
		public TerminalNode ROOM() { return getToken(COEParser.ROOM, 0); }
		public Room_pathContext room_path() {
			return getRuleContext(Room_pathContext.class,0);
		}
		public RoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoomContext room() throws RecognitionException {
		RoomContext _localctx = new RoomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(ROOM);
			setState(284);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRootRoom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeafRoomContext extends Room_pathContext {
		public Room_pathContext room_path() {
			return getRuleContext(Room_pathContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public LeafRoomContext(Room_pathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitLeafRoom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelativeRoomContext extends Room_pathContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public RelativeRoomContext(Room_pathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRelativeRoom(this);
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
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				_localctx = new RelativeRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(287);
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
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LeafRoomContext(new Room_pathContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_room_path);
					setState(291);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(292);
					match(DIV);
					setState(293);
					match(SYMBOL);
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		public TerminalNode IF() { return getToken(COEParser.IF, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public Exp_elseContext exp_else() {
			return getRuleContext(Exp_elseContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public Exp_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_if; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitExp_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_ifContext exp_if() throws RecognitionException {
		Exp_ifContext _localctx = new Exp_ifContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exp_if);
		int _la;
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(IF);
				setState(300);
				match(T__2);
				setState(301);
				operation(0);
				setState(302);
				match(T__3);
				setState(304);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(303);
					nl();
					}
				}

				setState(306);
				match(T__0);
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(307);
					nl();
					}
					break;
				}
				setState(311);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(310);
					code();
					}
				}

				setState(314);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(313);
					nl();
					}
				}

				setState(316);
				match(T__1);
				setState(318);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(317);
					exp_else();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				match(IF);
				setState(321);
				match(T__2);
				setState(322);
				operation(0);
				setState(323);
				match(T__3);
				setState(325);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(324);
					nl();
					}
					break;
				}
				setState(328);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(327);
					nl();
					}
					break;
				}
				setState(331);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(330);
					line();
					}
				}

				setState(334);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(333);
					nl();
					}
					break;
				}
				setState(337);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(336);
					exp_else();
					}
					break;
				}
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

	public static class Exp_elseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(COEParser.ELSE, 0); }
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public Exp_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_else; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitExp_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_elseContext exp_else() throws RecognitionException {
		Exp_elseContext _localctx = new Exp_elseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exp_else);
		int _la;
		try {
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(341);
					nl();
					}
				}

				setState(344);
				match(ELSE);
				setState(346);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(345);
					nl();
					}
				}

				setState(348);
				match(T__0);
				setState(350);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(349);
					nl();
					}
					break;
				}
				setState(353);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(352);
					code();
					}
				}

				setState(356);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(355);
					nl();
					}
				}

				setState(358);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(359);
					nl();
					}
				}

				setState(362);
				match(ELSE);
				setState(364);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(363);
					nl();
					}
					break;
				}
				setState(367);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(366);
					nl();
					}
					break;
				}
				setState(370);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(369);
					line();
					}
				}

				setState(373);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(372);
					nl();
					}
					break;
				}
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

	public static class Exp_forContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(COEParser.FOR, 0); }
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public Exp_forContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_for; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitExp_for(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_forContext exp_for() throws RecognitionException {
		Exp_forContext _localctx = new Exp_forContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exp_for);
		int _la;
		try {
			setState(414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(FOR);
				setState(378);
				match(T__2);
				setState(379);
				match(SYMBOL);
				setState(380);
				match(INHERIT);
				setState(381);
				operation(0);
				setState(382);
				match(T__3);
				setState(384);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(383);
					nl();
					}
				}

				setState(386);
				match(T__0);
				setState(388);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(387);
					nl();
					}
					break;
				}
				setState(391);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(390);
					code();
					}
				}

				setState(394);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(393);
					nl();
					}
				}

				setState(396);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				match(FOR);
				setState(399);
				match(T__2);
				setState(400);
				match(SYMBOL);
				setState(401);
				match(INHERIT);
				setState(402);
				operation(0);
				setState(403);
				match(T__3);
				setState(405);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(404);
					nl();
					}
					break;
				}
				setState(408);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(407);
					nl();
					}
				}

				setState(410);
				line();
				setState(412);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(411);
					nl();
					}
					break;
				}
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

	public static class Exp_userContext extends ParserRuleContext {
		public TerminalNode USERNAME() { return getToken(COEParser.USERNAME, 0); }
		public TerminalNode USEROBJ() { return getToken(COEParser.USEROBJ, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Exp_userContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_user; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitExp_user(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_userContext exp_user() throws RecognitionException {
		Exp_userContext _localctx = new Exp_userContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exp_user);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(USERNAME);
			setState(417);
			match(USEROBJ);
			setState(418);
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

	public static class EchoContext extends ParserRuleContext {
		public TerminalNode ECHO() { return getToken(COEParser.ECHO, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public EchoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitEcho(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EchoContext echo() throws RecognitionException {
		EchoContext _localctx = new EchoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_echo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			match(ECHO);
			setState(421);
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

	public static class Data_typeContext extends ParserRuleContext {
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
	 
		public Data_typeContext() { }
		public void copyFrom(Data_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FloatTypeContext extends Data_typeContext {
		public TerminalNode FLOAT_TYPE() { return getToken(COEParser.FLOAT_TYPE, 0); }
		public FloatTypeContext(Data_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InventoryTypeContext extends Data_typeContext {
		public TerminalNode INVENTORY() { return getToken(COEParser.INVENTORY, 0); }
		public InventoryTypeContext(Data_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitInventoryType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends Data_typeContext {
		public TerminalNode INT_TYPE() { return getToken(COEParser.INT_TYPE, 0); }
		public IntTypeContext(Data_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringTypeContext extends Data_typeContext {
		public TerminalNode STRING_TYPE() { return getToken(COEParser.STRING_TYPE, 0); }
		public StringTypeContext(Data_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListTypeContext extends Data_typeContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public ListTypeContext(Data_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymbolTypeContext extends Data_typeContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public SymbolTypeContext(Data_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitSymbolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RoomTypeContext extends Data_typeContext {
		public TerminalNode ROOM() { return getToken(COEParser.ROOM, 0); }
		public RoomTypeContext(Data_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRoomType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		return data_type(0);
	}

	private Data_typeContext data_type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Data_typeContext _localctx = new Data_typeContext(_ctx, _parentState);
		Data_typeContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_data_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			switch (_input.LA(1)) {
			case INT_TYPE:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(424);
				match(INT_TYPE);
				}
				break;
			case FLOAT_TYPE:
				{
				_localctx = new FloatTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(425);
				match(FLOAT_TYPE);
				}
				break;
			case STRING_TYPE:
				{
				_localctx = new StringTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(426);
				match(STRING_TYPE);
				}
				break;
			case SYMBOL:
				{
				_localctx = new SymbolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(427);
				match(SYMBOL);
				}
				break;
			case ROOM:
				{
				_localctx = new RoomTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(428);
				match(ROOM);
				}
				break;
			case INVENTORY:
				{
				_localctx = new InventoryTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(429);
				match(INVENTORY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListTypeContext(new Data_typeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_data_type);
					setState(432);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(433);
					match(T__10);
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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

	public static class NlContext extends ParserRuleContext {
		public NlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitNl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NlContext nl() throws RecognitionException {
		NlContext _localctx = new NlContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_nl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(440); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(439);
					match(T__11);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(442); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return variable_sempred((VariableContext)_localctx, predIndex);
		case 11:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 16:
			return room_path_sempred((Room_pathContext)_localctx, predIndex);
		case 22:
			return data_type_sempred((Data_typeContext)_localctx, predIndex);
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
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean room_path_sempred(Room_pathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean data_type_sempred(Data_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u01bf\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\5\2\64\n\2\3\2\3\2\5\28\n\2\3\2\5\2;\n\2\3\2\3\2\5\2?\n\2\3\2\5\2"+
		"B\n\2\3\3\3\3\3\3\5\3G\n\3\3\3\5\3J\n\3\3\3\3\3\5\3N\n\3\3\3\5\3Q\n\3"+
		"\3\3\5\3T\n\3\3\3\3\3\3\4\3\4\3\4\6\4[\n\4\r\4\16\4\\\3\5\3\5\3\5\3\5"+
		"\5\5c\n\5\3\6\3\6\5\6g\n\6\6\6i\n\6\r\6\16\6j\3\7\3\7\3\7\3\7\5\7q\n\7"+
		"\3\7\3\7\3\7\5\7v\n\7\3\7\3\7\5\7z\n\7\3\7\3\7\5\7~\n\7\3\7\5\7\u0081"+
		"\n\7\3\7\5\7\u0084\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u008e\n\b\f"+
		"\b\16\b\u0091\13\b\3\t\3\t\3\t\3\t\7\t\u0097\n\t\f\t\16\t\u009a\13\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a2\n\n\3\13\3\13\3\13\5\13\u00a7\n\13\3"+
		"\13\3\13\3\13\7\13\u00ac\n\13\f\13\16\13\u00af\13\13\3\f\3\f\3\f\5\f\u00b4"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u00bb\n\f\f\f\16\f\u00be\13\f\5\f\u00c0\n"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e2"+
		"\n\r\f\r\16\r\u00e5\13\r\5\r\u00e7\n\r\3\r\5\r\u00ea\n\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\r\u0103\n\r\f\r\16\r\u0106\13\r\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u0112\n\17\f\17\16\17\u0115\13\17\5\17\u0117"+
		"\n\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u0124"+
		"\n\22\3\22\3\22\3\22\7\22\u0129\n\22\f\22\16\22\u012c\13\22\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0133\n\23\3\23\3\23\5\23\u0137\n\23\3\23\5\23\u013a"+
		"\n\23\3\23\5\23\u013d\n\23\3\23\3\23\5\23\u0141\n\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u0148\n\23\3\23\5\23\u014b\n\23\3\23\5\23\u014e\n\23\3\23"+
		"\5\23\u0151\n\23\3\23\5\23\u0154\n\23\5\23\u0156\n\23\3\24\5\24\u0159"+
		"\n\24\3\24\3\24\5\24\u015d\n\24\3\24\3\24\5\24\u0161\n\24\3\24\5\24\u0164"+
		"\n\24\3\24\5\24\u0167\n\24\3\24\3\24\5\24\u016b\n\24\3\24\3\24\5\24\u016f"+
		"\n\24\3\24\5\24\u0172\n\24\3\24\5\24\u0175\n\24\3\24\5\24\u0178\n\24\5"+
		"\24\u017a\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0183\n\25\3\25"+
		"\3\25\5\25\u0187\n\25\3\25\5\25\u018a\n\25\3\25\5\25\u018d\n\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0198\n\25\3\25\5\25\u019b"+
		"\n\25\3\25\3\25\5\25\u019f\n\25\5\25\u01a1\n\25\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01b1\n\30\3\30"+
		"\3\30\7\30\u01b5\n\30\f\30\16\30\u01b8\13\30\3\31\6\31\u01bb\n\31\r\31"+
		"\16\31\u01bc\3\31\2\6\24\30\".\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\2\6\3\2\"#\3\2$%\3\2&+\3\2,-\u0207\2A\3\2\2\2\4C\3\2\2"+
		"\2\6Z\3\2\2\2\b^\3\2\2\2\nh\3\2\2\2\fp\3\2\2\2\16\u0087\3\2\2\2\20\u0092"+
		"\3\2\2\2\22\u00a1\3\2\2\2\24\u00a6\3\2\2\2\26\u00b3\3\2\2\2\30\u00e9\3"+
		"\2\2\2\32\u0107\3\2\2\2\34\u010b\3\2\2\2\36\u011a\3\2\2\2 \u011d\3\2\2"+
		"\2\"\u0123\3\2\2\2$\u0155\3\2\2\2&\u0179\3\2\2\2(\u01a0\3\2\2\2*\u01a2"+
		"\3\2\2\2,\u01a6\3\2\2\2.\u01b0\3\2\2\2\60\u01ba\3\2\2\2\62\64\5\60\31"+
		"\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\67\5\4\3\2\668\5\60\31"+
		"\2\67\66\3\2\2\2\678\3\2\2\28B\3\2\2\29;\5\60\31\2:9\3\2\2\2:;\3\2\2\2"+
		";<\3\2\2\2<>\5\20\t\2=?\5\60\31\2>=\3\2\2\2>?\3\2\2\2?B\3\2\2\2@B\3\2"+
		"\2\2A\63\3\2\2\2A:\3\2\2\2A@\3\2\2\2B\3\3\2\2\2CF\7\31\2\2DE\7\60\2\2"+
		"EG\7\31\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HJ\5\60\31\2IH\3\2\2\2IJ\3\2"+
		"\2\2JK\3\2\2\2KM\7\3\2\2LN\5\60\31\2ML\3\2\2\2MN\3\2\2\2NP\3\2\2\2OQ\5"+
		"\6\4\2PO\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RT\5\n\6\2SR\3\2\2\2ST\3\2\2\2TU\3"+
		"\2\2\2UV\7\4\2\2V\5\3\2\2\2WX\5\b\5\2XY\5\60\31\2Y[\3\2\2\2ZW\3\2\2\2"+
		"[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\7\3\2\2\2^_\5.\30\2_b\7\31\2\2`a\7"+
		".\2\2ac\5\30\r\2b`\3\2\2\2bc\3\2\2\2c\t\3\2\2\2df\5\f\7\2eg\5\60\31\2"+
		"fe\3\2\2\2fg\3\2\2\2gi\3\2\2\2hd\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"k\13\3\2\2\2lm\5.\30\2mn\7\31\2\2no\7.\2\2oq\3\2\2\2pl\3\2\2\2pq\3\2\2"+
		"\2qr\3\2\2\2rs\7\31\2\2su\7\5\2\2tv\5\16\b\2ut\3\2\2\2uv\3\2\2\2vw\3\2"+
		"\2\2wy\7\6\2\2xz\5\60\31\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{}\7\3\2\2|~\5"+
		"\60\31\2}|\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177\u0081\5\20\t\2\u0080\177"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0084\5\60\31\2"+
		"\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086"+
		"\7\4\2\2\u0086\r\3\2\2\2\u0087\u0088\5.\30\2\u0088\u008f\7\31\2\2\u0089"+
		"\u008a\7\7\2\2\u008a\u008b\5.\30\2\u008b\u008c\7\31\2\2\u008c\u008e\3"+
		"\2\2\2\u008d\u0089\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\17\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0098\5\22\n"+
		"\2\u0093\u0094\5\60\31\2\u0094\u0095\5\22\n\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0093\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\21\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u00a2\5$\23\2\u009c\u00a2"+
		"\5(\25\2\u009d\u00a2\5*\26\2\u009e\u00a2\5\30\r\2\u009f\u00a2\5\b\5\2"+
		"\u00a0\u00a2\5,\27\2\u00a1\u009b\3\2\2\2\u00a1\u009c\3\2\2\2\u00a1\u009d"+
		"\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\23\3\2\2\2\u00a3\u00a4\b\13\1\2\u00a4\u00a7\7\31\2\2\u00a5\u00a7\5\36"+
		"\20\2\u00a6\u00a3\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00ad\3\2\2\2\u00a8"+
		"\u00a9\f\3\2\2\u00a9\u00aa\7\b\2\2\u00aa\u00ac\7\31\2\2\u00ab\u00a8\3"+
		"\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\25\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\5\24\13\2\u00b1\u00b2\7\b"+
		"\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b6\7\31\2\2\u00b6\u00bf\7\5\2\2\u00b7\u00bc\5"+
		"\30\r\2\u00b8\u00b9\7\7\2\2\u00b9\u00bb\5\30\r\2\u00ba\u00b8\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c2\7\6\2\2\u00c2\27\3\2\2\2\u00c3\u00c4\b\r\1"+
		"\2\u00c4\u00ea\5\26\f\2\u00c5\u00c6\7%\2\2\u00c6\u00ea\5\30\r\27\u00c7"+
		"\u00c8\7\17\2\2\u00c8\u00ea\5\30\r\26\u00c9\u00ca\5\24\13\2\u00ca\u00cb"+
		"\7.\2\2\u00cb\u00cc\5\30\r\20\u00cc\u00ea\3\2\2\2\u00cd\u00ce\5\24\13"+
		"\2\u00ce\u00cf\7\t\2\2\u00cf\u00d0\5\30\r\2\u00d0\u00d1\7\n\2\2\u00d1"+
		"\u00d2\7.\2\2\u00d2\u00d3\5\30\r\2\u00d3\u00ea\3\2\2\2\u00d4\u00ea\5\24"+
		"\13\2\u00d5\u00ea\5\34\17\2\u00d6\u00ea\7\33\2\2\u00d7\u00ea\7\34\2\2"+
		"\u00d8\u00ea\7\35\2\2\u00d9\u00ea\7\36\2\2\u00da\u00ea\5\36\20\2\u00db"+
		"\u00ea\5 \21\2\u00dc\u00ea\5\32\16\2\u00dd\u00e6\7\3\2\2\u00de\u00e3\5"+
		"\30\r\2\u00df\u00e0\7\7\2\2\u00e0\u00e2\5\30\r\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e7\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00de\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00ea\7\4\2\2\u00e9\u00c3\3\2\2\2\u00e9\u00c5\3\2"+
		"\2\2\u00e9\u00c7\3\2\2\2\u00e9\u00c9\3\2\2\2\u00e9\u00cd\3\2\2\2\u00e9"+
		"\u00d4\3\2\2\2\u00e9\u00d5\3\2\2\2\u00e9\u00d6\3\2\2\2\u00e9\u00d7\3\2"+
		"\2\2\u00e9\u00d8\3\2\2\2\u00e9\u00d9\3\2\2\2\u00e9\u00da\3\2\2\2\u00e9"+
		"\u00db\3\2\2\2\u00e9\u00dc\3\2\2\2\u00e9\u00dd\3\2\2\2\u00ea\u0104\3\2"+
		"\2\2\u00eb\u00ec\f\25\2\2\u00ec\u00ed\7\17\2\2\u00ed\u0103\5\30\r\26\u00ee"+
		"\u00ef\f\24\2\2\u00ef\u00f0\t\2\2\2\u00f0\u0103\5\30\r\25\u00f1\u00f2"+
		"\f\23\2\2\u00f2\u00f3\t\3\2\2\u00f3\u0103\5\30\r\24\u00f4\u00f5\f\22\2"+
		"\2\u00f5\u00f6\t\4\2\2\u00f6\u0103\5\30\r\23\u00f7\u00f8\f\21\2\2\u00f8"+
		"\u00f9\t\5\2\2\u00f9\u0103\5\30\r\22\u00fa\u00fb\f\16\2\2\u00fb\u00fc"+
		"\7/\2\2\u00fc\u0103\5\30\r\17\u00fd\u00fe\f\f\2\2\u00fe\u00ff\7\t\2\2"+
		"\u00ff\u0100\5\30\r\2\u0100\u0101\7\n\2\2\u0101\u0103\3\2\2\2\u0102\u00eb"+
		"\3\2\2\2\u0102\u00ee\3\2\2\2\u0102\u00f1\3\2\2\2\u0102\u00f4\3\2\2\2\u0102"+
		"\u00f7\3\2\2\2\u0102\u00fa\3\2\2\2\u0102\u00fd\3\2\2\2\u0103\u0106\3\2"+
		"\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\31\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0107\u0108\7\5\2\2\u0108\u0109\5\30\r\2\u0109\u010a\7\6\2\2"+
		"\u010a\33\3\2\2\2\u010b\u010c\7\13\2\2\u010c\u010d\7\31\2\2\u010d\u0116"+
		"\7\5\2\2\u010e\u0113\5\30\r\2\u010f\u0110\7\7\2\2\u0110\u0112\5\30\r\2"+
		"\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u010e\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7\6\2\2\u0119\35\3\2\2"+
		"\2\u011a\u011b\7\f\2\2\u011b\u011c\7\33\2\2\u011c\37\3\2\2\2\u011d\u011e"+
		"\7\61\2\2\u011e\u011f\5\"\22\2\u011f!\3\2\2\2\u0120\u0121\b\22\1\2\u0121"+
		"\u0124\7\31\2\2\u0122\u0124\3\2\2\2\u0123\u0120\3\2\2\2\u0123\u0122\3"+
		"\2\2\2\u0124\u012a\3\2\2\2\u0125\u0126\f\3\2\2\u0126\u0127\7#\2\2\u0127"+
		"\u0129\7\31\2\2\u0128\u0125\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012b#\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e"+
		"\7\20\2\2\u012e\u012f\7\5\2\2\u012f\u0130\5\30\r\2\u0130\u0132\7\6\2\2"+
		"\u0131\u0133\5\60\31\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0136\7\3\2\2\u0135\u0137\5\60\31\2\u0136\u0135\3\2\2\2"+
		"\u0136\u0137\3\2\2\2\u0137\u0139\3\2\2\2\u0138\u013a\5\20\t\2\u0139\u0138"+
		"\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u013d\5\60\31\2"+
		"\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140"+
		"\7\4\2\2\u013f\u0141\5&\24\2\u0140\u013f\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0156\3\2\2\2\u0142\u0143\7\20\2\2\u0143\u0144\7\5\2\2\u0144\u0145\5"+
		"\30\r\2\u0145\u0147\7\6\2\2\u0146\u0148\5\60\31\2\u0147\u0146\3\2\2\2"+
		"\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u014b\5\60\31\2\u014a\u0149"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014d\3\2\2\2\u014c\u014e\5\22\n\2"+
		"\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0150\3\2\2\2\u014f\u0151"+
		"\5\60\31\2\u0150\u014f\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2"+
		"\u0152\u0154\5&\24\2\u0153\u0152\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156"+
		"\3\2\2\2\u0155\u012d\3\2\2\2\u0155\u0142\3\2\2\2\u0156%\3\2\2\2\u0157"+
		"\u0159\5\60\31\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3"+
		"\2\2\2\u015a\u015c\7\21\2\2\u015b\u015d\5\60\31\2\u015c\u015b\3\2\2\2"+
		"\u015c\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\7\3\2\2\u015f\u0161"+
		"\5\60\31\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163\3\2\2\2"+
		"\u0162\u0164\5\20\t\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166"+
		"\3\2\2\2\u0165\u0167\5\60\31\2\u0166\u0165\3\2\2\2\u0166\u0167\3\2\2\2"+
		"\u0167\u0168\3\2\2\2\u0168\u017a\7\4\2\2\u0169\u016b\5\60\31\2\u016a\u0169"+
		"\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\7\21\2\2"+
		"\u016d\u016f\5\60\31\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171"+
		"\3\2\2\2\u0170\u0172\5\60\31\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2"+
		"\u0172\u0174\3\2\2\2\u0173\u0175\5\22\n\2\u0174\u0173\3\2\2\2\u0174\u0175"+
		"\3\2\2\2\u0175\u0177\3\2\2\2\u0176\u0178\5\60\31\2\u0177\u0176\3\2\2\2"+
		"\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179\u0158\3\2\2\2\u0179\u016a"+
		"\3\2\2\2\u017a\'\3\2\2\2\u017b\u017c\7\22\2\2\u017c\u017d\7\5\2\2\u017d"+
		"\u017e\7\31\2\2\u017e\u017f\7\60\2\2\u017f\u0180\5\30\r\2\u0180\u0182"+
		"\7\6\2\2\u0181\u0183\5\60\31\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2\2\2"+
		"\u0183\u0184\3\2\2\2\u0184\u0186\7\3\2\2\u0185\u0187\5\60\31\2\u0186\u0185"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u018a\5\20\t\2"+
		"\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b\u018d"+
		"\5\60\31\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2\2\2"+
		"\u018e\u018f\7\4\2\2\u018f\u01a1\3\2\2\2\u0190\u0191\7\22\2\2\u0191\u0192"+
		"\7\5\2\2\u0192\u0193\7\31\2\2\u0193\u0194\7\60\2\2\u0194\u0195\5\30\r"+
		"\2\u0195\u0197\7\6\2\2\u0196\u0198\5\60\31\2\u0197\u0196\3\2\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u019b\5\60\31\2\u019a\u0199\3"+
		"\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\5\22\n\2\u019d"+
		"\u019f\5\60\31\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\3"+
		"\2\2\2\u01a0\u017b\3\2\2\2\u01a0\u0190\3\2\2\2\u01a1)\3\2\2\2\u01a2\u01a3"+
		"\7\32\2\2\u01a3\u01a4\7\62\2\2\u01a4\u01a5\5\30\r\2\u01a5+\3\2\2\2\u01a6"+
		"\u01a7\7\23\2\2\u01a7\u01a8\5\30\r\2\u01a8-\3\2\2\2\u01a9\u01aa\b\30\1"+
		"\2\u01aa\u01b1\7\24\2\2\u01ab\u01b1\7\25\2\2\u01ac\u01b1\7\26\2\2\u01ad"+
		"\u01b1\7\31\2\2\u01ae\u01b1\7\61\2\2\u01af\u01b1\7\63\2\2\u01b0\u01a9"+
		"\3\2\2\2\u01b0\u01ab\3\2\2\2\u01b0\u01ac\3\2\2\2\u01b0\u01ad\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b6\3\2\2\2\u01b2\u01b3\f\3"+
		"\2\2\u01b3\u01b5\7\r\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7/\3\2\2\2\u01b8\u01b6\3\2\2\2"+
		"\u01b9\u01bb\7\16\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01ba"+
		"\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\61\3\2\2\2H\63\67:>AFIMPS\\bfjpuy}"+
		"\u0080\u0083\u008f\u0098\u00a1\u00a6\u00ad\u00b3\u00bc\u00bf\u00e3\u00e6"+
		"\u00e9\u0102\u0104\u0113\u0116\u0123\u012a\u0132\u0136\u0139\u013c\u0140"+
		"\u0147\u014a\u014d\u0150\u0153\u0155\u0158\u015c\u0160\u0163\u0166\u016a"+
		"\u016e\u0171\u0174\u0177\u0179\u0182\u0186\u0189\u018c\u0197\u019a\u019e"+
		"\u01a0\u01b0\u01b6\u01bc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}