import antlr4.GrammarLexer;
import antlr4.GrammarParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.BitSet;

/**
 * Created by lucas on 05/01/17.
 */
public class TestGrammar {

    private static final Logger logger = LoggerFactory.getLogger(TestGrammar.class);

    @Test
    public void testExploratoryString() throws IOException {
        //String simplestProgram = "sphere 12 12 12 cube 2 3 4 cube 4 4 4 sphere 3 3 3";
        String simplestProgram = "x := 1;" +
                "y :={0,1,2,33};" +
                "if (x>y) then " +
                "{x:=1;} " +
                "else " +
                "{y:=1;}";

        CharStream inputCharStream = new ANTLRInputStream(new StringReader(simplestProgram));
        TokenSource tokenSource = new GrammarLexer(inputCharStream);
        TokenStream inputTokenStream = new CommonTokenStream(tokenSource);
        GrammarParser parser = new GrammarParser(inputTokenStream);

        //parser.addErrorListener(new TestErrorListener());
        parser.setErrorHandler(new BailErrorStrategy());

        GrammarParser.ProgramContext context = parser.program();

        System.out.println(context.getText());

        logger.info(context.toString());
    }

    class ErrorStrat implements ANTLRErrorStrategy {

        public void setTokenFactory(TokenFactory<?> tokenFactory) {

        }

        public Token recoverInline(@NotNull Parser parser) throws RecognitionException {
            return null;
        }

        public void recover(@NotNull Parser parser, @Nullable RecognitionException e) {
            System.out.println("");
        }

        public void sync(@NotNull Parser parser) {

        }

        public void beginErrorCondition(@NotNull Parser parser) {
        }

        public boolean inErrorRecoveryMode(@NotNull Parser parser) {
            System.out.println("Bonjour");
            return false;
        }

        public void endErrorCondition(@NotNull Parser parser) {
        }

        public void reportError(@NotNull Parser parser, @Nullable RecognitionException e) throws RecognitionException {
            System.out.println("");
        }
    }

    class TestListener implements ANTLRErrorListener {

        public void syntaxError(Recognizer<?, ?> recognizer, @Nullable Object o, int i, int i1, String s, @Nullable RecognitionException e) {
            System.out.println("");
        }

        public void reportAmbiguity(@NotNull Parser parser, DFA dfa, int i, int i1, @NotNull BitSet bitSet, @NotNull ATNConfigSet atnConfigSet) {

        }

        public void reportAttemptingFullContext(@NotNull Parser parser, @NotNull DFA dfa, int i, int i1, @NotNull ATNConfigSet atnConfigSet) {

        }

        public void reportContextSensitivity(@NotNull Parser parser, @NotNull DFA dfa, int i, int i1, @NotNull ATNConfigSet atnConfigSet) {

        }
    }

    class TestErrorListener implements ANTLRErrorListener {

        private boolean fail = false;

        public boolean isFail() {
            return fail;
        }

        public void setFail(boolean fail) {
            this.fail = fail;
        }

        public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2,
                                int arg3, String arg4, RecognitionException arg5) {
            System.out.println("Dans erreur de syntaxe");
            setFail(true);
            System.out.println("Dans erreur de syntaxe");
        }

        public void reportAmbiguity(@NotNull Parser parser, DFA dfa, int i, int i1, @NotNull BitSet bitSet, @NotNull ATNConfigSet atnConfigSet) {

        }

        public void reportAttemptingFullContext(@NotNull Parser parser, @NotNull DFA dfa, int i, int i1, @NotNull ATNConfigSet atnConfigSet) {

        }

        public void reportContextSensitivity(@NotNull Parser parser, @NotNull DFA dfa, int i, int i1, @NotNull ATNConfigSet atnConfigSet) {

        }

        @Override
        public String toString() {
            return "Bonjour";
        }
    }
}
