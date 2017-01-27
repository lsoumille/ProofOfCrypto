package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lucas on 10/01/17.
 */
public class Distribution {

    private Map<Configuration, Double> configWithProbability;

    public Distribution() {
        this.configWithProbability = new HashMap<Configuration, Double>();
    }

    public Distribution(Distribution d) {
        this.configWithProbability = new HashMap<Configuration, Double>(d.getConfigWithProbability());
    }

    public Map<Configuration, Double> getConfigWithProbability() {
        return configWithProbability;
    }

    public List<Configuration> getConfigurations() {
        return new ArrayList<Configuration>(configWithProbability.keySet());
    }

    public Double getProba(Configuration c) {
        return configWithProbability.get(c);
    }

    public void flush() {
        this.configWithProbability = new HashMap<>();
    }

    /**
     * Merge the configuration if they are equals else add the new configuration to the distribution
     */
    public void addConfiguration(Configuration c, Double probability) {
        for (Map.Entry<Configuration, Double> entry : configWithProbability.entrySet()) {
            if (entry.getKey().equals(c)) {
                entry.setValue(entry.getValue() + probability);
                return;
            }
        }
        configWithProbability.put(c, probability);
    }

    /**
     * Add the configurations inside the distribution
     *
     * @param multipleConf
     */
    public void addMultipleConfigurations(Map<Configuration, Double> multipleConf) {
        for (Map.Entry<Configuration, Double> entry : multipleConf.entrySet()) {
            addConfiguration(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        String ret = "Distribution {\n";
        for (Map.Entry<Configuration, Double> entry : configWithProbability.entrySet()) {
            ret += entry.getKey().toString() + " = " + entry.getValue() + "\n";
        }
        return ret + '}';
    }

    //TODO Must use a better algorithm to compare the two maps
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distribution)) return false;

        Distribution that = (Distribution) o;

        for (Map.Entry<Configuration, Double> entry : configWithProbability.entrySet()) {
            if(that.getConfigWithProbability().get(entry.getKey()) == null || !entry.getValue().equals(that.getConfigWithProbability().get(entry.getKey())))
                return false;
        }
        for (Map.Entry<Configuration, Double> entry : that.getConfigWithProbability().entrySet()) {
            if(configWithProbability.get(entry.getKey()) == null || !entry.getValue().equals(configWithProbability.get(entry.getKey())))
                return false;
        }
        return true;
    }
}
