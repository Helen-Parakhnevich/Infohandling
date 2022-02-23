package com.epam.infohangling.parsers;

import com.epam.infohangling.entity.text.Component;
import com.epam.infohangling.entity.text.Composite;
import com.epam.infohangling.entity.PartTextType;

public class TextParser extends AbstractParser {

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parser(String text) {

        Composite composite = new Composite();
        composite.setType(PartTextType.TEXT);
        String[] parts = text.split("(?=\n)");
        for (String part : parts){
            part = part.trim();
            Component paragraph = getSuccessor().parser(part);
            composite.add(paragraph);
        }
        return  composite;
        }
}
