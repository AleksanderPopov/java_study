package com.alexstudy.courses.onlinejavalessons.advanced.collections.set;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Alex on 4/1/2017.
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) ->
                o1 % 2 != 0
                        ? o2 % 2 != 0 ? o1.compareTo(o2) : 1
                        : o2 % 2 != 0 ? -1 : o1.compareTo(o2)
        );

        for (int i = 5; i > 0; i--) {
            queue.add(i);
        }

        while (!queue.isEmpty()) System.out.println(queue.poll());
    }
}
