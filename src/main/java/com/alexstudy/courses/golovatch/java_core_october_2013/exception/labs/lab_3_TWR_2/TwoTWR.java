package golovatch.courses.exception.labs.lab_3_TWR_2;

/**
 * Created by Alex on 8/6/2016.
 */
public class TwoTWR implements Two {

    @Override
    public void call(AutoClosableFactory factoryA, AutoClosableFactory factoryB, TryBody tryBody) throws Throwable {
        try (AutoCloseable resourceA = factoryA.create(); AutoCloseable resourceB = factoryB.create()) {
            tryBody.runBody();
        }
    }
}
