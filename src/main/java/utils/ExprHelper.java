package utils;

import api.AntlrAPI;
import business.Configuration;

/**
 * Created by lucas on 13/01/17.
 */
public class ExprHelper {

    /**
     * Return the value of the affectation
     * @param toProcess
     * @return
     */
    public static int getValueForAffectation(Configuration toProcess) {
        return AntlrAPI.getValueExpression(toProcess.getProgram().getFirstInstruction().expr(), toProcess.getMemory());
    }
}
