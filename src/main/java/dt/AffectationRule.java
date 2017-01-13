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
 * Created by lucas on 13/01/17.
 */
public class AffectationRule extends ARule {

    public AffectationRule(String name) {
        super(name);
    }

    /**
     * Apply an affectation rule on the toProcess config
     *
     */
    public void ApplyRule(Distribution distributionInput, Distribution distributionOutput/*, Configuration toProcess, Program toDoAfter*/) {
        //Apply the rule for all the configuration in the input distribution
        for(Configuration toProcess : distributionInput.getConfigurations()){
            //Get info about the affectation
            GrammarParser.CContext p = toProcess.getProgram().getFirstInstruction();
            //remove the current instruction from the configuration
            Program toDoAfter = toProcess.getProgram().getNextInstructions();
            //If the affectation is an expr
            if (p.expr() != null) {
                int value = ExprHelper.getValueForAffectation(toProcess);
                //Affect the value in memory, need to create a new one else every configuration will share the same reference
                Memory newMemory = new Memory();
                newMemory.setVarAndVal(new HashMap<String, Integer>(toProcess.getMemory().getVarAndVal()));
                newMemory.updateValueForVar(toProcess.getProgram().getFirstInstruction().VAR().getText(), value);
                //Update probability (expression affectation is 1.0)
                double probability = 1.0 * distributionInput.getConfigWithProbability().get(toProcess);
                //Add the new configuration the distribution output
                Configuration c = new Configuration(toDoAfter, newMemory);
                distributionOutput.addConfiguration(c, probability);
            } else if (p.probFun() != null) { //If the affection is a proba function
                //handle the prob func
                Map<Configuration, Double> allConfigs = ProbFuncHelper.getConfigurationForAffectation(toProcess, toDoAfter);
                for (Map.Entry<Configuration, Double> entry : allConfigs.entrySet()) {
                    //multiply with the proba of the previous configuraiton
                    double probability = entry.getValue() * distributionInput.getConfigWithProbability().get(toProcess);
                    distributionOutput.addConfiguration(entry.getKey(), probability);
                }
            }
        }

    }
}
