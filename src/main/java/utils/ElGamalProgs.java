package utils;

import api.CyclicGroupAPI;

/**
 * Created by lucas on 01/02/17.
 */
public class ElGamalProgs {

	CyclicGroupAPI cCApi;

	int x0;

	int x1;

	public ElGamalProgs(CyclicGroupAPI cCApi, int x0, int x1) {
		this.cCApi = cCApi;
		this.x0 = x0;
		this.x1 = x1;
	}

	public String getCpaEG() {
		return "q:=" + this.cCApi.getQ()
				+ ";b:={0,1};kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};kPrimeE:=" + this.cCApi.getGenerator() + "^kPrimeD%q;kE:=kPrimeE;kD:=kPrimeD;"
				+ getAdversaryCodeCPAEG();

	}

	//Deadcode
	public String getEG1() {
		return "q:=" + this.cCApi.getQ()
				+ ";b:={0,1};kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};kPrimeE:=" + this.cCApi.getGenerator() + "^kPrimeD%q;kE:=kPrimeE;"
				+ getAdversaryCodeEG1();
	}

	//Constant propagation
	public String getEG2() {
		return "q:=" + this.cCApi.getQ()
				+ ";b:={0,1};kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};kE:=" + this.cCApi.getGenerator() + "^kPrimeD%q;"
				+ getAdversaryCode();
	}

	//Deadcode
	public String getEG3() {
		return "q:=" + this.cCApi.getQ()
				+ ";b:={0,1};kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};"
				+ getAdversaryCode();
	}

	//Semantics
	public String getEG4() {
		return "q:=" + this.cCApi.getQ()
				+ ";b:={0,1};kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};r:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};" + getAdversaryCodeWithoutR();

	}

	//Swap
	public String getEG5() {
		return "q:=" + this.cCApi.getQ()
				+ ";kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};r:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};b:={0,1};"
				+ getAdversaryCodeWithoutR();

	}

	//B
	public String getDDH0() {
		return "q:=" + this.cCApi.getQ()
				+ ";kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};r:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};b:={0,1};"
				+ getAdversaryCodeWithoutR()
				+ ";d:=1;";

	}

	//inline
	public String getEGPrime() {
		return "q:=" + this.cCApi.getQ()
				+ ";kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};z:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};"
				+ getAdversaryCodePrime()
				+ "b:={0,1};";
	}

	//swap
	public String getEG1Prime() {
		return "q:=" + this.cCApi.getQ()
				+ ";kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};z:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};"
				+ "b:={0,1};"
				+ getAdversaryCodePrime();
	}

	public String getEG2Prime() {
		return "q:=" + this.cCApi.getQ()
				+ ";kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};z:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};"
				+ "b:={0,1};"
				+ getAdversaryCodePrimePad();
	}

	public String getDDH1() {
		return "q:=" + this.cCApi.getQ()
				+ ";kPrimeD:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};z:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};b:={0,1};"
				+ getAdversaryCodePrimePad()
				+ "d:=1;";
	}

	/**
	 * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
	 *
	 * @return
	 */
	private String getAdversaryCodePrime() {
		return "c:=" + this.cCApi.getGenerator() + "^z%q;";
		//the adversary can add other lines of code
	}

	/**
	 * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
	 *
	 * @return
	 */
	private String getAdversaryCodePrimePad() {
		return "if (b=0) then {calculPower:=" + this.cCApi.getGenerator() + "^z;c:=" + this.x0 + "*calculPower%q;}"
				+ " else {calculPower:=" + this.cCApi.getGenerator() + "^z;c:=" + this.x1 + "*calculPower%q;};";
		//the adversary can add other lines of code
	}

	/**
	 * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
	 *
	 * @return
	 */
	private String getAdversaryCodeCPAEG() {
		return "if (b=0) then {r:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};cUn:=" + this.cCApi.getGenerator() + "^r%q;calculPower:=" + this.cCApi.getGenerator() + "^kPrimeD^r;"
				+ "c:=" + this.x0 + "*calculPower%q;} else {"
				+ "r:={" + this.cCApi.generateValuesForBraces()
				+ "};cUn:=" + this.cCApi.getGenerator() + "^r%q;calculPower:=" + this.cCApi.getGenerator() + "^kPrimeD^r;"
				+ "c:=" + this.x1 + "*calculPower%q;}";
		//the adversary can add other lines of code
	}

	/**
	 * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
	 *
	 * @return
	 */
	private String getAdversaryCodeEG1() {
		return "if (b=0) then {r:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};calculPower:=" + this.cCApi.getGenerator() + "^kPrimeD^r;"
				+ "c:=" + this.x0 + "*calculPower%q;} else {"
				+ "r:={" + this.cCApi.generateValuesForBraces()
				+ "};calculPower:=" + this.cCApi.getGenerator() + "^kPrimeD^r;"
				+ "c:=" + this.x1 + "*calculPower%q;}";
		//the adversary can add other lines of code
	}

	/**
	 * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
	 *
	 * @return
	 */
	private String getAdversaryCode() {
		return "if (b=0) then {r:={"
				+ this.cCApi.generateValuesForBraces()
				+ "};power:=r*kPrimeD;calculPower:=" + this.cCApi.getGenerator() + "^power;"
				+ "c:=" + this.x0 + "*calculPower%q;} else {"
				+ "r:={" + this.cCApi.generateValuesForBraces()
				+ "};power:=r*kPrimeD;calculPower:=" + this.cCApi.getGenerator() + "^power;"
				+ "c:=" + this.x1 + "*calculPower%q;}";
		//the adversary can add other lines of code
	}

	private String getAdversaryCodeWithoutR() {
		return "if (b=0) then {"
				+ "power:=r*kPrimeD;calculPower:=" + this.cCApi.getGenerator() + "^power;"
				+ "c:=" + this.x0 + "*calculPower%q;} else {"
				+ "power:=r*kPrimeD;calculPower:=" + this.cCApi.getGenerator() + "^power;"
				+ "c:=" + this.x1 + "*calculPower%q;}";
		//the adversary can add other lines of code
	}
}
