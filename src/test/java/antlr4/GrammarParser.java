package antlr4;// Generated from Grammar.g4 by ANTLR 4.0

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, WS=13, VAR=14, CONST=15, OP=16;
	public static final String[] tokenNames = {
		"<INVALID>", "') do {'", "':='", "'while ('", "'} else {'", "') then {'", 
		"'if ('", "')'", "'{'", "';'", "'Z ('", "','", "'}'", "WS", "VAR", "CONST", 
		"OP"
	};
	public static final int
		RULE_program = 0, RULE_c = 1, RULE_expr = 2, RULE_exprBis = 3, RULE_probFun = 4, 
		RULE_ensemble = 5, RULE_zq = 6;
	public static final String[] ruleNames = {
		"program", "c", "expr", "exprBis", "probFun", "ensemble", "zq"
	};

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<CContext> c() {
			return getRuleContexts(CContext.class);
		}
		public CContext c(int i) {
			return getRuleContext(CContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); c();
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==9) {
				{
				{
				setState(15); match(9);
				setState(16); c();
				}
				}
				setState(21);
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

	public static class CContext extends ParserRuleContext {
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public TerminalNode VAR() { return getToken(GrammarParser.VAR, 0); }
		public ProbFunContext probFun() {
			return getRuleContext(ProbFunContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitC(this);
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_c);
		try {
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22); match(VAR);
				setState(23); match(2);
				setState(24); expr();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); match(VAR);
				setState(26); match(2);
				setState(27); probFun();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(28); match(6);
				setState(29); expr();
				setState(30); match(5);
				setState(31); program();
				setState(32); match(4);
				setState(33); program();
				setState(34); match(12);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(36); match(3);
				setState(37); expr();
				setState(38); match(1);
				setState(39); program();
				setState(40); match(12);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GrammarParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(GrammarParser.VAR, 0); }
		public ExprBisContext exprBis() {
			return getRuleContext(ExprBisContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(49);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); match(CONST);
				setState(46); exprBis();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); match(VAR);
				setState(48); exprBis();
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

	public static class ExprBisContext extends ParserRuleContext {
		public TerminalNode OP() { return getToken(GrammarParser.OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprBisContext exprBis() {
			return getRuleContext(ExprBisContext.class,0);
		}
		public ExprBisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprBis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExprBis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExprBis(this);
		}
	}

	public final ExprBisContext exprBis() throws RecognitionException {
		ExprBisContext _localctx = new ExprBisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exprBis);
		try {
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); match(OP);
				setState(52); expr();
				setState(53); exprBis();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ProbFunContext extends ParserRuleContext {
		public ZqContext zq() {
			return getRuleContext(ZqContext.class,0);
		}
		public EnsembleContext ensemble() {
			return getRuleContext(EnsembleContext.class,0);
		}
		public ProbFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProbFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProbFun(this);
		}
	}

	public final ProbFunContext probFun() throws RecognitionException {
		ProbFunContext _localctx = new ProbFunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_probFun);
		try {
			setState(60);
			switch (_input.LA(1)) {
			case 8:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); ensemble();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); zq();
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

	public static class EnsembleContext extends ParserRuleContext {
		public TerminalNode CONST(int i) {
			return getToken(GrammarParser.CONST, i);
		}
		public List<TerminalNode> CONST() { return getTokens(GrammarParser.CONST); }
		public EnsembleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ensemble; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEnsemble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEnsemble(this);
		}
	}

	public final EnsembleContext ensemble() throws RecognitionException {
		EnsembleContext _localctx = new EnsembleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ensemble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(8);
			setState(63); match(CONST);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==11) {
				{
				{
				setState(64); match(11);
				setState(65); match(CONST);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71); match(12);
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

	public static class ZqContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GrammarParser.CONST, 0); }
		public ZqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterZq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitZq(this);
		}
	}

	public final ZqContext zq() throws RecognitionException {
		ZqContext _localctx = new ZqContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_zq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); match(10);
			setState(74); match(CONST);
			setState(75); match(7);
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
		"\2\3\22P\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3"+
		"\2\3\2\7\2\24\n\2\f\2\16\2\27\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4"+
		"\3\4\5\4\64\n\4\3\5\3\5\3\5\3\5\3\5\5\5;\n\5\3\6\3\6\5\6?\n\6\3\7\3\7"+
		"\3\7\3\7\7\7E\n\7\f\7\16\7H\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\2\t\2\4\6"+
		"\b\n\f\16\2\2Q\2\20\3\2\2\2\4-\3\2\2\2\6\63\3\2\2\2\b:\3\2\2\2\n>\3\2"+
		"\2\2\f@\3\2\2\2\16K\3\2\2\2\20\25\5\4\3\2\21\22\7\13\2\2\22\24\5\4\3\2"+
		"\23\21\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2"+
		"\27\25\3\2\2\2\30\31\7\20\2\2\31\32\7\4\2\2\32.\5\6\4\2\33\34\7\20\2\2"+
		"\34\35\7\4\2\2\35.\5\n\6\2\36\37\7\b\2\2\37 \5\6\4\2 !\7\7\2\2!\"\5\2"+
		"\2\2\"#\7\6\2\2#$\5\2\2\2$%\7\16\2\2%.\3\2\2\2&\'\7\5\2\2\'(\5\6\4\2("+
		")\7\3\2\2)*\5\2\2\2*+\7\16\2\2+.\3\2\2\2,.\3\2\2\2-\30\3\2\2\2-\33\3\2"+
		"\2\2-\36\3\2\2\2-&\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\60\7\21\2\2\60\64\5\b"+
		"\5\2\61\62\7\20\2\2\62\64\5\b\5\2\63/\3\2\2\2\63\61\3\2\2\2\64\7\3\2\2"+
		"\2\65\66\7\22\2\2\66\67\5\6\4\2\678\5\b\5\28;\3\2\2\29;\3\2\2\2:\65\3"+
		"\2\2\2:9\3\2\2\2;\t\3\2\2\2<?\5\f\7\2=?\5\16\b\2><\3\2\2\2>=\3\2\2\2?"+
		"\13\3\2\2\2@A\7\n\2\2AF\7\21\2\2BC\7\r\2\2CE\7\21\2\2DB\3\2\2\2EH\3\2"+
		"\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\16\2\2J\r\3\2\2\2KL\7"+
		"\f\2\2LM\7\21\2\2MN\7\t\2\2N\17\3\2\2\2\b\25-\63:>F";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}