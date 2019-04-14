/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.med.calculator.analysis;

import java.util.*;
import com.med.calculator.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPExpr().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inARightExprExpr(ARightExprExpr node)
    {
        defaultIn(node);
    }

    public void outARightExprExpr(ARightExprExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARightExprExpr(ARightExprExpr node)
    {
        inARightExprExpr(node);
        if(node.getRightExpr() != null)
        {
            node.getRightExpr().apply(this);
        }
        outARightExprExpr(node);
    }

    public void inAFactorRightExpr(AFactorRightExpr node)
    {
        defaultIn(node);
    }

    public void outAFactorRightExpr(AFactorRightExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFactorRightExpr(AFactorRightExpr node)
    {
        inAFactorRightExpr(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        outAFactorRightExpr(node);
    }

    public void inAPlusRightExpr(APlusRightExpr node)
    {
        defaultIn(node);
    }

    public void outAPlusRightExpr(APlusRightExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusRightExpr(APlusRightExpr node)
    {
        inAPlusRightExpr(node);
        if(node.getRightExpr() != null)
        {
            node.getRightExpr().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        outAPlusRightExpr(node);
    }

    public void inAMinusRightExpr(AMinusRightExpr node)
    {
        defaultIn(node);
    }

    public void outAMinusRightExpr(AMinusRightExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusRightExpr(AMinusRightExpr node)
    {
        inAMinusRightExpr(node);
        if(node.getRightExpr() != null)
        {
            node.getRightExpr().apply(this);
        }
        if(node.getNegExpr() != null)
        {
            node.getNegExpr().apply(this);
        }
        outAMinusRightExpr(node);
    }

    public void inANegExprRightExpr(ANegExprRightExpr node)
    {
        defaultIn(node);
    }

    public void outANegExprRightExpr(ANegExprRightExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegExprRightExpr(ANegExprRightExpr node)
    {
        inANegExprRightExpr(node);
        if(node.getNegExpr() != null)
        {
            node.getNegExpr().apply(this);
        }
        outANegExprRightExpr(node);
    }

    public void inAExprOtherExpr(AExprOtherExpr node)
    {
        defaultIn(node);
    }

    public void outAExprOtherExpr(AExprOtherExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprOtherExpr(AExprOtherExpr node)
    {
        inAExprOtherExpr(node);
        if(node.getRightExpr() != null)
        {
            node.getRightExpr().apply(this);
        }
        outAExprOtherExpr(node);
    }

    public void inANegNegExpr(ANegNegExpr node)
    {
        defaultIn(node);
    }

    public void outANegNegExpr(ANegNegExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegNegExpr(ANegNegExpr node)
    {
        inANegNegExpr(node);
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        outANegNegExpr(node);
    }

    public void inATermFactor(ATermFactor node)
    {
        defaultIn(node);
    }

    public void outATermFactor(ATermFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATermFactor(ATermFactor node)
    {
        inATermFactor(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outATermFactor(node);
    }

    public void inAMultFactor(AMultFactor node)
    {
        defaultIn(node);
    }

    public void outAMultFactor(AMultFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultFactor(AMultFactor node)
    {
        inAMultFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outAMultFactor(node);
    }

    public void inADivFactor(ADivFactor node)
    {
        defaultIn(node);
    }

    public void outADivFactor(ADivFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivFactor(ADivFactor node)
    {
        inADivFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outADivFactor(node);
    }

    public void inAModFactor(AModFactor node)
    {
        defaultIn(node);
    }

    public void outAModFactor(AModFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModFactor(AModFactor node)
    {
        inAModFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getMod() != null)
        {
            node.getMod().apply(this);
        }
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outAModFactor(node);
    }

    public void inAPowFactor(APowFactor node)
    {
        defaultIn(node);
    }

    public void outAPowFactor(APowFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPowFactor(APowFactor node)
    {
        inAPowFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getPow() != null)
        {
            node.getPow().apply(this);
        }
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outAPowFactor(node);
    }

    public void inAMultFuncFactor(AMultFuncFactor node)
    {
        defaultIn(node);
    }

    public void outAMultFuncFactor(AMultFuncFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultFuncFactor(AMultFuncFactor node)
    {
        inAMultFuncFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getFunc() != null)
        {
            node.getFunc().apply(this);
        }
        outAMultFuncFactor(node);
    }

    public void inADivFuncFactor(ADivFuncFactor node)
    {
        defaultIn(node);
    }

    public void outADivFuncFactor(ADivFuncFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivFuncFactor(ADivFuncFactor node)
    {
        inADivFuncFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getFunc() != null)
        {
            node.getFunc().apply(this);
        }
        outADivFuncFactor(node);
    }

    public void inAModFuncFactor(AModFuncFactor node)
    {
        defaultIn(node);
    }

    public void outAModFuncFactor(AModFuncFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModFuncFactor(AModFuncFactor node)
    {
        inAModFuncFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getMod() != null)
        {
            node.getMod().apply(this);
        }
        if(node.getFunc() != null)
        {
            node.getFunc().apply(this);
        }
        outAModFuncFactor(node);
    }

    public void inAPowFuncFactor(APowFuncFactor node)
    {
        defaultIn(node);
    }

    public void outAPowFuncFactor(APowFuncFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPowFuncFactor(APowFuncFactor node)
    {
        inAPowFuncFactor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getPow() != null)
        {
            node.getPow().apply(this);
        }
        if(node.getFunc() != null)
        {
            node.getFunc().apply(this);
        }
        outAPowFuncFactor(node);
    }

    public void inAMultFunc2Factor(AMultFunc2Factor node)
    {
        defaultIn(node);
    }

    public void outAMultFunc2Factor(AMultFunc2Factor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultFunc2Factor(AMultFunc2Factor node)
    {
        inAMultFunc2Factor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getFunc2() != null)
        {
            node.getFunc2().apply(this);
        }
        outAMultFunc2Factor(node);
    }

    public void inAModFunc2Factor(AModFunc2Factor node)
    {
        defaultIn(node);
    }

    public void outAModFunc2Factor(AModFunc2Factor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModFunc2Factor(AModFunc2Factor node)
    {
        inAModFunc2Factor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getMod() != null)
        {
            node.getMod().apply(this);
        }
        if(node.getFunc2() != null)
        {
            node.getFunc2().apply(this);
        }
        outAModFunc2Factor(node);
    }

    public void inADivFunc2Factor(ADivFunc2Factor node)
    {
        defaultIn(node);
    }

    public void outADivFunc2Factor(ADivFunc2Factor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivFunc2Factor(ADivFunc2Factor node)
    {
        inADivFunc2Factor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getFunc2() != null)
        {
            node.getFunc2().apply(this);
        }
        outADivFunc2Factor(node);
    }

    public void inAPowFunc2Factor(APowFunc2Factor node)
    {
        defaultIn(node);
    }

    public void outAPowFunc2Factor(APowFunc2Factor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPowFunc2Factor(APowFunc2Factor node)
    {
        inAPowFunc2Factor(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        if(node.getPow() != null)
        {
            node.getPow().apply(this);
        }
        if(node.getFunc2() != null)
        {
            node.getFunc2().apply(this);
        }
        outAPowFunc2Factor(node);
    }

    public void inAFunctionFactor(AFunctionFactor node)
    {
        defaultIn(node);
    }

    public void outAFunctionFactor(AFunctionFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunctionFactor(AFunctionFactor node)
    {
        inAFunctionFactor(node);
        if(node.getFunc() != null)
        {
            node.getFunc().apply(this);
        }
        outAFunctionFactor(node);
    }

    public void inAFunction2Factor(AFunction2Factor node)
    {
        defaultIn(node);
    }

    public void outAFunction2Factor(AFunction2Factor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunction2Factor(AFunction2Factor node)
    {
        inAFunction2Factor(node);
        if(node.getFunc2() != null)
        {
            node.getFunc2().apply(this);
        }
        outAFunction2Factor(node);
    }

    public void inAExprExprBloc(AExprExprBloc node)
    {
        defaultIn(node);
    }

    public void outAExprExprBloc(AExprExprBloc node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprExprBloc(AExprExprBloc node)
    {
        inAExprExprBloc(node);
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getRightExpr() != null)
        {
            node.getRightExpr().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        outAExprExprBloc(node);
    }

    public void inAFunc(AFunc node)
    {
        defaultIn(node);
    }

    public void outAFunc(AFunc node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunc(AFunc node)
    {
        inAFunc(node);
        if(node.getFunction() != null)
        {
            node.getFunction().apply(this);
        }
        if(node.getExprBloc() != null)
        {
            node.getExprBloc().apply(this);
        }
        outAFunc(node);
    }

    public void inAFunc2(AFunc2 node)
    {
        defaultIn(node);
    }

    public void outAFunc2(AFunc2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunc2(AFunc2 node)
    {
        inAFunc2(node);
        if(node.getFunction2() != null)
        {
            node.getFunction2().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getRightExpr() != null)
        {
            node.getRightExpr().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getOtherExpr() != null)
        {
            node.getOtherExpr().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        outAFunc2(node);
    }

    public void inANumberTerm(ANumberTerm node)
    {
        defaultIn(node);
    }

    public void outANumberTerm(ANumberTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumberTerm(ANumberTerm node)
    {
        inANumberTerm(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumberTerm(node);
    }

    public void inAConstTerm(AConstTerm node)
    {
        defaultIn(node);
    }

    public void outAConstTerm(AConstTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConstTerm(AConstTerm node)
    {
        inAConstTerm(node);
        if(node.getConst() != null)
        {
            node.getConst().apply(this);
        }
        outAConstTerm(node);
    }

    public void inAVarTerm(AVarTerm node)
    {
        defaultIn(node);
    }

    public void outAVarTerm(AVarTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarTerm(AVarTerm node)
    {
        inAVarTerm(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarTerm(node);
    }

    public void inAExprTerm(AExprTerm node)
    {
        defaultIn(node);
    }

    public void outAExprTerm(AExprTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprTerm(AExprTerm node)
    {
        inAExprTerm(node);
        if(node.getExprBloc() != null)
        {
            node.getExprBloc().apply(this);
        }
        outAExprTerm(node);
    }
}
