package com.epam.infohangling.entity.expression;

import com.epam.infohangling.calculations.Context;
import com.epam.infohangling.exeptions.HandledException;

public abstract class AbstractMathExpression {
    public abstract void interpret(Context context) throws HandledException;
}