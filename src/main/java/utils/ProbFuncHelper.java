package utils;

import api.AntlrAPI;
import business.Configuration;
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
     * @param toProcess
     * @return
     */
    public static Map<Configuration, Double> getConfigurationForAffectation(Configuration toProcess, Program toDoAfter) {
        List<Integer> valueInEnsemble = AntlrAPI.getAllPossibleValueProbFunc(toProcess.getProgram().getFirstInstruction().probFun());
        //Calculate the probability of each value
        double probability = 1.0 / valueInEnsemble.size();
        //Create the new configurations
        Map<Configuration, Double> res = new HashMap<Configuration, Double>();
        for(Integer v : valueInEnsemble) {
            //Update memory
            toProcess.getMemory().updateValueForVar(toProcess.getProgram().getFirstInstruction().VAR().getText(), v);
            Configuration newConf = new Configuration(toDoAfter, toProcess.getMemory());
            res.put(newConf, probability);
        }
        return res;
    }
}
