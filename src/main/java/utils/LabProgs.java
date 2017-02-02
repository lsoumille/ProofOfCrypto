package utils;

/**
 * Created by lucas on 02/02/17.
 */
public class LabProgs {

    public String getLab2Ex1P0() {
        return "x:=1";
    }

    public String getLab2Ex1P1() {
        return "x:=3;x:=x+1;";
    }

    public String getLab2Ex1P2() {
        return "x:=0;if (x=0) then {z:=1} else {x:=x*2}";
    }

    public String getLab2Ex1P3() {
        return "x:=5;while (x>0) do {x:=x-1;}";
    }

    public String getLab2Ex1P4() {
        return "x:=1;while (x>0) do {x:=x+1;}";
    }

    public String getLab2Ex1P5(int power) {
        return "x:=" + power +";y:=2^x;while (y>0) do {y:=y-1;x:=x+1;}";
    }
}
