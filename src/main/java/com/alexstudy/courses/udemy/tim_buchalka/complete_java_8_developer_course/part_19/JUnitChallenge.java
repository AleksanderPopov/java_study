package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_19;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by apop on 12/6/2016.
 */

@RunWith(value = Parameterized.class)
public class JUnitChallenge {

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]
                {
                        {"ABCDEFF", "ABCDEF"},
                        {"AB88EFFG", "AB8EFG"},
                        {"112233445566", "123456"},
                        {"ZYZQQB", "ZYZQB"},
                        {"A", "A"}
                };
        return Arrays.asList(data);
    }

    @Parameter(value = 0)
    public String expected;
    @Parameter(value = 1)
    public String actual;

    Utilities util;


    @Before
    public void beforeMethod() {
        util = new Utilities();
    }

    @Test
    public void everyNthCharTest() {
        assertArrayEquals(new char[]{'e', 'l'}, util.everyNthChar("hello".toCharArray(), 2));
        assertArrayEquals("hello".toCharArray(), util.everyNthChar("hello".toCharArray(), 8));
    }

    @Test()
    public void removePairsTest() {
        assertEquals(actual, util.removePairs(expected));
    }

    @Test(expected = ArithmeticException.class)
    public void converterTest() {
        assertEquals(300, util.converter(10, 5));
        util.converter(10, 0);
    }

    @Test
    public void nullIfOddLengthTest() {
        assertNull(util.nullIfOddLength("abc"));
        assertEquals("abcd", util.nullIfOddLength("abcd"));
    }


}
