package com.med.mdvfd2;

public abstract class ASolver implements Solver {

    public static Pair[] getMaillage(int n) {
        double s1 = 0;
        double s2 = 0;

        Pair[] v = new Pair[ (n+2) *(n+2) ];

        double h = 1./(n+1);
        for (int j =0; j<n+2; j++) {
            for (int i = 0; i<n+2;i++) {
                v[i+(n+2)*j] = new Pair(s1, s2);
                s1+=h;
            }
            s1 = 0;
            s2+= h;
        }
        return v;
    }

    public static Pair[] getVolumes(int n) {
        return getMaillage(n);
    }

    public static Pair[] getVolumesPoints(int n) {
        double s1 = 0;
        double s2 = 0;
        Pair[] v = new Pair[ (n+3) *(n+3) ];
        double h = 1./(n+1);
        for (int j=0; j<n+3; j++) {
            for (int i = 0; i<n+3;i++) {
                v[i+(n+3)*j] = new Pair(s1, s2);
                if (i ==0 || i== n+1 )
                    s1+= h/2;
                else
                    s1+=h;
            }
            s1 = 0;
            if (j == 0 || j== n+1)
                s2+= h/2;
            else
                s2+= h;
        }
        return v;
    }

}
