package golovatch.courses.io;

import java.io.*;

/**
 * Created by Alex on 9/2/2016.
 */
public class DataInputOutput_Demo {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\main\\java\\golovatch\\courses\\io\\DataInputOutput_Demo.txt";

        // write/read java data types (long, float, double, etc.)

        DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath));
        out.writeInt(123);
        out.writeDouble(321.1);
        out.flush();
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream(filePath));
        System.out.println(in.readInt());
        System.out.println(in.readDouble());
        in.close();

        new File(filePath).delete();
    }
}
