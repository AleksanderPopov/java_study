package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_11.generic_challenge;

/**
 * Created by Alex on 10/13/2016.
 */
public abstract class Team implements Comparable<Team> {
    private String name;
    private int score;

    public Team(String name, int score) {
        if (name == null)
            throw new IllegalArgumentException("Expected: 'name' parameter is not null\nBut was: " + name);
        if (score < 0)
            throw new IllegalArgumentException("Expected: 'score' parameter greater of equal zero\nBut was: " + score);
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Team opponent) {
        if (this.score > opponent.score) return 1;
        else if (this.score == opponent.score) return 0;
        else return -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + name + ", score is " + score;
    }
}
