package dt;

import antlr4.GrammarParser;
import antlr4.GrammarParser.CContext;
import api.AntlrAPI;
import business.Configuration;
import business.Distribution;
import business.Memory;
import business.Program;
import utils.ExprHelper;
import utils.ProbFuncHelper;

import java.util.HashMap;
import java.util.List;
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
        //Apply the rule for all the configuration in the input distribution
        for(Configuration toProcess : distributionInput.getConfigurations()){
            //Get info about the if
            CContext p = toProcess.getProgram().getFirstInstruction();
            //Get the value of the expr inside the if
            int value = AntlrAPI.getValueExpression(p.ifInst().expr(), toProcess.getMemory());
            Program pIf = new Program();
            AntlrAPI api = null;
            if (value == 1) { //equivalent to the expression inside if equals to true
                //Create the configuration with if block
                pIf.setInstructions(p.ifInst().program(0).c());
                //Create a new api on the if block
                api = new AntlrAPI(p.ifInst().program(0).getText());
            } else { //equivalent to the expression inside if equals to false
                pIf.setInstructions(p.ifInst().program(1).c());
                //Create a new api on the else block
                api = new AntlrAPI(p.ifInst().program(1).getText());
            }
            //Create the initial distribution with the current configuration
            Distribution d0ForBlock = new Distribution();
            Configuration cIf = new Configuration(pIf, toProcess.getMemory());
            //Add the configuration with the previous (inside input distribution ) proba
            d0ForBlock.addConfiguration(cIf, distributionInput.getProba(toProcess));
            //Launch recursion
            Distribution newDistrib = api.launchMarkovProcess(d0ForBlock);
            //Add the configurations of new distrib in the output distribution
            distributionOutput.addMultipleConfigurations(newDistrib.getConfigWithProbability());
        }
    }
}
