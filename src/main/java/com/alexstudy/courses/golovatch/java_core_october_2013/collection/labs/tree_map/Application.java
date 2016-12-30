package golovatch.courses.collection.labs.tree_map;

/**
 * Created by Alex on 12/18/2016.
 */
public class Application {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> map = new MyTreeMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(4, "A");
        System.out.println(map);
    }
}
