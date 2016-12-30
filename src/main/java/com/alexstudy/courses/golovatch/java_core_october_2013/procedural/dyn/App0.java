package golovatch.courses.proc.dyn;

/**
 * Created by apop on 7/18/2016.
 */
public class App0 {
    public static void main(String[] args) {
        Node tail;
        
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node3.next = node2;
        node2.next = node1;
        node1.next = node0;

        tail = node3;

        System.out.println(tail.value);
        toString(tail);
        System.out.println(tail.value);
    }

    public static void toString(Node node){
        node.value = 1;
        System.out.println(node);
    }
}
