package antlr4;// Generated from Grammar.g4 by ANTLR 4.0

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface GrammarListener extends ParseTreeListener {
	void enterC(GrammarParser.CContext ctx);
	void exitC(GrammarParser.CContext ctx);

	void enterProbFun(GrammarParser.ProbFunContext ctx);
	void exitProbFun(GrammarParser.ProbFunContext ctx);

	void enterExpr(GrammarParser.ExprContext ctx);
	void exitExpr(GrammarParser.ExprContext ctx);

	void enterProgram(GrammarParser.ProgramContext ctx);
	void exitProgram(GrammarParser.ProgramContext ctx);

	void enterExprBis(GrammarParser.ExprBisContext ctx);
	void exitExprBis(GrammarParser.ExprBisContext ctx);
}