package utils;

import api.AntlrAPI;
import business.Configuration;
import business.Memory;
import business.Program;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lucas on 13/01/17.
 */
public class ProbFuncHelper {

    /**
     * Return the configuration with the associated proba for a ProbFunc
     *
     * @param toProcess
     * @return
     */
    public static Map<Configuration, Double> getConfigurationForAffectation(Configuration toProcess, Program toDoAfter) {
        List<Integer> valueInEnsemble = AntlrAPI.getAllPossibleValueProbFunc(toProcess.getProgram().getFirstInstruction().probFun());
        //Calculate the probability of each value
        double probability = 1.0 / valueInEnsemble.size();
        //Create the new configurations
        Map<Configuration, Double> res = new HashMap<Configuration, Double>();
        for (Integer v : valueInEnsemble) {
            //Update memory, need to create a new one else every configuration will share the same reference
            Memory newMemory = new Memory();
            newMemory.setVarAndVal(new HashMap<String, Integer>(toProcess.getMemory().getVarAndVal()));
            newMemory.updateValueForVar(toProcess.getProgram().getFirstInstruction().VAR().getText(), v);
            //Create new configuration
            Configuration newConf = new Configuration(toDoAfter, newMemory);
            res.put(newConf, probability);
        }
        return res;
    }
}
