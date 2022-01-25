package com.epam.infohangling.calculations;

import com.epam.infohangling.Context;

public class NonterminalExpressionNumber extends AbstractMathExpression {

    private int number;

    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
