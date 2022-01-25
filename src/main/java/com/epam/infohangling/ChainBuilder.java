package com.epam.infohangling;

import com.epam.infohangling.parsers.ParagraphParser;
import com.epam.infohangling.parsers.Parser;
import com.epam.infohangling.parsers.SentenceParser;
import com.epam.infohangling.parsers.TextParser;

public class ChainBuilder {

    public TextParser build() {
        return new TextParser(new ParagraphParser(new SentenceParser(null)));
    }
}
