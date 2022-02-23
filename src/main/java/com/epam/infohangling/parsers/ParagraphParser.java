package com.epam.infohangling.parsers;

import com.epam.infohangling.entity.text.Component;
import com.epam.infohangling.entity.text.Composite;
import com.epam.infohangling.entity.PartTextType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {

    public static final String REGEX_SENTENCE = "[A-Z]*?[\\.\\!\\?]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parser(String paragraph) {

        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(paragraph);
        List<String> punctuationMark = new ArrayList<>();
        while (matcher.find()) {
            punctuationMark.add(matcher.group());
        }

        List<String> splitText = Arrays.asList(paragraph.split(REGEX_SENTENCE));

        Composite composite = new Composite();
        composite.setType(PartTextType.PARAGRAPH);
        int numberParts = splitText.size();
        for (int i = 0; i < numberParts; i++) {
            String part = splitText.get(i).trim();
            part = part + punctuationMark.get(i);
            Component sentence = getSuccessor().parser(part);
            composite.add(sentence);
        }

//        Composite composite = new Composite();
//        String[] parts = paragraph.split(REGEX_SENTENCE);
//        for (String part : parts){
//            part = part.trim();
//            Component sentence = getSuccessor().parser(part);
//            composite.add(sentence);
//        }
        return  composite;
    }
}
