package app.utils;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Action action;
    public Node parent;
    public List<Node> children;

    public Node(Action action, List<Node> nodes) {
        this.children = nodes;
        this.action = action;
    }

    public Node(Action action) {
        this.children = new ArrayList<>();
        this.action = action;
    }

    public void doWorker() {
        this.action.doWorker();
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public Action getAction() {
        return this.action;
    }

    public Node goToParent() {
        if (this.parent == null) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.parent;
    }
}



