import api.CyclicGroupAPI;
import gameproof.ElGamalProver;
import utils.ElGamalProgs;

/**
 * Created by lucas on 05/01/17.
 */
public class Main {

    public static void main(String[] args) {
        ElGamalProver egp = new ElGamalProver();
        egp.processProof();
    }
}