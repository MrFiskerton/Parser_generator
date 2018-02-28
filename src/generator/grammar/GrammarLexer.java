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
		T__9=10, T__10=11, NON_TERM_NAME=12, TERM_NAME=13, MIXED_CASE=14, CODE=15, 
		STRING=16, WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NON_TERM_NAME", "TERM_NAME", "MIXED_CASE", "CODE", "STRING", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@header'", "'@members'", "'[returns '", "']'", "':'", "'|'", "';'", 
		"'['", "','", "'<'", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NON_TERM_NAME", "TERM_NAME", "MIXED_CASE", "CODE", "STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0087\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7\rS\n\r\f\r\16\rV\13"+
		"\r\3\16\3\16\7\16Z\n\16\f\16\16\16]\13\16\3\17\3\17\7\17a\n\17\f\17\16"+
		"\17d\13\17\3\20\3\20\6\20h\n\20\r\20\16\20i\3\20\5\20m\n\20\7\20o\n\20"+
		"\f\20\16\20r\13\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21z\n\21\f\21\16\21"+
		"}\13\21\3\21\3\21\3\22\6\22\u0082\n\22\r\22\16\22\u0083\3\22\3\22\2\2"+
		"\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23\3\2\n\3\2c|\6\2\62;C\\aac|\3\2C\\\5\2\62;C\\aa\4\2C"+
		"\\c|\4\2}}\177\177\3\2))\5\2\13\f\17\17\"\"\2\u008f\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5-\3"+
		"\2\2\2\7\66\3\2\2\2\t@\3\2\2\2\13B\3\2\2\2\rD\3\2\2\2\17F\3\2\2\2\21H"+
		"\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27N\3\2\2\2\31P\3\2\2\2\33W\3\2\2\2\35"+
		"^\3\2\2\2\37e\3\2\2\2!u\3\2\2\2#\u0081\3\2\2\2%&\7B\2\2&\'\7j\2\2\'(\7"+
		"g\2\2()\7c\2\2)*\7f\2\2*+\7g\2\2+,\7t\2\2,\4\3\2\2\2-.\7B\2\2./\7o\2\2"+
		"/\60\7g\2\2\60\61\7o\2\2\61\62\7d\2\2\62\63\7g\2\2\63\64\7t\2\2\64\65"+
		"\7u\2\2\65\6\3\2\2\2\66\67\7]\2\2\678\7t\2\289\7g\2\29:\7v\2\2:;\7w\2"+
		"\2;<\7t\2\2<=\7p\2\2=>\7u\2\2>?\7\"\2\2?\b\3\2\2\2@A\7_\2\2A\n\3\2\2\2"+
		"BC\7<\2\2C\f\3\2\2\2DE\7~\2\2E\16\3\2\2\2FG\7=\2\2G\20\3\2\2\2HI\7]\2"+
		"\2I\22\3\2\2\2JK\7.\2\2K\24\3\2\2\2LM\7>\2\2M\26\3\2\2\2NO\7@\2\2O\30"+
		"\3\2\2\2PT\t\2\2\2QS\t\3\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U"+
		"\32\3\2\2\2VT\3\2\2\2W[\t\4\2\2XZ\t\5\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2"+
		"\2[\\\3\2\2\2\\\34\3\2\2\2][\3\2\2\2^b\t\6\2\2_a\t\3\2\2`_\3\2\2\2ad\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2c\36\3\2\2\2db\3\2\2\2ep\7}\2\2fh\n\7\2\2gf"+
		"\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\5\37\20\2lk\3\2\2\2"+
		"lm\3\2\2\2mo\3\2\2\2ng\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2"+
		"rp\3\2\2\2st\7\177\2\2t \3\2\2\2u{\7)\2\2vz\n\b\2\2wx\7^\2\2xz\7)\2\2"+
		"yv\3\2\2\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2"+
		"~\177\7)\2\2\177\"\3\2\2\2\u0080\u0082\t\t\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0086\b\22\2\2\u0086$\3\2\2\2\f\2T[bilpy{\u0083\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}