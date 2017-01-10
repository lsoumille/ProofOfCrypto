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

    public static void main(String[] args) {
        Main m = new Main();
        //INIT
        System.out.println(m.init());
    }
}
