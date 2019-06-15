package com.med.test;


import com.med.mdvfd2.Vectorizable;

public interface Mesure {
    double getError(Vectorizable v1, Vectorizable v2);
}
