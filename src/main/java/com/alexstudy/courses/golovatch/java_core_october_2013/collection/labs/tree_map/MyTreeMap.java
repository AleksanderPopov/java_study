package golovatch.courses.collection.labs.tree_map;

import java.util.*;

/**
 * Created by Alex on 12/18/2016.
 */
public class MyTreeMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V> {

    private Node<K, V> tail;
    private int size = 0;

    @Override
    public V put(K key, V value) {
        Node<K, V> put = new Node<>(key, value, null);
        if (tail == null) {
            tail = put;
            size++;
            return null;
        } else {
            Node<K, V> point = tail;
            while (true) {
                int result = compare(point, put);
                if (result > 0) {
                    if (point.left == null) {
                        point.setLeft(put);
                        return null;
                    } else {
                        point = point.left;
                        continue;
                    }
                } else if (result < 0) {
                    if (point.right == null) {
                        point.setRight(put);
                        return null;
                    } else {
                        point = point.right;
                        continue;
                    }
                } else {
                    V tmp = point.val;
                    point.setValue(put.val);
                    return tmp;
                }
            }
        }
    }

    @Override
    public V remove(Object key) {
        return super.remove(key);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) {
        return null;
    }

    @Override
    public K lowerKey(K key) {
        return null;
    }

    @Override
    public Entry<K, V> floorEntry(K key) {
        return null;
    }

    @Override
    public K floorKey(K key) {
        return null;
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return null;
    }

    @Override
    public K ceilingKey(K key) {
        return null;
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        return null;
    }

    @Override
    public K higherKey(K key) {
        return null;
    }

    @Override
    public Entry<K, V> firstEntry() {
        return null;
    }

    @Override
    public Entry<K, V> lastEntry() {
        return null;
    }

    @Override
    public Entry<K, V> pollFirstEntry() {
        return null;
    }

    @Override
    public Entry<K, V> pollLastEntry() {
        return null;
    }

    @Override
    public NavigableMap<K, V> descendingMap() {
        return null;
    }

    @Override
    public NavigableSet<K> navigableKeySet() {
        return null;
    }

    @Override
    public NavigableSet<K> descendingKeySet() {
        return null;
    }

    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null;
    }

    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    @Override
    public K firstKey() {
        return null;
    }

    @Override
    public K lastKey() {
        return null;
    }

    int compare(Node<K, V> key1, Node<K, V> key2) {
        return key1 == null ? 0 : ((Comparable<? super K>) key1.getKey()).compareTo(key2.getKey());
    }


    @Override
    public String toString() {
        return tail == null ? null : tail.toString();
    }

    static class Node<K, V> implements Map.Entry<K, V> {

        private K key;
        private V val;
        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V val, Node<K, V> parent) {
            this.key = key;
            this.val = val;
            this.parent = parent;
        }

        public Node(K key, V val, Node<K, V> parent, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.val = val;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return val;
        }

        @Override
        public V setValue(V value) {
            V tmp = val;
            val = value;
            return tmp;
        }

        public void setParent(Node<K, V> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<K, V> left) {
            this.left = left;
            this.left.parent = this;
        }

        public void setRight(Node<K, V> right) {
            this.right = right;
            this.right.parent = this;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (left == null) {
                builder.append("{'")
                        .append(key)
                        .append("', '")
                        .append(val)
                        .append("'}");
                if (right != null) builder.append(right);
            } else builder.append(left.toString());
            return builder.toString();
        }

    }
}
