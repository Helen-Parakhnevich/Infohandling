package com.epam.infohangling.calculations;

import com.epam.infohangling.entity.expression.AbstractExpression;
import com.epam.infohangling.entity.expression.AbstractMathExpression;
import com.epam.infohangling.entity.expression.NonTerminalExpressionNumber;
import com.epam.infohangling.entity.expression.TerminalExpressionDivide;
import com.epam.infohangling.entity.expression.TerminalExpressionMinus;
import com.epam.infohangling.entity.expression.TerminalExpressionMultiply;
import com.epam.infohangling.entity.expression.TerminalExpressionPlus;
import com.epam.infohangling.exeptions.HandledException;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Client {
    private AbstractExpression expression;
    private Context context;

    private final ArrayList<AbstractMathExpression> listExpression;

    public Client(String expression, Map<Character, Integer> variablesMap) {
        listExpression = new ArrayList<>();
        try {
            parseExpression(expression, variablesMap);
        } catch (HandledException e) {
            e.printStackTrace();
        }
    }

    private void parseExpression(String expression, Map<Character, Integer> variablesMap) throws HandledException {
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
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        Integer number = scanner.nextInt();
                        listExpression.add(new NonTerminalExpressionNumber(number));
                    } else {
                        if (variablesMap.containsKey(temp)) {
                            Integer value = variablesMap.get(temp);
                            listExpression.add(new NonTerminalExpressionNumber(value));
                        }
                    }
            }
        }
    }

    public Integer calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            try {
                terminal.interpret(context);
            } catch (HandledException e) {
                e.printStackTrace();
            }
        }
        return context.popValue();
    }
}
