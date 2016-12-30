package golovatch.courses.exception.labs.lab_3_TWR_3;

/**
 * Created by Alex on 8/6/2016.
 */
public class ThreeImpI implements Three {
    @Override
    public void call(AutoClosableFactory factoryA,
                     AutoClosableFactory factoryB,
                     AutoClosableFactory factoryC,
                     TryBody tryBody) throws Throwable {

        //open resource A
        AutoCloseable resourceA = factoryA.create();

        //open resource B
        try {
            AutoCloseable resourceB = factoryB.create();

            //open resource C
            try {
                AutoCloseable resourceC = factoryC.create();

                //execute body
                try {
                    tryBody.runBody();
                    try {
                        resourceC.close();
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
                    } catch (Throwable exResC) {
                        try {
                            resourceB.close();
                            try {
                                resourceA.close();
                            } catch (Throwable exResA) {
                                exResC.addSuppressed(exResA);
                            }
                        } catch (Throwable exResB) {
                            exResC.addSuppressed(exResB);
                            try {
                                resourceA.close();
                            } catch (Throwable exResA) {
                                exResC.addSuppressed(exResA);
                            }
                        }
                        throw exResC;
                    }
                } catch (Throwable exBody) {
                    try {
                        resourceC.close();
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
                    } catch (Throwable exResC) {
                        exBody.addSuppressed(exResC);
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
                    }
                    throw exBody;
                }
            } catch (Throwable exResC) {
                try {
                    resourceB.close();
                    try {
                        resourceA.close();
                    } catch (Throwable exResA) {
                        exResC.addSuppressed(exResA);
                    }
                } catch (Throwable exResB) {
                    exResC.addSuppressed(exResB);
                    try {
                        resourceA.close();
                    } catch (Throwable exResA) {
                        exResC.addSuppressed(exResA);
                    }
                }
                throw exResC;
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
