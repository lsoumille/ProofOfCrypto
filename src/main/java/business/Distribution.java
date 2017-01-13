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

    /**
     * Merge the configuration if they are equals else add the new configuration to the distribution
     */
    public void addConfiguration(Configuration c, Double probability) {
        for (Map.Entry<Configuration, Double> entry : configWithProbability.entrySet()) {
            //TODO override equals method for the configuration class
            if (entry.getKey().equals(c)) {
                entry.setValue(entry.getValue() * probability);
                return;
            }
        }
        configWithProbability.put(c, probability);
    }

    @Override
    public String toString() {
        String ret = "Distribution {";
        for (Map.Entry<Configuration, Double> entry : configWithProbability.entrySet()) {
            ret += entry.getKey().toString() + " = " + entry.getValue() + "\n";
        }
        return ret + '}';
    }
}
