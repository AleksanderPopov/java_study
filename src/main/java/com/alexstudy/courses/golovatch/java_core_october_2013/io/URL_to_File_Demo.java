package golovatch.courses.io;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by Alex on 8/29/2016.
 */
public class URL_to_File_Demo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://google.com");

        try(InputStream in = url.openStream();
            OutputStream buff = new FileOutputStream(new File("D:\\study\\JavaWebdriverStudy" +
                    "\\src\\main\\java\\golovatch\\courses\\io\\URL_to_File_Demo.java"))){
            copy(in, buff);
        }
    }

    static void copy(InputStream is, OutputStream out) throws IOException {
        byte[] buff = new byte[1024];
        int count;
        while ((count = is.read(buff)) != -1) {
            out.write(buff, 0, count);
        }
    }
}
