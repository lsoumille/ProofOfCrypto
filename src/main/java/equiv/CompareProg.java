package equiv;

import business.Program;
import dt.ProbLang;

/**
 * Created by lucas on 27/01/17.
 */
public class CompareProg {

    public static boolean areEquiv(ProbLang p1, ProbLang p2) {
        return p1.getDF().equals(p2.getDF());
    }
}
