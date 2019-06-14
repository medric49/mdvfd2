package app.solvers;

import com.med.mdvfd2.ASolver;
import com.med.mdvfd2.Function;
import com.med.mdvfd2.Pair;
import com.med.mdvfd2.Vectorizable;
import com.udojava.evalex.Expression;

public class DFSolver extends com.med.mdvfd2.DFSolver implements Solver {

    private String f;
    private String g;
    private int n;

    @Override
    public double[][] solve(boolean multithreading) {
        Function gFunction = new Function() {
            @Override
            public double calcul(double x, double y) {
                String e = g.replace("x", ""+x).replace("y",""+y);

                return (new Expression(e)).eval().doubleValue();
            }
        };

        Function fFunction = new Function() {
            @Override
            public double calcul(double x, double y) {
                String e = f.replace("x", ""+x).replace("y",""+y);
                return (new Expression(e)).eval().doubleValue();
            }
        };
        Vectorizable v = this.solve(n, gFunction, fFunction, multithreading);
        double[][] r = new double[n+2][n+2];

        Pair[] points = ASolver.getMaillage(n);
        for (int j = 0; j<n+2; j++) {
            for (int i = 0; i < n+2; i++)
            {
                if (i == 0 || i == n+1 || j == 0 || j == n+1)
                {
                    Pair point = points[i+(n+2)*j] ;
                    r[i][j] = gFunction.calcul(point.x(),point.y());
                }
                else
                    r[i][j] = v.get( i-1 + n*(j-1) );
            }

        }


        return r;
    }

    @Override
    public String getF() {
        return f;
    }

    @Override
    public void setF(String f) {
        this.f = f;
    }
    @Override
    public String getG() {
        return g;
    }
    @Override
    public void setG(String g) {
        this.g = g;
    }
    @Override
    public int getN() {
        return n;
    }
    @Override
    public void setN(int n) {
        this.n = n;
    }
}
