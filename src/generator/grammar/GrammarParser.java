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
		T__9=10, T__10=11, NON_TERM_NAME=12, TERM_NAME=13, MIXED_CASE=14, CODE=15, 
		STRING=16, WS=17;
	public static final int
		RULE_file = 0, RULE_header = 1, RULE_members = 2, RULE_myRule = 3, RULE_inherited = 4, 
		RULE_declAttrs = 5, RULE_callAttrs = 6, RULE_arg = 7, RULE_argType = 8, 
		RULE_argName = 9, RULE_synthesized = 10, RULE_nonterminalVariant = 11, 
		RULE_nonterminalProduction = 12, RULE_terminalProduction = 13;
	public static final String[] ruleNames = {
		"file", "header", "members", "myRule", "inherited", "declAttrs", "callAttrs", 
		"arg", "argType", "argName", "synthesized", "nonterminalVariant", "nonterminalProduction", 
		"terminalProduction"
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
	public static class FileContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public MembersContext members() {
			return getRuleContext(MembersContext.class,0);
		}
		public List<MyRuleContext> myRule() {
			return getRuleContexts(MyRuleContext.class);
		}
		public MyRuleContext myRule(int i) {
			return getRuleContext(MyRuleContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(28);
				header();
				}
			}

			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(31);
				members();
				}
			}

			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NON_TERM_NAME || _la==TERM_NAME) {
				{
				{
				setState(34);
				myRule();
				}
				}
				setState(39);
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
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
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
			setState(40);
			match(T__0);
			setState(41);
			match(CODE);
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
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
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
			setState(43);
			match(T__1);
			setState(44);
			match(CODE);
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

	public static class MyRuleContext extends ParserRuleContext {
		public MyRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myRule; }
	 
		public MyRuleContext() { }
		public void copyFrom(MyRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TerminalLabelContext extends MyRuleContext {
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public List<TerminalProductionContext> terminalProduction() {
			return getRuleContexts(TerminalProductionContext.class);
		}
		public TerminalProductionContext terminalProduction(int i) {
			return getRuleContext(TerminalProductionContext.class,i);
		}
		public TerminalLabelContext(MyRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerminalLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerminalLabel(this);
		}
	}
	public static class NonTerminalLabelContext extends MyRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public List<NonterminalProductionContext> nonterminalProduction() {
			return getRuleContexts(NonterminalProductionContext.class);
		}
		public NonterminalProductionContext nonterminalProduction(int i) {
			return getRuleContext(NonterminalProductionContext.class,i);
		}
		public InheritedContext inherited() {
			return getRuleContext(InheritedContext.class,0);
		}
		public SynthesizedContext synthesized() {
			return getRuleContext(SynthesizedContext.class,0);
		}
		public NonTerminalLabelContext(MyRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNonTerminalLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNonTerminalLabel(this);
		}
	}

	public final MyRuleContext myRule() throws RecognitionException {
		MyRuleContext _localctx = new MyRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_myRule);
		int _la;
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM_NAME:
				_localctx = new NonTerminalLabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(NON_TERM_NAME);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(47);
					inherited();
					}
				}

				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(50);
					match(T__2);
					setState(51);
					synthesized();
					setState(52);
					match(T__3);
					}
				}

				setState(56);
				match(T__4);
				setState(57);
				nonterminalProduction();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(58);
					match(T__5);
					setState(59);
					nonterminalProduction();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(T__6);
				}
				break;
			case TERM_NAME:
				_localctx = new TerminalLabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(TERM_NAME);
				setState(68);
				match(T__4);
				setState(69);
				terminalProduction();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(70);
					match(T__5);
					setState(71);
					terminalProduction();
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(77);
				match(T__6);
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

	public static class InheritedContext extends ParserRuleContext {
		public DeclAttrsContext declAttrs() {
			return getRuleContext(DeclAttrsContext.class,0);
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
		enterRule(_localctx, 8, RULE_inherited);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			declAttrs();
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

	public static class DeclAttrsContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public DeclAttrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declAttrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclAttrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclAttrs(this);
		}
	}

	public final DeclAttrsContext declAttrs() throws RecognitionException {
		DeclAttrsContext _localctx = new DeclAttrsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declAttrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__7);
			setState(84);
			arg();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(85);
				match(T__8);
				setState(86);
				arg();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
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

	public static class CallAttrsContext extends ParserRuleContext {
		public List<TerminalNode> CODE() { return getTokens(GrammarParser.CODE); }
		public TerminalNode CODE(int i) {
			return getToken(GrammarParser.CODE, i);
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
		enterRule(_localctx, 12, RULE_callAttrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__7);
			setState(95);
			match(CODE);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(96);
				match(T__8);
				setState(97);
				match(CODE);
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
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

	public static class ArgContext extends ParserRuleContext {
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public ArgNameContext argName() {
			return getRuleContext(ArgNameContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			argType();
			setState(106);
			argName();
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

	public static class ArgTypeContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public TerminalNode MIXED_CASE() { return getToken(GrammarParser.MIXED_CASE, 0); }
		public ArgTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgType(this);
		}
	}

	public final ArgTypeContext argType() throws RecognitionException {
		ArgTypeContext _localctx = new ArgTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << MIXED_CASE))) != 0)) ) {
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

	public static class ArgNameContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public TerminalNode MIXED_CASE() { return getToken(GrammarParser.MIXED_CASE, 0); }
		public ArgNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArgName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArgName(this);
		}
	}

	public final ArgNameContext argName() throws RecognitionException {
		ArgNameContext _localctx = new ArgNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << MIXED_CASE))) != 0)) ) {
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

	public static class SynthesizedContext extends ParserRuleContext {
		public TerminalNode NON_TERM_NAME() { return getToken(GrammarParser.NON_TERM_NAME, 0); }
		public ArgTypeContext argType() {
			return getRuleContext(ArgTypeContext.class,0);
		}
		public TerminalNode TERM_NAME() { return getToken(GrammarParser.TERM_NAME, 0); }
		public TerminalNode MIXED_CASE() { return getToken(GrammarParser.MIXED_CASE, 0); }
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
		enterRule(_localctx, 20, RULE_synthesized);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(NON_TERM_NAME);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(113);
					match(T__9);
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << MIXED_CASE))) != 0)) {
						{
						setState(114);
						argType();
						}
					}

					setState(117);
					match(T__10);
					}
				}

				}
				break;
			case TERM_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(TERM_NAME);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(121);
					match(T__9);
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << MIXED_CASE))) != 0)) {
						{
						setState(122);
						argType();
						}
					}

					setState(125);
					match(T__10);
					}
				}

				}
				break;
			case MIXED_CASE:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(MIXED_CASE);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(129);
					match(T__9);
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NON_TERM_NAME) | (1L << TERM_NAME) | (1L << MIXED_CASE))) != 0)) {
						{
						setState(130);
						argType();
						}
					}

					setState(133);
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
		enterRule(_localctx, 22, RULE_nonterminalVariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_TERM_NAME:
				{
				{
				setState(138);
				match(NON_TERM_NAME);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(139);
					callAttrs();
					}
				}

				}
				}
				break;
			case TERM_NAME:
				{
				setState(142);
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

	public static class NonterminalProductionContext extends ParserRuleContext {
		public List<NonterminalVariantContext> nonterminalVariant() {
			return getRuleContexts(NonterminalVariantContext.class);
		}
		public NonterminalVariantContext nonterminalVariant(int i) {
			return getRuleContext(NonterminalVariantContext.class,i);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public NonterminalProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminalProduction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNonterminalProduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNonterminalProduction(this);
		}
	}

	public final NonterminalProductionContext nonterminalProduction() throws RecognitionException {
		NonterminalProductionContext _localctx = new NonterminalProductionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_nonterminalProduction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NON_TERM_NAME || _la==TERM_NAME) {
				{
				{
				setState(145);
				nonterminalVariant();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(151);
				match(CODE);
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

	public static class TerminalProductionContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(GrammarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(GrammarParser.STRING, i);
		}
		public TerminalProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminalProduction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTerminalProduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTerminalProduction(this);
		}
	}

	public final TerminalProductionContext terminalProduction() throws RecognitionException {
		TerminalProductionContext _localctx = new TerminalProductionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_terminalProduction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				match(STRING);
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23\u00a2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\5\2 \n\2\3\2\5\2#\n\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\5\5\63\n\5"+
		"\3\5\3\5\3\5\3\5\5\59\n\5\3\5\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\5\3\5\5\5R\n\5\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\7\7Z\n\7\f\7\16\7]\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7"+
		"\be\n\b\f\b\16\bh\13\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\f\5\fv\n\f\3\f\5\fy\n\f\3\f\3\f\3\f\5\f~\n\f\3\f\5\f\u0081\n\f\3\f\3"+
		"\f\3\f\5\f\u0086\n\f\3\f\5\f\u0089\n\f\5\f\u008b\n\f\3\r\3\r\5\r\u008f"+
		"\n\r\3\r\5\r\u0092\n\r\3\16\7\16\u0095\n\16\f\16\16\16\u0098\13\16\3\16"+
		"\5\16\u009b\n\16\3\17\6\17\u009e\n\17\r\17\16\17\u009f\3\17\2\2\20\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\2\3\3\2\16\20\2\u00aa\2\37\3\2\2\2\4"+
		"*\3\2\2\2\6-\3\2\2\2\bQ\3\2\2\2\nS\3\2\2\2\fU\3\2\2\2\16`\3\2\2\2\20k"+
		"\3\2\2\2\22n\3\2\2\2\24p\3\2\2\2\26\u008a\3\2\2\2\30\u0091\3\2\2\2\32"+
		"\u0096\3\2\2\2\34\u009d\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2\37 \3\2\2\2"+
		" \"\3\2\2\2!#\5\6\4\2\"!\3\2\2\2\"#\3\2\2\2#\'\3\2\2\2$&\5\b\5\2%$\3\2"+
		"\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*+\7\3\2\2+"+
		",\7\21\2\2,\5\3\2\2\2-.\7\4\2\2./\7\21\2\2/\7\3\2\2\2\60\62\7\16\2\2\61"+
		"\63\5\n\6\2\62\61\3\2\2\2\62\63\3\2\2\2\638\3\2\2\2\64\65\7\5\2\2\65\66"+
		"\5\26\f\2\66\67\7\6\2\2\679\3\2\2\28\64\3\2\2\289\3\2\2\29:\3\2\2\2:;"+
		"\7\7\2\2;@\5\32\16\2<=\7\b\2\2=?\5\32\16\2><\3\2\2\2?B\3\2\2\2@>\3\2\2"+
		"\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7\t\2\2DR\3\2\2\2EF\7\17\2\2FG\7\7"+
		"\2\2GL\5\34\17\2HI\7\b\2\2IK\5\34\17\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2L"+
		"M\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\t\2\2PR\3\2\2\2Q\60\3\2\2\2QE\3\2\2"+
		"\2R\t\3\2\2\2ST\5\f\7\2T\13\3\2\2\2UV\7\n\2\2V[\5\20\t\2WX\7\13\2\2XZ"+
		"\5\20\t\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2"+
		"\2^_\7\6\2\2_\r\3\2\2\2`a\7\n\2\2af\7\21\2\2bc\7\13\2\2ce\7\21\2\2db\3"+
		"\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\6\2\2j\17"+
		"\3\2\2\2kl\5\22\n\2lm\5\24\13\2m\21\3\2\2\2no\t\2\2\2o\23\3\2\2\2pq\t"+
		"\2\2\2q\25\3\2\2\2rx\7\16\2\2su\7\f\2\2tv\5\22\n\2ut\3\2\2\2uv\3\2\2\2"+
		"vw\3\2\2\2wy\7\r\2\2xs\3\2\2\2xy\3\2\2\2y\u008b\3\2\2\2z\u0080\7\17\2"+
		"\2{}\7\f\2\2|~\5\22\n\2}|\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0081\7\r"+
		"\2\2\u0080{\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u008b\3\2\2\2\u0082\u0088"+
		"\7\20\2\2\u0083\u0085\7\f\2\2\u0084\u0086\5\22\n\2\u0085\u0084\3\2\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\7\r\2\2\u0088\u0083"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008ar\3\2\2\2\u008a"+
		"z\3\2\2\2\u008a\u0082\3\2\2\2\u008b\27\3\2\2\2\u008c\u008e\7\16\2\2\u008d"+
		"\u008f\5\16\b\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0092\3"+
		"\2\2\2\u0090\u0092\7\17\2\2\u0091\u008c\3\2\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\31\3\2\2\2\u0093\u0095\5\30\r\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0099\u009b\7\21\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2"+
		"\u009b\33\3\2\2\2\u009c\u009e\7\22\2\2\u009d\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\35\3\2\2\2\30\37"+
		"\"\'\628@LQ[fux}\u0080\u0085\u0088\u008a\u008e\u0091\u0096\u009a\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}