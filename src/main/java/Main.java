import antlr4.GrammarParser;
import api.AntlrAPI;
import api.CyclicGroupAPI;
import business.Configuration;
import business.Distribution;
import business.Memory;
import business.Program;
import ch.bfh.unicrypt.UniCrypt;
import ch.bfh.unicrypt.crypto.schemes.encryption.classes.ElGamalEncryptionScheme;
import ch.bfh.unicrypt.helper.factorization.SafePrime;
import ch.bfh.unicrypt.math.algebra.general.interfaces.CyclicGroup;
import ch.bfh.unicrypt.math.algebra.general.interfaces.Element;
import ch.bfh.unicrypt.math.algebra.multiplicative.classes.GStarModSafePrime;
import dt.ProbLang;
import equiv.CompareProg;
import gameproof.ElGamalProof;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.security.SecureRandom;
import java.util.*;

/**
 * Created by lucas on 05/01/17.
 */
public class Main {

    public static void main(String[] args) {
        ElGamalProof egp = new ElGamalProof();
        egp.processProof();
        //DEBUG
        //String ifEx = "x:=100;y:=countones(x);";
        //ProbLang test = new ProbLang(ifEx);
        //System.out.println("FINAL " + test.getDF());
        //DEBUG
    }
}