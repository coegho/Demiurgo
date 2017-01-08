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
		INT_NUMBER=25, FLOAT_NUMBER=26, TEXT_STRING=27, WS=28, COMMENT=29, COMMENT2=30, 
		MUL=31, DIV=32, ADD=33, SUB=34, EQ=35, NEQ=36, GREQ=37, LESEQ=38, GREAT=39, 
		LESS=40, AND=41, OR=42, ASSIGN=43, MOVE=44, INHERIT=45, ROOM=46, USEROBJ=47, 
		INVENTORY=48, CONCAT=49;
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_fields = 2, RULE_var_decl = 3, RULE_methods = 4, 
		RULE_method = 5, RULE_args = 6, RULE_code = 7, RULE_line = 8, RULE_variable = 9, 
		RULE_function_call = 10, RULE_contents = 11, RULE_operation = 12, RULE_parens = 13, 
		RULE_new_obj = 14, RULE_sharp_identifier = 15, RULE_room = 16, RULE_room_path = 17, 
		RULE_exp_if = 18, RULE_exp_else = 19, RULE_exp_for = 20, RULE_exp_user = 21, 
		RULE_echo = 22, RULE_data_type = 23, RULE_bool = 24, RULE_nl = 25;
	public static final String[] ruleNames = {
		"s", "class_def", "fields", "var_decl", "methods", "method", "args", "code", 
		"line", "variable", "function_call", "contents", "operation", "parens", 
		"new_obj", "sharp_identifier", "room", "room_path", "exp_if", "exp_else", 
		"exp_for", "exp_user", "echo", "data_type", "bool", "nl"
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(52);
					nl();
					}
				}

				setState(55);
				class_def();
				setState(57);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(56);
					nl();
					}
				}

				}
				break;
			case 2:
				_localctx = new SCodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(59);
					nl();
					}
				}

				setState(62);
				code();
				setState(64);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(63);
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
			setState(69);
			match(SYMBOL);
			setState(72);
			_la = _input.LA(1);
			if (_la==INHERIT) {
				{
				setState(70);
				match(INHERIT);
				setState(71);
				match(SYMBOL);
				}
			}

			setState(75);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(74);
				nl();
				}
			}

			setState(77);
			match(T__0);
			setState(79);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(78);
				nl();
				}
			}

			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(81);
				fields();
				}
				break;
			}
			setState(85);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(84);
				methods();
				}
			}

			setState(87);
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
			setState(92); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(89);
					var_decl();
					setState(90);
					nl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94); 
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
			setState(96);
			data_type(0);
			setState(97);
			match(SYMBOL);
			setState(100);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(98);
				match(ASSIGN);
				setState(99);
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
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(102);
				method();
				setState(104);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(103);
					nl();
					}
				}

				}
				}
				setState(108); 
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
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(110);
				data_type(0);
				setState(111);
				match(SYMBOL);
				setState(112);
				match(ASSIGN);
				}
				break;
			}
			setState(116);
			((MethodContext)_localctx).metname = match(SYMBOL);
			setState(117);
			match(T__2);
			setState(119);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(118);
				args();
				}
			}

			setState(121);
			match(T__3);
			setState(123);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(122);
				nl();
				}
			}

			setState(125);
			match(T__0);
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(126);
				nl();
				}
				break;
			}
			setState(130);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(129);
				code();
				}
			}

			setState(133);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(132);
				nl();
				}
			}

			setState(135);
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
			setState(137);
			data_type(0);
			setState(138);
			match(SYMBOL);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(139);
				match(T__4);
				setState(140);
				data_type(0);
				setState(141);
				match(SYMBOL);
				}
				}
				setState(147);
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
			setState(148);
			line();
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(149);
					nl();
					setState(150);
					line();
					}
					} 
				}
				setState(156);
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
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				exp_if();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				exp_for();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				exp_user();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				operation(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				var_decl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
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
			setState(168);
			switch (_input.LA(1)) {
			case SYMBOL:
				{
				_localctx = new RootVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(166);
				match(SYMBOL);
				}
				break;
			case T__9:
				{
				_localctx = new RootObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				sharp_identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(175);
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
					setState(170);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(171);
					match(T__5);
					setState(172);
					match(SYMBOL);
					}
					} 
				}
				setState(177);
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
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(178);
				variable(0);
				setState(179);
				match(T__5);
				}
				break;
			}
			setState(183);
			match(SYMBOL);
			setState(184);
			match(T__2);
			setState(193);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(185);
				operation(0);
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(186);
					match(T__4);
					setState(187);
					operation(0);
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(195);
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

	public static class ContentsContext extends ParserRuleContext {
		public ContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contents; }
	 
		public ContentsContext() { }
		public void copyFrom(ContentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InventoryContentsContext extends ContentsContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode INVENTORY() { return getToken(COEParser.INVENTORY, 0); }
		public InventoryContentsContext(ContentsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitInventoryContents(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RoomContentsContext extends ContentsContext {
		public RoomContext room() {
			return getRuleContext(RoomContext.class,0);
		}
		public TerminalNode INVENTORY() { return getToken(COEParser.INVENTORY, 0); }
		public RoomContentsContext(ContentsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRoomContents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentsContext contents() throws RecognitionException {
		ContentsContext _localctx = new ContentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_contents);
		try {
			setState(205);
			switch (_input.LA(1)) {
			case T__9:
			case SYMBOL:
				_localctx = new InventoryContentsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				variable(0);
				setState(198);
				match(T__5);
				setState(199);
				match(INVENTORY);
				}
				break;
			case ROOM:
				_localctx = new RoomContentsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				room();
				setState(202);
				match(T__5);
				setState(203);
				match(INVENTORY);
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
	public static class ConcatContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(COEParser.CONCAT, 0); }
		public ConcatContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitConcat(this);
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
	public static class BooleanContext extends OperationContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BooleanContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitBoolean(this);
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
	public static class ContentsOpContext extends OperationContext {
		public ContentsContext contents() {
			return getRuleContext(ContentsContext.class,0);
		}
		public ContentsOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitContentsOp(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_operation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new ContentsOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(208);
				contents();
				}
				break;
			case 2:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				function_call();
				}
				break;
			case 3:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(SUB);
				setState(211);
				operation(22);
				}
				break;
			case 4:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(D);
				setState(213);
				operation(21);
				}
				break;
			case 5:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				variable(0);
				setState(215);
				match(ASSIGN);
				setState(216);
				operation(14);
				}
				break;
			case 6:
				{
				_localctx = new IndexAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				variable(0);
				setState(219);
				match(T__6);
				setState(220);
				operation(0);
				setState(221);
				match(T__7);
				setState(222);
				match(ASSIGN);
				setState(223);
				operation(0);
				}
				break;
			case 7:
				{
				_localctx = new VariableOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				variable(0);
				}
				break;
			case 8:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				new_obj();
				}
				break;
			case 9:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(INT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(FLOAT_NUMBER);
				}
				break;
			case 11:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				bool();
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(TEXT_STRING);
				}
				break;
			case 13:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				sharp_identifier();
				}
				break;
			case 14:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				room();
				}
				break;
			case 15:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				parens();
				}
				break;
			case 16:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(T__0);
				setState(243);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
					{
					setState(235);
					operation(0);
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(236);
						match(T__4);
						setState(237);
						operation(0);
						}
						}
						setState(242);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(245);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new MultDiceContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(248);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(249);
						match(D);
						setState(250);
						operation(21);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(251);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(252);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(253);
						operation(20);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(254);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(255);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(256);
						operation(19);
						}
						break;
					case 4:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(257);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(258);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(259);
						operation(18);
						}
						break;
					case 5:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(260);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(261);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(262);
						operation(17);
						}
						break;
					case 6:
						{
						_localctx = new ConcatContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(263);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(264);
						match(CONCAT);
						setState(265);
						operation(16);
						}
						break;
					case 7:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(266);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(267);
						match(MOVE);
						setState(268);
						operation(13);
						}
						break;
					case 8:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(269);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(270);
						match(T__6);
						setState(271);
						operation(0);
						setState(272);
						match(T__7);
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 26, RULE_parens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__2);
			setState(280);
			operation(0);
			setState(281);
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
		enterRule(_localctx, 28, RULE_new_obj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__8);
			setState(284);
			match(SYMBOL);
			setState(285);
			match(T__2);
			setState(294);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(286);
				operation(0);
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(287);
					match(T__4);
					setState(288);
					operation(0);
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(296);
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
		enterRule(_localctx, 30, RULE_sharp_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(T__9);
			setState(299);
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
		enterRule(_localctx, 32, RULE_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(ROOM);
			setState(302);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_room_path, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				_localctx = new RelativeRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(305);
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
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LeafRoomContext(new Room_pathContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_room_path);
					setState(309);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(310);
					match(DIV);
					setState(311);
					match(SYMBOL);
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		enterRule(_localctx, 36, RULE_exp_if);
		int _la;
		try {
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(IF);
				setState(318);
				match(T__2);
				setState(319);
				operation(0);
				setState(320);
				match(T__3);
				setState(322);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(321);
					nl();
					}
				}

				setState(324);
				match(T__0);
				setState(326);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
				case 1:
					{
					setState(325);
					nl();
					}
					break;
				}
				setState(329);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(328);
					code();
					}
				}

				setState(332);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(331);
					nl();
					}
				}

				setState(334);
				match(T__1);
				setState(336);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(335);
					exp_else();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				match(IF);
				setState(339);
				match(T__2);
				setState(340);
				operation(0);
				setState(341);
				match(T__3);
				setState(343);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(342);
					nl();
					}
					break;
				}
				setState(346);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(345);
					nl();
					}
					break;
				}
				setState(349);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(348);
					line();
					}
				}

				setState(352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(351);
					nl();
					}
					break;
				}
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(354);
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
		enterRule(_localctx, 38, RULE_exp_else);
		int _la;
		try {
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
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
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(363);
					nl();
					}
				}

				setState(366);
				match(T__0);
				setState(368);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(367);
					nl();
					}
					break;
				}
				setState(371);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(370);
					code();
					}
				}

				setState(374);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(373);
					nl();
					}
				}

				setState(376);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(377);
					nl();
					}
				}

				setState(380);
				match(ELSE);
				setState(382);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(381);
					nl();
					}
					break;
				}
				setState(385);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(384);
					nl();
					}
					break;
				}
				setState(388);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(387);
					line();
					}
				}

				setState(391);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(390);
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
		enterRule(_localctx, 40, RULE_exp_for);
		int _la;
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				match(FOR);
				setState(396);
				match(T__2);
				setState(397);
				match(SYMBOL);
				setState(398);
				match(INHERIT);
				setState(399);
				operation(0);
				setState(400);
				match(T__3);
				setState(402);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(401);
					nl();
					}
				}

				setState(404);
				match(T__0);
				setState(406);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(405);
					nl();
					}
					break;
				}
				setState(409);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(408);
					code();
					}
				}

				setState(412);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(411);
					nl();
					}
				}

				setState(414);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(416);
				match(FOR);
				setState(417);
				match(T__2);
				setState(418);
				match(SYMBOL);
				setState(419);
				match(INHERIT);
				setState(420);
				operation(0);
				setState(421);
				match(T__3);
				setState(423);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(422);
					nl();
					}
					break;
				}
				setState(426);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(425);
					nl();
					}
				}

				setState(428);
				line();
				setState(430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(429);
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
		enterRule(_localctx, 42, RULE_exp_user);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(USERNAME);
			setState(435);
			match(USEROBJ);
			setState(436);
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
		enterRule(_localctx, 44, RULE_echo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(ECHO);
			setState(439);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_data_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			switch (_input.LA(1)) {
			case INT_TYPE:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(442);
				match(INT_TYPE);
				}
				break;
			case FLOAT_TYPE:
				{
				_localctx = new FloatTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(443);
				match(FLOAT_TYPE);
				}
				break;
			case STRING_TYPE:
				{
				_localctx = new StringTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(444);
				match(STRING_TYPE);
				}
				break;
			case SYMBOL:
				{
				_localctx = new SymbolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(445);
				match(SYMBOL);
				}
				break;
			case ROOM:
				{
				_localctx = new RoomTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(446);
				match(ROOM);
				}
				break;
			case INVENTORY:
				{
				_localctx = new InventoryTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(447);
				match(INVENTORY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListTypeContext(new Data_typeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_data_type);
					setState(450);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(451);
					match(T__10);
					}
					} 
				}
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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

	public static class BoolContext extends ParserRuleContext {
		public Token v;
		public TerminalNode TRUE() { return getToken(COEParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(COEParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			((BoolContext)_localctx).v = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
				((BoolContext)_localctx).v = (Token)_errHandler.recoverInline(this);
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
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitNl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NlContext nl() throws RecognitionException {
		NlContext _localctx = new NlContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_nl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(460); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(459);
					match(T__11);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(462); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
		case 12:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 17:
			return room_path_sempred((Room_pathContext)_localctx, predIndex);
		case 23:
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
			return precpred(_ctx, 20);
		case 2:
			return precpred(_ctx, 19);
		case 3:
			return precpred(_ctx, 18);
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 10);
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
	private boolean data_type_sempred(Data_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u01d3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\5\28\n\2\3\2\3\2\5\2<\n\2\3\2\5\2?\n\2\3\2\3"+
		"\2\5\2C\n\2\3\2\5\2F\n\2\3\3\3\3\3\3\5\3K\n\3\3\3\5\3N\n\3\3\3\3\3\5\3"+
		"R\n\3\3\3\5\3U\n\3\3\3\5\3X\n\3\3\3\3\3\3\4\3\4\3\4\6\4_\n\4\r\4\16\4"+
		"`\3\5\3\5\3\5\3\5\5\5g\n\5\3\6\3\6\5\6k\n\6\6\6m\n\6\r\6\16\6n\3\7\3\7"+
		"\3\7\3\7\5\7u\n\7\3\7\3\7\3\7\5\7z\n\7\3\7\3\7\5\7~\n\7\3\7\3\7\5\7\u0082"+
		"\n\7\3\7\5\7\u0085\n\7\3\7\5\7\u0088\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\7\b\u0092\n\b\f\b\16\b\u0095\13\b\3\t\3\t\3\t\3\t\7\t\u009b\n\t\f\t"+
		"\16\t\u009e\13\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a6\n\n\3\13\3\13\3\13"+
		"\5\13\u00ab\n\13\3\13\3\13\3\13\7\13\u00b0\n\13\f\13\16\13\u00b3\13\13"+
		"\3\f\3\f\3\f\5\f\u00b8\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u00bf\n\f\f\f\16\f"+
		"\u00c2\13\f\5\f\u00c4\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00d0\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u00f1\n\16\f\16\16\16\u00f4\13\16\5\16"+
		"\u00f6\n\16\3\16\5\16\u00f9\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u0115\n\16\f\16\16\16\u0118\13\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0124\n\20\f\20\16\20"+
		"\u0127\13\20\5\20\u0129\n\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\5\23\u0136\n\23\3\23\3\23\3\23\7\23\u013b\n\23\f\23\16\23"+
		"\u013e\13\23\3\24\3\24\3\24\3\24\3\24\5\24\u0145\n\24\3\24\3\24\5\24\u0149"+
		"\n\24\3\24\5\24\u014c\n\24\3\24\5\24\u014f\n\24\3\24\3\24\5\24\u0153\n"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u015a\n\24\3\24\5\24\u015d\n\24\3\24"+
		"\5\24\u0160\n\24\3\24\5\24\u0163\n\24\3\24\5\24\u0166\n\24\5\24\u0168"+
		"\n\24\3\25\5\25\u016b\n\25\3\25\3\25\5\25\u016f\n\25\3\25\3\25\5\25\u0173"+
		"\n\25\3\25\5\25\u0176\n\25\3\25\5\25\u0179\n\25\3\25\3\25\5\25\u017d\n"+
		"\25\3\25\3\25\5\25\u0181\n\25\3\25\5\25\u0184\n\25\3\25\5\25\u0187\n\25"+
		"\3\25\5\25\u018a\n\25\5\25\u018c\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u0195\n\26\3\26\3\26\5\26\u0199\n\26\3\26\5\26\u019c\n\26\3\26"+
		"\5\26\u019f\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01aa"+
		"\n\26\3\26\5\26\u01ad\n\26\3\26\3\26\5\26\u01b1\n\26\5\26\u01b3\n\26\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5"+
		"\31\u01c3\n\31\3\31\3\31\7\31\u01c7\n\31\f\31\16\31\u01ca\13\31\3\32\3"+
		"\32\3\33\6\33\u01cf\n\33\r\33\16\33\u01d0\3\33\2\6\24\32$\60\34\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\7\3\2!\"\3\2#$\3"+
		"\2%*\3\2+,\3\2\27\30\u021c\2E\3\2\2\2\4G\3\2\2\2\6^\3\2\2\2\bb\3\2\2\2"+
		"\nl\3\2\2\2\ft\3\2\2\2\16\u008b\3\2\2\2\20\u0096\3\2\2\2\22\u00a5\3\2"+
		"\2\2\24\u00aa\3\2\2\2\26\u00b7\3\2\2\2\30\u00cf\3\2\2\2\32\u00f8\3\2\2"+
		"\2\34\u0119\3\2\2\2\36\u011d\3\2\2\2 \u012c\3\2\2\2\"\u012f\3\2\2\2$\u0135"+
		"\3\2\2\2&\u0167\3\2\2\2(\u018b\3\2\2\2*\u01b2\3\2\2\2,\u01b4\3\2\2\2."+
		"\u01b8\3\2\2\2\60\u01c2\3\2\2\2\62\u01cb\3\2\2\2\64\u01ce\3\2\2\2\668"+
		"\5\64\33\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29;\5\4\3\2:<\5\64\33\2;"+
		":\3\2\2\2;<\3\2\2\2<F\3\2\2\2=?\5\64\33\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2"+
		"\2@B\5\20\t\2AC\5\64\33\2BA\3\2\2\2BC\3\2\2\2CF\3\2\2\2DF\3\2\2\2E\67"+
		"\3\2\2\2E>\3\2\2\2ED\3\2\2\2F\3\3\2\2\2GJ\7\31\2\2HI\7/\2\2IK\7\31\2\2"+
		"JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\5\64\33\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2"+
		"\2OQ\7\3\2\2PR\5\64\33\2QP\3\2\2\2QR\3\2\2\2RT\3\2\2\2SU\5\6\4\2TS\3\2"+
		"\2\2TU\3\2\2\2UW\3\2\2\2VX\5\n\6\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\4"+
		"\2\2Z\5\3\2\2\2[\\\5\b\5\2\\]\5\64\33\2]_\3\2\2\2^[\3\2\2\2_`\3\2\2\2"+
		"`^\3\2\2\2`a\3\2\2\2a\7\3\2\2\2bc\5\60\31\2cf\7\31\2\2de\7-\2\2eg\5\32"+
		"\16\2fd\3\2\2\2fg\3\2\2\2g\t\3\2\2\2hj\5\f\7\2ik\5\64\33\2ji\3\2\2\2j"+
		"k\3\2\2\2km\3\2\2\2lh\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\13\3\2\2"+
		"\2pq\5\60\31\2qr\7\31\2\2rs\7-\2\2su\3\2\2\2tp\3\2\2\2tu\3\2\2\2uv\3\2"+
		"\2\2vw\7\31\2\2wy\7\5\2\2xz\5\16\b\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{}\7"+
		"\6\2\2|~\5\64\33\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0081\7\3\2\2"+
		"\u0080\u0082\5\64\33\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084"+
		"\3\2\2\2\u0083\u0085\5\20\t\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0087\3\2\2\2\u0086\u0088\5\64\33\2\u0087\u0086\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\4\2\2\u008a\r\3\2\2\2\u008b"+
		"\u008c\5\60\31\2\u008c\u0093\7\31\2\2\u008d\u008e\7\7\2\2\u008e\u008f"+
		"\5\60\31\2\u008f\u0090\7\31\2\2\u0090\u0092\3\2\2\2\u0091\u008d\3\2\2"+
		"\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\17"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u009c\5\22\n\2\u0097\u0098\5\64\33"+
		"\2\u0098\u0099\5\22\n\2\u0099\u009b\3\2\2\2\u009a\u0097\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\21\3\2\2"+
		"\2\u009e\u009c\3\2\2\2\u009f\u00a6\5&\24\2\u00a0\u00a6\5*\26\2\u00a1\u00a6"+
		"\5,\27\2\u00a2\u00a6\5\32\16\2\u00a3\u00a6\5\b\5\2\u00a4\u00a6\5.\30\2"+
		"\u00a5\u009f\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a2"+
		"\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\23\3\2\2\2\u00a7"+
		"\u00a8\b\13\1\2\u00a8\u00ab\7\31\2\2\u00a9\u00ab\5 \21\2\u00aa\u00a7\3"+
		"\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00b1\3\2\2\2\u00ac\u00ad\f\3\2\2\u00ad"+
		"\u00ae\7\b\2\2\u00ae\u00b0\7\31\2\2\u00af\u00ac\3\2\2\2\u00b0\u00b3\3"+
		"\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\25\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b5\5\24\13\2\u00b5\u00b6\7\b\2\2\u00b6\u00b8\3"+
		"\2\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\7\31\2\2\u00ba\u00c3\7\5\2\2\u00bb\u00c0\5\32\16\2\u00bc\u00bd"+
		"\7\7\2\2\u00bd\u00bf\5\32\16\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\7\6\2\2\u00c6\27\3\2\2\2\u00c7\u00c8\5\24\13\2\u00c8\u00c9\7\b"+
		"\2\2\u00c9\u00ca\7\62\2\2\u00ca\u00d0\3\2\2\2\u00cb\u00cc\5\"\22\2\u00cc"+
		"\u00cd\7\b\2\2\u00cd\u00ce\7\62\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00c7\3"+
		"\2\2\2\u00cf\u00cb\3\2\2\2\u00d0\31\3\2\2\2\u00d1\u00d2\b\16\1\2\u00d2"+
		"\u00f9\5\30\r\2\u00d3\u00f9\5\26\f\2\u00d4\u00d5\7$\2\2\u00d5\u00f9\5"+
		"\32\16\30\u00d6\u00d7\7\17\2\2\u00d7\u00f9\5\32\16\27\u00d8\u00d9\5\24"+
		"\13\2\u00d9\u00da\7-\2\2\u00da\u00db\5\32\16\20\u00db\u00f9\3\2\2\2\u00dc"+
		"\u00dd\5\24\13\2\u00dd\u00de\7\t\2\2\u00de\u00df\5\32\16\2\u00df\u00e0"+
		"\7\n\2\2\u00e0\u00e1\7-\2\2\u00e1\u00e2\5\32\16\2\u00e2\u00f9\3\2\2\2"+
		"\u00e3\u00f9\5\24\13\2\u00e4\u00f9\5\36\20\2\u00e5\u00f9\7\33\2\2\u00e6"+
		"\u00f9\7\34\2\2\u00e7\u00f9\5\62\32\2\u00e8\u00f9\7\35\2\2\u00e9\u00f9"+
		"\5 \21\2\u00ea\u00f9\5\"\22\2\u00eb\u00f9\5\34\17\2\u00ec\u00f5\7\3\2"+
		"\2\u00ed\u00f2\5\32\16\2\u00ee\u00ef\7\7\2\2\u00ef\u00f1\5\32\16\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00ed\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\7\4\2\2\u00f8\u00d1\3\2"+
		"\2\2\u00f8\u00d3\3\2\2\2\u00f8\u00d4\3\2\2\2\u00f8\u00d6\3\2\2\2\u00f8"+
		"\u00d8\3\2\2\2\u00f8\u00dc\3\2\2\2\u00f8\u00e3\3\2\2\2\u00f8\u00e4\3\2"+
		"\2\2\u00f8\u00e5\3\2\2\2\u00f8\u00e6\3\2\2\2\u00f8\u00e7\3\2\2\2\u00f8"+
		"\u00e8\3\2\2\2\u00f8\u00e9\3\2\2\2\u00f8\u00ea\3\2\2\2\u00f8\u00eb\3\2"+
		"\2\2\u00f8\u00ec\3\2\2\2\u00f9\u0116\3\2\2\2\u00fa\u00fb\f\26\2\2\u00fb"+
		"\u00fc\7\17\2\2\u00fc\u0115\5\32\16\27\u00fd\u00fe\f\25\2\2\u00fe\u00ff"+
		"\t\2\2\2\u00ff\u0115\5\32\16\26\u0100\u0101\f\24\2\2\u0101\u0102\t\3\2"+
		"\2\u0102\u0115\5\32\16\25\u0103\u0104\f\23\2\2\u0104\u0105\t\4\2\2\u0105"+
		"\u0115\5\32\16\24\u0106\u0107\f\22\2\2\u0107\u0108\t\5\2\2\u0108\u0115"+
		"\5\32\16\23\u0109\u010a\f\21\2\2\u010a\u010b\7\63\2\2\u010b\u0115\5\32"+
		"\16\22\u010c\u010d\f\16\2\2\u010d\u010e\7.\2\2\u010e\u0115\5\32\16\17"+
		"\u010f\u0110\f\f\2\2\u0110\u0111\7\t\2\2\u0111\u0112\5\32\16\2\u0112\u0113"+
		"\7\n\2\2\u0113\u0115\3\2\2\2\u0114\u00fa\3\2\2\2\u0114\u00fd\3\2\2\2\u0114"+
		"\u0100\3\2\2\2\u0114\u0103\3\2\2\2\u0114\u0106\3\2\2\2\u0114\u0109\3\2"+
		"\2\2\u0114\u010c\3\2\2\2\u0114\u010f\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\33\3\2\2\2\u0118\u0116\3\2\2"+
		"\2\u0119\u011a\7\5\2\2\u011a\u011b\5\32\16\2\u011b\u011c\7\6\2\2\u011c"+
		"\35\3\2\2\2\u011d\u011e\7\13\2\2\u011e\u011f\7\31\2\2\u011f\u0128\7\5"+
		"\2\2\u0120\u0125\5\32\16\2\u0121\u0122\7\7\2\2\u0122\u0124\5\32\16\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0120\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\6\2\2\u012b\37\3\2\2"+
		"\2\u012c\u012d\7\f\2\2\u012d\u012e\7\33\2\2\u012e!\3\2\2\2\u012f\u0130"+
		"\7\60\2\2\u0130\u0131\5$\23\2\u0131#\3\2\2\2\u0132\u0133\b\23\1\2\u0133"+
		"\u0136\7\31\2\2\u0134\u0136\3\2\2\2\u0135\u0132\3\2\2\2\u0135\u0134\3"+
		"\2\2\2\u0136\u013c\3\2\2\2\u0137\u0138\f\3\2\2\u0138\u0139\7\"\2\2\u0139"+
		"\u013b\7\31\2\2\u013a\u0137\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3"+
		"\2\2\2\u013c\u013d\3\2\2\2\u013d%\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140"+
		"\7\20\2\2\u0140\u0141\7\5\2\2\u0141\u0142\5\32\16\2\u0142\u0144\7\6\2"+
		"\2\u0143\u0145\5\64\33\2\u0144\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0148\7\3\2\2\u0147\u0149\5\64\33\2\u0148\u0147\3"+
		"\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u014c\5\20\t\2\u014b"+
		"\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014f\5\64"+
		"\33\2\u014e\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0152\7\4\2\2\u0151\u0153\5(\25\2\u0152\u0151\3\2\2\2\u0152\u0153\3\2"+
		"\2\2\u0153\u0168\3\2\2\2\u0154\u0155\7\20\2\2\u0155\u0156\7\5\2\2\u0156"+
		"\u0157\5\32\16\2\u0157\u0159\7\6\2\2\u0158\u015a\5\64\33\2\u0159\u0158"+
		"\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u015d\5\64\33\2"+
		"\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u0160"+
		"\5\22\n\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2"+
		"\u0161\u0163\5\64\33\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165"+
		"\3\2\2\2\u0164\u0166\5(\25\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u0168\3\2\2\2\u0167\u013f\3\2\2\2\u0167\u0154\3\2\2\2\u0168\'\3\2\2\2"+
		"\u0169\u016b\5\64\33\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c"+
		"\3\2\2\2\u016c\u016e\7\21\2\2\u016d\u016f\5\64\33\2\u016e\u016d\3\2\2"+
		"\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\7\3\2\2\u0171\u0173"+
		"\5\64\33\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2"+
		"\u0174\u0176\5\20\t\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178"+
		"\3\2\2\2\u0177\u0179\5\64\33\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2"+
		"\u0179\u017a\3\2\2\2\u017a\u018c\7\4\2\2\u017b\u017d\5\64\33\2\u017c\u017b"+
		"\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\7\21\2\2"+
		"\u017f\u0181\5\64\33\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183"+
		"\3\2\2\2\u0182\u0184\5\64\33\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2"+
		"\u0184\u0186\3\2\2\2\u0185\u0187\5\22\n\2\u0186\u0185\3\2\2\2\u0186\u0187"+
		"\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u018a\5\64\33\2\u0189\u0188\3\2\2\2"+
		"\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b\u016a\3\2\2\2\u018b\u017c"+
		"\3\2\2\2\u018c)\3\2\2\2\u018d\u018e\7\22\2\2\u018e\u018f\7\5\2\2\u018f"+
		"\u0190\7\31\2\2\u0190\u0191\7/\2\2\u0191\u0192\5\32\16\2\u0192\u0194\7"+
		"\6\2\2\u0193\u0195\5\64\33\2\u0194\u0193\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0198\7\3\2\2\u0197\u0199\5\64\33\2\u0198\u0197\3"+
		"\2\2\2\u0198\u0199\3\2\2\2\u0199\u019b\3\2\2\2\u019a\u019c\5\20\t\2\u019b"+
		"\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2\2\2\u019d\u019f\5\64"+
		"\33\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a1\7\4\2\2\u01a1\u01b3\3\2\2\2\u01a2\u01a3\7\22\2\2\u01a3\u01a4\7"+
		"\5\2\2\u01a4\u01a5\7\31\2\2\u01a5\u01a6\7/\2\2\u01a6\u01a7\5\32\16\2\u01a7"+
		"\u01a9\7\6\2\2\u01a8\u01aa\5\64\33\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3"+
		"\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01ad\5\64\33\2\u01ac\u01ab\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\5\22\n\2\u01af\u01b1\5"+
		"\64\33\2\u01b0\u01af\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2"+
		"\u018d\3\2\2\2\u01b2\u01a2\3\2\2\2\u01b3+\3\2\2\2\u01b4\u01b5\7\32\2\2"+
		"\u01b5\u01b6\7\61\2\2\u01b6\u01b7\5\32\16\2\u01b7-\3\2\2\2\u01b8\u01b9"+
		"\7\23\2\2\u01b9\u01ba\5\32\16\2\u01ba/\3\2\2\2\u01bb\u01bc\b\31\1\2\u01bc"+
		"\u01c3\7\24\2\2\u01bd\u01c3\7\25\2\2\u01be\u01c3\7\26\2\2\u01bf\u01c3"+
		"\7\31\2\2\u01c0\u01c3\7\60\2\2\u01c1\u01c3\7\62\2\2\u01c2\u01bb\3\2\2"+
		"\2\u01c2\u01bd\3\2\2\2\u01c2\u01be\3\2\2\2\u01c2\u01bf\3\2\2\2\u01c2\u01c0"+
		"\3\2\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c8\3\2\2\2\u01c4\u01c5\f\3\2\2\u01c5"+
		"\u01c7\7\r\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2"+
		"\2\2\u01c8\u01c9\3\2\2\2\u01c9\61\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc"+
		"\t\6\2\2\u01cc\63\3\2\2\2\u01cd\u01cf\7\16\2\2\u01ce\u01cd\3\2\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\65\3\2\2"+
		"\2I\67;>BEJMQTW`fjnty}\u0081\u0084\u0087\u0093\u009c\u00a5\u00aa\u00b1"+
		"\u00b7\u00c0\u00c3\u00cf\u00f2\u00f5\u00f8\u0114\u0116\u0125\u0128\u0135"+
		"\u013c\u0144\u0148\u014b\u014e\u0152\u0159\u015c\u015f\u0162\u0165\u0167"+
		"\u016a\u016e\u0172\u0175\u0178\u017c\u0180\u0183\u0186\u0189\u018b\u0194"+
		"\u0198\u019b\u019e\u01a9\u01ac\u01b0\u01b2\u01c2\u01c8\u01d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}