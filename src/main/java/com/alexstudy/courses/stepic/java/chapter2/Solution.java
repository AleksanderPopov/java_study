package org.stepic.java.chapter2;

import java.math.BigInteger;

/**
 * Created by apop on 7/4/2016.
 */
public class Solution {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("(\\W|\\s)", "").toLowerCase();
        return (text.equals(new StringBuilder(text).reverse().toString()));
    }

    public static boolean isPowerOfTwo(int value) {
        return (Integer.bitCount(Math.abs(value)) == 1);
    }

    public static BigInteger factorial(int value) {
        if (value == 1) return BigInteger.valueOf(1);
        else return (factorial(value - 1).multiply(BigInteger.valueOf(value)));
    }

    //my method, which does not pass checking
    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder finalString = new StringBuilder("");
        for (String role : roles) {
            finalString.append(role + ":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role)) finalString
                        .append(i+1)
                        .append(')')
                        .append(textLines[i].substring(textLines[i].indexOf(':') + 1))
                        .append('\n');
            }
            finalString.append('\n');
        }
        return finalString.toString();
    }

    //google method, which does pas checking
//    private static String printTextPerRole(String[] roles, String[] textLines) {
//        StringBuilder[] textByRoles = new StringBuilder[roles.length];
//        for (int i = 0; i < roles.length; i++) {
//            textByRoles[i] = new StringBuilder(roles[i] + ":");
//        }
//
//        for (int i = 0; i < textLines.length; i++) {
//            String[] splitLine = textLines[i].split(": ", 2);
//            String role = splitLine[0];
//            String text = splitLine[1];
//
//            int j = 0;
//            while (!roles[j].equals(role)) {
//                j++;
//            }
//            textByRoles[j].append("\n" + (i + 1) + ") " + text);
//        }
//
//        String result = "";
//        for (StringBuilder line : textByRoles) {
//            result += line + "\n\n";
//        }
//        return result;
//    }

    public static void main(String[] args) throws Exception {

        System.out.println("----------------------------------------------");
        String palindrome = "Madam, I'm Adam!";
        System.out.println(isPalindrome(palindrome));
        System.out.println("----------------------------------------------");
        int powerOfTwo = 64;
        System.out.println(isPowerOfTwo(powerOfTwo));
        System.out.println("----------------------------------------------");
        int factorialNumber = 10;
        System.out.println(factorial(factorialNumber));
        System.out.println("----------------------------------------------");
    }
}
