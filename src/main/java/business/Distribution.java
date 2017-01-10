package business;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucas on 10/01/17.
 */
public class Distribution {

    private Map<Configuration, Double> configWithProbability;

    public Distribution() {
        this.configWithProbability = new HashMap<Configuration, Double>();
    }

    public Map<Configuration, Double> getConfigWithProbability() {
        return configWithProbability;
    }

    //TODO
    @Override
    public String toString() {
        return "Distribution{" +
                "configWithProbability=" + configWithProbability +
                '}';
    }
}
