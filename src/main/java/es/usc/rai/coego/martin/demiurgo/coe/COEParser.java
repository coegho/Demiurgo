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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, D=15, IF=16, ELSE=17, 
		FOR=18, ECHO=19, INT_TYPE=20, FLOAT_TYPE=21, STRING_TYPE=22, TRUE=23, 
		FALSE=24, NOT=25, INSTANCEOFSYMBOL=26, NULLOBJ=27, SYMBOL=28, USERNAME=29, 
		INT_NUMBER=30, FLOAT_NUMBER=31, TEXT_STRING=32, WS=33, COMMENT=34, COMMENT2=35, 
		MUL=36, DIV=37, ADD=38, SUB=39, EQ=40, NEQ=41, GREQ=42, LESEQ=43, GREAT=44, 
		LESS=45, AND=46, OR=47, ASSIGN=48, MOVE=49, INHERIT=50, ROOM=51, USEROBJ=52, 
		INVENTORY=53, CONCAT=54;
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_fields = 2, RULE_var_decl = 3, RULE_methods = 4, 
		RULE_method = 5, RULE_args = 6, RULE_code = 7, RULE_line = 8, RULE_function_call = 9, 
		RULE_operation = 10, RULE_parens = 11, RULE_new_obj = 12, RULE_sharp_identifier = 13, 
		RULE_room = 14, RULE_region = 15, RULE_room_path = 16, RULE_exp_if = 17, 
		RULE_exp_else = 18, RULE_exp_for = 19, RULE_exp_user = 20, RULE_echo = 21, 
		RULE_data_type = 22, RULE_bool = 23, RULE_nl = 24;
	public static final String[] ruleNames = {
		"s", "class_def", "fields", "var_decl", "methods", "method", "args", "code", 
		"line", "function_call", "operation", "parens", "new_obj", "sharp_identifier", 
		"room", "region", "room_path", "exp_if", "exp_else", "exp_for", "exp_user", 
		"echo", "data_type", "bool", "nl"
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
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(50);
					nl();
					}
				}

				setState(53);
				class_def();
				setState(55);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(54);
					nl();
					}
				}

				}
				break;
			case 2:
				_localctx = new SCodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(57);
					nl();
					}
				}

				setState(60);
				code();
				setState(62);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(61);
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
			setState(67);
			match(SYMBOL);
			setState(70);
			_la = _input.LA(1);
			if (_la==INHERIT) {
				{
				setState(68);
				match(INHERIT);
				setState(69);
				match(SYMBOL);
				}
			}

			setState(73);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(72);
				nl();
				}
			}

			setState(75);
			match(T__0);
			setState(77);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(76);
				nl();
				}
			}

			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(79);
				fields();
				}
				break;
			}
			setState(83);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(82);
				methods();
				}
			}

			setState(85);
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
			setState(90); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(87);
					var_decl();
					setState(88);
					nl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(92); 
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
			setState(94);
			data_type(0);
			setState(95);
			match(SYMBOL);
			setState(98);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(96);
				match(ASSIGN);
				setState(97);
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
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(100);
				method();
				setState(102);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(101);
					nl();
					}
				}

				}
				}
				setState(106); 
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
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(108);
				data_type(0);
				setState(109);
				match(SYMBOL);
				setState(110);
				match(ASSIGN);
				}
				break;
			}
			setState(114);
			((MethodContext)_localctx).metname = match(SYMBOL);
			setState(115);
			match(T__2);
			setState(117);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(116);
				args();
				}
			}

			setState(119);
			match(T__3);
			setState(121);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(120);
				nl();
				}
			}

			setState(123);
			match(T__0);
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(124);
				nl();
				}
				break;
			}
			setState(128);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(127);
				code();
				}
			}

			setState(131);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(130);
				nl();
				}
			}

			setState(133);
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
			setState(135);
			data_type(0);
			setState(136);
			match(SYMBOL);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(137);
				match(T__4);
				setState(138);
				data_type(0);
				setState(139);
				match(SYMBOL);
				}
				}
				setState(145);
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
			setState(146);
			line();
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(147);
					nl();
					setState(148);
					line();
					}
					} 
				}
				setState(154);
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
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
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
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				exp_if();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				exp_for();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				exp_user();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				echo();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				operation(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				var_decl();
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
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
		enterRule(_localctx, 18, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(SYMBOL);
			setState(164);
			match(T__2);
			setState(173);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(165);
				operation(0);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(166);
					match(T__4);
					setState(167);
					operation(0);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(175);
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
	public static class GetLocContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode ROOM() { return getToken(COEParser.ROOM, 0); }
		public GetLocContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitGetLoc(this);
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
	public static class GetUserContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public GetUserContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitGetUser(this);
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
	public static class NullObjContext extends OperationContext {
		public TerminalNode NULLOBJ() { return getToken(COEParser.NULLOBJ, 0); }
		public NullObjContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitNullObj(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetIdContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public GetIdContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitGetId(this);
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
	public static class NotOpContext extends OperationContext {
		public TerminalNode NOT() { return getToken(COEParser.NOT, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public NotOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitNotOp(this);
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
	public static class RoomContentsContext extends OperationContext {
		public RoomContext room() {
			return getRuleContext(RoomContext.class,0);
		}
		public TerminalNode INVENTORY() { return getToken(COEParser.INVENTORY, 0); }
		public RoomContentsContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRoomContents(this);
			else return visitor.visitChildren(this);
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
	public static class IntermediateVariableContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public IntermediateVariableContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitIntermediateVariable(this);
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
	public static class SomeContentsContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode INVENTORY() { return getToken(COEParser.INVENTORY, 0); }
		public SomeContentsContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitSomeContents(this);
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
	public static class MethodOpContext extends OperationContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public MethodOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitMethodOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends OperationContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public VariableContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstanceofOpContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode INSTANCEOFSYMBOL() { return getToken(COEParser.INSTANCEOFSYMBOL, 0); }
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public InstanceofOpContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitInstanceofOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocationContext extends OperationContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode ROOM() { return getToken(COEParser.ROOM, 0); }
		public LocationContext(OperationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitLocation(this);
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
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(COEParser.ASSIGN, 0); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_operation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new RoomContentsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(178);
				room();
				setState(179);
				match(T__5);
				setState(180);
				match(INVENTORY);
				}
				break;
			case 2:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				function_call();
				}
				break;
			case 3:
				{
				_localctx = new NotOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(NOT);
				setState(184);
				operation(23);
				}
				break;
			case 4:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(SUB);
				setState(186);
				operation(22);
				}
				break;
			case 5:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(D);
				setState(188);
				operation(21);
				}
				break;
			case 6:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				match(SYMBOL);
				}
				break;
			case 7:
				{
				_localctx = new NullObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(NULLOBJ);
				}
				break;
			case 8:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				new_obj();
				}
				break;
			case 9:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(INT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(FLOAT_NUMBER);
				}
				break;
			case 11:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				bool();
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(TEXT_STRING);
				}
				break;
			case 13:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				sharp_identifier();
				}
				break;
			case 14:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				room();
				}
				break;
			case 15:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				parens();
				}
				break;
			case 16:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(T__0);
				setState(208);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
					{
					setState(200);
					operation(0);
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(201);
						match(T__4);
						setState(202);
						operation(0);
						}
						}
						setState(207);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(210);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(278);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MultDiceContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(213);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(214);
						match(D);
						setState(215);
						operation(21);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(216);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(217);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(218);
						operation(20);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(219);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(220);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(221);
						operation(19);
						}
						break;
					case 4:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(222);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(223);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(224);
						operation(18);
						}
						break;
					case 5:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(225);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(226);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(227);
						operation(17);
						}
						break;
					case 6:
						{
						_localctx = new ConcatContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(228);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(229);
						match(CONCAT);
						setState(230);
						operation(16);
						}
						break;
					case 7:
						{
						_localctx = new AssignContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(231);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(232);
						match(ASSIGN);
						setState(233);
						operation(15);
						}
						break;
					case 8:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(234);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(235);
						match(MOVE);
						setState(236);
						operation(14);
						}
						break;
					case 9:
						{
						_localctx = new SomeContentsContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(237);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(238);
						match(T__5);
						setState(239);
						match(INVENTORY);
						}
						break;
					case 10:
						{
						_localctx = new MethodOpContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(240);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(241);
						match(T__5);
						setState(242);
						match(SYMBOL);
						setState(243);
						match(T__2);
						setState(252);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
							{
							setState(244);
							operation(0);
							setState(249);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(245);
								match(T__4);
								setState(246);
								operation(0);
								}
								}
								setState(251);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(254);
						match(T__3);
						}
						break;
					case 11:
						{
						_localctx = new IntermediateVariableContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(255);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(256);
						match(T__5);
						setState(257);
						match(SYMBOL);
						}
						break;
					case 12:
						{
						_localctx = new LocationContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(258);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(259);
						match(T__5);
						setState(260);
						match(ROOM);
						}
						break;
					case 13:
						{
						_localctx = new GetUserContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(261);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(262);
						match(T__5);
						setState(263);
						match(T__6);
						}
						break;
					case 14:
						{
						_localctx = new GetIdContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(264);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(265);
						match(T__5);
						setState(266);
						match(T__7);
						}
						break;
					case 15:
						{
						_localctx = new GetLocContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(267);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(268);
						match(T__5);
						setState(269);
						match(ROOM);
						}
						break;
					case 16:
						{
						_localctx = new InstanceofOpContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(270);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(271);
						match(INSTANCEOFSYMBOL);
						setState(272);
						match(SYMBOL);
						}
						break;
					case 17:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(273);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(274);
						match(T__8);
						setState(275);
						operation(0);
						setState(276);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(282);
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
		enterRule(_localctx, 22, RULE_parens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__2);
			setState(284);
			operation(0);
			setState(285);
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
		enterRule(_localctx, 24, RULE_new_obj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__10);
			setState(288);
			match(SYMBOL);
			setState(289);
			match(T__2);
			setState(298);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(290);
				operation(0);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(291);
					match(T__4);
					setState(292);
					operation(0);
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(300);
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
		enterRule(_localctx, 26, RULE_sharp_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(T__7);
			setState(303);
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
		public RoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room; }
	 
		public RoomContext() { }
		public void copyFrom(RoomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ThisRoomContext extends RoomContext {
		public TerminalNode ROOM() { return getToken(COEParser.ROOM, 0); }
		public ThisRoomContext(RoomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitThisRoom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SomeRoomContext extends RoomContext {
		public TerminalNode ROOM() { return getToken(COEParser.ROOM, 0); }
		public Room_pathContext room_path() {
			return getRuleContext(Room_pathContext.class,0);
		}
		public SomeRoomContext(RoomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitSomeRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoomContext room() throws RecognitionException {
		RoomContext _localctx = new RoomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_room);
		try {
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new SomeRoomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(ROOM);
				setState(306);
				room_path(0);
				}
				break;
			case 2:
				_localctx = new ThisRoomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(ROOM);
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

	public static class RegionContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public RegionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_region; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitRegion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegionContext region() throws RecognitionException {
		RegionContext _localctx = new RegionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_region);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__11) | (1L << SYMBOL))) != 0)) ) {
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
		public RegionContext region() {
			return getRuleContext(RegionContext.class,0);
		}
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
		public RegionContext region() {
			return getRuleContext(RegionContext.class,0);
		}
		public LeafRoomContext(Room_pathContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitLeafRoom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelativeRoomContext extends Room_pathContext {
		public RegionContext region() {
			return getRuleContext(RegionContext.class,0);
		}
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
			setState(316);
			switch (_input.LA(1)) {
			case T__5:
			case T__11:
			case SYMBOL:
				{
				_localctx = new RelativeRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(313);
				region();
				}
				break;
			case DIV:
				{
				_localctx = new RootRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				match(DIV);
				setState(315);
				region();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
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
					setState(318);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(319);
					match(DIV);
					setState(320);
					region();
					}
					} 
				}
				setState(325);
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
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				match(IF);
				setState(327);
				match(T__2);
				setState(328);
				operation(0);
				setState(329);
				match(T__3);
				setState(331);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(330);
					nl();
					}
				}

				setState(333);
				match(T__0);
				setState(335);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(334);
					nl();
					}
					break;
				}
				setState(338);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(337);
					code();
					}
				}

				setState(341);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(340);
					nl();
					}
				}

				setState(343);
				match(T__1);
				setState(345);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(344);
					exp_else();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(IF);
				setState(348);
				match(T__2);
				setState(349);
				operation(0);
				setState(350);
				match(T__3);
				setState(352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(351);
					nl();
					}
					break;
				}
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(354);
					nl();
					}
					break;
				}
				setState(358);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(357);
					line();
					}
				}

				setState(361);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(360);
					nl();
					}
					break;
				}
				setState(364);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(363);
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
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(368);
					nl();
					}
				}

				setState(371);
				match(ELSE);
				setState(373);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(372);
					nl();
					}
				}

				setState(375);
				match(T__0);
				setState(377);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(376);
					nl();
					}
					break;
				}
				setState(380);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(379);
					code();
					}
				}

				setState(383);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(382);
					nl();
					}
				}

				setState(385);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(386);
					nl();
					}
				}

				setState(389);
				match(ELSE);
				setState(391);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(390);
					nl();
					}
					break;
				}
				setState(394);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
				case 1:
					{
					setState(393);
					nl();
					}
					break;
				}
				setState(397);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(396);
					line();
					}
				}

				setState(400);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(399);
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
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				match(FOR);
				setState(405);
				match(T__2);
				setState(406);
				match(SYMBOL);
				setState(407);
				match(INHERIT);
				setState(408);
				operation(0);
				setState(409);
				match(T__3);
				setState(411);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(410);
					nl();
					}
				}

				setState(413);
				match(T__0);
				setState(415);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(414);
					nl();
					}
					break;
				}
				setState(418);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(417);
					code();
					}
				}

				setState(421);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(420);
					nl();
					}
				}

				setState(423);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				match(FOR);
				setState(426);
				match(T__2);
				setState(427);
				match(SYMBOL);
				setState(428);
				match(INHERIT);
				setState(429);
				operation(0);
				setState(430);
				match(T__3);
				setState(432);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(431);
					nl();
					}
					break;
				}
				setState(435);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(434);
					nl();
					}
				}

				setState(437);
				line();
				setState(439);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(438);
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
			setState(443);
			match(USERNAME);
			setState(444);
			match(USEROBJ);
			setState(445);
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
			setState(447);
			match(ECHO);
			setState(448);
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
			setState(457);
			switch (_input.LA(1)) {
			case INT_TYPE:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(451);
				match(INT_TYPE);
				}
				break;
			case FLOAT_TYPE:
				{
				_localctx = new FloatTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(452);
				match(FLOAT_TYPE);
				}
				break;
			case STRING_TYPE:
				{
				_localctx = new StringTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(453);
				match(STRING_TYPE);
				}
				break;
			case SYMBOL:
				{
				_localctx = new SymbolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(454);
				match(SYMBOL);
				}
				break;
			case ROOM:
				{
				_localctx = new RoomTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(455);
				match(ROOM);
				}
				break;
			case INVENTORY:
				{
				_localctx = new InventoryTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(456);
				match(INVENTORY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(463);
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
					setState(459);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(460);
					match(T__12);
					}
					} 
				}
				setState(465);
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
		enterRule(_localctx, 46, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
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
		enterRule(_localctx, 48, RULE_nl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(469); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(468);
					match(T__13);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(471); 
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
		case 10:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 16:
			return room_path_sempred((Room_pathContext)_localctx, predIndex);
		case 22:
			return data_type_sempred((Data_typeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean operation_sempred(OperationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
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
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 33);
		case 9:
			return precpred(_ctx, 30);
		case 10:
			return precpred(_ctx, 29);
		case 11:
			return precpred(_ctx, 28);
		case 12:
			return precpred(_ctx, 27);
		case 13:
			return precpred(_ctx, 26);
		case 14:
			return precpred(_ctx, 25);
		case 15:
			return precpred(_ctx, 24);
		case 16:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean room_path_sempred(Room_pathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean data_type_sempred(Data_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\38\u01dc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\5\2\66\n\2\3\2\3\2\5\2:\n\2\3\2\5\2=\n\2\3\2\3\2\5\2A\n"+
		"\2\3\2\5\2D\n\2\3\3\3\3\3\3\5\3I\n\3\3\3\5\3L\n\3\3\3\3\3\5\3P\n\3\3\3"+
		"\5\3S\n\3\3\3\5\3V\n\3\3\3\3\3\3\4\3\4\3\4\6\4]\n\4\r\4\16\4^\3\5\3\5"+
		"\3\5\3\5\5\5e\n\5\3\6\3\6\5\6i\n\6\6\6k\n\6\r\6\16\6l\3\7\3\7\3\7\3\7"+
		"\5\7s\n\7\3\7\3\7\3\7\5\7x\n\7\3\7\3\7\5\7|\n\7\3\7\3\7\5\7\u0080\n\7"+
		"\3\7\5\7\u0083\n\7\3\7\5\7\u0086\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\b\u0090\n\b\f\b\16\b\u0093\13\b\3\t\3\t\3\t\3\t\7\t\u0099\n\t\f\t\16"+
		"\t\u009c\13\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a4\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00ab\n\13\f\13\16\13\u00ae\13\13\5\13\u00b0\n\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ce\n\f\f\f\16\f\u00d1\13\f\5"+
		"\f\u00d3\n\f\3\f\5\f\u00d6\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00fa\n\f\f\f\16\f\u00fd\13\f\5\f\u00ff"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0119\n\f\f\f\16\f\u011c\13\f\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0128\n\16\f\16\16\16\u012b"+
		"\13\16\5\16\u012d\n\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0137"+
		"\n\20\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u013f\n\22\3\22\3\22\3\22\7\22"+
		"\u0144\n\22\f\22\16\22\u0147\13\22\3\23\3\23\3\23\3\23\3\23\5\23\u014e"+
		"\n\23\3\23\3\23\5\23\u0152\n\23\3\23\5\23\u0155\n\23\3\23\5\23\u0158\n"+
		"\23\3\23\3\23\5\23\u015c\n\23\3\23\3\23\3\23\3\23\3\23\5\23\u0163\n\23"+
		"\3\23\5\23\u0166\n\23\3\23\5\23\u0169\n\23\3\23\5\23\u016c\n\23\3\23\5"+
		"\23\u016f\n\23\5\23\u0171\n\23\3\24\5\24\u0174\n\24\3\24\3\24\5\24\u0178"+
		"\n\24\3\24\3\24\5\24\u017c\n\24\3\24\5\24\u017f\n\24\3\24\5\24\u0182\n"+
		"\24\3\24\3\24\5\24\u0186\n\24\3\24\3\24\5\24\u018a\n\24\3\24\5\24\u018d"+
		"\n\24\3\24\5\24\u0190\n\24\3\24\5\24\u0193\n\24\5\24\u0195\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\5\25\u019e\n\25\3\25\3\25\5\25\u01a2\n\25"+
		"\3\25\5\25\u01a5\n\25\3\25\5\25\u01a8\n\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u01b3\n\25\3\25\5\25\u01b6\n\25\3\25\3\25\5\25"+
		"\u01ba\n\25\5\25\u01bc\n\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\5\30\u01cc\n\30\3\30\3\30\7\30\u01d0\n\30"+
		"\f\30\16\30\u01d3\13\30\3\31\3\31\3\32\6\32\u01d8\n\32\r\32\16\32\u01d9"+
		"\3\32\2\5\26\".\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\2\b\3\2&\'\3\2()\3\2*/\3\2\60\61\5\2\b\b\16\16\36\36\3\2\31\32\u022e"+
		"\2C\3\2\2\2\4E\3\2\2\2\6\\\3\2\2\2\b`\3\2\2\2\nj\3\2\2\2\fr\3\2\2\2\16"+
		"\u0089\3\2\2\2\20\u0094\3\2\2\2\22\u00a3\3\2\2\2\24\u00a5\3\2\2\2\26\u00d5"+
		"\3\2\2\2\30\u011d\3\2\2\2\32\u0121\3\2\2\2\34\u0130\3\2\2\2\36\u0136\3"+
		"\2\2\2 \u0138\3\2\2\2\"\u013e\3\2\2\2$\u0170\3\2\2\2&\u0194\3\2\2\2(\u01bb"+
		"\3\2\2\2*\u01bd\3\2\2\2,\u01c1\3\2\2\2.\u01cb\3\2\2\2\60\u01d4\3\2\2\2"+
		"\62\u01d7\3\2\2\2\64\66\5\62\32\2\65\64\3\2\2\2\65\66\3\2\2\2\66\67\3"+
		"\2\2\2\679\5\4\3\28:\5\62\32\298\3\2\2\29:\3\2\2\2:D\3\2\2\2;=\5\62\32"+
		"\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>@\5\20\t\2?A\5\62\32\2@?\3\2\2\2@A\3"+
		"\2\2\2AD\3\2\2\2BD\3\2\2\2C\65\3\2\2\2C<\3\2\2\2CB\3\2\2\2D\3\3\2\2\2"+
		"EH\7\36\2\2FG\7\64\2\2GI\7\36\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JL\5\62"+
		"\32\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2MO\7\3\2\2NP\5\62\32\2ON\3\2\2\2OP"+
		"\3\2\2\2PR\3\2\2\2QS\5\6\4\2RQ\3\2\2\2RS\3\2\2\2SU\3\2\2\2TV\5\n\6\2U"+
		"T\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\4\2\2X\5\3\2\2\2YZ\5\b\5\2Z[\5\62\32"+
		"\2[]\3\2\2\2\\Y\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\7\3\2\2\2`a\5"+
		".\30\2ad\7\36\2\2bc\7\62\2\2ce\5\26\f\2db\3\2\2\2de\3\2\2\2e\t\3\2\2\2"+
		"fh\5\f\7\2gi\5\62\32\2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jf\3\2\2\2kl\3\2\2"+
		"\2lj\3\2\2\2lm\3\2\2\2m\13\3\2\2\2no\5.\30\2op\7\36\2\2pq\7\62\2\2qs\3"+
		"\2\2\2rn\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\36\2\2uw\7\5\2\2vx\5\16\b\2w"+
		"v\3\2\2\2wx\3\2\2\2xy\3\2\2\2y{\7\6\2\2z|\5\62\32\2{z\3\2\2\2{|\3\2\2"+
		"\2|}\3\2\2\2}\177\7\3\2\2~\u0080\5\62\32\2\177~\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\u0082\3\2\2\2\u0081\u0083\5\20\t\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0086\5\62\32\2\u0085\u0084\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\4\2\2\u0088"+
		"\r\3\2\2\2\u0089\u008a\5.\30\2\u008a\u0091\7\36\2\2\u008b\u008c\7\7\2"+
		"\2\u008c\u008d\5.\30\2\u008d\u008e\7\36\2\2\u008e\u0090\3\2\2\2\u008f"+
		"\u008b\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\17\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u009a\5\22\n\2\u0095\u0096"+
		"\5\62\32\2\u0096\u0097\5\22\n\2\u0097\u0099\3\2\2\2\u0098\u0095\3\2\2"+
		"\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\21"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a4\5$\23\2\u009e\u00a4\5(\25\2\u009f"+
		"\u00a4\5*\26\2\u00a0\u00a4\5,\27\2\u00a1\u00a4\5\26\f\2\u00a2\u00a4\5"+
		"\b\5\2\u00a3\u009d\3\2\2\2\u00a3\u009e\3\2\2\2\u00a3\u009f\3\2\2\2\u00a3"+
		"\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\23\3\2\2"+
		"\2\u00a5\u00a6\7\36\2\2\u00a6\u00af\7\5\2\2\u00a7\u00ac\5\26\f\2\u00a8"+
		"\u00a9\7\7\2\2\u00a9\u00ab\5\26\f\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00a7\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b2\7\6\2\2\u00b2\25\3\2\2\2\u00b3\u00b4\b\f\1\2\u00b4\u00b5"+
		"\5\36\20\2\u00b5\u00b6\7\b\2\2\u00b6\u00b7\7\67\2\2\u00b7\u00d6\3\2\2"+
		"\2\u00b8\u00d6\5\24\13\2\u00b9\u00ba\7\33\2\2\u00ba\u00d6\5\26\f\31\u00bb"+
		"\u00bc\7)\2\2\u00bc\u00d6\5\26\f\30\u00bd\u00be\7\21\2\2\u00be\u00d6\5"+
		"\26\f\27\u00bf\u00d6\7\36\2\2\u00c0\u00d6\7\35\2\2\u00c1\u00d6\5\32\16"+
		"\2\u00c2\u00d6\7 \2\2\u00c3\u00d6\7!\2\2\u00c4\u00d6\5\60\31\2\u00c5\u00d6"+
		"\7\"\2\2\u00c6\u00d6\5\34\17\2\u00c7\u00d6\5\36\20\2\u00c8\u00d6\5\30"+
		"\r\2\u00c9\u00d2\7\3\2\2\u00ca\u00cf\5\26\f\2\u00cb\u00cc\7\7\2\2\u00cc"+
		"\u00ce\5\26\f\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3"+
		"\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2"+
		"\u00ca\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\7\4"+
		"\2\2\u00d5\u00b3\3\2\2\2\u00d5\u00b8\3\2\2\2\u00d5\u00b9\3\2\2\2\u00d5"+
		"\u00bb\3\2\2\2\u00d5\u00bd\3\2\2\2\u00d5\u00bf\3\2\2\2\u00d5\u00c0\3\2"+
		"\2\2\u00d5\u00c1\3\2\2\2\u00d5\u00c2\3\2\2\2\u00d5\u00c3\3\2\2\2\u00d5"+
		"\u00c4\3\2\2\2\u00d5\u00c5\3\2\2\2\u00d5\u00c6\3\2\2\2\u00d5\u00c7\3\2"+
		"\2\2\u00d5\u00c8\3\2\2\2\u00d5\u00c9\3\2\2\2\u00d6\u011a\3\2\2\2\u00d7"+
		"\u00d8\f\26\2\2\u00d8\u00d9\7\21\2\2\u00d9\u0119\5\26\f\27\u00da\u00db"+
		"\f\25\2\2\u00db\u00dc\t\2\2\2\u00dc\u0119\5\26\f\26\u00dd\u00de\f\24\2"+
		"\2\u00de\u00df\t\3\2\2\u00df\u0119\5\26\f\25\u00e0\u00e1\f\23\2\2\u00e1"+
		"\u00e2\t\4\2\2\u00e2\u0119\5\26\f\24\u00e3\u00e4\f\22\2\2\u00e4\u00e5"+
		"\t\5\2\2\u00e5\u0119\5\26\f\23\u00e6\u00e7\f\21\2\2\u00e7\u00e8\78\2\2"+
		"\u00e8\u0119\5\26\f\22\u00e9\u00ea\f\20\2\2\u00ea\u00eb\7\62\2\2\u00eb"+
		"\u0119\5\26\f\21\u00ec\u00ed\f\17\2\2\u00ed\u00ee\7\63\2\2\u00ee\u0119"+
		"\5\26\f\20\u00ef\u00f0\f#\2\2\u00f0\u00f1\7\b\2\2\u00f1\u0119\7\67\2\2"+
		"\u00f2\u00f3\f \2\2\u00f3\u00f4\7\b\2\2\u00f4\u00f5\7\36\2\2\u00f5\u00fe"+
		"\7\5\2\2\u00f6\u00fb\5\26\f\2\u00f7\u00f8\7\7\2\2\u00f8\u00fa\5\26\f\2"+
		"\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00f6\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0119\7\6\2\2\u0101\u0102\f\37"+
		"\2\2\u0102\u0103\7\b\2\2\u0103\u0119\7\36\2\2\u0104\u0105\f\36\2\2\u0105"+
		"\u0106\7\b\2\2\u0106\u0119\7\65\2\2\u0107\u0108\f\35\2\2\u0108\u0109\7"+
		"\b\2\2\u0109\u0119\7\t\2\2\u010a\u010b\f\34\2\2\u010b\u010c\7\b\2\2\u010c"+
		"\u0119\7\n\2\2\u010d\u010e\f\33\2\2\u010e\u010f\7\b\2\2\u010f\u0119\7"+
		"\65\2\2\u0110\u0111\f\32\2\2\u0111\u0112\7\34\2\2\u0112\u0119\7\36\2\2"+
		"\u0113\u0114\f\f\2\2\u0114\u0115\7\13\2\2\u0115\u0116\5\26\f\2\u0116\u0117"+
		"\7\f\2\2\u0117\u0119\3\2\2\2\u0118\u00d7\3\2\2\2\u0118\u00da\3\2\2\2\u0118"+
		"\u00dd\3\2\2\2\u0118\u00e0\3\2\2\2\u0118\u00e3\3\2\2\2\u0118\u00e6\3\2"+
		"\2\2\u0118\u00e9\3\2\2\2\u0118\u00ec\3\2\2\2\u0118\u00ef\3\2\2\2\u0118"+
		"\u00f2\3\2\2\2\u0118\u0101\3\2\2\2\u0118\u0104\3\2\2\2\u0118\u0107\3\2"+
		"\2\2\u0118\u010a\3\2\2\2\u0118\u010d\3\2\2\2\u0118\u0110\3\2\2\2\u0118"+
		"\u0113\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2"+
		"\2\2\u011b\27\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7\5\2\2\u011e\u011f"+
		"\5\26\f\2\u011f\u0120\7\6\2\2\u0120\31\3\2\2\2\u0121\u0122\7\r\2\2\u0122"+
		"\u0123\7\36\2\2\u0123\u012c\7\5\2\2\u0124\u0129\5\26\f\2\u0125\u0126\7"+
		"\7\2\2\u0126\u0128\5\26\f\2\u0127\u0125\3\2\2\2\u0128\u012b\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012c\u0124\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\7\6\2\2\u012f\33\3\2\2\2\u0130\u0131\7\n\2\2\u0131\u0132\7 \2\2"+
		"\u0132\35\3\2\2\2\u0133\u0134\7\65\2\2\u0134\u0137\5\"\22\2\u0135\u0137"+
		"\7\65\2\2\u0136\u0133\3\2\2\2\u0136\u0135\3\2\2\2\u0137\37\3\2\2\2\u0138"+
		"\u0139\t\6\2\2\u0139!\3\2\2\2\u013a\u013b\b\22\1\2\u013b\u013f\5 \21\2"+
		"\u013c\u013d\7\'\2\2\u013d\u013f\5 \21\2\u013e\u013a\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013f\u0145\3\2\2\2\u0140\u0141\f\3\2\2\u0141\u0142\7\'\2\2\u0142"+
		"\u0144\5 \21\2\u0143\u0140\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2"+
		"\2\2\u0145\u0146\3\2\2\2\u0146#\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149"+
		"\7\22\2\2\u0149\u014a\7\5\2\2\u014a\u014b\5\26\f\2\u014b\u014d\7\6\2\2"+
		"\u014c\u014e\5\62\32\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014f\u0151\7\3\2\2\u0150\u0152\5\62\32\2\u0151\u0150\3\2\2\2"+
		"\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0155\5\20\t\2\u0154\u0153"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0158\5\62\32\2"+
		"\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b"+
		"\7\4\2\2\u015a\u015c\5&\24\2\u015b\u015a\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u0171\3\2\2\2\u015d\u015e\7\22\2\2\u015e\u015f\7\5\2\2\u015f\u0160\5"+
		"\26\f\2\u0160\u0162\7\6\2\2\u0161\u0163\5\62\32\2\u0162\u0161\3\2\2\2"+
		"\u0162\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0166\5\62\32\2\u0165\u0164"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0169\5\22\n\2"+
		"\u0168\u0167\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u016c"+
		"\5\62\32\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2"+
		"\u016d\u016f\5&\24\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171"+
		"\3\2\2\2\u0170\u0148\3\2\2\2\u0170\u015d\3\2\2\2\u0171%\3\2\2\2\u0172"+
		"\u0174\5\62\32\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3"+
		"\2\2\2\u0175\u0177\7\23\2\2\u0176\u0178\5\62\32\2\u0177\u0176\3\2\2\2"+
		"\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\7\3\2\2\u017a\u017c"+
		"\5\62\32\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2"+
		"\u017d\u017f\5\20\t\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181"+
		"\3\2\2\2\u0180\u0182\5\62\32\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2"+
		"\u0182\u0183\3\2\2\2\u0183\u0195\7\4\2\2\u0184\u0186\5\62\32\2\u0185\u0184"+
		"\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\7\23\2\2"+
		"\u0188\u018a\5\62\32\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018c"+
		"\3\2\2\2\u018b\u018d\5\62\32\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2"+
		"\u018d\u018f\3\2\2\2\u018e\u0190\5\22\n\2\u018f\u018e\3\2\2\2\u018f\u0190"+
		"\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u0193\5\62\32\2\u0192\u0191\3\2\2\2"+
		"\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0173\3\2\2\2\u0194\u0185"+
		"\3\2\2\2\u0195\'\3\2\2\2\u0196\u0197\7\24\2\2\u0197\u0198\7\5\2\2\u0198"+
		"\u0199\7\36\2\2\u0199\u019a\7\64\2\2\u019a\u019b\5\26\f\2\u019b\u019d"+
		"\7\6\2\2\u019c\u019e\5\62\32\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2"+
		"\u019e\u019f\3\2\2\2\u019f\u01a1\7\3\2\2\u01a0\u01a2\5\62\32\2\u01a1\u01a0"+
		"\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a5\5\20\t\2"+
		"\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a8"+
		"\5\62\32\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2"+
		"\u01a9\u01aa\7\4\2\2\u01aa\u01bc\3\2\2\2\u01ab\u01ac\7\24\2\2\u01ac\u01ad"+
		"\7\5\2\2\u01ad\u01ae\7\36\2\2\u01ae\u01af\7\64\2\2\u01af\u01b0\5\26\f"+
		"\2\u01b0\u01b2\7\6\2\2\u01b1\u01b3\5\62\32\2\u01b2\u01b1\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b6\5\62\32\2\u01b5\u01b4\3"+
		"\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\5\22\n\2\u01b8"+
		"\u01ba\5\62\32\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc\3"+
		"\2\2\2\u01bb\u0196\3\2\2\2\u01bb\u01ab\3\2\2\2\u01bc)\3\2\2\2\u01bd\u01be"+
		"\7\37\2\2\u01be\u01bf\7\66\2\2\u01bf\u01c0\5\26\f\2\u01c0+\3\2\2\2\u01c1"+
		"\u01c2\7\25\2\2\u01c2\u01c3\5\26\f\2\u01c3-\3\2\2\2\u01c4\u01c5\b\30\1"+
		"\2\u01c5\u01cc\7\26\2\2\u01c6\u01cc\7\27\2\2\u01c7\u01cc\7\30\2\2\u01c8"+
		"\u01cc\7\36\2\2\u01c9\u01cc\7\65\2\2\u01ca\u01cc\7\67\2\2\u01cb\u01c4"+
		"\3\2\2\2\u01cb\u01c6\3\2\2\2\u01cb\u01c7\3\2\2\2\u01cb\u01c8\3\2\2\2\u01cb"+
		"\u01c9\3\2\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01d1\3\2\2\2\u01cd\u01ce\f\3"+
		"\2\2\u01ce\u01d0\7\17\2\2\u01cf\u01cd\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2/\3\2\2\2\u01d3\u01d1\3\2\2\2"+
		"\u01d4\u01d5\t\7\2\2\u01d5\61\3\2\2\2\u01d6\u01d8\7\20\2\2\u01d7\u01d6"+
		"\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\63\3\2\2\2H\659<@CHKORU^dhlrw{\177\u0082\u0085\u0091\u009a\u00a3\u00ac"+
		"\u00af\u00cf\u00d2\u00d5\u00fb\u00fe\u0118\u011a\u0129\u012c\u0136\u013e"+
		"\u0145\u014d\u0151\u0154\u0157\u015b\u0162\u0165\u0168\u016b\u016e\u0170"+
		"\u0173\u0177\u017b\u017e\u0181\u0185\u0189\u018c\u018f\u0192\u0194\u019d"+
		"\u01a1\u01a4\u01a7\u01b2\u01b5\u01b9\u01bb\u01cb\u01d1\u01d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}