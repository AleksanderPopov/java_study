package golovatch.courses.proc.dyn.labs;

/**
 * Created by apop on 7/18/2016.
 */
public class single_lib {


    public static void main(String[] args) {
        Node tail = new Node(5);
        System.out.println(tail.toStringNode());
        tail.addI(10);
        System.out.println(tail.toStringNode());
        tail.addR(7);
        System.out.println(tail.toStringNode());
        tail.removeI();
        System.out.println(tail.toStringNode());
        tail.removeR();
        System.out.println(tail.toStringNode());
    }
}
