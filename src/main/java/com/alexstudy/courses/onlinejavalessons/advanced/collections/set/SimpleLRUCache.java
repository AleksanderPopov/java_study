package com.alexstudy.courses.onlinejavalessons.advanced.collections.set;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by apop on 3/31/2017.
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K,V> {

    int initialCapacity;

    public SimpleLRUCache(int initialCapacity) {
        super(initialCapacity + 1, 1.1f, true);
        this.initialCapacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > initialCapacity;
    }

    public static void main(String[] args) {

        Map<Integer, String> newMap = new SimpleLRUCache<>(2);
        newMap.put(1, "a");
        newMap.put(2, "a");
        newMap.put(3, "a");
        newMap.get(2);
        newMap.put(9, "a");

        System.out.println(newMap);
    }

}
