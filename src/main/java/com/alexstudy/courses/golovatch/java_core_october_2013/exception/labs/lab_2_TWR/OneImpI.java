package golovatch.courses.exception.labs.lab_2_TWR;

/**
 * Created by Alex on 8/6/2016.
 */
public class OneImpI implements One {
    @Override
    public void call(AutoClosableFactory factory, TryBody tryBody) throws Throwable {
        AutoCloseable resource = factory.create();
        try {
            tryBody.runBody();
        } catch (Throwable exBody) {
            try {
                resource.close();
            } catch (Throwable main) {
                exBody.addSuppressed(main);
            }
            throw exBody;
        }

        try {
            resource.close();
        } catch (Throwable main) {
            throw main;
        }
    }
}
