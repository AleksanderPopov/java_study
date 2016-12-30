package golovatch.courses.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Alex on 9/3/2016.
 */
public class ReaderWriter_Demo {
    public static void main(String[] args) throws Exception{
        String filePath = "src\\main\\java\\golovatch\\courses\\io\\ReaderWriter_Demo.txt";

        //write and read char[]

        Writer out = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8);
//        Writer out = new FileWriter(filePath);
        out.write("Test string");
        out.flush();
        out.close();


        Reader in = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
//        Reader in = new FileReader(filePath);
        int data = in.read();
        while(data != -1){
            char dataChar = (char) data;
            System.out.print(dataChar);
            data = in.read();
        }
        in.close();
    }
}
