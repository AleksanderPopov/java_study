package golovatch.courses.collection.labs.hash_map;

/**
 * Created by Alex on 12/17/2016.
 */
public class Application {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println(map.put("A", 4));
        System.out.println(map.get("A"));
        System.out.println(map);
        System.out.println(map.remove("C"));
        System.out.println(map.entrySet());
        System.out.println(map.values());
        System.out.println(map.keySet());
        System.out.println(map.size());
    }
}
