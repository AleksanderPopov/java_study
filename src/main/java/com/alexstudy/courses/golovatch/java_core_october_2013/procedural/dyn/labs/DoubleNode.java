package golovatch.courses.proc.dyn.labs;

/**
 * Created by Alex on 7/24/2016.
 */
public class DoubleNode {
    int value;
    DoubleNode next;
    DoubleNode prev;

    DoubleNode() {}

    DoubleNode(int value, DoubleNode next, DoubleNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode addR(int elem) {
        return next == null ? next = new DoubleNode(elem, null, this) : next.addR(elem);
    }

    public DoubleNode addI(int elem) {
        DoubleNode tmp = this;
        while (tmp.next != null) tmp = tmp.next;
        tmp.next = new DoubleNode(elem, null, tmp);
        return this;
    }

    public DoubleNode addR(int elem, int index) {
        if (next == null | index == 1) {
            DoubleNode tmp = new DoubleNode(elem, next, this);
            tmp.next.prev = tmp;
            this.next = tmp;
            return tmp;
        } else {
            next.addR(elem, index - 1);
            return null;
        }
    }

    public DoubleNode addI(int elem, int index) {
        DoubleNode tmp = this;
        for (int i = 0; i < index-1 & tmp.next != null; i++) tmp = tmp.next;

        DoubleNode doubleNode = new DoubleNode(elem, tmp.next, tmp);
        doubleNode.next.prev = doubleNode;
        tmp.next = doubleNode;
        return this;
    }

    public DoubleNode removeR() {
        return next.next == null ? next = null : next.removeR();
    }

    public DoubleNode removeI() {
        DoubleNode result = this;
        DoubleNode tmp = result;
        while (tmp.next.next != null) tmp = tmp.next;
        tmp.next = null;
        return result;
    }

    public DoubleNode removeR(int index) {
        if (next.next == null | index == 1) {
            next.next.prev = this;
            next = next.next;
            return null;
        } else return next.removeR(index-1);

    }

    public DoubleNode removeI(int index) {
        DoubleNode result = this;
        DoubleNode tmp = result;
        for (int i = 0; i < index-1 && tmp.next.next != null; i++) tmp = tmp.next;
        tmp.next.next.prev = tmp;
        tmp.next = tmp.next.next;
        return result;
    }

    @Override
    public String toString() {
        if (next == null) return value + "->*";
        else return value + "<->" + next.toString();
    }
}
