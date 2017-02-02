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
                + getAdversaryCode();

    }

    public String getEG1() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};kPrimeE:=" + cCApi.getGenerator() + "^kPrimeD%q;kE:=kPrimeE;"
                + getAdversaryCode();
    }

    public String getEG2() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};kE:=" + cCApi.getGenerator() + "^kPrimeD%q;"
                + getAdversaryCode();
    }

    public String getEG3() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};"
                + getAdversaryCode();
    }

    public String getEG4() {
        return "q:=" + cCApi.getQ()
                + ";b:={0,1};kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};r:={"
                + cCApi.generateValuesForBraces()
                + "};" + getAdversaryCodeWithoutR();

    }

    public String getEG5() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};r:={"
                + cCApi.generateValuesForBraces()
                + "};b:={0,1};"
                + getAdversaryCodeWithoutR();

    }

    public String getDDH0() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};r:={"
                + cCApi.generateValuesForBraces()
                + "};b:={0,1};"
                + getAdversaryCodeWithoutR() +
                ";d:=0;";

    }

    public String getDDH1() {
        return "q:=" + cCApi.getQ()
                + ";kPrimeD:={"
                + cCApi.generateValuesForBraces()
                + "};r:={"
                + cCApi.generateValuesForBraces()
                + "};b:={0,1};"
                + getAdversaryCodeWithoutR() +
                ";d:=1;";
    }

    /**
     * We assume here that the adversary execute the encryption oracle one time with x0 and x1 parameters
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
