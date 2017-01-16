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

    /**
     * Return the result of the expression passed in param
     *
     * TODO Multiple expression
     */
    public static int getValueForOperation(int leftOperande, String operator, int rightOperande) {
        switch (operator){
            case "+":
                return leftOperande + rightOperande;
            case "-":
                return leftOperande - rightOperande;
            case "*":
                return leftOperande * rightOperande;
            case "/":
                return leftOperande / rightOperande;
            case "=":
                return leftOperande == rightOperande ? 1 : 0;
            case "<":
                return leftOperande < rightOperande ? 1 : 0;
            case ">":
                return leftOperande > rightOperande ? 1 : 0;
        }
        //default value
        return 0;
    }
}
