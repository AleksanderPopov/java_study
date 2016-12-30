package golovatch.courses.multithreading.labs.play_the_accordion;

/**
 * Created by Alex on 11/10/2016.
 */
public class Lab_Thread_Thread_Play_The_Accordion {
    private static Runnable printerA = new PrintRunnable("A   .", 100);
    private static Runnable printerB = new PrintRunnable(".   B", 99);
    private static Runnable printerC = new PrintRunnable("  C", 100);

    public static void main(String[] args) throws InterruptedException {
        Thread coordinator = new Thread(new CoordinatorRunnable(printerA, printerB, printerC));
        coordinator.start();
        coordinator.join();
        System.out.println("FINISH");
    }
}
