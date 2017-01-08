// Generated from /home/lucas/IdeaProjects/ProofOfCrypto/src/main/antlr4/Grammar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#c}.
	 * @param ctx the parse tree
	 */
	void enterC(GrammarParser.CContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#c}.
	 * @param ctx the parse tree
	 */
	void exitC(GrammarParser.CContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprBis}.
	 * @param ctx the parse tree
	 */
	void enterExprBis(GrammarParser.ExprBisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprBis}.
	 * @param ctx the parse tree
	 */
	void exitExprBis(GrammarParser.ExprBisContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#probFun}.
	 * @param ctx the parse tree
	 */
	void enterProbFun(GrammarParser.ProbFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#probFun}.
	 * @param ctx the parse tree
	 */
	void exitProbFun(GrammarParser.ProbFunContext ctx);
}