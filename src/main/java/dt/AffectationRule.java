package dt;

import antlr4.GrammarParser;
import business.Configuration;
import business.Distribution;
import utils.ProbFuncHelper;

import java.util.Map;

/**
 * Created by lucas on 13/01/17.
 */
public class AffectationRule extends ARule {

    public AffectationRule(Distribution distributionInput, Distribution distributionOutput, Configuration toProcess) {
        super(distributionInput, distributionOutput, toProcess);
    }

    /**
     * Apply an affectation rule on the toProcess config
     * TODO apply on all the distribution input at higher layer
     */
    public void ApplyRule() {
        //Get info about the affectation
        GrammarParser.CContext p = toProcess.getProgram().getFirstInstruction();
        //If the affectation is an expr
        if (p.expr() != null) {
            //TODO get the value of the expression
            int value = 1;
            //Affect the value in memory
            toProcess.getMemory().updateValueForVar(p.VAR().getText(), value);
            //Update probability (expression affectation is 1.0)
            double probability = 1.0 * distributionInput.getConfigWithProbability().get(toProcess);
            //Add the new configuration the distribution output
            Configuration c = new Configuration(this.toDoAfter, toProcess.getMemory());
            distributionOutput.addConfiguration(c, probability);
        } else if (p.probFun() != null) { //If the affection is a proba function
            //handle the prob func
            Map<Configuration, Double> allConfigs = ProbFuncHelper.getConfigurationForAffectation(toProcess, toDoAfter);
            for (Map.Entry<Configuration, Double> entry : allConfigs.entrySet()) {
                distributionOutput.addConfiguration(entry.getKey(), entry.getValue());
            }
        }
    }
}
