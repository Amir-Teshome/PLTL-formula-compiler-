// Generated from PolicyGrammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PolicyGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, CTX=4, DOM=5, PREVIOUS=6, SINCE=7, EPAST=8, GPAST=9, 
		ELEMENT=10, EQU=11, NOT=12, AND=13, OR=14, EXIST=15, ALL=16, IN=17, FLOW=18, 
		IFLOW=19, ID=20, INT=21, NEWLINE=22, WS=23;
	public static final int
		RULE_stat = 0, RULE_policy = 1, RULE_assignment = 2, RULE_formula = 3, 
		RULE_atom = 4, RULE_termctx = 5, RULE_termdom = 6, RULE_var = 7;
	public static final String[] ruleNames = {
		"stat", "policy", "assignment", "formula", "atom", "termctx", "termdom", 
		"var"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", null, "'users'", null, null, null, null, null, 
		"'EQ'", "'NOT'", "'AND'", "'OR'", "'EXIST'", "'ALL'", "'IN'", null, "'>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "CTX", "DOM", "PREVIOUS", "SINCE", "EPAST", "GPAST", 
		"ELEMENT", "EQU", "NOT", "AND", "OR", "EXIST", "ALL", "IN", "FLOW", "IFLOW", 
		"ID", "INT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "PolicyGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PolicyGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatContext extends ParserRuleContext {
		public List<PolicyContext> policy() {
			return getRuleContexts(PolicyContext.class);
		}
		public PolicyContext policy(int i) {
			return getRuleContext(PolicyContext.class,i);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				policy();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==NEWLINE );
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

	public static class PolicyContext extends ParserRuleContext {
		public PolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policy; }
	 
		public PolicyContext() { }
		public void copyFrom(PolicyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintDecision_methodContext extends PolicyContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PolicyGrammarParser.NEWLINE, 0); }
		public PrintDecision_methodContext(PolicyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterPrintDecision_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitPrintDecision_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitPrintDecision_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Blank_methodContext extends PolicyContext {
		public TerminalNode NEWLINE() { return getToken(PolicyGrammarParser.NEWLINE, 0); }
		public Blank_methodContext(PolicyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterBlank_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitBlank_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitBlank_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolicyContext policy() throws RecognitionException {
		PolicyContext _localctx = new PolicyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_policy);
		try {
			setState(26);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new PrintDecision_methodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				assignment();
				setState(23);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(22);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case NEWLINE:
				_localctx = new Blank_methodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(NEWLINE);
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Assign_methodContext extends AssignmentContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Assign_methodContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterAssign_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitAssign_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitAssign_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			_localctx = new Assign_methodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			var();
			setState(29);
			match(T__0);
			setState(30);
			formula(0);
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

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Not_methodContext extends FormulaContext {
		public TerminalNode NOT() { return getToken(PolicyGrammarParser.NOT, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Not_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterNot_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitNot_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitNot_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Parens_methodContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Parens_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterParens_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitParens_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitParens_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class S_methodContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode SINCE() { return getToken(PolicyGrammarParser.SINCE, 0); }
		public S_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterS_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitS_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitS_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atom_methodContext extends FormulaContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Atom_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterAtom_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitAtom_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitAtom_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Y_methodContext extends FormulaContext {
		public TerminalNode PREVIOUS() { return getToken(PolicyGrammarParser.PREVIOUS, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Y_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterY_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitY_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitY_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exist_methodContext extends FormulaContext {
		public TerminalNode EXIST() { return getToken(PolicyGrammarParser.EXIST, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode IN() { return getToken(PolicyGrammarParser.IN, 0); }
		public TermdomContext termdom() {
			return getRuleContext(TermdomContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Exist_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterExist_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitExist_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitExist_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class And_methodContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode AND() { return getToken(PolicyGrammarParser.AND, 0); }
		public And_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterAnd_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitAnd_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitAnd_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class H_methodContext extends FormulaContext {
		public TerminalNode GPAST() { return getToken(PolicyGrammarParser.GPAST, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public H_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterH_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitH_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitH_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class P_methodContext extends FormulaContext {
		public TerminalNode EPAST() { return getToken(PolicyGrammarParser.EPAST, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public P_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterP_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitP_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitP_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Or_methodContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode OR() { return getToken(PolicyGrammarParser.OR, 0); }
		public Or_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterOr_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitOr_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitOr_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class All_methodContext extends FormulaContext {
		public TerminalNode ALL() { return getToken(PolicyGrammarParser.ALL, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode IN() { return getToken(PolicyGrammarParser.IN, 0); }
		public TermdomContext termdom() {
			return getRuleContext(TermdomContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public All_methodContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterAll_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitAll_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitAll_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			switch (_input.LA(1)) {
			case NOT:
				{
				_localctx = new Not_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(33);
				match(NOT);
				setState(34);
				formula(6);
				}
				break;
			case EXIST:
				{
				_localctx = new Exist_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(EXIST);
				setState(36);
				var();
				setState(37);
				match(IN);
				setState(38);
				termdom();
				setState(39);
				formula(3);
				}
				break;
			case ALL:
				{
				_localctx = new All_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(ALL);
				setState(42);
				var();
				setState(43);
				match(IN);
				setState(44);
				termdom();
				setState(45);
				formula(2);
				}
				break;
			case T__1:
				{
				_localctx = new Parens_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(T__1);
				setState(48);
				formula(0);
				setState(49);
				match(T__2);
				}
				break;
			case PREVIOUS:
				{
				_localctx = new Y_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(PREVIOUS);
				setState(52);
				match(T__1);
				setState(53);
				formula(0);
				setState(54);
				match(T__2);
				}
				break;
			case EPAST:
				{
				_localctx = new P_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(EPAST);
				setState(57);
				match(T__1);
				setState(58);
				formula(0);
				setState(59);
				match(T__2);
				}
				break;
			case GPAST:
				{
				_localctx = new H_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				match(GPAST);
				setState(62);
				match(T__1);
				setState(63);
				formula(0);
				setState(64);
				match(T__2);
				}
				break;
			case CTX:
			case DOM:
			case ID:
				{
				_localctx = new Atom_methodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(78);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new S_methodContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(69);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(70);
						match(SINCE);
						setState(71);
						formula(10);
						}
						break;
					case 2:
						{
						_localctx = new And_methodContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(72);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(73);
						match(AND);
						setState(74);
						formula(6);
						}
						break;
					case 3:
						{
						_localctx = new Or_methodContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(75);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(76);
						match(OR);
						setState(77);
						formula(5);
						}
						break;
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Elem_methodContext extends AtomContext {
		public TerminalNode ELEMENT() { return getToken(PolicyGrammarParser.ELEMENT, 0); }
		public List<TermdomContext> termdom() {
			return getRuleContexts(TermdomContext.class);
		}
		public TermdomContext termdom(int i) {
			return getRuleContext(TermdomContext.class,i);
		}
		public TermctxContext termctx() {
			return getRuleContext(TermctxContext.class,0);
		}
		public Elem_methodContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterElem_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitElem_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitElem_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Equ_dom_methodContext extends AtomContext {
		public TerminalNode EQU() { return getToken(PolicyGrammarParser.EQU, 0); }
		public List<TermdomContext> termdom() {
			return getRuleContexts(TermdomContext.class);
		}
		public TermdomContext termdom(int i) {
			return getRuleContext(TermdomContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public Equ_dom_methodContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterEqu_dom_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitEqu_dom_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitEqu_dom_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Flow_methodContext extends AtomContext {
		public TerminalNode FLOW() { return getToken(PolicyGrammarParser.FLOW, 0); }
		public List<TermctxContext> termctx() {
			return getRuleContexts(TermctxContext.class);
		}
		public TermctxContext termctx(int i) {
			return getRuleContext(TermctxContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public Flow_methodContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterFlow_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitFlow_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitFlow_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Equ_ctx_methodContext extends AtomContext {
		public TerminalNode EQU() { return getToken(PolicyGrammarParser.EQU, 0); }
		public List<TermctxContext> termctx() {
			return getRuleContexts(TermctxContext.class);
		}
		public TermctxContext termctx(int i) {
			return getRuleContext(TermctxContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public Equ_ctx_methodContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterEqu_ctx_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitEqu_ctx_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitEqu_ctx_method(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Iflow_methodContext extends AtomContext {
		public TerminalNode IFLOW() { return getToken(PolicyGrammarParser.IFLOW, 0); }
		public List<TermctxContext> termctx() {
			return getRuleContexts(TermctxContext.class);
		}
		public TermctxContext termctx(int i) {
			return getRuleContext(TermctxContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public Iflow_methodContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterIflow_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitIflow_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitIflow_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atom);
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Flow_methodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				switch (_input.LA(1)) {
				case CTX:
					{
					setState(83);
					termctx();
					}
					break;
				case ID:
					{
					setState(84);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(87);
				match(FLOW);
				setState(90);
				switch (_input.LA(1)) {
				case CTX:
					{
					setState(88);
					termctx();
					}
					break;
				case ID:
					{
					setState(89);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new Iflow_methodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				switch (_input.LA(1)) {
				case CTX:
					{
					setState(92);
					termctx();
					}
					break;
				case ID:
					{
					setState(93);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(96);
				match(IFLOW);
				setState(99);
				switch (_input.LA(1)) {
				case CTX:
					{
					setState(97);
					termctx();
					}
					break;
				case ID:
					{
					setState(98);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new Elem_methodContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				switch (_input.LA(1)) {
				case DOM:
					{
					setState(101);
					termdom();
					}
					break;
				case CTX:
					{
					setState(102);
					termctx();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(105);
				match(ELEMENT);
				setState(106);
				termdom();
				}
				break;
			case 4:
				_localctx = new Equ_ctx_methodContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				switch (_input.LA(1)) {
				case CTX:
					{
					setState(108);
					termctx();
					}
					break;
				case ID:
					{
					setState(109);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(112);
				match(EQU);
				setState(115);
				switch (_input.LA(1)) {
				case CTX:
					{
					setState(113);
					termctx();
					}
					break;
				case ID:
					{
					setState(114);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				_localctx = new Equ_dom_methodContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(119);
				switch (_input.LA(1)) {
				case DOM:
					{
					setState(117);
					termdom();
					}
					break;
				case ID:
					{
					setState(118);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(121);
				match(EQU);
				setState(124);
				switch (_input.LA(1)) {
				case DOM:
					{
					setState(122);
					termdom();
					}
					break;
				case ID:
					{
					setState(123);
					var();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class TermctxContext extends ParserRuleContext {
		public TermctxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termctx; }
	 
		public TermctxContext() { }
		public void copyFrom(TermctxContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Ctx_methodContext extends TermctxContext {
		public TerminalNode CTX() { return getToken(PolicyGrammarParser.CTX, 0); }
		public Ctx_methodContext(TermctxContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterCtx_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitCtx_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitCtx_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermctxContext termctx() throws RecognitionException {
		TermctxContext _localctx = new TermctxContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_termctx);
		try {
			_localctx = new Ctx_methodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(CTX);
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

	public static class TermdomContext extends ParserRuleContext {
		public TermdomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termdom; }
	 
		public TermdomContext() { }
		public void copyFrom(TermdomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Dom_methodContext extends TermdomContext {
		public TerminalNode DOM() { return getToken(PolicyGrammarParser.DOM, 0); }
		public Dom_methodContext(TermdomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterDom_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitDom_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitDom_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermdomContext termdom() throws RecognitionException {
		TermdomContext _localctx = new TermdomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_termdom);
		try {
			_localctx = new Dom_methodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(DOM);
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

	public static class VarContext extends ParserRuleContext {
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	 
		public VarContext() { }
		public void copyFrom(VarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Var_methodContext extends VarContext {
		public TerminalNode ID() { return getToken(PolicyGrammarParser.ID, 0); }
		public Var_methodContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).enterVar_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyGrammarListener ) ((PolicyGrammarListener)listener).exitVar_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PolicyGrammarVisitor ) return ((PolicyGrammarVisitor<? extends T>)visitor).visitVar_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var);
		try {
			_localctx = new Var_methodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(ID);
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
		case 3:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u0089\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n"+
		"\2\r\2\16\2\25\3\3\3\3\5\3\32\n\3\3\3\5\3\35\n\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5F"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5Q\n\5\f\5\16\5T\13\5\3\6\3"+
		"\6\5\6X\n\6\3\6\3\6\3\6\5\6]\n\6\3\6\3\6\5\6a\n\6\3\6\3\6\3\6\5\6f\n\6"+
		"\3\6\3\6\5\6j\n\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\6\3\6\3\6\5\6v\n\6\3"+
		"\6\3\6\5\6z\n\6\3\6\3\6\3\6\5\6\177\n\6\5\6\u0081\n\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\2\3\b\n\2\4\6\b\n\f\16\20\2\2\u009a\2\23\3\2\2\2\4\34\3\2"+
		"\2\2\6\36\3\2\2\2\bE\3\2\2\2\n\u0080\3\2\2\2\f\u0082\3\2\2\2\16\u0084"+
		"\3\2\2\2\20\u0086\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24\25\3\2\2\2\25"+
		"\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\31\5\6\4\2\30\32\7\30\2\2\31"+
		"\30\3\2\2\2\31\32\3\2\2\2\32\35\3\2\2\2\33\35\7\30\2\2\34\27\3\2\2\2\34"+
		"\33\3\2\2\2\35\5\3\2\2\2\36\37\5\20\t\2\37 \7\3\2\2 !\5\b\5\2!\7\3\2\2"+
		"\2\"#\b\5\1\2#$\7\16\2\2$F\5\b\5\b%&\7\21\2\2&\'\5\20\t\2\'(\7\23\2\2"+
		"()\5\16\b\2)*\5\b\5\5*F\3\2\2\2+,\7\22\2\2,-\5\20\t\2-.\7\23\2\2./\5\16"+
		"\b\2/\60\5\b\5\4\60F\3\2\2\2\61\62\7\4\2\2\62\63\5\b\5\2\63\64\7\5\2\2"+
		"\64F\3\2\2\2\65\66\7\b\2\2\66\67\7\4\2\2\678\5\b\5\289\7\5\2\29F\3\2\2"+
		"\2:;\7\n\2\2;<\7\4\2\2<=\5\b\5\2=>\7\5\2\2>F\3\2\2\2?@\7\13\2\2@A\7\4"+
		"\2\2AB\5\b\5\2BC\7\5\2\2CF\3\2\2\2DF\5\n\6\2E\"\3\2\2\2E%\3\2\2\2E+\3"+
		"\2\2\2E\61\3\2\2\2E\65\3\2\2\2E:\3\2\2\2E?\3\2\2\2ED\3\2\2\2FR\3\2\2\2"+
		"GH\f\13\2\2HI\7\t\2\2IQ\5\b\5\fJK\f\7\2\2KL\7\17\2\2LQ\5\b\5\bMN\f\6\2"+
		"\2NO\7\20\2\2OQ\5\b\5\7PG\3\2\2\2PJ\3\2\2\2PM\3\2\2\2QT\3\2\2\2RP\3\2"+
		"\2\2RS\3\2\2\2S\t\3\2\2\2TR\3\2\2\2UX\5\f\7\2VX\5\20\t\2WU\3\2\2\2WV\3"+
		"\2\2\2XY\3\2\2\2Y\\\7\24\2\2Z]\5\f\7\2[]\5\20\t\2\\Z\3\2\2\2\\[\3\2\2"+
		"\2]\u0081\3\2\2\2^a\5\f\7\2_a\5\20\t\2`^\3\2\2\2`_\3\2\2\2ab\3\2\2\2b"+
		"e\7\25\2\2cf\5\f\7\2df\5\20\t\2ec\3\2\2\2ed\3\2\2\2f\u0081\3\2\2\2gj\5"+
		"\16\b\2hj\5\f\7\2ig\3\2\2\2ih\3\2\2\2jk\3\2\2\2kl\7\f\2\2lm\5\16\b\2m"+
		"\u0081\3\2\2\2nq\5\f\7\2oq\5\20\t\2pn\3\2\2\2po\3\2\2\2qr\3\2\2\2ru\7"+
		"\r\2\2sv\5\f\7\2tv\5\20\t\2us\3\2\2\2ut\3\2\2\2v\u0081\3\2\2\2wz\5\16"+
		"\b\2xz\5\20\t\2yw\3\2\2\2yx\3\2\2\2z{\3\2\2\2{~\7\r\2\2|\177\5\16\b\2"+
		"}\177\5\20\t\2~|\3\2\2\2~}\3\2\2\2\177\u0081\3\2\2\2\u0080W\3\2\2\2\u0080"+
		"`\3\2\2\2\u0080i\3\2\2\2\u0080p\3\2\2\2\u0080y\3\2\2\2\u0081\13\3\2\2"+
		"\2\u0082\u0083\7\6\2\2\u0083\r\3\2\2\2\u0084\u0085\7\7\2\2\u0085\17\3"+
		"\2\2\2\u0086\u0087\7\26\2\2\u0087\21\3\2\2\2\22\25\31\34EPRW\\`eipuy~"+
		"\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}