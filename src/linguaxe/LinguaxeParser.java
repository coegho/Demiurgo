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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, D=17, 
		IF=18, ELSE=19, FOR=20, SYMBOL=21, USERNAME=22, INT_NUMBER=23, FLOAT_NUMBER=24, 
		BOOLEAN=25, TEXT_STRING=26, WS=27, COMMENT=28, COMMENT2=29, MUL=30, DIV=31, 
		ADD=32, SUB=33, EQ=34, NEQ=35, GREQ=36, LESEQ=37, GREAT=38, LESS=39, AND=40, 
		OR=41, ASSIGN=42, MOVE=43, INHERIT=44, ROOM=45, USEROBJ=46;
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_fields = 2, RULE_var_decl = 3, RULE_methods = 4, 
		RULE_method = 5, RULE_args = 6, RULE_code = 7, RULE_line = 8, RULE_variable = 9, 
		RULE_function = 10, RULE_operation = 11, RULE_parens = 12, RULE_new_obj = 13, 
		RULE_sharp_identifier = 14, RULE_room = 15, RULE_room_path = 16, RULE_exp_if = 17, 
		RULE_exp_for = 18, RULE_exp_user = 19, RULE_data_type = 20, RULE_nl = 21;
	public static final String[] ruleNames = {
		"s", "class_def", "fields", "var_decl", "methods", "method", "args", "code", 
		"line", "variable", "function", "operation", "parens", "new_obj", "sharp_identifier", 
		"room", "room_path", "exp_if", "exp_for", "exp_user", "data_type", "nl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "','", "'.'", "'^'", "'['", "']'", "'new'", 
		"'#'", "'int'", "'float'", "'string'", "'[]'", "'\n'", null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "'*'", "'/'", 
		"'+'", "'-'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&'", "'|'", 
		"'='", "'>>'", "':'", "'@'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "D", "IF", "ELSE", "FOR", "SYMBOL", "USERNAME", 
		"INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", "TEXT_STRING", "WS", "COMMENT", 
		"COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", "GREQ", "LESEQ", 
		"GREAT", "LESS", "AND", "OR", "ASSIGN", "MOVE", "INHERIT", "ROOM", "USEROBJ"
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
			setState(46);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				class_def();
				}
				break;
			case 2:
				_localctx = new SCodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
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
			setState(48);
			match(SYMBOL);
			setState(51);
			_la = _input.LA(1);
			if (_la==INHERIT) {
				{
				setState(49);
				match(INHERIT);
				setState(50);
				match(SYMBOL);
				}
			}

			setState(54);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(53);
				nl();
				}
			}

			setState(56);
			match(T__0);
			setState(58);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(57);
				nl();
				}
			}

			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(60);
				fields();
				}
				break;
			}
			setState(64);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << SYMBOL))) != 0)) {
				{
				setState(63);
				methods();
				}
			}

			setState(66);
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
			setState(71); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(68);
					var_decl();
					setState(69);
					nl();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(73); 
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			data_type(0);
			setState(76);
			match(SYMBOL);
			setState(79);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(77);
				match(ASSIGN);
				setState(78);
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
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				method();
				setState(83);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(82);
					nl();
					}
				}

				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << SYMBOL))) != 0) );
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
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(89);
				data_type(0);
				setState(90);
				match(SYMBOL);
				setState(91);
				match(ASSIGN);
				}
				break;
			}
			setState(95);
			((MethodContext)_localctx).metname = match(SYMBOL);
			setState(96);
			match(T__2);
			setState(98);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << SYMBOL))) != 0)) {
				{
				setState(97);
				args();
				}
			}

			setState(100);
			match(T__3);
			setState(102);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(101);
				nl();
				}
			}

			setState(104);
			match(T__0);
			setState(106);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << D) | (1L << IF) | (1L << FOR) | (1L << SYMBOL) | (1L << USERNAME) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(105);
				code();
				}
			}

			setState(108);
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
			setState(110);
			data_type(0);
			setState(111);
			match(SYMBOL);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(112);
				match(T__4);
				setState(113);
				data_type(0);
				setState(114);
				match(SYMBOL);
				}
				}
				setState(120);
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
			setState(122);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(121);
				nl();
				}
			}

			setState(124);
			line();
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(125);
					nl();
					setState(126);
					line();
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(134);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(133);
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
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
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
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				exp_if();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				exp_for();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				exp_user();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				operation(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
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

			setState(144);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
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
					setState(146);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(147);
					match(T__5);
					setState(148);
					match(SYMBOL);
					}
					} 
				}
				setState(153);
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
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(154);
				variable(0);
				setState(155);
				match(T__5);
				}
				break;
			}
			setState(159);
			match(SYMBOL);
			setState(160);
			match(T__2);
			setState(169);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(161);
				operation(0);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(162);
					match(T__4);
					setState(163);
					operation(0);
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(171);
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
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(174);
				match(SUB);
				setState(175);
				operation(22);
				}
				break;
			case 2:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(D);
				setState(177);
				operation(21);
				}
				break;
			case 3:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				variable(0);
				setState(179);
				match(ASSIGN);
				setState(180);
				operation(14);
				}
				break;
			case 4:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				function();
				}
				break;
			case 5:
				{
				_localctx = new IndexAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				variable(0);
				setState(184);
				match(T__7);
				setState(185);
				operation(0);
				setState(186);
				match(T__8);
				setState(187);
				match(ASSIGN);
				setState(188);
				operation(0);
				}
				break;
			case 6:
				{
				_localctx = new VariableOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				variable(0);
				}
				break;
			case 7:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				new_obj();
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(INT_NUMBER);
				}
				break;
			case 9:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(FLOAT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(BOOLEAN);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(TEXT_STRING);
				}
				break;
			case 12:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				sharp_identifier();
				}
				break;
			case 13:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				room();
				}
				break;
			case 14:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				parens();
				}
				break;
			case 15:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(T__0);
				setState(208);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
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
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(239);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
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
						_localctx = new ExponentContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(216);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(217);
						match(T__6);
						setState(218);
						operation(20);
						}
						break;
					case 3:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(219);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(220);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(221);
						operation(19);
						}
						break;
					case 4:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(222);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(223);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(224);
						operation(18);
						}
						break;
					case 5:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(225);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(226);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(227);
						operation(17);
						}
						break;
					case 6:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(228);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(229);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(230);
						operation(16);
						}
						break;
					case 7:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(231);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(232);
						match(MOVE);
						setState(233);
						operation(13);
						}
						break;
					case 8:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(234);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(235);
						match(T__7);
						setState(236);
						operation(0);
						setState(237);
						match(T__8);
						}
						break;
					}
					} 
				}
				setState(243);
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
			setState(244);
			match(T__2);
			setState(245);
			operation(0);
			setState(246);
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
			setState(248);
			match(T__9);
			setState(249);
			match(SYMBOL);
			setState(250);
			match(T__2);
			setState(259);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB) | (1L << ROOM))) != 0)) {
				{
				setState(251);
				operation(0);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(252);
					match(T__4);
					setState(253);
					operation(0);
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(261);
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
			setState(263);
			match(T__10);
			setState(264);
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
			setState(266);
			match(ROOM);
			setState(267);
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
			setState(272);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new RelativeRoomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(270);
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
			setState(279);
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
					setState(274);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(275);
					match(DIV);
					setState(276);
					match(SYMBOL);
					}
					} 
				}
				setState(281);
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
			setState(282);
			match(IF);
			setState(283);
			match(T__2);
			setState(284);
			operation(0);
			setState(285);
			match(T__3);
			setState(287);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(286);
				nl();
				}
			}

			setState(289);
			match(T__0);
			setState(290);
			code();
			setState(291);
			match(T__1);
			setState(303);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(293);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(292);
					nl();
					}
				}

				setState(295);
				match(ELSE);
				setState(297);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(296);
					nl();
					}
				}

				setState(299);
				match(T__0);
				setState(300);
				code();
				setState(301);
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
			setState(305);
			match(FOR);
			setState(306);
			match(T__2);
			setState(307);
			match(SYMBOL);
			setState(308);
			match(INHERIT);
			setState(309);
			operation(0);
			setState(310);
			match(T__3);
			setState(312);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(311);
				nl();
				}
			}

			setState(314);
			match(T__0);
			setState(315);
			code();
			setState(316);
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
		public TerminalNode USERNAME() { return getToken(LinguaxeParser.USERNAME, 0); }
		public TerminalNode USEROBJ() { return getToken(LinguaxeParser.USEROBJ, 0); }
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
			setState(318);
			match(USERNAME);
			setState(319);
			match(USEROBJ);
			setState(320);
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
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
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
		return data_type(0);
	}

	private Data_typeContext data_type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Data_typeContext _localctx = new Data_typeContext(_ctx, _parentState);
		Data_typeContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_data_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(323);
				match(T__11);
				}
				break;
			case T__12:
				{
				setState(324);
				match(T__12);
				}
				break;
			case T__13:
				{
				setState(325);
				match(T__13);
				}
				break;
			case SYMBOL:
				{
				setState(326);
				match(SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(333);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Data_typeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_data_type);
					setState(329);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(330);
					match(T__14);
					}
					} 
				}
				setState(335);
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
		enterRule(_localctx, 42, RULE_nl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(336);
				match(T__15);
				}
				}
				setState(339); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__15 );
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
		case 20:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u0158\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\5\2\61\n\2"+
		"\3\3\3\3\3\3\5\3\66\n\3\3\3\5\39\n\3\3\3\3\3\5\3=\n\3\3\3\5\3@\n\3\3\3"+
		"\5\3C\n\3\3\3\3\3\3\4\3\4\3\4\6\4J\n\4\r\4\16\4K\3\5\3\5\3\5\3\5\5\5R"+
		"\n\5\3\6\3\6\5\6V\n\6\6\6X\n\6\r\6\16\6Y\3\7\3\7\3\7\3\7\5\7`\n\7\3\7"+
		"\3\7\3\7\5\7e\n\7\3\7\3\7\5\7i\n\7\3\7\3\7\5\7m\n\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\bw\n\b\f\b\16\bz\13\b\3\t\5\t}\n\t\3\t\3\t\3\t\3\t\7"+
		"\t\u0083\n\t\f\t\16\t\u0086\13\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u0090\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0098\n\13\f\13\16\13"+
		"\u009b\13\13\3\f\3\f\3\f\5\f\u00a0\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a7\n"+
		"\f\f\f\16\f\u00aa\13\f\5\f\u00ac\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ce\n\r\f\r\16\r\u00d1\13\r\5\r\u00d3\n"+
		"\r\3\r\5\r\u00d6\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f2\n\r\f"+
		"\r\16\r\u00f5\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7"+
		"\17\u0101\n\17\f\17\16\17\u0104\13\17\5\17\u0106\n\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u0113\n\22\3\22\3\22\3\22"+
		"\7\22\u0118\n\22\f\22\16\22\u011b\13\22\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0122\n\23\3\23\3\23\3\23\3\23\5\23\u0128\n\23\3\23\3\23\5\23\u012c\n"+
		"\23\3\23\3\23\3\23\3\23\5\23\u0132\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u013b\n\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u014a\n\26\3\26\3\26\7\26\u014e\n\26\f\26\16\26\u0151"+
		"\13\26\3\27\6\27\u0154\n\27\r\27\16\27\u0155\3\27\2\6\24\30\"*\30\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\6\3\2 !\3\2\"#\3\2$)\3\2"+
		"*+\u0181\2\60\3\2\2\2\4\62\3\2\2\2\6I\3\2\2\2\bM\3\2\2\2\nW\3\2\2\2\f"+
		"_\3\2\2\2\16p\3\2\2\2\20|\3\2\2\2\22\u008f\3\2\2\2\24\u0091\3\2\2\2\26"+
		"\u009f\3\2\2\2\30\u00d5\3\2\2\2\32\u00f6\3\2\2\2\34\u00fa\3\2\2\2\36\u0109"+
		"\3\2\2\2 \u010c\3\2\2\2\"\u0112\3\2\2\2$\u011c\3\2\2\2&\u0133\3\2\2\2"+
		"(\u0140\3\2\2\2*\u0149\3\2\2\2,\u0153\3\2\2\2.\61\5\4\3\2/\61\5\20\t\2"+
		"\60.\3\2\2\2\60/\3\2\2\2\61\3\3\2\2\2\62\65\7\27\2\2\63\64\7.\2\2\64\66"+
		"\7\27\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\679\5,\27\28\67\3\2"+
		"\2\289\3\2\2\29:\3\2\2\2:<\7\3\2\2;=\5,\27\2<;\3\2\2\2<=\3\2\2\2=?\3\2"+
		"\2\2>@\5\6\4\2?>\3\2\2\2?@\3\2\2\2@B\3\2\2\2AC\5\n\6\2BA\3\2\2\2BC\3\2"+
		"\2\2CD\3\2\2\2DE\7\4\2\2E\5\3\2\2\2FG\5\b\5\2GH\5,\27\2HJ\3\2\2\2IF\3"+
		"\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\7\3\2\2\2MN\5*\26\2NQ\7\27\2\2O"+
		"P\7,\2\2PR\5\30\r\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2\2SU\5\f\7\2TV\5,\27\2"+
		"UT\3\2\2\2UV\3\2\2\2VX\3\2\2\2WS\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2"+
		"Z\13\3\2\2\2[\\\5*\26\2\\]\7\27\2\2]^\7,\2\2^`\3\2\2\2_[\3\2\2\2_`\3\2"+
		"\2\2`a\3\2\2\2ab\7\27\2\2bd\7\5\2\2ce\5\16\b\2dc\3\2\2\2de\3\2\2\2ef\3"+
		"\2\2\2fh\7\6\2\2gi\5,\27\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jl\7\3\2\2km\5"+
		"\20\t\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\4\2\2o\r\3\2\2\2pq\5*\26\2q"+
		"x\7\27\2\2rs\7\7\2\2st\5*\26\2tu\7\27\2\2uw\3\2\2\2vr\3\2\2\2wz\3\2\2"+
		"\2xv\3\2\2\2xy\3\2\2\2y\17\3\2\2\2zx\3\2\2\2{}\5,\27\2|{\3\2\2\2|}\3\2"+
		"\2\2}~\3\2\2\2~\u0084\5\22\n\2\177\u0080\5,\27\2\u0080\u0081\5\22\n\2"+
		"\u0081\u0083\3\2\2\2\u0082\177\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0089\5,\27\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\21\3\2\2"+
		"\2\u008a\u0090\5$\23\2\u008b\u0090\5&\24\2\u008c\u0090\5(\25\2\u008d\u0090"+
		"\5\30\r\2\u008e\u0090\5\b\5\2\u008f\u008a\3\2\2\2\u008f\u008b\3\2\2\2"+
		"\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\23"+
		"\3\2\2\2\u0091\u0092\b\13\1\2\u0092\u0093\7\27\2\2\u0093\u0099\3\2\2\2"+
		"\u0094\u0095\f\3\2\2\u0095\u0096\7\b\2\2\u0096\u0098\7\27\2\2\u0097\u0094"+
		"\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\25\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\5\24\13\2\u009d\u009e\7\b"+
		"\2\2\u009e\u00a0\3\2\2\2\u009f\u009c\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\7\27\2\2\u00a2\u00ab\7\5\2\2\u00a3\u00a8\5"+
		"\30\r\2\u00a4\u00a5\7\7\2\2\u00a5\u00a7\5\30\r\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\7\6\2\2\u00ae\27\3\2\2\2\u00af\u00b0\b\r\1"+
		"\2\u00b0\u00b1\7#\2\2\u00b1\u00d6\5\30\r\30\u00b2\u00b3\7\23\2\2\u00b3"+
		"\u00d6\5\30\r\27\u00b4\u00b5\5\24\13\2\u00b5\u00b6\7,\2\2\u00b6\u00b7"+
		"\5\30\r\20\u00b7\u00d6\3\2\2\2\u00b8\u00d6\5\26\f\2\u00b9\u00ba\5\24\13"+
		"\2\u00ba\u00bb\7\n\2\2\u00bb\u00bc\5\30\r\2\u00bc\u00bd\7\13\2\2\u00bd"+
		"\u00be\7,\2\2\u00be\u00bf\5\30\r\2\u00bf\u00d6\3\2\2\2\u00c0\u00d6\5\24"+
		"\13\2\u00c1\u00d6\5\34\17\2\u00c2\u00d6\7\31\2\2\u00c3\u00d6\7\32\2\2"+
		"\u00c4\u00d6\7\33\2\2\u00c5\u00d6\7\34\2\2\u00c6\u00d6\5\36\20\2\u00c7"+
		"\u00d6\5 \21\2\u00c8\u00d6\5\32\16\2\u00c9\u00d2\7\3\2\2\u00ca\u00cf\5"+
		"\30\r\2\u00cb\u00cc\7\7\2\2\u00cc\u00ce\5\30\r\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00ca\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d6\7\4\2\2\u00d5\u00af\3\2\2\2\u00d5\u00b2\3\2"+
		"\2\2\u00d5\u00b4\3\2\2\2\u00d5\u00b8\3\2\2\2\u00d5\u00b9\3\2\2\2\u00d5"+
		"\u00c0\3\2\2\2\u00d5\u00c1\3\2\2\2\u00d5\u00c2\3\2\2\2\u00d5\u00c3\3\2"+
		"\2\2\u00d5\u00c4\3\2\2\2\u00d5\u00c5\3\2\2\2\u00d5\u00c6\3\2\2\2\u00d5"+
		"\u00c7\3\2\2\2\u00d5\u00c8\3\2\2\2\u00d5\u00c9\3\2\2\2\u00d6\u00f3\3\2"+
		"\2\2\u00d7\u00d8\f\26\2\2\u00d8\u00d9\7\23\2\2\u00d9\u00f2\5\30\r\27\u00da"+
		"\u00db\f\25\2\2\u00db\u00dc\7\t\2\2\u00dc\u00f2\5\30\r\26\u00dd\u00de"+
		"\f\24\2\2\u00de\u00df\t\2\2\2\u00df\u00f2\5\30\r\25\u00e0\u00e1\f\23\2"+
		"\2\u00e1\u00e2\t\3\2\2\u00e2\u00f2\5\30\r\24\u00e3\u00e4\f\22\2\2\u00e4"+
		"\u00e5\t\4\2\2\u00e5\u00f2\5\30\r\23\u00e6\u00e7\f\21\2\2\u00e7\u00e8"+
		"\t\5\2\2\u00e8\u00f2\5\30\r\22\u00e9\u00ea\f\16\2\2\u00ea\u00eb\7-\2\2"+
		"\u00eb\u00f2\5\30\r\17\u00ec\u00ed\f\f\2\2\u00ed\u00ee\7\n\2\2\u00ee\u00ef"+
		"\5\30\r\2\u00ef\u00f0\7\13\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00d7\3\2\2\2"+
		"\u00f1\u00da\3\2\2\2\u00f1\u00dd\3\2\2\2\u00f1\u00e0\3\2\2\2\u00f1\u00e3"+
		"\3\2\2\2\u00f1\u00e6\3\2\2\2\u00f1\u00e9\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\31\3\2\2"+
		"\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7\5\2\2\u00f7\u00f8\5\30\r\2\u00f8"+
		"\u00f9\7\6\2\2\u00f9\33\3\2\2\2\u00fa\u00fb\7\f\2\2\u00fb\u00fc\7\27\2"+
		"\2\u00fc\u0105\7\5\2\2\u00fd\u0102\5\30\r\2\u00fe\u00ff\7\7\2\2\u00ff"+
		"\u0101\5\30\r\2\u0100\u00fe\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3"+
		"\2\2\2\u0102\u0103\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0105"+
		"\u00fd\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7\6"+
		"\2\2\u0108\35\3\2\2\2\u0109\u010a\7\r\2\2\u010a\u010b\7\31\2\2\u010b\37"+
		"\3\2\2\2\u010c\u010d\7/\2\2\u010d\u010e\5\"\22\2\u010e!\3\2\2\2\u010f"+
		"\u0110\b\22\1\2\u0110\u0113\7\27\2\2\u0111\u0113\3\2\2\2\u0112\u010f\3"+
		"\2\2\2\u0112\u0111\3\2\2\2\u0113\u0119\3\2\2\2\u0114\u0115\f\3\2\2\u0115"+
		"\u0116\7!\2\2\u0116\u0118\7\27\2\2\u0117\u0114\3\2\2\2\u0118\u011b\3\2"+
		"\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a#\3\2\2\2\u011b\u0119"+
		"\3\2\2\2\u011c\u011d\7\24\2\2\u011d\u011e\7\5\2\2\u011e\u011f\5\30\r\2"+
		"\u011f\u0121\7\6\2\2\u0120\u0122\5,\27\2\u0121\u0120\3\2\2\2\u0121\u0122"+
		"\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\7\3\2\2\u0124\u0125\5\20\t\2"+
		"\u0125\u0131\7\4\2\2\u0126\u0128\5,\27\2\u0127\u0126\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\7\25\2\2\u012a\u012c\5,\27\2"+
		"\u012b\u012a\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e"+
		"\7\3\2\2\u012e\u012f\5\20\t\2\u012f\u0130\7\4\2\2\u0130\u0132\3\2\2\2"+
		"\u0131\u0127\3\2\2\2\u0131\u0132\3\2\2\2\u0132%\3\2\2\2\u0133\u0134\7"+
		"\26\2\2\u0134\u0135\7\5\2\2\u0135\u0136\7\27\2\2\u0136\u0137\7.\2\2\u0137"+
		"\u0138\5\30\r\2\u0138\u013a\7\6\2\2\u0139\u013b\5,\27\2\u013a\u0139\3"+
		"\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\7\3\2\2\u013d"+
		"\u013e\5\20\t\2\u013e\u013f\7\4\2\2\u013f\'\3\2\2\2\u0140\u0141\7\30\2"+
		"\2\u0141\u0142\7\60\2\2\u0142\u0143\5\30\r\2\u0143)\3\2\2\2\u0144\u0145"+
		"\b\26\1\2\u0145\u014a\7\16\2\2\u0146\u014a\7\17\2\2\u0147\u014a\7\20\2"+
		"\2\u0148\u014a\7\27\2\2\u0149\u0144\3\2\2\2\u0149\u0146\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u0149\u0148\3\2\2\2\u014a\u014f\3\2\2\2\u014b\u014c\f\3"+
		"\2\2\u014c\u014e\7\21\2\2\u014d\u014b\3\2\2\2\u014e\u0151\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150+\3\2\2\2\u0151\u014f\3\2\2\2"+
		"\u0152\u0154\7\22\2\2\u0153\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156-\3\2\2\2*\60\658<?BKQUY_dhlx|\u0084"+
		"\u0088\u008f\u0099\u009f\u00a8\u00ab\u00cf\u00d2\u00d5\u00f1\u00f3\u0102"+
		"\u0105\u0112\u0119\u0121\u0127\u012b\u0131\u013a\u0149\u014f\u0155";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}