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
}
