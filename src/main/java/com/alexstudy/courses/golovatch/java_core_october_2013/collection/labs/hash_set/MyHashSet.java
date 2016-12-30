package golovatch.courses.collection.labs.hash_set;

import golovatch.courses.collection.labs.hash_map.MyHashMap;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Alex on 12/17/2016.
 */
public class MyHashSet<E> extends AbstractSet<E> implements Set<E> {
    private final Object object = new Object();
    private MyHashMap map = new MyHashMap();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) map.keySet().toArray(a);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, object) != null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!this.contains(e)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            this.add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object e : c) {
            this.remove(e);
        }
        return true;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }
}
