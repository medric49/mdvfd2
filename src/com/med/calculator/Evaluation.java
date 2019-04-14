package com.med.calculator;

import com.med.calculator.analysis.DepthFirstAdapter;
import com.med.calculator.node.*;

import java.util.Hashtable;
public class Evaluation extends DepthFirstAdapter {
    private Hashtable<String,Double> register;

    public Evaluation(Hashtable<String,Double> register) {
        super();
        this.register = register;
    }



    // ==================== EVALUATION DES REGLES DE PRODUCION DE PARTIE GAUCHE 'TERM' ============================
    @Override
    public void outAVarTerm(AVarTerm node) {
        double varVal = register.get(node.getVar().toString());
        register.put(node.toString(),varVal);
    }

    @Override
    public void outANumberTerm(ANumberTerm node) {
        double numberVal = Double.parseDouble(node.getNumber().getText() );
        register.put(node.toString(),numberVal);
    }

    @Override
    public void outAExprTerm(AExprTerm node) {
        double termVal = register.get(node.getExprBloc().toString());
        register.put(node.toString(),termVal);
    }

    @Override
    public void outAExprExprBloc(AExprExprBloc node) {
        double termVal = register.get(node.getRightExpr().toString());
        register.put(node.toString(),termVal);
    }

    @Override
    public void outAConstTerm(AConstTerm node) {
        double value = 0;
        switch (node.getConst().getText()) {
            case "PI":
                value = 3.141592653589793;
                break;
            case "E":
                value = 2.718281828459045;
                break;
        }
        register.put(node.toString(),value);
    }

    // ===================== EVALUATION DES REGLES DE PRODUCTION DE PARTIE GAUCHE 'FACTOR' ==========================

    @Override
    public void outAPowFactor(APowFactor node) {
        double factorValue = register.get(node.getFactor().toString());
        double termValue = register.get(node.getTerm().toString());

        register.put(node.toString(), Math.pow(factorValue, termValue));
    }

    @Override
    public void outAPowFuncFactor(APowFuncFactor node) {
        double factorValue = register.get(node.getFactor().toString());
        double funcValue = register.get(node.getFunc().toString());

        register.put(node.toString(), Math.pow(factorValue, funcValue));
        super.outAPowFuncFactor(node);
    }

    @Override
    public void outAPowFunc2Factor(APowFunc2Factor node) {
        double factorValue = register.get(node.getFactor().toString());
        double func2Value = register.get(node.getFunc2().toString());

        register.put(node.toString(), Math.pow(factorValue, func2Value));
        super.outAPowFunc2Factor(node);
    }

    @Override
    public void outAMultFuncFactor(AMultFuncFactor node) {
        double factorVal = register.get(node.getFactor().toString());
        double funcVal = register.get(node.getFunc().toString());

        register.put(node.toString(),factorVal*funcVal);

    }

    @Override
    public void outAMultFunc2Factor(AMultFunc2Factor node) {
        double factorVal = register.get(node.getFactor().toString());
        double funcVal = register.get(node.getFunc2().toString());

        register.put(node.toString(),factorVal*funcVal);
    }

    @Override
    public void outADivFuncFactor(ADivFuncFactor node) {
        double factorVal = register.get(node.getFactor().toString());
        double funcVal = register.get(node.getFunc().toString());

        register.put(node.toString(),factorVal/funcVal);
    }

    @Override
    public void outADivFunc2Factor(ADivFunc2Factor node) {
        double factorVal = register.get(node.getFactor().toString());
        double funcVal = register.get(node.getFunc2().toString());

        register.put(node.toString(),factorVal/funcVal);
    }

    @Override
    public void outAModFuncFactor(AModFuncFactor node) {
        double factorVal = register.get(node.getFactor().toString());
        double funcVal = register.get(node.getFunc().toString());

        register.put(node.toString(),factorVal%funcVal);
    }

    @Override
    public void outAModFunc2Factor(AModFunc2Factor node) {
        double factorVal = register.get(node.getFactor().toString());
        double funcVal = register.get(node.getFunc2().toString());

        register.put(node.toString(),factorVal%funcVal);
    }

    @Override
    public void outATermFactor(ATermFactor node) {
        double termVal = register.get(node.getTerm().toString());
        register.put(node.toString(),termVal);
    }

    @Override
    public void outAMultFactor(AMultFactor node) {
        double factorVal = register.get(node.getFactor().toString());
        double termVal = register.get(node.getTerm().toString());
        register.put(node.toString(),factorVal*termVal);
    }

    @Override
    public void outADivFactor(ADivFactor node) {
        double factorVal = register.get(node.getFactor().toString());
        double termVal = register.get(node.getTerm().toString());
        register.put(node.toString(),factorVal/termVal);
    }

