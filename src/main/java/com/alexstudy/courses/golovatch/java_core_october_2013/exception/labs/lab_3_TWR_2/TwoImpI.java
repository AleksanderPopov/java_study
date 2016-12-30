package golovatch.courses.exception.labs.lab_3_TWR_2;

/**
 * Created by Alex on 8/6/2016.
 */
public class TwoImpI implements Two {

    @Override
    public void call(AutoClosableFactory factoryA, AutoClosableFactory factoryB, TryBody tryBody) throws Throwable {
        //open resource A
        AutoCloseable resourceA = factoryA.create();
        try {
            AutoCloseable resourceB = factoryB.create();
            try {
                tryBody.runBody();
                try {
                    resourceB.close();
                    try {
                        resourceA.close();
                    } catch (Throwable exResA) {
                        throw exResA;
                    }
                } catch (Throwable exResB) {
                    try {
                        resourceA.close();
                    } catch (Throwable exResA) {
                        exResB.addSuppressed(exResA);
                    }
                    throw exResB;
                }
            } catch (Throwable exBody) {
                try {
                    resourceB.close();
                    try {
                        resourceA.close();
                    } catch (Throwable exResA) {
                        exBody.addSuppressed(exResA);
                    }
                } catch (Throwable exResB) {
                    exBody.addSuppressed(exResB);
                    try {
                        resourceA.close();
                    } catch (Throwable exResA) {
                        exBody.addSuppressed(exResA);
                    }
                }
                throw exBody;
            }
        } catch (Throwable exResB) {
            try {
                resourceA.close();
            } catch (Throwable exResA) {
                exResB.addSuppressed(exResA);
            }
            throw exResB;
        }
    }
}
