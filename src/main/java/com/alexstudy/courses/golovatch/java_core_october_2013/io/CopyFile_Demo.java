package golovatch.courses.io;

import java.io.*;

/**
 * Created by Alex on 9/3/2016.
 */
public class CopyFile_Demo {
    public static void main(String[] args) throws IOException {
//        copy(new File("C:\\Users\\Alex\\Desktop\\fileOne.docx"), new File("C:\\Users\\Alex\\Desktop\\fileTwo.docx"));
        copyBuff(new File("C:\\Users\\Alex\\Desktop\\fileOne.docx"), new File("C:\\Users\\Alex\\Desktop\\fileTwo.docx"));
    }

    public static void copy(File from, File to) throws IOException {
        long startTime = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream(from);
             FileOutputStream out = new FileOutputStream(to)) {
            int data;
            while ((data = in.read()) != -1) out.write(data);
            out.flush();
        }
        System.out.println("copy takes " + (System.currentTimeMillis() - startTime));
    }

    public static void copyBuff(File from, File to) throws IOException {
        long startTime = System.currentTimeMillis();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(from));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(to))) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
            out.flush();
        }
        System.out.println("copyBuff takes " + (System.currentTimeMillis() - startTime));
    }
}
