package com.med.mdvfd2;

public class Main {
    public static void main(String[] args) {
        Vectorizable v = (new DFSolver()).solve(100, new Function() {
                    @Override
                    public double calcul(double x, double y) {
                        return 2;
                    }
                },
                new Function() {
                    @Override
                    public double calcul(double x, double y) {
                        return 0;
                    }
                });


        for (int i =0; i<v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}
