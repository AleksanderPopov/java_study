package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_8.master_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class BaseBurger extends Burger {
    BaseBurger(String... additions) {
        this.breadType = "Bread Roll Type";
        this.minAdditions = 0;
        this.maxAdditions = 4;

        if (additions.length > this.maxAdditions) throw new IllegalArgumentException("Too much additions ordered");
        this.additions = additions;
        System.out.print("You have ordered Base Burger with ");
        for (int a = 0; a < additions.length; a++) {
            if (a != additions.length - 1) System.out.print(additions[a] + ", ");
            else System.out.print(additions[a] + ".\n");
        }
    }

    @Override
    protected int getPrice() {
        return 15 + this.additions.length * 5;
    }
}
