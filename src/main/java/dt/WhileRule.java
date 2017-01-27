package dt;

import antlr4.GrammarParser;
import api.AntlrAPI;
import business.Configuration;
import business.Distribution;
import business.Program;

/**
 * Created by lucas on 16/01/17.
 */
public class WhileRule extends ARule {

    public WhileRule(String name) {
        super(name);
    }

    /**
     * Apply a while rule on the toProcess config
     */
    public void ApplyRule(Distribution distributionInput, Distribution distributionOutput) {
        //TODO
        //Evaluate the expression
        //If true process the block and go to evaluate expression
        //Else return the distribution
        //Apply the rule for all the configuration in the input distribution
        for (Configuration toProcess : distributionInput.getConfigurations()) {
            //Get info about the while
            GrammarParser.CContext p = toProcess.getProgram().getFirstInstruction();
            //Create the API for the while block
            Program pWhile = new Program();
            pWhile.setInstructions(p.whileInst().program().c());
            AntlrAPI api = new AntlrAPI(p.whileInst().program().getText());
            //Create the distribution
            //Create the initial distribution with the current configuration
            Distribution d0ForBlock = new Distribution();
            Configuration cWhile = new Configuration(pWhile, toProcess.getMemory());
            //Add the configuration with the previous (inside input distribution ) proba
            d0ForBlock.addConfiguration(cWhile, distributionInput.getProba(toProcess));
            //Get the value of the expr inside the while
            int value = 0;
            //while the condition is true execute the while block and toContinue is true
            boolean toContinue = true; //VAR used to check at the end of each loop if we must stop or continue
            while ((value = AntlrAPI.getValueExpression(p.whileInst().expr(), toProcess.getMemory(), 0)) == 1 && toContinue) {
                //Launch recursion
                Distribution newDistrib = api.launchMarkovProcess(d0ForBlock);
                //Check the condition for each configuration
                for (Configuration c : newDistrib.getConfigurations()) {
                    toContinue = false;
                    //If one configuration is true then continue the execution
                    if (AntlrAPI.getValueExpression(p.whileInst().expr(), c.getMemory(), 0) == 1) {
                        toContinue = true;
                    }
                }
                //Patch the distribution for the next iteration
                if (toContinue) {
                    //Add the configurations of new distrib in the d0 distrib for the next iteration
                    d0ForBlock.flush(); //remove all the configuration inside the distribution
                    //Add the pWhile program in the new distrib in case we need to perform another loop
                    for (Configuration c : newDistrib.getConfigurations()) {
                        c.setP(pWhile);
                    }
                    d0ForBlock.addMultipleConfigurations(newDistrib.getConfigWithProbability());
                } else { //Or save the new configuration for the distribution output
                    d0ForBlock = newDistrib;
                }
            }
            distributionOutput.addMultipleConfigurations(d0ForBlock.getConfigWithProbability());
        }
    }
}
