import api.AntlrAPI;
import business.Configuration;
import business.Distribution;
import business.Memory;
import business.Program;

import java.util.Set;

/**
 * Created by lucas on 05/01/17.
 */
public class Main {

    //C'est degueulasse mais je sais pas encore ce que je fais

    public static String simplestProgram = "x:=1;" +
            "y:={0,1,2,33};" +
            "if (x>y) then " +
            "{x:=1;z:=0;} " +
            "else " +
            "{y:=1;}";

    public static AntlrAPI api = new AntlrAPI(simplestProgram);

    //Je fabrique la distribution initiale
    public Distribution init() {
        //Create memory
        Memory m = new Memory();
        //Create Program
        Program p = new Program();
        //Create initial distribution
        Distribution d0 = new Distribution();

        //Get all initial tokens
        Set<String> varTokens = api.getVarTokens();
        //Iterate trought the tokens in order to add the var in memory
        for (String t : varTokens) {
            m.getVarAndVal().put(t, 0);
        }
        //Add the program code to the program object
        p.setInstructions(api.getProgramRoot());
        //Create configuration with the program and the memory
        Configuration c = new Configuration(p, m);
        //Add the configuration to the initial distribution
        //Because it's the initial distribution, the probability of this configuration is 1
        d0.getConfigWithProbability().put(c, 1.0);
        //return distribution
        return d0;
    }

    //  Détermine les états dans lesquels va être la configuration suivante dans la chaîne de Markov
    public String[] statesProcess(Distribution dx, Configuration si) {

        // On détermine dans cette partie les états dans lesquels va être la configuration sf
        String debutEnsemble = ":={";
        String finEnsemble = "};";
        String[] states = {};

        /* Recherche s'il y a un ensemble {} dans la configuration si
        * (Pour l'instant on considère qu'une seule variable peut avoir plusieurs états, par ex. x:={0,1}) */
        if (si.getProgram().toString().indexOf(debutEnsemble) != -1) {

            /* On stocke dans states les différents états
             * On explose par exemple la chaîne "{0,1}" en tableau ["0","1"] */
            states = si.getProgram().toString().substring(
                        si.toString().indexOf(debutEnsemble)+1,
                        si.toString().indexOf(finEnsemble)
                    ).split(",");

        } else {

            /* S'il n'y a qu'un seul état, on le met dans states quand même */
            states[0] = si.getProgram().toString().substring(
                    si.getProgram().toString().indexOf(":=")+1,
                    si.getProgram().toString().indexOf(";")
                    );
        }

        //On retourne le tableau d'états
        return states;
    }

    public static void main(String[] args) {
        Main m = new Main();
        //INIT
        System.out.println(m.init());
    }
}
