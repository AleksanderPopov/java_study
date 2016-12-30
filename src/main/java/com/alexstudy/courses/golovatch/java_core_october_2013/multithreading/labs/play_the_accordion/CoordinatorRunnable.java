package golovatch.courses.multithreading.labs.play_the_accordion;

/**
 * Created by Alex on 11/10/2016.
 */
public class CoordinatorRunnable implements Runnable {
    private Runnable runnableA;
    private Runnable runnableB;
    private Runnable runnableC;

    public CoordinatorRunnable(Runnable... runnables) {
        this.runnableA = runnables[0];
        this.runnableB = runnables[1];
        this.runnableC = runnables[2];
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread threadA = new Thread(runnableA);
                Thread threadB = new Thread(runnableB);
                Thread threadC = new Thread(runnableC);
                threadA.start();
                threadB.start();
                threadA.join();
                threadB.join();
                System.out.println("-----------");
                threadC.start();
                threadC.join();
                System.out.println("-----------");
            } catch (InterruptedException e) {
                /*NOP*/
            }
        }
    }
}
