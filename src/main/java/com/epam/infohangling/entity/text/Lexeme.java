package com.epam.infohangling.entity.text;

import com.epam.infohangling.entity.PartTextType;

public class Lexeme implements Component {

    private String value;
    private PartTextType type;

    public Lexeme(String value, PartTextType type) {
        this.value = value;
        this.type = type;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value, PartTextType.WORD);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, PartTextType.EXPRESSION);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public PartTextType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lexeme)) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return getValue().equals(lexeme.value) && type == lexeme.type;
    }

    @Override
    public int hashCode() {
        int result = 31*type.hashCode();
        result = 31*result + value.hashCode();
        return result;
    }
}
