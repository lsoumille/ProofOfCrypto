package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lucas on 10/01/17.
 */
public class Memory {

	private Map<String, Integer> varAndVal;

	public Memory() {
		this.varAndVal = new HashMap<>();
	}

	public Map<String, Integer> getVarAndVal() {
		return this.varAndVal;
	}

	public void setVarAndVal(Map<String, Integer> varAndVal) {
		this.varAndVal = varAndVal;
	}

	public void updateValueForVar(String var, int value) {
		for (Map.Entry<String, Integer> entry : this.varAndVal.entrySet()) {
			if (entry.getKey().equals(var)) {
				entry.setValue(value);
				return;
			}
		}
	}

	public List<String> getCommonVars(Memory toCompare) {
		List<String> res = new ArrayList<>();
		for (String s : this.varAndVal.keySet()) {
			if (toCompare.getValForVar(s) != null) {
				res.add(s);
			}
		}
		return res;
	}

	public Integer getValForVar(String s) {
		return this.varAndVal.get(s);
	}

	@Override
	public String toString() {
		String ret = "[";
		for (Map.Entry<String, Integer> entry : this.varAndVal.entrySet()) {
			ret += entry.getKey() + ":" + entry.getValue() + ",";
		}
		return ret.substring(0, ret.length() - 1) + ']';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Memory)) {
			return false;
		}

		Memory memory = (Memory) o;

		return this.varAndVal != null ? this.varAndVal.equals(memory.varAndVal) : memory.varAndVal == null;
	}

	@Override
	public int hashCode() {
		return this.varAndVal != null ? this.varAndVal.hashCode() : 0;
	}

	public boolean isEquivalent(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Memory)) {
			return false;
		}

		Memory memory = (Memory) o;

		for (Map.Entry<String, Integer> entry : memory.getVarAndVal().entrySet()) {
			if (this.varAndVal.containsKey(entry.getKey()) && !this.varAndVal.get(entry.getKey()).equals(entry.getValue())) {
				return false;
			}
		}
		return true;
	}

	public boolean isEquivalent(Object o, List<String> vars) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Memory)) {
			return false;
		}

		Memory memory = (Memory) o;
		for (String v : vars) {
			if (!this.varAndVal.get(v).equals(memory.getValForVar(v))) {
				return false;
			}
		}
		return true;
	}
}
