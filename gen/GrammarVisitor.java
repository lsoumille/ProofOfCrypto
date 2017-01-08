// Generated from /home/lucas/IdeaProjects/ProofOfCrypto/src/main/antlr4/Grammar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(GrammarParser.CContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#exprBis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBis(GrammarParser.ExprBisContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#probFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProbFun(GrammarParser.ProbFunContext ctx);
}