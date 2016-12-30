package golovatch.courses.collection.labs.iterator_merge;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Alex on 12/10/2016.
 */
public class IteratorSortedMerger<E extends Comparable<? super E>> implements Iterator<E> {
    private Iterator<E> first;
    private Iterator<E> second;
    private E firstValue = null;
    private E secondValue = null;

    public IteratorSortedMerger(Iterator<E> iter1, Iterator<E> iter2) {
        this.first = iter1;
        this.second = iter2;
        this.firstValue = iter1.hasNext() ? iter1.next() : null;
        this.secondValue = iter2.hasNext() ? iter2.next() : null;
    }

    @Override
    public boolean hasNext() {
        return firstValue != null || secondValue != null;
    }

    @Override
    public E next() {
        if (firstValue == null & secondValue == null) throw new NoSuchElementException();
        else if (firstValue == null) {
            E tmp = secondValue;
            secondValue = null;
            return tmp;
        }
        else if (secondValue == null) {
            E tmp = firstValue;
            firstValue = null;
            return tmp;
        }

        E item1 = firstValue;
        E item2 = secondValue;

        if (item1.compareTo(item2) <= 0) {
            firstValue = first.hasNext() ? first.next() : null;
            return item1;
        } else {
            secondValue = second.hasNext() ? second.next() : null;
            return item2;
        }
    }
}
