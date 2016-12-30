package golovatch.courses.io;

import java.io.*;

/**
 * Created by Alex on 9/2/2016.
 */
public class File_Write_Read_Demo {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\study\\JavaWebdriverStudy" +
                "\\src\\main\\java\\golovatch\\courses\\io\\File_Write_Read_Demo.txt";
        OutputStream out = new FileOutputStream(filePath);
        try {
            out.write('H');
            out.write(new byte[] {'e', 'l', 'l', 'o', ' ', 'A'});
            out.write(new byte[] {'l', 'e', 'x'});
            out.flush();
        } finally {
            out.close();
        }

        InputStream in = new FileInputStream(filePath);
        try {
            int ch;
            while ((ch = in.read()) >= 1) {
                System.out.print((char) ch);
            }
        } finally {
            in.close();
        }

        new File(filePath).delete();
    }
}
