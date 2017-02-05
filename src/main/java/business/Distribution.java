package business;

import java.util.*;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distribution)) return false;

        Distribution that = (Distribution) o;

        for (Map.Entry<Configuration, Double> entry : configWithProbability.entrySet()) {
            if (that.getConfigWithProbability().get(entry.getKey()) == null || !entry.getValue().equals(that.getConfigWithProbability().get(entry.getKey())))
                return false;
        }
        for (Map.Entry<Configuration, Double> entry : that.getConfigWithProbability().entrySet()) {
            if (configWithProbability.get(entry.getKey()) == null || !entry.getValue().equals(configWithProbability.get(entry.getKey())))
                return false;
        }
        return true;
    }

    /**
     * Return true if the parameter is a distribution and is equivalent
     *
     * @param o
     * @return
     */
    public boolean equivalent(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distribution)) return false;

        Distribution that = (Distribution) o;
        Memory mThis = this.getConfigurations().get(0).getMemory();
        Memory mThat = that.getConfigurations().get(0).getMemory();
        return this.equivalent(that, mThat.getCommonVars(mThis));
    }

    /**
     * Return true if the parameter is a distribution and is equivalent
     * for the vars
     *
     * @param o
     * @return
     */
    public boolean equivalent(Object o, List<String> vars) {
        if (this == o) return true;
        if (!(o instanceof Distribution)) return false;

        Distribution that = (Distribution) o;
        //Calculate the probability for all the vars in the two distributions
        Map<Map.Entry<String, Integer>, Double> varWithProbThis = new HashMap<>();
        Map<Map.Entry<String, Integer>, Double> varWithProbThat = new HashMap<>();
        for (String var : vars) {
            //Calculate proba for the vars in the this object
            for (Map.Entry<Configuration, Double> eThis : this.configWithProbability.entrySet()) {
                if (eThis.getKey().getMemory().getValForVar(var) != null) {
                    Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<String, Integer>(var, eThis.getKey().getMemory().getValForVar(var));
                    if (!varWithProbThis.containsKey(entry)) {
                        varWithProbThis.put(entry, eThis.getValue());
                    } else {
                        varWithProbThis.put(entry, eThis.getValue() + varWithProbThis.get(entry));
                    }
                }
            }
            //Calculate the proba for the vars in the that object
            for (Map.Entry<Configuration, Double> eThat : that.configWithProbability.entrySet()) {
                if (eThat.getKey().getMemory().getValForVar(var) != null) {
                    Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<String, Integer>(var, eThat.getKey().getMemory().getValForVar(var));
                    if (!varWithProbThat.containsKey(entry)) {
                        varWithProbThat.put(entry, eThat.getValue());
                    } else {
                        varWithProbThat.put(entry, eThat.getValue() + varWithProbThat.get(entry));
                    }
                }
            }
        }
        //Now compare the two maps
        for (Map.Entry<Map.Entry<String, Integer>, Double> e : varWithProbThis.entrySet()) {
            if (!varWithProbThat.containsKey(e.getKey()) || !(varWithProbThat.get(e.getKey()) != e.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Set the program in param for all the configurations in the distribution
     */
    public void updateProgramForAllConfiguration(Program p) {
        for (Map.Entry<Configuration, Double> entry : this.configWithProbability.entrySet()) {
            entry.getKey().setP(p);
        }
    }
}
