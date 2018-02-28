package generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrfiskerton on 25.01.2018.
 */
public class Element {
    private List<Node> nodes = new ArrayList<>();
    private String javaCode = "";
    private String attrs = "";

    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }

    public void add(Node node) {
        nodes.add(node);
    }

    public String getJavaCode() {
        return javaCode;
    }

    public void setJavaCode(String code) {
        javaCode += code;
    }

    public int size() {
        return nodes.size();
    }

    public Node get(int i) {
        return nodes.get(i);
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
