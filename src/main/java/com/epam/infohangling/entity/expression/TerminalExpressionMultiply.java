package com.epam.infohangling.entity.expression;

import com.epam.infohangling.calculations.Context;
import com.epam.infohangling.entity.expression.AbstractMathExpression;

public class TerminalExpressionMultiply extends AbstractMathExpression {

    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() * context.popValue());
    }
}
