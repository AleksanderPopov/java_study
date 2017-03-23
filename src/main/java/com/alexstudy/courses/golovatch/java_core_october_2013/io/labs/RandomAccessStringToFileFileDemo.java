package com.alexstudy.courses.golovatch.java_core_october_2013.io.labs;

import java.io.IOException;

/**
 * Created by Alex on 11/10/2016.
 */
public class RandomAccessStringToFileFileDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessStringToFile randomAccessStringToFile =
                new RandomAccessStringToFile();
        randomAccessStringToFile.write(new byte[100]);
        randomAccessStringToFile.writeFrom(100, "Alex");
        System.out.println(randomAccessStringToFile.readFrom(100));
    }
}
