package com.epam.infohangling.parsers;

import com.epam.infohangling.calculations.Client;
import com.epam.infohangling.entity.text.Component;
import com.epam.infohangling.entity.text.Composite;
import com.epam.infohangling.entity.text.Lexeme;
import com.epam.infohangling.entity.PartTextType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    public static final String REGEX_EXPRESSION = "(\\[.*?\\])";
    public static final String REGEX_SPACE = "\\p{Blank}+";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parser(String sentence) {

        Composite composite = new Composite();
        composite.setType(PartTextType.SENTENCE);

        Pattern pattern = Pattern.compile(REGEX_EXPRESSION);
        Matcher matcher = pattern.matcher(sentence);
        List<String> opz = new ArrayList<>();
        while (matcher.find()) {
            opz.add(matcher.group());
        }

        List<String> splitText = Arrays.asList(sentence.split(REGEX_EXPRESSION));

        int numberParts = splitText.size();
        Lexeme lexeme;
        for (int i = 0; i < numberParts; i++) {
            String part = splitText.get(i).trim();
            String[] parts = part.split(REGEX_SPACE);
            for (String word : parts) {
                word = word.trim();
                lexeme = Lexeme.word(word);
                composite.add(lexeme);
            }
            if (i<numberParts-1) {
                String expression = opz.get(i);
                String resultExpression = calculateExpression(expression);
                lexeme = Lexeme.expression(resultExpression);
                composite.add(lexeme);
            }
        }
        return  composite;
    }

    private String calculateExpression(String expression) {

        expression = expression.substring(1, expression.length()-1);
        Map<Character,Integer> variablesMap = new HashMap<>();
        Client client = new Client(expression, variablesMap);

        return client.calculate().toString();

    }
}
