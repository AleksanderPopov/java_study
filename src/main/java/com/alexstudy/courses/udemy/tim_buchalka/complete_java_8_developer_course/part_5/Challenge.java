package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_5;

/**
 * Created by apop on 10/6/2016.
 */
public class Challenge {
    private static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position + " on the high score table.");
    }

    private static int calculateHighScorePosition(int score) {
        if (score >= 1000) return 1;
        else if (score >= 500 && score < 1000) return 2;
        else if (score >= 100 && score < 500) return 3;
        else return 4;
    }

    public static void main(String[] args) {
        displayHighScorePosition("Alex", 1);
        System.out.println(calculateHighScorePosition(345));
    }
}
