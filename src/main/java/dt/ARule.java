package dt;

import business.Distribution;

/**
 * Created by lucas on 13/01/17.
 */
public abstract class ARule {

	protected String name;

	public ARule(String name) {
		this.name = name;
	}

	public abstract void ApplyRule(Distribution distributionInput, Distribution distributionOutput/*, Configuration toProcess, Program toDoAfter*/);

	public boolean hasSameRuleWord(String s) {
		return this.name.equals(s);
	}
}
