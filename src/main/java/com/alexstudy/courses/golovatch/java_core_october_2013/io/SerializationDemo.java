package golovatch.courses.io;

import java.io.*;

/**
 * Created by Alex on 10/22/2016.
 */
public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bytes);

        TestClass testClass = new TestClass("test");
        out.writeObject(testClass);
        out.flush();
        byte[] arr = bytes.toByteArray();


        ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(arr));
        System.out.println(in.readObject());


        out.close();
        in.close();
    }

    private static class TestClass implements Serializable {
        String name;

        public TestClass(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TestClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
