package app.solvers;

import com.med.mdvfd2.Function;
import com.med.mdvfd2.Vectorizable;
import com.udojava.evalex.Expression;

public class VFSolver extends com.med.mdvfd2.VFSolver implements Solver {

    private String f;
    private String g;
    private int n;

    @Override
    public Vectorizable solve(boolean multithreading) {
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

        return this.solve(n, gFunction, fFunction, multithreading);
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
