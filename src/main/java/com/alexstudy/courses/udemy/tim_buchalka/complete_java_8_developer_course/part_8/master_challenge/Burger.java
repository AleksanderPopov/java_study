package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_8.master_challenge;

/**
 * Created by Alex on 10/11/2016.
 */

public abstract class Burger {
    protected String breadType;
    protected int minAdditions;
    protected int maxAdditions;
    protected String[] additions;

    protected abstract int getPrice();
}
