/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.med.calculator.node;

import com.med.calculator.analysis.*;

@SuppressWarnings("nls")
public final class TVar extends Token
{
    public TVar(String text)
    {
        setText(text);
    }

    public TVar(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TVar(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTVar(this);
    }
}