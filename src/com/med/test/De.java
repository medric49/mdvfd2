package com.med.test;

import com.med.mdvfd2.Function;

public class De {
    private Function f;
    private Function g;
    private int n;

    public Function getF() {
        return f;
    }

    public void setF(Function f) {
        this.f = f;
    }

    public Function getG() {
        return g;
    }

    public void setG(Function g) {
        this.g = g;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public De(int n, Function g, Function f) {

        this.f = f;
        this.g = g;
        this.n = n;
    }
}
