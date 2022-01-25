package com.epam.infohangling.calculations;

import com.epam.infohangling.Context;

import java.util.ArrayList;

public class Client {

    private ArrayList<AbstractMathExpression> listExpression;

    public Client(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                default:
//                    Scanner scan = new Scanner(lexeme);
//                    if (scan.hasNextInt()) {
//                        listExpression.add(
//                                new NonterminalExpressionNumber(scan.nextInt()));
//                    }
            }
        }
    }

    public Number calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}