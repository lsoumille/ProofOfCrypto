package business;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucas on 10/01/17.
 */
public class Memory {

    private Map<String, Integer> varAndVal;

    public Memory() {
        varAndVal = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getVarAndVal() {
        return varAndVal;
    }

    public void setVarAndVal(Map<String, Integer> varAndVal) {
        this.varAndVal = varAndVal;
    }

    public void updateValueForVar(String var, int value) {
        for (Map.Entry<String, Integer> entry : varAndVal.entrySet()) {
            if (entry.getKey().equals(var)) {
                entry.setValue(value);
                return;
            }
        }
    }

    public Integer getValForVar(String s) {
        return varAndVal.get(s);
    }

    @Override
    public String toString() {
        String ret = "[";
        for (Map.Entry<String, Integer> entry : varAndVal.entrySet()) {
            ret += entry.getKey() + ":" + entry.getValue() + ",";
        }
        return ret.substring(0, ret.length() - 1) + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memory)) return false;

        Memory memory = (Memory) o;

        return varAndVal != null ? varAndVal.equals(memory.varAndVal) : memory.varAndVal == null;
    }
}
