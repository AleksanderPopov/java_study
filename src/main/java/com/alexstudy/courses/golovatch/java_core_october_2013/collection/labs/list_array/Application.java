package golovatch.courses.collection.labs.list_array;

import java.util.Iterator;

/**
 * Created by apop on 12/2/2016.
 */
public class Application {
    public static void main(String[] args) {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list + ", size=" + list.size());
        list.add(4, 6);
        list.add(5, 7);
        System.out.println(list + ", size=" + list.size());
        list.add(1, 12);
        System.out.println(list + ", size=" + list.size());
        list.set(1, 2);
        System.out.println(list + ", size=" + list.size());
        list.remove(0);
        list.remove(1);
        list.remove(new Integer(4));
        System.out.println(list + ", size=" + list.size());

        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            Integer next = iter.next();
            if (next % 2 != 0) System.out.println(next);
            else iter.remove();
        }
        System.out.println(list + " size=" + list.size());
    }
}
