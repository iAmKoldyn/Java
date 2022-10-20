package Menu;

import Menu.Action.*;

public class Node {
    public String item;
    public Action action;
    public Node parent;
    public Node[] children;

    public Node(int quantityChildren ,Action action) {
        this.children = new Node[quantityChildren];
        this.action = action;
        this.item = MessageSet.MOVE_UP + "\n";
        this.item += MessageSet.PRESS + "1" + MessageSet.THEN + action.description;
    }

    public String getItem() {
        return this.item;
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node[] getChildren() {
        return this.children;
    }

    public Action getAction() {
        return this.action;
    }

    public boolean hasNext() {
        return this.children.length != 0;
    }

    public boolean hasParent() {
        return parent == null;
    }

    public int sizeChildren() {
        return children.length;
    }

    public int sizeAction(){
        return 1;
    }

    public Node goToParent() {
        if (this.parent == null) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.parent;
    }
    
    public Node goToChild(int Child) {
        if (Child >= children.length) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.children[Child];
    }

    public void doAction() {
        this.action.action();
    }
}
