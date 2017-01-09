import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.antlr.v4.runtime.ANTLRErrorListener;

import java.io.IOException;
import java.io.StringReader;
import java.util.BitSet;
import java.util.List;

/**
 * Created by lucas on 05/01/17.
 */
public class TestGrammar {

    private static final Logger logger = LoggerFactory.getLogger(TestGrammar.class);

    @Test
    public void testExploratoryString() throws IOException {

        //String simplestProgram = "sphere 12 12 12 cube 2 3 4 Bite cube 4 4 4 sphere 3 3 3";
        String simplestProgram = "x := 1;" +
                "y :={0,1,2,33};" +
                "if (x>y) then " +
                "{ x:=1;} " +
                "else " +
                "{ y:=1;}";

        CharStream inputCharStream = new ANTLRInputStream(new StringReader(simplestProgram));
        TokenSource tokenSource = new GrammarLexer(inputCharStream);
        TokenStream inputTokenStream = new CommonTokenStream(tokenSource);
        GrammarParser parser = new GrammarParser(inputTokenStream);

        parser.addErrorListener(new TestErrorListener());

        GrammarParser.ProgramContext context = parser.program();

        System.out.println(context.getText());

        logger.info(context.toString());
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
            setFail(true);
        }

        public void reportAmbiguity(@NotNull Parser parser, DFA dfa, int i, int i1, @NotNull BitSet bitSet, @NotNull ATNConfigSet atnConfigSet) {

        }

        public void reportAttemptingFullContext(@NotNull Parser parser, @NotNull DFA dfa, int i, int i1, @NotNull ATNConfigSet atnConfigSet) {

        }

        public void reportContextSensitivity(@NotNull Parser parser, @NotNull DFA dfa, int i, int i1, @NotNull ATNConfigSet atnConfigSet) {

        }

        public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2,
                                             int arg3, int arg4, ATNConfigSet arg5) {
            setFail(true);
        }

        public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2,
                                                int arg3, BitSet arg4, ATNConfigSet arg5) {
            setFail(true);
        }

        public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3,
                                    boolean arg4, BitSet arg5, ATNConfigSet arg6) {
            setFail(true);
        }
    }
}
