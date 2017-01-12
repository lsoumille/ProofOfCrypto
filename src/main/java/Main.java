import antlr4.GrammarParser;
import api.AntlrAPI;
import business.Configuration;
import business.Distribution;
import business.Memory;
import business.Program;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
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

    public static AntlrAPI api = new AntlrAPI(simplestProgram);

    public static HashMap<String, List<TerminalNode>> states = new HashMap
            <String, List<org.antlr.v4.runtime.tree.TerminalNode>>();

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

    //  Etats dans lesquels va être la configuration suivante dans la chaîne de Markov
    public HashMap<String, List<TerminalNode>> processStates() {

        /* HashMap contenant en clé le nom de la variable, et en valeur l'ensemble affecté
        à cette variable */
        for (GrammarParser.CContext c : api.getProgramRoot()) {
            if (c.expr() == null) {
                /* Si on rentre dans ce cas, c'est qu'on a probablement
                affaire à une affectation d'ensemble à une variable */
                states.put(c.VAR().getText(),c.probFun().CONST());
            } else {}
        }

        return states;
    }

    // Détermine le nombre de configurations du niveau suivant dans la chaîne de Markov
    public int nbConfigurations(HashMap<String, List<TerminalNode>> map) {

        int nb = 0;

        for (String key : map.keySet()) {
            for (int i = 0; i < map.get(key).size(); i ++) {
                nb++;
            }
        }

        return nb;
    }

    public static void main(String[] args) {
        Main m = new Main();
        //INIT
        //System.out.println(m.init());

        //Détermination des différents états de variables qui se voient affecter
        // un ensemble dans un programme
        HashMap<String,List<TerminalNode>> map = m.processStates();
        System.out.println(map);

        //Détermination du nb de différentes configurations dans le niveau suivant
        //dans la chaîne de Markov
        System.out.println(m.nbConfigurations(map));
    }
}