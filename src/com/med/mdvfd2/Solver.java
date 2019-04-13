package com.med.mdvfd2;

public interface Solver {
    Vectorizable solve(int n,Function g, Function f, boolean multiThreading) throws MDVFException;
}
