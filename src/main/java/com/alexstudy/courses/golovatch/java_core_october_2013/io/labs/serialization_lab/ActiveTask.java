package golovatch.courses.io.labs.serialization_lab;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Serializable;

/**
 * Created by Alex on 10/23/2016.
 */
public class ActiveTask implements Serializable {
    private HelloTask helloTask;
    private transient MyThread myThread;

    public ActiveTask(String text, int count, int repeatAfter) {
        helloTask = new HelloTask(text, count, repeatAfter);
        myThread = new MyThread(helloTask);
    }

    public ActiveTask(HelloTask helloTask) {
        myThread = new MyThread(helloTask);
    }

    public void startTask() {
        myThread.start();
    }

    public void writeObject(ObjectOutput out) {
        myThread.pauseThread();
        helloTask = myThread.getHelloTask();
        try {
            out.writeObject(helloTask);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myThread.unpauseThread();
    }
}