/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.med.calculator.analysis;

import com.med.calculator.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseARightExprExpr(ARightExprExpr node);
    void caseAFactorRightExpr(AFactorRightExpr node);
    void caseAPlusRightExpr(APlusRightExpr node);
    void caseAMinusRightExpr(AMinusRightExpr node);
    void caseANegExprRightExpr(ANegExprRightExpr node);
    void caseAExprOtherExpr(AExprOtherExpr node);
    void caseANegNegExpr(ANegNegExpr node);
    void caseATermFactor(ATermFactor node);
    void caseAMultFactor(AMultFactor node);
    void caseADivFactor(ADivFactor node);
    void caseAModFactor(AModFactor node);
    void caseAPowFactor(APowFactor node);
    void caseAMultFuncFactor(AMultFuncFactor node);
    void caseADivFuncFactor(ADivFuncFactor node);
    void caseAModFuncFactor(AModFuncFactor node);
    void caseAPowFuncFactor(APowFuncFactor node);
    void caseAMultFunc2Factor(AMultFunc2Factor node);
    void caseAModFunc2Factor(AModFunc2Factor node);
    void caseADivFunc2Factor(ADivFunc2Factor node);
    void caseAPowFunc2Factor(APowFunc2Factor node);
    void caseAFunctionFactor(AFunctionFactor node);
    void caseAFunction2Factor(AFunction2Factor node);
    void caseAExprExprBloc(AExprExprBloc node);
    void caseAFunc(AFunc node);
    void caseAFunc2(AFunc2 node);
    void caseANumberTerm(ANumberTerm node);
    void caseAConstTerm(AConstTerm node);
    void caseAVarTerm(AVarTerm node);
    void caseAExprTerm(AExprTerm node);

    void caseTFunction(TFunction node);
    void caseTFunction2(TFunction2 node);
    void caseTConst(TConst node);
    void caseTVar(TVar node);
    void caseTNumber(TNumber node);
    void caseTComma(TComma node);
    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTMod(TMod node);
    void caseTPow(TPow node);
    void caseTLPar(TLPar node);
    void caseTRPar(TRPar node);
    void caseTBlank(TBlank node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}