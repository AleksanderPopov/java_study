package golovatch.courses.io.adapter_decorator;

import java.util.Arrays;

/**
 * Created by Alex on 9/19/2016.
 */
public class Employee {
    String name;
    String position;
    int age;
    boolean married;
    String[] kids;

    public Employee(String name, String position, int age, boolean married) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.married = married;
    }

    public Employee() {
        this.name = "Marina";
        this.position = "QA";
        this.age = 23;
        this.married = true;
        kids = (String[]) Arrays.asList("Alex", "Kate").toArray();
    }
}
