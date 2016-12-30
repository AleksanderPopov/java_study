package golovatch.courses.proc.dyn.labs;

/**
 * Created by Alex on 7/24/2016.
 */
public class double_lib_4 {
    private static DoubleNode fillI(int length) {
        DoubleNode result = new DoubleNode();
        DoubleNode next = result;
        DoubleNode prev = result;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                next.value = i;
                next = next.next = new DoubleNode();
                continue;
            }
            next.value = i;
            next.prev = prev;
            prev = next;
            if (i != length-1) next.next = new DoubleNode();
            next = next.next;
        }
        return result;
    }

    public static void main(String[] args) {
        DoubleNode tail = fillI(5);
        System.out.println(tail.toString());
        tail.addR(12);
        System.out.println(tail.toString());
        tail.addI(34);
        System.out.println(tail.toString());
        tail.addR(66, 3);
        System.out.println(tail.toString());
        tail.addI(101, 2);
        System.out.println(tail.toString());
        tail.removeR();
        System.out.println(tail.toString());
        tail.removeI();
        System.out.println(tail.toString());
        tail.removeR(3);
        System.out.println(tail.toString());
        tail.removeI(3);
        System.out.println(tail.toString());
    }
}
