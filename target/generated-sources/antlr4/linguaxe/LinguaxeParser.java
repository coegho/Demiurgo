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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, D=23, SYMBOL=24, INT_NUMBER=25, 
		FLOAT_NUMBER=26, BOOLEAN=27, TEXT_STRING=28, WS=29, COMMENT=30, COMMENT2=31, 
		MUL=32, DIV=33, ADD=34, SUB=35, EQ=36, NEQ=37, GREQ=38, LESEQ=39, GREAT=40, 
		LESS=41, AND=42, OR=43, ASSIGN=44, MOVE_RIGHT=45, MOVE_LEFT=46;
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_attributes = 2, RULE_attrib = 3, 
		RULE_methods = 4, RULE_method = 5, RULE_params = 6, RULE_code = 7, RULE_aline = 8, 
		RULE_line = 9, RULE_variable = 10, RULE_function = 11, RULE_operation = 12, 
		RULE_parens = 13, RULE_new_obj = 14, RULE_sharp_identifier = 15, RULE_room = 16, 
		RULE_room_path = 17, RULE_exp_if = 18, RULE_exp_for = 19, RULE_exp_user = 20, 
		RULE_username = 21, RULE_data_type = 22, RULE_nl = 23;
	public static final String[] ruleNames = {
		"s", "class_def", "attributes", "attrib", "methods", "method", "params", 
		"code", "aline", "line", "variable", "function", "operation", "parens", 
		"new_obj", "sharp_identifier", "room", "room_path", "exp_if", "exp_for", 
		"exp_user", "username", "data_type", "nl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "','", "'\n'", "'.'", "'^'", "'['", 
		"']'", "'new'", "'#'", "'@'", "'if'", "'else'", "'for'", "':'", "'->'", 
		"'$'", "'int'", "'float'", "'string'", "'d'", null, null, null, null, 
		null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>='", 
		"'<='", "'>'", "'<'", "'&'", "'|'", "'='", "'>>'", "'<<'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "D", 
		"SYMBOL", "INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", "TEXT_STRING", "WS", 
		"COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", "GREQ", 
		"LESEQ", "GREAT", "LESS", "AND", "OR", "ASSIGN", "MOVE_RIGHT", "MOVE_LEFT"
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
			setState(50);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ClassDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				class_def();
				}
				break;
			case 2:
				_localctx = new SCodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
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
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public MethodsContext methods() {
			return getRuleContext(MethodsContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
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
			setState(52);
			match(SYMBOL);
			setState(56);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(53);
				match(T__0);
				setState(54);
				match(SYMBOL);
				setState(55);
				match(T__1);
				}
			}

			setState(59);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(58);
				nl();
				}
			}

			setState(61);
			match(T__2);
			setState(63);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(62);
				nl();
				}
			}

			setState(65);
			attributes();
			setState(66);
			methods();
			setState(67);
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

	public static class AttributesContext extends ParserRuleContext {
		public List<AttribContext> attrib() {
			return getRuleContexts(AttribContext.class);
		}
		public AttribContext attrib(int i) {
			return getRuleContext(AttribContext.class,i);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_attributes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(69);
					attrib();
					setState(70);
					nl();
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class AttribContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public TerminalNode ASSIGN() { return getToken(LinguaxeParser.ASSIGN, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrib; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitAttrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttribContext attrib() throws RecognitionException {
		AttribContext _localctx = new AttribContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attrib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			data_type();
			setState(78);
			match(SYMBOL);
			setState(81);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(79);
				match(ASSIGN);
				setState(80);
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
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==SYMBOL) {
				{
				{
				setState(83);
				method();
				setState(85);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(84);
					nl();
					}
				}

				}
				}
				setState(91);
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

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(LinguaxeParser.ASSIGN, 0); }
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
			setState(97);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(92);
				match(T__0);
				setState(93);
				params();
				setState(94);
				match(T__1);
				setState(95);
				match(ASSIGN);
				}
			}

			setState(99);
			match(SYMBOL);
			setState(100);
			match(T__0);
			setState(101);
			params();
			setState(102);
			match(T__1);
			setState(104);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(103);
				nl();
				}
			}

			setState(106);
			match(T__2);
			setState(108);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(107);
				nl();
				}
				break;
			}
			setState(111);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB))) != 0)) {
				{
				setState(110);
				code();
				}
			}

			setState(113);
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

	public static class ParamsContext extends ParserRuleContext {
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
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			data_type();
			setState(116);
			match(SYMBOL);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(117);
				match(T__4);
				setState(118);
				data_type();
				setState(119);
				match(SYMBOL);
				}
				}
				setState(125);
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
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public List<AlineContext> aline() {
			return getRuleContexts(AlineContext.class);
		}
		public AlineContext aline(int i) {
			return getRuleContext(AlineContext.class,i);
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
			setState(127);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(126);
				nl();
				}
			}

			setState(129);
			line();
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(130);
					aline();
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(137);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(136);
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

	public static class AlineContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public AlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aline; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitAline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlineContext aline() throws RecognitionException {
		AlineContext _localctx = new AlineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_aline);
		try {
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(T__5);
				setState(140);
				line();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(T__5);
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

	public static class LineContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public Exp_ifContext exp_if() {
			return getRuleContext(Exp_ifContext.class,0);
		}
		public Exp_forContext exp_for() {
			return getRuleContext(Exp_forContext.class,0);
		}
		public Exp_userContext exp_user() {
			return getRuleContext(Exp_userContext.class,0);
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
		enterRule(_localctx, 18, RULE_line);
		try {
			setState(148);
			switch (_input.LA(1)) {
			case T__0:
			case T__2:
			case T__10:
			case T__11:
			case T__12:
			case D:
			case SYMBOL:
			case INT_NUMBER:
			case FLOAT_NUMBER:
			case BOOLEAN:
			case TEXT_STRING:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				operation(0);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				exp_if();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				exp_for();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				exp_user();
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_variable, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RootVariableContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(151);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IntermediateVariableContext(new VariableContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_variable);
					setState(153);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(154);
					match(T__6);
					setState(155);
					match(SYMBOL);
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 22, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(161);
				variable(0);
				setState(162);
				match(T__6);
				}
				break;
			}
			setState(166);
			match(SYMBOL);
			setState(167);
			match(T__0);
			setState(176);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB))) != 0)) {
				{
				setState(168);
				operation(0);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(169);
					match(T__4);
					setState(170);
					operation(0);
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(178);
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
		public Token op;
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public TerminalNode MOVE_LEFT() { return getToken(LinguaxeParser.MOVE_LEFT, 0); }
		public TerminalNode MOVE_RIGHT() { return getToken(LinguaxeParser.MOVE_RIGHT, 0); }
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_operation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(181);
				match(SUB);
				setState(182);
				operation(22);
				}
				break;
			case 2:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(D);
				setState(184);
				operation(21);
				}
				break;
			case 3:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				variable(0);
				setState(186);
				match(ASSIGN);
				setState(187);
				operation(14);
				}
				break;
			case 4:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				function();
				}
				break;
			case 5:
				{
				_localctx = new IndexAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				variable(0);
				setState(191);
				match(T__8);
				setState(192);
				operation(0);
				setState(193);
				match(T__9);
				setState(194);
				match(ASSIGN);
				setState(195);
				operation(0);
				}
				break;
			case 6:
				{
				_localctx = new VariableOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				variable(0);
				}
				break;
			case 7:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				new_obj();
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(INT_NUMBER);
				}
				break;
			case 9:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(FLOAT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(BOOLEAN);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(TEXT_STRING);
				}
				break;
			case 12:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				sharp_identifier();
				}
				break;
			case 13:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				room();
				}
				break;
			case 14:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				parens();
				}
				break;
			case 15:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(T__2);
				setState(207);
				operation(0);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(208);
					match(T__4);
					setState(209);
					operation(0);
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(215);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(245);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new MultDiceContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(219);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(220);
						match(D);
						setState(221);
						operation(21);
						}
						break;
					case 2:
						{
						_localctx = new ExponentContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(222);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(223);
						match(T__7);
						setState(224);
						operation(20);
						}
						break;
					case 3:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(225);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(226);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(227);
						operation(19);
						}
						break;
					case 4:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(228);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(229);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(230);
						operation(18);
						}
						break;
					case 5:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(231);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(232);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(233);
						operation(17);
						}
						break;
					case 6:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(234);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(235);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(236);
						operation(16);
						}
						break;
					case 7:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(237);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(238);
						((MoveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MOVE_RIGHT || _la==MOVE_LEFT) ) {
							((MoveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(239);
						operation(13);
						}
						break;
					case 8:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(240);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(241);
						match(T__8);
						setState(242);
						operation(0);
						setState(243);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 26, RULE_parens);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__0);
			setState(251);
			operation(0);
			setState(252);
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
		enterRule(_localctx, 28, RULE_new_obj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__10);
			setState(255);
			match(SYMBOL);
			setState(256);
			match(T__0);
			setState(265);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB))) != 0)) {
				{
				setState(257);
				operation(0);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(258);
					match(T__4);
					setState(259);
					operation(0);
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(267);
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
		enterRule(_localctx, 30, RULE_sharp_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__11);
			setState(270);
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
		enterRule(_localctx, 32, RULE_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__12);
			setState(273);
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
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public Room_pathContext room_path() {
			return getRuleContext(Room_pathContext.class,0);
		}
		public Room_pathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_path; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LinguaxeVisitor ) return ((LinguaxeVisitor<? extends T>)visitor).visitRoom_path(this);
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
			{
			setState(276);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Room_pathContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_room_path);
					setState(278);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(279);
					match(DIV);
					setState(280);
					match(SYMBOL);
					}
					} 
				}
				setState(285);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp_ifContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
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
		enterRule(_localctx, 36, RULE_exp_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__13);
			setState(287);
			match(T__0);
			setState(288);
			line();
			setState(289);
			match(T__1);
			setState(291);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(290);
				nl();
				}
			}

			setState(293);
			match(T__2);
			setState(294);
			code();
			setState(295);
			match(T__3);
			setState(310);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(297);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(296);
					nl();
					}
				}

				setState(299);
				match(T__14);
				setState(301);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(300);
					nl();
					}
				}

				setState(303);
				match(T__2);
				setState(305);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(304);
					nl();
					}
					break;
				}
				setState(307);
				code();
				setState(308);
				match(T__3);
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
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
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
		enterRule(_localctx, 38, RULE_exp_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(T__15);
			setState(313);
			match(T__0);
			setState(314);
			match(SYMBOL);
			setState(315);
			match(T__16);
			setState(316);
			operation(0);
			setState(317);
			match(T__1);
			setState(319);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(318);
				nl();
				}
			}

			setState(321);
			match(T__2);
			setState(323);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(322);
				nl();
				}
				break;
			}
			setState(325);
			code();
			setState(326);
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
		enterRule(_localctx, 40, RULE_exp_user);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			username();
			setState(329);
			match(T__17);
			setState(330);
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
		enterRule(_localctx, 42, RULE_username);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(T__18);
			setState(333);
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
		enterRule(_localctx, 44, RULE_data_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << SYMBOL))) != 0)) ) {
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
		enterRule(_localctx, 46, RULE_nl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(338); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(337);
					match(T__5);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(340); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
			return variable_sempred((VariableContext)_localctx, predIndex);
		case 12:
			return operation_sempred((OperationContext)_localctx, predIndex);
		case 17:
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u0159\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\5\2\65\n\2\3\3\3\3\3\3\3\3\5\3;\n\3\3\3\5\3>\n\3\3\3\3\3\5\3"+
		"B\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\5\3\5\3\5"+
		"\3\5\5\5T\n\5\3\6\3\6\5\6X\n\6\7\6Z\n\6\f\6\16\6]\13\6\3\7\3\7\3\7\3\7"+
		"\3\7\5\7d\n\7\3\7\3\7\3\7\3\7\3\7\5\7k\n\7\3\7\3\7\5\7o\n\7\3\7\5\7r\n"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b|\n\b\f\b\16\b\177\13\b\3\t\5\t"+
		"\u0082\n\t\3\t\3\t\7\t\u0086\n\t\f\t\16\t\u0089\13\t\3\t\5\t\u008c\n\t"+
		"\3\n\3\n\3\n\5\n\u0091\n\n\3\13\3\13\3\13\3\13\5\13\u0097\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\7\f\u009f\n\f\f\f\16\f\u00a2\13\f\3\r\3\r\3\r\5\r\u00a7"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ae\n\r\f\r\16\r\u00b1\13\r\5\r\u00b3\n"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u00d5\n\16\f\16\16\16\u00d8\13\16\3\16\3\16"+
		"\5\16\u00dc\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00f8\n\16\f\16\16\16\u00fb\13\16\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u0107\n\20\f\20\16\20\u010a\13\20\5\20"+
		"\u010c\n\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u011c\n\23\f\23\16\23\u011f\13\23\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0126\n\24\3\24\3\24\3\24\3\24\5\24\u012c\n\24\3\24\3\24\5"+
		"\24\u0130\n\24\3\24\3\24\5\24\u0134\n\24\3\24\3\24\3\24\5\24\u0139\n\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0142\n\25\3\25\3\25\5\25\u0146"+
		"\n\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\6\31\u0155\n\31\r\31\16\31\u0156\3\31\2\5\26\32$\32\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\2\b\3\2\"#\3\2$%\3\2&+\3\2,-\3\2/\60"+
		"\4\2\26\30\32\32\u017a\2\64\3\2\2\2\4\66\3\2\2\2\6L\3\2\2\2\bO\3\2\2\2"+
		"\n[\3\2\2\2\fc\3\2\2\2\16u\3\2\2\2\20\u0081\3\2\2\2\22\u0090\3\2\2\2\24"+
		"\u0096\3\2\2\2\26\u0098\3\2\2\2\30\u00a6\3\2\2\2\32\u00db\3\2\2\2\34\u00fc"+
		"\3\2\2\2\36\u0100\3\2\2\2 \u010f\3\2\2\2\"\u0112\3\2\2\2$\u0115\3\2\2"+
		"\2&\u0120\3\2\2\2(\u013a\3\2\2\2*\u014a\3\2\2\2,\u014e\3\2\2\2.\u0151"+
		"\3\2\2\2\60\u0154\3\2\2\2\62\65\5\4\3\2\63\65\5\20\t\2\64\62\3\2\2\2\64"+
		"\63\3\2\2\2\65\3\3\2\2\2\66:\7\32\2\2\678\7\3\2\289\7\32\2\29;\7\4\2\2"+
		":\67\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\5\60\31\2=<\3\2\2\2=>\3\2\2\2>?\3\2"+
		"\2\2?A\7\5\2\2@B\5\60\31\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\5\6\4\2DE\5"+
		"\n\6\2EF\7\6\2\2F\5\3\2\2\2GH\5\b\5\2HI\5\60\31\2IK\3\2\2\2JG\3\2\2\2"+
		"KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\7\3\2\2\2NL\3\2\2\2OP\5.\30\2PS\7\32\2"+
		"\2QR\7.\2\2RT\5\32\16\2SQ\3\2\2\2ST\3\2\2\2T\t\3\2\2\2UW\5\f\7\2VX\5\60"+
		"\31\2WV\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YU\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3"+
		"\2\2\2\\\13\3\2\2\2][\3\2\2\2^_\7\3\2\2_`\5\16\b\2`a\7\4\2\2ab\7.\2\2"+
		"bd\3\2\2\2c^\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\32\2\2fg\7\3\2\2gh\5\16\b"+
		"\2hj\7\4\2\2ik\5\60\31\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2ln\7\5\2\2mo\5\60"+
		"\31\2nm\3\2\2\2no\3\2\2\2oq\3\2\2\2pr\5\20\t\2qp\3\2\2\2qr\3\2\2\2rs\3"+
		"\2\2\2st\7\6\2\2t\r\3\2\2\2uv\5.\30\2v}\7\32\2\2wx\7\7\2\2xy\5.\30\2y"+
		"z\7\32\2\2z|\3\2\2\2{w\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\17\3"+
		"\2\2\2\177}\3\2\2\2\u0080\u0082\5\60\31\2\u0081\u0080\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0087\5\24\13\2\u0084\u0086\5\22\n"+
		"\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\60\31\2"+
		"\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\21\3\2\2\2\u008d\u008e"+
		"\7\b\2\2\u008e\u0091\5\24\13\2\u008f\u0091\7\b\2\2\u0090\u008d\3\2\2\2"+
		"\u0090\u008f\3\2\2\2\u0091\23\3\2\2\2\u0092\u0097\5\32\16\2\u0093\u0097"+
		"\5&\24\2\u0094\u0097\5(\25\2\u0095\u0097\5*\26\2\u0096\u0092\3\2\2\2\u0096"+
		"\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\25\3\2\2"+
		"\2\u0098\u0099\b\f\1\2\u0099\u009a\7\32\2\2\u009a\u00a0\3\2\2\2\u009b"+
		"\u009c\f\3\2\2\u009c\u009d\7\t\2\2\u009d\u009f\7\32\2\2\u009e\u009b\3"+
		"\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\27\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\5\26\f\2\u00a4\u00a5\7\t\2"+
		"\2\u00a5\u00a7\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a9\7\32\2\2\u00a9\u00b2\7\3\2\2\u00aa\u00af\5\32\16"+
		"\2\u00ab\u00ac\7\7\2\2\u00ac\u00ae\5\32\16\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\7\4\2\2\u00b5\31\3\2\2\2\u00b6\u00b7\b\16\1"+
		"\2\u00b7\u00b8\7%\2\2\u00b8\u00dc\5\32\16\30\u00b9\u00ba\7\31\2\2\u00ba"+
		"\u00dc\5\32\16\27\u00bb\u00bc\5\26\f\2\u00bc\u00bd\7.\2\2\u00bd\u00be"+
		"\5\32\16\20\u00be\u00dc\3\2\2\2\u00bf\u00dc\5\30\r\2\u00c0\u00c1\5\26"+
		"\f\2\u00c1\u00c2\7\13\2\2\u00c2\u00c3\5\32\16\2\u00c3\u00c4\7\f\2\2\u00c4"+
		"\u00c5\7.\2\2\u00c5\u00c6\5\32\16\2\u00c6\u00dc\3\2\2\2\u00c7\u00dc\5"+
		"\26\f\2\u00c8\u00dc\5\36\20\2\u00c9\u00dc\7\33\2\2\u00ca\u00dc\7\34\2"+
		"\2\u00cb\u00dc\7\35\2\2\u00cc\u00dc\7\36\2\2\u00cd\u00dc\5 \21\2\u00ce"+
		"\u00dc\5\"\22\2\u00cf\u00dc\5\34\17\2\u00d0\u00d1\7\5\2\2\u00d1\u00d6"+
		"\5\32\16\2\u00d2\u00d3\7\7\2\2\u00d3\u00d5\5\32\16\2\u00d4\u00d2\3\2\2"+
		"\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9"+
		"\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7\6\2\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00b6\3\2\2\2\u00db\u00b9\3\2\2\2\u00db\u00bb\3\2\2\2\u00db\u00bf\3\2"+
		"\2\2\u00db\u00c0\3\2\2\2\u00db\u00c7\3\2\2\2\u00db\u00c8\3\2\2\2\u00db"+
		"\u00c9\3\2\2\2\u00db\u00ca\3\2\2\2\u00db\u00cb\3\2\2\2\u00db\u00cc\3\2"+
		"\2\2\u00db\u00cd\3\2\2\2\u00db\u00ce\3\2\2\2\u00db\u00cf\3\2\2\2\u00db"+
		"\u00d0\3\2\2\2\u00dc\u00f9\3\2\2\2\u00dd\u00de\f\26\2\2\u00de\u00df\7"+
		"\31\2\2\u00df\u00f8\5\32\16\27\u00e0\u00e1\f\25\2\2\u00e1\u00e2\7\n\2"+
		"\2\u00e2\u00f8\5\32\16\26\u00e3\u00e4\f\24\2\2\u00e4\u00e5\t\2\2\2\u00e5"+
		"\u00f8\5\32\16\25\u00e6\u00e7\f\23\2\2\u00e7\u00e8\t\3\2\2\u00e8\u00f8"+
		"\5\32\16\24\u00e9\u00ea\f\22\2\2\u00ea\u00eb\t\4\2\2\u00eb\u00f8\5\32"+
		"\16\23\u00ec\u00ed\f\21\2\2\u00ed\u00ee\t\5\2\2\u00ee\u00f8\5\32\16\22"+
		"\u00ef\u00f0\f\16\2\2\u00f0\u00f1\t\6\2\2\u00f1\u00f8\5\32\16\17\u00f2"+
		"\u00f3\f\f\2\2\u00f3\u00f4\7\13\2\2\u00f4\u00f5\5\32\16\2\u00f5\u00f6"+
		"\7\f\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00dd\3\2\2\2\u00f7\u00e0\3\2\2\2\u00f7"+
		"\u00e3\3\2\2\2\u00f7\u00e6\3\2\2\2\u00f7\u00e9\3\2\2\2\u00f7\u00ec\3\2"+
		"\2\2\u00f7\u00ef\3\2\2\2\u00f7\u00f2\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\33\3\2\2\2\u00fb\u00f9\3\2\2"+
		"\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe\5\32\16\2\u00fe\u00ff\7\4\2\2\u00ff"+
		"\35\3\2\2\2\u0100\u0101\7\r\2\2\u0101\u0102\7\32\2\2\u0102\u010b\7\3\2"+
		"\2\u0103\u0108\5\32\16\2\u0104\u0105\7\7\2\2\u0105\u0107\5\32\16\2\u0106"+
		"\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u0103\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7\4\2\2\u010e\37\3\2\2"+
		"\2\u010f\u0110\7\16\2\2\u0110\u0111\7\33\2\2\u0111!\3\2\2\2\u0112\u0113"+
		"\7\17\2\2\u0113\u0114\5$\23\2\u0114#\3\2\2\2\u0115\u0116\b\23\1\2\u0116"+
		"\u0117\7\32\2\2\u0117\u011d\3\2\2\2\u0118\u0119\f\3\2\2\u0119\u011a\7"+
		"#\2\2\u011a\u011c\7\32\2\2\u011b\u0118\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e%\3\2\2\2\u011f\u011d\3\2\2\2"+
		"\u0120\u0121\7\20\2\2\u0121\u0122\7\3\2\2\u0122\u0123\5\24\13\2\u0123"+
		"\u0125\7\4\2\2\u0124\u0126\5\60\31\2\u0125\u0124\3\2\2\2\u0125\u0126\3"+
		"\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\7\5\2\2\u0128\u0129\5\20\t\2\u0129"+
		"\u0138\7\6\2\2\u012a\u012c\5\60\31\2\u012b\u012a\3\2\2\2\u012b\u012c\3"+
		"\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\7\21\2\2\u012e\u0130\5\60\31\2"+
		"\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133"+
		"\7\5\2\2\u0132\u0134\5\60\31\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0135\u0136\5\20\t\2\u0136\u0137\7\6\2\2\u0137\u0139"+
		"\3\2\2\2\u0138\u012b\3\2\2\2\u0138\u0139\3\2\2\2\u0139\'\3\2\2\2\u013a"+
		"\u013b\7\22\2\2\u013b\u013c\7\3\2\2\u013c\u013d\7\32\2\2\u013d\u013e\7"+
		"\23\2\2\u013e\u013f\5\32\16\2\u013f\u0141\7\4\2\2\u0140\u0142\5\60\31"+
		"\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145"+
		"\7\5\2\2\u0144\u0146\5\60\31\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2"+
		"\u0146\u0147\3\2\2\2\u0147\u0148\5\20\t\2\u0148\u0149\7\6\2\2\u0149)\3"+
		"\2\2\2\u014a\u014b\5,\27\2\u014b\u014c\7\24\2\2\u014c\u014d\5\32\16\2"+
		"\u014d+\3\2\2\2\u014e\u014f\7\25\2\2\u014f\u0150\7\32\2\2\u0150-\3\2\2"+
		"\2\u0151\u0152\t\7\2\2\u0152/\3\2\2\2\u0153\u0155\7\b\2\2\u0154\u0153"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\61\3\2\2\2\'\64:=ALSW[cjnq}\u0081\u0087\u008b\u0090\u0096\u00a0\u00a6"+
		"\u00af\u00b2\u00d6\u00db\u00f7\u00f9\u0108\u010b\u011d\u0125\u012b\u012f"+
		"\u0133\u0138\u0141\u0145\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}