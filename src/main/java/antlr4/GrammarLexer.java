package antlr4;// Generated from Grammar.g4 by ANTLR 4.0

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, WS=13, VAR=14, CONST=15, OP=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"') do {'", "':='", "'while ('", "'} else {'", "') then {'", "'if ('", 
		"')'", "'{'", "';'", "'Z ('", "','", "'}'", "WS", "VAR", "CONST", "OP"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "WS", "VAR", "CONST", "OP"
	};


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 12: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\22m\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16\\\n\16\r\16\16\16]\3\16\3\16\3\17\6"+
		"\17c\n\17\r\17\16\17d\3\20\6\20h\n\20\r\20\16\20i\3\21\3\21\2\22\3\3\1"+
		"\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31"+
		"\16\1\33\17\2\35\20\1\37\21\1!\22\1\3\2\6\5\13\f\17\17\"\"\5\"\"C\\c|"+
		"\4\"\"\62;\6,-//\61\61>@o\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5*\3\2\2\2\7-\3\2\2\2\t\65\3\2\2\2\13>\3"+
		"\2\2\2\rG\3\2\2\2\17L\3\2\2\2\21N\3\2\2\2\23P\3\2\2\2\25R\3\2\2\2\27V"+
		"\3\2\2\2\31X\3\2\2\2\33[\3\2\2\2\35b\3\2\2\2\37g\3\2\2\2!k\3\2\2\2#$\7"+
		"+\2\2$%\7\"\2\2%&\7f\2\2&\'\7q\2\2\'(\7\"\2\2()\7}\2\2)\4\3\2\2\2*+\7"+
		"<\2\2+,\7?\2\2,\6\3\2\2\2-.\7y\2\2./\7j\2\2/\60\7k\2\2\60\61\7n\2\2\61"+
		"\62\7g\2\2\62\63\7\"\2\2\63\64\7*\2\2\64\b\3\2\2\2\65\66\7\177\2\2\66"+
		"\67\7\"\2\2\678\7g\2\289\7n\2\29:\7u\2\2:;\7g\2\2;<\7\"\2\2<=\7}\2\2="+
		"\n\3\2\2\2>?\7+\2\2?@\7\"\2\2@A\7v\2\2AB\7j\2\2BC\7g\2\2CD\7p\2\2DE\7"+
		"\"\2\2EF\7}\2\2F\f\3\2\2\2GH\7k\2\2HI\7h\2\2IJ\7\"\2\2JK\7*\2\2K\16\3"+
		"\2\2\2LM\7+\2\2M\20\3\2\2\2NO\7}\2\2O\22\3\2\2\2PQ\7=\2\2Q\24\3\2\2\2"+
		"RS\7\\\2\2ST\7\"\2\2TU\7*\2\2U\26\3\2\2\2VW\7.\2\2W\30\3\2\2\2XY\7\177"+
		"\2\2Y\32\3\2\2\2Z\\\t\2\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^"+
		"_\3\2\2\2_`\b\16\2\2`\34\3\2\2\2ac\t\3\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2e\36\3\2\2\2fh\t\4\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2"+
		"\2\2j \3\2\2\2kl\t\5\2\2l\"\3\2\2\2\6\2]di";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}