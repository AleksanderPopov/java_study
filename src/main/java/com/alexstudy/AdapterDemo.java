package com.alexstudy;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Alex on 5/2/2017.
 */
public class AdapterDemo {
  public static void main(String[] args) throws IOException {
    File tmpFile = new File(".//tmp.txt");
    tmpFile.deleteOnExit();

    try (FileWriter writer = new FileWriter(tmpFile)) {
      writer.write("hello world");
      writer.flush();
    }

    InputStreamToIteratorAdapter iterator = new InputStreamToIteratorAdapter(new FileInputStream(tmpFile));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    for (Integer i : iterator) {
      out.write(i);
    }
    System.out.println(new String(out.toByteArray()));
    iterator.done();
    out.close();
  }
}
