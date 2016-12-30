package com.alexstudy.courses.golovatch.java_core_october_2013.io.labs;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * Created by Alex on 11/10/2016.
 */
public class RandomAccessStringToFile {
    private File file = new File("src//main//java//golovatch//courses//io//labs//tmp.txt");
    private RandomAccessFile accessFile;

    public void write(String text) throws IOException {
        accessFile = new RandomAccessFile(file, "rw");
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        accessFile.writeInt(bytes.length);
        accessFile.write(bytes);
        accessFile.close();
    }

    public void write(byte[] bytes) throws IOException {
        accessFile = new RandomAccessFile(file, "rw");
        accessFile.write(bytes);
        accessFile.close();
    }

    public void writeFrom(int byteNumber, String text) throws IOException {
        accessFile = new RandomAccessFile(file, "rw");
        accessFile.seek(byteNumber);
        System.out.println("File pointer is" + accessFile.getFilePointer());
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        accessFile.writeInt(bytes.length);
        accessFile.write(bytes);
        accessFile.close();
    }

    public String read() throws IOException {
        accessFile = new RandomAccessFile(file, "r");
        int byteArrayLength = accessFile.readInt();
        byte[] bytes = new byte[byteArrayLength];
        accessFile.read(bytes, 0, byteArrayLength);
        String text = "";
        for (int i = 0; i < byteArrayLength; i++) {
            text += (char) bytes[i];
        }
        accessFile.close();
        return text;
    }

    public String readFrom(int byteNumber) throws IOException {
        accessFile = new RandomAccessFile(file, "r");
        accessFile.seek(byteNumber);
        System.out.println("File pointer is" + accessFile.getFilePointer());
        int byteArrayLength = accessFile.readInt();
        byte[] bytes = new byte[byteArrayLength];
        accessFile.read(bytes, 0, byteArrayLength);
        String text = "";
        for (int i = 0; i < byteArrayLength; i++) {
            text += (char) bytes[i];
        }
        accessFile.close();
        return text;
    }

    public void close() throws IOException {
        accessFile.close();
    }
}
