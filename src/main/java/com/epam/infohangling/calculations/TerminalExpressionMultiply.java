package com.epam.infohangling.calculations;

import com.epam.infohangling.Context;

public class TerminalExpressionMultiply extends AbstractMathExpression{

    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() * context.popValue());
    }
}
