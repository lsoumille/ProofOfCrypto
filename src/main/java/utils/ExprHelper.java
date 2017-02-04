package utils;

import api.AntlrAPI;
import business.Configuration;

/**
 * Created by lucas on 13/01/17.
 */
public class ExprHelper {

	/**
	 * Return the value of the affectation
	 *
	 * @param toProcess
	 * @return
	 */
	public static int getValueForAffectation(Configuration toProcess) {
		return AntlrAPI.getValueExpression(toProcess.getProgram().getFirstInstruction().expr(), toProcess.getMemory(), 0);
	}

	/**
	 * Return the result of the expression passed in param 24/01 add pow and modulo
	 *
	 * @param leftOperande
	 * @param operator
	 * @param rightOperande
	 * @return
	 */
	public static int getValueForOperation(int leftOperande, String operator, int rightOperande) {
		switch (operator) {
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
			case "%":
				return Math.floorMod(leftOperande, rightOperande); //leftOperande % rightOperande;
			case "^":
				return (int) Math.pow((new Integer(leftOperande)).doubleValue(), (new Integer(rightOperande).doubleValue()));
		}
		//default value
		return 0;
	}
}
