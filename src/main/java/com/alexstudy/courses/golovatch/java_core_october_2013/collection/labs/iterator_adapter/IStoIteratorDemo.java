package golovatch.courses.collection.labs.iterator_adapter;

import java.io.ByteArrayInputStream;

/**
 * Created by Alex on 12/9/2016.
 */
public class IStoIteratorDemo {

    public static void main(String[] args) {
        byte[] source = new byte[]{1, 12, -123, 64, 120};
        ByteArrayInputStream in = new ByteArrayInputStream(source);
        InputStreamToIterator iter = new InputStreamToIterator(in);
        while (iter.hasNext()) System.out.println(iter.next());
    }
}
