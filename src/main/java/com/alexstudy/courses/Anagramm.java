package com.alexstudy.courses;

import java.math.BigInteger;

/**
 * Created by apop on 4/5/2017.
 */
public class Anagramm {

    static BigInteger quantityOf(String word) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= word.length(); i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Anagramm.quantityOf("qwertyuiop"));
    }
}
