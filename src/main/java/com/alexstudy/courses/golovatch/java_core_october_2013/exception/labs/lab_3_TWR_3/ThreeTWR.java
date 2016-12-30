package golovatch.courses.exception.labs.lab_3_TWR_3;

/**
 * Created by Alex on 8/6/2016.
 */
public class ThreeTWR implements Three {

    @Override
    public void call(AutoClosableFactory factoryA,
                     AutoClosableFactory factoryB,
                     AutoClosableFactory factoryC,
                     TryBody tryBody) throws Throwable {

        try (AutoCloseable resourceA = factoryA.create();
             AutoCloseable resourceB = factoryB.create();
             AutoCloseable resourceC = factoryC.create()) {
            tryBody.runBody();
        }
    }
}
