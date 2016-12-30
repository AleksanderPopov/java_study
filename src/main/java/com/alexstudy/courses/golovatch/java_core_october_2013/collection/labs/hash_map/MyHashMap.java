package golovatch.courses.collection.labs.hash_map;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Alex on 12/17/2016.
 */
public class MyHashMap<K, V> implements Map<K, V> {

    private Node[] data;
    private int size = 0;

    public MyHashMap() {
        this(8);
    }

    public MyHashMap(int capacity) {
        this.data = new Node[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public V get(Object key) {
        Node<K, V> get = new Node<>((K) key, null);
        int hash = key.hashCode();
        int bucketNumber = hash % data.length;
        Node point = data[bucketNumber];
        if (data[bucketNumber] == null) return null;
        else {
            while (point != null) {
                if (point.equals(get)) return (V) point.val;
                point = point.next;
            }
            return null;
        }
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> put = new Node<>(key, value);
        int hash = put.hashCode();
        int bucketNumber = hash % data.length;
        Node<K, V> point = data[bucketNumber];
        if (point == null) {
            data[bucketNumber] = put;
            size++;
            return (V) data[bucketNumber].val;
        } else {
            while (point != null) {
                if (point.equals(put)) {
                    V val = point.val;
                    point.setValue(put.val);
                    return val;
                }
                point = point.next;
            }
            point = put;
            size++;
            return point.val;
        }
    }

    @Override
    public V remove(Object key) {
        Node<K, V> remove = new Node(key, null);
        int hash = remove.hashCode();
        int bucketNumber = hash % data.length;
        Node<K, V> point = data[bucketNumber];
        if (point == null) {
            return null;
        } else {
            if (point.equals(remove)) {
                data[bucketNumber] = point.next;
                size--;
                return point.val;
            }
            while (point.next != null) {
                if (point.next.equals(remove)) {
                    V val = (V) point.next.val;
                    point.next = point.next.next;
                    size--;
                    return val;
                }
            }
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Map.Entry entry : m.entrySet()) {
            this.put((K) entry.getKey(), (V) entry.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }

    @Override
    public Set<K> keySet() {
        return entrySet()
                .stream()
                .map(Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<V> values() {
        return entrySet()
                .stream()
                .map(Entry::getValue)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            Node<K, V> point = data[i];
            while (point != null) {
                set.add(point);
                point = point.next;
            }
        }
        return set;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < data.length; i++) {
            Node<K, V> node = data[i];
            while (node != null) {
                if (builder.length() > 1) builder.append(", ");
                builder.append(node.toString());
                node = node.next;
            }
        }
        builder.append("]");
        return builder.toString();
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        private K key;
        private V val;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.val = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }

        @Override
        public Object setValue(Object value) {
            V tmp = val;
            val = (V) value;
            return tmp;
        }

        public void setNext(K key, V value) {
            next = new Node(key, val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) o;

            if (!key.equals(node.key)) return false;
            return true;
        }

        @Override
        public String toString() {
            return "{'" + key + "', '" + val + "'}";
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
