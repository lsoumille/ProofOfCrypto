package equiv;

import business.Program;
import dt.ProbLang;

/**
 * Created by lucas on 27/01/17.
 */
public class CompareProg {

    /**
     * Check observational equivalence between two probLangs
     * @param p1
     * @param p2
     * @return
     */
    public static boolean areEquiv(ProbLang p1, ProbLang p2) {
        return p1.getDF().equivalent(p2.getDF());
    }
}
