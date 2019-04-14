package com.med.mdvfd2;

import com.udojava.evalex.Expression;

public class Main {
    public static void main(String[] args) {
        String expr = "x^2+y^2";
        int n = 20;

        Function g = new Function() {
            @Override
            public double calcul(double x, double y) {
                String e = expr.replace("x", ""+x).replace("y",""+y);

                return (new Expression(e)).eval().doubleValue();
            }
        };
        Function f = new Function() {
            @Override
            public double calcul(double x, double y) {
                return 4;
            }
        };

        long t1 = System.currentTimeMillis();
        Vectorizable v1 = (new DFSolver()).solve(n,g,f, true);
        long t2 = System.currentTimeMillis();
        long d1 = t2-t1;

        System.out.println("Temps avec multithread : "+ (d1/1000.));

        t1 = System.currentTimeMillis();
        Vectorizable v2 = (new DFSolver()).solve(n,g,f, false);
        t2 = System.currentTimeMillis();

        long d2 = t2-t1;

        System.out.println("Temps sans multithread : "+ (d2/1000.));

        System.out.println("Rapport des vitesses : " + (d2*1.)/d1);

        double s = 0;
        double s0 = 0;
        double h;
        for (int i = 0; i<n; i++) {
            h = v1.get(i) - v2.get(i);

            s += h*h;
            s0 += v2.get(i)*v2.get(i);

        }
        s = Math.sqrt(s);
        s0 = Math.sqrt(s0);

        if (s0 != 0)
            s = s/s0;
        System.out.println("Différence des resultat : " +s);

    }
}
