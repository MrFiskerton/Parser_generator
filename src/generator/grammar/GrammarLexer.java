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
		DOUBLE_QUOTE_STRING=16, JAVA_NAME=17, WS=18, BLOCK_COMMENT=19, COMMENT=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NON_TERM_NAME", "TERM_NAME", "JAVA_CODE", "SINGLE_QUOTE_STRING", 
		"DOUBLE_QUOTE_STRING", "JAVA_NAME", "CHAR", "LETTER", "UPPERCASE_LETTER", 
		"LOWERCASE_LETTER", "UNDERSCORE", "DIGIT", "WS", "BLOCK_COMMENT", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@header'", "'@members'", "':'", "'|'", "';'", "'['", "','", "']'", 
		"'[returns '", "'<'", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NON_TERM_NAME", "TERM_NAME", "JAVA_CODE", "SINGLE_QUOTE_STRING", "DOUBLE_QUOTE_STRING", 
		"JAVA_NAME", "WS", "BLOCK_COMMENT", "COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00cd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7"+
		"\re\n\r\f\r\16\rh\13\r\3\16\3\16\7\16l\n\16\f\16\16\16o\13\16\3\17\3\17"+
		"\6\17s\n\17\r\17\16\17t\3\17\3\17\7\17y\n\17\f\17\16\17|\13\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\7\20\u0084\n\20\f\20\16\20\u0087\13\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\7\21\u008f\n\21\f\21\16\21\u0092\13\21\3\21\3"+
		"\21\3\22\3\22\7\22\u0098\n\22\f\22\16\22\u009b\13\22\3\23\3\23\3\23\5"+
		"\23\u00a0\n\23\3\24\3\24\5\24\u00a4\n\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\6\31\u00af\n\31\r\31\16\31\u00b0\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\7\32\u00b9\n\32\f\32\16\32\u00bc\13\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\7\33\u00c7\n\33\f\33\16\33\u00ca\13\33\3\33\3"+
		"\33\3\u00ba\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\2\'\2)\2+\2-\2/\2\61\24\63\25\65\26\3\2"+
		"\13\5\2$$}}\177\177\3\2))\3\2$$\3\2C\\\3\2c|\3\2aa\3\2\62;\5\2\13\f\17"+
		"\17\"\"\4\2\f\f\17\17\2\u00d7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\3\67\3\2\2\2\5?\3\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13L\3\2\2\2\rN\3\2\2"+
		"\2\17P\3\2\2\2\21R\3\2\2\2\23T\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2\31b\3\2"+
		"\2\2\33i\3\2\2\2\35p\3\2\2\2\37\177\3\2\2\2!\u008a\3\2\2\2#\u0095\3\2"+
		"\2\2%\u009f\3\2\2\2\'\u00a3\3\2\2\2)\u00a5\3\2\2\2+\u00a7\3\2\2\2-\u00a9"+
		"\3\2\2\2/\u00ab\3\2\2\2\61\u00ae\3\2\2\2\63\u00b4\3\2\2\2\65\u00c2\3\2"+
		"\2\2\678\7B\2\289\7j\2\29:\7g\2\2:;\7c\2\2;<\7f\2\2<=\7g\2\2=>\7t\2\2"+
		">\4\3\2\2\2?@\7B\2\2@A\7o\2\2AB\7g\2\2BC\7o\2\2CD\7d\2\2DE\7g\2\2EF\7"+
		"t\2\2FG\7u\2\2G\6\3\2\2\2HI\7<\2\2I\b\3\2\2\2JK\7~\2\2K\n\3\2\2\2LM\7"+
		"=\2\2M\f\3\2\2\2NO\7]\2\2O\16\3\2\2\2PQ\7.\2\2Q\20\3\2\2\2RS\7_\2\2S\22"+
		"\3\2\2\2TU\7]\2\2UV\7t\2\2VW\7g\2\2WX\7v\2\2XY\7w\2\2YZ\7t\2\2Z[\7p\2"+
		"\2[\\\7u\2\2\\]\7\"\2\2]\24\3\2\2\2^_\7>\2\2_\26\3\2\2\2`a\7@\2\2a\30"+
		"\3\2\2\2bf\5+\26\2ce\5%\23\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g"+
		"\32\3\2\2\2hf\3\2\2\2im\5)\25\2jl\5%\23\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2"+
		"\2mn\3\2\2\2n\34\3\2\2\2om\3\2\2\2pz\7}\2\2qs\n\2\2\2rq\3\2\2\2st\3\2"+
		"\2\2tr\3\2\2\2tu\3\2\2\2uy\3\2\2\2vy\5!\21\2wy\5\35\17\2xr\3\2\2\2xv\3"+
		"\2\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7"+
		"\177\2\2~\36\3\2\2\2\177\u0085\7)\2\2\u0080\u0084\n\3\2\2\u0081\u0082"+
		"\7^\2\2\u0082\u0084\7)\2\2\u0083\u0080\3\2\2\2\u0083\u0081\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7)\2\2\u0089 \3\2\2\2\u008a\u0090"+
		"\7$\2\2\u008b\u008f\n\4\2\2\u008c\u008d\7^\2\2\u008d\u008f\7$\2\2\u008e"+
		"\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0094\7$\2\2\u0094\"\3\2\2\2\u0095\u0099\5\'\24\2\u0096\u0098\5%\23\2"+
		"\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a$\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u00a0\5/\30\2\u009d"+
		"\u00a0\5\'\24\2\u009e\u00a0\5-\27\2\u009f\u009c\3\2\2\2\u009f\u009d\3"+
		"\2\2\2\u009f\u009e\3\2\2\2\u00a0&\3\2\2\2\u00a1\u00a4\5)\25\2\u00a2\u00a4"+
		"\5+\26\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4(\3\2\2\2\u00a5"+
		"\u00a6\t\5\2\2\u00a6*\3\2\2\2\u00a7\u00a8\t\6\2\2\u00a8,\3\2\2\2\u00a9"+
		"\u00aa\t\7\2\2\u00aa.\3\2\2\2\u00ab\u00ac\t\b\2\2\u00ac\60\3\2\2\2\u00ad"+
		"\u00af\t\t\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\31\2\2\u00b3"+
		"\62\3\2\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b6\7,\2\2\u00b6\u00ba\3\2\2"+
		"\2\u00b7\u00b9\13\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bd\u00be\7,\2\2\u00be\u00bf\7\61\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\b\32\2\2\u00c1\64\3\2\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c4\7\61"+
		"\2\2\u00c4\u00c8\3\2\2\2\u00c5\u00c7\n\n\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\b\33\2\2\u00cc\66\3\2\2\2\22\2fm"+
		"txz\u0083\u0085\u008e\u0090\u0099\u009f\u00a3\u00b0\u00ba\u00c8\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}