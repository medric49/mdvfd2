package com.med.mdvfd2;

import com.udojava.evalex.Expression;

public class Main {
    public static void main(String[] args) {
        int n = 3;

        Function g = new Function() {
            @Override
            public double calcul(double x, double y) {
                return 2;
            }
        };
        Function f = new Function() {
            @Override
            public double calcul(double x, double y) {
                return 0;
            }
        };

        Vectorizable v1 = (new VFSolver()).solve(n,g,f, true);

        System.out.println(v1.size());
    }
}
