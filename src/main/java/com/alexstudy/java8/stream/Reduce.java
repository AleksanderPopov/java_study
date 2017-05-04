package com.alexstudy.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 5/4/2017.
 */
public class Reduce {
  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    // sum
    Integer sum = integers.stream().reduce(0, ((i1, i2) -> i1 + i2));

    // max
    Integer max = integers.stream().reduce(0, ((i1, i2) -> i1 > i2 ? i1 : i2));

    // min
    Integer min = integers.stream().reduce(0, ((i1, i2) -> i1 < i2 ? i1 : i2));

  }
}
