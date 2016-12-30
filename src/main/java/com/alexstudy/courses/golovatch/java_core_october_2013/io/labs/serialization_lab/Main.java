package golovatch.courses.io.labs.serialization_lab;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 10/23/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        ActiveTask task = new ActiveTask("Marina", 20, 1000);
        task.startTask();

        TimeUnit.MILLISECONDS.sleep(3000);
        byte[] barr;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bout);
        task.writeObject(out);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInput in = new ObjectInputStream(bin);
        HelloTask tmp = (HelloTask) in.readObject();
        TimeUnit.MILLISECONDS.sleep(2000);
        new ActiveTask(tmp).startTask();
        new ActiveTask(tmp).startTask();
        new ActiveTask(tmp).startTask();
    }
}