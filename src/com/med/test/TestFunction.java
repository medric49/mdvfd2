package com.med.test;

import com.med.mdvfd2.Solver;
import com.med.mdvfd2.Vectorizable;

public interface TestFunction {
    Vectorizable getRO(Solver f, De de);
}
