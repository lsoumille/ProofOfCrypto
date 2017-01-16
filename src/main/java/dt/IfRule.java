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
public class IfRule extends ARule {

    public IfRule(String name) {
        super(name);
    }

    /**
     * Apply an if rule on the toProcess config
     *
     */
    public void ApplyRule(Distribution distributionInput, Distribution distributionOutput) {
        //TODO
        //On each configuration, process the expression inside the if
        //if true process recursively the if block
        //if false process recursively the else block
        //Fill the distribution output
    }
}
