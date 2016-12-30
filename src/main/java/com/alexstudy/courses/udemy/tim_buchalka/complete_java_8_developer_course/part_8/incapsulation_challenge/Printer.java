package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_8.incapsulation_challenge;

/**
 * Created by Alex on 10/11/2016.
 */
public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(boolean isDuplex) {
        this.tonerLevel = 100;
        this.pagesPrinted = 0;
        this.isDuplex = isDuplex;
    }

    public void fillToner(int percent) {
        System.out.printf("Toner lever before filling: %d\n", tonerLevel);
        if (percent <= 0 || percent > 100) throw new IllegalArgumentException();
        if (tonerLevel + percent > 100) {
            tonerLevel = 100;
            System.out.printf("Too much toner, wasted %d toner. Toner level is 100\n", (tonerLevel + percent - 100));
        } else {
            tonerLevel += percent;
            System.out.printf("Filling success. Current toner level %d\n", tonerLevel);
        }
    }

    public void print() {
        System.out.println("Trying to print a page...");
        if (isDuplex) {
            if (tonerLevel <= 0) System.out.println("Not enough toner to print");
            else {
                tonerLevel -= 2;
                pagesPrinted += 2;
                System.out.println("Printing success!");
            }
        } else {
            if (tonerLevel <= 0) System.out.println("Not enough toner to print");
            else {
                tonerLevel--;
                pagesPrinted++;
                System.out.println("Printing success!");
            }
        }
    }
}
