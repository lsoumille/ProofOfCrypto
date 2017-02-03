package api;

import antlr4.GrammarLexer;
import antlr4.GrammarParser;
import business.Distribution;
import business.Memory;
import com.google.common.base.Joiner;
import dt.ProbLang;
import exceptions.ErrorSyntaxException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import utils.Cartesian;
import utils.ExprHelper;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchValidationProcess() throws ErrorSyntaxException {
        //TO DO Check if the program does not throw an error during the parser execution
        if (this.programRoot == null) {
            this.programRoot = this.parser.program();
        }
        if (parser.getNumberOfSyntaxErrors() != 0) throw new ErrorSyntaxException("Syntax Error in the program");
    }

    /**
     * Get all the variable names
     * Used to create the initial distribution
     *
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
     *
     * @param c
     * @param res
     */
    private void recursiveTokenSearch(List<GrammarParser.CContext> c, Set<String> res) {
        for (GrammarParser.CContext context : c) {
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
     *
     * @param d0
     */
    public Distribution launchMarkovProcess(Distribution d0) {
        //If the root program isn't set else use it
        if (this.programRoot == null) {
            this.programRoot = this.parser.program();
        }
        return programRuleApplication(this.programRoot.c(), d0);
    }

    /**
     * Apply semantic rules recursively on the program (list of CCcontext) in param using the inputDistribution
     *
     * @param c
     * @param inputDistribution
     */
    private Distribution programRuleApplication(List<GrammarParser.CContext> c, Distribution inputDistribution) {
        Distribution outputDistribution = new Distribution();
        for (GrammarParser.CContext context : c) {
            //take care of the case if the token is empty
            if (context.getText().equals("") || context == null) continue;
            //clean output first
            outputDistribution = new Distribution();
            //if the c rule starts with VAR apply affectation rule
            if (context.VAR() != null) {
                ProbLang.getRuleToApply("AFFECTATION").ApplyRule(inputDistribution, outputDistribution);
            } else if (context.ifInst() != null) {
                ProbLang.getRuleToApply("IF").ApplyRule(inputDistribution, outputDistribution);
            } else if (context.whileInst() != null) {
                ProbLang.getRuleToApply("WHILE").ApplyRule(inputDistribution, outputDistribution);
            }
            //Set the new distribution for the next instruction
            inputDistribution = new Distribution(outputDistribution);
        }
        return outputDistribution;
    }

    /**
     * Return the list with the first set of instructions (program root)
     *
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
     *
     * @param c
     * @return
     */
    public static List<Integer> getAllPossibleValueProbFunc(GrammarParser.ProbFunContext c, Memory m) {
        List<Integer> iNodes = new ArrayList<Integer>();
        //Put the terminal nodes according to the prob function type
        if (c.ensemble() != null) {
            List<TerminalNode> tNodes = c.ensemble().CONST();
            //add all the value inside the braces to the return list
            for (TerminalNode n : tNodes) {
                iNodes.add(new Integer(n.getText()));
            }
        } else if (c.zq() != null) {
            int numberZq = new Integer(c.zq().CONST().getText());
            //Get all the value between 0 and numberZq - 1
            for (int i = 0; i < numberZq; ++i) {
                iNodes.add(i);
            }
        } else if (c.powerEnsemble() != null) {
            List<TerminalNode> tNodes = c.powerEnsemble().CONST();
            //Get power and remove last elem
            int power = new Integer(tNodes.get(tNodes.size() - 1).getText());
            tNodes = tNodes.subList(0, tNodes.size() - 1);
            //make all the combination for the ensemble of the power length
            //Init with the tNodes values
            List<String> list = new ArrayList<>();
            for(TerminalNode tNode : tNodes) {
                list.add(tNode.getText());
            }
            //create the list to perform the cartesian product
            List<List<String>> concatCartesianProduct = new ArrayList<>();
            for(int i = 0 ; i < power ; ++i) {
                concatCartesianProduct.add(list);
            }
            //Convert the string value in Integer
            for(List<String> s : Cartesian.product(concatCartesianProduct)){
                //concat before converting
                iNodes.add(new Integer(Joiner.on("").join(s)));
            }
        } else if (c.countones() != null) {
            //Convert int to string
            String value = m.getValForVar(c.countones().VAR().getText()).toString();
            //count the number of 1 in value
            int cpt = 0;
            for(char ch : value.toCharArray()) {
                if(ch == '1') ++cpt;
            }
            //Add the res to the
            iNodes.add(cpt);
        }
        return iNodes;
    }

    /**
     * Return the value of an expression
     *
     * @param e
     * @param m
     * @return
     */
    public static int getValueExpression(GrammarParser.ExprContext e, Memory m, int valueLeftPrec) {
        //If we've got only a constant
        if (e.CONST() != null && e.exprBis().OP() == null) {
            return new Integer(e.CONST().getText()); // return the constant value
        } else if (e.VAR() != null && e.exprBis().OP() == null) { //If we've got only a variable name
            return m.getValForVar(e.VAR().toString()); //return the variable value store in memory
        } else if (e.exprBis() != null) { //If we've got an operator
            //Get the operator
            String operator = e.exprBis().OP().getText();
            //Process the left operand if it's not a recursive call
            if(valueLeftPrec == 0) {
                //If the first operand is a VAR get the value of it
                if (e.VAR() != null) {
                    valueLeftPrec = m.getValForVar(e.VAR().toString());
                } else { //the left operand is a digit
                    valueLeftPrec = new Integer(e.CONST().getText());
                }
            }
            //Process right operand
            //The right operand is a VAR get the value of it
            int valueRight = 0;
            if (e.exprBis().expr().VAR() != null) {
                valueRight = m.getValForVar(e.exprBis().expr().VAR().toString());
            } else { // the right operand is a digit
                valueRight = new Integer(e.exprBis().expr().CONST().getText());
            }
            //If we have another expression perform a recursion
            if (e.exprBis().expr().exprBis() != null && !e.exprBis().expr().exprBis().getText().equals("")) {
                //Result of the first operation
                return getValueExpression(e.exprBis().expr(), m, ExprHelper.getValueForOperation(valueLeftPrec, operator, valueRight));
            }
            return ExprHelper.getValueForOperation(valueLeftPrec, operator, valueRight);
        }
        //default
        return 0;
    }
}
