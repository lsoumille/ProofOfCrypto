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
		RULE_program = 0, RULE_c = 1, RULE_ifInst = 2, RULE_whileInst = 3, RULE_expr = 4, 
		RULE_exprBis = 5, RULE_probFun = 6, RULE_powerEnsemble = 7, RULE_ensemble = 8, 
		RULE_zq = 9;
	public static final String[] ruleNames = {
		"program", "c", "ifInst", "whileInst", "expr", "exprBis", "probFun", "powerEnsemble", 
		"ensemble", "zq"
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
			setState(20); c();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==9) {
				{
				{
				setState(21); match(9);
				setState(22); c();
				}
				}
				setState(27);
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
		public WhileInstContext whileInst() {
			return getRuleContext(WhileInstContext.class,0);
		}
		public TerminalNode VAR() { return getToken(GrammarParser.VAR, 0); }
		public ProbFunContext probFun() {
			return getRuleContext(ProbFunContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IfInstContext ifInst() {
			return getRuleContext(IfInstContext.class,0);
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
			setState(37);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); match(VAR);
				setState(29); match(2);
				setState(30); expr();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); match(VAR);
				setState(32); match(2);
				setState(33); probFun();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34); ifInst();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35); whileInst();
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

	public static class IfInstContext extends ParserRuleContext {
		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}
		public IfInstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifInst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterIfInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitIfInst(this);
		}
	}

	public final IfInstContext ifInst() throws RecognitionException {
		IfInstContext _localctx = new IfInstContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifInst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(6);
			setState(40); expr();
			setState(41); match(5);
			setState(42); program();
			setState(43); match(4);
			setState(44); program();
			setState(45); match(12);
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

	public static class WhileInstContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public WhileInstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileInst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterWhileInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitWhileInst(this);
		}
	}

	public final WhileInstContext whileInst() throws RecognitionException {
		WhileInstContext _localctx = new WhileInstContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whileInst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); match(3);
			setState(48); expr();
			setState(49); match(1);
			setState(50); program();
			setState(51); match(12);
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
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(57);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); match(CONST);
				setState(54); exprBis();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); match(VAR);
				setState(56); exprBis();
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
		enterRule(_localctx, 10, RULE_exprBis);
		try {
			setState(64);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59); match(OP);
				setState(60); expr();
				setState(61); exprBis();
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
		public PowerEnsembleContext powerEnsemble() {
			return getRuleContext(PowerEnsembleContext.class,0);
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
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterProbFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitProbFun(this);
		}
	}

	public final ProbFunContext probFun() throws RecognitionException {
		ProbFunContext _localctx = new ProbFunContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_probFun);
		try {
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66); ensemble();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67); zq();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(68); powerEnsemble();
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

	public static class PowerEnsembleContext extends ParserRuleContext {
		public TerminalNode CONST(int i) {
			return getToken(GrammarParser.CONST, i);
		}
		public List<TerminalNode> CONST() { return getTokens(GrammarParser.CONST); }
		public PowerEnsembleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powerEnsemble; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterPowerEnsemble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitPowerEnsemble(this);
		}
	}

	public final PowerEnsembleContext powerEnsemble() throws RecognitionException {
		PowerEnsembleContext _localctx = new PowerEnsembleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_powerEnsemble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(8);
			setState(72); match(CONST);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==11) {
				{
				{
				setState(73); match(11);
				setState(74); match(CONST);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); match(12);
			setState(81); match(CONST);
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
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterEnsemble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitEnsemble(this);
		}
	}

	public final EnsembleContext ensemble() throws RecognitionException {
		EnsembleContext _localctx = new EnsembleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ensemble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(8);
			setState(84); match(CONST);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==11) {
				{
				{
				setState(85); match(11);
				setState(86); match(CONST);
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92); match(12);
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
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterZq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitZq(this);
		}
	}

	public final ZqContext zq() throws RecognitionException {
		ZqContext _localctx = new ZqContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_zq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(10);
			setState(95); match(CONST);
			setState(96); match(7);
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
		"\2\3\22e\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\3\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3(\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6<\n\6\3\7\3\7\3\7\3\7\3\7\5"+
		"\7C\n\7\3\b\3\b\3\b\5\bH\n\b\3\t\3\t\3\t\3\t\7\tN\n\t\f\t\16\tQ\13\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\7\nZ\n\n\f\n\16\n]\13\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\2\f\2\4\6\b\n\f\16\20\22\24\2\2e\2\26\3\2\2\2\4\'\3\2\2"+
		"\2\6)\3\2\2\2\b\61\3\2\2\2\n;\3\2\2\2\fB\3\2\2\2\16G\3\2\2\2\20I\3\2\2"+
		"\2\22U\3\2\2\2\24`\3\2\2\2\26\33\5\4\3\2\27\30\7\13\2\2\30\32\5\4\3\2"+
		"\31\27\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2"+
		"\35\33\3\2\2\2\36\37\7\20\2\2\37 \7\4\2\2 (\5\n\6\2!\"\7\20\2\2\"#\7\4"+
		"\2\2#(\5\16\b\2$(\5\6\4\2%(\5\b\5\2&(\3\2\2\2\'\36\3\2\2\2\'!\3\2\2\2"+
		"\'$\3\2\2\2\'%\3\2\2\2\'&\3\2\2\2(\5\3\2\2\2)*\7\b\2\2*+\5\n\6\2+,\7\7"+
		"\2\2,-\5\2\2\2-.\7\6\2\2./\5\2\2\2/\60\7\16\2\2\60\7\3\2\2\2\61\62\7\5"+
		"\2\2\62\63\5\n\6\2\63\64\7\3\2\2\64\65\5\2\2\2\65\66\7\16\2\2\66\t\3\2"+
		"\2\2\678\7\21\2\28<\5\f\7\29:\7\20\2\2:<\5\f\7\2;\67\3\2\2\2;9\3\2\2\2"+
		"<\13\3\2\2\2=>\7\22\2\2>?\5\n\6\2?@\5\f\7\2@C\3\2\2\2AC\3\2\2\2B=\3\2"+
		"\2\2BA\3\2\2\2C\r\3\2\2\2DH\5\22\n\2EH\5\24\13\2FH\5\20\t\2GD\3\2\2\2"+
		"GE\3\2\2\2GF\3\2\2\2H\17\3\2\2\2IJ\7\n\2\2JO\7\21\2\2KL\7\r\2\2LN\7\21"+
		"\2\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\16"+
		"\2\2ST\7\21\2\2T\21\3\2\2\2UV\7\n\2\2V[\7\21\2\2WX\7\r\2\2XZ\7\21\2\2"+
		"YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7\16"+
		"\2\2_\23\3\2\2\2`a\7\f\2\2ab\7\21\2\2bc\7\t\2\2c\25\3\2\2\2\t\33\';BG"+
		"O[";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}