package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_16;

/**
 * Created by Alex on 11/1/2016.
 */

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create methods that will read file by buffers (using locks, or synchronized(){} )
 * 1. read in two threads
 * 2. write in two threads
 * 3. read in 'n' threads
 * 4. write in 'n' threads
 */

public class MultithreadFileReader {
    private static final File file = new File("./src/main/java/udemy/Tim_Buchalka/Complete_Java_8_Developer_Course/part_16/multithreadTestFileBig");
    private static final File file1 = new File("./src/main/java/udemy/Tim_Buchalka/Complete_Java_8_Developer_Course/part_16/multithreadTestFile1");

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file1));
        byte[] barr;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        ReentrantLock lock = new ReentrantLock();
        long readCount = 0;

        new Reader(fileIn, bout, lock, readCount).start();
        new Reader(fileIn, bout, lock, readCount).start();
    }


    private static class Reader extends Thread {
        private BufferedInputStream in;
        private OutputStream out;
        private ReentrantLock lock;
        private long readCount;

        private Reader(BufferedInputStream in, OutputStream out, ReentrantLock lock, long readCount) {
            this.in = in;
            this.out = out;
            this.lock = lock;
            this.readCount = readCount;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            while (true) {
                if (lock.tryLock()) {
                    try {
                        int i;
                        try {
                            readCount++;
                            i = in.read();
                            if (i != -1) {
                                if (readCount % 1000 == 0)
                                    System.out.println("count=" + readCount + " " + Thread.currentThread().getName() + " readed " + i + " bytes.");
//                                out.write(i);
                            } else {
                                System.out.println(Thread.currentThread().getName() + " there is EOF. Terminating...");
                                break;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                    } finally {
                        lock.unlock();
                    }
                } else continue;
            }
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " wasted millsec's = " + (endTime-startTime));
        }
    }
}
