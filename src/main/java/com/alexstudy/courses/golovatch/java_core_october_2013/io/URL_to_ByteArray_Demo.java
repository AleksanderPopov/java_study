package golovatch.courses.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by Alex on 8/29/2016.
 */
public class URL_to_ByteArray_Demo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://google.com");

        try (InputStream in = url.openStream();
             ByteArrayOutputStream buff = new ByteArrayOutputStream()) {

            copy(in, buff);
            byte[] bytes = buff.toByteArray();
            String html = new String(bytes, StandardCharsets.US_ASCII);
            System.out.println(html);
        }
    }

    static void copy(InputStream is, OutputStream out) throws IOException {
        int elem;
        while (true) {
            elem = is.read();
            if (elem != -1) {
                out.write(elem);
            } else break;
        }
    }
}
