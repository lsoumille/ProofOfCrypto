package business;

import java.util.List;

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
		return this.p;
	}

	public Memory getMemory() {
		return this.m;
	}

	public void setP(Program p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return '<' + this.p.toString() + ',' + this.m.toString() + '>';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Configuration)) {
			return false;
		}

		Configuration that = (Configuration) o;

		if (this.p != null ? !this.p.equals(that.p) : that.p != null) {
			return false;
		}
		return this.m != null ? this.m.equals(that.m) : that.m == null;
	}

	@Override
	public int hashCode() {
		int result = this.p != null ? this.p.hashCode() : 0;
		result = 31 * result + (this.m != null ? this.m.hashCode() : 0);
		return result;
	}

	public boolean isEquivalent(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Configuration)) {
			return false;
		}

		Configuration that = (Configuration) o;

		return this.m != null ? this.m.isEquivalent(that.m) : that.m == null;
	}

	public boolean isEquivalent(Object o, List<String> vars) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Configuration)) {
			return false;
		}

		Configuration that = (Configuration) o;

		return this.m != null ? this.m.isEquivalent(that.m, vars) : that.m == null;
	}
}
