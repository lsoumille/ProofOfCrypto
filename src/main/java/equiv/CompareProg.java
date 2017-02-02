package equiv;

import business.Program;
import dt.ProbLang;

import java.util.List;

/**
 * Created by lucas on 27/01/17.
 */
public class CompareProg {

    /**
     * Check observational equivalence between two probLangs
     * Using the vars that are common to the p2 and p1 programs
     * @param p1
     * @param p2
     * @return
     */
    public static boolean areEquiv(ProbLang p1, ProbLang p2) {
        return p1.getDF().equivalent(p2.getDF());
    }

    /**
     * Check observational equivalence between two problangs
     * Using the vars in params
     */
    public static boolean areEquiv(ProbLang p1, ProbLang p2, List<String> vars) {
        return p1.getDF().equivalent(p2.getDF(), vars);
    }
}
