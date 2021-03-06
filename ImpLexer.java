// Generated from /home/samuele/IdeaProjects/imp/src/Imp.g4 by ANTLR 4.9
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAT=1, BOOL=2, PLUS=3, MINUS=4, MUL=5, DIV=6, MOD=7, POW=8, AND=9, OR=10, 
		EQQ=11, NEQ=12, LEQ=13, GEQ=14, LT=15, GT=16, NOT=17, IF=18, THEN=19, 
		ELSE=20, WHILE=21, SKIPP=22, ASSIGN=23, OUT=24, LPAR=25, RPAR=26, LBRACE=27, 
		RBRACE=28, SEMICOLON=29, ID=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NAT", "BOOL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "AND", "OR", 
			"EQQ", "NEQ", "LEQ", "GEQ", "LT", "GT", "NOT", "IF", "THEN", "ELSE", 
			"WHILE", "SKIPP", "ASSIGN", "OUT", "LPAR", "RPAR", "LBRACE", "RBRACE", 
			"SEMICOLON", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'mod'", "'^'", "'&'", 
			"'|'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'!'", "'if'", "'then'", 
			"'else'", "'while'", "'skip'", "'='", "'out'", "'('", "')'", "'{'", "'}'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAT", "BOOL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "AND", 
			"OR", "EQQ", "NEQ", "LEQ", "GEQ", "LT", "GT", "NOT", "IF", "THEN", "ELSE", 
			"WHILE", "SKIPP", "ASSIGN", "OUT", "LPAR", "RPAR", "LBRACE", "RBRACE", 
			"SEMICOLON", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public ImpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Imp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00ae\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\7\2E\n\2\f\2\16\2H\13\2\5\2J\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3U\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u00a4\n\37\r\37\16\37\u00a5\3 \6 "+
		"\u00a9\n \r \16 \u00aa\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\6\3\2\63;\3\2\62;\3\2c|\5\2\13"+
		"\f\17\17\"\"\2\u00b2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3I\3\2\2\2\5T\3\2\2\2"+
		"\7V\3\2\2\2\tX\3\2\2\2\13Z\3\2\2\2\r\\\3\2\2\2\17^\3\2\2\2\21b\3\2\2\2"+
		"\23d\3\2\2\2\25f\3\2\2\2\27h\3\2\2\2\31k\3\2\2\2\33n\3\2\2\2\35q\3\2\2"+
		"\2\37t\3\2\2\2!v\3\2\2\2#x\3\2\2\2%z\3\2\2\2\'}\3\2\2\2)\u0082\3\2\2\2"+
		"+\u0087\3\2\2\2-\u008d\3\2\2\2/\u0092\3\2\2\2\61\u0094\3\2\2\2\63\u0098"+
		"\3\2\2\2\65\u009a\3\2\2\2\67\u009c\3\2\2\29\u009e\3\2\2\2;\u00a0\3\2\2"+
		"\2=\u00a3\3\2\2\2?\u00a8\3\2\2\2AJ\7\62\2\2BF\t\2\2\2CE\t\3\2\2DC\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IA\3\2\2\2IB\3\2"+
		"\2\2J\4\3\2\2\2KL\7v\2\2LM\7t\2\2MN\7w\2\2NU\7g\2\2OP\7h\2\2PQ\7c\2\2"+
		"QR\7n\2\2RS\7u\2\2SU\7g\2\2TK\3\2\2\2TO\3\2\2\2U\6\3\2\2\2VW\7-\2\2W\b"+
		"\3\2\2\2XY\7/\2\2Y\n\3\2\2\2Z[\7,\2\2[\f\3\2\2\2\\]\7\61\2\2]\16\3\2\2"+
		"\2^_\7o\2\2_`\7q\2\2`a\7f\2\2a\20\3\2\2\2bc\7`\2\2c\22\3\2\2\2de\7(\2"+
		"\2e\24\3\2\2\2fg\7~\2\2g\26\3\2\2\2hi\7?\2\2ij\7?\2\2j\30\3\2\2\2kl\7"+
		"#\2\2lm\7?\2\2m\32\3\2\2\2no\7>\2\2op\7?\2\2p\34\3\2\2\2qr\7@\2\2rs\7"+
		"?\2\2s\36\3\2\2\2tu\7>\2\2u \3\2\2\2vw\7@\2\2w\"\3\2\2\2xy\7#\2\2y$\3"+
		"\2\2\2z{\7k\2\2{|\7h\2\2|&\3\2\2\2}~\7v\2\2~\177\7j\2\2\177\u0080\7g\2"+
		"\2\u0080\u0081\7p\2\2\u0081(\3\2\2\2\u0082\u0083\7g\2\2\u0083\u0084\7"+
		"n\2\2\u0084\u0085\7u\2\2\u0085\u0086\7g\2\2\u0086*\3\2\2\2\u0087\u0088"+
		"\7y\2\2\u0088\u0089\7j\2\2\u0089\u008a\7k\2\2\u008a\u008b\7n\2\2\u008b"+
		"\u008c\7g\2\2\u008c,\3\2\2\2\u008d\u008e\7u\2\2\u008e\u008f\7m\2\2\u008f"+
		"\u0090\7k\2\2\u0090\u0091\7r\2\2\u0091.\3\2\2\2\u0092\u0093\7?\2\2\u0093"+
		"\60\3\2\2\2\u0094\u0095\7q\2\2\u0095\u0096\7w\2\2\u0096\u0097\7v\2\2\u0097"+
		"\62\3\2\2\2\u0098\u0099\7*\2\2\u0099\64\3\2\2\2\u009a\u009b\7+\2\2\u009b"+
		"\66\3\2\2\2\u009c\u009d\7}\2\2\u009d8\3\2\2\2\u009e\u009f\7\177\2\2\u009f"+
		":\3\2\2\2\u00a0\u00a1\7=\2\2\u00a1<\3\2\2\2\u00a2\u00a4\t\4\2\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6>\3\2\2\2\u00a7\u00a9\t\5\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ad\b \2\2\u00ad@\3\2\2\2\b\2FIT\u00a5\u00aa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}