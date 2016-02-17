// Generated from PolicyGrammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PolicyGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, CTX=4, DOM=5, PREVIOUS=6, SINCE=7, EPAST=8, GPAST=9, 
		ELEMENT=10, EQU=11, NOT=12, AND=13, OR=14, EXIST=15, ALL=16, IN=17, FLOW=18, 
		IFLOW=19, ID=20, INT=21, NEWLINE=22, WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "CTX", "DOM", "PREVIOUS", "SINCE", "EPAST", "GPAST", 
		"ELEMENT", "EQU", "NOT", "AND", "OR", "EXIST", "ALL", "IN", "FLOW", "IFLOW", 
		"ID", "INT", "NEWLINE", "WS"
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


	public PolicyGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PolicyGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\6\25\177\n\25"+
		"\r\25\16\25\u0080\3\26\6\26\u0084\n\26\r\26\16\26\u0085\3\27\5\27\u0089"+
		"\n\27\3\27\3\27\3\30\6\30\u008e\n\30\r\30\16\30\u008f\3\30\3\30\2\2\31"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\13\3\2[[\3\2UU\3\2RR\3\2J"+
		"J\3\2GG\3\2@@\4\2C\\c|\3\2\62;\4\2\13\13\"\"\u0099\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3"+
		"\2\2\2\7\65\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rS\3\2\2\2\17U\3\2\2\2\21W"+
		"\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27]\3\2\2\2\31`\3\2\2\2\33d\3\2\2\2\35"+
		"h\3\2\2\2\37k\3\2\2\2!q\3\2\2\2#u\3\2\2\2%x\3\2\2\2\'z\3\2\2\2)~\3\2\2"+
		"\2+\u0083\3\2\2\2-\u0088\3\2\2\2/\u008d\3\2\2\2\61\62\7?\2\2\62\4\3\2"+
		"\2\2\63\64\7*\2\2\64\6\3\2\2\2\65\66\7+\2\2\66\b\3\2\2\2\678\7w\2\289"+
		"\7u\2\29:\7g\2\2:;\7t\2\2;L\7\63\2\2<=\7w\2\2=>\7u\2\2>?\7g\2\2?@\7t\2"+
		"\2@L\7\64\2\2AB\7w\2\2BC\7u\2\2CD\7g\2\2DE\7t\2\2EL\7\65\2\2FG\7w\2\2"+
		"GH\7u\2\2HI\7g\2\2IJ\7t\2\2JL\7\66\2\2K\67\3\2\2\2K<\3\2\2\2KA\3\2\2\2"+
		"KF\3\2\2\2L\n\3\2\2\2MN\7w\2\2NO\7u\2\2OP\7g\2\2PQ\7t\2\2QR\7u\2\2R\f"+
		"\3\2\2\2ST\t\2\2\2T\16\3\2\2\2UV\t\3\2\2V\20\3\2\2\2WX\t\4\2\2X\22\3\2"+
		"\2\2YZ\t\5\2\2Z\24\3\2\2\2[\\\t\6\2\2\\\26\3\2\2\2]^\7G\2\2^_\7S\2\2_"+
		"\30\3\2\2\2`a\7P\2\2ab\7Q\2\2bc\7V\2\2c\32\3\2\2\2de\7C\2\2ef\7P\2\2f"+
		"g\7F\2\2g\34\3\2\2\2hi\7Q\2\2ij\7T\2\2j\36\3\2\2\2kl\7G\2\2lm\7Z\2\2m"+
		"n\7K\2\2no\7U\2\2op\7V\2\2p \3\2\2\2qr\7C\2\2rs\7N\2\2st\7N\2\2t\"\3\2"+
		"\2\2uv\7K\2\2vw\7P\2\2w$\3\2\2\2xy\t\7\2\2y&\3\2\2\2z{\7@\2\2{|\7@\2\2"+
		"|(\3\2\2\2}\177\t\b\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081*\3\2\2\2\u0082\u0084\t\t\2\2\u0083\u0082\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086,\3"+
		"\2\2\2\u0087\u0089\7\17\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\7\f\2\2\u008b.\3\2\2\2\u008c\u008e\t\n\2\2"+
		"\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\b\30\2\2\u0092\60\3\2\2\2\b\2"+
		"K\u0080\u0085\u0088\u008f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}