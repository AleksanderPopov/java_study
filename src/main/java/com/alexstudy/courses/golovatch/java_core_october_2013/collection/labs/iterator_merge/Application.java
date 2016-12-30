package golovatch.courses.collection.labs.iterator_merge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 12/10/2016.
 */
public class Application {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list1.add(1);
        list2.add(2);
        list1.add(3);
        list2.add(4);
        list1.add(5);
        list2.add(6);
        list1.add(7);
        list2.add(8);
        list1.add(9);
        list2.add(10);
        list1.add(11);
        list2.add(12);

        System.out.println(list1);
        System.out.println(list2);

        Iterator<Integer> iter1 = list1.iterator();
        Iterator<Integer> iter2 = list2.iterator();
        IteratorSortedMerger<Integer> mIter = new IteratorSortedMerger(iter1, iter2);

        while (mIter.hasNext()) System.out.println(mIter.next());
    }
}
