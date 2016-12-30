package golovatch.courses.collection.labs.iterator_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by Alex on 12/9/2016.
 */
public class InputStreamToIterator implements Iterator<Integer> {
    private InputStream in;
    private Integer current = null;
    private Integer next = null;
    private boolean readed = false;

    public InputStreamToIterator(InputStream in) {
        this.in = in;
        firstInit();
    }

    @Override
    public Integer next() {
        if (!readed) {
            readed = true;
            return current;
        } else forward();
        return current;
    }

    @Override
    public boolean hasNext() {
        return next != -1;
    }

    private void forward() {
        try {
            current = next;
            next = in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void firstInit() {
        try {
            this.current = in.read();
            this.next = in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
