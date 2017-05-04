package com.alexstudy.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 5/4/2017.
 */
public class Optional {
  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    // using optional value or default
    integers.stream()
            .filter(i -> i == -1)
            .findFirst()
            .orElse(Integer.MIN_VALUE);

    // using optional value or thow exception, if no value
    integers.stream()
            .filter(i -> i == -1)
            .findFirst()
            .orElseThrow(NullPointerException::new);
  }
}
