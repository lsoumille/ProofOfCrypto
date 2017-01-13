package dt;

import business.Configuration;
import business.Distribution;
import business.Program;

/**
 * Created by lucas on 13/01/17.
 */
public abstract class ARule {

    protected Distribution distributionInput;

    protected Distribution distributionOutput;

    protected Configuration toProcess;

    protected Program toDoAfter;

    public ARule(Distribution distributionInput, Distribution distributionOutput, Configuration toProcess) {
        this.distributionInput = distributionInput;
        this.distributionOutput = distributionOutput;
        this.toProcess = toProcess;
        this.toDoAfter = toProcess.getProgram();
        //Remove the current instruction
        this.toDoAfter.getInstructions().remove(0);
    }

    public abstract void ApplyRule();
}
