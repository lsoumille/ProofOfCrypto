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
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, WS=14, VAR=15, CONST=16, OP=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"') do {'", "'while ('", "'if ('", "'{'", "';'", "'}'", "'countones('", 
		"':='", "'} else {'", "') then {'", "')'", "'Z ('", "','", "WS", "VAR", 
		"CONST", "OP"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "WS", "VAR", "CONST", "OP"
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
		case 13: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\23z\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\17\6\17i\n\17\r\17\16\17j\3\17\3\17\3\20\6\20p\n\20"+
		"\r\20\16\20q\3\21\6\21u\n\21\r\21\16\21v\3\22\3\22\2\23\3\3\1\5\4\1\7"+
		"\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33"+
		"\17\1\35\20\2\37\21\1!\22\1#\23\1\3\2\6\5\13\f\17\17\"\"\5\"\"C\\c|\4"+
		"\"\"\62;\b\'\',-//\61\61>@``|\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5,\3\2\2\2\7\64\3\2\2\2\t"+
		"9\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21J\3\2\2\2\23M\3\2\2\2\25"+
		"V\3\2\2\2\27_\3\2\2\2\31a\3\2\2\2\33e\3\2\2\2\35h\3\2\2\2\37o\3\2\2\2"+
		"!t\3\2\2\2#x\3\2\2\2%&\7+\2\2&\'\7\"\2\2\'(\7f\2\2()\7q\2\2)*\7\"\2\2"+
		"*+\7}\2\2+\4\3\2\2\2,-\7y\2\2-.\7j\2\2./\7k\2\2/\60\7n\2\2\60\61\7g\2"+
		"\2\61\62\7\"\2\2\62\63\7*\2\2\63\6\3\2\2\2\64\65\7k\2\2\65\66\7h\2\2\66"+
		"\67\7\"\2\2\678\7*\2\28\b\3\2\2\29:\7}\2\2:\n\3\2\2\2;<\7=\2\2<\f\3\2"+
		"\2\2=>\7\177\2\2>\16\3\2\2\2?@\7e\2\2@A\7q\2\2AB\7w\2\2BC\7p\2\2CD\7v"+
		"\2\2DE\7q\2\2EF\7p\2\2FG\7g\2\2GH\7u\2\2HI\7*\2\2I\20\3\2\2\2JK\7<\2\2"+
		"KL\7?\2\2L\22\3\2\2\2MN\7\177\2\2NO\7\"\2\2OP\7g\2\2PQ\7n\2\2QR\7u\2\2"+
		"RS\7g\2\2ST\7\"\2\2TU\7}\2\2U\24\3\2\2\2VW\7+\2\2WX\7\"\2\2XY\7v\2\2Y"+
		"Z\7j\2\2Z[\7g\2\2[\\\7p\2\2\\]\7\"\2\2]^\7}\2\2^\26\3\2\2\2_`\7+\2\2`"+
		"\30\3\2\2\2ab\7\\\2\2bc\7\"\2\2cd\7*\2\2d\32\3\2\2\2ef\7.\2\2f\34\3\2"+
		"\2\2gi\t\2\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\b\17"+
		"\2\2m\36\3\2\2\2np\t\3\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r \3"+
		"\2\2\2su\t\4\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\"\3\2\2\2xy"+
		"\t\5\2\2y$\3\2\2\2\6\2jqv";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}