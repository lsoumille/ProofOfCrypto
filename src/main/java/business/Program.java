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

    public void setInstructions(Program p) {
        this.instructions = p.getInstructions();
    }

    public void setInstructions(List<GrammarParser.CContext> instructions) {
        this.instructions = instructions;
    }

    public GrammarParser.CContext getFirstInstruction() {
        if (instructions.size() == 0) {
            return null;
        }
        return instructions.get(0);
    }

    /**
     * Remove the first instruction of the list == toDoAfter
     * and create a deep copy
     */
    public Program getNextInstructions() {
        Program toDoAfter = new Program();
        List<GrammarParser.CContext> newInstructions = new ArrayList<GrammarParser.CContext>();
        for (int i = 1; i < instructions.size(); ++i) {
            newInstructions.add(instructions.get(i));
        }
        toDoAfter.setInstructions(newInstructions);
        return toDoAfter;
    }

    @Override
    public String toString() {
        String ret = "";
        for (GrammarParser.CContext c : instructions) {
            ret += c.getText();
        }
        return ret.equals("") ? "TICK" : ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Program)) return false;

        Program program = (Program) o;

        String thisInstInStr = this.toString();
        String paramInstInStr = program.toString();
        return thisInstInStr.equals(paramInstInStr);
    }

    @Override
    public int hashCode() {
        return instructions != null || instructions.isEmpty() ? this.toString().hashCode() : 0;
    }
}
