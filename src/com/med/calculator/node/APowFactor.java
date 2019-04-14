/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.med.calculator.node;

import com.med.calculator.analysis.*;

@SuppressWarnings("nls")
public final class APowFactor extends PFactor
{
    private PFactor _factor_;
    private TPow _pow_;
    private PTerm _term_;

    public APowFactor()
    {
        // Constructor
    }

    public APowFactor(
        @SuppressWarnings("hiding") PFactor _factor_,
        @SuppressWarnings("hiding") TPow _pow_,
        @SuppressWarnings("hiding") PTerm _term_)
    {
        // Constructor
        setFactor(_factor_);

        setPow(_pow_);

        setTerm(_term_);

    }

    @Override
    public Object clone()
    {
        return new APowFactor(
            cloneNode(this._factor_),
            cloneNode(this._pow_),
            cloneNode(this._term_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPowFactor(this);
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

    public PTerm getTerm()
    {
        return this._term_;
    }

    public void setTerm(PTerm node)
    {
        if(this._term_ != null)
        {
            this._term_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._term_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._factor_)
            + toString(this._pow_)
            + toString(this._term_);
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

        if(this._term_ == child)
        {
            this._term_ = null;
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

        if(this._term_ == oldChild)
        {
            setTerm((PTerm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
