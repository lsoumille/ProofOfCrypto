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
	protected static final PredictionContextCache _sharedContextCache
			= new PredictionContextCache();
	public static final int T__12 = 1, T__11 = 2, T__10 = 3, T__9 = 4, T__8 = 5, T__7 = 6, T__6 = 7, T__5 = 8, T__4 = 9,
			T__3 = 10, T__2 = 11, T__1 = 12, T__0 = 13, WS = 14, VAR = 15, CONST = 16, OP = 17;
	public static final String[] tokenNames = {
		"<INVALID>", "') do {'", "'while ('", "'if ('", "'{'", "';'", "'}'", "'countones('",
		"':='", "'} else {'", "') then {'", "')'", "'Z ('", "','", "WS", "VAR",
		"CONST", "OP"
	};
	public static final int RULE_program = 0, RULE_c = 1, RULE_ifInst = 2, RULE_whileInst = 3, RULE_expr = 4,
			RULE_exprBis = 5, RULE_probFun = 6, RULE_powerEnsemble = 7, RULE_ensemble = 8,
			RULE_zq = 9, RULE_countones = 10;
	public static final String[] ruleNames = {
		"program", "c", "ifInst", "whileInst", "expr", "exprBis", "probFun", "powerEnsemble",
		"ensemble", "zq", "countones"
	};

	@Override
	public String getGrammarFileName() {
		return "Grammar.g4";
	}

	@Override
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {

		public List<CContext> c() {
			return getRuleContexts(CContext.class);
		}

		public CContext c(int i) {
			return getRuleContext(CContext.class, i);
		}

		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_program;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterProgram(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitProgram(this);
			}
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(22);
				c();
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == 5) {
					{
						{
							setState(23);
							match(5);
							setState(24);
							c();
						}
					}
					setState(29);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CContext extends ParserRuleContext {

		public WhileInstContext whileInst() {
			return getRuleContext(WhileInstContext.class, 0);
		}

		public TerminalNode VAR() {
			return getToken(GrammarParser.VAR, 0);
		}

		public ProbFunContext probFun() {
			return getRuleContext(ProbFunContext.class, 0);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public IfInstContext ifInst() {
			return getRuleContext(IfInstContext.class, 0);
		}

		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_c;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterC(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitC(this);
			}
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_c);
		try {
			setState(39);
			switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
					 {
						setState(30);
						match(VAR);
						setState(31);
						match(8);
						setState(32);
						expr();
					}
					break;

				case 2:
					enterOuterAlt(_localctx, 2);
					 {
						setState(33);
						match(VAR);
						setState(34);
						match(8);
						setState(35);
						probFun();
					}
					break;

				case 3:
					enterOuterAlt(_localctx, 3);
					 {
						setState(36);
						ifInst();
					}
					break;

				case 4:
					enterOuterAlt(_localctx, 4);
					 {
						setState(37);
						whileInst();
					}
					break;

				case 5:
					enterOuterAlt(_localctx, 5);
					 {
					}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfInstContext extends ParserRuleContext {

		public ProgramContext program(int i) {
			return getRuleContext(ProgramContext.class, i);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public List<ProgramContext> program() {
			return getRuleContexts(ProgramContext.class);
		}

		public IfInstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_ifInst;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterIfInst(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitIfInst(this);
			}
		}
	}

	public final IfInstContext ifInst() throws RecognitionException {
		IfInstContext _localctx = new IfInstContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifInst);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(41);
				match(3);
				setState(42);
				expr();
				setState(43);
				match(10);
				setState(44);
				program();
				setState(45);
				match(9);
				setState(46);
				program();
				setState(47);
				match(6);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileInstContext extends ParserRuleContext {

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public ProgramContext program() {
			return getRuleContext(ProgramContext.class, 0);
		}

		public WhileInstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_whileInst;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterWhileInst(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitWhileInst(this);
			}
		}
	}

	public final WhileInstContext whileInst() throws RecognitionException {
		WhileInstContext _localctx = new WhileInstContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whileInst);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(49);
				match(2);
				setState(50);
				expr();
				setState(51);
				match(1);
				setState(52);
				program();
				setState(53);
				match(6);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {

		public TerminalNode CONST() {
			return getToken(GrammarParser.CONST, 0);
		}

		public TerminalNode VAR() {
			return getToken(GrammarParser.VAR, 0);
		}

		public ExprBisContext exprBis() {
			return getRuleContext(ExprBisContext.class, 0);
		}

		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_expr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterExpr(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitExpr(this);
			}
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(59);
			switch (_input.LA(1)) {
				case CONST:
					enterOuterAlt(_localctx, 1);
					 {
						setState(55);
						match(CONST);
						setState(56);
						exprBis();
					}
					break;
				case VAR:
					enterOuterAlt(_localctx, 2);
					 {
						setState(57);
						match(VAR);
						setState(58);
						exprBis();
					}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprBisContext extends ParserRuleContext {

		public TerminalNode OP() {
			return getToken(GrammarParser.OP, 0);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public ExprBisContext exprBis() {
			return getRuleContext(ExprBisContext.class, 0);
		}

		public ExprBisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_exprBis;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterExprBis(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitExprBis(this);
			}
		}
	}

	public final ExprBisContext exprBis() throws RecognitionException {
		ExprBisContext _localctx = new ExprBisContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exprBis);
		try {
			setState(66);
			switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
					 {
						setState(61);
						match(OP);
						setState(62);
						expr();
						setState(63);
						exprBis();
					}
					break;

				case 2:
					enterOuterAlt(_localctx, 2);
					 {
					}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProbFunContext extends ParserRuleContext {

		public CountonesContext countones() {
			return getRuleContext(CountonesContext.class, 0);
		}

		public ZqContext zq() {
			return getRuleContext(ZqContext.class, 0);
		}

		public PowerEnsembleContext powerEnsemble() {
			return getRuleContext(PowerEnsembleContext.class, 0);
		}

		public EnsembleContext ensemble() {
			return getRuleContext(EnsembleContext.class, 0);
		}

		public ProbFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_probFun;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterProbFun(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitProbFun(this);
			}
		}
	}

	public final ProbFunContext probFun() throws RecognitionException {
		ProbFunContext _localctx = new ProbFunContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_probFun);
		try {
			setState(72);
			switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
					 {
						setState(68);
						ensemble();
					}
					break;

				case 2:
					enterOuterAlt(_localctx, 2);
					 {
						setState(69);
						zq();
					}
					break;

				case 3:
					enterOuterAlt(_localctx, 3);
					 {
						setState(70);
						powerEnsemble();
					}
					break;

				case 4:
					enterOuterAlt(_localctx, 4);
					 {
						setState(71);
						countones();
					}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowerEnsembleContext extends ParserRuleContext {

		public TerminalNode CONST(int i) {
			return getToken(GrammarParser.CONST, i);
		}

		public List<TerminalNode> CONST() {
			return getTokens(GrammarParser.CONST);
		}

		public PowerEnsembleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_powerEnsemble;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterPowerEnsemble(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitPowerEnsemble(this);
			}
		}
	}

	public final PowerEnsembleContext powerEnsemble() throws RecognitionException {
		PowerEnsembleContext _localctx = new PowerEnsembleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_powerEnsemble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(74);
				match(4);
				setState(75);
				match(CONST);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == 13) {
					{
						{
							setState(76);
							match(13);
							setState(77);
							match(CONST);
						}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				match(6);
				setState(84);
				match(CONST);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnsembleContext extends ParserRuleContext {

		public TerminalNode CONST(int i) {
			return getToken(GrammarParser.CONST, i);
		}

		public List<TerminalNode> CONST() {
			return getTokens(GrammarParser.CONST);
		}

		public EnsembleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_ensemble;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterEnsemble(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitEnsemble(this);
			}
		}
	}

	public final EnsembleContext ensemble() throws RecognitionException {
		EnsembleContext _localctx = new EnsembleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ensemble);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(86);
				match(4);
				setState(87);
				match(CONST);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == 13) {
					{
						{
							setState(88);
							match(13);
							setState(89);
							match(CONST);
						}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(6);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ZqContext extends ParserRuleContext {

		public TerminalNode CONST() {
			return getToken(GrammarParser.CONST, 0);
		}

		public ZqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_zq;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterZq(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitZq(this);
			}
		}
	}

	public final ZqContext zq() throws RecognitionException {
		ZqContext _localctx = new ZqContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_zq);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(97);
				match(12);
				setState(98);
				match(CONST);
				setState(99);
				match(11);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CountonesContext extends ParserRuleContext {

		public TerminalNode VAR() {
			return getToken(GrammarParser.VAR, 0);
		}

		public CountonesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_countones;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).enterCountones(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof GrammarListener) {
				((GrammarListener) listener).exitCountones(this);
			}
		}
	}

	public final CountonesContext countones() throws RecognitionException {
		CountonesContext _localctx = new CountonesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_countones);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(101);
				match(7);
				setState(102);
				match(VAR);
				setState(103);
				match(11);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN
			= "\2\3\23l\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"
			+ "\t\4\n\t\n\4\13\t\13\4\f\t\f\3\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3"
			+ "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"
			+ "\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6>\n\6\3\7\3\7\3\7\3"
			+ "\7\3\7\5\7E\n\7\3\b\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\3\t\7\tQ\n\t\f\t"
			+ "\16\tT\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n]\n\n\f\n\16\n`\13\n\3\n\3"
			+ "\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\2\r\2\4\6\b\n\f\16\20\22\24"
			+ "\26\2\2l\2\30\3\2\2\2\4)\3\2\2\2\6+\3\2\2\2\b\63\3\2\2\2\n=\3\2\2\2\f"
			+ "D\3\2\2\2\16J\3\2\2\2\20L\3\2\2\2\22X\3\2\2\2\24c\3\2\2\2\26g\3\2\2\2"
			+ "\30\35\5\4\3\2\31\32\7\7\2\2\32\34\5\4\3\2\33\31\3\2\2\2\34\37\3\2\2\2"
			+ "\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35\3\2\2\2 !\7\21\2\2!\""
			+ "\7\n\2\2\"*\5\n\6\2#$\7\21\2\2$%\7\n\2\2%*\5\16\b\2&*\5\6\4\2\'*\5\b\5"
			+ "\2(*\3\2\2\2) \3\2\2\2)#\3\2\2\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\5\3\2"
			+ "\2\2+,\7\5\2\2,-\5\n\6\2-.\7\f\2\2./\5\2\2\2/\60\7\13\2\2\60\61\5\2\2"
			+ "\2\61\62\7\b\2\2\62\7\3\2\2\2\63\64\7\4\2\2\64\65\5\n\6\2\65\66\7\3\2"
			+ "\2\66\67\5\2\2\2\678\7\b\2\28\t\3\2\2\29:\7\22\2\2:>\5\f\7\2;<\7\21\2"
			+ "\2<>\5\f\7\2=9\3\2\2\2=;\3\2\2\2>\13\3\2\2\2?@\7\23\2\2@A\5\n\6\2AB\5"
			+ "\f\7\2BE\3\2\2\2CE\3\2\2\2D?\3\2\2\2DC\3\2\2\2E\r\3\2\2\2FK\5\22\n\2G"
			+ "K\5\24\13\2HK\5\20\t\2IK\5\26\f\2JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2"
			+ "\2\2K\17\3\2\2\2LM\7\6\2\2MR\7\22\2\2NO\7\17\2\2OQ\7\22\2\2PN\3\2\2\2"
			+ "QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7\b\2\2VW\7\22\2"
			+ "\2W\21\3\2\2\2XY\7\6\2\2Y^\7\22\2\2Z[\7\17\2\2[]\7\22\2\2\\Z\3\2\2\2]"
			+ "`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7\b\2\2b\23\3\2\2"
			+ "\2cd\7\16\2\2de\7\22\2\2ef\7\r\2\2f\25\3\2\2\2gh\7\t\2\2hi\7\21\2\2ij"
			+ "\7\r\2\2j\27\3\2\2\2\t\35)=DJR^";
	public static final ATN _ATN
			= ATNSimulator.deserialize(_serializedATN.toCharArray());

	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