    @Override
    public void outAModFactor(AModFactor node) {
        double factorVal = register.get(node.getFactor().toString());
        double termVal = register.get(node.getTerm().toString());
        register.put(node.toString(),factorVal%termVal);
    }



    @Override
    public void outAFunction2Factor(AFunction2Factor node) {
        double val = register.get(node.getFunc2().toString());
        register.put(node.toString(),val);
    }

    @Override
    public void outAFunctionFactor(AFunctionFactor node) {
        double func = register.get(node.getFunc().toString());
        register.put(node.toString(),func);
    }



    // ======================= EVALUATION DES REGLES DE PRODUCTION DE PARTIE GAUCHE 'FUNC & FUNC2' =======================


    @Override
    public void outAFunc(AFunc node) {
        double factorVal = register.get(node.getExprBloc().toString());

        double result = 0;
        switch (node.getFunction().getText()) {
            case "sin":
                result = Math.sin(factorVal);
                break;
            case "cos":
                result = Math.cos(factorVal);
                break;
            case "tan":
                result = Math.tan(factorVal);
                break;
            case "ln":
                result = Math.log(factorVal);
                break;
            case "Log":
                result = Math.log10(factorVal);
                break;
            case "exp":
                result = Math.exp(factorVal);
                break;
            case "sinh":
                result = Math.sinh(factorVal);
                break;
            case "cosh":
                result = Math.cosh(factorVal);
                break;
            case "tanh":
                result = Math.tanh(factorVal);
                break;
            case "abs":
                result = Math.abs(factorVal);
                break;
            case "floor":
                result = Math.floor(factorVal);
                break;
            case "ceil":
                result = Math.ceil(factorVal);
                break;
            case "sqrt":
                result = Math.sqrt(factorVal);
                break;
            case "atan":
                result = Math.atan(factorVal);
                break;
            case "asin":
                result = Math.asin(factorVal);
                break;
            case "acos":
                result = Math.acos(factorVal);
                break;

        }
        register.put(node.toString(),result);

    }

    @Override
    public void outAFunc2(AFunc2 node) {
        double rightExprValue = register.get(node.getRightExpr().toString());
        double otherExprValue = register.get(node.getOtherExpr().toString());

        double result = 0;
        switch (node.getFunction2().getText()) {
            case "pow":
                result = Math.pow(rightExprValue,otherExprValue);
                break;
            case "max":
                result = Math.max(rightExprValue,otherExprValue);
                break;
            case "min":
                result = Math.min(rightExprValue,otherExprValue);
                break;
        }
        register.put(node.toString(),result);
    }

    // ======================= EVALUATION DES REGLES DE PRODUCTION DE PARTIE GAUCHE 'RIGHT_EXPR' =======================
    @Override
    public void outAFactorRightExpr(AFactorRightExpr node) {
        double factorVal = register.get(node.getFactor().toString());
        register.put(node.toString(),factorVal);
    }


    @Override
    public void outAPlusRightExpr(APlusRightExpr node) {
        double exprVal=  register.get(node.getRightExpr().toString());
        double factorVal = register.get(node.getFactor().toString());
        register.put(node.toString(),exprVal+factorVal);
    }

    @Override
    public void outAMinusRightExpr(AMinusRightExpr node) {
        double exprVal=  register.get(node.getRightExpr().toString());
        double negVal = register.get(node.getNegExpr().toString());
        register.put(node.toString(),exprVal+negVal);
    }

    @Override
    public void outANegExprRightExpr(ANegExprRightExpr node) {
        double negVal = register.get(node.getNegExpr().toString());
        register.put(node.toString(),negVal);
    }

    // ======================= EVALUATION DES REGLES DE PRODUCTION DE PARTIE GAUCHE 'NEG_EXPR' =========================

    @Override
    public void outANegNegExpr(ANegNegExpr node) {
        double factorValue = register.get(node.getFactor().toString());
        register.put(node.toString(),-factorValue);
    }

    // ======================= EVALUATION DES REGLES DE PRODUCTION DE PARTIE GAUCHE 'OTHER_EXPR' =======================

    @Override
    public void outAExprOtherExpr(AExprOtherExpr node) {
        double value = register.get(node.getRightExpr().toString());
        register.put(node.toString(),value);
    }


    // ======================= EVALUATION DES REGLES DE PRODUCTION DE PARTIE GAUCHE 'EXPR' =======================


    @Override
    public void outARightExprExpr(ARightExprExpr node) {
        double rightExprVal = register.get(node.getRightExpr().toString());
        register.put(node.toString(),rightExprVal);
    }

}
