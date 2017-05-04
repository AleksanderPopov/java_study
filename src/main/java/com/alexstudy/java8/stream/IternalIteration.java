package com.alexstudy.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 5/4/2017.
 */
public class IternalIteration {
  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    // external (old)
    for (Integer i : integers) {
      System.out.println(i);
    }

    // internal (new)
    integers.forEach(System.out::println);
  }
}
