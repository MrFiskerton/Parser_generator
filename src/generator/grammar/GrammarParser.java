// Generated from /home/mrfiskerton/Documents/University-tasks/Translation/4th_lab/Parser_generator/src/Grammar.g4 by ANTLR 4.7
package generator.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NON_TERM_NAME=12, TERM_NAME=13, JAVA_CODE=14, SINGLE_QUOTE_STRING=15, 
		DOUBLE_QUOTE_STRING=16, JAVA_NAME=17, WS=18, BLOCK_COMMENT=19, COMMENT=20;
	public static final int
		RULE_source_file = 0, RULE_header = 1, RULE_members = 2, RULE_grammar_rule = 3, 
		RULE_nonterminal = 4, RULE_terminal = 5, RULE_inherited = 6, RULE_synthesized = 7, 
		RULE_argument = 8, RULE_arg_type = 9, RULE_arg_name = 10, RULE_result = 11, 
		RULE_nonterminalProd = 12, RULE_nonterminalVariant = 13, RULE_callAttrs = 14, 
		RULE_terminalProd = 15;
	public static final String[] ruleNames = {
		"source_file", "header", "members", "grammar_rule", "nonterminal", "terminal", 
		"inherited", "synthesized", "argument", "arg_type", "arg_name", "result", 
		"nonterminalProd", "nonterminalVariant", "callAttrs", "terminalProd"
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Source_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public MembersContext members() {
			return getRuleContext(MembersContext.class,0);
		}
		public List<Grammar_ruleContext> grammar_rule() {
			return getRuleContexts(Grammar_ruleContext.class);
		}
		public Grammar_ruleContext grammar_rule(int i) {
			return getRuleContext(Grammar_ruleContext.class,i);
		}
		public Source_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSource_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSource_file(this);
		}
	}

	public final Source_fileContext source_file() throws RecognitionException {
		Source_fileContext _localctx = new Source_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_source_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(32);
				header();
				}
			}

			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(35);
				members();
				}
			}

			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				grammar_rule();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NON_TERM_NAME || _la==TERM_NAME );
			setState(43);
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

	public static class HeaderContext extends ParserRuleContext {
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	 
		public HeaderContext() { }
		public void copyFrom(HeaderContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HeaderLabelContext extends HeaderContext {
		public TerminalNode JAVA_CODE() { return getToken(GrammarParser.JAVA_CODE, 0); }
		public HeaderLabelContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterHeaderLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitHeaderLabel(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			_localctx = new HeaderLabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__0);
			setState(46);
			match(JAVA_CODE);
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

	public static class MembersContext extends ParserRuleContext {
		public MembersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_members; }
	 
		public MembersContext() { }
		public void copyFrom(MembersContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MembersLabelContext extends MembersContext {
		public TerminalNode JAVA_CODE() { return getToken(GrammarParser.JAVA_CODE, 0); }
		public MembersLabelContext(MembersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMembersLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMembersLabel(this);
		}
	}

	public final MembersContext members() throws RecognitionException {
		MembersContext _localctx = new MembersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_members);
		try {
			_localctx = new MembersLabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__1);
			setState(49);
			match(JAVA_CODE);
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

	public static class Grammar_ruleContext extends ParserRuleContext {
		public NonterminalContext nonterminal() {
			return getRuleContext(NonterminalContext.class,0);
		}
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public Grammar_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammar_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterGrammar_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitGrammar_rule(this);
		}
	}

	public final Grammar_ruleContext grammar_rule() throws RecognitionException {
		Grammar_ruleContext _localctx = new Grammar_ruleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_grammar_rule);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				nonterminal();
				}
				break;
			case TERM_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				terminal();
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

	public static class NonterminalContext extends ParserRuleContext {
		public NonterminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminal; }
	 
		public NonterminalContext() { }
		public void copyFrom(NonterminalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NonTerminalLabelContext extends NonterminalContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public List<NonterminalProdContext> nonterminalProd() {
			return getRuleContexts(NonterminalProdContext.class);
		}
		public NonterminalProdContext nonterminalProd(int i) {
			return getRuleContext(NonterminalProdContext.class,i);
		}
		public InheritedContext inherited() {
			return getRuleContext(InheritedContext.class,0);
		}
		public SynthesizedContext synthesized() {
			return getRuleContext(SynthesizedContext.class,0);
		}
		public NonTerminalLabelContext(NonterminalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNonTerminalLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNonTerminalLabel(this);
		}
	}

	public final NonterminalContext nonterminal() throws RecognitionException {
		NonterminalContext _localctx = new NonterminalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nonterminal);
		int _la;
		try {
			_localctx = new NonTerminalLabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(NON_TERM_NAME);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(56);
				inherited();
				}
			}

			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(59);
				synthesized();
				}
			}

			setState(62);
			match(T__2);
			setState(63);
			nonterminalProd();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(64);
				match(T__3);
				setState(65);
				nonterminalProd();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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

	public static class TerminalContext extends ParserRuleContext {
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
	 
		public TerminalContext() { }
		public void copyFrom(TerminalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TerminalLabelContext extends TerminalContext {
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public List<TerminalProdContext> terminalProd() {
			return getRuleContexts(TerminalProdContext.class);
		}
		public TerminalProdContext terminalProd(int i) {
			return getRuleContext(TerminalProdContext.class,i);
		}
		public TerminalLabelContext(TerminalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerminalLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerminalLabel(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_terminal);
		int _la;
		try {
			_localctx = new TerminalLabelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(TERM_NAME);
			setState(74);
			match(T__2);
			setState(75);
			terminalProd();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(76);
				match(T__3);
				setState(77);
				terminalProd();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
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

	public static class InheritedContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public InheritedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inherited; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInherited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInherited(this);
		}
	}

	public final InheritedContext inherited() throws RecognitionException {
		InheritedContext _localctx = new InheritedContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inherited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__5);
			setState(86);
			argument();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(87);
				match(T__6);
				setState(88);
				argument();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__7);
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

	public static class SynthesizedContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public SynthesizedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synthesized; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSynthesized(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSynthesized(this);
		}
	}

	public final SynthesizedContext synthesized() throws RecognitionException {
		SynthesizedContext _localctx = new SynthesizedContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_synthesized);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__8);
			setState(97);
			result();
			setState(98);
			match(T__7);
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

	public static class ArgumentContext extends ParserRuleContext {
		public Arg_typeContext arg_type() {
			return getRuleContext(Arg_typeContext.class,0);
		}
		public Arg_nameContext arg_name() {
			return getRuleContext(Arg_nameContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			arg_type();
			setState(101);
			arg_name();
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

	public static class Arg_typeContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public TerminalNode JAVA_NAME() { return getToken(GrammarParser.JAVA_NAME, 0); }
		public Arg_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArg_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArg_type(this);
		}
	}

	public final Arg_typeContext arg_type() throws RecognitionException {
		Arg_typeContext _localctx = new Arg_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arg_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << JAVA_NAME))) != 0)) ) {
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

	public static class Arg_nameContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public TerminalNode JAVA_NAME() { return getToken(GrammarParser.JAVA_NAME, 0); }
		public Arg_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArg_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArg_name(this);
		}
	}

	public final Arg_nameContext arg_name() throws RecognitionException {
		Arg_nameContext _localctx = new Arg_nameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arg_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << JAVA_NAME))) != 0)) ) {
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

	public static class ResultContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public Arg_typeContext arg_type() {
			return getRuleContext(Arg_typeContext.class,0);
		}
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public TerminalNode JAVA_NAME() { return getToken(GrammarParser.JAVA_NAME, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitResult(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_result);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(NON_TERM_NAME);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(108);
					match(T__9);
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << JAVA_NAME))) != 0)) {
						{
						setState(109);
						arg_type();
						}
					}

					setState(112);
					match(T__10);
					}
				}

				}
				break;
			case TERM_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(TERM_NAME);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(116);
					match(T__9);
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << JAVA_NAME))) != 0)) {
						{
						setState(117);
						arg_type();
						}
					}

					setState(120);
					match(T__10);
					}
				}

				}
				break;
			case JAVA_NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(JAVA_NAME);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(124);
					match(T__9);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << JAVA_NAME))) != 0)) {
						{
						setState(125);
						arg_type();
						}
					}

					setState(128);
					match(T__10);
					}
				}

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

	public static class NonterminalProdContext extends ParserRuleContext {
		public List<NonterminalVariantContext> nonterminalVariant() {
			return getRuleContexts(NonterminalVariantContext.class);
		}
		public NonterminalVariantContext nonterminalVariant(int i) {
			return getRuleContext(NonterminalVariantContext.class,i);
		}
		public TerminalNode JAVA_CODE() { return getToken(GrammarParser.JAVA_CODE, 0); }
		public NonterminalProdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminalProd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNonterminalProd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNonterminalProd(this);
		}
	}

	public final NonterminalProdContext nonterminalProd() throws RecognitionException {
		NonterminalProdContext _localctx = new NonterminalProdContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_nonterminalProd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NON_TERM_NAME || _la==TERM_NAME) {
				{
				{
				setState(133);
				nonterminalVariant();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==JAVA_CODE) {
				{
				setState(139);
				match(JAVA_CODE);
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

	public static class NonterminalVariantContext extends ParserRuleContext {
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public CallAttrsContext callAttrs() {
			return getRuleContext(CallAttrsContext.class,0);
		}
		public NonterminalVariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminalVariant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNonterminalVariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNonterminalVariant(this);
		}
	}

	public final NonterminalVariantContext nonterminalVariant() throws RecognitionException {
		NonterminalVariantContext _localctx = new NonterminalVariantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_nonterminalVariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM_NAME:
				{
				{
				setState(142);
				match(NON_TERM_NAME);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(143);
					callAttrs();
					}
				}

				}
				}
				break;
			case TERM_NAME:
				{
				setState(146);
				match(TERM_NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CallAttrsContext extends ParserRuleContext {
		public List<TerminalNode> JAVA_CODE() { return getTokens(GrammarParser.JAVA_CODE); }
		public TerminalNode JAVA_CODE(int i) {
			return getToken(GrammarParser.JAVA_CODE, i);
		}
		public CallAttrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callAttrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCallAttrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCallAttrs(this);
		}
	}

	public final CallAttrsContext callAttrs() throws RecognitionException {
		CallAttrsContext _localctx = new CallAttrsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_callAttrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__5);
			setState(150);
			match(JAVA_CODE);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(151);
				match(T__6);
				setState(152);
				match(JAVA_CODE);
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			match(T__7);
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

	public static class TerminalProdContext extends ParserRuleContext {
		public List<TerminalNode> SINGLE_QUOTE_STRING() { return getTokens(GrammarParser.SINGLE_QUOTE_STRING); }
		public TerminalNode SINGLE_QUOTE_STRING(int i) {
			return getToken(GrammarParser.SINGLE_QUOTE_STRING, i);
		}
		public TerminalProdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalProd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerminalProd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerminalProd(this);
		}
	}

	public final TerminalProdContext terminalProd() throws RecognitionException {
		TerminalProdContext _localctx = new TerminalProdContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_terminalProd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				match(SINGLE_QUOTE_STRING);
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SINGLE_QUOTE_STRING );
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u00a8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\5\2"+
		"$\n\2\3\2\5\2\'\n\2\3\2\6\2*\n\2\r\2\16\2+\3\2\3\2\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\5\3\5\5\58\n\5\3\6\3\6\5\6<\n\6\3\6\5\6?\n\6\3\6\3\6\3\6\3\6\7"+
		"\6E\n\6\f\6\16\6H\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7Q\n\7\f\7\16\7T"+
		"\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\5\rq\n\r\3\r\5\rt\n"+
		"\r\3\r\3\r\3\r\5\ry\n\r\3\r\5\r|\n\r\3\r\3\r\3\r\5\r\u0081\n\r\3\r\5\r"+
		"\u0084\n\r\5\r\u0086\n\r\3\16\7\16\u0089\n\16\f\16\16\16\u008c\13\16\3"+
		"\16\5\16\u008f\n\16\3\17\3\17\5\17\u0093\n\17\3\17\5\17\u0096\n\17\3\20"+
		"\3\20\3\20\3\20\7\20\u009c\n\20\f\20\16\20\u009f\13\20\3\20\3\20\3\21"+
		"\6\21\u00a4\n\21\r\21\16\21\u00a5\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \2\3\4\2\16\17\23\23\2\u00ae\2#\3\2\2\2\4/\3\2\2\2\6\62"+
		"\3\2\2\2\b\67\3\2\2\2\n9\3\2\2\2\fK\3\2\2\2\16W\3\2\2\2\20b\3\2\2\2\22"+
		"f\3\2\2\2\24i\3\2\2\2\26k\3\2\2\2\30\u0085\3\2\2\2\32\u008a\3\2\2\2\34"+
		"\u0095\3\2\2\2\36\u0097\3\2\2\2 \u00a3\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2#"+
		"$\3\2\2\2$&\3\2\2\2%\'\5\6\4\2&%\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(*\5\b\5"+
		"\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\2\2\3.\3\3\2"+
		"\2\2/\60\7\3\2\2\60\61\7\20\2\2\61\5\3\2\2\2\62\63\7\4\2\2\63\64\7\20"+
		"\2\2\64\7\3\2\2\2\658\5\n\6\2\668\5\f\7\2\67\65\3\2\2\2\67\66\3\2\2\2"+
		"8\t\3\2\2\29;\7\16\2\2:<\5\16\b\2;:\3\2\2\2;<\3\2\2\2<>\3\2\2\2=?\5\20"+
		"\t\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\5\2\2AF\5\32\16\2BC\7\6\2\2CE\5"+
		"\32\16\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2I"+
		"J\7\7\2\2J\13\3\2\2\2KL\7\17\2\2LM\7\5\2\2MR\5 \21\2NO\7\6\2\2OQ\5 \21"+
		"\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\7\2"+
		"\2V\r\3\2\2\2WX\7\b\2\2X]\5\22\n\2YZ\7\t\2\2Z\\\5\22\n\2[Y\3\2\2\2\\_"+
		"\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\n\2\2a\17\3\2\2\2"+
		"bc\7\13\2\2cd\5\30\r\2de\7\n\2\2e\21\3\2\2\2fg\5\24\13\2gh\5\26\f\2h\23"+
		"\3\2\2\2ij\t\2\2\2j\25\3\2\2\2kl\t\2\2\2l\27\3\2\2\2ms\7\16\2\2np\7\f"+
		"\2\2oq\5\24\13\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rt\7\r\2\2sn\3\2\2\2st\3"+
		"\2\2\2t\u0086\3\2\2\2u{\7\17\2\2vx\7\f\2\2wy\5\24\13\2xw\3\2\2\2xy\3\2"+
		"\2\2yz\3\2\2\2z|\7\r\2\2{v\3\2\2\2{|\3\2\2\2|\u0086\3\2\2\2}\u0083\7\23"+
		"\2\2~\u0080\7\f\2\2\177\u0081\5\24\13\2\u0080\177\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\7\r\2\2\u0083~\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085m\3\2\2\2\u0085u\3\2\2\2\u0085"+
		"}\3\2\2\2\u0086\31\3\2\2\2\u0087\u0089\5\34\17\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d\u008f\7\20\2\2\u008e\u008d\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\33\3\2\2\2\u0090\u0092\7\16\2\2\u0091\u0093\5\36"+
		"\20\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0096\7\17\2\2\u0095\u0090\3\2\2\2\u0095\u0094\3\2\2\2\u0096\35\3\2\2"+
		"\2\u0097\u0098\7\b\2\2\u0098\u009d\7\20\2\2\u0099\u009a\7\t\2\2\u009a"+
		"\u009c\7\20\2\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3"+
		"\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a1\7\n\2\2\u00a1\37\3\2\2\2\u00a2\u00a4\7\21\2\2\u00a3\u00a2\3\2\2"+
		"\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6!"+
		"\3\2\2\2\30#&+\67;>FR]psx{\u0080\u0083\u0085\u008a\u008e\u0092\u0095\u009d"+
		"\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}