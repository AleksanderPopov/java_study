package com.alexstudy.courses.javaonlinestudy.advanced.collections;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Alex on 4/1/2017.
 */
public class WeakHashMapExample {
    public static void main(String[] args) {
        Map<Data, String> map = new WeakHashMap<>();
        Data data = new Data() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

        map.put(data, "a");

        data = null;
        System.gc();

        for (int i = 0; i < 100_000; i++) {
            if (map.isEmpty()) {
                System.out.println("empty" + i);
                break;
            }
        }
    }
}
