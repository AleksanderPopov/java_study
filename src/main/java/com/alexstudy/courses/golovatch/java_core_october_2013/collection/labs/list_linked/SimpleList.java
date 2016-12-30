package golovatch.courses.collection.labs.list_linked;

import java.util.Iterator;

/**
 * Created by apop on 11/30/2016.
 */
public interface SimpleList<E> extends Iterable<E> {

    // add
    boolean add(E element);

    void add(int index, E element);

    // read
    E get(int index);

    Iterator<E> iterator();

    // check
    boolean contains(E value);

    int size();

    boolean isEmpty();

    // mutate
    E set(int index, E element);

    // remove
    E remove(int index);

    boolean remove(E elem);
}
