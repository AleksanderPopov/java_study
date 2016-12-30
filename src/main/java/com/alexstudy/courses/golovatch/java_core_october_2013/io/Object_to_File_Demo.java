package golovatch.courses.io;

import java.io.*;

/**
 * Created by Alex on 9/3/2016.
 */
public class Object_to_File_Demo {
    static String filePath = "src\\main\\java\\golovatch\\courses\\io\\Object_to_File_Demo";
    static File file = new File(filePath);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestObject o1 = new TestObject("alex", 23, false, 12.1);
        TestObject o2 = new TestObject("marina", 24, false, 2.7);


        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(o1);
        out.writeObject(o2);
        out.flush();
        out.close();

        o1 = null;
        o2 = null;

        ObjectInput in = new ObjectInputStream(new FileInputStream(file));
        o1 = (TestObject) in.readObject();
        System.out.println(o1.toString());
        o2 = (TestObject) in.readObject();
        System.out.println(o2.toString());
        in.close();

        file.delete();
    }


    static class TestObject implements Serializable {
        String name;
        int age;
        boolean married;
        double salary;

        TestObject(String aname, int aage, boolean amarried, double asalary) {
            name = aname;
            age = aage;
            married = amarried;
            salary = asalary;
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", married=" + married +
                    ", salary=" + salary +
                    '}';
        }
    }
}