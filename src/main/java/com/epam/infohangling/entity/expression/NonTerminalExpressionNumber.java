package com.epam.infohangling.entity.expression;

import com.epam.infohangling.calculations.Context;
import com.epam.infohangling.entity.expression.AbstractMathExpression;

public class NonTerminalExpressionNumber extends AbstractMathExpression {

    private final int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
