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

    public void setP(Program p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return '<' + p.toString() + ',' + m.toString() + '>';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Configuration)) return false;

        Configuration that = (Configuration) o;

        if (p != null ? !p.equals(that.p) : that.p != null) return false;
        return m != null ? m.equals(that.m) : that.m == null;
    }

    @Override
    public int hashCode() {
        int result = p != null ? p.hashCode() : 0;
        result = 31 * result + (m != null ? m.hashCode() : 0);
        return result;
    }
}
