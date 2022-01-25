package com.epam.infohangling.parsers;

import com.epam.infohangling.Component;
import com.epam.infohangling.Composite;
import com.epam.infohangling.parsers.AbstractParser;
import com.epam.infohangling.parsers.Parser;

public class ParagraphParser extends AbstractParser {

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parser(String paragraph) {

        Composite composite = new Composite();
        String[] parts = paragraph.split(".");
        for (String part : parts){
            Component sentence = getSuccessor().parser(part);
            composite.add(sentence);
        }
        return  composite;
    }
}
