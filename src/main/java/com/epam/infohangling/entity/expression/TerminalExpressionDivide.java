package com.epam.infohangling.entity.expression;

import com.epam.infohangling.calculations.Context;
import com.epam.infohangling.exeptions.HandledException;

public class TerminalExpressionDivide extends AbstractMathExpression {

    @Override
    public void interpret(Context context) throws HandledException {

        int divisor = context.popValue();
        int dividend = context.popValue();
        if (!(divisor == 0)) {
            context.pushValue(dividend / divisor);
        }
        else {
            throw new HandledException("Division by zero is undefined.");
        }
    }
}
