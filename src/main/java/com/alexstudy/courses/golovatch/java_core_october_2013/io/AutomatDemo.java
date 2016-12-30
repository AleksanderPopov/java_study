package golovatch.courses.io;


import java.io.Serializable;

/**
 * Created by Alex on 10/2/2016.
 */
public class AutomatDemo implements Serializable{
    public static void main(String[] args) {
        String e1 = "a@a.com";
        String e2 = "a@aasd.asdcom@";
        String e3 = "a@a.adsasdcom.";
        String e4 = "@a.com";
        String e5 = "a@@a.com";
        String e6 = "a@a..com";

        System.out.println("is " + e1 + " valid - " + isEmailValid(e1));
        System.out.println("is " + e2 + " valid - " + isEmailValid(e2));
        System.out.println("is " + e3 + " valid - " + isEmailValid(e3));
        System.out.println("is " + e4 + " valid - " + isEmailValid(e4));
        System.out.println("is " + e5 + " valid - " + isEmailValid(e5));
        System.out.println("is " + e6 + " valid - " + isEmailValid(e6));
    }

    // only detects double '@' and double '.'
    private static boolean isEmailValid(String email) {
        char[] arr = email.toCharArray();
        State state = State.START;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) state = State.END;
            switch (arr[i]) {
                case '@':
                    if (state != State.LET || state == State.END) return false;
                    else {
                        state = State.AT;
                        continue;
                    }
                case '.':
                    if (state != State.LET || state == State.END) return false;
                    else {
                        state = State.DOT;
                        continue;
                    }
                default:
                    state = State.LET;
            }
        }
        return true;
    }
    private enum State { LET, DOT, AT, START, END}
}
