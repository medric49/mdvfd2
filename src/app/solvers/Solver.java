package app.solvers;

import com.med.mdvfd2.Vectorizable;

public interface Solver {

    Vectorizable solve(boolean multithreading);

    String getF();

    void setF(String f);

    String getG();

    void setG(String g);

    int getN();

    void setN(int n);
}
