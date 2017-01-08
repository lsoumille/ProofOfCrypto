// Generated from /home/lucas/IdeaProjects/ProofOfCrypto/src/main/antlr4/Grammar.g4 by ANTLR 4.6
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, WS=13, VAR=14, CONST=15, OP=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "WS", "VAR", "CONST", "OP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':='", "'if ('", "') then {'", "'} else {'", "'}'", "'while ('", 
		"') do {'", "'{'", "','", "'Z ('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "WS", "VAR", "CONST", "OP"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22m\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\16\6\16\\\n\16\r\16\16\16]\3\16\3\16\3\17\6\17c\n\17\r\17\16\17d"+
		"\3\20\6\20h\n\20\r\20\16\20i\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2\6\5\2\13\f"+
		"\17\17\"\"\5\2\"\"C\\c|\4\2\"\"\62;\6\2,-//\61\61>@o\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7(\3"+
		"\2\2\2\t-\3\2\2\2\13\66\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21I\3\2\2\2\23"+
		"P\3\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31X\3\2\2\2\33[\3\2\2\2\35b\3\2\2\2"+
		"\37g\3\2\2\2!k\3\2\2\2#$\7=\2\2$\4\3\2\2\2%&\7<\2\2&\'\7?\2\2\'\6\3\2"+
		"\2\2()\7k\2\2)*\7h\2\2*+\7\"\2\2+,\7*\2\2,\b\3\2\2\2-.\7+\2\2./\7\"\2"+
		"\2/\60\7v\2\2\60\61\7j\2\2\61\62\7g\2\2\62\63\7p\2\2\63\64\7\"\2\2\64"+
		"\65\7}\2\2\65\n\3\2\2\2\66\67\7\177\2\2\678\7\"\2\289\7g\2\29:\7n\2\2"+
		":;\7u\2\2;<\7g\2\2<=\7\"\2\2=>\7}\2\2>\f\3\2\2\2?@\7\177\2\2@\16\3\2\2"+
		"\2AB\7y\2\2BC\7j\2\2CD\7k\2\2DE\7n\2\2EF\7g\2\2FG\7\"\2\2GH\7*\2\2H\20"+
		"\3\2\2\2IJ\7+\2\2JK\7\"\2\2KL\7f\2\2LM\7q\2\2MN\7\"\2\2NO\7}\2\2O\22\3"+
		"\2\2\2PQ\7}\2\2Q\24\3\2\2\2RS\7.\2\2S\26\3\2\2\2TU\7\\\2\2UV\7\"\2\2V"+
		"W\7*\2\2W\30\3\2\2\2XY\7+\2\2Y\32\3\2\2\2Z\\\t\2\2\2[Z\3\2\2\2\\]\3\2"+
		"\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\b\16\2\2`\34\3\2\2\2ac\t\3\2\2ba"+
		"\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\36\3\2\2\2fh\t\4\2\2gf\3\2\2\2"+
		"hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j \3\2\2\2kl\t\5\2\2l\"\3\2\2\2\6\2]di\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}