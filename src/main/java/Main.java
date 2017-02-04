import gameproof.ElGamalProver;

/**
 * Created by lucas on 05/01/17.
 */
public class Main {

    public static void main(String[] args) {
        ElGamalProver egp = new ElGamalProver();
        egp.processProof();
        /*LabProgs progs = new LabProgs();
        ProbLang test = new ProbLang(progs.getLab2Ex4P6());
        System.out.println(test.getDF());*/
        //
        //DEBUG
        //String ifEx = "x:=100;y:=countones(x);";
        //ProbLang test = new ProbLang(ifEx);
        //System.out.println("FINAL " + test.getDF());
        //DEBUG
    }
}