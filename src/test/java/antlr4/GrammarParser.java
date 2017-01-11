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
		RULE_program = 0, RULE_c = 1, RULE_expr = 2, RULE_exprBis = 3, RULE_probFun = 4;
	public static final String[] ruleNames = {
		"program", "c", "expr", "exprBis", "probFun"
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
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); c();
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==9) {
				{
				{
				setState(11); match(9);
				setState(12); c();
				}
				}
				setState(17);
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
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitC(this);
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_c);
		try {
			setState(39);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(18); match(VAR);
				setState(19); match(2);
				setState(20); expr();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21); match(VAR);
				setState(22); match(2);
				setState(23); probFun();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24); match(6);
				setState(25); expr();
				setState(26); match(5);
				setState(27); program();
				setState(28); match(4);
				setState(29); program();
				setState(30); match(12);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(32); match(3);
				setState(33); expr();
				setState(34); match(1);
				setState(35); program();
				setState(36); match(12);
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
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(45);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); match(CONST);
				setState(42); exprBis();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); match(VAR);
				setState(44); exprBis();
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
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterExprBis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitExprBis(this);
		}
	}

	public final ExprBisContext exprBis() throws RecognitionException {
		ExprBisContext _localctx = new ExprBisContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exprBis);
		try {
			setState(52);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); match(OP);
				setState(48); expr();
				setState(49); exprBis();
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
		public TerminalNode CONST(int i) {
			return getToken(GrammarParser.CONST, i);
		}
		public List<TerminalNode> CONST() { return getTokens(GrammarParser.CONST); }
		public ProbFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterProbFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitProbFun(this);
		}
	}

	public final ProbFunContext probFun() throws RecognitionException {
		ProbFunContext _localctx = new ProbFunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_probFun);
		int _la;
		try {
			setState(67);
			switch (_input.LA(1)) {
			case 8:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); match(8);
				setState(55); match(CONST);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==11) {
					{
					{
					setState(56); match(11);
					setState(57); match(CONST);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63); match(12);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 2);
				{
				setState(64); match(10);
				setState(65); match(CONST);
				setState(66); match(7);
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

	public static final String _serializedATN =
		"\2\3\22H\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\7\2\20\n"+
		"\2\f\2\16\2\23\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\5\4\60\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\5\5\67\n\5\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13"+
		"\6\3\6\3\6\3\6\3\6\5\6F\n\6\3\6\2\7\2\4\6\b\n\2\2K\2\f\3\2\2\2\4)\3\2"+
		"\2\2\6/\3\2\2\2\b\66\3\2\2\2\nE\3\2\2\2\f\21\5\4\3\2\r\16\7\13\2\2\16"+
		"\20\5\4\3\2\17\r\3\2\2\2\20\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22"+
		"\3\3\2\2\2\23\21\3\2\2\2\24\25\7\20\2\2\25\26\7\4\2\2\26*\5\6\4\2\27\30"+
		"\7\20\2\2\30\31\7\4\2\2\31*\5\n\6\2\32\33\7\b\2\2\33\34\5\6\4\2\34\35"+
		"\7\7\2\2\35\36\5\2\2\2\36\37\7\6\2\2\37 \5\2\2\2 !\7\16\2\2!*\3\2\2\2"+
		"\"#\7\5\2\2#$\5\6\4\2$%\7\3\2\2%&\5\2\2\2&\'\7\16\2\2\'*\3\2\2\2(*\3\2"+
		"\2\2)\24\3\2\2\2)\27\3\2\2\2)\32\3\2\2\2)\"\3\2\2\2)(\3\2\2\2*\5\3\2\2"+
		"\2+,\7\21\2\2,\60\5\b\5\2-.\7\20\2\2.\60\5\b\5\2/+\3\2\2\2/-\3\2\2\2\60"+
		"\7\3\2\2\2\61\62\7\22\2\2\62\63\5\6\4\2\63\64\5\b\5\2\64\67\3\2\2\2\65"+
		"\67\3\2\2\2\66\61\3\2\2\2\66\65\3\2\2\2\67\t\3\2\2\289\7\n\2\29>\7\21"+
		"\2\2:;\7\r\2\2;=\7\21\2\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3"+
		"\2\2\2@>\3\2\2\2AF\7\16\2\2BC\7\f\2\2CD\7\21\2\2DF\7\t\2\2E8\3\2\2\2E"+
		"B\3\2\2\2F\13\3\2\2\2\b\21)/\66>E";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}