package com.alexstudy.courses.golovatch.java_core_october_2013.oop.labs.cyclic_ref_hand_cut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by apop on 4/3/2017.
 */
public class CyclicEmployee {
    private int age;
    private String name;
    private CyclicEmployee boss;
    private List<CyclicEmployee> subordinate;

    public CyclicEmployee(int age, String name, CyclicEmployee boss, List<CyclicEmployee> subordinate) {
        this.age = age;
        this.name = name;
        this.boss = boss;
        this.subordinate = subordinate;
    }

    public CyclicEmployee(int age, String name, CyclicEmployee boss, CyclicEmployee... subordinate) {
        this(age, name, boss, Stream.of(subordinate).collect(toList()));
    }

    public CyclicEmployee(int age, String name, CyclicEmployee boss) {
        this(age, name, boss, new ArrayList<>());
    }

    public CyclicEmployee(CyclicEmployee cyclicEmployee) {
        this.age = cyclicEmployee.age;
        this.name = cyclicEmployee.name;
        this.boss = cyclicEmployee.boss;
        this.subordinate = cyclicEmployee.subordinate;
    }

    static CyclicEmployee alex() {
        CyclicEmployee alex = new CyclicEmployee(24, "Alex", new CyclicEmployee(32, "An", null));
        CyclicEmployee gramatik = new CyclicEmployee(24, "Gramatik", new CyclicEmployee(32, "An", null));
        alex.subordinate.add(gramatik);
        gramatik.subordinate.add(alex);
        return alex;
    }

    @Override
    public String toString() {
        List<CyclicEmployee> employees = new ArrayList<>();
        for (CyclicEmployee employee : subordinate) {
            if (employee.subordinate.contains(this)) {
                employee.subordinate.remove(this);
                employee.subordinate.add(new CyclicEmployeeSimple(this));
                employees.add(employee);
            } else {
                employees.add(employee);
            }
        }

        return String.format("Employee[age='%d', name='%s', boss='%s', subordinate='%s']",
                age,
                name,
                boss == null ? "null" : boss.toString(),
                subordinate == null
                        ? "null"
                        : employees.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        CyclicEmployee that = (CyclicEmployee) o;

        if (age != that.age) return false;
        if (!name.equals(that.name)) return false;
        if (!boss.equals(that.boss)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        result = 31 * result + boss.hashCode();
        result = 31 * result + (subordinate != null ? subordinate.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(CyclicEmployee.alex().toString());
    }

    class CyclicEmployeeSimple extends CyclicEmployee {
        private final CyclicEmployee employee;

        CyclicEmployeeSimple(CyclicEmployee employee) {
            super(employee);
            this.employee = employee;
        }

        @Override
        public String toString() {
            return String.format("Employee[age='%d', name='%s', boss='%s']",
                    employee.age, employee.name, employee.boss == null ? "no" : employee.boss.toString());
        }
    }
}
