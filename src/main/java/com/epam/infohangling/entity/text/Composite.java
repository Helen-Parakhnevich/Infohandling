package com.epam.infohangling.entity.text;

import com.epam.infohangling.calculations.Client;
import com.epam.infohangling.entity.PartTextType;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> children;
    private PartTextType type;

    private Client client;

    public Composite() {
        children = new ArrayList<>();
    }

    public Composite(List<Component> children) {
        this.children = children;
    }

    public List<Component> getComponent() {
        return children;
    }

    public void add(Component child) {
        children.add(child);
    }

    public void setType(PartTextType type) {
        this.type = type;
    }

    @Override
    public PartTextType getType() {
        return type;
    }

    @Override
    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component child : children) {
            String value = child.getValue();
//            PartTextType partType = child.getType();
//            if (partType == PartTextType.EXPRESSION) {
//                value = value.substring(1, value.length()-1);
//                client = new Client(value);
//                stringBuilder.append(client.calculate());
//            }
//            else {
                stringBuilder.append(value);
//            }
            switch (child.getType()) {
                case WORD:
                case EXPRESSION:
                {
                    stringBuilder.append(" ");
                    break;
                }
                case PARAGRAPH: {
                    stringBuilder.append("\n\t");
                    break;
                }
                case TEXT: {
                    stringBuilder.setLength(stringBuilder.length()-3);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

}
