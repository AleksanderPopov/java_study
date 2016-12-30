package golovatch.courses.proc.dyn.labs;

/**
 * Created by Alex on 7/23/2016.
 */
public class single_lib_2 {
    public static void main(String[] args) {
        Node tail = new Node(5);
        for (int i = 10; i < 100; i+=10) {
            tail.addR(i);
        }
        System.out.println(tail.toStringNode());
        tail.addI(13, 10);
        System.out.println(tail.toStringNode());
        tail.addR(24, 11);
        System.out.println(tail.toStringNode());
        tail.removeI(2);
        System.out.println(tail.toStringNode());
        tail.removeR(2);
        System.out.println(tail.toStringNode());
    }
}
