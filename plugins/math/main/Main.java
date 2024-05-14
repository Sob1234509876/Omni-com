package math.main;

import math.lib.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Math " + cons.__VERSION__);
        System.out.println("Vanilla plugin worked in a strange way somehow.");
        System.out.println("s(2)=" + util.s(2));
        System.out.println("sides(1, 11)=" + geo.sides(1, 11) + " A 11 dimension hypercube has 11264 edges.");
    }
}
