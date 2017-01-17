package api;

import antlr4.GrammarLexer;
import antlr4.GrammarParser;
import business.Distribution;
import business.Memory;
import business.Program;
import dt.ProbLang;
import exceptions.ErrorSyntaxException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import utils.ExprHelper;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lucas on 10/01/17.
 */
public class AntlrAPI {

    private GrammarParser parser;

    private GrammarParser.ProgramContext programRoot;

    public AntlrAPI(String testProgram) {
        CharStream inputCharStream = null;
        try {
            inputCharStream = new ANTLRInputStream(new StringReader(testProgram));
            TokenSource tokenSource = new GrammarLexer(inputCharStream);
            TokenStream inputTokenStream = new CommonTokenStream(tokenSource);
            this.parser = new GrammarParser(inputTokenStream);

            parser.addErrorListener(new DiagnosticErrorListener());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchValidationProcess() throws ErrorSyntaxException {
        //TO DO Check if the program does not throw an error during the parser execution
        if (this.programRoot == null) {
            this.programRoot = this.parser.program();
        }
        if(parser.getNumberOfSyntaxErrors() != 0) throw new ErrorSyntaxException("Syntax Error in the program");
    }

    /**
     * Get all the variable names
     * Used to create the initial distribution
     * @return
     */
    public Set<String> getVarTokens() {
        //If the root program isn't set else use it
        if (this.programRoot == null) {
            this.programRoot = this.parser.program();
        }
        Set<String> tokens = new HashSet<String>();
        recursiveTokenSearch(this.programRoot.c(), tokens);
        return tokens;
    }

    /**
     * Try all path in order to find all variable declarations
     * @param c
     * @param res
     *
     */
    private void recursiveTokenSearch(List<GrammarParser.CContext> c, Set<String> res) {
        for(GrammarParser.CContext context : c) {
            //if the c rule starts with VAR add the token to the set
            if (context.VAR() != null) {
                res.add(context.VAR().getText());
            } else if (context.ifInst() != null) { //if c rule starts with if search in the then and the else blocks
                recursiveTokenSearch(context.ifInst().program(0).c(), res);
                recursiveTokenSearch(context.ifInst().program(1).c(), res);
            } else if (context.whileInst() != null) { //if c rule starts with while search in the loop block
                recursiveTokenSearch(context.whileInst().program().c(), res);
            }
        }
    }

    /**
     * Launch the program analysis
     * @param d0
     */
    public Distribution launchMarkovProcess(Distribution d0) {
        //If the root program isn't set else use it
        if (this.programRoot == null) {
            this.programRoot = this.parser.program();
        }
        return recursiveRuleApplication(this.programRoot.c(), d0);
    }

    /**
     * Apply semantic rules recursively on the program (list of CCcontext) in param using the inputDistribution
     * @param c
     * @param inputDistribution
     */
    private Distribution recursiveRuleApplication(List<GrammarParser.CContext> c, Distribution inputDistribution) {
        Distribution outputDistribution = new Distribution();
        for(GrammarParser.CContext context : c) {
            //take care of the case if the token is empty
            if(context.getText().equals("") || context == null) continue;
            //clean output first
            outputDistribution = new Distribution();
            //if the c rule starts with VAR apply affectation rule
            if (context.VAR() != null) {
                ProbLang.getRuleToApply("AFFECTATION").ApplyRule(inputDistribution, outputDistribution);
            } else if (context.ifInst() != null) {
                ProbLang.getRuleToApply("IF").ApplyRule(inputDistribution, outputDistribution);
            }
            //Set the new distribution for the next instruction
            inputDistribution = new Distribution(outputDistribution);
        }
        System.out.println(outputDistribution);
        return outputDistribution;
    }

    /**
     * Return the list with the first set of instructions (program root)
     * @return
     */
    public List<GrammarParser.CContext> getProgramRoot() {
        if (this.programRoot == null) {
            this.programRoot = this.parser.program();
        }
        return this.programRoot.c();
    }

    /**
     * return all the possible value that can give the random pick on a { } or Zq
     * @param c
     * @return
     */
    public static List<Integer> getAllPossibleValueProbFunc(GrammarParser.ProbFunContext c) {
        List<Integer> iNodes = new ArrayList<Integer>();
        //Put the terminal nodes according to the prob function type
        if (c.ensemble() != null) {
            List<TerminalNode> tNodes = c.ensemble().CONST();
            //add all the value inside the braces to the return list
            for(TerminalNode n : tNodes) {
                iNodes.add(new Integer(n.getText()));
            }
        } else if (c.zq() != null) {
            int numberZq = new Integer(c.zq().CONST().getText());
            //Get all the value between 0 and numberZq - 1
            for(int i = 0 ; i < numberZq ; ++i) {
                iNodes.add(i);
            }
        }
        return iNodes;
    }

    /**
     * Return the value of an expression
     * @param e
     * @param m
     * @return
     */
    public static int getValueExpression(GrammarParser.ExprContext e, Memory m) {
        //If we've got only a constant
        if(e.CONST() != null && e.exprBis().OP() == null) {
            return new Integer(e.CONST().getText()); // return the constant value
        } else if (e.VAR() != null && e.exprBis().OP() == null) { //If we've got only a variable name
            return m.getValForVar(e.VAR().toString()); //return the variable value store in memory
        } else if (e.exprBis() != null) { //If we've got an operator
            //Get the operator
            String operator = e.exprBis().OP().getText();
            //Process the left operand
            //If the first operand is a VAR get the value of it
            int valueLeft = 0;
            if (e.VAR() != null) {
                valueLeft = m.getValForVar(e.VAR().toString());
            } else { //the left operand is a digit
                valueLeft = new Integer(e.CONST().getText());
            }
            //Process right operand
            //The right operand is a VAR get the value of it
            int valueRight = 0;
            if (e.exprBis().expr().VAR() != null) {
                valueRight = m.getValForVar(e.exprBis().expr().VAR().toString());
            } else { // the right operand is a digit
                valueRight = new Integer(e.exprBis().expr().CONST().getText());
            }
            return ExprHelper.getValueForOperation(valueLeft, operator, valueRight);
        }
        //default
        return 0;
    }
}
