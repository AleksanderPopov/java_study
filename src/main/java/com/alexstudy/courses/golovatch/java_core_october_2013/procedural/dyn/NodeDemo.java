package golovatch.courses.proc.dyn;

/**
 * Created by apop on 7/21/2016.
 */
public class NodeDemo {
    //fill Nodes recursion way
    private static Node fillNodesR(int lenght) {
        if (lenght == 0) return new Node(lenght);
        else return new Node(lenght, fillNodesR(lenght - 1));
    }

    //fill Nodes iteration way
    private static Node fillNodesI(int lenght) {
        Node result = new Node(0, new Node());
        Node tmp = result.next;
        for (int i = 1; i < lenght; i++) {
            tmp.value = i;
            tmp.next = new Node();
            tmp = tmp.next;
        }
        return result;
    }

    private static Node copy(Node from) {
        if (from == null) return from;
        return new Node(from.value, copy(from.next));
    }

    private static boolean isEqual(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        else return n1.value == n2.value && isEqual(n1.next, n2.next);
    }

    private static Node mergeR(Node n1, Node n2) {
        if (n1.next == null) return n2;
        else if (n2.next == null) return n1;

        if (n1.value < n2.value) return new Node(n1.value, mergeR(n1.next, n2));
        else return new Node(n2.value, mergeR(n2.next, n1));
    }

    private static int maxElement(Node tail) {
        if (tail == null) return Integer.MIN_VALUE;
        return tail.value >= maxElement(tail.next)? tail.value : maxElement(tail.next);
    }

    public static void main(String[] args) {
        Node tail1 = fillNodesI(15);
        Node tail2 = copy(tail1);
        System.out.println("tail1 is: " + tail1.toStringNode());
        System.out.println("tail2 is: " + tail2.toStringNode());
        System.out.println("tail1 equal tail2 is " + isEqual(tail1, tail2));
        System.out.println("merge Node is " + mergeR(tail1, tail2).toStringNode());
        System.out.println("Sum of all values of Node is: " + Node.sum(tail1));
        System.out.println("Max element from node is: " + maxElement(tail1));
    }
}
