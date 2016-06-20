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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		D=25, SYMBOL=26, INT_NUMBER=27, FLOAT_NUMBER=28, BOOLEAN=29, TEXT_STRING=30, 
		WS=31, COMMENT=32, COMMENT2=33, MUL=34, DIV=35, ADD=36, SUB=37, EQ=38, 
		NEQ=39, GREQ=40, LESEQ=41, GREAT=42, LESS=43, AND=44, OR=45, MOVE_RIGHT=46, 
		MOVE_LEFT=47;
	public static final int
		RULE_s = 0, RULE_class_def = 1, RULE_attributes = 2, RULE_attrib = 3, 
		RULE_methods = 4, RULE_method = 5, RULE_params = 6, RULE_code = 7, RULE_aline = 8, 
		RULE_line = 9, RULE_variable = 10, RULE_function = 11, RULE_operation = 12, 
		RULE_parens = 13, RULE_new_obj = 14, RULE_sharp_identifier = 15, RULE_room = 16, 
		RULE_room_path = 17, RULE_exp_if = 18, RULE_exp_for = 19, RULE_exp_user = 20, 
		RULE_username = 21, RULE_data_type = 22;
	public static final String[] ruleNames = {
		"s", "class_def", "attributes", "attrib", "methods", "method", "params", 
		"code", "aline", "line", "variable", "function", "operation", "parens", 
		"new_obj", "sharp_identifier", "room", "room_path", "exp_if", "exp_for", 
		"exp_user", "username", "data_type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'/n'", "'{'", "'}'", "'\n'", "':='", "'('", "')'", "','", "'.'", 
		"'^'", "'['", "']'", "'new'", "'#'", "'@'", "'if'", "'else'", "'for'", 
		"':'", "'->'", "'$'", "'int'", "'float'", "'string'", "'d'", null, null, 
		null, null, null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'='", 
		"'!='", "'>='", "'<='", "'>'", "'<'", "'&'", "'|'", "'>>'", "'<<'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "D", "SYMBOL", "INT_NUMBER", "FLOAT_NUMBER", "BOOLEAN", "TEXT_STRING", 
		"WS", "COMMENT", "COMMENT2", "MUL", "DIV", "ADD", "SUB", "EQ", "NEQ", 
		"GREQ", "LESEQ", "GREAT", "LESS", "AND", "OR", "MOVE_RIGHT", "MOVE_LEFT"
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
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
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
			if (_la==LESS) {
				{
				setState(51);
				match(LESS);
				setState(52);
				match(SYMBOL);
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(55);
				match(T__0);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(T__1);
			setState(62);
			attributes();
			setState(63);
			methods();
			setState(64);
			match(T__2);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) {
				{
				{
				setState(66);
				attrib();
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(67);
					match(T__3);
					}
					}
					setState(70); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__3 );
				}
				}
				setState(76);
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

	public static class AttribContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
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
			if (_la==T__4) {
				{
				setState(79);
				match(T__4);
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
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				method();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(84);
					match(T__3);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 || _la==SYMBOL );
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
			setState(99);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(94);
				match(T__5);
				setState(95);
				params();
				setState(96);
				match(T__6);
				setState(97);
				match(T__4);
				}
			}

			setState(101);
			match(SYMBOL);
			setState(102);
			match(T__5);
			setState(103);
			params();
			setState(104);
			match(T__6);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(105);
				match(T__3);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(T__1);
			setState(113);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__5) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB))) != 0)) {
				{
				setState(112);
				code();
				}
			}

			setState(115);
			match(T__2);
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
			setState(117);
			data_type();
			setState(118);
			match(SYMBOL);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(119);
				match(T__7);
				setState(120);
				data_type();
				setState(121);
				match(SYMBOL);
				}
				}
				setState(127);
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
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(128);
				match(T__3);
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			line();
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(135);
					aline();
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(141);
				match(T__3);
				}
				}
				setState(146);
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
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__3);
				setState(148);
				line();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(T__3);
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
			setState(156);
			switch (_input.LA(1)) {
			case T__1:
			case T__5:
			case T__12:
			case T__13:
			case T__14:
			case D:
			case SYMBOL:
			case INT_NUMBER:
			case FLOAT_NUMBER:
			case BOOLEAN:
			case TEXT_STRING:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				operation(0);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				exp_if();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				exp_for();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
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

			setState(159);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IntermediateVariableContext(new VariableContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_variable);
					setState(161);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(162);
					match(T__8);
					setState(163);
					match(SYMBOL);
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(169);
				variable(0);
				setState(170);
				match(T__8);
				}
				break;
			}
			setState(174);
			match(SYMBOL);
			setState(175);
			match(T__5);
			setState(184);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB))) != 0)) {
				{
				setState(176);
				operation(0);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(177);
					match(T__7);
					setState(178);
					operation(0);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(186);
			match(T__6);
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
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(189);
				match(SUB);
				setState(190);
				operation(22);
				}
				break;
			case 2:
				{
				_localctx = new DiceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(D);
				setState(192);
				operation(21);
				}
				break;
			case 3:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				variable(0);
				setState(194);
				match(T__4);
				setState(195);
				operation(14);
				}
				break;
			case 4:
				{
				_localctx = new FunctionOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				function();
				}
				break;
			case 5:
				{
				_localctx = new IndexAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				variable(0);
				setState(199);
				match(T__10);
				setState(200);
				operation(0);
				setState(201);
				match(T__11);
				setState(202);
				match(T__4);
				setState(203);
				operation(0);
				}
				break;
			case 6:
				{
				_localctx = new VariableOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				variable(0);
				}
				break;
			case 7:
				{
				_localctx = new NewObjContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				new_obj();
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(INT_NUMBER);
				}
				break;
			case 9:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(FLOAT_NUMBER);
				}
				break;
			case 10:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(BOOLEAN);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(TEXT_STRING);
				}
				break;
			case 12:
				{
				_localctx = new SharpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				sharp_identifier();
				}
				break;
			case 13:
				{
				_localctx = new RoomOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				room();
				}
				break;
			case 14:
				{
				_localctx = new ParensOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				parens();
				}
				break;
			case 15:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(T__1);
				setState(215);
				operation(0);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(216);
					match(T__7);
					setState(217);
					operation(0);
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(223);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(253);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new MultDiceContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(227);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(228);
						match(D);
						setState(229);
						operation(21);
						}
						break;
					case 2:
						{
						_localctx = new ExponentContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(230);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(231);
						match(T__9);
						setState(232);
						operation(20);
						}
						break;
					case 3:
						{
						_localctx = new MulDivContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(233);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(234);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(235);
						operation(19);
						}
						break;
					case 4:
						{
						_localctx = new AddSubContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(236);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(237);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(238);
						operation(18);
						}
						break;
					case 5:
						{
						_localctx = new CompareContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(239);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(240);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GREQ) | (1L << LESEQ) | (1L << GREAT) | (1L << LESS))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(241);
						operation(17);
						}
						break;
					case 6:
						{
						_localctx = new LogicContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(242);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(243);
						((LogicContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(244);
						operation(16);
						}
						break;
					case 7:
						{
						_localctx = new MoveContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(245);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(246);
						((MoveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MOVE_RIGHT) ) {
							((MoveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(247);
						operation(13);
						}
						break;
					case 8:
						{
						_localctx = new IndexContext(new OperationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_operation);
						setState(248);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(249);
						match(T__10);
						setState(250);
						operation(0);
						setState(251);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(257);
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
			setState(258);
			match(T__5);
			setState(259);
			operation(0);
			setState(260);
			match(T__6);
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
			setState(262);
			match(T__12);
			setState(263);
			match(SYMBOL);
			setState(264);
			match(T__5);
			setState(273);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << D) | (1L << SYMBOL) | (1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << BOOLEAN) | (1L << TEXT_STRING) | (1L << SUB))) != 0)) {
				{
				setState(265);
				operation(0);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(266);
					match(T__7);
					setState(267);
					operation(0);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(275);
			match(T__6);
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
			setState(277);
			match(T__13);
			setState(278);
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
			setState(280);
			match(T__14);
			setState(281);
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
			setState(284);
			match(SYMBOL);
			}
			_ctx.stop = _input.LT(-1);
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Room_pathContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_room_path);
					setState(286);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(287);
					match(DIV);
					setState(288);
					match(SYMBOL);
					}
					} 
				}
				setState(293);
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
			setState(294);
			match(T__15);
			setState(295);
			match(T__5);
			setState(296);
			line();
			setState(297);
			match(T__6);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(298);
				match(T__0);
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304);
			match(T__1);
			setState(305);
			code();
			setState(306);
			match(T__2);
			setState(324);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__16) {
				{
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(307);
					match(T__0);
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313);
				match(T__16);
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(314);
					match(T__0);
					}
					}
					setState(319);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(320);
				match(T__1);
				setState(321);
				code();
				setState(322);
				match(T__2);
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

	public static class Exp_forContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(LinguaxeParser.SYMBOL, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
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
			setState(326);
			match(T__17);
			setState(327);
			match(T__5);
			setState(328);
			match(SYMBOL);
			setState(329);
			match(T__18);
			setState(330);
			operation(0);
			setState(331);
			match(T__6);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(332);
				match(T__0);
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
			match(T__1);
			setState(339);
			code();
			setState(340);
			match(T__2);
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
			setState(342);
			username();
			setState(343);
			match(T__19);
			setState(344);
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
			setState(346);
			match(T__20);
			setState(347);
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
			setState(349);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u0162\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\5"+
		"\2\63\n\2\3\3\3\3\3\3\5\38\n\3\3\3\7\3;\n\3\f\3\16\3>\13\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\6\4G\n\4\r\4\16\4H\7\4K\n\4\f\4\16\4N\13\4\3\5\3\5\3"+
		"\5\3\5\5\5T\n\5\3\6\3\6\7\6X\n\6\f\6\16\6[\13\6\6\6]\n\6\r\6\16\6^\3\7"+
		"\3\7\3\7\3\7\3\7\5\7f\n\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7"+
		"\3\7\3\7\5\7t\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b~\n\b\f\b\16\b\u0081"+
		"\13\b\3\t\7\t\u0084\n\t\f\t\16\t\u0087\13\t\3\t\3\t\7\t\u008b\n\t\f\t"+
		"\16\t\u008e\13\t\3\t\7\t\u0091\n\t\f\t\16\t\u0094\13\t\3\n\3\n\3\n\5\n"+
		"\u0099\n\n\3\13\3\13\3\13\3\13\5\13\u009f\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\7\f\u00a7\n\f\f\f\16\f\u00aa\13\f\3\r\3\r\3\r\5\r\u00af\n\r\3\r\3\r\3"+
		"\r\3\r\3\r\7\r\u00b6\n\r\f\r\16\r\u00b9\13\r\5\r\u00bb\n\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00dd\n\16\f\16\16\16\u00e0\13\16\3\16\3\16\5\16\u00e4\n\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0100"+
		"\n\16\f\16\16\16\u0103\13\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\7\20\u010f\n\20\f\20\16\20\u0112\13\20\5\20\u0114\n\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0124"+
		"\n\23\f\23\16\23\u0127\13\23\3\24\3\24\3\24\3\24\3\24\7\24\u012e\n\24"+
		"\f\24\16\24\u0131\13\24\3\24\3\24\3\24\3\24\7\24\u0137\n\24\f\24\16\24"+
		"\u013a\13\24\3\24\3\24\7\24\u013e\n\24\f\24\16\24\u0141\13\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0147\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0150"+
		"\n\25\f\25\16\25\u0153\13\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\2\5\26\32$\31\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\2\b\3\2$%\3\2&\'\3\2(-\3\2./\3\2\60\60\3\2\30\32"+
		"\u0180\2\62\3\2\2\2\4\64\3\2\2\2\6L\3\2\2\2\bO\3\2\2\2\n\\\3\2\2\2\fe"+
		"\3\2\2\2\16w\3\2\2\2\20\u0085\3\2\2\2\22\u0098\3\2\2\2\24\u009e\3\2\2"+
		"\2\26\u00a0\3\2\2\2\30\u00ae\3\2\2\2\32\u00e3\3\2\2\2\34\u0104\3\2\2\2"+
		"\36\u0108\3\2\2\2 \u0117\3\2\2\2\"\u011a\3\2\2\2$\u011d\3\2\2\2&\u0128"+
		"\3\2\2\2(\u0148\3\2\2\2*\u0158\3\2\2\2,\u015c\3\2\2\2.\u015f\3\2\2\2\60"+
		"\63\5\4\3\2\61\63\5\20\t\2\62\60\3\2\2\2\62\61\3\2\2\2\63\3\3\2\2\2\64"+
		"\67\7\34\2\2\65\66\7-\2\2\668\7\34\2\2\67\65\3\2\2\2\678\3\2\2\28<\3\2"+
		"\2\29;\7\3\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2"+
		"\2\2?@\7\4\2\2@A\5\6\4\2AB\5\n\6\2BC\7\5\2\2C\5\3\2\2\2DF\5\b\5\2EG\7"+
		"\6\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JD\3\2\2\2KN\3"+
		"\2\2\2LJ\3\2\2\2LM\3\2\2\2M\7\3\2\2\2NL\3\2\2\2OP\5.\30\2PS\7\34\2\2Q"+
		"R\7\7\2\2RT\5\32\16\2SQ\3\2\2\2ST\3\2\2\2T\t\3\2\2\2UY\5\f\7\2VX\7\6\2"+
		"\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2\\U\3\2"+
		"\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\13\3\2\2\2`a\7\b\2\2ab\5\16\b\2b"+
		"c\7\t\2\2cd\7\7\2\2df\3\2\2\2e`\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\34\2\2"+
		"hi\7\b\2\2ij\5\16\b\2jn\7\t\2\2km\7\6\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2"+
		"\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qs\7\4\2\2rt\5\20\t\2sr\3\2\2\2st\3\2"+
		"\2\2tu\3\2\2\2uv\7\5\2\2v\r\3\2\2\2wx\5.\30\2x\177\7\34\2\2yz\7\n\2\2"+
		"z{\5.\30\2{|\7\34\2\2|~\3\2\2\2}y\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\17\3\2\2\2\u0081\177\3\2\2\2\u0082\u0084\7\6"+
		"\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008c\5\24"+
		"\13\2\u0089\u008b\5\22\n\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0092\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008f\u0091\7\6\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\21\3\2\2\2\u0094\u0092\3\2\2"+
		"\2\u0095\u0096\7\6\2\2\u0096\u0099\5\24\13\2\u0097\u0099\7\6\2\2\u0098"+
		"\u0095\3\2\2\2\u0098\u0097\3\2\2\2\u0099\23\3\2\2\2\u009a\u009f\5\32\16"+
		"\2\u009b\u009f\5&\24\2\u009c\u009f\5(\25\2\u009d\u009f\5*\26\2\u009e\u009a"+
		"\3\2\2\2\u009e\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\25\3\2\2\2\u00a0\u00a1\b\f\1\2\u00a1\u00a2\7\34\2\2\u00a2\u00a8\3\2\2"+
		"\2\u00a3\u00a4\f\3\2\2\u00a4\u00a5\7\13\2\2\u00a5\u00a7\7\34\2\2\u00a6"+
		"\u00a3\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\27\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad"+
		"\7\13\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ab\3\2\2\2\u00ae\u00af\3\2\2\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\34\2\2\u00b1\u00ba\7\b\2\2\u00b2\u00b7"+
		"\5\32\16\2\u00b3\u00b4\7\n\2\2\u00b4\u00b6\5\32\16\2\u00b5\u00b3\3\2\2"+
		"\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bb"+
		"\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00b2\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\7\t\2\2\u00bd\31\3\2\2\2\u00be\u00bf\b\16\1"+
		"\2\u00bf\u00c0\7\'\2\2\u00c0\u00e4\5\32\16\30\u00c1\u00c2\7\33\2\2\u00c2"+
		"\u00e4\5\32\16\27\u00c3\u00c4\5\26\f\2\u00c4\u00c5\7\7\2\2\u00c5\u00c6"+
		"\5\32\16\20\u00c6\u00e4\3\2\2\2\u00c7\u00e4\5\30\r\2\u00c8\u00c9\5\26"+
		"\f\2\u00c9\u00ca\7\r\2\2\u00ca\u00cb\5\32\16\2\u00cb\u00cc\7\16\2\2\u00cc"+
		"\u00cd\7\7\2\2\u00cd\u00ce\5\32\16\2\u00ce\u00e4\3\2\2\2\u00cf\u00e4\5"+
		"\26\f\2\u00d0\u00e4\5\36\20\2\u00d1\u00e4\7\35\2\2\u00d2\u00e4\7\36\2"+
		"\2\u00d3\u00e4\7\37\2\2\u00d4\u00e4\7 \2\2\u00d5\u00e4\5 \21\2\u00d6\u00e4"+
		"\5\"\22\2\u00d7\u00e4\5\34\17\2\u00d8\u00d9\7\4\2\2\u00d9\u00de\5\32\16"+
		"\2\u00da\u00db\7\n\2\2\u00db\u00dd\5\32\16\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\5\2\2\u00e2\u00e4\3\2\2\2\u00e3"+
		"\u00be\3\2\2\2\u00e3\u00c1\3\2\2\2\u00e3\u00c3\3\2\2\2\u00e3\u00c7\3\2"+
		"\2\2\u00e3\u00c8\3\2\2\2\u00e3\u00cf\3\2\2\2\u00e3\u00d0\3\2\2\2\u00e3"+
		"\u00d1\3\2\2\2\u00e3\u00d2\3\2\2\2\u00e3\u00d3\3\2\2\2\u00e3\u00d4\3\2"+
		"\2\2\u00e3\u00d5\3\2\2\2\u00e3\u00d6\3\2\2\2\u00e3\u00d7\3\2\2\2\u00e3"+
		"\u00d8\3\2\2\2\u00e4\u0101\3\2\2\2\u00e5\u00e6\f\26\2\2\u00e6\u00e7\7"+
		"\33\2\2\u00e7\u0100\5\32\16\27\u00e8\u00e9\f\25\2\2\u00e9\u00ea\7\f\2"+
		"\2\u00ea\u0100\5\32\16\26\u00eb\u00ec\f\24\2\2\u00ec\u00ed\t\2\2\2\u00ed"+
		"\u0100\5\32\16\25\u00ee\u00ef\f\23\2\2\u00ef\u00f0\t\3\2\2\u00f0\u0100"+
		"\5\32\16\24\u00f1\u00f2\f\22\2\2\u00f2\u00f3\t\4\2\2\u00f3\u0100\5\32"+
		"\16\23\u00f4\u00f5\f\21\2\2\u00f5\u00f6\t\5\2\2\u00f6\u0100\5\32\16\22"+
		"\u00f7\u00f8\f\16\2\2\u00f8\u00f9\t\6\2\2\u00f9\u0100\5\32\16\17\u00fa"+
		"\u00fb\f\f\2\2\u00fb\u00fc\7\r\2\2\u00fc\u00fd\5\32\16\2\u00fd\u00fe\7"+
		"\16\2\2\u00fe\u0100\3\2\2\2\u00ff\u00e5\3\2\2\2\u00ff\u00e8\3\2\2\2\u00ff"+
		"\u00eb\3\2\2\2\u00ff\u00ee\3\2\2\2\u00ff\u00f1\3\2\2\2\u00ff\u00f4\3\2"+
		"\2\2\u00ff\u00f7\3\2\2\2\u00ff\u00fa\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\33\3\2\2\2\u0103\u0101\3\2\2"+
		"\2\u0104\u0105\7\b\2\2\u0105\u0106\5\32\16\2\u0106\u0107\7\t\2\2\u0107"+
		"\35\3\2\2\2\u0108\u0109\7\17\2\2\u0109\u010a\7\34\2\2\u010a\u0113\7\b"+
		"\2\2\u010b\u0110\5\32\16\2\u010c\u010d\7\n\2\2\u010d\u010f\5\32\16\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u010b\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7\t\2\2\u0116\37\3\2\2"+
		"\2\u0117\u0118\7\20\2\2\u0118\u0119\7\35\2\2\u0119!\3\2\2\2\u011a\u011b"+
		"\7\21\2\2\u011b\u011c\5$\23\2\u011c#\3\2\2\2\u011d\u011e\b\23\1\2\u011e"+
		"\u011f\7\34\2\2\u011f\u0125\3\2\2\2\u0120\u0121\f\3\2\2\u0121\u0122\7"+
		"%\2\2\u0122\u0124\7\34\2\2\u0123\u0120\3\2\2\2\u0124\u0127\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126%\3\2\2\2\u0127\u0125\3\2\2\2"+
		"\u0128\u0129\7\22\2\2\u0129\u012a\7\b\2\2\u012a\u012b\5\24\13\2\u012b"+
		"\u012f\7\t\2\2\u012c\u012e\7\3\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131"+
		"\u012f\3\2\2\2\u0132\u0133\7\4\2\2\u0133\u0134\5\20\t\2\u0134\u0146\7"+
		"\5\2\2\u0135\u0137\7\3\2\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2"+
		"\2\2\u013b\u013f\7\23\2\2\u013c\u013e\7\3\2\2\u013d\u013c\3\2\2\2\u013e"+
		"\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0142\u0143\7\4\2\2\u0143\u0144\5\20\t\2\u0144"+
		"\u0145\7\5\2\2\u0145\u0147\3\2\2\2\u0146\u0138\3\2\2\2\u0146\u0147\3\2"+
		"\2\2\u0147\'\3\2\2\2\u0148\u0149\7\24\2\2\u0149\u014a\7\b\2\2\u014a\u014b"+
		"\7\34\2\2\u014b\u014c\7\25\2\2\u014c\u014d\5\32\16\2\u014d\u0151\7\t\2"+
		"\2\u014e\u0150\7\3\2\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0155\7\4\2\2\u0155\u0156\5\20\t\2\u0156\u0157\7\5\2\2\u0157)\3\2\2\2"+
		"\u0158\u0159\5,\27\2\u0159\u015a\7\26\2\2\u015a\u015b\5\32\16\2\u015b"+
		"+\3\2\2\2\u015c\u015d\7\27\2\2\u015d\u015e\7\34\2\2\u015e-\3\2\2\2\u015f"+
		"\u0160\t\7\2\2\u0160/\3\2\2\2#\62\67<HLSY^ens\177\u0085\u008c\u0092\u0098"+
		"\u009e\u00a8\u00ae\u00b7\u00ba\u00de\u00e3\u00ff\u0101\u0110\u0113\u0125"+
		"\u012f\u0138\u013f\u0146\u0151";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}