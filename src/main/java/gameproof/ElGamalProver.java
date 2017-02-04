package gameproof;

import api.CyclicGroupAPI;
import dt.ProbLang;
import equiv.CompareProg;
import utils.ElGamalProgs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 01/02/17.
 */
public class ElGamalProver {

    private CyclicGroupAPI cGAPI;

    private int x0;

    private int x1;

    public ElGamalProver(CyclicGroupAPI cGAPI, int x0, int x1) {
        this.cGAPI = cGAPI;
        this.x0 = x0;
        this.x1 = x1;
    }

    public ElGamalProver() {
        this.cGAPI = new CyclicGroupAPI(11);
        this.x0 = 1;
        this.x1 = 3;
    }

    public void processProof() {
        //Create object to have access to the ElGamal programs
        ElGamalProgs egProgs = new ElGamalProgs(cGAPI, x0, x1);

        ProbLang pl1 = new ProbLang(egProgs.getCpaEG());
        ProbLang pl2 = new ProbLang(egProgs.getEG1());
        System.out.println("Equiv CPA_EG and EG1 = " + CompareProg.areEquiv(pl1, pl2));

        ProbLang pl3 = new ProbLang(egProgs.getEG2());
        System.out.println("Equiv EG1 and EG2 = " + CompareProg.areEquiv(pl2, pl3));

        ProbLang pl4 = new ProbLang(egProgs.getEG3());
        System.out.println("Equiv EG2 and EG3 = " + CompareProg.areEquiv(pl3, pl4));

        ProbLang pl5 = new ProbLang(egProgs.getEG4());
        System.out.println("Equiv EG3 and EG4 = " + CompareProg.areEquiv(pl4, pl5));

        ProbLang pl6 = new ProbLang(egProgs.getEG5());
        System.out.println("Equiv EG4 and EG5 = " + CompareProg.areEquiv(pl5, pl6));

        ProbLang pl7 = new ProbLang(egProgs.getDDH0());
        System.out.println("Equiv EG5 and DDH0 = " + CompareProg.areEquiv(pl6, pl7));

        ProbLang pl8 = new ProbLang(egProgs.getEGPrime());
        ProbLang pl9 = new ProbLang(egProgs.getEG1Prime());
        System.out.println("Equiv EG' and EG1' = " + CompareProg.areEquiv(pl8, pl9));

        ProbLang pl10 = new ProbLang(egProgs.getEG2Prime());
        System.out.println("Equiv EG1 and EG2 = " + CompareProg.areEquiv(pl9, pl10));

        ProbLang pl11 = new ProbLang(egProgs.getDDH1());
        System.out.println("Equiv EG2 and DDH1 = " + CompareProg.areEquiv(pl10, pl11));

        List<String> varsToEqui = new ArrayList<>();
        varsToEqui.add("d");
        System.out.println("Equiv DDH0 and DDH1 with d:=1 = " + CompareProg.areEquiv(pl7, pl11, varsToEqui));
    }
}
