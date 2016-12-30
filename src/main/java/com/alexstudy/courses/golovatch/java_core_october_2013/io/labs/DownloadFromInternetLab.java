package golovatch.courses.io.labs;

import java.io.*;
import java.net.URL;

/**
 * Created by Alex on 10/2/2016.
 */
public class DownloadFromInternetLab {
    public static void main(String[] args) throws IOException {
        /*try {
            downloadIntoFile();
        } catch (IOException e) {

        }*/
        downloadIntoFile(255);
    }

    private static void downloadIntoFile() throws IOException {
        URL url = new URL("http://google.com");
        InputStream in = url.openStream();
        int b;
        while ((b = in.read()) != -1) {
            System.out.print((char) b);
        }
        in.close();
    }

    private static void downloadIntoFile(int buff) throws IOException{
        URL url = new URL("http://google.com");
        byte[] arr = new byte[buff];

        try (InputStream in = url.openStream();
             OutputStream out1 = new FileOutputStream(new File("src\\main\\java\\golovatch\\courses\\io\\labs\\1.html"));
             OutputStream out2 = new FileOutputStream(new File("src\\main\\java\\golovatch\\courses\\io\\labs\\2.html"))) {
            while ((in.read(arr)) != -1) {
                out1.write(arr);
                out2.write(arr);
            }
        } catch (IOException writeExc) {
                if (!new File("src\\main\\java\\golovatch\\courses\\io\\labs\\1.html").delete())
                    writeExc.addSuppressed(new IOException("Cant delete the file 1"));
                if (!new File("src\\main\\java\\golovatch\\courses\\io\\labs\\2.html").delete())
                    writeExc.addSuppressed(new IOException("Cant delete the file 2"));
        }
    }
}
