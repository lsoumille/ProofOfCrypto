import antlr4.GrammarParser;
import api.AntlrAPI;
import business.Configuration;
import business.Distribution;
import business.Memory;
import business.Program;
import dt.ProbLang;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static String s2Program = "x:={0,1}";

    public static AntlrAPI api = new AntlrAPI(s2Program);

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

    //  Détermine les affectations d'ensembles aux variables qui permettront
    // d'établir les configurations au niveau suivant dans la chaîne de Markov
    public HashMap<String, List<TerminalNode>> processStates() {

        /* HashMap contenant en clé le nom de la variable, et en valeur l'ensemble affecté
        à cette variable */
        HashMap<String, List<TerminalNode>> states = new HashMap
                <String, List<org.antlr.v4.runtime.tree.TerminalNode>>();

        for (GrammarParser.CContext c : api.getProgramRoot()) {
            if (c.expr() == null) {
                /* Si on rentre dans ce cas, c'est qu'on a probablement
                affaire à une affectation d'ensemble à une variable */
                states.put(c.VAR().getText(),c.probFun().ensemble().CONST());
            } else {}
        }

        return states;
    }

    // Détermine le nombre de configurations du niveau suivant dans la chaîne de Markov
    public double nbConfigurations(HashMap<String, List<TerminalNode>> map) {

        double nb = 0.0;
        ArrayList<Double> nbs = new ArrayList<Double>();

        for (String key : map.keySet()) {

            if (map.keySet().size() == 1) {
                for (int i = 0; i < map.get(key).size(); i++) {
                    nb++;
                }
            } else {
                nb = 1.0;
                nbs.add((double) map.get(key).size());
                for (double d : nbs) {
                    nb *= d;
                }
            }
        }

        return nb;
    }

    // Calcule les probabilités sur un niveau de la chaîne de Markov
    public double calculateProba(double nbConfig) {

        return 1/nbConfig;

    }

    // The formule!
    public Distribution distributionTransformer(Distribution di, Configuration sPrime, double p) {

        Distribution df = new Distribution();
        double bigSum = 0.0;

        for (Configuration key : di.getConfigWithProbability().keySet()) {

            if (key.equals(sPrime)) {
                bigSum += di.getConfigWithProbability().get(key) * p;
                df.getConfigWithProbability().put(sPrime,bigSum);
            }
        }
        return df;
    }

    public static void main(String[] args) {
        Main m = new Main();
        //INIT
        ProbLang pl = new ProbLang();
        pl.getDF();
        System.out.println("PROGRAM ENDED");
        //Détermination des différents états de variables qui se voient affecter
        // un ensemble dans un programme
        HashMap<String,List<TerminalNode>> map = m.processStates();
        System.out.println(map);

        //Détermination du nb de différentes configurations dans le niveau suivant
        //dans la chaîne de Markov
        double nbConfig = m.nbConfigurations(map);
        System.out.println(nbConfig);

        //Calcule les proba sur un niveau
        System.out.println(m.calculateProba(nbConfig));

        //Calcul distribution

        //Set sPrime, par exemple on veut la config [x:1, y:1, z:0]
        /*Program p = new Program();
        Memory mm = new Memory();

        Set<String> varTokens = api.getVarTokens();
        for (String t : varTokens) {
            mm.getVarAndVal().put(t, 1);
            if (t.equals("z")) {
                mm.getVarAndVal().remove(t);
                mm.getVarAndVal().put(t, 0);
            }
        }
        p.setInstructions(api.getProgramRoot());
        Configuration sPrime = new Configuration(p,mm);

        System.out.println(m.distributionTransformer(m.init(), sPrime,0.25));*/
    }
}