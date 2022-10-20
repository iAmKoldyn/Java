public class Tree<T> {
    TreeItem<T> head;
    TreeItem<T> currentNode;

    public void printNodes() {
        for (Node node : currentNode.nodes) {
            System.out.println(node.data.toString());
        }
    }

    public void moveBack() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
        }
    }

    public void moveForward() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
        }
    }
}
