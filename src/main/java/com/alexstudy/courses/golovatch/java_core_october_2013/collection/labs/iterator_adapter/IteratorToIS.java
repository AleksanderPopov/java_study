package golovatch.courses.collection.labs.iterator_adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by Alex on 12/9/2016.
 */
public class IteratorToIS extends InputStream {
    private Iterator<Byte> iterator;

    public IteratorToIS(Iterator<Byte> iterator) {
        this.iterator = iterator;
    }

    @Override
    public int read() throws IOException {
        return iterator.hasNext() ? iterator.next() & 0xFF : -1;
    }
}
