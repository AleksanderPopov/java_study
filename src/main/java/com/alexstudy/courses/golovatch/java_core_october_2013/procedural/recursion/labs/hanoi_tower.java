package golovatch.courses.proc.recursion.labs;

import java.util.Stack;

/**
 * Created by Alex on 7/17/2016.
 */
public class hanoi_tower {
    static Stack<Integer> from = new Stack<>();
    static Stack<Integer> help = new Stack<>();
    static Stack<Integer> to = new Stack<>();
    static int size = from.size();

    static {
//        for (int i = 10; i >= 0; i--) {
//            from.push(i);
//        }
        from.push(3);
        from.push(2);
        from.push(1);
    }

    private static void exchange (Stack<Integer> from, Stack<Integer> help, Stack<Integer> to, int count) {
        if (count > 0) {
            exchange(from, to, help, count - 1);
            int biggers = from.pop();
            to.push(biggers);
            exchange(help, from, to, count - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("from was: " + from);
        System.out.println("help was: " +help);
        System.out.println("to was: " + to);
        System.out.println("------------------exchange----------------");
        exchange(from, help, to, from.size());
        System.out.println("from now: " + from);
        System.out.println("help now: " +help);
        System.out.println("to now: " + to);
    }
}
