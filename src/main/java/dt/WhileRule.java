package dt;

import antlr4.GrammarParser;
import business.Configuration;
import business.Distribution;
import business.Memory;
import business.Program;
import utils.ExprHelper;
import utils.ProbFuncHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucas on 16/01/17.
 */
public class WhileRule extends ARule {

    public WhileRule(String name) {
        super(name);
    }

    /**
     * Apply a while rule on the toProcess config
     *
     */
    public void ApplyRule(Distribution distributionInput, Distribution distributionOutput) {
        //TODO
        //Evaluate the expression
        //If true process the block and go to evaluate expression
        //Else return the distribution
    }
}
