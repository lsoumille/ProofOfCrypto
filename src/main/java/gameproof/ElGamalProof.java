package gameproof;

import api.CyclicGroupAPI;
import dt.ProbLang;
import equiv.CompareProg;
import utils.ElGamalProgs;

/**
 * Created by lucas on 01/02/17.
 */
public class ElGamalProof {

    private CyclicGroupAPI cGAPI;

    private int x0;

    private int x1;

    public ElGamalProof(CyclicGroupAPI cGAPI, int x0, int x1) {
        this.cGAPI = cGAPI;
        this.x0 = x0;
        this.x1 = x1;
    }

    public ElGamalProof() {
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

    }
}
