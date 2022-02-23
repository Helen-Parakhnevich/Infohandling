//package com.epam.infohangling.calculations;
//
//import com.epam.infohangling.service.HandledException;
//
//import java.util.ArrayList;
//import java.util.Map;
//
//public class Client_delete {
//
//    private ArrayList<AbstractMathExpression> listExpression;
//
//    public Client_delete(String expression) {
//        listExpression = new ArrayList<>();
//        parse(expression);
//    }
//
//    private void parse(String expression, Map<String, Integer> variablesMap) throws HandledException {
//        for (String lexeme : expression.split("\\p{Blank}+")) {
//            if (lexeme.isEmpty()) {
//                continue;
//            }
//            char temp = lexeme.charAt(0);
//            switch (temp) {
//                case '+':
//                    listExpression.add(new TerminalExpressionPlus());
//                    break;
//                case '-':
//                    listExpression.add(new TerminalExpressionMinus());
//                    break;
//                case '*':
//                    listExpression.add(new TerminalExpressionMultiply());
//                    break;
//                case '/':
//                    listExpression.add(new TerminalExpressionDivide());
//                    break;
//                default:
//
//
////                  Scanner scanner = new Scanner(part);
////                      if (scanner.hasNextDouble()) {
////                           Double number = scanner.nextDouble();
////                        expressions.add(new NonTerminalExpression(number));
////                      } else {
////                          String key = scanner.next();
////                          if (parameters.containsKey(key)) {
////                              Double number = parameters.get(key);
////                              expressions.add(new NonTerminalExpression(number));
////                           } else {
////                               throw new InformationHandlingException("There is unknown variable in expression: " + key);
////                           }
////                       }
//            }
//        }
//    }
//
//    public Integer calculate() {
//        Context context = new Context();
//        for (AbstractMathExpression terminal : listExpression) {
//            try {
//                terminal.interpret(context);
//            } catch (HandledException e) {
//                e.printStackTrace();
//            }
//        }
//        return context.popValue();
//    }
//}