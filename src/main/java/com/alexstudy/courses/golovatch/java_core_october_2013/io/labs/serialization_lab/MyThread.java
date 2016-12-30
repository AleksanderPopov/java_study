package golovatch.courses.io.labs.serialization_lab;

/**
 * Created by Alex on 10/23/2016.
 */
public class MyThread extends Thread {
    private HelloTask helloTask;
    private boolean pause = false;

    public MyThread(HelloTask helloTask) {
        this.helloTask = helloTask;
    }

    @Override
    public void run() {
        while (true) {
            if (pause) continue;
            else {
                if (helloTask != null) {
                    if (pause) continue;
                    else helloTask = helloTask.next();
                } else break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished.");
    }

    public void pauseThread() {
        pause = true;
    }

    public void unpauseThread() {
        pause = false;
    }

    public boolean isPaused() {
        return pause;
    }

    public HelloTask getHelloTask() {
        return this.helloTask;
    }
}
