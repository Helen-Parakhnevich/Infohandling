package com.epam.infohangling.parsers;

public abstract class AbstractParser implements Parser {

    private Parser successor;

    protected Parser getSuccessor() {
        return successor;
    }

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }
}
