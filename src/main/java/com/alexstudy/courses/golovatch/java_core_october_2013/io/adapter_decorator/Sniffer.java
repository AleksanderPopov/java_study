package golovatch.courses.io.adapter_decorator;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Alex on 9/7/2016.
 */
public class Sniffer {
    static File file = new File("src\\main\\java\\golovatch\\courses\\io\\Sniffer");

    public static void main(String[] args) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(
                new GZIPOutputStream(
                        new LogOutputStream(
                            new BufferedOutputStream(
                                new FileOutputStream(file)))));

        for (int i = 0; i < 1000; i++) {
            outputStream.writeDouble(Math.random());
        }
        outputStream.flush();
        outputStream.close();

        file.delete();
    }


}

class LogOutputStream extends OutputStream {
    private final OutputStream out;

    LogOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
        System.out.println(">>> log: 1");
    }

    @Override
    public void write(byte[] b) throws IOException {
        out.write(b);
        System.out.println(">>> log: " + b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        out.write(b, off, len);
        System.out.println(">>> log: " + b.length);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
        System.out.println(">>>log: flushed");
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
