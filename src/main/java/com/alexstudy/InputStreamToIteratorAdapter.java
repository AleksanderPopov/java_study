package com.alexstudy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by Alex on 5/2/2017.
 */
public class InputStreamToIteratorAdapter implements Iterator<Integer>, Iterable<Integer> {
  private final InputStream stream;
  private int pointer = -1;

  public InputStreamToIteratorAdapter(InputStream stream) {
    this.stream = stream;
  }

  public void done() throws IOException {
    stream.close();
  }

  @Override
  public boolean hasNext() {
    try {
      return (pointer = stream.read()) != -1;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Integer next() {
    try {
      return pointer > 0 ? pointer : stream.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator<Integer> iterator() {
    return this;
  }
}
