package golovatch.courses.exception.labs.lab_2_TWR;

/**
 * Created by Alex on 8/6/2016.
 */
public class OneTWR implements One {

    @Override
    public void call(AutoClosableFactory factory, TryBody tryBody) throws Throwable {
        try (AutoCloseable resource = factory.create()) {
            tryBody.runBody();
        }
    }
}
