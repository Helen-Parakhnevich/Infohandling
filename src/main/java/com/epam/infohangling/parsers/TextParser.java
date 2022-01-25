package com.epam.infohangling.parsers;

import com.epam.infohangling.Component;
import com.epam.infohangling.Composite;

public class TextParser extends AbstractParser {

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parser(String text) {

        Composite composite = new Composite();
        String[] parts = text.split("\n");
        for (String part : parts){
            Component paragraph = getSuccessor().parser(part);
            composite.add(paragraph);
        }
        return  composite;
        }
}
