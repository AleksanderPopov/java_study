package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_12.scope_challenge;

import java.util.Scanner;

/**
 * Created by Alex on 10/15/2016.
 */
public class Main {
    private static Scanner x = new Scanner(System.in);
    public static void main(String[] args) {
        X x = new X();
        x.x(Main.x.nextInt());
    }
}
