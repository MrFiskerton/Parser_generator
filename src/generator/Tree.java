package generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mrfiskerton on 26.01.2018.
 */
public class Tree {
    private String node;
    private List<Tree> children;

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
        this.children = Collections.emptyList();
    }

    public String getNode() {
        return node;
    }

    public String hash() {
        return Integer.toString(this.hashCode());
    }
}
