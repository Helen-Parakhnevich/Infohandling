package com.epam.infohangling.parsers;

import com.epam.infohangling.Component;

public interface Parser {
    Component parser(String text);
}
