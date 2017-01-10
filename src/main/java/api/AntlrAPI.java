package api;

import antlr4.GrammarLexer;
import antlr4.GrammarParser;
import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lucas on 10/01/17.
 */
public class AntlrAPI {

    private GrammarParser parser;

    public AntlrAPI(String testProgram) {
        CharStream inputCharStream = null;
        try {
            inputCharStream = new ANTLRInputStream(new StringReader(testProgram));
            TokenSource tokenSource = new GrammarLexer(inputCharStream);
            TokenStream inputTokenStream = new CommonTokenStream(tokenSource);
            this.parser = new GrammarParser(inputTokenStream);

            parser.setErrorHandler(new BailErrorStrategy());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchValidationProcess() {
        //TO DO Check if the program does not throw an error during the parser execution
    }

    /**
     * Get all the variable names
     * Used to create the initial distribution
     * @return
     */
    public Set<String> getVarTokens() {
        GrammarParser.ProgramContext context = parser.program();
        Set<String> tokens = new HashSet<String>();
        recursiveTokenSearch(context.c(), tokens);
        return tokens;
    }

    /**
     * Try all path in order to find all variable declarations
     * @param c
     * @param res
     */
    private void recursiveTokenSearch(List<GrammarParser.CContext> c, Set<String> res) {
        for(GrammarParser.CContext context : c) {
            //if the c rule starts with VAR add the token to the set
            if (context.VAR() != null) {
                res.add(context.VAR().getText());
            } else if (context.getText().startsWith("if ")) { //if c rule starts with if search in the then and the else blocks
                recursiveTokenSearch(context.program().get(0).c(), res);
                recursiveTokenSearch(context.program().get(1).c(), res);
            } else if (context.getText().startsWith("while ")) { //if c rule starts with while search in the loop block
                recursiveTokenSearch(context.program().get(0).c(), res);
            }
        }
    }

    /**
     * Return the list with the first set of instructions (program root)
     * @return
     */
    public List<GrammarParser.CContext> getProgramRoot() {
        return parser.program().c();
    }
}
