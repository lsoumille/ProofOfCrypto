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
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};kPrimeE:=" + cCApi.getGenerator() + "^kPrimeD%q;kE:=kPrimeE;kD:=kPrimeD;"
                + getAdversaryCodeCPAEG();

    }

    //Deadcode
    public String getEG1() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};kPrimeE:=" + cCApi.getGenerator() + "^kPrimeD%q;kE:=kPrimeE;"
                + getAdversaryCodeEG1();
    }

    //Constant propagation
    public String getEG2() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};kE:=" + cCApi.getGenerator() + "^kPrimeD%q;"
                + getAdversaryCode();
    }

    //Deadcode
    public String getEG3() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};"
                + getAdversaryCode();
    }

    //Semantics
    public String getEG4() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};r:={"
                + cCApi.generateValuesForBraces()
                + "};" + getAdversaryCodeWithoutR();

    }

    //Swap
    public String getEG5() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};r:={"
                + cCApi.generateValuesForBraces()
                + "};b:={0,1};"
                + getAdversaryCodeWithoutR();

    }

    //B
    public String getDDH0() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};r:={"
                + cCApi.generateValuesForBraces()
                + "};b:={0,1};"
                + getAdversaryCodeWithoutR() +
                ";d:=1;";

    }

    //inline
    public String getEGPrime() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};z:={"
                + cCApi.generateValuesForBraces()
                + "};"
                + getAdversaryCodePrime()
                + "b:={0,1};";
    }

    //swap
    public String getEG1Prime() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};z:={"
                + cCApi.generateValuesForBraces()
                + "};"
                + "b:={0,1};"
                + getAdversaryCodePrime();
    }

    public String getEG2Prime() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};z:={"
                + cCApi.generateValuesForBraces()
                + "};"
                + "b:={0,1};"
                + getAdversaryCodePrimePad();
    }

    public String getDDH1() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};z:={"
                + cCApi.generateValuesForBraces()
                + "};b:={0,1};"
                + getAdversaryCodePrimePad() +
                "d:=1;";
    }

    /**
     * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
     *
     * @return
     */
    private String getAdversaryCodePrime() {
        return "c:=" + cCApi.getGenerator() + "^z%q;";
        //the adversary can add other lines of code
    }

    /**
     * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
     *
     * @return
     */
    private String getAdversaryCodePrimePad() {
        return "if (b=0) then {calculPower:=" + cCApi.getGenerator() + "^z;c:=" + x0 + "*calculPower%q;}"
                + " else {calculPower:=" + cCApi.getGenerator() + "^z;c:=" + x1 + "*calculPower%q;};";
        //the adversary can add other lines of code
    }

    /**
     * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
     *
     * @return
     */
    private String getAdversaryCodeCPAEG() {
        return "if (b=0) then {r:={"
                + cCApi.generateValuesForBraces()
                + "};cUn:=" + cCApi.getGenerator() + "^r%q;calculPower:=" + cCApi.getGenerator() + "^kPrimeD^r;"
                + "c:=" + x0 + "*calculPower%q;} else {"
                + "r:={" + cCApi.generateValuesForBraces()
                + "};cUn:=" + cCApi.getGenerator() + "^r%q;calculPower:=" + cCApi.getGenerator() + "^kPrimeD^r;"
                + "c:=" + x1 + "*calculPower%q;}";
        //the adversary can add other lines of code
    }

    /**
     * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
     *
     * @return
     */
    private String getAdversaryCodeEG1() {
        return "if (b=0) then {r:={"
                + cCApi.generateValuesForBraces()
                + "};calculPower:=" + cCApi.getGenerator() + "^kPrimeD^r;"
                + "c:=" + x0 + "*calculPower%q;} else {"
                + "r:={" + cCApi.generateValuesForBraces()
                + "};calculPower:=" + cCApi.getGenerator() + "^kPrimeD^r;"
                + "c:=" + x1 + "*calculPower%q;}";
        //the adversary can add other lines of code
    }

    /**
     * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
     *
     * @return
     */
    private String getAdversaryCode() {
        return "if (b=0) then {r:={"
                + cCApi.generateValuesForBraces()
                + "};power:=r*kPrimeD;calculPower:=" + cCApi.getGenerator() + "^power;"
                + "c:=" + x0 + "*calculPower%q;} else {"
                + "r:={" + cCApi.generateValuesForBraces()
                + "};power:=r*kPrimeD;calculPower:=" + cCApi.getGenerator() + "^power;"
                + "c:=" + x1 + "*calculPower%q;}";
        //the adversary can add other lines of code
    }

    private String getAdversaryCodeWithoutR() {
        return "if (b=0) then {" +
                "power:=r*kPrimeD;calculPower:=" + cCApi.getGenerator() + "^power;"
                + "c:=" + x0 + "*calculPower%q;} else {"
                + "power:=r*kPrimeD;calculPower:=" + cCApi.getGenerator() + "^power;"
                + "c:=" + x1 + "*calculPower%q;}";
        //the adversary can add other lines of code
    }
}
