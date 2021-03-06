/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.med.calculator.node;

import com.med.calculator.analysis.*;

@SuppressWarnings("nls")
public final class AModFuncFactor extends PFactor
{
    private PFactor _factor_;
    private TMod _mod_;
    private PFunc _func_;

    public AModFuncFactor()
    {
        // Constructor
    }

    public AModFuncFactor(
        @SuppressWarnings("hiding") PFactor _factor_,
        @SuppressWarnings("hiding") TMod _mod_,
        @SuppressWarnings("hiding") PFunc _func_)
    {
        // Constructor
        setFactor(_factor_);

        setMod(_mod_);

        setFunc(_func_);

    }

    @Override
    public Object clone()
    {
        return new AModFuncFactor(
            cloneNode(this._factor_),
            cloneNode(this._mod_),
            cloneNode(this._func_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAModFuncFactor(this);
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

    public TMod getMod()
    {
        return this._mod_;
    }

    public void setMod(TMod node)
    {
        if(this._mod_ != null)
        {
            this._mod_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mod_ = node;
    }

    public PFunc getFunc()
    {
        return this._func_;
    }

    public void setFunc(PFunc node)
    {
        if(this._func_ != null)
        {
            this._func_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._func_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._factor_)
            + toString(this._mod_)
            + toString(this._func_);
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

        if(this._mod_ == child)
        {
            this._mod_ = null;
            return;
        }

        if(this._func_ == child)
        {
            this._func_ = null;
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

        if(this._mod_ == oldChild)
        {
            setMod((TMod) newChild);
            return;
        }

        if(this._func_ == oldChild)
        {
            setFunc((PFunc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
