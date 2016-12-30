package golovatch.courses.io.adapter_decorator;

/**
 * Created by Alex on 9/19/2016.
 */
public class Company {
    String name;
    int years;
    Employee[] staff;

    public Company(String name, int years, Employee[] staff) {
        this.name = name;
        this.years = years;
        this.staff = staff;
    }

    public Company() {
        this.name = "BVA";
        this.years = 3;
        this.staff = new Employee[3];
        staff[0] = new Employee("Alex", "Automation QA", 23, true);
        staff[1] = new Employee("Zenya", "Seaboy", 19, false);
        staff[1] = new Employee();
    }
}
