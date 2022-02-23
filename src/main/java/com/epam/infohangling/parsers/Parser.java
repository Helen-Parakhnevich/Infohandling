package com.epam.infohangling.parsers;

import com.epam.infohangling.entity.text.Component;

public interface Parser {
    Component parser(String text);
}
