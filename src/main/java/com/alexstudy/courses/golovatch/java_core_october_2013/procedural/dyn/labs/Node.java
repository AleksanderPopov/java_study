package golovatch.courses.proc.dyn.labs;

/**
 * Created by Alex on 7/23/2016.
 */
public class Node {
    public Node next;
    public int value;

    Node() {}
    Node(int value) {
        this.value = value;
        next = null;
    }
    Node(int value, Node next) {
        this.next = next;
        this.value = value;
    }

    public Node addI(int elem ) {
        Node tmp = this;
        while (tmp.hasNext()) {
            tmp = tmp.next;
        }
        tmp.next = new Node(elem);
        return this;
    }

    public Node addR(int elem) {
        if (next == null) {
            next = new Node(elem);
        } else this.next.addR(elem);
        return this;
    }

    public Node addI(int elem, int index) {
        Node tmp = this;
        int i = 0;
        while (tmp.hasNext() & i < index-1) {
            tmp = tmp.next;
            i++;
        }
        tmp.next = new Node(elem, tmp.next);
        return this;
    }

    public Node addR(int elem, int index) {
//        if (next != null & index == 1) {
        if (index == 1) {
            next = new Node(elem, next);
        } else this.next.addR(elem, index-1);
        return this;
    }

    public Node removeI() {
        Node tmp = this;
        while (tmp.next.next != null) tmp = tmp.next;
        tmp.next = null;
        return this;
    }

    public Node removeR() {
        if (next.next == null) {
            next = null;
            return this;
        }
        return next.removeR();
    }

    public Node removeI(int index) {
        Node tmp = this;
        int i = 0;
        while (tmp.next.next != null & i < index-1) {
            tmp = tmp.next;
            i++;
        }
        tmp.next = tmp.next.next;
        return this;
    }

    public Node removeR(int index) {
        if (next == null | index == 1) {
            next = next.next;
            return this;
        }
        return next.removeR(index-1);
    }

    public boolean hasNext() { return next != null; }

    public String toStringNode() {
        return this.next == null? "" + value + "->*" : value + "->" + next.toStringNode();
    }
}
