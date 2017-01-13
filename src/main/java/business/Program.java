package business;

import antlr4.GrammarParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 10/01/17.
 */
public class Program {

    private List<GrammarParser.CContext> instructions;

    public Program() {
        this.instructions = new ArrayList<GrammarParser.CContext>();
    }

    public List<GrammarParser.CContext> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<GrammarParser.CContext> instructions) {
        this.instructions = instructions;
    }

    public GrammarParser.CContext getFirstInstruction() {
        return instructions.get(0);
    }

    @Override
    public String toString() {
        String ret = "";
        for(GrammarParser.CContext c : instructions) {
            ret += c.getText();
        }
        return ret;
    }
}
