package golovatch.courses.collection.labs.hash_set;

/**
 * Created by Alex on 12/18/2016.
 */
public class Application {
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("B");
        set.add("A");
        System.out.println(set);
    }
}
