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
		FALSE=24, NOT=25, INSTANCEOFSYMBOL=26, NULLOBJ=27, THROWKEY=28, STATICKEY=29, 
		SYMBOL=30, USERNAME=31, INT_NUMBER=32, FLOAT_NUMBER=33, TEXT_STRING=34, 
		WS=35, COMMENT=36, COMMENT2=37, MUL=38, DIV=39, ADD=40, SUB=41, EQ=42, 
		NEQ=43, GREQ=44, LESEQ=45, GREAT=46, LESS=47, AND=48, OR=49, ASSIGN=50, 
		MOVE=51, INHERIT=52, ROOM=53, USEROBJ=54, INVENTORY=55, CONCAT=56;
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_fields = 2, RULE_field_decl = 3, 
		RULE_var_decl = 4, RULE_methods = 5, RULE_method = 6, RULE_args = 7, RULE_code = 8, 
		RULE_line = 9, RULE_function_call = 10, RULE_tags = 11, RULE_operation = 12, 
		RULE_parens = 13, RULE_new_obj = 14, RULE_sharp_identifier = 15, RULE_room = 16, 
		RULE_region = 17, RULE_room_path = 18, RULE_exp_if = 19, RULE_exp_else = 20, 
		RULE_exp_for = 21, RULE_exp_user = 22, RULE_exp_throw = 23, RULE_echo = 24, 
		RULE_data_type = 25, RULE_bool = 26, RULE_nl = 27;
	public static final String[] ruleNames = {
		"s", "class_def", "fields", "field_decl", "var_decl", "methods", "method", 
		"args", "code", "line", "function_call", "tags", "operation", "parens", 
		"new_obj", "sharp_identifier", "room", "region", "room_path", "exp_if", 
		"exp_else", "exp_for", "exp_user", "exp_throw", "echo", "data_type", "bool", 
		"nl"
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
		public TerminalNode EOF() { return getToken(COEParser.EOF, 0); }
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
		public TerminalNode EOF() { return getToken(COEParser.EOF, 0); }
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
		public TerminalNode EOF() { return getToken(COEParser.EOF, 0); }
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
		}
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
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(56);
					nl();
					}
				}

				setState(59);
				class_def();
				setState(61);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(60);
					nl();
					}
				}

				setState(63);
				match(EOF);
				}
				break;
			case 2:
				_localctx = new SCodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(65);
					nl();
					}
				}

				setState(68);
				code();
				setState(70);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(69);
					nl();
					}
				}

				setState(72);
				match(EOF);
				}
				break;
			case 3:
				_localctx = new EmptyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(74);
					nl();
					}
				}

				setState(77);
				match(EOF);
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
			setState(80);
			match(SYMBOL);
			setState(83);
			_la = _input.LA(1);
			if (_la==INHERIT) {
				{
				setState(81);
				match(INHERIT);
				setState(82);
				match(SYMBOL);
				}
			}

			setState(86);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(85);
				nl();
				}
			}

			setState(88);
			match(T__0);
			setState(90);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(89);
				nl();
				}
			}

			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(92);
				fields();
				}
				break;
			}
			setState(96);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << LESS) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(95);
				methods();
				}
			}

			setState(98);
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
		public List<Field_declContext> field_decl() {
			return getRuleContexts(Field_declContext.class);
		}
		public Field_declContext field_decl(int i) {
			return getRuleContext(Field_declContext.class,i);
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
			setState(103); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(100);
					field_decl();
					setState(101);
					nl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(105); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Field_declContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public TagsContext tags() {
			return getRuleContext(TagsContext.class,0);
		}
		public TerminalNode STATICKEY() { return getToken(COEParser.STATICKEY, 0); }
		public TerminalNode ASSIGN() { return getToken(COEParser.ASSIGN, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
		}
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitField_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declContext field_decl() throws RecognitionException {
		Field_declContext _localctx = new Field_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(107);
				tags();
				setState(109);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(108);
					nl();
					}
				}

				}
			}

			setState(114);
			_la = _input.LA(1);
			if (_la==STATICKEY) {
				{
				setState(113);
				match(STATICKEY);
				}
			}

			setState(116);
			data_type(0);
			setState(117);
			match(SYMBOL);
			setState(120);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(118);
				match(ASSIGN);
				setState(119);
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
		enterRule(_localctx, 8, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			data_type(0);
			setState(123);
			match(SYMBOL);
			setState(126);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(124);
				match(ASSIGN);
				setState(125);
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
		enterRule(_localctx, 10, RULE_methods);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				method();
				setState(130);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(129);
					nl();
					}
				}

				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << LESS) | (1L << ROOM) | (1L << INVENTORY))) != 0) );
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
		public TagsContext tags() {
			return getRuleContext(TagsContext.class,0);
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
		enterRule(_localctx, 12, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if (_la==LESS) {
				{
				setState(136);
				tags();
				setState(138);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(137);
					nl();
					}
				}

				}
			}

			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(142);
				data_type(0);
				setState(143);
				match(SYMBOL);
				setState(144);
				match(ASSIGN);
				}
				break;
			}
			setState(148);
			((MethodContext)_localctx).metname = match(SYMBOL);
			setState(149);
			match(T__2);
			setState(151);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << SYMBOL) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(150);
				args();
				}
			}

			setState(153);
			match(T__3);
			setState(155);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(154);
				nl();
				}
			}

			setState(157);
			match(T__0);
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(158);
				nl();
				}
				break;
			}
			setState(162);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << THROWKEY) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
				{
				setState(161);
				code();
				}
			}

			setState(165);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(164);
				nl();
				}
			}

			setState(167);
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
		enterRule(_localctx, 14, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			data_type(0);
			setState(170);
			match(SYMBOL);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(171);
				match(T__4);
				setState(172);
				data_type(0);
				setState(173);
				match(SYMBOL);
				}
				}
				setState(179);
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
		enterRule(_localctx, 16, RULE_code);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			line();
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(181);
					nl();
					setState(182);
					line();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		public Exp_throwContext exp_throw() {
			return getRuleContext(Exp_throwContext.class,0);
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
		enterRule(_localctx, 18, RULE_line);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				exp_if();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				exp_for();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				exp_user();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				exp_throw();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				echo();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
				operation(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(195);
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
		enterRule(_localctx, 20, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(SYMBOL);
			setState(199);
			match(T__2);
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

	public static class TagsContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(COEParser.SYMBOL, 0); }
		public TagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tags; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitTags(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagsContext tags() throws RecognitionException {
		TagsContext _localctx = new TagsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(LESS);
			setState(213);
			match(SYMBOL);
			setState(214);
			match(GREAT);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_operation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new RoomContentsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(217);
				room();
				setState(218);
				match(T__5);
				setState(219);
				match(INVENTORY);
				}
				break;
			case 2:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				function_call();
				}
				break;
			case 3:
				{
				_localctx = new NotOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(NOT);
				setState(223);
				operation(23);
				}
				break;
			case 4:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(SUB);
				setState(225);
				operation(22);
				}
				break;
			case 5:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(D);
				setState(227);
				operation(21);
				}
				break;
			case 6:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(SYMBOL);
				}
				break;
			case 7:
				{
				_localctx = new NullObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(NULLOBJ);
				}
				break;
			case 8:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				new_obj();
				}
				break;
			case 9:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(INT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(FLOAT_NUMBER);
				}
				break;
			case 11:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				bool();
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(TEXT_STRING);
				}
				break;
			case 13:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				sharp_identifier();
				}
				break;
			case 14:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				room();
				}
				break;
			case 15:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				parens();
				}
				break;
			case 16:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(T__0);
				setState(247);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
					{
					setState(239);
					operation(0);
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(240);
						match(T__4);
						setState(241);
						operation(0);
						}
						}
						setState(246);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(249);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(317);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new MultDiceContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(252);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(253);
						match(D);
						setState(254);
						operation(21);
						}
						break;
					case 2:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(255);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(256);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(257);
						operation(20);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(258);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(259);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(260);
						operation(19);
						}
						break;
					case 4:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(261);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(262);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(263);
						operation(18);
						}
						break;
					case 5:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(264);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(265);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(266);
						operation(17);
						}
						break;
					case 6:
						{
						_localctx = new ConcatContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(267);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(268);
						match(CONCAT);
						setState(269);
						operation(16);
						}
						break;
					case 7:
						{
						_localctx = new AssignContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(270);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(271);
						match(ASSIGN);
						setState(272);
						operation(15);
						}
						break;
					case 8:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(273);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(274);
						match(MOVE);
						setState(275);
						operation(14);
						}
						break;
					case 9:
						{
						_localctx = new SomeContentsContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(276);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(277);
						match(T__5);
						setState(278);
						match(INVENTORY);
						}
						break;
					case 10:
						{
						_localctx = new MethodOpContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(279);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(280);
						match(T__5);
						setState(281);
						match(SYMBOL);
						setState(282);
						match(T__2);
						setState(291);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
							{
							setState(283);
							operation(0);
							setState(288);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(284);
								match(T__4);
								setState(285);
								operation(0);
								}
								}
								setState(290);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(293);
						match(T__3);
						}
						break;
					case 11:
						{
						_localctx = new IntermediateVariableContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(294);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(295);
						match(T__5);
						setState(296);
						match(SYMBOL);
						}
						break;
					case 12:
						{
						_localctx = new LocationContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(297);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(298);
						match(T__5);
						setState(299);
						match(ROOM);
						}
						break;
					case 13:
						{
						_localctx = new GetUserContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(300);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(301);
						match(T__5);
						setState(302);
						match(T__6);
						}
						break;
					case 14:
						{
						_localctx = new GetIdContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(303);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(304);
						match(T__5);
						setState(305);
						match(T__7);
						}
						break;
					case 15:
						{
						_localctx = new GetLocContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(306);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(307);
						match(T__5);
						setState(308);
						match(ROOM);
						}
						break;
					case 16:
						{
						_localctx = new InstanceofOpContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(309);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(310);
						match(INSTANCEOFSYMBOL);
						setState(311);
						match(SYMBOL);
						}
						break;
					case 17:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(312);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(313);
						match(T__8);
						setState(314);
						operation(0);
						setState(315);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
			setState(322);
			match(T__2);
			setState(323);
			operation(0);
			setState(324);
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
			setState(326);
			match(T__10);
			setState(327);
			match(SYMBOL);
			setState(328);
			match(T__2);
			setState(337);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(329);
				operation(0);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(330);
					match(T__4);
					setState(331);
					operation(0);
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(339);
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
			setState(341);
			match(T__7);
			setState(342);
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
		enterRule(_localctx, 32, RULE_room);
		try {
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new SomeRoomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				match(ROOM);
				setState(345);
				room_path(0);
				}
				break;
			case 2:
				_localctx = new ThisRoomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
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
		enterRule(_localctx, 34, RULE_region);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_room_path, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			switch (_input.LA(1)) {
			case T__5:
			case T__11:
			case SYMBOL:
				{
				_localctx = new RelativeRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(352);
				region();
				}
				break;
			case DIV:
				{
				_localctx = new RootRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353);
				match(DIV);
				setState(354);
				region();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(362);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LeafRoomContext(new Room_pathContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_room_path);
					setState(357);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(358);
					match(DIV);
					setState(359);
					region();
					}
					} 
				}
				setState(364);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
		enterRule(_localctx, 38, RULE_exp_if);
		int _la;
		try {
			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				match(IF);
				setState(366);
				match(T__2);
				setState(367);
				operation(0);
				setState(368);
				match(T__3);
				setState(370);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(369);
					nl();
					}
				}

				setState(372);
				match(T__0);
				setState(374);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(373);
					nl();
					}
					break;
				}
				setState(377);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << THROWKEY) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(376);
					code();
					}
				}

				setState(380);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(379);
					nl();
					}
				}

				setState(382);
				match(T__1);
				setState(384);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(383);
					exp_else();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				match(IF);
				setState(387);
				match(T__2);
				setState(388);
				operation(0);
				setState(389);
				match(T__3);
				setState(391);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(390);
					nl();
					}
					break;
				}
				setState(394);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(393);
					nl();
					}
					break;
				}
				setState(397);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << THROWKEY) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(396);
					line();
					}
				}

				setState(400);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(399);
					nl();
					}
					break;
				}
				setState(403);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
				case 1:
					{
					setState(402);
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
		enterRule(_localctx, 40, RULE_exp_else);
		int _la;
		try {
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(407);
					nl();
					}
				}

				setState(410);
				match(ELSE);
				setState(412);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(411);
					nl();
					}
				}

				setState(414);
				match(T__0);
				setState(416);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(415);
					nl();
					}
					break;
				}
				setState(419);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << THROWKEY) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(418);
					code();
					}
				}

				setState(422);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(421);
					nl();
					}
				}

				setState(424);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(425);
					nl();
					}
				}

				setState(428);
				match(ELSE);
				setState(430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(429);
					nl();
					}
					break;
				}
				setState(433);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(432);
					nl();
					}
					break;
				}
				setState(436);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << THROWKEY) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(435);
					line();
					}
				}

				setState(439);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
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
		enterRule(_localctx, 42, RULE_exp_for);
		int _la;
		try {
			setState(480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				match(FOR);
				setState(444);
				match(T__2);
				setState(445);
				match(SYMBOL);
				setState(446);
				match(INHERIT);
				setState(447);
				operation(0);
				setState(448);
				match(T__3);
				setState(450);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(449);
					nl();
					}
				}

				setState(452);
				match(T__0);
				setState(454);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(453);
					nl();
					}
					break;
				}
				setState(457);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__7) | (1L << T__10) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << ECHO) | (1L << INT_TYPE) | (1L << FLOAT_TYPE) | (1L << STRING_TYPE) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << NULLOBJ) | (1L << THROWKEY) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM) | (1L << INVENTORY))) != 0)) {
					{
					setState(456);
					code();
					}
				}

				setState(460);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(459);
					nl();
					}
				}

				setState(462);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
				match(FOR);
				setState(465);
				match(T__2);
				setState(466);
				match(SYMBOL);
				setState(467);
				match(INHERIT);
				setState(468);
				operation(0);
				setState(469);
				match(T__3);
				setState(471);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(470);
					nl();
					}
					break;
				}
				setState(474);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(473);
					nl();
					}
				}

				setState(476);
				line();
				setState(478);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(477);
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
		enterRule(_localctx, 44, RULE_exp_user);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(USERNAME);
			setState(483);
			match(USEROBJ);
			setState(484);
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

	public static class Exp_throwContext extends ParserRuleContext {
		public TerminalNode THROWKEY() { return getToken(COEParser.THROWKEY, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Exp_throwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_throw; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof COEVisitor ) return ((COEVisitor<? extends T>)visitor).visitExp_throw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_throwContext exp_throw() throws RecognitionException {
		Exp_throwContext _localctx = new Exp_throwContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exp_throw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(THROWKEY);
			setState(487);
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
		enterRule(_localctx, 48, RULE_echo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(ECHO);
			setState(490);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_data_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			switch (_input.LA(1)) {
			case INT_TYPE:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(493);
				match(INT_TYPE);
				}
				break;
			case FLOAT_TYPE:
				{
				_localctx = new FloatTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(494);
				match(FLOAT_TYPE);
				}
				break;
			case STRING_TYPE:
				{
				_localctx = new StringTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(495);
				match(STRING_TYPE);
				}
				break;
			case SYMBOL:
				{
				_localctx = new SymbolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(496);
				match(SYMBOL);
				}
				break;
			case ROOM:
				{
				_localctx = new RoomTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(497);
				match(ROOM);
				}
				break;
			case INVENTORY:
				{
				_localctx = new InventoryTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(498);
				match(INVENTORY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(505);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListTypeContext(new Data_typeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_data_type);
					setState(501);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(502);
					match(T__12);
					}
					} 
				}
				setState(507);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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
		enterRule(_localctx, 52, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
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
		enterRule(_localctx, 54, RULE_nl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(511); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(510);
					match(T__13);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(513); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
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
		case 12:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 18:
			return room_path_sempred((Room_pathContext)_localctx, predIndex);
		case 25:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3:\u0206\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\5\2<\n\2\3\2\3\2\5\2@\n\2"+
		"\3\2\3\2\3\2\5\2E\n\2\3\2\3\2\5\2I\n\2\3\2\3\2\3\2\5\2N\n\2\3\2\5\2Q\n"+
		"\2\3\3\3\3\3\3\5\3V\n\3\3\3\5\3Y\n\3\3\3\3\3\5\3]\n\3\3\3\5\3`\n\3\3\3"+
		"\5\3c\n\3\3\3\3\3\3\4\3\4\3\4\6\4j\n\4\r\4\16\4k\3\5\3\5\5\5p\n\5\5\5"+
		"r\n\5\3\5\5\5u\n\5\3\5\3\5\3\5\3\5\5\5{\n\5\3\6\3\6\3\6\3\6\5\6\u0081"+
		"\n\6\3\7\3\7\5\7\u0085\n\7\6\7\u0087\n\7\r\7\16\7\u0088\3\b\3\b\5\b\u008d"+
		"\n\b\5\b\u008f\n\b\3\b\3\b\3\b\3\b\5\b\u0095\n\b\3\b\3\b\3\b\5\b\u009a"+
		"\n\b\3\b\3\b\5\b\u009e\n\b\3\b\3\b\5\b\u00a2\n\b\3\b\5\b\u00a5\n\b\3\b"+
		"\5\b\u00a8\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b2\n\t\f\t\16\t"+
		"\u00b5\13\t\3\n\3\n\3\n\3\n\7\n\u00bb\n\n\f\n\16\n\u00be\13\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00c7\n\13\3\f\3\f\3\f\3\f\3\f\7\f\u00ce"+
		"\n\f\f\f\16\f\u00d1\13\f\5\f\u00d3\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00f5\n\16"+
		"\f\16\16\16\u00f8\13\16\5\16\u00fa\n\16\3\16\5\16\u00fd\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u0121\n\16\f\16\16\16\u0124\13\16\5\16\u0126"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0140\n\16"+
		"\f\16\16\16\u0143\13\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\7\20\u014f\n\20\f\20\16\20\u0152\13\20\5\20\u0154\n\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\5\22\u015e\n\22\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\5\24\u0166\n\24\3\24\3\24\3\24\7\24\u016b\n\24\f\24\16\24\u016e"+
		"\13\24\3\25\3\25\3\25\3\25\3\25\5\25\u0175\n\25\3\25\3\25\5\25\u0179\n"+
		"\25\3\25\5\25\u017c\n\25\3\25\5\25\u017f\n\25\3\25\3\25\5\25\u0183\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\5\25\u018a\n\25\3\25\5\25\u018d\n\25\3\25\5"+
		"\25\u0190\n\25\3\25\5\25\u0193\n\25\3\25\5\25\u0196\n\25\5\25\u0198\n"+
		"\25\3\26\5\26\u019b\n\26\3\26\3\26\5\26\u019f\n\26\3\26\3\26\5\26\u01a3"+
		"\n\26\3\26\5\26\u01a6\n\26\3\26\5\26\u01a9\n\26\3\26\3\26\5\26\u01ad\n"+
		"\26\3\26\3\26\5\26\u01b1\n\26\3\26\5\26\u01b4\n\26\3\26\5\26\u01b7\n\26"+
		"\3\26\5\26\u01ba\n\26\5\26\u01bc\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\5\27\u01c5\n\27\3\27\3\27\5\27\u01c9\n\27\3\27\5\27\u01cc\n\27\3\27"+
		"\5\27\u01cf\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01da"+
		"\n\27\3\27\5\27\u01dd\n\27\3\27\3\27\5\27\u01e1\n\27\5\27\u01e3\n\27\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\5\33\u01f6\n\33\3\33\3\33\7\33\u01fa\n\33\f\33\16\33\u01fd"+
		"\13\33\3\34\3\34\3\35\6\35\u0202\n\35\r\35\16\35\u0203\3\35\2\5\32&\64"+
		"\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\b\3"+
		"\2()\3\2*+\3\2,\61\3\2\62\63\5\2\b\b\16\16  \3\2\31\32\u025d\2P\3\2\2"+
		"\2\4R\3\2\2\2\6i\3\2\2\2\bq\3\2\2\2\n|\3\2\2\2\f\u0086\3\2\2\2\16\u008e"+
		"\3\2\2\2\20\u00ab\3\2\2\2\22\u00b6\3\2\2\2\24\u00c6\3\2\2\2\26\u00c8\3"+
		"\2\2\2\30\u00d6\3\2\2\2\32\u00fc\3\2\2\2\34\u0144\3\2\2\2\36\u0148\3\2"+
		"\2\2 \u0157\3\2\2\2\"\u015d\3\2\2\2$\u015f\3\2\2\2&\u0165\3\2\2\2(\u0197"+
		"\3\2\2\2*\u01bb\3\2\2\2,\u01e2\3\2\2\2.\u01e4\3\2\2\2\60\u01e8\3\2\2\2"+
		"\62\u01eb\3\2\2\2\64\u01f5\3\2\2\2\66\u01fe\3\2\2\28\u0201\3\2\2\2:<\5"+
		"8\35\2;:\3\2\2\2;<\3\2\2\2<=\3\2\2\2=?\5\4\3\2>@\58\35\2?>\3\2\2\2?@\3"+
		"\2\2\2@A\3\2\2\2AB\7\2\2\3BQ\3\2\2\2CE\58\35\2DC\3\2\2\2DE\3\2\2\2EF\3"+
		"\2\2\2FH\5\22\n\2GI\58\35\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\2\2\3KQ"+
		"\3\2\2\2LN\58\35\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OQ\7\2\2\3P;\3\2\2\2P"+
		"D\3\2\2\2PM\3\2\2\2Q\3\3\2\2\2RU\7 \2\2ST\7\66\2\2TV\7 \2\2US\3\2\2\2"+
		"UV\3\2\2\2VX\3\2\2\2WY\58\35\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\7\3\2"+
		"\2[]\58\35\2\\[\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^`\5\6\4\2_^\3\2\2\2_`\3\2"+
		"\2\2`b\3\2\2\2ac\5\f\7\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\4\2\2e\5\3"+
		"\2\2\2fg\5\b\5\2gh\58\35\2hj\3\2\2\2if\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3"+
		"\2\2\2l\7\3\2\2\2mo\5\30\r\2np\58\35\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2q"+
		"m\3\2\2\2qr\3\2\2\2rt\3\2\2\2su\7\37\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2"+
		"vw\5\64\33\2wz\7 \2\2xy\7\64\2\2y{\5\32\16\2zx\3\2\2\2z{\3\2\2\2{\t\3"+
		"\2\2\2|}\5\64\33\2}\u0080\7 \2\2~\177\7\64\2\2\177\u0081\5\32\16\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\13\3\2\2\2\u0082\u0084\5\16\b\2\u0083"+
		"\u0085\58\35\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2"+
		"\2\2\u0086\u0082\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\r\3\2\2\2\u008a\u008c\5\30\r\2\u008b\u008d\58\35"+
		"\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008a"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0094\3\2\2\2\u0090\u0091\5\64\33\2"+
		"\u0091\u0092\7 \2\2\u0092\u0093\7\64\2\2\u0093\u0095\3\2\2\2\u0094\u0090"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\7 \2\2\u0097"+
		"\u0099\7\5\2\2\u0098\u009a\5\20\t\2\u0099\u0098\3\2\2\2\u0099\u009a\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\7\6\2\2\u009c\u009e\58\35\2\u009d"+
		"\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\7\3"+
		"\2\2\u00a0\u00a2\58\35\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u00a5\5\22\n\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3"+
		"\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a8\58\35\2\u00a7\u00a6\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\7\4\2\2\u00aa\17\3\2\2"+
		"\2\u00ab\u00ac\5\64\33\2\u00ac\u00b3\7 \2\2\u00ad\u00ae\7\7\2\2\u00ae"+
		"\u00af\5\64\33\2\u00af\u00b0\7 \2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ad\3"+
		"\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\21\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bc\5\24\13\2\u00b7\u00b8\58\35"+
		"\2\u00b8\u00b9\5\24\13\2\u00b9\u00bb\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\23\3\2\2"+
		"\2\u00be\u00bc\3\2\2\2\u00bf\u00c7\5(\25\2\u00c0\u00c7\5,\27\2\u00c1\u00c7"+
		"\5.\30\2\u00c2\u00c7\5\60\31\2\u00c3\u00c7\5\62\32\2\u00c4\u00c7\5\32"+
		"\16\2\u00c5\u00c7\5\n\6\2\u00c6\u00bf\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c6"+
		"\u00c1\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c5\3\2\2\2\u00c7\25\3\2\2\2\u00c8\u00c9\7 \2\2\u00c9\u00d2"+
		"\7\5\2\2\u00ca\u00cf\5\32\16\2\u00cb\u00cc\7\7\2\2\u00cc\u00ce\5\32\16"+
		"\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0"+
		"\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00ca\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\6\2\2\u00d5\27\3\2\2"+
		"\2\u00d6\u00d7\7\61\2\2\u00d7\u00d8\7 \2\2\u00d8\u00d9\7\60\2\2\u00d9"+
		"\31\3\2\2\2\u00da\u00db\b\16\1\2\u00db\u00dc\5\"\22\2\u00dc\u00dd\7\b"+
		"\2\2\u00dd\u00de\79\2\2\u00de\u00fd\3\2\2\2\u00df\u00fd\5\26\f\2\u00e0"+
		"\u00e1\7\33\2\2\u00e1\u00fd\5\32\16\31\u00e2\u00e3\7+\2\2\u00e3\u00fd"+
		"\5\32\16\30\u00e4\u00e5\7\21\2\2\u00e5\u00fd\5\32\16\27\u00e6\u00fd\7"+
		" \2\2\u00e7\u00fd\7\35\2\2\u00e8\u00fd\5\36\20\2\u00e9\u00fd\7\"\2\2\u00ea"+
		"\u00fd\7#\2\2\u00eb\u00fd\5\66\34\2\u00ec\u00fd\7$\2\2\u00ed\u00fd\5 "+
		"\21\2\u00ee\u00fd\5\"\22\2\u00ef\u00fd\5\34\17\2\u00f0\u00f9\7\3\2\2\u00f1"+
		"\u00f6\5\32\16\2\u00f2\u00f3\7\7\2\2\u00f3\u00f5\5\32\16\2\u00f4\u00f2"+
		"\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\7\4\2\2\u00fc\u00da\3\2\2\2\u00fc"+
		"\u00df\3\2\2\2\u00fc\u00e0\3\2\2\2\u00fc\u00e2\3\2\2\2\u00fc\u00e4\3\2"+
		"\2\2\u00fc\u00e6\3\2\2\2\u00fc\u00e7\3\2\2\2\u00fc\u00e8\3\2\2\2\u00fc"+
		"\u00e9\3\2\2\2\u00fc\u00ea\3\2\2\2\u00fc\u00eb\3\2\2\2\u00fc\u00ec\3\2"+
		"\2\2\u00fc\u00ed\3\2\2\2\u00fc\u00ee\3\2\2\2\u00fc\u00ef\3\2\2\2\u00fc"+
		"\u00f0\3\2\2\2\u00fd\u0141\3\2\2\2\u00fe\u00ff\f\26\2\2\u00ff\u0100\7"+
		"\21\2\2\u0100\u0140\5\32\16\27\u0101\u0102\f\25\2\2\u0102\u0103\t\2\2"+
		"\2\u0103\u0140\5\32\16\26\u0104\u0105\f\24\2\2\u0105\u0106\t\3\2\2\u0106"+
		"\u0140\5\32\16\25\u0107\u0108\f\23\2\2\u0108\u0109\t\4\2\2\u0109\u0140"+
		"\5\32\16\24\u010a\u010b\f\22\2\2\u010b\u010c\t\5\2\2\u010c\u0140\5\32"+
		"\16\23\u010d\u010e\f\21\2\2\u010e\u010f\7:\2\2\u010f\u0140\5\32\16\22"+
		"\u0110\u0111\f\20\2\2\u0111\u0112\7\64\2\2\u0112\u0140\5\32\16\21\u0113"+
		"\u0114\f\17\2\2\u0114\u0115\7\65\2\2\u0115\u0140\5\32\16\20\u0116\u0117"+
		"\f#\2\2\u0117\u0118\7\b\2\2\u0118\u0140\79\2\2\u0119\u011a\f \2\2\u011a"+
		"\u011b\7\b\2\2\u011b\u011c\7 \2\2\u011c\u0125\7\5\2\2\u011d\u0122\5\32"+
		"\16\2\u011e\u011f\7\7\2\2\u011f\u0121\5\32\16\2\u0120\u011e\3\2\2\2\u0121"+
		"\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0126\3\2"+
		"\2\2\u0124\u0122\3\2\2\2\u0125\u011d\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0140\7\6\2\2\u0128\u0129\f\37\2\2\u0129\u012a\7"+
		"\b\2\2\u012a\u0140\7 \2\2\u012b\u012c\f\36\2\2\u012c\u012d\7\b\2\2\u012d"+
		"\u0140\7\67\2\2\u012e\u012f\f\35\2\2\u012f\u0130\7\b\2\2\u0130\u0140\7"+
		"\t\2\2\u0131\u0132\f\34\2\2\u0132\u0133\7\b\2\2\u0133\u0140\7\n\2\2\u0134"+
		"\u0135\f\33\2\2\u0135\u0136\7\b\2\2\u0136\u0140\7\67\2\2\u0137\u0138\f"+
		"\32\2\2\u0138\u0139\7\34\2\2\u0139\u0140\7 \2\2\u013a\u013b\f\f\2\2\u013b"+
		"\u013c\7\13\2\2\u013c\u013d\5\32\16\2\u013d\u013e\7\f\2\2\u013e\u0140"+
		"\3\2\2\2\u013f\u00fe\3\2\2\2\u013f\u0101\3\2\2\2\u013f\u0104\3\2\2\2\u013f"+
		"\u0107\3\2\2\2\u013f\u010a\3\2\2\2\u013f\u010d\3\2\2\2\u013f\u0110\3\2"+
		"\2\2\u013f\u0113\3\2\2\2\u013f\u0116\3\2\2\2\u013f\u0119\3\2\2\2\u013f"+
		"\u0128\3\2\2\2\u013f\u012b\3\2\2\2\u013f\u012e\3\2\2\2\u013f\u0131\3\2"+
		"\2\2\u013f\u0134\3\2\2\2\u013f\u0137\3\2\2\2\u013f\u013a\3\2\2\2\u0140"+
		"\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\33\3\2\2"+
		"\2\u0143\u0141\3\2\2\2\u0144\u0145\7\5\2\2\u0145\u0146\5\32\16\2\u0146"+
		"\u0147\7\6\2\2\u0147\35\3\2\2\2\u0148\u0149\7\r\2\2\u0149\u014a\7 \2\2"+
		"\u014a\u0153\7\5\2\2\u014b\u0150\5\32\16\2\u014c\u014d\7\7\2\2\u014d\u014f"+
		"\5\32\16\2\u014e\u014c\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2"+
		"\u0150\u0151\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u014b"+
		"\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\7\6\2\2\u0156"+
		"\37\3\2\2\2\u0157\u0158\7\n\2\2\u0158\u0159\7\"\2\2\u0159!\3\2\2\2\u015a"+
		"\u015b\7\67\2\2\u015b\u015e\5&\24\2\u015c\u015e\7\67\2\2\u015d\u015a\3"+
		"\2\2\2\u015d\u015c\3\2\2\2\u015e#\3\2\2\2\u015f\u0160\t\6\2\2\u0160%\3"+
		"\2\2\2\u0161\u0162\b\24\1\2\u0162\u0166\5$\23\2\u0163\u0164\7)\2\2\u0164"+
		"\u0166\5$\23\2\u0165\u0161\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u016c\3\2"+
		"\2\2\u0167\u0168\f\3\2\2\u0168\u0169\7)\2\2\u0169\u016b\5$\23\2\u016a"+
		"\u0167\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2"+
		"\2\2\u016d\'\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7\22\2\2\u0170\u0171"+
		"\7\5\2\2\u0171\u0172\5\32\16\2\u0172\u0174\7\6\2\2\u0173\u0175\58\35\2"+
		"\u0174\u0173\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178"+
		"\7\3\2\2\u0177\u0179\58\35\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017b\3\2\2\2\u017a\u017c\5\22\n\2\u017b\u017a\3\2\2\2\u017b\u017c\3"+
		"\2\2\2\u017c\u017e\3\2\2\2\u017d\u017f\58\35\2\u017e\u017d\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182\7\4\2\2\u0181\u0183\5*"+
		"\26\2\u0182\u0181\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0198\3\2\2\2\u0184"+
		"\u0185\7\22\2\2\u0185\u0186\7\5\2\2\u0186\u0187\5\32\16\2\u0187\u0189"+
		"\7\6\2\2\u0188\u018a\58\35\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\u018c\3\2\2\2\u018b\u018d\58\35\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018d\u018f\3\2\2\2\u018e\u0190\5\24\13\2\u018f\u018e\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u0193\58\35\2\u0192\u0191\3\2"+
		"\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0196\5*\26\2\u0195"+
		"\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197\u016f\3\2"+
		"\2\2\u0197\u0184\3\2\2\2\u0198)\3\2\2\2\u0199\u019b\58\35\2\u019a\u0199"+
		"\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\7\23\2\2"+
		"\u019d\u019f\58\35\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0"+
		"\3\2\2\2\u01a0\u01a2\7\3\2\2\u01a1\u01a3\58\35\2\u01a2\u01a1\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a6\5\22\n\2\u01a5\u01a4\3"+
		"\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a9\58\35\2\u01a8"+
		"\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01bc\7\4"+
		"\2\2\u01ab\u01ad\58\35\2\u01ac\u01ab\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01b0\7\23\2\2\u01af\u01b1\58\35\2\u01b0\u01af\3"+
		"\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b4\58\35\2\u01b3"+
		"\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b7\5\24"+
		"\13\2\u01b6\u01b5\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8"+
		"\u01ba\58\35\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc\3\2"+
		"\2\2\u01bb\u019a\3\2\2\2\u01bb\u01ac\3\2\2\2\u01bc+\3\2\2\2\u01bd\u01be"+
		"\7\24\2\2\u01be\u01bf\7\5\2\2\u01bf\u01c0\7 \2\2\u01c0\u01c1\7\66\2\2"+
		"\u01c1\u01c2\5\32\16\2\u01c2\u01c4\7\6\2\2\u01c3\u01c5\58\35\2\u01c4\u01c3"+
		"\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\7\3\2\2\u01c7"+
		"\u01c9\58\35\2\u01c8\u01c7\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cb\3\2"+
		"\2\2\u01ca\u01cc\5\22\n\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"\u01ce\3\2\2\2\u01cd\u01cf\58\35\2\u01ce\u01cd\3\2\2\2\u01ce\u01cf\3\2"+
		"\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\7\4\2\2\u01d1\u01e3\3\2\2\2\u01d2"+
		"\u01d3\7\24\2\2\u01d3\u01d4\7\5\2\2\u01d4\u01d5\7 \2\2\u01d5\u01d6\7\66"+
		"\2\2\u01d6\u01d7\5\32\16\2\u01d7\u01d9\7\6\2\2\u01d8\u01da\58\35\2\u01d9"+
		"\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01dd\58"+
		"\35\2\u01dc\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de"+
		"\u01e0\5\24\13\2\u01df\u01e1\58\35\2\u01e0\u01df\3\2\2\2\u01e0\u01e1\3"+
		"\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01bd\3\2\2\2\u01e2\u01d2\3\2\2\2\u01e3"+
		"-\3\2\2\2\u01e4\u01e5\7!\2\2\u01e5\u01e6\78\2\2\u01e6\u01e7\5\32\16\2"+
		"\u01e7/\3\2\2\2\u01e8\u01e9\7\36\2\2\u01e9\u01ea\5\32\16\2\u01ea\61\3"+
		"\2\2\2\u01eb\u01ec\7\25\2\2\u01ec\u01ed\5\32\16\2\u01ed\63\3\2\2\2\u01ee"+
		"\u01ef\b\33\1\2\u01ef\u01f6\7\26\2\2\u01f0\u01f6\7\27\2\2\u01f1\u01f6"+
		"\7\30\2\2\u01f2\u01f6\7 \2\2\u01f3\u01f6\7\67\2\2\u01f4\u01f6\79\2\2\u01f5"+
		"\u01ee\3\2\2\2\u01f5\u01f0\3\2\2\2\u01f5\u01f1\3\2\2\2\u01f5\u01f2\3\2"+
		"\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6\u01fb\3\2\2\2\u01f7"+
		"\u01f8\f\3\2\2\u01f8\u01fa\7\17\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fd\3"+
		"\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\65\3\2\2\2\u01fd"+
		"\u01fb\3\2\2\2\u01fe\u01ff\t\7\2\2\u01ff\67\3\2\2\2\u0200\u0202\7\20\2"+
		"\2\u0201\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204"+
		"\3\2\2\2\u02049\3\2\2\2O;?DHMPUX\\_bkoqtz\u0080\u0084\u0088\u008c\u008e"+
		"\u0094\u0099\u009d\u00a1\u00a4\u00a7\u00b3\u00bc\u00c6\u00cf\u00d2\u00f6"+
		"\u00f9\u00fc\u0122\u0125\u013f\u0141\u0150\u0153\u015d\u0165\u016c\u0174"+
		"\u0178\u017b\u017e\u0182\u0189\u018c\u018f\u0192\u0195\u0197\u019a\u019e"+
		"\u01a2\u01a5\u01a8\u01ac\u01b0\u01b3\u01b6\u01b9\u01bb\u01c4\u01c8\u01cb"+
		"\u01ce\u01d9\u01dc\u01e0\u01e2\u01f5\u01fb\u0203";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}