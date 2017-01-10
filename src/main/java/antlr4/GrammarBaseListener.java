package antlr4;// Generated from Grammar.g4 by ANTLR 4.0

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class GrammarBaseListener implements GrammarListener {
	@Override public void enterC(GrammarParser.CContext ctx) { }
	@Override public void exitC(GrammarParser.CContext ctx) { }

	@Override public void enterProbFun(GrammarParser.ProbFunContext ctx) { }
	@Override public void exitProbFun(GrammarParser.ProbFunContext ctx) { }

	@Override public void enterExpr(GrammarParser.ExprContext ctx) { }
	@Override public void exitExpr(GrammarParser.ExprContext ctx) { }

	@Override public void enterProgram(GrammarParser.ProgramContext ctx) { }
	@Override public void exitProgram(GrammarParser.ProgramContext ctx) { }

	@Override public void enterExprBis(GrammarParser.ExprBisContext ctx) { }
	@Override public void exitExprBis(GrammarParser.ExprBisContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}