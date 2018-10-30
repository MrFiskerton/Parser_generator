// Generated from /home/mrfiskerton/Documents/University-tasks/Translation/4th_lab/Parser_generator/src/Grammar.g4 by ANTLR 4.7
package generator.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NON_TERM_NAME=12, TERM_NAME=13, JAVA_CODE=14, SINGLE_QUOTE_STRING=15, 
		JAVA_NAME=16, WS=17, BLOCK_COMMENT=18, COMMENT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NON_TERM_NAME", "TERM_NAME", "JAVA_CODE", "SINGLE_QUOTE_STRING", 
		"JAVA_NAME", "CHAR", "LETTER", "UPPERCASE_LETTER", "LOWERCASE_LETTER", 
		"UNDERSCORE", "DIGIT", "WS", "BLOCK_COMMENT", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@header'", "'@members'", "':'", "'|'", "';'", "'['", "','", "']'", 
		"'[returns '", "'<'", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NON_TERM_NAME", "TERM_NAME", "JAVA_CODE", "SINGLE_QUOTE_STRING", "JAVA_NAME", 
		"WS", "BLOCK_COMMENT", "COMMENT"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u00c1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7\rc\n\r\f"+
		"\r\16\rf\13\r\3\16\3\16\7\16j\n\16\f\16\16\16m\13\16\3\17\3\17\6\17q\n"+
		"\17\r\17\16\17r\3\17\5\17v\n\17\7\17x\n\17\f\17\16\17{\13\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\7\20\u0083\n\20\f\20\16\20\u0086\13\20\3\20\3\20"+
		"\3\21\3\21\7\21\u008c\n\21\f\21\16\21\u008f\13\21\3\22\3\22\3\22\5\22"+
		"\u0094\n\22\3\23\3\23\5\23\u0098\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\6\30\u00a3\n\30\r\30\16\30\u00a4\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\7\31\u00ad\n\31\f\31\16\31\u00b0\13\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\7\32\u00bb\n\32\f\32\16\32\u00be\13\32\3\32\3\32"+
		"\3\u00ae\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\2%\2\'\2)\2+\2-\2/\23\61\24\63\25\3\2\n\4\2}}"+
		"\177\177\3\2))\3\2C\\\3\2c|\3\2aa\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17"+
		"\17\2\u00c8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5=\3\2\2\2\7F\3\2"+
		"\2\2\tH\3\2\2\2\13J\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21P\3\2\2\2\23R\3\2"+
		"\2\2\25\\\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33g\3\2\2\2\35n\3\2\2\2\37~"+
		"\3\2\2\2!\u0089\3\2\2\2#\u0093\3\2\2\2%\u0097\3\2\2\2\'\u0099\3\2\2\2"+
		")\u009b\3\2\2\2+\u009d\3\2\2\2-\u009f\3\2\2\2/\u00a2\3\2\2\2\61\u00a8"+
		"\3\2\2\2\63\u00b6\3\2\2\2\65\66\7B\2\2\66\67\7j\2\2\678\7g\2\289\7c\2"+
		"\29:\7f\2\2:;\7g\2\2;<\7t\2\2<\4\3\2\2\2=>\7B\2\2>?\7o\2\2?@\7g\2\2@A"+
		"\7o\2\2AB\7d\2\2BC\7g\2\2CD\7t\2\2DE\7u\2\2E\6\3\2\2\2FG\7<\2\2G\b\3\2"+
		"\2\2HI\7~\2\2I\n\3\2\2\2JK\7=\2\2K\f\3\2\2\2LM\7]\2\2M\16\3\2\2\2NO\7"+
		".\2\2O\20\3\2\2\2PQ\7_\2\2Q\22\3\2\2\2RS\7]\2\2ST\7t\2\2TU\7g\2\2UV\7"+
		"v\2\2VW\7w\2\2WX\7t\2\2XY\7p\2\2YZ\7u\2\2Z[\7\"\2\2[\24\3\2\2\2\\]\7>"+
		"\2\2]\26\3\2\2\2^_\7@\2\2_\30\3\2\2\2`d\5)\25\2ac\5#\22\2ba\3\2\2\2cf"+
		"\3\2\2\2db\3\2\2\2de\3\2\2\2e\32\3\2\2\2fd\3\2\2\2gk\5\'\24\2hj\5#\22"+
		"\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\34\3\2\2\2mk\3\2\2\2ny\7}"+
		"\2\2oq\n\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\5\35"+
		"\17\2ut\3\2\2\2uv\3\2\2\2vx\3\2\2\2wp\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3"+
		"\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7\177\2\2}\36\3\2\2\2~\u0084\7)\2\2\177\u0083"+
		"\n\3\2\2\u0080\u0081\7^\2\2\u0081\u0083\7)\2\2\u0082\177\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7)\2\2\u0088"+
		" \3\2\2\2\u0089\u008d\5%\23\2\u008a\u008c\5#\22\2\u008b\u008a\3\2\2\2"+
		"\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\"\3"+
		"\2\2\2\u008f\u008d\3\2\2\2\u0090\u0094\5-\27\2\u0091\u0094\5%\23\2\u0092"+
		"\u0094\5+\26\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2"+
		"\2\2\u0094$\3\2\2\2\u0095\u0098\5\'\24\2\u0096\u0098\5)\25\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0096\3\2\2\2\u0098&\3\2\2\2\u0099\u009a\t\4\2\2\u009a"+
		"(\3\2\2\2\u009b\u009c\t\5\2\2\u009c*\3\2\2\2\u009d\u009e\t\6\2\2\u009e"+
		",\3\2\2\2\u009f\u00a0\t\7\2\2\u00a0.\3\2\2\2\u00a1\u00a3\t\b\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\30\2\2\u00a7\60\3\2\2\2\u00a8\u00a9"+
		"\7\61\2\2\u00a9\u00aa\7,\2\2\u00aa\u00ae\3\2\2\2\u00ab\u00ad\13\2\2\2"+
		"\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00af\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\7,\2\2\u00b2"+
		"\u00b3\7\61\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\31\2\2\u00b5\62\3\2"+
		"\2\2\u00b6\u00b7\7\61\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00bc\3\2\2\2\u00b9"+
		"\u00bb\n\t\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c0\b\32\2\2\u00c0\64\3\2\2\2\20\2dkruy\u0082\u0084\u008d\u0093\u0097"+
		"\u00a4\u00ae\u00bc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}