package com.epam.infohangling.parsers;

import com.epam.infohangling.Component;
import com.epam.infohangling.Composite;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {

    List<String> words = new ArrayList<>();
    List<String> expression = new ArrayList<>();

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parser(String sentence) {
        Composite composite = new Composite();
//        String[] parts = sentence.split(" ");
//        for (String part : parts){
//            Component paragraph = getSuccessor().parser(part);
//            composite.add(paragraph);
//        }
        return  composite;
    }

}
