package business;

/**
 * Created by lucas on 10/01/17.
 */
public class Configuration {

    private Program p;
    private Memory m;

    public Configuration(Program p, Memory m) {
        this.p = p;
        this.m = m;
    }

    public Program getProgram() {
        return p;
    }

    public Memory getMemory() {
        return m;
    }
}
