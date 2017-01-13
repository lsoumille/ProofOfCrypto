package dt;

import business.Configuration;
import business.Distribution;
import business.Program;

/**
 * Created by lucas on 13/01/17.
 */
public abstract class ARule {

    protected String name;

    public ARule(String name) {
        this.name = name;
    }

    public abstract void ApplyRule(Distribution distributionInput, Distribution distributionOutput/*, Configuration toProcess, Program toDoAfter*/);

    public boolean hasSameRuleWord(String s) {
        return name.equals(s);
    }
}
