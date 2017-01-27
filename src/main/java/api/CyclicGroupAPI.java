package api;

import ch.bfh.unicrypt.math.algebra.multiplicative.classes.GStarModSafePrime;

/**
 * Created by lucas on 27/01/17.
 */
public class CyclicGroupAPI {

    private long q;

    private int generator;

    public CyclicGroupAPI(long qVal) {
        this.q = qVal;
        this.generator = GStarModSafePrime.getInstance(q).getDefaultGenerator().convertToBigInteger().intValue();
    }

    public int getGenerator() {
        return this.generator;
    }

    public long getQ() {
        return q;
    }

    /**
     * Get all the values between 1 and (q value - 1) in order to fit a braces function
     * @return
     */
    public String generateValuesForBraces() {
        String res = "";
        for(int i = 1 ; i < (this.q - 1) ; ++i) {
            res += (i + ",");
        }
        return res.substring(0, res.length() - 1);
    }
}
