package generator;

/**
 * Created by mrfiskerton on 25.01.2018.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Node {
    private String name;
    private String returnType = "void";
    private List<Element> elementList = new ArrayList<>();

    private List<String> callAttrs = new ArrayList<>();
    private final Map<String, String> declAttrs = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void putDeclAttrs(String name, String type) {
        declAttrs.put(name, type);
    }

    public String getDeclAttrs(boolean withTypes) {
        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = declAttrs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (withTypes) {
                builder.append(entry.getValue()).append(" ");
            }
            builder.append(entry.getKey());
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public String getCallAttrs() {
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = callAttrs.iterator();
        while (iterator.hasNext()) {
            String entry = iterator.next();
            builder.append(entry);
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public void setCallAttrs(List<String> callAttrs) {
        this.callAttrs = callAttrs;
    }

    @Override
    public boolean equals(Object o) {
        return (getClass() == o.getClass() && name.equals(((Node) o).name));
    }

    public String getName() {
        return name;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public void setReturnType(String s) {
        this.returnType = s;
    }

    public void add(Element Element) {
        elementList.add(Element);
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public Element get(int i) {
        return elementList.get(i);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" -> ");
        for (Element cur : elementList) {
            stringBuilder.append(cur.toString()).append(" | ");
        }
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        return stringBuilder.toString();
    }
}