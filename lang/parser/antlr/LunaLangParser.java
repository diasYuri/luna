// Generated from ../lang/parser/LunaLang.g4 by ANTLR 4.8

    package lang.parser.antlr;
    import lang.ast.*;
    import lang.ast.abstracts.*;
    import lang.ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LunaLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, TYPE_INT=36, TYPE_CHAR=37, TYPE_BOOL=38, 
		TYPE_FLOAT=39, BREAKLINE=40, INT=41, FLOAT=42, CHAR=43, WS=44, ID=45, 
		LINE_COMMENT=46, COMMENT=47;
	public static final int
		RULE_prog = 0, RULE_data = 1, RULE_decl = 2, RULE_func = 3, RULE_params = 4, 
		RULE_cmd = 5, RULE_type = 6, RULE_exp = 7, RULE_rexp = 8, RULE_aexp = 9, 
		RULE_mexp = 10, RULE_sexp = 11, RULE_pexp = 12, RULE_exps = 13, RULE_lvalue = 14, 
		RULE_btype = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "data", "decl", "func", "params", "cmd", "type", "exp", "rexp", 
			"aexp", "mexp", "sexp", "pexp", "exps", "lvalue", "btype"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'data'", "'{'", "'}'", "'::'", "';'", "'('", "')'", "':'", "','", 
			"'if'", "'else'", "'iterate'", "'read'", "'print'", "'return'", "'='", 
			"'<'", "'>'", "'[]'", "'&&'", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'!'", "'true'", "'false'", "'null'", "'new'", "'['", "']'", "'.'", 
			"'Int'", "'Char'", "'Bool'", "'Float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TYPE_INT", "TYPE_CHAR", "TYPE_BOOL", "TYPE_FLOAT", "BREAKLINE", "INT", 
			"FLOAT", "CHAR", "WS", "ID", "LINE_COMMENT", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "LunaLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LunaLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LunaLangParser.EOF, 0); }
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(32);
				data();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(38);
				func();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(EOF);
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

	public static class DataContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			match(ID);
			setState(48);
			match(T__1);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(49);
				decl();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ID);
			setState(58);
			match(T__3);
			setState(59);
			type(0);
			setState(60);
			match(T__4);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ID);
			setState(63);
			match(T__5);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(64);
				params();
				}
			}

			setState(67);
			match(T__6);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(68);
				match(T__7);
				setState(69);
				type(0);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(70);
					match(T__8);
					setState(71);
					type(0);
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(79);
			match(T__1);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID))) != 0)) {
				{
				{
				setState(80);
				cmd();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
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
		public List<TerminalNode> ID() { return getTokens(LunaLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LunaLangParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(ID);
			setState(89);
			match(T__3);
			setState(90);
			type(0);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(91);
				match(T__8);
				setState(92);
				match(ID);
				setState(93);
				match(T__3);
				setState(94);
				type(0);
				}
				}
				setState(99);
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

	public static class CmdContext extends ParserRuleContext {
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	 
		public CmdContext() { }
		public void copyFrom(CmdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintContext extends CmdContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadContext extends CmdContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ReadContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CmdscopeContext extends CmdContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdscopeContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitCmdscope(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttrContext extends CmdContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AttrContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends CmdContext {
		public CmdContext cmd_if;
		public CmdContext cmd_else;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public IfContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends CmdContext {
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public ReturnContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterateContext extends CmdContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public IterateContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitIterate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Call_attrContext extends CmdContext {
		public ExpsContext parameters;
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public List<LvalueContext> lvalue() {
			return getRuleContexts(LvalueContext.class);
		}
		public LvalueContext lvalue(int i) {
			return getRuleContext(LvalueContext.class,i);
		}
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public Call_attrContext(CmdContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitCall_attr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		int _la;
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new CmdscopeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(T__1);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << ID))) != 0)) {
					{
					{
					setState(101);
					cmd();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(T__9);
				setState(109);
				match(T__5);
				setState(110);
				exp(0);
				setState(111);
				match(T__6);
				setState(112);
				((IfContext)_localctx).cmd_if = cmd();
				}
				break;
			case 3:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(T__9);
				setState(115);
				match(T__5);
				setState(116);
				exp(0);
				setState(117);
				match(T__6);
				setState(118);
				((IfContext)_localctx).cmd_if = cmd();
				setState(119);
				match(T__10);
				setState(120);
				((IfContext)_localctx).cmd_else = cmd();
				}
				break;
			case 4:
				_localctx = new IterateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(T__11);
				setState(123);
				match(T__5);
				setState(124);
				exp(0);
				setState(125);
				match(T__6);
				setState(126);
				cmd();
				}
				break;
			case 5:
				_localctx = new ReadContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				match(T__12);
				setState(129);
				lvalue(0);
				setState(130);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				match(T__13);
				setState(133);
				exp(0);
				setState(134);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(136);
				match(T__14);
				setState(137);
				exps();
				setState(138);
				match(T__4);
				}
				break;
			case 8:
				_localctx = new AttrContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(140);
				lvalue(0);
				setState(141);
				match(T__15);
				setState(142);
				exp(0);
				setState(143);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new Call_attrContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(145);
				match(ID);
				setState(146);
				match(T__5);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << INT) | (1L << FLOAT) | (1L << CHAR) | (1L << ID))) != 0)) {
					{
					setState(147);
					((Call_attrContext)_localctx).parameters = exps();
					}
				}

				setState(150);
				match(T__6);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(151);
					match(T__16);
					setState(152);
					lvalue(0);
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(153);
						match(T__8);
						setState(154);
						lvalue(0);
						}
						}
						setState(159);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(160);
					match(T__17);
					}
				}

				setState(164);
				match(T__4);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeignoreContext extends TypeContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public TypeignoreContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitTypeignore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TypeignoreContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(168);
			btype();
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(170);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(171);
					match(T__18);
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndexpContext extends ExpContext {
		public ExpContext left;
		public ExpContext right;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public AndexpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitAndexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpignoreContext extends ExpContext {
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public ExpignoreContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitExpignore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExpignoreContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(178);
			rexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndexpContext(new ExpContext(_parentctx, _parentState));
					((AndexpContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(180);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(181);
					match(T__19);
					setState(182);
					((AndexpContext)_localctx).right = exp(3);
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class RexpContext extends ParserRuleContext {
		public RexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rexp; }
	 
		public RexpContext() { }
		public void copyFrom(RexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Lesser_thanContext extends RexpContext {
		public AexpContext left;
		public AexpContext right;
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public Lesser_thanContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitLesser_than(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualsContext extends RexpContext {
		public RexpContext l;
		public AexpContext right;
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public EqualsContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotequalsContext extends RexpContext {
		public RexpContext l;
		public AexpContext right;
		public RexpContext rexp() {
			return getRuleContext(RexpContext.class,0);
		}
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public NotequalsContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitNotequals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RexpignoreContext extends RexpContext {
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public RexpignoreContext(RexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitRexpignore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RexpContext rexp() throws RecognitionException {
		return rexp(0);
	}

	private RexpContext rexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RexpContext _localctx = new RexpContext(_ctx, _parentState);
		RexpContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_rexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new Lesser_thanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(189);
				((Lesser_thanContext)_localctx).left = aexp(0);
				setState(190);
				match(T__16);
				setState(191);
				((Lesser_thanContext)_localctx).right = aexp(0);
				}
				break;
			case 2:
				{
				_localctx = new RexpignoreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				aexp(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(202);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new EqualsContext(new RexpContext(_parentctx, _parentState));
						((EqualsContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
						setState(196);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(197);
						match(T__20);
						setState(198);
						((EqualsContext)_localctx).right = aexp(0);
						}
						break;
					case 2:
						{
						_localctx = new NotequalsContext(new RexpContext(_parentctx, _parentState));
						((NotequalsContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rexp);
						setState(199);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(200);
						match(T__21);
						setState(201);
						((NotequalsContext)_localctx).right = aexp(0);
						}
						break;
					}
					} 
				}
				setState(206);
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

	public static class AexpContext extends ParserRuleContext {
		public AexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp; }
	 
		public AexpContext() { }
		public void copyFrom(AexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddContext extends AexpContext {
		public AexpContext left;
		public MexpContext right;
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public AddContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubContext extends AexpContext {
		public AexpContext left;
		public MexpContext right;
		public AexpContext aexp() {
			return getRuleContext(AexpContext.class,0);
		}
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public SubContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AexpignoreContext extends AexpContext {
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public AexpignoreContext(AexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitAexpignore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpContext aexp() throws RecognitionException {
		return aexp(0);
	}

	private AexpContext aexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexpContext _localctx = new AexpContext(_ctx, _parentState);
		AexpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_aexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AexpignoreContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(208);
			mexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(216);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new AddContext(new AexpContext(_parentctx, _parentState));
						((AddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(210);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(211);
						match(T__22);
						setState(212);
						((AddContext)_localctx).right = mexp(0);
						}
						break;
					case 2:
						{
						_localctx = new SubContext(new AexpContext(_parentctx, _parentState));
						((SubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_aexp);
						setState(213);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(214);
						match(T__23);
						setState(215);
						((SubContext)_localctx).right = mexp(0);
						}
						break;
					}
					} 
				}
				setState(220);
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

	public static class MexpContext extends ParserRuleContext {
		public MexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mexp; }
	 
		public MexpContext() { }
		public void copyFrom(MexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivContext extends MexpContext {
		public MexpContext left;
		public SexpContext right;
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public DivContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends MexpContext {
		public MexpContext left;
		public SexpContext right;
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public MultContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModContext extends MexpContext {
		public MexpContext left;
		public SexpContext right;
		public MexpContext mexp() {
			return getRuleContext(MexpContext.class,0);
		}
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public ModContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MexpignoreContext extends MexpContext {
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public MexpignoreContext(MexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitMexpignore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MexpContext mexp() throws RecognitionException {
		return mexp(0);
	}

	private MexpContext mexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MexpContext _localctx = new MexpContext(_ctx, _parentState);
		MexpContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_mexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new MexpignoreContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(222);
			sexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(233);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new MexpContext(_parentctx, _parentState));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(224);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(225);
						match(T__24);
						setState(226);
						((MultContext)_localctx).right = sexp();
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new MexpContext(_parentctx, _parentState));
						((DivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(227);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(228);
						match(T__25);
						setState(229);
						((DivContext)_localctx).right = sexp();
						}
						break;
					case 3:
						{
						_localctx = new ModContext(new MexpContext(_parentctx, _parentState));
						((ModContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_mexp);
						setState(230);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(231);
						match(T__26);
						setState(232);
						((ModContext)_localctx).right = sexp();
						}
						break;
					}
					} 
				}
				setState(237);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SexpContext extends ParserRuleContext {
		public SexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexp; }
	 
		public SexpContext() { }
		public void copyFrom(SexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullContext extends SexpContext {
		public NullContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusexpContext extends SexpContext {
		public SexpContext right;
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public MinusexpContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitMinusexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends SexpContext {
		public TrueContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends SexpContext {
		public FalseContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharContext extends SexpContext {
		public TerminalNode CHAR() { return getToken(LunaLangParser.CHAR, 0); }
		public CharContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitChar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PexpignoreContext extends SexpContext {
		public PexpContext pexp() {
			return getRuleContext(PexpContext.class,0);
		}
		public PexpignoreContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitPexpignore(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NexpContext extends SexpContext {
		public SexpContext right;
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public NexpContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitNexp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatContext extends SexpContext {
		public TerminalNode FLOAT() { return getToken(LunaLangParser.FLOAT, 0); }
		public FloatContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends SexpContext {
		public TerminalNode INT() { return getToken(LunaLangParser.INT, 0); }
		public IntContext(SexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexpContext sexp() throws RecognitionException {
		SexpContext _localctx = new SexpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sexp);
		try {
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				_localctx = new NexpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(T__27);
				setState(239);
				((NexpContext)_localctx).right = sexp();
				}
				break;
			case T__23:
				_localctx = new MinusexpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(T__23);
				setState(241);
				((MinusexpContext)_localctx).right = sexp();
				}
				break;
			case T__28:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				match(T__28);
				}
				break;
			case T__29:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				match(T__29);
				}
				break;
			case T__30:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(244);
				match(T__30);
				}
				break;
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(245);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(246);
				match(FLOAT);
				}
				break;
			case CHAR:
				_localctx = new CharContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(247);
				match(CHAR);
				}
				break;
			case T__5:
			case T__31:
			case ID:
				_localctx = new PexpignoreContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(248);
				pexp();
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

	public static class PexpContext extends ParserRuleContext {
		public PexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pexp; }
	 
		public PexpContext() { }
		public void copyFrom(PexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TupleContext extends PexpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TupleContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewContext extends PexpContext {
		public ExpContext arr_exp;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NewContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PexpLvalueContext extends PexpContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public PexpLvalueContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitPexpLvalue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallValueContext extends PexpContext {
		public ExpsContext parameters;
		public ExpContext offset;
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public CallValueContext(PexpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitCallValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PexpContext pexp() throws RecognitionException {
		PexpContext _localctx = new PexpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pexp);
		int _la;
		try {
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new TupleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(T__5);
				setState(252);
				exp(0);
				setState(253);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new NewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(T__31);
				setState(256);
				type(0);
				setState(261);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(257);
					match(T__32);
					setState(258);
					((NewContext)_localctx).arr_exp = exp(0);
					setState(259);
					match(T__33);
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new CallValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				match(ID);
				setState(264);
				match(T__5);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << INT) | (1L << FLOAT) | (1L << CHAR) | (1L << ID))) != 0)) {
					{
					setState(265);
					((CallValueContext)_localctx).parameters = exps();
					}
				}

				setState(268);
				match(T__6);
				setState(269);
				match(T__32);
				setState(270);
				((CallValueContext)_localctx).offset = exp(0);
				setState(271);
				match(T__33);
				}
				break;
			case 4:
				_localctx = new PexpLvalueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(273);
				lvalue(0);
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

	public static class ExpsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitExps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			exp(0);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(277);
				match(T__8);
				setState(278);
				exp(0);
				}
				}
				setState(283);
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

	public static class LvalueContext extends ParserRuleContext {
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	 
		public LvalueContext() { }
		public void copyFrom(LvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LvalueAccessContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public LvalueAccessContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitLvalueAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueIdContext extends LvalueContext {
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public LvalueIdContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitLvalueId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueArrContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalueArrContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitLvalueArr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LvalueIdContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(285);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(295);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueArrContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(287);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(288);
						match(T__32);
						setState(289);
						exp(0);
						setState(290);
						match(T__33);
						}
						break;
					case 2:
						{
						_localctx = new LvalueAccessContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(292);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(293);
						match(T__34);
						setState(294);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(299);
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

	public static class BtypeContext extends ParserRuleContext {
		public TerminalNode TYPE_INT() { return getToken(LunaLangParser.TYPE_INT, 0); }
		public TerminalNode TYPE_CHAR() { return getToken(LunaLangParser.TYPE_CHAR, 0); }
		public TerminalNode TYPE_BOOL() { return getToken(LunaLangParser.TYPE_BOOL, 0); }
		public TerminalNode TYPE_FLOAT() { return getToken(LunaLangParser.TYPE_FLOAT, 0); }
		public TerminalNode ID() { return getToken(LunaLangParser.ID, 0); }
		public BtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LunaLangVisitor ) return ((LunaLangVisitor<? extends T>)visitor).visitBtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_btype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INT) | (1L << TYPE_CHAR) | (1L << TYPE_BOOL) | (1L << TYPE_FLOAT) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
		case 6:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 7:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 8:
			return rexp_sempred((RexpContext)_localctx, predIndex);
		case 9:
			return aexp_sempred((AexpContext)_localctx, predIndex);
		case 10:
			return mexp_sempred((MexpContext)_localctx, predIndex);
		case 14:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rexp_sempred(RexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean aexp_sempred(AexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mexp_sempred(MexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0131\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2"+
		"$\n\2\f\2\16\2\'\13\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\5\5D\n\5\3\5\3\5\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\5\5P\n\5\3\5\3\5"+
		"\7\5T\n\5\f\5\16\5W\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6b\n\6"+
		"\f\6\16\6e\13\6\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7\u0097\n\7\3\7\3\7\3\7\3\7\3\7\7\7\u009e\n\7\f\7\16\7\u00a1\13\7"+
		"\3\7\3\7\5\7\u00a5\n\7\3\7\5\7\u00a8\n\7\3\b\3\b\3\b\3\b\3\b\7\b\u00af"+
		"\n\b\f\b\16\b\u00b2\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ba\n\t\f\t\16"+
		"\t\u00bd\13\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c5\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\7\n\u00cd\n\n\f\n\16\n\u00d0\13\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00db\n\13\f\13\16\13\u00de\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ec\n\f\f\f\16\f\u00ef\13\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00fc\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0108\n\16\3\16\3\16\3\16\5\16"+
		"\u010d\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0115\n\16\3\17\3\17\3"+
		"\17\7\17\u011a\n\17\f\17\16\17\u011d\13\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\7\20\u012a\n\20\f\20\16\20\u012d\13\20\3"+
		"\21\3\21\3\21\2\b\16\20\22\24\26\36\22\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \2\3\4\2&)//\2\u014e\2%\3\2\2\2\4\60\3\2\2\2\6;\3\2\2\2\b@\3\2"+
		"\2\2\nZ\3\2\2\2\f\u00a7\3\2\2\2\16\u00a9\3\2\2\2\20\u00b3\3\2\2\2\22\u00c4"+
		"\3\2\2\2\24\u00d1\3\2\2\2\26\u00df\3\2\2\2\30\u00fb\3\2\2\2\32\u0114\3"+
		"\2\2\2\34\u0116\3\2\2\2\36\u011e\3\2\2\2 \u012e\3\2\2\2\"$\5\4\3\2#\""+
		"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&+\3\2\2\2\'%\3\2\2\2(*\5\b\5\2"+
		")(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\2\2\3"+
		"/\3\3\2\2\2\60\61\7\3\2\2\61\62\7/\2\2\62\66\7\4\2\2\63\65\5\6\4\2\64"+
		"\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3"+
		"\2\2\29:\7\5\2\2:\5\3\2\2\2;<\7/\2\2<=\7\6\2\2=>\5\16\b\2>?\7\7\2\2?\7"+
		"\3\2\2\2@A\7/\2\2AC\7\b\2\2BD\5\n\6\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EO"+
		"\7\t\2\2FG\7\n\2\2GL\5\16\b\2HI\7\13\2\2IK\5\16\b\2JH\3\2\2\2KN\3\2\2"+
		"\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OF\3\2\2\2OP\3\2\2\2PQ\3\2\2"+
		"\2QU\7\4\2\2RT\5\f\7\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2"+
		"\2WU\3\2\2\2XY\7\5\2\2Y\t\3\2\2\2Z[\7/\2\2[\\\7\6\2\2\\c\5\16\b\2]^\7"+
		"\13\2\2^_\7/\2\2_`\7\6\2\2`b\5\16\b\2a]\3\2\2\2be\3\2\2\2ca\3\2\2\2cd"+
		"\3\2\2\2d\13\3\2\2\2ec\3\2\2\2fj\7\4\2\2gi\5\f\7\2hg\3\2\2\2il\3\2\2\2"+
		"jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2m\u00a8\7\5\2\2no\7\f\2\2op\7"+
		"\b\2\2pq\5\20\t\2qr\7\t\2\2rs\5\f\7\2s\u00a8\3\2\2\2tu\7\f\2\2uv\7\b\2"+
		"\2vw\5\20\t\2wx\7\t\2\2xy\5\f\7\2yz\7\r\2\2z{\5\f\7\2{\u00a8\3\2\2\2|"+
		"}\7\16\2\2}~\7\b\2\2~\177\5\20\t\2\177\u0080\7\t\2\2\u0080\u0081\5\f\7"+
		"\2\u0081\u00a8\3\2\2\2\u0082\u0083\7\17\2\2\u0083\u0084\5\36\20\2\u0084"+
		"\u0085\7\7\2\2\u0085\u00a8\3\2\2\2\u0086\u0087\7\20\2\2\u0087\u0088\5"+
		"\20\t\2\u0088\u0089\7\7\2\2\u0089\u00a8\3\2\2\2\u008a\u008b\7\21\2\2\u008b"+
		"\u008c\5\34\17\2\u008c\u008d\7\7\2\2\u008d\u00a8\3\2\2\2\u008e\u008f\5"+
		"\36\20\2\u008f\u0090\7\22\2\2\u0090\u0091\5\20\t\2\u0091\u0092\7\7\2\2"+
		"\u0092\u00a8\3\2\2\2\u0093\u0094\7/\2\2\u0094\u0096\7\b\2\2\u0095\u0097"+
		"\5\34\17\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2"+
		"\u0098\u00a4\7\t\2\2\u0099\u009a\7\23\2\2\u009a\u009f\5\36\20\2\u009b"+
		"\u009c\7\13\2\2\u009c\u009e\5\36\20\2\u009d\u009b\3\2\2\2\u009e\u00a1"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u00a3\7\24\2\2\u00a3\u00a5\3\2\2\2\u00a4\u0099\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\7\7\2\2\u00a7"+
		"f\3\2\2\2\u00a7n\3\2\2\2\u00a7t\3\2\2\2\u00a7|\3\2\2\2\u00a7\u0082\3\2"+
		"\2\2\u00a7\u0086\3\2\2\2\u00a7\u008a\3\2\2\2\u00a7\u008e\3\2\2\2\u00a7"+
		"\u0093\3\2\2\2\u00a8\r\3\2\2\2\u00a9\u00aa\b\b\1\2\u00aa\u00ab\5 \21\2"+
		"\u00ab\u00b0\3\2\2\2\u00ac\u00ad\f\4\2\2\u00ad\u00af\7\25\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\17\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\b\t\1\2\u00b4\u00b5\5\22\n"+
		"\2\u00b5\u00bb\3\2\2\2\u00b6\u00b7\f\4\2\2\u00b7\u00b8\7\26\2\2\u00b8"+
		"\u00ba\5\20\t\5\u00b9\u00b6\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3"+
		"\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\21\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00bf\b\n\1\2\u00bf\u00c0\5\24\13\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2"+
		"\5\24\13\2\u00c2\u00c5\3\2\2\2\u00c3\u00c5\5\24\13\2\u00c4\u00be\3\2\2"+
		"\2\u00c4\u00c3\3\2\2\2\u00c5\u00ce\3\2\2\2\u00c6\u00c7\f\5\2\2\u00c7\u00c8"+
		"\7\27\2\2\u00c8\u00cd\5\24\13\2\u00c9\u00ca\f\4\2\2\u00ca\u00cb\7\30\2"+
		"\2\u00cb\u00cd\5\24\13\2\u00cc\u00c6\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\23\3\2\2"+
		"\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\b\13\1\2\u00d2\u00d3\5\26\f\2\u00d3"+
		"\u00dc\3\2\2\2\u00d4\u00d5\f\5\2\2\u00d5\u00d6\7\31\2\2\u00d6\u00db\5"+
		"\26\f\2\u00d7\u00d8\f\4\2\2\u00d8\u00d9\7\32\2\2\u00d9\u00db\5\26\f\2"+
		"\u00da\u00d4\3\2\2\2\u00da\u00d7\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\25\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00e0\b\f\1\2\u00e0\u00e1\5\30\r\2\u00e1\u00ed\3\2\2\2\u00e2\u00e3\f"+
		"\6\2\2\u00e3\u00e4\7\33\2\2\u00e4\u00ec\5\30\r\2\u00e5\u00e6\f\5\2\2\u00e6"+
		"\u00e7\7\34\2\2\u00e7\u00ec\5\30\r\2\u00e8\u00e9\f\4\2\2\u00e9\u00ea\7"+
		"\35\2\2\u00ea\u00ec\5\30\r\2\u00eb\u00e2\3\2\2\2\u00eb\u00e5\3\2\2\2\u00eb"+
		"\u00e8\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\27\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7\36\2\2\u00f1\u00fc"+
		"\5\30\r\2\u00f2\u00f3\7\32\2\2\u00f3\u00fc\5\30\r\2\u00f4\u00fc\7\37\2"+
		"\2\u00f5\u00fc\7 \2\2\u00f6\u00fc\7!\2\2\u00f7\u00fc\7+\2\2\u00f8\u00fc"+
		"\7,\2\2\u00f9\u00fc\7-\2\2\u00fa\u00fc\5\32\16\2\u00fb\u00f0\3\2\2\2\u00fb"+
		"\u00f2\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb\u00f6\3\2"+
		"\2\2\u00fb\u00f7\3\2\2\2\u00fb\u00f8\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fa\3\2\2\2\u00fc\31\3\2\2\2\u00fd\u00fe\7\b\2\2\u00fe\u00ff\5\20\t"+
		"\2\u00ff\u0100\7\t\2\2\u0100\u0115\3\2\2\2\u0101\u0102\7\"\2\2\u0102\u0107"+
		"\5\16\b\2\u0103\u0104\7#\2\2\u0104\u0105\5\20\t\2\u0105\u0106\7$\2\2\u0106"+
		"\u0108\3\2\2\2\u0107\u0103\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0115\3\2"+
		"\2\2\u0109\u010a\7/\2\2\u010a\u010c\7\b\2\2\u010b\u010d\5\34\17\2\u010c"+
		"\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\7\t"+
		"\2\2\u010f\u0110\7#\2\2\u0110\u0111\5\20\t\2\u0111\u0112\7$\2\2\u0112"+
		"\u0115\3\2\2\2\u0113\u0115\5\36\20\2\u0114\u00fd\3\2\2\2\u0114\u0101\3"+
		"\2\2\2\u0114\u0109\3\2\2\2\u0114\u0113\3\2\2\2\u0115\33\3\2\2\2\u0116"+
		"\u011b\5\20\t\2\u0117\u0118\7\13\2\2\u0118\u011a\5\20\t\2\u0119\u0117"+
		"\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\35\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\b\20\1\2\u011f\u0120\7/\2"+
		"\2\u0120\u012b\3\2\2\2\u0121\u0122\f\4\2\2\u0122\u0123\7#\2\2\u0123\u0124"+
		"\5\20\t\2\u0124\u0125\7$\2\2\u0125\u012a\3\2\2\2\u0126\u0127\f\3\2\2\u0127"+
		"\u0128\7%\2\2\u0128\u012a\7/\2\2\u0129\u0121\3\2\2\2\u0129\u0126\3\2\2"+
		"\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\37"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\t\2\2\2\u012f!\3\2\2\2\37%+\66"+
		"CLOUcj\u0096\u009f\u00a4\u00a7\u00b0\u00bb\u00c4\u00cc\u00ce\u00da\u00dc"+
		"\u00eb\u00ed\u00fb\u0107\u010c\u0114\u011b\u0129\u012b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}