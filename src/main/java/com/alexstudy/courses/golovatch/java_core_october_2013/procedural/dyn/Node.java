package golovatch.courses.proc.dyn;

/**
 * Created by apop on 7/18/2016.
 */
public class Node {
    int value;
    Node next;
    Node(int aValue, Node aNext) {
        value = aValue;
        next = aNext;
    }

    Node(int aValue) {
        this(aValue, null);
    }

    Node() {}

    public static int sum(Node node) {
        return node == null? 0 : node.value + sum(node.next);
    }

    public boolean hasNext() { return (next != null); }

    public String toStringNode() {
        return !hasNext()? "*" : value + "->" + next.toStringNode();
    }
}
