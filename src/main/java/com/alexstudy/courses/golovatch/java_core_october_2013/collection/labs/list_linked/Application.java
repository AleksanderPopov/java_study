package golovatch.courses.collection.labs.list_linked;

import java.util.Iterator;

/**
 * Created by Alex on 12/9/2016.
 */
public class Application {
    public static void main(String[] args) {
        SimpleLinkedList<String> names = new SimpleLinkedList<>();
        names.add("alex1");
        names.add("alex2");
        names.add("alex3");
        names.add("alex4");
        names.add("alex5");
        names.add("alex6");
        names.add("alex7");
        names.add("alex8");

        for(Iterator<String> iter = names.iterator(); iter.hasNext(); ) {
            String s = iter.next();
            System.out.println(s);
        }
        names.remove("alex4");
        for(Iterator<String> iter = names.iterator(); iter.hasNext(); ) {
            String s = iter.next();
            System.out.println(s);
        }
    }
}
