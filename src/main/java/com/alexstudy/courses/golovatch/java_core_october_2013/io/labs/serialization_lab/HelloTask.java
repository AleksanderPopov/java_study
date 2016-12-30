package golovatch.courses.io.labs.serialization_lab;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 10/23/2016.
 */
public class HelloTask implements Serializable {
    private String text;
    private int count;
    private int repeatAfter;

    public HelloTask(String text, int count, int repeatAfter) {
        this.text = text;
        this.count = count;
        this.repeatAfter = repeatAfter;
    }

    public HelloTask next() {
        if (count == 0) return null;
        System.out.println(text + ":" + count);
        try {
            TimeUnit.MILLISECONDS.sleep(repeatAfter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HelloTask(this.text, this.count-1, this.repeatAfter);
    }
}
