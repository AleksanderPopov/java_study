package golovatch.courses.collection.labs.list_array;

import golovatch.courses.collection.labs.list_linked.SimpleList;

import java.util.*;

/**
 * Created by apop on 11/30/2016.
 */
public class SimpleArrayList<E> implements SimpleList<E> {
    Object[] data;
    private int size = 0;
    private int capacity;

    public SimpleArrayList() {
        this(10);
    }

    public SimpleArrayList(int capacity) {
        this.data = new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean add(E element) {
        if (size != capacity) {
            data[size++] = element;
            return true;
        } else {
            Object[] newData = new Object[capacity *= 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
            data[size++] = element;
            return true;
        }
    }

    @Override
    public void add(int index, E element) {
        if (index >= size) throw new IllegalArgumentException();
        else if (index == size - 1) {
            Object[] oldArray = new Object[capacity *= 2];
            System.arraycopy(data, 0, oldArray, 0, data.length);
            oldArray[size] = element;
            data = oldArray;
            size++;
        } else if (index <= size - 1) {
            if (size + 1 == capacity) capacity *= 2;
            Object[] startArr = new Object[index];
            Object[] finishArr = new Object[size - index];
            System.arraycopy(data, 0, startArr, 0, startArr.length);
            System.arraycopy(data, index, finishArr, 0, finishArr.length);
            Object[] newArr = new Object[capacity];
            System.arraycopy(startArr, 0, newArr, 0, startArr.length);
            newArr[startArr.length] = element;
            System.arraycopy(finishArr, 0, newArr, startArr.length + 1, finishArr.length);
            data = newArr;
            size++;
        }
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= size - 1) return (E) data[index];
        else throw new IllegalArgumentException();
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public boolean contains(E value) {
        return Arrays.asList(data).contains(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public E set(int index, E element) {
        E was = (E) data[index];
        data[index] = element;
        return was;
    }

    @Override
    public E remove(int index) {
        E was = (E) data[index];
        if (index == 0) {
            Object[] finish = new Object[size - index - 1];
            System.arraycopy(data, index + 1, finish, 0, finish.length);
            data = finish;
            size--;
        } else {
            Object[] startArr = new Object[index];
            Object[] finishArr = new Object[size - index - 1];
            System.arraycopy(data, 0, startArr, 0, startArr.length);
            System.arraycopy(data, index+1, finishArr, 0, finishArr.length);
            Object[] newArr = new Object[capacity];
            System.arraycopy(startArr, 0, newArr, 0, startArr.length);
            System.arraycopy(finishArr, 0, newArr, startArr.length, finishArr.length);
            data = newArr;
            size--;
        }
        return was;
    }

    @Override
    public boolean remove(E elem) {
        if (!Arrays.asList(data).contains(elem)) return false;
        else {
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals(elem)) {
                    this.remove(i);
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Object elem : data) {
            if (elem == null) break;
            else sb.append(elem + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }
    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = SimpleArrayList.this.data;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                SimpleArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

    }
}
