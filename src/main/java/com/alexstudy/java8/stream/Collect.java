package com.alexstudy.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.*;

/**
 * Created by Alex on 5/4/2017.
 */
public class Collect {
  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

    // simple to list
    integers.stream().filter(i -> i > 5).collect(toList());

    // simple to set
    integers.stream().filter(i -> i > 5).collect(toSet());

    List<Entry> entries = Arrays.asList(new Entry(0, "zero"), new Entry(1, "first"));
    // to map with key and value extractor
    Map<Integer, String> toMap = entries.stream().collect(toMap(Entry::getId, Entry::getName));

    // to map using groupingBy
    Map<Integer, List<Entry>> groupingBy = entries.stream().collect(groupingBy(Entry::getId));

    // to map using groupingBy with set
    Map<String, Set<Entry>> groupingBySet = entries.stream().collect(groupingBy(Entry::getName, toSet()));

    // to map using groupingBy with groupingBy
    Map<Integer, Map<InnerEntry, List<Entry>>> groupingByAndAgain = entries.stream().collect(groupingBy(Entry::getId, groupingBy(Entry::getInnerEntry)));

    // to map using pattern split
    Map<String, Long> groupingByPattern = Pattern.compile(".").splitAsStream("abcddcbaeefgg").collect(groupingBy(s -> s, counting()));
  }
}

class Entry {
  Integer id;
  String name;
  InnerEntry innerEntry;

  public Entry(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public InnerEntry getInnerEntry() {
    return innerEntry;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
class InnerEntry {
  boolean state;

  public InnerEntry(boolean state) {
    this.state = state;
  }

  public boolean getState() {
    return state;
  }
}