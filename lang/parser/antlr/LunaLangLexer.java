// Generated from lang/parser/LunaLang.g4 by ANTLR 4.8

    package lang.parser.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LunaLangLexer extends Lexer {
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
		ID_DATA=46, LINE_COMMENT=47, COMMENT=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "TYPE_INT", "TYPE_CHAR", "TYPE_BOOL", "TYPE_FLOAT", 
			"BREAKLINE", "INT", "FLOAT", "CHAR", "WS", "ID", "ID_DATA", "LINE_COMMENT", 
			"COMMENT"
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
			"FLOAT", "CHAR", "WS", "ID", "ID_DATA", "LINE_COMMENT", "COMMENT"
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


	public LunaLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LunaLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u014a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3"+
		"&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\5)\u00e9\n)\3)"+
		"\3)\3)\3)\3*\3*\3*\7*\u00f2\n*\f*\16*\u00f5\13*\5*\u00f7\n*\3+\3+\7+\u00fb"+
		"\n+\f+\16+\u00fe\13+\3+\3+\6+\u0102\n+\r+\16+\u0103\3,\3,\3,\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0119\n,\3-\6-\u011c\n-\r-"+
		"\16-\u011d\3-\3-\3.\3.\7.\u0124\n.\f.\16.\u0127\13.\3/\3/\7/\u012b\n/"+
		"\f/\16/\u012e\13/\3\60\3\60\3\60\3\60\7\60\u0134\n\60\f\60\16\60\u0137"+
		"\13\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0141\n\61\f\61\16"+
		"\61\u0144\13\61\3\61\3\61\3\61\3\61\3\61\3\u0142\2\62\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61a\62\3\2\n\3\2\62\62\3\2\63;\3\2\62;\5\2\13"+
		"\f\17\17\"\"\3\2c|\6\2\62;C\\aac|\3\2C\\\4\2\f\f\17\17\2\u0157\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3"+
		"c\3\2\2\2\5h\3\2\2\2\7j\3\2\2\2\tl\3\2\2\2\13o\3\2\2\2\rq\3\2\2\2\17s"+
		"\3\2\2\2\21u\3\2\2\2\23w\3\2\2\2\25y\3\2\2\2\27|\3\2\2\2\31\u0081\3\2"+
		"\2\2\33\u0089\3\2\2\2\35\u008e\3\2\2\2\37\u0094\3\2\2\2!\u009b\3\2\2\2"+
		"#\u009d\3\2\2\2%\u009f\3\2\2\2\'\u00a1\3\2\2\2)\u00a4\3\2\2\2+\u00a7\3"+
		"\2\2\2-\u00aa\3\2\2\2/\u00ad\3\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2\2"+
		"\65\u00b3\3\2\2\2\67\u00b5\3\2\2\29\u00b7\3\2\2\2;\u00b9\3\2\2\2=\u00be"+
		"\3\2\2\2?\u00c4\3\2\2\2A\u00c9\3\2\2\2C\u00cd\3\2\2\2E\u00cf\3\2\2\2G"+
		"\u00d1\3\2\2\2I\u00d3\3\2\2\2K\u00d7\3\2\2\2M\u00dc\3\2\2\2O\u00e1\3\2"+
		"\2\2Q\u00e8\3\2\2\2S\u00f6\3\2\2\2U\u00f8\3\2\2\2W\u0118\3\2\2\2Y\u011b"+
		"\3\2\2\2[\u0121\3\2\2\2]\u0128\3\2\2\2_\u012f\3\2\2\2a\u013c\3\2\2\2c"+
		"d\7f\2\2de\7c\2\2ef\7v\2\2fg\7c\2\2g\4\3\2\2\2hi\7}\2\2i\6\3\2\2\2jk\7"+
		"\177\2\2k\b\3\2\2\2lm\7<\2\2mn\7<\2\2n\n\3\2\2\2op\7=\2\2p\f\3\2\2\2q"+
		"r\7*\2\2r\16\3\2\2\2st\7+\2\2t\20\3\2\2\2uv\7<\2\2v\22\3\2\2\2wx\7.\2"+
		"\2x\24\3\2\2\2yz\7k\2\2z{\7h\2\2{\26\3\2\2\2|}\7g\2\2}~\7n\2\2~\177\7"+
		"u\2\2\177\u0080\7g\2\2\u0080\30\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083"+
		"\7v\2\2\u0083\u0084\7g\2\2\u0084\u0085\7t\2\2\u0085\u0086\7c\2\2\u0086"+
		"\u0087\7v\2\2\u0087\u0088\7g\2\2\u0088\32\3\2\2\2\u0089\u008a\7t\2\2\u008a"+
		"\u008b\7g\2\2\u008b\u008c\7c\2\2\u008c\u008d\7f\2\2\u008d\34\3\2\2\2\u008e"+
		"\u008f\7r\2\2\u008f\u0090\7t\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2"+
		"\u0092\u0093\7v\2\2\u0093\36\3\2\2\2\u0094\u0095\7t\2\2\u0095\u0096\7"+
		"g\2\2\u0096\u0097\7v\2\2\u0097\u0098\7w\2\2\u0098\u0099\7t\2\2\u0099\u009a"+
		"\7p\2\2\u009a \3\2\2\2\u009b\u009c\7?\2\2\u009c\"\3\2\2\2\u009d\u009e"+
		"\7>\2\2\u009e$\3\2\2\2\u009f\u00a0\7@\2\2\u00a0&\3\2\2\2\u00a1\u00a2\7"+
		"]\2\2\u00a2\u00a3\7_\2\2\u00a3(\3\2\2\2\u00a4\u00a5\7(\2\2\u00a5\u00a6"+
		"\7(\2\2\u00a6*\3\2\2\2\u00a7\u00a8\7?\2\2\u00a8\u00a9\7?\2\2\u00a9,\3"+
		"\2\2\2\u00aa\u00ab\7#\2\2\u00ab\u00ac\7?\2\2\u00ac.\3\2\2\2\u00ad\u00ae"+
		"\7-\2\2\u00ae\60\3\2\2\2\u00af\u00b0\7/\2\2\u00b0\62\3\2\2\2\u00b1\u00b2"+
		"\7,\2\2\u00b2\64\3\2\2\2\u00b3\u00b4\7\61\2\2\u00b4\66\3\2\2\2\u00b5\u00b6"+
		"\7\'\2\2\u00b68\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8:\3\2\2\2\u00b9\u00ba"+
		"\7v\2\2\u00ba\u00bb\7t\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7g\2\2\u00bd"+
		"<\3\2\2\2\u00be\u00bf\7h\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7n\2\2\u00c1"+
		"\u00c2\7u\2\2\u00c2\u00c3\7g\2\2\u00c3>\3\2\2\2\u00c4\u00c5\7p\2\2\u00c5"+
		"\u00c6\7w\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7n\2\2\u00c8@\3\2\2\2\u00c9"+
		"\u00ca\7p\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7y\2\2\u00ccB\3\2\2\2\u00cd"+
		"\u00ce\7]\2\2\u00ceD\3\2\2\2\u00cf\u00d0\7_\2\2\u00d0F\3\2\2\2\u00d1\u00d2"+
		"\7\60\2\2\u00d2H\3\2\2\2\u00d3\u00d4\7K\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6"+
		"\7v\2\2\u00d6J\3\2\2\2\u00d7\u00d8\7E\2\2\u00d8\u00d9\7j\2\2\u00d9\u00da"+
		"\7c\2\2\u00da\u00db\7t\2\2\u00dbL\3\2\2\2\u00dc\u00dd\7D\2\2\u00dd\u00de"+
		"\7q\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7n\2\2\u00e0N\3\2\2\2\u00e1\u00e2"+
		"\7H\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7c\2\2\u00e5"+
		"\u00e6\7v\2\2\u00e6P\3\2\2\2\u00e7\u00e9\7\17\2\2\u00e8\u00e7\3\2\2\2"+
		"\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\f\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ed\b)\2\2\u00edR\3\2\2\2\u00ee\u00f7\t\2\2\2\u00ef\u00f3"+
		"\t\3\2\2\u00f0\u00f2\t\4\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f6\u00ee\3\2\2\2\u00f6\u00ef\3\2\2\2\u00f7T\3\2\2\2\u00f8\u00fc"+
		"\t\3\2\2\u00f9\u00fb\t\4\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2"+
		"\2\2\u00ff\u0101\7\60\2\2\u0100\u0102\t\4\2\2\u0101\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104V\3\2\2\2"+
		"\u0105\u0106\7)\2\2\u0106\u0107\13\2\2\2\u0107\u0119\7)\2\2\u0108\u0109"+
		"\7)\2\2\u0109\u010a\7^\2\2\u010a\u010b\7p\2\2\u010b\u0119\7)\2\2\u010c"+
		"\u010d\7)\2\2\u010d\u010e\7^\2\2\u010e\u010f\7t\2\2\u010f\u0119\7)\2\2"+
		"\u0110\u0111\7)\2\2\u0111\u0112\7^\2\2\u0112\u0113\7v\2\2\u0113\u0119"+
		"\7)\2\2\u0114\u0115\7)\2\2\u0115\u0116\7^\2\2\u0116\u0117\7^\2\2\u0117"+
		"\u0119\7)\2\2\u0118\u0105\3\2\2\2\u0118\u0108\3\2\2\2\u0118\u010c\3\2"+
		"\2\2\u0118\u0110\3\2\2\2\u0118\u0114\3\2\2\2\u0119X\3\2\2\2\u011a\u011c"+
		"\t\5\2\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\b-\2\2\u0120Z\3\2\2\2\u0121"+
		"\u0125\t\6\2\2\u0122\u0124\t\7\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\\\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0128\u012c\t\b\2\2\u0129\u012b\t\7\2\2\u012a\u0129\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d^\3\2\2\2"+
		"\u012e\u012c\3\2\2\2\u012f\u0130\7/\2\2\u0130\u0131\7/\2\2\u0131\u0135"+
		"\3\2\2\2\u0132\u0134\n\t\2\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0138\u0139\5Q)\2\u0139\u013a\3\2\2\2\u013a\u013b\b\60\2\2\u013b"+
		"`\3\2\2\2\u013c\u013d\7}\2\2\u013d\u013e\7/\2\2\u013e\u0142\3\2\2\2\u013f"+
		"\u0141\13\2\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0143\3"+
		"\2\2\2\u0142\u0140\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145"+
		"\u0146\7/\2\2\u0146\u0147\7\177\2\2\u0147\u0148\3\2\2\2\u0148\u0149\b"+
		"\61\2\2\u0149b\3\2\2\2\16\2\u00e8\u00f3\u00f6\u00fc\u0103\u0118\u011d"+
		"\u0125\u012c\u0135\u0142\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}