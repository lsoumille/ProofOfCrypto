package antlr4;// Generated from Grammar.g4 by ANTLR 4.0

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface GrammarListener extends ParseTreeListener {
	void enterWhileInst(GrammarParser.WhileInstContext ctx);

	void exitWhileInst(GrammarParser.WhileInstContext ctx);

	void enterCountones(GrammarParser.CountonesContext ctx);

	void exitCountones(GrammarParser.CountonesContext ctx);

	void enterC(GrammarParser.CContext ctx);

	void exitC(GrammarParser.CContext ctx);

	void enterProbFun(GrammarParser.ProbFunContext ctx);

	void exitProbFun(GrammarParser.ProbFunContext ctx);

	void enterPowerEnsemble(GrammarParser.PowerEnsembleContext ctx);

	void exitPowerEnsemble(GrammarParser.PowerEnsembleContext ctx);

	void enterZq(GrammarParser.ZqContext ctx);

	void exitZq(GrammarParser.ZqContext ctx);

	void enterExpr(GrammarParser.ExprContext ctx);

	void exitExpr(GrammarParser.ExprContext ctx);

	void enterEnsemble(GrammarParser.EnsembleContext ctx);

	void exitEnsemble(GrammarParser.EnsembleContext ctx);

	void enterProgram(GrammarParser.ProgramContext ctx);

	void exitProgram(GrammarParser.ProgramContext ctx);

	void enterExprBis(GrammarParser.ExprBisContext ctx);

	void exitExprBis(GrammarParser.ExprBisContext ctx);

	void enterIfInst(GrammarParser.IfInstContext ctx);

	void exitIfInst(GrammarParser.IfInstContext ctx);
}