package com.alexstudy.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * Created by apop on 4/10/2017.
 */
public class StreamCollectExample {

    public static void main(String[] args) {
        List<String> strings = Stream.of(1, 2, 3, 4, 5).map(Object::toString).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(strings);
        Averager averager = Stream.of(1, 2, 3, 4, 5).collect(Averager::new, Averager::accept, Averager::combine);
        System.out.println(averager.average());
    }
}

class Averager implements IntConsumer {
    private int total = 0;
    private int count = 0;

    public double average() {
        return count > 0 ? ((double) total) / count : 0;
    }

    public void accept(int i) {
        total += i;
        count++;
    }

    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}