/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.med.calculator.node;

import com.med.calculator.analysis.*;

@SuppressWarnings("nls")
public final class APowFunc2Factor extends PFactor
{
    private PFactor _factor_;
    private TPow _pow_;
    private PFunc2 _func2_;

    public APowFunc2Factor()
    {
        // Constructor
    }

    public APowFunc2Factor(
        @SuppressWarnings("hiding") PFactor _factor_,
        @SuppressWarnings("hiding") TPow _pow_,
        @SuppressWarnings("hiding") PFunc2 _func2_)
    {
        // Constructor
        setFactor(_factor_);

        setPow(_pow_);

        setFunc2(_func2_);

    }

    @Override
    public Object clone()
    {
        return new APowFunc2Factor(
            cloneNode(this._factor_),
            cloneNode(this._pow_),
            cloneNode(this._func2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPowFunc2Factor(this);
    }

    public PFactor getFactor()
    {
        return this._factor_;
    }

    public void setFactor(PFactor node)
    {
        if(this._factor_ != null)
        {
            this._factor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._factor_ = node;
    }

    public TPow getPow()
    {
        return this._pow_;
    }

    public void setPow(TPow node)
    {
        if(this._pow_ != null)
        {
            this._pow_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pow_ = node;
    }

    public PFunc2 getFunc2()
    {
        return this._func2_;
    }

    public void setFunc2(PFunc2 node)
    {
        if(this._func2_ != null)
        {
            this._func2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._func2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._factor_)
            + toString(this._pow_)
            + toString(this._func2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._factor_ == child)
        {
            this._factor_ = null;
            return;
        }

        if(this._pow_ == child)
        {
            this._pow_ = null;
            return;
        }

        if(this._func2_ == child)
        {
            this._func2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._factor_ == oldChild)
        {
            setFactor((PFactor) newChild);
            return;
        }

        if(this._pow_ == oldChild)
        {
            setPow((TPow) newChild);
            return;
        }

        if(this._func2_ == oldChild)
        {
            setFunc2((PFunc2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
