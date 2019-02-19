package util;

import api.model.PriorityList;
import model.Element;
import model.LeftBracket;
import model.RightBracket;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PriorityAdapter {

    private HashMap<String, Integer> elements;

    public PriorityAdapter() {
        elements = new HashMap<>();
        elements.put("+", 1);
        elements.put("-", 1);
        elements.put("*", 2);
        elements.put("/", 2);
        elements.put("^", 3);
    }

    private int getPriority(Element element, int brackets) {
        int priority = 0;
        for (Map.Entry<String, Integer> entry : elements.entrySet()) {
            if (entry.getKey().equals(element.getValue())) {
                priority = brackets * 3 + entry.getValue();
                break;
            }
        }
        return priority;
    }

    public PriorityList adapt(ArrayList<Element> elements) {
        int brackets = 0;
        PriorityList result = new PriorityList();

        for (int i = 0; i < elements.size(); i++) {
            Element current = elements.get(i);
            if (current instanceof LeftBracket) {
                brackets++;
            } else if (current instanceof RightBracket) {
                brackets--;
            } else {
                result.add(current,getPriority(current, brackets));
            }
        }

        return result;

    }
}
