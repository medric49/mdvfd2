package com.med.mdvfd2;

import com.med.test.Functions;
import com.udojava.evalex.Expression;

public class Main {
    public static void main(String[] args) {
        Vector v = Functions.constructRAforVF(new Function() {
            @Override
            public double calcul(double x, double y) {
                return y;
            }
        }, 2);
        for (int i = 0; i<v.size(); i++)
            System.out.println(v.get(i));
    }
}
