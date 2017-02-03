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

    public String getLab2Ex4P0() { return "x:={0,1}3;"; }

    public String getLab2Ex4P1() { return "x:={0,1};y:={0,1};z:=3;"; }

    public String getLab2Ex4P2() { return "x:={0,1};if (x=0) then {y:={0,1};z:=0;} else {y:={0,1};z:=1;}"; }

    public String getLab2Ex4P3() { return "x:={0,1};y:={0,1};if (x=0) then {if (y=0) then {z:=0;} else {z:=2;}} else {z:=1;}"; }

    public String getLab2Ex4P4() { return "z:={0,1};x:=Z (5);"; }

    public String getLab2Ex4P5() { return "z:=0;y:=3;if (z=0) then {x:=Z (5);x:=x*y} else {x:=42}"; }

    public String getLab2Ex4P6() { return "z:=0;y:=3;if (z=0) then {x:=Z (5);x:=x*z} else {x:=42}"; }

    public String getLab2Ex4P7() { return "y:=0;x:={0,1};while (x=0) do {x:={0,1};y:={0,1};}"; }
}
