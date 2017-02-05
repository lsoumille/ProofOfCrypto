import dt.ProbLang;
import gameproof.ElGamalProver;
import utils.LabProgs;

/**
 * Created by lucas on 05/01/17.
 */
public class Main {

    public static void main(String[] args) {
        ElGamalProver egp = new ElGamalProver();
        egp.processProof(true);
        LabProgs lp = new LabProgs();
        ProbLang pl1 = new ProbLang(lp.getLab2Ex1P2());
        System.out.println(pl1.getDF());
    }
}